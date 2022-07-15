package Controller;

import Main.Main;
import Model.DataParse;
import Model.Pengguna;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserQuondamViewController implements Initializable {
    
    OpenScene bukaScene = new OpenScene();
    
        @FXML
        private AnchorPane userQ;
        
        @FXML
        private BorderPane borderPane;

        @FXML
        private Button btCari;

        @FXML
        private MenuButton mbProfile;
        
        @FXML
        private ChoiceBox tujuan;

        @FXML
        private Parent root;
        @FXML
        private Scene scene;
        @FXML
        private Stage stage;
        
        
        //AnchorPane Menu User\\

        @FXML
        private void buttonUserRefresh (ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UserQuondamView.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }
        @FXML
        private void buttonUserChat (ActionEvent event)throws IOException
        {
        Pane pane= FXMLLoader.load(PengaturanViewController.class.getResource("/View/ChatView.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Anda membuka Chat");
        }

        @FXML
        private void buttonUserPengaturan (ActionEvent event)throws IOException{
            Pane pane= FXMLLoader.load(PengaturanViewController.class.getResource("/View/PengaturanView.fxml"));
            borderPane.setCenter(pane);
            System.out.println("Anda membuka pengaturan");
        }

        @FXML
        private void buttonKeluar (ActionEvent event)throws IOException {
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
    
              
//            QuondamFX ip12 = new QuondamFX();
//            ip12.changeScene("/Barang/IphoneView.fxml");
//            System.out.println("Membuka Iphone 12");
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        tujuan.setValue("Yogyakarta");
        tujuan.getValue();
        tujuan.getItems().addAll("Yogyakarta", "Jakarta", "Bandung","Surabaya", "Solo" , "Semarang", "Malang");
    }

}
