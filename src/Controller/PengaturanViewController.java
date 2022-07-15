/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.DataParse;
import Model.Pengguna;
import Main.Main;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rizqdwan
 */
public class PengaturanViewController implements Initializable {
    
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

   
    @FXML
    private Label lNama;
    
    @FXML
    private Label lEmail;
    
    @FXML
    private Label lPass;
    
    @FXML
    private BorderPane anchor;
    
    @FXML
    private Button bthShow;
    
    @FXML
    private Button bthHide;
    
    @FXML
    private Pane hiderPane;

    
    @FXML
    private TableView<Pengguna> tvRegistrasi;
    @FXML
    private TableColumn<Pengguna, String> tcEmail;
    @FXML
    private TableColumn<Pengguna, String> tcNamaLengkap;
    @FXML
    private TableColumn<Pengguna, String> tcPassword;
    
    @FXML
    private void handleButtonImg(ActionEvent event) {
        final FileChooser fc = new FileChooser();
        Stage stage = (Stage) anchor.getScene().getWindow();
        File file= fc.showOpenDialog(stage);
    }
    
    @FXML
    private void bthUbahEmail(ActionEvent event) throws IOException{
        Parent masukScene = FXMLLoader.load(getClass().getResource("/View/UbahEmail.fxml"));
        Scene scene = new Scene(masukScene);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.setTitle("Change Email");
        stage.show();
    }
    
    @FXML
    private void bthUbahNama(ActionEvent event) throws IOException{
        Parent masukScene = FXMLLoader.load(getClass().getResource("/View/UbahNama.fxml"));
        Scene scene = new Scene(masukScene);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.setTitle("Change Name");
        stage.show();
    }
    
    @FXML
    private void bthUbahPass(ActionEvent event) throws IOException{
        Parent masukScene = FXMLLoader.load(getClass().getResource("/View/UbahPass.fxml"));
        Scene scene = new Scene(masukScene);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.setTitle("Change Password");
        stage.show();
    }
    
      @FXML
    private void show(ActionEvent event) {
        hiderPane.setVisible(false);
        bthShow.setVisible(false);
        bthHide.setVisible(true);
    }
    
    @FXML
    private void hide(ActionEvent event) {
        hiderPane.setVisible(true);
        bthShow.setVisible(true);
        bthHide.setVisible(false);
    }
      
    
        ArrayList<Pengguna> pengguna = new ArrayList<>();
        ObservableList dataPengguna = observableArrayList();
        DataRegistrasiController drc = new DataRegistrasiController();
        
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataParse dp = new DataParse();
        openTabel();
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcNamaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tvRegistrasi.setItems(dataPengguna); 
        
        lEmail.setText(pengguna.get(dp.getIndex()).getEmail());
        lNama.setText(pengguna.get(dp.getIndex()).getNama());
        lPass.setText(pengguna.get(dp.getIndex()).getPassword());
    }    
    
}
