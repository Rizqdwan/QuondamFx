package Controller;

import Model.PenggunaList;
import Model.DataParse;
import Model.Pengguna;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Model.ArrayList;

public class DataStatistikaController implements Initializable {
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    XYChart.Series dataUser = new XYChart.Series<>();

    DataParse dp = new DataParse();
   
    ArrayList<Pengguna> pengguna = new ArrayList<>();

    ObservableList dataPengguna = observableArrayList();
    
    PenggunaList datapl;
    
    @FXML
    private PieChart pcData;
    
    @FXML
    private LineChart userData;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    
    @FXML
    private TableView tvRegistrasi;
    @FXML
    private TableColumn tcEmail;
    @FXML
    private TableColumn tcNamaLengkap;
    @FXML
    private TableColumn tcPassword;
      
    @FXML
    private Button btHapus;
    @FXML
    private Button btTambah;
    
    int jml = 0;
    
    @FXML
    private void buttonHapus (ActionEvent event)throws IOException{
       
    }
    @FXML
    private void buttonTambah (ActionEvent event)throws IOException{
       
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data.add(new PieChart.Data("Elektronik & Gadget", 50));
        data.add(new PieChart.Data("Hobi & Olahraga", 30));
        data.add(new PieChart.Data("Perlengkapan Bayi", 10));
        data.add(new PieChart.Data("Kantor & Industri", 20));
        data.add(new PieChart.Data("Rumah Tangga", 30));
        
        pcData.setData(data);
        
        //Jumlah pengguna TableView\\
        System.out.println(dp.getDatajml());
        dataUser.getData().add(new XYChart.Data("2022", dp.getDatajml()));
        dataUser.setName("Jumlah User");
        
        userData.getData().addAll(dataUser);
    }    
    
}
