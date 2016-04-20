/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nando;

import java.io.Serializable;

/**
 *
 * @author NANDO
 */
public class MataKuliah implements Serializable{
    private String namaMK;
    private String kodeMK;
    private int sks;

    public MataKuliah(String namaMK, String kodeMK, int sks) {
        this.namaMK = namaMK;
        this.kodeMK = kodeMK;
        this.sks = sks;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public void setKodeMK(String kodeMK) {
        this.kodeMK = kodeMK;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

}
