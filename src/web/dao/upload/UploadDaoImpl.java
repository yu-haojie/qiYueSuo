package web.dao.upload;

import web.pojo.File;
import web.util.ConnectionUtil;


import java.sql.*;

public class UploadDaoImpl implements UploadDao {
    /**
     * 上传文件
     * @param file
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public String upload(File file) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionUtil.getConnection();//获取连接
        //3.创建执行sql语句对象
        //b.创建预编译的SQL语句对象(SQL参数需要使用?占位)
        String sql = "insert into file values (null ,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//c.设置参数, 执行(还是executeQuery()和executeQUpdate(), 但是不需要再传入SQL语句, 上面已经传入了)
        preparedStatement.setString(1,file.getUUID());
        preparedStatement.setLong(2,file.getFileCount());
        preparedStatement.setString(3,file.getFileType());
        preparedStatement.setString(4,file.getOldName());
        preparedStatement.setString(5, file.getBuileTime());
        preparedStatement.setString(6,file.getFilePath());
        preparedStatement.executeUpdate();
        //5.释放资源
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return file.getUUID();
    }
}
