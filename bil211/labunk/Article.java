
public class Article extends WritingPiece {
    private String firstAuthor;
    private int citations;
    public int getCitations() {
        return citations;       
    }
    public String getFirstAuthor() {
        return firstAuthor;       
    }
    public void setCitations(int a) {
        citations = a; 
    }
    public void setFirstAuthor(String a) {
        firstAuthor=a;      
    }
    public Article(String string, int i, String string2, int j) {
        super(string,i);
        firstAuthor=string2;
        citations=j;
    }
    public Article(){
        super("",0);
    }
}
