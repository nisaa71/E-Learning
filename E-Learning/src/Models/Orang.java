/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author user
 */
public abstract class Orang implements Serializable {

    private String nama;
    private int umur;
    private String alamat;
    private String username;
    private String password;

    public Orang(String nama, int umur, String alamat, String username, String password) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
