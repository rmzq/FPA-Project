/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User
 */
public class TransaksiBiasa {
    private String namabelib;
    private String kodebelib;
    private Integer banyakbelib;
    private Integer subtotalbelib;
    private LocalDate tanggalbelib;

    public TransaksiBiasa(String namabelib, String kodebelib, Integer banyakbelibr, Integer subtotalbelibr/*, LocalDate tanggalbelib*/) {
        this.namabelib = namabelib;
        this.kodebelib = kodebelib;
        this.banyakbelib = banyakbelibr;
        this.subtotalbelib = subtotalbelibr;
        /*this.tanggalbelib = tanggalbelib;*/
    }

    public String getNamabelib() {
        return namabelib;
    }

    public void setNamabelib(String namabelib) {
        this.namabelib = namabelib;
    }

    public String getKodebelib() {
        return kodebelib;
    }

    public void setKodebelib(String kodebelib) {
        this.kodebelib = kodebelib;
    }

    public Integer getBanyakbelib() {
        return banyakbelib;
    }

    public void setBanyakbelib(Integer banyakbelibr) {
        this.banyakbelib = banyakbelibr;
    }

    public Integer getSubtotalbelib() {
        return subtotalbelib;
    }

    public void setSubtotalbelib(Integer subtotalbelibr) {
        this.subtotalbelib = subtotalbelibr;
    }
/*
    public LocalDate getTanggalbelib() {
        return tanggalbelib;
    }

    public void setTanggalbelib(LocalDate tanggalbelib) {
        this.tanggalbelib = tanggalbelib;
    }
    
  */  
    
}
