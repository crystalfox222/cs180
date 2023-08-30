public class Song extends Audio {
    private String artist;
    private double songLength;

    public Song(String fileName, String artist, double songLength){
        super(fileName);
        this.artist = artist;
        this.songLength = songLength;
    }

    public String getArtist() {
        return artist;
    }

    public double getSongLength() {
        return songLength;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }

    @Override
    public void printInfo() {
        System.out.println("Song: "+getFileName());
        System.out.println("Artist: "+getArtist());
        System.out.println("Length: "+getSongLength() + " minutes");
        System.out.println("File Name: "+getFileName()+"."+getFileExtension());
        System.out.println("Size: "+String.format("%.2f MB",getFileSize()));
    }
    public double calcFileSize(){
        setFileSize(songLength*3);
        return getFileSize();
    }
}
