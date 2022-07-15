package Controller;

import Model.DataBarang;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class InputBarangViewController implements Initializable {
        XStream xstream = new XStream(new StaxDriver());
        List<DataBarang> dBarang = new ArrayList<DataBarang>();
        ObservableList dataBarang = observableArrayList();
    
    void openTabel() {
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("dataBarang.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            dBarang = (ArrayList<DataBarang>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    void SimpanTable(){
        String xml = xstream.toXML(dBarang);
        FileOutputStream berkasKeluar;

        try {
            byte[] data = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("dataBarang.xml");
            berkasKeluar.write(data);
            berkasKeluar.close();
        } catch (Exception io) {
            System.err.println("Terjadi kesalahan: " + io.getMessage());
        } 
    }

    @FXML
    private AnchorPane anchor;
    
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn tcNama;
    @FXML
    private TableColumn tcHarga;
    @FXML
    private TableColumn tcDeskripsi;
    
    @FXML
    private Button btnImg;
    
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfHarga;
    @FXML
    private TextArea tfDeskripsi;

@FXML
    private void buttonTambah(ActionEvent event) {
        String nama = tfNama.getText();
        String harga = tfHarga.getText();
        String deskripsi = tfDeskripsi.getText();
        String imgSrc = btnImg.getText();

        DataBarang db = new DataBarang();
        db.setNamaBarang(nama);
        db.setHargaBarang(harga);
        db.setDeskripsi(deskripsi);
        db.setImgSrc(imgSrc);
        db.setOri(false);
        
        dataBarang.add(db);
        dBarang.add(db);
//        dBarang.add(new DataBarang(nama, harga, deskripsi));

        TableView.TableViewSelectionModel selectionModel=tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int dataSize= dataBarang.size();
        selectionModel.select(dataSize-1);


        tfNama.setText("");
        tfHarga.setText("");
        tfDeskripsi.setText("");
        
        SimpanTable();
    }

    @FXML
    private void buttonHapus(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel=tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
        if(i>=0){
            dataBarang.remove(i);
            dBarang.remove(i);
            
             SimpanTable();
    }
    }
    

    @FXML
    private void handleButtonImg(ActionEvent event) {
        final FileChooser fc = new FileChooser();
        Stage stage = (Stage) anchor.getScene().getWindow();
        File file= fc.showOpenDialog(stage);
        if(file!=null){
            System.out.println("Dir: "+file.getAbsolutePath() );
            btnImg.setText(file.toURI().toString());
    }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openTabel();
        for (DataBarang da : dBarang){
            dataBarang.add(da);
        }
        
         tableView.setItems(dataBarang);
        
        tcNama.setCellValueFactory(new PropertyValueFactory<DataBarang,String>("namaBarang"));
        tcHarga.setCellValueFactory(new PropertyValueFactory<DataBarang,String>("hargaBarang"));
        tcDeskripsi.setCellValueFactory(new PropertyValueFactory<DataBarang,String>("deskripsi"));
    }     
}
