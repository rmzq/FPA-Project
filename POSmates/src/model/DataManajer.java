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
public class DataManajer {
    String namaManajer;
    String usernameManajer;
    String passwordsManajer;
    
    public DataManajer(){
        this("","","");
    }

    public DataManajer(String namaManajer, String usernameManajer, String passwordsManajer) {
        this.namaManajer = namaManajer;
        this.usernameManajer = usernameManajer;
        this.passwordsManajer = passwordsManajer;
    }

    public String getNamaManajer() {
        return namaManajer;
    }

    public void setNamaManajer(String namaManajer) {
        this.namaManajer = namaManajer;
    }

    public String getUsernameManajer() {
        return usernameManajer;
    }

    public void setUsernameManajer(String usernameManajer) {
        this.usernameManajer = usernameManajer;
    }

    public String getPasswordsManajer() {
        return passwordsManajer;
    }

    public void setPasswordsManajer(String passwordsManajer) {
        this.passwordsManajer = passwordsManajer;
    }
    
    
    
    
    
}
