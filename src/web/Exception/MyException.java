package web.Exception;
//自定义异常
public class MyException extends Exception {
    @Override
    public String getMessage() {
        return "410 : 文件下载错误";
    }

    @Override
    public void printStackTrace() {
        System.out.println("410 : 文件下载错误");
    }
}
