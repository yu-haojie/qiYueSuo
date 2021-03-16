package web.service.downLoad;

import web.pojo.File;

import java.sql.SQLException;

public interface DownLoadService {
    /**
     * 文件查找
     * @param UUID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    File getFile(String UUID) throws SQLException, ClassNotFoundException;
}
