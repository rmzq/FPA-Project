/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Barang;
import model.BarangList;
import model.Transaksi;
import model.TransaksiList;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Tampilan_transaksiController implements Initializable {
    private BarangList barangList;
    private TransaksiList transaksiList;
    
    
    @FXML
    private TableView <Barang> tabel_Barang;
    
    @FXML
    private TableColumn <Barang, String> kodeBarang;
    
    @FXML
    private TableColumn <Barang, String> namaBarang;
    
    @FXML
    private TableColumn<Barang,Integer> harga;
    @FXML
    private JFXTextField banyakbelibr;
    @FXML
    private TableView<Transaksi> tabelbrbeli;
    @FXML
    private TableColumn<Transaksi, String> kodebrbeli;
    @FXML
    private TableColumn<Transaksi, String> namabrbeli;
    @FXML
    private JFXTextField banyakbayar;
    @FXML
    private TableColumn<Transaksi, Integer> subtotalbrbeli;
    @FXML
    private TableColumn<Transaksi, Integer> banyakbrbeli;
    @FXML
    private Label tampiltotal;
    @FXML
    private JFXDatePicker wkttransaksi;
    @FXML
    private Label tampilbayar;
    @FXML
    private Label tampilkembalian;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transaksiList = new TransaksiList();
        barangList = new BarangList();
        barangList.bacaXMLFile();
        tabel_Barang.setItems(barangList.get());
        
        kodeBarang.setCellValueFactory(cellData -> cellData.getValue().kodeBarangProperty());
        kodeBarang.setCellValueFactory(cellData -> cellData.getValue().kodeBarangProperty());
        namaBarang.setCellValueFactory(cellData -> cellData.getValue().namaBarangProperty());
        harga.setCellValueFactory(cellData -> cellData.getValue().hargajualBarangProperty().asObject());
        
        kodebrbeli.setCellValueFactory(cellData -> cellData.getValue().kodeBarangBeliProperty());
        namabrbeli.setCellValueFactory(cellData -> cellData.getValue().namaBarangBeliProperty());
        banyakbrbeli.setCellValueFactory(cellData -> cellData.getValue().banyakBarangBeliProperty().asObject());
        subtotalbrbeli.setCellValueFactory(cellData -> cellData.getValue().subtotalBarangBeliProperty().asObject());
        
        tampiltotal.setText("0");
        tampilbayar.setText("0");
        tampilkembalian.setText("0");
        banyakbayar.setText("0");
        
        
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
    private void btn_tambahbarang(ActionEvent event) {
        Transaksi tr = new Transaksi();
        
        Barang bar = tabel_Barang.getSelectionModel().getSelectedItem();
        
        tr.setKodeBarangBeli(bar.getKodeBarang());
        tr.setNamaBarangBeli(bar.getNamaBarang());
        tr.setBanyakBarangBeli(Integer.parseInt(banyakbelibr.getText()));
        tr.setSubtotalBarangBeli(bar.getHargajualBarang()*Integer.parseInt(banyakbelibr.getText()));
        
        System.out.println(wkttransaksi.getValue());
        System.out.println(tr.getKodeBarangBeli());
        
        bar.setBanyakBarang(bar.getBanyakBarang()-Integer.parseInt(banyakbelibr.getText()));
        tabelbrbeli.getItems().add(tr);
        
        System.out.println();
        
        Integer totalt = tr.getSubtotalBarangBeli()+Integer.parseInt(tampiltotal.getText());
        tampiltotal.setText(Integer.toString(totalt));
        
        
    }

    @FXML
    private void btn_hapusbarang(ActionEvent event) {
        Barang bar = tabel_Barang.getSelectionModel().getSelectedItem();
        
        int pilihan = tabelbrbeli.getSelectionModel().getSelectedIndex();
        
        bar.setBanyakBarang(bar.getBanyakBarang()+banyakbrbeli.getCellData(pilihan));
        
        
        Integer totalt = Integer.parseInt(tampiltotal.getText())-subtotalbrbeli.getCellData(pilihan);
        tampiltotal.setText(Integer.toString(totalt));
        
        if(pilihan >= 0) {
            tabelbrbeli.getItems().remove(pilihan);
            
        }
    }


    @FXML
    private void btn_bayar(ActionEvent event) {
        //tr.setTanggalBarangbeli(wkttransaksi.getValue());
        
        int bayar = Integer.parseInt(banyakbayar.getText());
        int kembalian = bayar - Integer.parseInt(tampiltotal.getText());
        
        
        barangList.simpanXMLFile();
        
        tampilkembalian.setText(Integer.toString(kembalian));
        tampilbayar.setText(banyakbayar.getText());
        
        
        
    }
}
