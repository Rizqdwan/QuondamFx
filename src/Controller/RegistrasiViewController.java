/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Pengguna;
import Model.PenggunaList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RegistrasiViewController implements Initializable {

    void openTabel() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("dataPengguna.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            pengguna = (ArrayList<Pengguna>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    PenggunaList data;

    ArrayList<Pengguna> pengguna = new ArrayList<>();
//    ArrayList<Pengguna> pgn = new ArrayList<>();

    @FXML
    private TableView<Pengguna> tvRegistrasi;
    @FXML
    private TextField emailDaftar;
    @FXML
    private TextField namaLengkapDaftar;
    @FXML
    private TextField kataSandiDaftar;


    @FXML
    private Button jadiDaftar;

    @FXML
    private void buttonJdDaftar(ActionEvent event) throws IOException {
        data = new PenggunaList();
        String email = emailDaftar.getText();
        String namaLengkap = namaLengkapDaftar.getText();
        String password = kataSandiDaftar.getText();

        openTabel();
//        if (pgn != null) {
//            for (int i = 0; i < pgn.size(); i++) {
//                pengguna.add((Pengguna) pgn.get(i));
//            }
//        }

        pengguna.add(new Pengguna(email, namaLengkap, password));
//        data.setData(email, namaLengkap, password);
//        tvRegistrasi.setItems(data.getData());

        Parent jdDaftarScene = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
        Scene scene = new Scene(jdDaftarScene);
        
        Stage page = (Stage) jadiDaftar.getScene().getWindow();
        page.close();

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        System.out.println("Anda berhasil daftar");

        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(pengguna);
        FileOutputStream berkasKeluar;

        try {
            byte[] data = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("dataPengguna.xml");
            berkasKeluar.write(data);
            berkasKeluar.close();
        } catch (Exception io) {
            System.out.println("Terjadi kesalahan: " + io.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openTabel();
    }

}
