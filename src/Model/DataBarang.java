package Model;
public class DataBarang {
    private String namaBarang;
    private String hargaBarang;
    private String deskripsi;
    private String imgSrc="";
    private boolean ori=true;

        public DataBarang(String namaBarang, String hargaBarang, String deskripsi, String imgSrc) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.deskripsi = deskripsi;
        this.imgSrc = imgSrc;
    }

    public DataBarang() {
    }


    public String getNamaBarang() {
        return namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public boolean isOri() {
        return ori;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setOri(boolean ori) {
        this.ori = ori;
    }
    
    
    

}
