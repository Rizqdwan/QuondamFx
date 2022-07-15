/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Controller.MetodePembayaranController;

/**
 * FXML Controller class
 *
 * @author Rizqdwan
 */
public class Iphone12ViewController implements Initializable {

    @FXML 
    private BorderPane borderPane;
    
    @FXML
    private TextField tfTawar;
    
    @FXML
    private Button bthTawar;
    
    @FXML
    private Button bthBeli;
    
    @FXML
    private Button bthChat;
    
    @FXML
    private Hyperlink hyperLink;
    
        
    @FXML
    void openLink(ActionEvent event)throws URISyntaxException, IOException{
        System.out.println("Link clicked!");
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/6%C2%B009'52.8%22S+106%C2%B052'39.0%22E/@-6.1646611,106.87"
                + "74971,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x81e523ea9ca8efe7!8m2!3d-6.1646611!4d106.8774971"));
    }
        
    @FXML
    private void buttonBeliLangsung(ActionEvent event) throws IOException {
        
        Pane pane= FXMLLoader.load(MetodePembayaranController.class.getResource("/View/MetodePembayaran.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Masuk Pembayaran");
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    
    
    
}
    
