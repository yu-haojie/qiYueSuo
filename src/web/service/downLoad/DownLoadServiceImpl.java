package web.service.downLoad;

import web.dao.downLoad.DownLoadImpl;
import web.dao.downLoad.DownloadDao;
import web.pojo.File;

import java.sql.SQLException;

public class DownLoadServiceImpl implements DownLoadService {
    DownloadDao downloadDao= new DownLoadImpl();

    /**
     * 文件查找
     * @param UUID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public File getFile(String UUID) throws SQLException, ClassNotFoundException {
        File file = downloadDao.getFile(UUID);
        return file;
    }
}
