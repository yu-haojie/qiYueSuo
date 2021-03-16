package web.service.upLoad;

import java.io.IOException;

public interface UpLoad {
    /**
     * 文件上传
     * @param path
     * @return
     * @throws IOException
     */
    String upload(String path) throws IOException;
}
