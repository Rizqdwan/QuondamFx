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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class ATMViewController implements Initializable {
    
    @FXML
    private Button bayar;
    
     @FXML
    private void buttonBayarTrf (ActionEvent event) throws IOException{
        Parent statikScene = FXMLLoader.load(getClass().getResource("/View/TerimakasihView.fxml"));
        Scene scene = new Scene(statikScene);
        Stage stage = new Stage();
        stage.setTitle("Pembayaran");
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Stage page = (Stage) bayar.getScene().getWindow();
                        page.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
