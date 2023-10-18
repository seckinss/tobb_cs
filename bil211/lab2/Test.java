public class Test {

    public static void main(String[] args) {

        Hamle h1 = new Hamle("villain",200); //ilk hamle oluşturuldu
        h1.SilahSec("Atak", "kalem"); //hamle için bir silah seçildi
        h1.KarakterYarat("John Wick", 10, 8, 8); // hamle için bir karakter oluşturuldu

        Hamle h2 = new Hamle("hero",300);//ikinci hamle olusturuldu
        h2.KarakterYarat("Neo", 10, 10, 5);// Sadece karakter oluşturuldu
        
        h1.yarisma(h2);// yarış başladı

        h2.KarakterYarat("Neo2", 10, 10, 10);
        System.out.println("..................................................");

        Hamle h3 = new Hamle("villain",100);
        h3.SilahSec("Atak", "Kilic");
        h3.KarakterYarat("Davy Jones", 10, 6, 8);

        Hamle h4 = new Hamle("hero",5);
        h4.SilahSec("Savunma", "Halat");
        h4.KarakterYarat("Jack Sparrow", 10, 10, 6);
        h3.yarisma(h4);
        

    }
}