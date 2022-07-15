package Controller;

import Model.DataBarang;
import Model.Pengguna;
import Main.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class BrangPostViewController {

    @FXML
    private ImageView imgBarang;
    @FXML
    private Label namaBarang;
    @FXML
    private Label hargaBarang;
    
    
    

    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(db);
    }
    
    private DataBarang db;
    private MyListener myListener;

    public void setData(DataBarang db, MyListener myListener) {
        this.db = db;
        this.myListener = myListener;
        namaBarang.setText(db.getNamaBarang());
        hargaBarang.setText("Rp. " + db.getHargaBarang());

        if (db.getImgSrc().equals("")) {
        } else {
            Image image;
            if (db.isOri()) {
                image = new Image(getClass().getResourceAsStream(db.getImgSrc()));
            } else {
                image = new Image(db.getImgSrc());
            }
            imgBarang.setImage(image);
        }
    } 
}
