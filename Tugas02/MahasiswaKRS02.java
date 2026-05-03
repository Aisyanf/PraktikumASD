package Tugas02;

public class MahasiswaKRS02 {
    String nim;
    String nama;
    String prodi;
    String kelas;
 
    public MahasiswaKRS02 (String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }
 
    public void tampilkanData() {
        System.out.println(nim + " - " + nama + " - " + prodi + " - " + kelas);
    }
}
