/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.stage.Stage;
import model.DataKaryawan;
import model.DataKaryawanList;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Login_KaryawanController implements Initializable {
    

    @FXML
    private JFXTextField unkar;
    @FXML
    private JFXPasswordField passkar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_loginkaryawan(ActionEvent event) throws IOException {
        
        DataKaryawanList dataKaryawanList = new DataKaryawanList();
        dataKaryawanList.bacaXMLFile();
        for(DataKaryawan dtk : dataKaryawanList.get()){
            if (unkar.getText().equals(dtk.getUsernameKaryawan())& passkar.getText().equals(dtk.getPassKaryawan()) ){
                System.out.println("login karyawan");
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_home.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(tableViewScene);
                window.show();
                break;
            }
        }

    }
    
    

    @FXML
    private void btn_kembali(ActionEvent event) throws IOException {
        System.out.println("kembali");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_Awal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
