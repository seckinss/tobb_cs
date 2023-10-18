public abstract class Karakter 
{
    private String Karakter_adi;
    private int yetenek_puani;
    private int ceviklik_puani;
    private int zeka_puani;
    private double bonus;
    private String tanitim_cumlesi;
    public Karakter(String ad, int yetenek, int ceviklik, int zeka) {
        setKarakter_adi(ad);
        setYetenek_puani(yetenek);
        setCeviklik_puani(ceviklik);
        setZeka_puani(zeka);
    }
    /*Kendi get/set metodlarınızı ekleyiniz */
    public abstract double saldir();
    public abstract void setProp();
    
    @Override
    public String toString() {
        
        return "Ben "+ getKarakter_adi() + ", " + getTanitim_cumlesi();
    }


    public double getBonus() {
        return bonus;
    }
    public int getCeviklik_puani() {
        return ceviklik_puani;
    }
    public String getKarakter_adi() {
        return Karakter_adi;
    }
    public String getTanitim_cumlesi() {
        return tanitim_cumlesi;
    }
    public int getYetenek_puani() {
        return yetenek_puani;
    }
    public int getZeka_puani() {
        return zeka_puani;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void setCeviklik_puani(int ceviklik_puani) {
        this.ceviklik_puani = ceviklik_puani;
    }
    public void setKarakter_adi(String karakter_adi) {
        Karakter_adi = karakter_adi;
    }
    public void setTanitim_cumlesi(String tanitim_cumlesi) {
        this.tanitim_cumlesi = tanitim_cumlesi;
    }
    public void setYetenek_puani(int yetenek_puani) {
        this.yetenek_puani = yetenek_puani;
    }
    public void setZeka_puani(int zeka_puani) {
        this.zeka_puani = zeka_puani;
    }
}
