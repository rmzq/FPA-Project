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
public class BarangList {
    private ObservableList<Barang> list;
    private String extFile;

    public BarangList() {
        list = FXCollections.observableArrayList();
        extFile = "databarang.xml";
    }

    public ObservableList<Barang> get() {
        return list;
    }

    public void setFromArray(BarangBiasa[] array) {
        list = FXCollections.observableArrayList();

        for(BarangBiasa br : array) {
            list.add(new Barang(br.getNamaB(), br.getKodeB(), br.getHargajualB(), br.getHargabeliB(), br.getBanyakB()));
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

            BarangBiasa[] array = (BarangBiasa[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BarangBiasa[] getArray() {
        BarangBiasa[] array = new BarangBiasa[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String namaBarang = list.get(i).getNamaBarang();
            String kodeBarang = list.get(i).getKodeBarang();
            Integer hargajualBarang = list.get(i).getHargajualBarang();
            Integer hargabeliBarang = list.get(i).getHargabeliBarang();
            Integer banyakBarang = list.get(i).getBanyakBarang();
            
            array[i] = new BarangBiasa(namaBarang, kodeBarang, hargajualBarang, hargabeliBarang, banyakBarang);
        }

        return array;
    }

    public void simpanXMLFile() {
        BarangBiasa[] array = this.getArray();
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
