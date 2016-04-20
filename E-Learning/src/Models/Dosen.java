/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author NANDO
 */
public class Dosen extends Orang implements Serializable{


    private Kelas kls;
    private String nip;
    private String kodedosen;
    private int umur;
    private ArrayList<Kelas>  daftarKelas = new ArrayList<>();

    public Dosen(String nama, String nip, String kodeDosen, String noTelp, String alamat, String tanggalLahir, String username, String password) {
        super(nama, noTelp, alamat, tanggalLahir, username, password);
        this.kodedosen = kodedosen;
        this.nip = nip;
    }
    public void createKelas(String nama) {
        
        if(daftarKelas.size() < 3) daftarKelas.add(kls);
        else System.out.println("Kelas Penuh");
    }
    
    public Kelas getKelas(int i){
        return daftarKelas.get(i);
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public void setKodedosen(String kodedosen) {
        this.kodedosen = kodedosen;
    }
    public Kelas getKelasByIndex(int i) {
        return daftarKelas.get(i);
    }
    
    public void removeKelas(int index) { //method untuk menghapus data di ArrayList berdasarkan index Arraynya
        if((index >= 0) && (index <daftarKelas.size())){
        daftarKelas.remove(index);
        }
    }
}