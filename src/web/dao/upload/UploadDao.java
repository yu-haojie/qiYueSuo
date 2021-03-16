package web.dao.upload;

import web.pojo.File;

import java.sql.SQLException;

public interface UploadDao {
    /**
     * 上传文件
     * @param file
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    String upload(File file) throws ClassNotFoundException, SQLException;
}
