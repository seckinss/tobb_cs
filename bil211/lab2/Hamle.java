public class Hamle {
    private String KarakterTipi;
    private int HamleGucu;
    private Silah s = null;
    private Karakter chr = null;
    public Hamle(String tip, int hamle) {
        this.KarakterTipi=tip;
        this.HamleGucu=hamle;
    }
    public void KarakterYarat(String ad,int yetenek,int ceviklik,int zeka){
        if(getChr()!=null){
            System.out.println("Uyari: Hamleye bir karakter atanmiştir, yeni bir karakter atayamazsiniz !");
            return;
        }
        Karakter k=new Karakter(ad, yetenek, ceviklik, zeka) {
            @Override
            public double saldir() {
                System.out.println(super.toString());
                if(s==null){
                    System.out.println("Hiç silah kullanmadan seni yenebilirim");
                    return (double)((((getCeviklik_puani()+getZeka_puani())*getBonus()) + getYetenek_puani())*getHamleGucu());
                }
                System.out.println("Ben "+s.bilgi()+ " kullaniyorum");
                return (double)((((getCeviklik_puani()+getZeka_puani())*getBonus()) + getYetenek_puani())*getHamleGucu()) + s.hasar();
            }

            @Override
            public void setProp() {
                if(getKarakterTipi().equals("villain")){
                    setBonus(3);
                    setTanitim_cumlesi("Seni ne pahasina olursa olsun yenecegim");
                }
                if(getKarakterTipi().equals("hero")){
                    setBonus(1.5);
                    setTanitim_cumlesi("Beni hafife alma");
                }
            }
        };
        chr = k;
    }
    public void SilahSec(String silahTipi, String SilahAdı){
        class InnerSilah implements Silah{
            private String silahTipi;
            private String silahAdı;
            public InnerSilah(String silahTipi,String SilahAdı){
                this.silahAdı=SilahAdı;
                this.silahTipi=silahTipi;
            }
            @Override
            public double hasar() {
                if(silahTipi.equals("Atak")){
                    return getHamleGucu()*3;
                }
                if(silahTipi.equals("Savunma")){
                    return getHamleGucu()*1.5;
                }
                return getHamleGucu();
            }
            @Override
            public String bilgi() {
                if(silahTipi.equals("Atak")){
                    return "atak silahi, "+ silahAdı;
                }
                if(silahTipi.equals("Savunma")){
                    return "savunma silahi, "+ silahAdı;
                }
                return "This is not expected as output";
            }       
        }
        InnerSilah s2 = new InnerSilah(silahTipi, SilahAdı);
        s=s2;
    }
    public void yarisma(Hamle H2){
        H2.chr.setProp();
        this.chr.setProp();
        double thisPower=this.chr.saldir();
        double h2Power=H2.chr.saldir();
        if(h2Power>thisPower){
            System.out.println("Kazanan "+H2.chr.getKarakter_adi());
        }
        if(thisPower>h2Power){
            System.out.println("Kazanan "+this.chr.getKarakter_adi());
        }
        if(thisPower==h2Power){
            System.out.println("Winner is Tie !!");
        }
    }
    public Karakter getChr() {
        return chr;
    }
    public int getHamleGucu() {
        return HamleGucu;
    }
    public String getKarakterTipi() {
        return KarakterTipi;
    }
    public Silah getS() {
        return s;
    }
    public void setChr(Karakter chr) {
        this.chr = chr;
    }
    public void setHamleGucu(int hamleGucu) {
        HamleGucu = hamleGucu;
    }
    public void setKarakterTipi(String karakterTipi) {
        KarakterTipi = karakterTipi;
    }
    public void setS(Silah s) {
        this.s = s;
    }
}
