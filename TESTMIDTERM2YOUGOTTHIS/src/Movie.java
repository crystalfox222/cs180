public class Movie extends Video{
    private String director;
    private double movieLength;

    public Movie(String fileName, String director, double movieLength) {
        super(fileName);
        this.director = director;
        this.movieLength = movieLength;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }

    public double getMovieLength() {
        return movieLength;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void printInfo() {
        System.out.println("Movie Title: "+getFileName());
        System.out.println("Director: "+getDirector());
        System.out.println("Length: " + movieLength+ " hours");
        System.out.println("File Name: "+getFileName() +"."+getFileExtension());
        System.out.println("Size: "+String.format("%.2f MB",getFileSize()));
    }
    public double calcFileSize(){
        setFileSize(movieLength*1200);
        return getFileSize();

    }
}
