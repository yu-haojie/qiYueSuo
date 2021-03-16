package web.dao.downLoad;

import web.pojo.File;

import java.sql.SQLException;

public interface DownloadDao {
    /**
     * 根据UUID获取文件
     * @param UUID
     * @return
     */
    File getFile(String UUID) throws SQLException, ClassNotFoundException;
}
