/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.*;

/**
 *
 * @author User
 */
public class Barang {
    private StringProperty namaBarang;
    private StringProperty kodeBarang;
    private IntegerProperty hargajualBarang;
    private IntegerProperty hargabeliBarang;
    private IntegerProperty banyakBarang;
    
    public Barang(){
        this ("", "", 0, 0, 0);
    }
    
    public Barang(String namaBarang, String kodeBarang, Integer hargajualBarang,Integer hargabeliBarang, Integer banyakBarang){
        this.namaBarang = new SimpleStringProperty(namaBarang);
        this.kodeBarang = new SimpleStringProperty(kodeBarang);
        this.hargajualBarang = new SimpleIntegerProperty(hargajualBarang);
        this.hargabeliBarang = new SimpleIntegerProperty(hargabeliBarang);
        this.banyakBarang = new SimpleIntegerProperty(banyakBarang);
    }

    public String getNamaBarang() {
        return this.namaBarang.get();
    }

    public void setNamaBarang(String namaB) {
        this.namaBarang.set(namaB);
    }
    
    public StringProperty namaBarangProperty(){
        return namaBarang;
    }

    public String getKodeBarang() {
        return this.kodeBarang.get();
    }

    public void setKodeBarang(String kodeB) {
        this.kodeBarang.set(kodeB);
    }
    
    public StringProperty kodeBarangProperty(){
        return kodeBarang;
    }

    public Integer getHargajualBarang() {
        return this.hargajualBarang.get();
    }

    public void setHargajualBarang(Integer hargajualB) {
        this.hargajualBarang.set(hargajualB);
    }
    
    public IntegerProperty hargajualBarangProperty(){
        return hargajualBarang;
    }

    public Integer getHargabeliBarang() {
        return this.hargabeliBarang.get();
    }

    public void setHargabeliBarang(Integer hargabeliB) {
        this.hargabeliBarang.set(hargabeliB);
    }
    
    public IntegerProperty hargabeliBarangProperty(){
        return hargabeliBarang;
    }

    public Integer getBanyakBarang() {
        return this.banyakBarang.get();
    }

    public void setBanyakBarang(Integer banyakB) {
        this.banyakBarang.set(banyakB);
    }
    
    public IntegerProperty banyakBarangProperty(){
        return banyakBarang;
    }
    
    
    
}
