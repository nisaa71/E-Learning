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
public class Mahasiswa extends Orang implements Serializable {
    private String nim;
    
    public Mahasiswa(String nama, String nim, int umur, String alamat, String username, String password) {
        super(nama, umur, alamat, username, password);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
