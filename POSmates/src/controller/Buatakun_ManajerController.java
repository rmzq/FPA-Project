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
import java.io.FileOutputStream;
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
public class Buatakun_ManajerController implements Initializable {
    

    @FXML
    private JFXTextField usernamem;
    @FXML
    private JFXPasswordField passm;
    @FXML
    private JFXTextField namem;
    @FXML
    private JFXPasswordField passconfirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_login(ActionEvent event) throws IOException {
        System.out.println("login");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/login_Manajer.fxml"));
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

    @FXML
    private void btn_buatakun(ActionEvent event) {
        DataManajer data = new DataManajer (namem.getText(),usernamem.getText(),passm.getText());
        
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(data);

        try{
            FileOutputStream output = new FileOutputStream("dataManajer.xml");
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
