package web.servet;

import web.pojo.File;
import web.service.downLoad.DownLoadService;
import web.service.downLoad.DownLoadServiceImpl;
import web.Exception.MyException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    DownLoadService downLOadService= new DownLoadServiceImpl();

    /**
     * 文件下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream os=null;
        InputStream fis=null;
        String result=null;
        String uuid = req.getParameter("UUID");
        try {

            File file = downLOadService.getFile(uuid);
            if(file == null){
                System.out.println("文件不存在!!!");
                throw new MyException();
            }
            try {
                //设置一下文件的类型，以及告诉浏览器要下载。
                String mimeType = getServletContext().getMimeType(file.getFilePath());
                resp.setContentType(mimeType);
                resp.setHeader("Content-Disposition" , "attachment;filename="+file.getFilePath());
                //3. 使用字节流的方式写给浏览器
                os = resp.getOutputStream();
                fis =new FileInputStream(new java.io.File(file.getFilePath()));

                byte [] buffer = new byte[1024];
                int len = 0 ;
                while( (len = fis.read(buffer)) != -1 ){
                    os.write(buffer , 0 , len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                os.close();
                fis.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("result", "410:下载错误");
            getServletContext().getRequestDispatcher("/downResult.jsp").forward(
                    req, resp);
        }
    }
}
