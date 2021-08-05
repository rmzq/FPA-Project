/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

import javafx.beans.property.*;

/**
 *
 * @author User
 */
public class Transaksi {
    private StringProperty namaBarangBeli;
    private StringProperty kodeBarangBeli;
    private IntegerProperty banyakBarangBeli;
    private IntegerProperty subtotalBarangBeli;
    private LocalDate tanggalBarangbeli;
    
    public Transaksi(){
        this("","",0,0/*,null*/);
    }

    public Transaksi(String namaBarangBeli, String kodeBarangBeli, Integer banyakBarangBeli, Integer subtotalBarangBeli/*, LocalDate tanggalbeli*/) {
        this.namaBarangBeli = new SimpleStringProperty(namaBarangBeli);
        this.kodeBarangBeli = new SimpleStringProperty(kodeBarangBeli);
        this.banyakBarangBeli = new SimpleIntegerProperty(banyakBarangBeli);
        this.subtotalBarangBeli = new SimpleIntegerProperty(subtotalBarangBeli);
        /*this.tanggalBarangbeli = tanggalbeli;*/
    }

    public String getNamaBarangBeli() {
        return namaBarangBeli.get();
    }

    public void setNamaBarangBeli(String namaBarBeli) {
        this.namaBarangBeli.set(namaBarBeli);
    }
    
    public StringProperty namaBarangBeliProperty(){
        return namaBarangBeli;
    }

    public String getKodeBarangBeli() {
        return kodeBarangBeli.get();
    }

    public void setKodeBarangBeli(String kodeBarBeli) {
        this.kodeBarangBeli.set(kodeBarBeli);
    }
    
    public StringProperty kodeBarangBeliProperty(){
        return kodeBarangBeli;
    }

    public Integer getBanyakBarangBeli() {
        return banyakBarangBeli.get();
    }

    public void setBanyakBarangBeli(Integer banyakBarBeli) {
        this.banyakBarangBeli.set(banyakBarBeli);
    }
    
    public IntegerProperty banyakBarangBeliProperty(){
        return banyakBarangBeli;
    }

    public Integer getSubtotalBarangBeli() {
        return subtotalBarangBeli.get();
    }

    public void setSubtotalBarangBeli(Integer subtotalBarBeli) {
        this.subtotalBarangBeli.set(subtotalBarBeli);
    }
    
    public IntegerProperty subtotalBarangBeliProperty(){
        return subtotalBarangBeli;
    }
/*
    public LocalDate getTanggalBarangbeli() {
        return tanggalBarangbeli;
    }

    public void setTanggalBarangbeli(LocalDate tanggalBarangbeli) {
        this.tanggalBarangbeli = tanggalBarangbeli;
    }
    
  */  
    
    
    
}
