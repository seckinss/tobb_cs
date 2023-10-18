
public class ScientificJournal extends Journal{
    public static int articleWords(Article[] articles){
        int total =0;
        for(int i=0;articles.length>i;i++)
            total = total + articles[i].getWordCount();
        return total;
    }
    public ScientificJournal(String name, Article[] articles1) {
        super(name, articles1,articleWords(articles1));
    }
    public ScientificJournal(){}
    
}