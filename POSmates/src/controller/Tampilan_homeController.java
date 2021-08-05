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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Tampilan_homeController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_barang(ActionEvent event) throws IOException {
        
        System.out.println("barang");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_barang.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void btn_transaksi(ActionEvent event) throws IOException {
        System.out.println("transaksi");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_transaksi.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    private void btn_laporan(ActionEvent event) throws IOException {
        System.out.println("laporan");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_laporan.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    

    @FXML
    private void btn_logout(ActionEvent event) throws IOException {
        System.out.println("logout");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilan_Awal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
