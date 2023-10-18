
public class Journal extends WritingPiece{
    public Journal(String name, Article[] articles1, int k) {
        super(name,k);
        articles=new Article[articles1.length];
        for(int i=0;articles1.length>i;i++){
            this.articles[i]=articles1[i];
        }

    }
    public Journal(){
        super("i",0);
    }
    private Article[] articles;
    private double averageCitations;
    public Article[] getArticles() {
        return articles;
    }
    public double getAverageCitations() {
        return averageCitations;
    }
    public void setAverageCitations() {
        double total=0;
        for(int i=0;articles.length>i;i++){
            total += articles[i].getCitations();
        }
        averageCitations = total/articles.length;
    }
    public void setArticles(Article[] articles) {
        this.articles = articles;
    }
}
