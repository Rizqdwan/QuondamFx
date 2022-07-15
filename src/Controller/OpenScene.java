package Controller;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OpenScene {

    private Pane view;

    public Pane getPane(String namaFile) {
        try {
            URL fileUrl = Main.class.getResource("/QuondamFX/" + namaFile + ".fxml");

            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }

            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("Tidak ditemukan halaman tersebut");
        }
        return view;
    }
    
     public void pindahHalamanME(MouseEvent event, String tujuan) throws InterruptedException{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        
        try{
            root = FXMLLoader.load(getClass().getResource(tujuan));
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void pindahHalamanAE(ActionEvent event, String tujuan) throws InterruptedException{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        
        try{
            root = FXMLLoader.load(getClass().getResource(tujuan));
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        }
        catch(IOException e){
            System.out.println(e);
        }  
    }
}


    
   
    


