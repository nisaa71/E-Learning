/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Aplikasi {

    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    int loggedin;

    public Aplikasi() {
        daftarDosen = readDosen();
        daftarMahasiswa = readMahasiswa();
        daftarMataKuliah = readMataKuliah();
    }

    public void addDosen(String nama, String nip, String kodeDosen, int umur, String alamat, String username, String password) {
        Dosen d = new Dosen(nama, nip, kodeDosen, umur, alamat, username, password);
        daftarDosen.add(d);
    }

    public void addMahasiswa(String namaMhs, String nim, int umurMhs, String alamatMhs, String usernameMhs, String passwordMhs) {
        Mahasiswa mhs = new Mahasiswa(namaMhs, nim, umurMhs, alamatMhs, usernameMhs, passwordMhs);
        daftarMahasiswa.add(mhs);
    }

    public void addMataKuliah(String namaMK, String kodeMK, int sks) {
        MataKuliah mk = new MataKuliah(namaMK, kodeMK, sks);
        daftarMataKuliah.add(mk);
    }

    public Dosen getDosen(String nip) {
        for (int i = 0; i < daftarDosen.size(); i++) {
            if (daftarDosen.get(i).getNip().equals(nip)) {
                return daftarDosen.get(i);
            }
        }
        return null;
    }

    public Mahasiswa getMahasiswa(String nim) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                return daftarMahasiswa.get(i);
            }
        }
        return null;
    }

    public MataKuliah getMataKuliah(String kodeMK) {
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            if (daftarMataKuliah.get(i).getKodeMK().equals(kodeMK)) {
                return daftarMataKuliah.get(i);
            }
        }
        return null;
    }

    public boolean deleteMahasiswa(String nim) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                daftarMahasiswa.remove(i);
                return true;
            }
        }
        return false;
    }

    public void updateFileDosen() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("dosen.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(daftarDosen);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error File Not Found");
        } catch (IOException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void updateFileMahasiswa() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("mahasiswa.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(daftarMahasiswa);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error File Not Found");
        } catch (IOException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void updateFileMataKuliah() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("matakuliah.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(daftarMataKuliah);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error File Not Found");
        } catch (IOException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public ArrayList<Dosen> readDosen() {
        try {
            FileInputStream fis = new FileInputStream(new File("dosen.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Dosen> daftarDosen = (ArrayList<Dosen>) ois.readObject();
            return daftarDosen;
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (EOFException ex) {
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Mahasiswa> readMahasiswa() {
        try {
            FileInputStream fis = new FileInputStream(new File("mahasiswa.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Mahasiswa> daftarMahasiswa = (ArrayList<Mahasiswa>) ois.readObject();
            return daftarMahasiswa;
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (EOFException ex) {
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MataKuliah> readMataKuliah() {
        try {
            FileInputStream fis = new FileInputStream(new File("matakuliah.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<MataKuliah> daftarMataKuliah = (ArrayList<MataKuliah>) ois.readObject();
            return daftarMataKuliah;
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (EOFException ex) {
            return new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void menuDosen() {
        String pil = null;
        do {
            System.out.println("1. Create Kelas");
            System.out.println("2. Add Mahasiswa");
            System.out.println("3. Delete Mahasiswa");
            System.out.println("4. Create Tugas");
            System.out.println("5. View Mahasiswa");
            System.out.println("6. Log Out");
            System.out.println("Masukkan pilihan : ");
            pil = s.next();
            switch (pil) {
                case "1":
                    System.out.println("Masukkan nama kelas : ");
                    String inputKelas = s.next();
                    daftarDosen.get(loggedin).createKelas(inputKelas);
                    updateFileDosen();
                    break;
                case "2":
                    System.out.println("Masukkan mahasiswa ke dalam kelas : ");
                    String searchKelas = s.next();
                    Kelas k = daftarDosen.get(loggedin).getKelasByNama(searchKelas);
                    if (k != null) {
                        for (int i = 0; i < daftarMahasiswa.size(); i++) {
                            if (!k.getMahasiswa().contains(daftarMahasiswa.get(i))) {
                                System.out.println((i + 1) + " " + daftarMahasiswa.get(i).getNim() + " | " + daftarMahasiswa.get(i).getNama());
                            }
                        }
                        System.out.print("Masukkan NIM mahasiswa yang ingin ditambahkan : ");
                        int inputMhs = s.nextInt();
                        k.addMahasiswa(daftarMahasiswa.get(inputMhs - 1));
                        updateFileDosen();
                    }
                    break;
                case "3":
                    System.out.println("Hapus mahasiswa dari kelas");
                    String searchKelasDelete = s.next();
                    Kelas kls = daftarDosen.get(loggedin).getKelasByNama(searchKelasDelete);
                    if (kls != null) {
                        for (int i = 0; i < daftarMahasiswa.size(); i++) {
                            if (!kls.getMahasiswa().contains(daftarMahasiswa.get(i))) {
                                System.out.println((i + 1) + " " + daftarMahasiswa.get(i).getNim() + " | " + daftarMahasiswa.get(i).getNama());
                            }
                        }
                        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus : ");
                        String nim = s.next();
                        kls.deleteMahasiswa(nim);
                        updateFileDosen();
                    }
                    break;
                case "4":
                    System.out.println("Create Tugas");
                    String inputTugas = s.next();
                    daftarDosen.get(loggedin).createTugas(inputTugas);
                    updateFileDosen();
                    break;
                case "5":
                    System.out.println("Lihat daftar mahasiswa");
                    for (int i = 0; i < daftarDosen.get(loggedin).getDaftarKelas(); i++) {
                        System.out.println(daftarDosen.get(loggedin).getKelasByIndex(i).getMahasiswa());
                        ArrayList<Mahasiswa> mhs = daftarDosen.get(loggedin).getKelasByIndex(i).getMahasiswa();
                        if (mhs.size() > 0) {
                            for (Mahasiswa m : mhs) {
                                System.out.println(m);
                            }
                        } else {
                            System.out.println("Belum ada mahasiswa");
                        }
                    }
                default:
                    System.out.println("Pilihan yang anda masukkan salah.");
            }
        } while (!pil.equals("6"));
    }

    public void menuMahasiswa() {
        String pil = null;
        do {
            System.out.println("1. View Daftar Kelas ");
            System.out.println("2. Join Kelas");
            System.out.println("3. Logout");
            System.out.println("Masukkan pilihan : ");
            pil = s.next();
            switch (pil) {
                case "1":
                    System.out.println("Daftar Kelas : ");
                    for (int i = 0; i < daftarDosen.get(loggedin).getDaftarKelas(); i++) {
                        System.out.println(daftarDosen.get(loggedin).getKelasByIndex(i));
                        ArrayList<Kelas> kls = daftarDosen.get(loggedin).getKelasByIndex(i).getMahasiswa();
                        if (kls.size() > 0) {
                            for (Kelas k : kls) {
                                System.out.println(k);
                            }
                        } else {
                            System.out.println("Belum ada mahasiswa");
                        }
                    }
                    updateFileMahasiswa();
                    break;

                case "2":
                    System.out.println("Join Kelas : ");
                    String Kelas = s.next();
                    daftarMahasiswa.get(loggedin).getDaftarKelas().setKelas(Kelas);
                    updateFileMahasiswa();
                    break;
                default:
                    System.out.println("Menu yang anda masukkan salah");
                    ;
            }
        } while (!pil.equals("3"));

    }

    public void menuSignUp() {
        String pil = null;
        do {
            System.out.println("===SIGN UP===");
            System.out.println("1. Dosen");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Back");
            System.out.print("Masukkan pilihan : ");
            pil = s.next();
            switch (pil) {
                case "1":
                    System.out.print("Nama : ");
                    String nama = s.next();
                    System.out.print("NIP : ");
                    String nip = s.next();
                    System.out.print("Kode Dosen : ");
                    String kodeDosen = s.next();
                    System.out.println("Umur : ");
                    int umur = s.nextInt();
                    System.out.print("Alamat : ");
                    String alamat = s.next();
                    System.out.print("Username : ");
                    String username = s.next();
                    System.out.print("Password : ");
                    String password = s.next();
                    addDosen(nama, nip, kodeDosen, umur, alamat, username, password);
                    System.out.println("Data Dosen Berhasil Ditambahkan");
                    break;
                case "2":
                    System.out.print("Nama : ");
                    String namaMhs = s.next();
                    System.out.print("NIM : ");
                    String nim = s.next();
                    System.out.println("Umur : ");
                    int umurMhs = s.nextInt();
                    System.out.print("Alamat : ");
                    String alamatMhs = s.next();
                    System.out.print("Username : ");
                    String usernameMhs = s.next();
                    System.out.print("Password : ");
                    String passwordMhs = s.next();
                    addMahasiswa(namaMhs, nim, umurMhs, alamatMhs, usernameMhs, passwordMhs);
                    System.out.println("Data Mahasiswa Berhasil Ditambahkan");
                    break;
                default:
                    System.out.println("Pilihan yang anda masukkan salah");
            }
        } while (!pil.equals("3"));
    }

    public String login(String username, String password) {
        for (Dosen d : daftarDosen) {
            if (d.getUsername().equals(username) && d.getPassword().equals(password)) {
                loggedin = daftarDosen.indexOf(d);
                return "dosen";
            }
        }
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
                loggedin = daftarMahasiswa.indexOf(m);
                return "mahasiswa";
            }
        }
        return "Password atau username salah!";
    }

    public void mainMenu() {
        String pil;
        do {
            System.out.println("MENU UTAMA");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan :");
            pil = s.next();
            switch (pil) {
                case "1":
                    System.out.print("Username : ");
                    String username = s.next();
                    System.out.print("Password : ");
                    String password = s.next();
                    String status = login(username, password);
                    if (status.equals("mahasiswa")) {
                        menuMahasiswa();
                    } else if (status.equals("dosen")) {
                        menuDosen();
                    } else {
                        System.out.println("Akun tidak tersedia");
                    }
                    break;
                case "2":
                    menuSignUp();
                    break;
            }
        } while (!pil.equals("3"));
    }
}
