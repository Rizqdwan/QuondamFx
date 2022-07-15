/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
      import javafx.collections.FXCollections;
      import javafx.collections.ObservableList;
public class PenggunaList {
    private ObservableList<Pengguna> listUser;
    
    public PenggunaList(){
        listUser = FXCollections.observableArrayList();
    }
    
    public ObservableList<Pengguna> getData(){
        return this.listUser;
    }
    
    public void setData(String email, String nama, String sandi){
        listUser.add(new Pengguna(email, nama, sandi));
    }
    
    public void setDummy(){
        listUser.add(new Pengguna("admin@gmail.com", "admin", "12345"));
    }
}
