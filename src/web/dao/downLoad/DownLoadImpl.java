package web.dao.downLoad;

import web.pojo.File;
import web.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DownLoadImpl implements DownloadDao {
    /**
     * 根据UUID获取文件
     *
     * @param UUID
     * @return
     */
    @Override
    public File getFile(String UUID) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();

        //执行sql语句
        String sql="select * from file where UUID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,UUID);
        ResultSet resultSet = preparedStatement.executeQuery();
        File file=null;
        //封装对象
        while (resultSet.next()){
            file  = new File(
                    resultSet.getString("UUID"),
                    resultSet.getLong("fileCount"),
                    resultSet.getString("fileType"),
                    resultSet.getString("oldName"),
                    resultSet.getString("buildTime"),
                    resultSet.getString("filePath")
            );
        }
        return file;
    }
}
