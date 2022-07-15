package Controller;

import Main.Main;
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
import javafx.stage.Stage;


public class ChatViewController implements Initializable {
@FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    
    
    
    @FXML
     private void buttonRefresh(ActionEvent event) throws IOException{
         //addFruit();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UserQuondamView.fxml"));
         root = loader.load();	
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();

        
     }
    
    @FXML
    private void buttonChat (ActionEvent event)throws IOException{
      
        Main chat = new Main();
        chat.changeScene("/View/ChatView.fxml");
      
    }
    
    @FXML
    private void buttonPengaturan (ActionEvent event)throws IOException{
        Main pengaturan = new Main();
        pengaturan.changeScene("/View/PengaturanView.fxml");
    }
    
    @FXML
    private void buttonKeluar(ActionEvent event)throws IOException{
        Main p = new Main();
        p.changeScene("/View/QuondamSceneController.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
