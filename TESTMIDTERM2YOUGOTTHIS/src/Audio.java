public class Audio implements StreamingFile {

    private String fileName;
    private String fileExtension;
    private double fileSize;

    public Audio(String fileName){
        this.fileName = fileName;
        this.fileExtension = "mp3";
    }
    public Audio(){

    }

    public double getFileSize() {
        return fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void printInfo() {
        System.out.println("File Name: " + fileName + "." +fileExtension);
        System.out.println("Size: "+String.format("%.2f MB",getFileSize()));
    }

    @Override
    public void printFileExtension() {
        System.out.println(fileExtension);

    }
}
