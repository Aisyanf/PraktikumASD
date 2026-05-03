package Tugas02;

public class AntrianKRS02 {
    MahasiswaKRS02 [] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS;
    int maxDPA;
 
    public AntrianKRS02 (int max, int maxDPA) {
        this.max = max;
        this.maxDPA = maxDPA;
        this.data = new MahasiswaKRS02 [max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
    }
 
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
 
    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
 
    public void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        } else {
            System.out.println("Antrian sudah kosong.");
        }
    }
 
    public void tambahAntrian(MahasiswaKRS02 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        if (sudahKRS >= maxDPA) {
            System.out.println("DPA sudah menangani " + maxDPA + " mahasiswa. Tidak dapat menerima antrian baru.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian. (Nomor antrian: " + size + ")");
    }
 
    public void panggilKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa yang dipanggil.");
            return;
        }
        System.out.println("=== Memanggil antrian untuk proses KRS ===");
        int dipanggil = 0;
        while (!isEmpty() && dipanggil < 2) {
            if (sudahKRS >= maxDPA) {
                System.out.println("DPA sudah mencapai batas maksimal " + maxDPA + " mahasiswa.");
                break;
            }
            MahasiswaKRS02 mhs = data[front];
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            dipanggil++;
            System.out.print("Mahasiswa ke-" + sudahKRS + " diproses KRS: ");
            mhs.tampilkanData();
        }
        if (dipanggil == 0) {
            System.out.println("Tidak ada mahasiswa yang dapat diproses.");
        }
    }
 
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Semua Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }
 
    public void tampilkanDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 Antrian Terdepan:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }
 
    public void tampilkanAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling akhir:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }
 
    public void cetakJumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian : " + size);
    }
 
    public void cetakSudahKRS() {
        System.out.println("Jumlah mahasiswa yang sudah KRS: " + sudahKRS);
    }
    
    public void cetakBelumKRS() {
        int belumKRS = size;
        System.out.println("Jumlah mahasiswa yang belum KRS : " + belumKRS);
    }
}
