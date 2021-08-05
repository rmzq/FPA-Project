/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class DataKaryawanList {
    private ObservableList<DataKaryawan> list;
    private String extFile;

    public DataKaryawanList() {
        list = FXCollections.observableArrayList();
        extFile = "dataKaryawan.xml";
    }

    public ObservableList<DataKaryawan> get() {
        return list;
    }

    public void setFromArray(DataKaryawanBiasa[] array) {
        list = FXCollections.observableArrayList();

        for(DataKaryawanBiasa dt : array) {
            list.add(new DataKaryawan(dt.getUsernameK(),dt.getNamaK(),dt.getPassK()));
        }
    }

    public void bacaXMLFile() {
        try {
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(extFile);
            String s = "";
            int c = in.read();
            while (c != -1) {
                s += (char) c;
                c = in.read();
            }

            DataKaryawanBiasa[] array = (DataKaryawanBiasa[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataKaryawanBiasa[] getArray() {
        DataKaryawanBiasa[] array = new DataKaryawanBiasa[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String usernameKaryawan = list.get(i).getUsernameKaryawan();
            String namaKaryawan = list.get(i).getNamaKaryawan();
            String passKaryawan = list.get(i).getPassKaryawan();
            
            array[i] = new DataKaryawanBiasa(usernameKaryawan,namaKaryawan,passKaryawan);
        }

        return array;
    }

    public void simpanXMLFile() {
        DataKaryawanBiasa[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML(array);

        try{
            FileOutputStream output = new FileOutputStream(extFile);
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
