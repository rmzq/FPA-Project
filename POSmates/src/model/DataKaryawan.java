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
public class DataKaryawan {
    private StringProperty usernameKaryawan;
    private StringProperty namaKaryawan;
    private StringProperty passKaryawan;
    
    public DataKaryawan(){
        this("","","");
    }

    public DataKaryawan(String usernameKaryawan, String namaKaryawan, String passKaryawan) {
        this.usernameKaryawan = new SimpleStringProperty(usernameKaryawan);
        this.namaKaryawan = new SimpleStringProperty(namaKaryawan);
        this.passKaryawan = new SimpleStringProperty(passKaryawan);
    }

    public String getUsernameKaryawan() {
        return usernameKaryawan.get();
    }

    public void setUsernameKaryawan(String usernameK) {
        this.usernameKaryawan.set(usernameK);
    }
    
    public StringProperty usernameKaryawan(){
        return usernameKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan.get();
    }

    public void setNamaKaryawan(String namaK) {
        this.namaKaryawan.set(namaK);
    }
    
    public StringProperty namaKaryawan(){
        return namaKaryawan;
    }

    public String getPassKaryawan() {
        return passKaryawan.get();
    }

    public void setPassKaryawan(String passK) {
        this.passKaryawan.set(passK);
    }
    
    public StringProperty passKaryawan(){
        return passKaryawan;
    }
    
    
    
}
