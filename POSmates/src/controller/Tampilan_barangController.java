/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Barang;
import model.BarangList;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Tampilan_barangController implements Initializable {

    
    private BarangList barangList;
    
    
    @FXML
    private TableView <Barang> tabel_Barang;
    @FXML
    private TableColumn <Barang, String> kodeBarang;    
    @FXML
    private TableColumn <Barang, String> namaBarang;    
    @FXML
    private TableColumn<Barang,Integer> hargajualBarang;    
    @FXML
    private TableColumn<Barang, Integer> hargabeliBarang;
    @FXML
    private TableColumn<Barang, Integer> banyakBarang;
    
    @FXML
    private TextField namabr;
    @FXML
    private TextField kodebr;
    @FXML
    private TextField hargajualbr;
    @FXML
    private TextField hargabelibr;
    @FXML
    private TextField banyakbr;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        barangList = new BarangList();
        barangList.bacaXMLFile();
        tabel_Barang.setItems(barangList.get());
        
        kodeBarang.setCellValueFactory(cellData -> cellData.getValue().kodeBarangProperty());
        namaBarang.setCellValueFactory(cellData -> cellData.getValue().namaBarangProperty());
        hargajualBarang.setCellValueFactory(cellData -> cellData.getValue().hargajualBarangProperty().asObject());
        hargabeliBarang.setCellValueFactory(cellData -> cellData.getValue().hargabeliBarangProperty().asObject());
        banyakBarang.setCellValueFactory(cellData -> cellData.getValue().banyakBarangProperty().asObject());
        

    }    
    
    public void Bersihkan(){
        namabr.setText("");
        kodebr.setText("");
        hargajualbr.setText("");
        hargabelibr.setText("");
        banyakbr.setText("");
    }
    
    @FXML
    public void btn_tambah() {
        Barang br = new Barang();

        br.setNamaBarang(namabr.getText());
        br.setKodeBarang(kodebr.getText());
        br.setHargajualBarang(Integer.parseInt(hargajualbr.getText()));
        br.setHargabeliBarang(Integer.parseInt(hargabelibr.getText()));
        br.setBanyakBarang(Integer.parseInt(banyakbr.getText()));
       

        tabel_Barang.getItems().add(br);
        barangList.simpanXMLFile();
        Bersihkan();
    }
    
    @FXML
    public void btn_hapus(){
        int pilihan = tabel_Barang.getSelectionModel().getSelectedIndex();

        if(pilihan >= 0) {
            tabel_Barang.getItems().remove(pilihan);
        }

        barangList.simpanXMLFile();
        Bersihkan();
    }

    @FXML
    private void btn_home(ActionEvent event) throws IOException {
        System.out.println("ke home");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void tampilkan_Ubah(MouseEvent event) {
        Barang bar = tabel_Barang.getSelectionModel().getSelectedItem();
        
        namabr.setText(bar.getNamaBarang());
        kodebr.setText(bar.getKodeBarang());
        hargajualbr.setText(bar.getHargajualBarang().toString());
        hargabelibr.setText(bar.getHargabeliBarang().toString());
        banyakbr.setText(bar.getBanyakBarang().toString());
        
    }

    @FXML
    private void btn_ubah(ActionEvent event) {
        
        int pilihan = tabel_Barang.getSelectionModel().getSelectedIndex();
        if(pilihan >= 0) {
            tabel_Barang.getItems().remove(pilihan);
        }
        
        Barang br = new Barang();
        
        br.setNamaBarang(namabr.getText());
        br.setKodeBarang(kodebr.getText());
        br.setHargajualBarang(Integer.parseInt(hargajualbr.getText()));
        br.setHargabeliBarang(Integer.parseInt(hargabelibr.getText()));
        br.setBanyakBarang(Integer.parseInt(banyakbr.getText()));

        tabel_Barang.getItems().add(br);
        barangList.simpanXMLFile();
        
        Bersihkan();
    }

    @FXML
    private void panebarang(MouseEvent event) {
        Bersihkan();
    }


}
