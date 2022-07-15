
package Controller;

import Model.DataParse;
import Model.Pengguna;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UbahEmailController implements Initializable {
ArrayList<Pengguna> pengguna = new ArrayList<>();
    void openTabel() {
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
        }
    }
    void simpanTable(){
         XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(pengguna);
        FileOutputStream berkasKeluar;

        try {
            byte[] data = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("dataPengguna.xml");
            berkasKeluar.write(data);
            berkasKeluar.close();
        } catch (Exception io) {
            System.out.println("Terjadi kesalahan: " + io.getMessage());
        }
            System.out.println("berhasil menghapus");   
    
    }

    @FXML
    private TextField emailLama;
    
    @FXML
    private TextField emailBaru;
    
    @FXML
    private Button change;
    
    @FXML
    private Label warning;
    
    DataParse dp;
    @FXML
    private void bthChange(ActionEvent event){
            String newEmail = emailBaru.getText();
            String oldEmail = emailLama.getText();

            openTabel();
                if(pengguna.get(dp.getIndex()).getEmail().equals(oldEmail)){
                    pengguna.get(dp.getIndex()).setEmail(newEmail);
                    simpanTable();
                    Stage page = (Stage) change.getScene().getWindow();
                    page.close();
                }else{
             warning.setText("Password lama anda tidak valid");
                }
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       dp = new DataParse();
        openTabel();
        simpanTable();
    }    
    
}
