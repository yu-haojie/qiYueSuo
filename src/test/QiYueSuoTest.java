package test;

import org.junit.Test;
import web.pojo.File;
import web.service.downLoad.DownLoadService;
import web.service.downLoad.DownLoadServiceImpl;
import web.service.upLoad.UpLoad;
import web.service.upLoad.UpLoadImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//单元测试
public class QiYueSuoTest {
    /**
     * 文件上传
     */
    @Test
    public void Upload(){
        try {
            UpLoad upload = new UpLoadImpl();
            //输入上传文件路径
            String upload1 = upload.upload("E:\\springboot\\as\\代码\\qiYueSuo.zip");
            if(upload!=null){
                System.out.println("文件上传成功，UUID："+upload1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //文件获取
    @Test
    public void downLoad(){
        try {
            DownLoadService downLoadService=new DownLoadServiceImpl();
            //输入UUID
            File file = downLoadService.getFile("c81189ef-c5ac-4bc5-aa2a-e95b31b119d5");
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
