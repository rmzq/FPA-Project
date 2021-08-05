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
public class DataKaryawanBiasa {
    private String usernameK;
    private String namaK;
    private String passK;

    public DataKaryawanBiasa(String usernameK, String namaK, String passK) {
        this.usernameK = usernameK;
        this.namaK = namaK;
        this.passK = passK;
    }

    public String getUsernameK() {
        return usernameK;
    }

    public void setUsernameK(String usernameK) {
        this.usernameK = usernameK;
    }

    public String getNamaK() {
        return namaK;
    }

    public void setNamaK(String namaK) {
        this.namaK = namaK;
    }

    public String getPassK() {
        return passK;
    }

    public void setPassK(String passK) {
        this.passK = passK;
    }
    
    
    
}
