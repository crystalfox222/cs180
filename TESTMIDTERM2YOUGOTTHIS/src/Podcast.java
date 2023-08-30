public class Podcast extends Audio {
    private String podcastShow;
    private String producer;
    private double podcastLength;

    public Podcast(String fileName, String podcastShow, String producer, double podcastLength){
        super(fileName);
        this.podcastShow = podcastShow;
        this.producer = producer;
        this.podcastLength = podcastLength;
    }

    public double getPodcastLength() {
        return podcastLength;
    }

    public String getPodcastShow() {
        return podcastShow;
    }

    public String getProducer() {
        return producer;
    }

    public void setPodcastLength(double podcastLength) {
        this.podcastLength = podcastLength;
    }

    public void setPodcastShow(String podcastShow) {
        this.podcastShow = podcastShow;
    }

    @Override
    public void printInfo() {
        System.out.println("Podcast Episode: "+ getFileName());
        System.out.println("Podcast Show: " + podcastShow);
        System.out.println("Producer: "+producer);
        System.out.println("Length: " + getPodcastLength()+" minutes");
        System.out.println("File Name: " + getFileName()+"."+getFileExtension());
        System.out.println("Size: "+String.format("%.2f MB",getFileSize()));
    }
    public double calcFileSize(){
        setFileSize(podcastLength*3);
        return getFileSize();
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
