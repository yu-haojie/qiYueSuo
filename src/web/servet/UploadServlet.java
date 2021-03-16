package web.servet;

import web.service.upLoad.UpLoad;
import web.service.upLoad.UpLoadImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        UpLoad upload = new UpLoadImpl();
        //解决参数乱码
        request.setCharacterEncoding("UTF-8");
        String uploadFile = request.getParameter("uploadFile");
        String result = upload.upload(uploadFile);
        //使用request作用域赋值
        request.setAttribute("message", result);

        getServletContext().getRequestDispatcher("/message.jsp").forward(
                    request, response);

    }

}
