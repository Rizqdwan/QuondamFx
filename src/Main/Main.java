package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class Main extends Application {
    //Akun SetScene Pembeli
    //email : anna@gmail.com\\
    //password : anna7 \\
    
    //Akun SetScene Penjual
    //email : hugo@gmail.com\\
    //password : hugo1 \\
    
    //Akun SetScene Admin
    //email : admin@gmail.org\\
    //password : 12345 \\

    private static Stage stg;
    
    @Override
    public void start(Stage Mainstage) throws Exception {
        stg = Mainstage;
        Mainstage.setResizable(false);
//        Parent root = FXMLLoader.load(getClass().getResource("QuondamSceneController.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/View/IntroPage.fxml"));

        Scene scene = new Scene(root);
        Mainstage.getIcons().add(new Image("Img/Q.png"));
        Mainstage.setScene(scene);
        Mainstage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
