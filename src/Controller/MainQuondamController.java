/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Main.Main;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainQuondamController implements Initializable {
    OpenScene bukaScene = new OpenScene();
    
    
    @FXML
    private Button btCari;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private MenuButton mbProfile;

    @FXML
    private ChoiceBox tujuan;
    
    @FXML
    private TextField tfCariBarang;
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    
    //AnchorPane Menu Admin\\
    
    @FXML
     private void buttonRefresh(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainQuondam.fxml"));
         root = loader.load();	
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();

        
     }
    
    @FXML
    private void buttonRead(ActionEvent event) throws IOException {
        Parent readScene = FXMLLoader.load(getClass().getResource("/View/DataRegistrasi.fxml"));
        Scene scene = new Scene(readScene);
        
        Stage stage = new Stage();
        stage.setTitle("Data");
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void buttonStatistika (ActionEvent event) throws IOException{
         Parent statikScene = FXMLLoader.load(getClass().getResource("/View/DataStatistika.fxml"));
        Scene scene0 = new Scene(statikScene);
        
        Stage stage0 = new Stage();
        stage0.setTitle("Statistika");
        stage0.getIcons().add(new Image("Img/Q.png"));
        stage0.setResizable(false);
        stage0.setScene(scene0);
        stage0.show();
    }

    @FXML
    private void buttonPengaturan (ActionEvent event)throws IOException{
        Pane pane= FXMLLoader.load(PengaturanViewController.class.getResource("/View/PengaturanView.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Anda membuka pengaturan");
    }
    
    @FXML
    private void buttonKeluar(ActionEvent event)throws IOException{
        Main p = new Main();
        p.changeScene("/View/QuondamSceneController.fxml");
        System.out.println("Anda Keluar");
    }
    
    //Barang\\
    
    @FXML
    private void bthIphone12(ActionEvent event) throws IOException{
//        Pane halaman = bukaScene.getPane("IphoneView");
        Pane pane= FXMLLoader.load(Iphone12ViewController.class.getResource("/View/Iphone12View.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Anda melihat Iphone 12");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tujuan.setValue("Yogyakarta");
        tujuan.getValue();
        tujuan.getItems().addAll("Yogyakarta", "Jakarta", "Bandung","Surabaya", "Solo" , "Semarang", "Malang");
    }      


}

