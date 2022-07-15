package Controller;

import Main.Main;
import Main.MyListener;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import Model.DataBarang;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class PenjualViewController implements Initializable {

    OpenScene bukaScene = new OpenScene();
    InputBarangViewController inputBar = new InputBarangViewController();
    XStream xstream = new XStream(new StaxDriver());
    
    ArrayList<DataBarang> dBarang = getDataBarang();
    ArrayList<DataBarang> getDataBarang() {
        FileInputStream berkasMasuk = null;
        try {
            berkasMasuk = new FileInputStream("dataBarang.xml");
            int isi;
            char c;
            // isi file dikembalikan menjadi string
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            // string isi file dikembalikan menjadi larik double
            return (ArrayList<DataBarang>) xstream.fromXML(s);
        } catch (Exception e) {
            System.err.println("test: " + e.getMessage());
        } finally {
            if (berkasMasuk != null) {
                try {
                    berkasMasuk.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
    void openTabel() {
        FileInputStream berkasMasuk;
        try {
            berkasMasuk = new FileInputStream("dataBarang.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != - 1) {
                c = (char) isi;
                s = s + c;
            }
            dBarang = (ArrayList<DataBarang>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    void simpanTable(){
        String xml = xstream.toXML(dBarang);
        FileOutputStream berkasKeluar;

        try {
            byte[] data = xml.getBytes("UTF-8");
            berkasKeluar = new FileOutputStream("dataBarang.xml");
            berkasKeluar.write(data);
            berkasKeluar.close();
        } catch (Exception io) {
            System.out.println("Terjadi kesalahan: " + io.getMessage());
        }
            System.out.println("berhasil menghapus");   
    
    }

    
    int column, row;

    @FXML
    private GridPane grid;
    
    @FXML
    private ScrollPane scroll;

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
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;


    //AnchorPane Menu Penjual\\
    @FXML
    private void buttonRefresh(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PenjualView.fxml"));
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
    private void buttonInputBarang(ActionEvent event) throws IOException {
        Parent readScene = FXMLLoader.load(getClass().getResource("/View/InputBarangView.fxml"));
        Scene scene = new Scene(readScene);

        Stage stage = new Stage();
        stage.setTitle("Data Barang");
        stage.setResizable(false);
        stage.getIcons().add(new Image("Img/Q.png"));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void buttonPengaturan(ActionEvent event) throws IOException {
        Pane pane= FXMLLoader.load(PengaturanViewController.class.getResource("/View/PengaturanView.fxml"));
        borderPane.setCenter(pane);
        System.out.println("Anda membuka pengaturan");
    }

    @FXML
    private void buttonKeluar(ActionEvent event) throws IOException {
        Main p = new Main();
        p.changeScene("/View/QuondamSceneController.fxml");
        System.out.println("Anda Keluar");

    }

    //Barang\\
    
    private ArrayList<DataBarang> Barangs = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    void setPostinganDefault() {
        
        DataBarang Barang; Barang = new DataBarang();
        Barang.setNamaBarang("Iphone 12");
        Barang.setHargaBarang("10.000.000");
        Barang.setImgSrc("/Img/Iphone12.png");
        Barangs.add(Barang);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (!dBarang.isEmpty()) {
            DataBarang Barang;
            for (int i = 0; i < dBarang.size(); i++) {
                Barang = new DataBarang();
                
                Barang.setNamaBarang(dBarang.get(i).getNamaBarang());
                if (dBarang.get(i).getImgSrc().equals("")) {
                    Barang.setOri(true);
                    Barang.setImgSrc("/Img/fitness.jpg");
                } else {
                    Barang.setImgSrc(dBarang.get(i).getImgSrc());
                    Barang.setOri(false);
                }
                Barang.setHargaBarang(dBarang.get(i).getHargaBarang());
                Barangs.add(Barang);
                simpanTable();
            }
        }
         
    setPostinganDefault();   
    
        column = 0;
        row = 1;
        
        try {
            System.out.println("");
            for (int i = 0; i < Barangs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/BrangPostView.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                System.out.println(Barangs.get(i).getImgSrc());
                System.out.println(Barangs.get(i).isOri());
                BrangPostViewController brangPostViewController = fxmlLoader.getController();
                brangPostViewController.setData(Barangs.get(i), myListener);

                if (column == 4) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        tujuan.setValue("Yogyakarta");
        tujuan.getValue();
        tujuan.getItems().addAll("Jakarta", "Bandung", "Surabaya", "Solo", "Semarang", "Malang");
        setPostinganDefault();
        openTabel();
        simpanTable();
    }
}
