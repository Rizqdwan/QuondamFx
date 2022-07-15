package Model;

public class Pengguna {

    private String email;
    private String nama;
    private String password;
    private boolean online;
    
    public Pengguna(String email, String nama, String password) {
        this.email = email;
        this.nama = nama;
        this.password = password;

    }
    
        public Pengguna(String email, String nama, String password, boolean online) {
        this.email = email;
        this.nama = nama;
        this.password = password;
        this.online = online;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
      
    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean Online) {
        this.online = Online;
    }

}
