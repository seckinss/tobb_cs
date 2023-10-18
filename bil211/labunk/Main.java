public class Main {
  
    public static void main(String[] args) {
      Book b1 = new Book("Alice's Adventures in Wonderland", 26432, 12, "Lewis Carroll","Fantasy");
      Book b2 = new Book("A Christmas Carol", 31650, 5, "Charles Dickens","Ghost Story");
      Book b3 = new Book("The Wonderful Wizard of Oz",42636,24,"L. Frank Baum","Fantasy");
      Book b4 = new Book("The Time Machine",35530, 16,"H. G. Wells","Fantasy");
      Book b5 = new Book("A Short History of Nearly Everything",140000,36,"Bill Bryson","Non-Fiction");
  
      Article a1 = new Article("Stochastic Modelling of Proof-of-Work Protocols", 4125 , "John Doe", 12);
      Article a2 = new Article("Secure Integrated Mobility Network", 3502 , "Alice Smith", 7);
      Article a3 = new Article("An interactive proxy database derived from a parameterized secure agent", 3998 , "Bob Smith", 19);
      Article a4 = new Article("A virtual binary cache related to an open proxy toolkit", 4603 , "Bob Smith", 25);
      Article[] articles1 = {a1,a2,a3,a4};
      ScientificJournal sciJournal = new ScientificJournal("Journal of Cybersecurity and Privacy",articles1);
  
      Article a5 = new Article("An interactive bioinformatic algorithm related to a scalable parallelizing agent" ,2905, "Alice Smith", 39);
      Article a6 = new Article("A balanced big data network related to an active programmable protocol" ,3300, "John Smith", 34);
      Article[] articles2 = {a5,a6};
      OpenAccessJournal oaJournal = new OpenAccessJournal("Software Impacts",articles2);
  
      WritingPiece[] archiveList = {b1,b2,b3,b4,b5,sciJournal,oaJournal};
      Archive archive = new Archive(archiveList);
  
      System.out.println("Total Word Count: " + archive.getTotalNumberOfWords());
      System.out.println("Total Estimated Reading Time: " + archive.getTotalEstimatedReadingTime());
      System.out.println("Number of Books in Genre \"Fantasy\": " +  + archive.getNumberOfBooksInGenre("Fantasy"));
      System.out.println("Number of Books in Genre \"Non-Fiction\": " +  + archive.getNumberOfBooksInGenre("Non-Fiction"));
      System.out.println("Citation Stats (Journals):");
      System.out.println("----Over 10.0----");
      archive.printJournalsOverCitation(10.0);
      System.out.println("----Over 30.0----");
      archive.printJournalsOverCitation(30.0);
      System.out.println("Citation Stats (Articles):");
      System.out.println("----Over 15.0----");
      archive.printArticlesOverCitation(15.0);
      System.out.println("----Over 30.0----");
      archive.printArticlesOverCitation(30.0);
    }
  }