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
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class TransaksiList {
    private ObservableList<Transaksi> list;
    private String extFile;

    public TransaksiList() {
        list = FXCollections.observableArrayList();
        extFile = "datatransaksi.xml";
    }

    public ObservableList<Transaksi> get() {
        return list;
    }

    public void setFromArray(TransaksiBiasa[] array) {
        list = FXCollections.observableArrayList();

        for(TransaksiBiasa br : array) {
            list.add(new Transaksi(br.getNamabelib(), br.getKodebelib(), br.getBanyakbelib(), br.getSubtotalbelib()/*, br.getTanggalbelib()*/));
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

            TransaksiBiasa[] array = (TransaksiBiasa[]) xs.fromXML(s);
            this.setFromArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TransaksiBiasa[] getArray() {
        TransaksiBiasa[] array = new TransaksiBiasa[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String namaBar = list.get(i).getNamaBarangBeli();
            String kodeBar = list.get(i).getKodeBarangBeli();
            Integer banyakBar = list.get(i).getBanyakBarangBeli();
            Integer subtotalBar = list.get(i).getSubtotalBarangBeli();
            //LocalDate tanggalBarangBeli = list.get(i).getTanggalBarangbeli();
            
            array[i] = new TransaksiBiasa(namaBar, kodeBar, banyakBar, subtotalBar/*, tanggalBarangBeli*/);
        }

        return array;
    }

    public void simpanXMLFile() {
        TransaksiBiasa[] array = this.getArray();
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
