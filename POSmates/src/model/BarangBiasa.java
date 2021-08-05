/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class BarangBiasa {
    private String namaB;
    private String kodeB;
    private Integer hargajualB;
    private Integer hargabeliB;
    private Integer banyakB;

    public BarangBiasa(String namaB, String kodeB, Integer hargajualB, Integer hargabeliB, Integer banyakB) {
        this.namaB = namaB;
        this.kodeB = kodeB;
        this.hargajualB = hargajualB;
        this.hargabeliB = hargabeliB;
        this.banyakB = banyakB;
    }

    public String getNamaB() {
        return namaB;
    }

    public void setNamaB(String namaB) {
        this.namaB = namaB;
    }

    public String getKodeB() {
        return kodeB;
    }

    public void setKodeB(String kodeB) {
        this.kodeB = kodeB;
    }

    public Integer getHargajualB() {
        return hargajualB;
    }

    public void setHargajualB(Integer hargajualB) {
        this.hargajualB = hargajualB;
    }

    public Integer getHargabeliB() {
        return hargabeliB;
    }

    public void setHargabeliB(Integer hargabeliB) {
        this.hargabeliB = hargabeliB;
    }

    public Integer getBanyakB() {
        return banyakB;
    }

    public void setBanyakB(Integer banyakB) {
        this.banyakB = banyakB;
    }
    
    
    
}
