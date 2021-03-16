package web.servet;

import web.pojo.File;
import web.service.downLoad.DownLoadService;
import web.service.downLoad.DownLoadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/selectServlet")
public class SelectServlet extends HttpServlet {
    //引入DownLoadServiceImpl对象
    DownLoadService downLOadService= new DownLoadServiceImpl();

    /**
     * 文件查找
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("UUID");
        try {
            File file = downLOadService.getFile(uuid);
            req.setAttribute("message",file);
            //请求转发
            getServletContext().getRequestDispatcher("/Select.jsp").forward(
                    req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
