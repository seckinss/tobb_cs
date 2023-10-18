public class Archive {
    public Archive(WritingPiece[] archive){
        this.archive=new WritingPiece[archive.length];
        for(int i=0;archive.length>i;i++){
            this.archive[i]=archive[i];
        }
        
    }
    public WritingPiece[] archive;

    public int getTotalNumberOfWords(){
        int total = 0;
        for(int i=0;archive.length>i;i++)
            total= total + archive[i].getWordCount(); 
        return total;

   }
    public String getTotalEstimatedReadingTime(){
        int hours=0;
        int minutes=0;
        for(int k=0;archive.length>k;k++)
            minutes= minutes + archive[k].getEstimatedReadingTime();
        for(int i = minutes;i>=60;i-=60){
            hours++;
            minutes-=60;
        }
        return hours + "hours and " + minutes + " minutes ";
        
    }
    public int getNumberOfBooksInGenre(String targetGenre){
        int count=0;
        for(int i=0;archive.length>i;i++){
            if (archive[i].getReadingTimeMultiplier()== 1.2)
                if(((Book) archive[i]).getGenre().equals(targetGenre))
                    count++;
        }
        
        return count;
    }
    public int getTotalNumberOfArticles(){
        int count=0;
        for(int i=0;archive.length>i;i++){
            if (archive[i].getReadingTimeMultiplier()== 1.5)
                    count++;
        }
        return count;
    }
    public void printJournalsOverCitation(double targetAvGCitations){
        for(int i=0;archive.length>i;i++){
            if(archive[i] instanceof Journal){
                System.out.println(archive[i].getClass().getSuperclass().getSuperclass().getName());
                if(((Journal) archive[i]).getAverageCitations()>=targetAvGCitations)
                    System.out.print(((Journal)archive[i]).getName()+" ");
            }
        }
    }
    public void printArticlesOverCitation(double targetCitations){
        Article a = new Article();
        for(int i=0;archive.length>i;i++){
            System.out.println(archive[i].getClass());
            if(archive[i].getClass()==a.getClass()){
                System.out.println(archive[i].getName());
                if(((Article) archive[i]).getCitations()>=targetCitations)
                    System.out.println((archive[i]).getName());
            }
        }
    }
}
