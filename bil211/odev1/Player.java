import java.io.Serializable;

public class Player implements Serializable {
	String isim;
	String tasrenk;
	public Player(String isim, String tasrenk) {
		this.isim=isim;
		this.tasrenk=tasrenk;
    }
	
	@Override
	public String toString() {
		return isim;
	}
    float puan; // her taş yedikçe oyuncunun puanı taşın puanına göre artar.

}
