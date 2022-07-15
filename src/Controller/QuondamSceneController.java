/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class QuondamSceneController implements Initializable {
    OpenScene bukaScene = new OpenScene();
    
    
    @FXML
    private BorderPane borderPane;
        //Menu
    @FXML
    private TextField tfCariBarang;
    @FXML
    private Button btCari;
    @FXML
    private Button btMasuk;
    @FXML
    private Button btDaftar;
    
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    //AnchorPane Menu Pengguna\\
    
    @FXML
     private void buttonRefresh(ActionEvent event) throws IOException{
         //addFruit();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/QuondamSceneController.fxml"));
         root = loader.load();	
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
//         System.out.println(dataBaru.size());
        
     }

    @FXML
    private void buttonMasuk(ActionEvent event) throws IOException {
        Parent masukScene = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
        Scene scene = new Scene(masukScene);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
        
        System.out.println("Anda sedang masuk");
    }
    @FXML
    private void buttonDaftar(ActionEvent event) throws IOException {
        Parent daftarScene = FXMLLoader.load(getClass().getResource("/View/RegistrasiView.fxml"));
        Scene scene = new Scene(daftarScene);
        
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.setTitle("Daftar");
        stage.show();
        System.out.println("Anda sedang mendaftar");
    }
    
    //Barang\\
    
     @FXML
    private void bthIphone12(ActionEvent event) throws IOException{
//        OpenScene bukaScene = new OpenScene();
//        Pane halaman = bukaScene.getPane("/Barang/IphoneView");
        Pane pane= FXMLLoader.load(Iphone12ViewController.class.getResource("/View/Iphone12View.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Anda melihat Iphone 12");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        tujuan.setValue("Yogyakarta");
//        tujuan.getValue();
//        tujuan.getItems().addAll("Jakarta", "Bandung","Surabaya", "Solo" , "Semarang", "Malang");
    }    
    
}
