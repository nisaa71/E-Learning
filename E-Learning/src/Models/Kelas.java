/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Faridh Ronianto
 */
public class Kelas {
    private MataKuliah mataKuliah;
    private ArrayList <Mahasiswa> anggota = new ArrayList<>();
    private ArrayList <Tugas> tugas = new ArrayList<>();
    private String kelas;
    private String nim;

    public Kelas(String kelas) {
        this.kelas = kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setNamaKuliah(MataKuliah mk) {
        this.mataKuliah = mk;
    }

    public MataKuliah getNamaKuliah() {
        return mataKuliah;
    }

    public String getKelas() {
        return kelas;
    }

    public void addMahasiswa(Mahasiswa m) {
        if(anggota.size() < 40) anggota.add(m);
        else System.out.println("Kelas Penuh");
    }

    public void createTugas(Tugas t) {
        if(tugas.size() < 5) tugas.add(t);
        else System.out.println("Tugas Penuh");
    }
    
    public Tugas getTugasByIndex(int t){
        return tugas.get(t);
    }
    
    public Mahasiswa getMahasiswaByIndex(int idx){
        if(idx<anggota.size()){
            return anggota.get(idx);
        } else {
            return null;
        }
    }
    public Mahasiswa getMahasiswaById(String idMhs){
        Mahasiswa mhs = null;
	for (Mahasiswa m : anggota) {
            if (m.getNim() == idMhs) {
		mhs = m;
		break;
            }
	}
	return mhs;
    }
    public void deleteMahasiswa(Mahasiswa m){
        if(anggota.size() > 0) anggota.remove(m);
        else System.out.println("Kelas Kosong");
    }
}
