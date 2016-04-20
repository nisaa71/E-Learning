/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Faridh Ronianto
 */
public class Tugas implements Serializable {
    private String namaTugas;
    private String deadline;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    private String namaMK;

    public Tugas(String namaTugas, String deadline, String namaMK) {
        this.namaTugas = namaTugas;
        this.deadline = deadline;
        this.namaMK = namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getNamaTugas() {
        return namaTugas;
    }
}
