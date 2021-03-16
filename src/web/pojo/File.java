package web.pojo;


public class File {
    private String UUID;//文件UUID
    private Long fileCount;//文件大小
    private String fileType;//文件类型
    private String oldName;//原始文件名
    private String buileTime;//创建时间
    private String filePath;//文件保存目录

    public Long getFileCount() {
        return fileCount;
    }

    public void setFileCount(Long fileCount) {
        this.fileCount = fileCount;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }



    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getBuileTime() {
        return buileTime;
    }

    public void setBuileTime(String buileTime) {
        this.buileTime = buileTime;
    }

    public File(String UUID, Long fileCount, String fileType, String oldName, String buileTime, String filePath) {
        this.UUID = UUID;
        this.fileCount = fileCount;
        this.fileType = fileType;
        this.oldName = oldName;
        this.buileTime = buileTime;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "UUID=" + UUID +
                ", fileCount=" + fileCount +
                ", fileType='" + fileType + '\'' +
                ", oldName='" + oldName + '\'' +
                ", buileTime='" + buileTime + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}


