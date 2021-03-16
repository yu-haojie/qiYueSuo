package web.service.upLoad;

import web.dao.upload.UploadDao;
import web.dao.upload.UploadDaoImpl;
import web.pojo.File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UpLoadImpl implements UpLoad {

    UploadDao uploadDao = new UploadDaoImpl();

    /**
     * 文件上传
     * @param uploadFile
     * @return
     * @throws IOException
     */
    @Override
    public String upload(String uploadFile) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            //字符串截取文件类型
            int i = uploadFile.lastIndexOf('.');
            String end = uploadFile.substring(i);
            //创建输入流
            java.io.File upfile = new java.io.File(uploadFile);
            in = new FileInputStream(uploadFile);
            //获取UUID
            UUID uuid = UUID.randomUUID();
            Date date = new Date(); //获取当前的系统时间。
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); //使用了默认的格式创建了一个日期格式化对象。
            String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
            java.io.File f2 = new java.io.File("D:\\\\" + time);//存储到D盘
            //4.创建文件夹
            boolean b1 = f2.mkdir();
            String path = "D:\\\\" + time + "\\\\" + uuid + end;
            //创建输出流
            out = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            // 3.3 读写数据
            byte[] b = new byte[1024 * 8];
            int len;
            while ((len = in.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            File file = new File(uuid.toString(), upfile.length(), end, upfile.getName(), new Date().toString(), path);
            String uuid1 = uploadDao.upload(file);
            if (uuid1 != null)
                return "文件上传成功,文件保存成功,UUID:"+uuid1;
            else return "文件上传成功,文件保存失败";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败!";
        } finally {
            in.close();
            out.close();
        }
    }
}