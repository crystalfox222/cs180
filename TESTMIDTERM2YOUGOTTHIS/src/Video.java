public class Video implements StreamingFile {

    private String fileName;
    private String fileExtension;
    private double fileSize;

    public Video(String fileName){
        this.fileName = fileName;
        fileExtension = "mp4";
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public double getFileSize() {
        return fileSize;
    }

    @Override
    public void printInfo() {
        System.out.println("File Name: "+fileName+"."+fileExtension);
        System.out.println("Size: " + String.format("%.2f MB",getFileSize()));

    }

    @Override
    public void printFileExtension() {
        System.out.println(fileExtension);

    }
}
