package Jobsheet12;

public class Mahasiswa02 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa02 (String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampil() {
        System.out.println("NIM    : " +nim +"\nNama   : " +nama +"\nKelas    : " +kelas +"\nIPK     : " +ipk);
    }
}