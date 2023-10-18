

public class Book extends WritingPiece {
    public Book(String string, int i, int j, String string2, String string3) {
        super(string,i);
        numberOfChapters=j;
        author=string2;
        genre=string3;
    }
    private int numberOfChapters;
    private String author;
    private String genre;
    
    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public int getNumberOfChapters() {
        return numberOfChapters;
    }
}