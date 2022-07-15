/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MetodePembayaranController implements Initializable {
    
    
    @FXML
    private ChoiceBox Pengiriman; 
    
    @FXML
    private ChoiceBox Kurir; 
    
    @FXML
    private ChoiceBox Pembayaran; 
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    @FXML
    private void buttonBayar (ActionEvent event) throws IOException{
         Parent statikScene = FXMLLoader.load(getClass().getResource("/View/ATMView.fxml"));
        Scene scene = new Scene(statikScene);
        
        Stage stage = new Stage();
        stage.setTitle("Pembayaran");
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    //MetodePembayaran\\

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Pengiriman\\
        Pengiriman.setValue("Reguler (1-2 hari)");
        Pengiriman.getValue();
        Pengiriman.getItems().addAll("Reguler (1-2 hari)", "Reguler (2-4 hari", "Reguler (5-9 hari)");
        
        //Kurir\\
        Kurir.setValue("JNE");
        Kurir.getValue();
        Kurir.getItems().addAll("JNE", "SiCepat", "AnterAja", "J&T Express");
        
        //Pembayaran\\
        Pembayaran.setValue("ATM");
        Pembayaran.getValue();
        Pembayaran.getItems().addAll("ATM");
        
    }    
    
}
