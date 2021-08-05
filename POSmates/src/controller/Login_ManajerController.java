/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
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
import model.DataManajer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Login_ManajerController implements Initializable {

    @FXML
    private JFXTextField usnamem;
    @FXML
    private JFXPasswordField passm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_loginmanajer(ActionEvent event) throws IOException {
        try {
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream("dataManajer.xml");
            
            DataManajer dtm = (DataManajer) xs.fromXML(in);
            
            if (usnamem.getText().equals(dtm.getUsernameManajer()) & passm.getText().equals(dtm.getPasswordsManajer())){
                System.out.println("login");
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/tampilanhome_Manajer.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(tableViewScene);
                window.show();
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btn_buatakunmanajer(ActionEvent event) throws IOException {
        System.out.println("buat akun");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/buatakun_Manajer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
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
