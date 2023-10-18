public class WritingPiece {
    private String name;
    private int wordCount;
    private int estimatedReadingTime;
    private double readingTimeMultiplier;
    public WritingPiece(String name, int wordCount){
        this.name = name;
        this.wordCount = wordCount;
        readingTimeMultiplier = 1.0;
        estimatedReadingTime =(int) Math.ceil(wordCount / 200 * readingTimeMultiplier);
    }
    public int getEstimatedReadingTime() {
        return estimatedReadingTime;
    }
    public String getName() {
        return name;
    }
    public double getReadingTimeMultiplier() {
        return readingTimeMultiplier;
    }
    public int getWordCount() {
        return wordCount;
    }
    public void setEstimatedReadingTime(int estimatedReadingTime) {
        this.estimatedReadingTime = estimatedReadingTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setReadingTimeMultiplier(double readingTimeMultiplier) {
        this.readingTimeMultiplier = readingTimeMultiplier;
    }
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}