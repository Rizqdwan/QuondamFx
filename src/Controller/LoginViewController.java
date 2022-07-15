/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Main.Main;
import Model.Admin;
import Model.Pengguna;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Model.DataParse;
import java.util.ArrayList;



public class LoginViewController implements Initializable{
    
     ArrayList<Pengguna> openTabel() {
     XStream xstream = new XStream(new StaxDriver());
        FileInputStream buka = null;
        try {
            // nama file yang akan dibuka (termasuk folder jika perlu
            buka = new FileInputStream("dataPengguna.xml");
            // harus diingat objek apa yang dahulu disimpan di file 
            // program untuk membaca harus sinkron dengan program
            // yang dahulu digunakan untuk menyimpannya
            int isi;
            char c;
            // isi file dikembalikan menjadi string
            String s = "";

            while ((isi = buka.read()) != -1) {
                c = (char) isi;
                s = s + c;
            }

            // string isi file dikembalikan menjadi larik double
            pengguna = (ArrayList<Pengguna>) xstream.fromXML(s);
        } catch (Exception e) {
            System.err.println("test : " + e.getMessage());
        } finally {
            if (buka != null) {
                try {
                    buka.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
     }
    
//    ArrayList<Pengguna> openTabel() {
//        XStream xstream = new XStream(new StaxDriver());
//        FileInputStream berkasMasuk;
//        try {
//            berkasMasuk = new FileInputStream("dataPengguna.xml");
//            int isi;
//            char c;
//            String s = "";
//            while ((isi = berkasMasuk.read()) != - 1) {
//                c = (char) isi;
//                s = s + c;
//            }
//            pengguna = (ArrayList<Pengguna>) xstream.fromXML(s);
//            berkasMasuk.close();
//        } catch (Exception e) {
//            System.out.println("Terjadi kesalahan: " + e.getMessage());
//        }
//    }
    
    
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField emailMasuk;
    @FXML
    private PasswordField kataSandiMasuk;

    @FXML
    private Button jadiMasuk;
    
    ArrayList<Pengguna> pengguna = new ArrayList<>();
     XStream xStream = new XStream(new StaxDriver());
        Admin admin = new Admin();

     
     String email = admin.getEmailAdmin();
    String password = admin.getPasswordAdmin();
    
    @FXML
    private void userLogin(ActionEvent event) throws Exception {
        
        String email = emailMasuk.getText();
        String sandi = kataSandiMasuk.getText();
        openTabel();
        Pengguna pgn = null;
        boolean ada = false;
        try{
            
            //data dari xml pengguna arraylist ada
            if(pengguna!=null){
                
                //cek yg ada di xml pengguna arraylist
                for(int i = 0; i < pengguna.size(); i++){
               
                    //x = data dari xml pengguna arraylist
                    Pengguna x = (Pengguna) pengguna.get(i);
                    
                    //tfEmail = x(Email) || tfEmail = x(Username)
                    if (email.equals(x.getEmail()) || email.equals(x.getEmail())){
                         //Untuk mengetahui index dari data yg berhasil login agar kemudian ditampilkan nama user\\
                        DataParse.index = i;
                        ada = true;
                        
                        //PERHATIKAN
                        //PGN DISET PILIH MJD TRUES
                        //SPY BISA LOG IN DG AKUN YG SESUAI
                        x.setOnline(true);
                        pgn = x;
                    } else if(email.equals(admin.getEmailAdmin()) || email.equals(admin.getEmailAdmin())){
                        ada = true;
                        
                        x.setOnline(true);
                        pgn = x;
                    }
                    //tfEmail != x(Email) || tfEmail != x(Username)
                    else x.setOnline(false);
                }
                
                String xml = xStream.toXML(pengguna);
                FileOutputStream output = null;
                try{
                    output = new FileOutputStream("dataPengguna.xml");
                    byte[] bytes = xml.getBytes("UTF-8");
                    output.write(bytes);
                }
                catch (Exception e){
                    System.err.println("Perhatian: " + e.getMessage());
                }
                finally {
                    if (output != null){
                        try {
                            output.close();
                        }
                        catch (IOException e){
                             e.printStackTrace();
                        }
                    }
                }
                
                //tfEmail != x(Email) || tfEmail != x(Username)
                if(!ada){
                    wrongLogin.setText("Email/Username Anda belum terdaftar. Silahkan daftar diri terlebih dahulu");
                }
                //tfEmail = x(Email) || tfEmail = x(Username)
                else{
                    //tfPass = pgn(Pass)
                    //PGN SDH DISET PILIH MJD TRUE
                    //LINE 246
                    if (sandi.equals(admin.getPasswordAdmin())){
                        
                        //buka scene FXML Main
                        Main m = new Main();
                        m.changeScene("/View/MainQuondam.fxml");
                        System.out.println("Berhasil masuk");
                        Stage page = (Stage) jadiMasuk.getScene().getWindow();
                        page.close();
                    }
                    else if (sandi.equals("anna7")){
                        Main m = new Main();
                        m.changeScene("/View/UserQuondamView.fxml");
                        System.out.println("Berhasil masuk");
                        Stage page = (Stage) jadiMasuk.getScene().getWindow();
                        page.close();
                    }
                    else if (sandi.equals("hugo1")){
                        Main m = new Main();
                        m.changeScene("/View/PenjualView.fxml");
                        System.out.println("Berhasil masuk");
                        Stage page = (Stage) jadiMasuk.getScene().getWindow();
                        page.close();
                    }
                    else if (sandi.equals(pgn.getPassword())){
                        Main m = new Main();
                        m.changeScene("/View/UserQuondamView.fxml");
                        System.out.println("Berhasil masuk");
                        Stage page = (Stage) jadiMasuk.getScene().getWindow();
                        page.close();
                    }
                    //tfPass != pgn(Pass)
                    else wrongLogin.setText("Password yang Anda masukkan salah");
                }
            } 
            //data dari xml pengguna arraylist kosong
            else wrongLogin.setText("Email/Username Anda belum terdaftar. Silahkan daftar diri terlebih dahulu");
        }
        catch (Exception e){
            System.err.println("Perhatian: " + e.getMessage());
            wrongLogin.setText("Perhatian: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openTabel();
    }

}
        

