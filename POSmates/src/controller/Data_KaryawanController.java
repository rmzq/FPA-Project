/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataKaryawan;
import model.DataKaryawanList;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Data_KaryawanController implements Initializable {
    
    private DataKaryawanList dataKaryawanList;

    @FXML
    private TableColumn<DataKaryawan, String> usernamekar;
    @FXML
    private TableColumn<DataKaryawan, String> namakar;
    @FXML
    private TableColumn<DataKaryawan, String> passkar;
    @FXML
    private TableView<DataKaryawan> tabeldatakar;
    @FXML
    private JFXTextField un;
    @FXML
    private JFXTextField nm;
    @FXML
    private JFXTextField ps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataKaryawanList = new DataKaryawanList();
        dataKaryawanList.bacaXMLFile();
        
        tabeldatakar.setItems(dataKaryawanList.get());
        
        usernamekar.setCellValueFactory(cellData->cellData.getValue().usernameKaryawan());
        namakar.setCellValueFactory(cellData->cellData.getValue().namaKaryawan());
        passkar.setCellValueFactory(cellData->cellData.getValue().passKaryawan());
        
        
    }    

    @FXML
    private void btn_kembali(ActionEvent event) throws IOException {
        System.out.println("kembali");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilanhome_Manajer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }




    @FXML
    private void btn_tambah(ActionEvent event) {
        DataKaryawan dk = new DataKaryawan();
        
        dk.setUsernameKaryawan(un.getText());
        dk.setNamaKaryawan(nm.getText());
        dk.setPassKaryawan(ps.getText());
        
        tabeldatakar.getItems().add(dk);
        dataKaryawanList.simpanXMLFile();
    }

    @FXML
    private void btn_ubah(ActionEvent event) {
        int pilihan = tabeldatakar.getSelectionModel().getSelectedIndex();

        if(pilihan >= 0) {
            tabeldatakar.getItems().remove(pilihan);
        }
        
        DataKaryawan dtk = new DataKaryawan();
        
        dtk.setUsernameKaryawan(un.getText());
        dtk.setNamaKaryawan(nm.getText());
        dtk.setPassKaryawan(ps.getText());
        tabeldatakar.getItems().add(dtk);
        dataKaryawanList.simpanXMLFile();
    }

    @FXML
    private void btn_hapus(ActionEvent event) {
        int pilihan = tabeldatakar.getSelectionModel().getSelectedIndex();

        if(pilihan >= 0) {
            tabeldatakar.getItems().remove(pilihan);
        }

        dataKaryawanList.simpanXMLFile();
    }

    @FXML
    private void tampil_ubah(MouseEvent event) {
        DataKaryawan dtk = tabeldatakar.getSelectionModel().getSelectedItem();
        
        un.setText(dtk.getUsernameKaryawan());
        nm.setText(dtk.getNamaKaryawan());
        ps.setText(dtk.getPassKaryawan());
    }
    
}
