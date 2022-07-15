/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.PenggunaList;
import Model.Pengguna;
import Model.DataParse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import Controller.RegistrasiViewController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rizqdwan
 */
public class DataRegistrasiController implements Initializable {

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
    ArrayList<Pengguna> pengguna = new ArrayList<>();

    ObservableList dataPengguna = observableArrayList();

    PenggunaList data;

    @FXML
    private TableView<Pengguna> tvRegistrasi;
    @FXML
    private TableColumn<Pengguna, String> tcEmail;
    @FXML
    private TableColumn<Pengguna, String> tcNamaLengkap;
    @FXML
    private TableColumn<Pengguna, String> tcPassword;
    
    @FXML
    private TextField emailDaftar;
    @FXML
    private TextField namaLengkapDaftar;
    @FXML
    private TextField kataSandiDaftar;

    @FXML
    private Button btDelete;
    @FXML
    private Button btEdit;
    
    @FXML 
    private Button close;
    
    DataParse dp = new DataParse();
    
    @FXML
    private void buttonClose(ActionEvent event){
        Stage page = (Stage) close.getScene().getWindow();
        page.close();
    }
    
    @FXML
    private void buttonEdit(ActionEvent event){
//        tvRegistrasi.setEditable(true);
//        tvRegistrasi.getSelectionModel().cellSelectionEnabledProperty().set(true);
//        TableView.TableViewSelectionModel selectionModel=tvRegistrasi.getSelectionModel();
//        selectionModel.setSelectionMode(SelectionMode.SINGLE);
//        int i=selectionModel.getSelectedIndex();
//        
//        
//        emailDaftar.setText("");
//        namaLengkapDaftar.setText("");
//        kataSandiDaftar.setText("");   

    }

    @FXML
    private void removeBthAction(ActionEvent event) {
//        int selectedID = tvRegistrasi.getSelectionModel().getSelectedIndex();
//        tvRegistrasi.getItems().remove(selectedID);
        
//        int selectedID = tvRegistrasi.getSelectionModel().getSelectedIndex();
//        tvRegistrasi.getItems().remove(selectedID);
//        dataPengguna.get(selectedID);
        
        TableView.TableViewSelectionModel selectionModel=tvRegistrasi.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i=selectionModel.getSelectedIndex();
        if(i>=0){
            dataPengguna.remove(i);
            pengguna.remove(i);
        
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
            System.out.println("berhasil menghapus");   
    }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcNamaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tvRegistrasi.editingCellProperty();
        

        openTabel();
        for (int i = 0; i < pengguna.size(); i++) {
            dataPengguna.add(pengguna.get(i));

        }
        data = new PenggunaList();
        data.setDummy();
        tvRegistrasi.setItems(dataPengguna);
        
        dp.jmlh = tvRegistrasi.getItems().size();
        
    }
    

}
