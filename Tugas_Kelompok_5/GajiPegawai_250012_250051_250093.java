/*
Nama Program : Program Gaji OOP dengan tambahan parkir
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 09 November 2026
Deskripsi    : Buatlah program OOP Array of Object dengan menambahkan class person (minimal ada nama, Alamat, dll) yang melakukan inheritance dengan class pegawai untuk mencari gaji harian dan lembur
               berdasarkan lama kerja pegawai dgn aturan sbb:
                • Input : NIP, nama, Alamat, gol, waktu datang, waktu pulang
                • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
                    Gol gaji harian lembur >= 8 jam kerja
                    1 150 rb 50.000 /jam
                    2 200 rb 75.000 /jam
                    3 400 rb 150.000 /jam
                    4 500 rb 200.000 /jam
                • Proses : gaji Harian = gapok + lembur
                • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
                • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
                  Tabel
                  Rata-rata Gaji : ---
                  Gaji Tertinggi :
                  Gaji Terendah :
               Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output ) selain class Utama
               Buat program parkir kendaraan berdasarkan kendaraan --> mobil, truk dan motor ( inheritance dan polimorfisma)
               Biaya parkir :
                untuk umum (person atau tanpa identitas) : 3000, 5000 dan 2000 perjam
                untuk pegawai : 6000, dan 3000 per hari (<=24 jam) --> hanya mobil dan motor. Truk sesuai umum
               Parkir kendaraan juga berbentuk array (buatkan tabel laporannya)
               Lakukan improvisasi. Tuliskan spek dan aturan terbaik yang lain berdasarkan spek dasar ini.
*/
import java.util.Scanner;

class Waktu {
    private int jam, menit, detik;

    public Waktu() {
        this(0, 0, 0);
    }

    public Waktu(int jam, int menit, int detik) {
        setWaktu(jam, menit, detik);
    }

    public int getJam() { return jam; }
    public int getMenit() { return menit; }
    public int getDetik() { return detik; }

    public void setJam(int jam) {
        if (jam >= 0 && jam < 24) this.jam = jam;
        else {
            this.jam = 0;
            System.out.println("Jam harus 0-23.");
        }
    }

    public void setMenit(int menit) {
        if (menit >= 0 && menit < 60) this.menit = menit;
        else {
            this.menit = 0;
            System.out.println("Menit harus 0-59.");
        }
    }

    public void setDetik(int detik) {
        if (detik >= 0 && detik < 60) this.detik = detik;
        else {
            this.detik = 0;
            System.out.println("Detik harus 0-59.");
        }
    }

    public void setWaktu(int jam, int menit, int detik) {
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }

    public int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    public void inputWaktu(Scanner input) {
        int j, m, d;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            j = input.nextInt();
            if (j < 0 || j >= 24)
                System.out.println("Jam harus 0-23.");
        } while (j < 0 || j >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            m = input.nextInt();
            if (m < 0 || m >= 60)
                System.out.println("Menit harus 0-59.");
        } while (m < 0 || m >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            d = input.nextInt();
            if (d < 0 || d >= 60)
                System.out.println("Detik harus 0-59.");
        } while (d < 0 || d >= 60);

        setWaktu(j, m, d);
        input.nextLine();
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", jam, menit, detik);
    }
}

class Person {
    protected String nama;
    protected String alamat;

    public Person() {
        this("", "");
    }

    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }

    public void setNama(String nama) { this.nama = nama; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public void setPerson(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public void inputPerson(Scanner input) {
        System.out.print("Masukkan nama: ");
        nama = input.nextLine();

        System.out.print("Masukkan alamat: ");
        alamat = input.nextLine();
    }

    public void cetakPerson() {
        System.out.println("Nama   : " + nama);
        System.out.println("Alamat : " + alamat);
    }
}

class Pegawai extends Person {
    private String NIP;
    private int gol;

    public Pegawai() {
        this("", "", 0, "");
    }

    public Pegawai(String nama, String NIP, int gol, String alamat) {
        super(nama, alamat);
        this.NIP = NIP;
        this.gol = gol;
    }

    public String getNIP() { return NIP; }
    public int getGol() { return gol; }

    public void setNIP(String NIP) { this.NIP = NIP; }
    public void setGol(int gol) { this.gol = gol; }

    public void setPegawai(String nama, String NIP, int gol, String alamat) {
        setPerson(nama, alamat);
        this.NIP = NIP;
        this.gol = gol;
    }

    public void inputPegawai(Scanner input) {
        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

        System.out.print("Masukkan alamat pegawai: ");
        alamat = input.nextLine();

        do {
            System.out.print("Masukkan golongan: ");
            gol = input.nextInt();

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan tidak valid.");
                System.out.println(
                    "Silahkan pilih golongan dengan rentang 1-4!"
                );
                System.out.println();
            }
        } while (gol < 1 || gol > 4);

        input.nextLine();
    }

    public int hitungGajiHarian() {
        switch (gol) {
            case 1: return 150000;
            case 2: return 200000;
            case 3: return 400000;
            case 4: return 500000;
            default: return 0;
        }
    }

    public int hitungLembur() {
        switch (gol) {
            case 1: return 50000;
            case 2: return 75000;
            case 3: return 150000;
            case 4: return 200000;
            default: return 0;
        }
    }

    public Waktu hitungLamaKerja(Waktu datang, Waktu pulang) {
        int awal = datang.konvertDetik();
        int akhir = pulang.konvertDetik();

        if (akhir < awal)
            akhir += 24 * 3600;

        int selisih = akhir - awal;

        return new Waktu(
            selisih / 3600,
            (selisih % 3600) / 60,
            selisih % 60
        );
    }

    public int hitungJamLembur(Waktu datang, Waktu pulang) {
        int totalDetik = hitungLamaKerja(datang, pulang).konvertDetik();

        if (totalDetik < 9 * 3600)
            return 0;

        return (totalDetik - 8 * 3600) / 3600;
    }

    public int hitungGajiLembur(Waktu datang, Waktu pulang) {
        return hitungJamLembur(datang, pulang) * hitungLembur();
    }

    public int hitungGajiTotal(Waktu datang, Waktu pulang) {
        return hitungGajiHarian() + hitungGajiLembur(datang, pulang);
    }

    public String hitungStatus(Waktu datang, Waktu pulang) {
        int lama = hitungLamaKerja(datang, pulang).konvertDetik();

        if (lama < 8 * 3600)
            return "peringatan";

        return "ok";
    }

    public String formatRibuan(int angka) {
        String nilai = String.valueOf(angka);
        String hasil = "";
        int hitung = 0;

        for (int i = nilai.length() - 1; i >= 0; i--) {
            hasil = nilai.charAt(i) + hasil;
            hitung++;

            if (hitung % 3 == 0 && i > 0)
                hasil = "." + hasil;
        }

        return hasil;
    }

    public String formatWaktu(Waktu waktu) {
        return String.format(
            "%02d:%02d:%02d",
            waktu.getJam(),
            waktu.getMenit(),
            waktu.getDetik()
        );
    }

    public void cetakPegawai(Waktu datang, Waktu pulang, int no) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        System.out.printf(
            "%-4d%-10s%-14s%-20s%-5d%-10s%-10s%-10s%-12d%-15s%-12s%-15s%-12s%n",
            no,
            getNIP(),
            getNama(),
            getAlamat(),
            getGol(),
            formatWaktu(datang),
            formatWaktu(pulang),
            formatWaktu(lama),
            hitungJamLembur(datang, pulang),
            formatRibuan(hitungGajiHarian()),
            formatRibuan(hitungGajiLembur(datang, pulang)),
            formatRibuan(hitungGajiTotal(datang, pulang)),
            hitungStatus(datang, pulang)
        );
    }
}

class ArrayPegawai {
    private Pegawai[] data;
    private Waktu[] waktuDatang;
    private Waktu[] waktuPulang;
    private int jumlah;

    public ArrayPegawai() {
        data = new Pegawai[10];
        waktuDatang = new Waktu[10];
        waktuPulang = new Waktu[10];
        jumlah = 0;
    }

    public int getJumlah() { return jumlah; }

    public Pegawai getPegawai(int index) {
        Pegawai p = data[index];

        return new Pegawai(
            p.getNama(), p.getNIP(), p.getGol(), p.getAlamat()
        );
    }

    public Waktu getWaktuDatang(int index) {
        Waktu w = waktuDatang[index];

        return new Waktu(w.getJam(), w.getMenit(), w.getDetik());
    }

    public Waktu getWaktuPulang(int index) {
        Waktu w = waktuPulang[index];

        return new Waktu(w.getJam(), w.getMenit(), w.getDetik());
    }

    public void tambahPegawai(Pegawai pegawai, Waktu datang, Waktu pulang) {
        if (jumlah < 10) {
            data[jumlah] = new Pegawai(
                pegawai.getNama(),
                pegawai.getNIP(),
                pegawai.getGol(),
                pegawai.getAlamat()
            );

            waktuDatang[jumlah] = new Waktu(
                datang.getJam(), datang.getMenit(), datang.getDetik()
            );

            waktuPulang[jumlah] = new Waktu(
                pulang.getJam(), pulang.getMenit(), pulang.getDetik()
            );

            jumlah++;
        } else {
            System.out.println("Array pegawai sudah penuh!");
        }
    }

    public int hitungGajiPadaIndex(int index) {
        return data[index].hitungGajiTotal(
            waktuDatang[index], waktuPulang[index]
        );
    }

    public void tukarData(int i, int j) {
        Pegawai tempPegawai = data[i];
        data[i] = data[j];
        data[j] = tempPegawai;

        Waktu tempDatang = waktuDatang[i];
        waktuDatang[i] = waktuDatang[j];
        waktuDatang[j] = tempDatang;

        Waktu tempPulang = waktuPulang[i];
        waktuPulang[i] = waktuPulang[j];
        waktuPulang[j] = tempPulang;
    }

    public ArrayPegawai salinData() {
        ArrayPegawai hasil = new ArrayPegawai();

        for (int i = 0; i < jumlah; i++) {
            hasil.tambahPegawai(data[i], waktuDatang[i], waktuPulang[i]);
        }

        return hasil;
    }

    public ArrayPegawai sortingAscending() {
        ArrayPegawai hasil = salinData();

        for (int i = 0; i < hasil.jumlah - 1; i++) {
            for (int j = 0; j < hasil.jumlah - i - 1; j++) {
                if (hasil.hitungGajiPadaIndex(j) >
                    hasil.hitungGajiPadaIndex(j + 1)) {
                    hasil.tukarData(j, j + 1);
                }
            }
        }

        return hasil;
    }

    public ArrayPegawai sortingDescending() {
        ArrayPegawai hasil = salinData();

        for (int i = 0; i < hasil.jumlah - 1; i++) {
            for (int j = 0; j < hasil.jumlah - i - 1; j++) {
                if (hasil.hitungGajiPadaIndex(j) <
                    hasil.hitungGajiPadaIndex(j + 1)) {
                    hasil.tukarData(j, j + 1);
                }
            }
        }

        return hasil;
    }
}

class Orang {
    private String nama;

    public Orang() {
        this("");
    }

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}

abstract class Kendaraan {
    protected String nomorPolisi;
    protected String NIP;
    protected String status;
    protected Orang pemilik;
    protected Waktu waktuMasuk;
    protected Waktu waktuKeluar;

    public Kendaraan() {
        this("", "", "", "Umum", new Waktu(), new Waktu());
    }

    public Kendaraan(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar
    ) {
        nomorPolisi = nomor;
        pemilik = new Orang(nama);
        NIP = nip;
        this.status = status;

        waktuMasuk = new Waktu(
            masuk.getJam(), masuk.getMenit(), masuk.getDetik()
        );

        waktuKeluar = new Waktu(
            keluar.getJam(), keluar.getMenit(), keluar.getDetik()
        );
    }

    public String getNomorPolisi() { return nomorPolisi; }
    public String getStatus() { return status; }

    public int hitungLamaDetik() {
        int awal = waktuMasuk.konvertDetik();
        int akhir = waktuKeluar.konvertDetik();

        if (akhir < awal)
            akhir += 24 * 3600;

        return akhir - awal;
    }

    public void setKendaraan(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar
    ) {
        nomorPolisi = nomor;
        pemilik.setNama(nama);
        NIP = nip;
        this.status = status;

        waktuMasuk = new Waktu(
            masuk.getJam(), masuk.getMenit(), masuk.getDetik()
        );

        waktuKeluar = new Waktu(
            keluar.getJam(), keluar.getMenit(), keluar.getDetik()
        );
    }

    public void inputDataDasar(Scanner input) {
        int pengguna;

        System.out.print("Nomor polisi: ");
        nomorPolisi = input.nextLine();

        do {
            System.out.print("Jenis pengguna (1. Umum  2. Pegawai): ");
            pengguna = input.nextInt();

            if (pengguna < 1 || pengguna > 2)
                System.out.println("Pilihan tidak valid!");

        } while (pengguna < 1 || pengguna > 2);

        input.nextLine();

        if (pengguna == 2) {
            status = "Pegawai";

            System.out.print("Nama pegawai: ");
            pemilik.setNama(input.nextLine());

            System.out.print("NIP pegawai: ");
            NIP = input.nextLine();
        } else {
            status = "Umum";
            pemilik.setNama("");
            NIP = "";
        }
    }

    public abstract String getJenis();
    public abstract void cetakKarakteristik();
    public abstract int hitungBiaya(int lamaDetik, boolean pegawai);
    public abstract void inputKendaraan(Scanner input);

    public void cetakData(int no) {
        Pegawai format = new Pegawai();

        String identitas = status.equals("Pegawai")
            ? pemilik.getNama() + "/" + NIP : "-";

        int detik = hitungLamaDetik();

        String lama = (detik / 3600) + "j " +
            ((detik % 3600) / 60) + "m";

        System.out.printf(
            "%-4d%-12s%-10s%-12s%-18s%-10s%-10s%-12s%-15s",
            no,
            nomorPolisi,
            getJenis(),
            status,
            identitas,
            format.formatWaktu(waktuMasuk),
            format.formatWaktu(waktuKeluar),
            lama,
            "Rp " + format.formatRibuan(
                hitungBiaya(detik, status.equals("Pegawai"))
            )
        );

        cetakKarakteristik();
        System.out.println();
    }
}

class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil() {
        this("", "", "", "Umum", new Waktu(), new Waktu(), 4);
    }

    public Mobil(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int pintu
    ) {
        super(nomor, nama, nip, status, masuk, keluar);
        jumlahPintu = pintu;
    }

    public void setMobil(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int pintu
    ) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahPintu = pintu;
    }

    public void inputKendaraan(Scanner input) {
        inputDataDasar(input);

        do {
            System.out.print("Jumlah pintu mobil: ");
            jumlahPintu = input.nextInt();

            if (jumlahPintu < 2 || jumlahPintu > 6)
                System.out.println("Jumlah pintu harus 2-6!");

        } while (jumlahPintu < 2 || jumlahPintu > 6);

        input.nextLine();

        System.out.println("-- Waktu masuk --");
        waktuMasuk.inputWaktu(input);

        System.out.println("-- Waktu keluar --");
        waktuKeluar.inputWaktu(input);
    }

    public String getJenis() { return "Mobil"; }

    public void cetakKarakteristik() {
        System.out.print("Jumlah pintu: " + jumlahPintu);
    }

    public int hitungBiaya(int lamaDetik, boolean pegawai) {
        if (pegawai)
            return ((lamaDetik + 86400 - 1) / 86400) * 6000;

        return ((lamaDetik + 3600 - 1) / 3600) * 3000;
    }
}

class Truk extends Kendaraan {
    private int jumlahRoda;

    public Truk() {
        this("", "", "", "Umum", new Waktu(), new Waktu(), 6);
    }

    public Truk(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int roda
    ) {
        super(nomor, nama, nip, status, masuk, keluar);
        jumlahRoda = roda;
    }

    public void setTruk(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int roda
    ) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahRoda = roda;
    }

    public void inputKendaraan(Scanner input) {
        inputDataDasar(input);

        do {
            System.out.print("Jumlah roda truk: ");
            jumlahRoda = input.nextInt();

            if (jumlahRoda < 4 || jumlahRoda > 18)
                System.out.println("Jumlah roda harus 4-18!");

        } while (jumlahRoda < 4 || jumlahRoda > 18);

        input.nextLine();

        System.out.println("-- Waktu masuk --");
        waktuMasuk.inputWaktu(input);

        System.out.println("-- Waktu keluar --");
        waktuKeluar.inputWaktu(input);
    }

    public String getJenis() { return "Truk"; }

    public void cetakKarakteristik() {
        System.out.print("Jumlah roda: " + jumlahRoda);
    }

    public int hitungBiaya(int lamaDetik, boolean pegawai) {
        return ((lamaDetik + 3600 - 1) / 3600) * 5000;
    }
}

class Motor extends Kendaraan {
    private int jumlahTak;

    public Motor() {
        this("", "", "", "Umum", new Waktu(), new Waktu(), 4);
    }

    public Motor(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int tak
    ) {
        super(nomor, nama, nip, status, masuk, keluar);
        jumlahTak = tak;
    }

    public void setMotor(
        String nomor, String nama, String nip, String status,
        Waktu masuk, Waktu keluar, int tak
    ) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahTak = tak;
    }

    public void inputKendaraan(Scanner input) {
        inputDataDasar(input);

        do {
            System.out.print("Jenis mesin motor (2 atau 4 tak): ");
            jumlahTak = input.nextInt();

            if (jumlahTak != 2 && jumlahTak != 4)
                System.out.println("Isi 2 atau 4!");

        } while (jumlahTak != 2 && jumlahTak != 4);

        input.nextLine();

        System.out.println("-- Waktu masuk --");
        waktuMasuk.inputWaktu(input);

        System.out.println("-- Waktu keluar --");
        waktuKeluar.inputWaktu(input);
    }

    public String getJenis() { return "Motor"; }

    public void cetakKarakteristik() {
        System.out.print("Jenis mesin: " + jumlahTak + "-tak");
    }

    public int hitungBiaya(int lamaDetik, boolean pegawai) {
        if (pegawai)
            return ((lamaDetik + 86400 - 1) / 86400) * 3000;

        return ((lamaDetik + 3600 - 1) / 3600) * 2000;
    }
}

class ArrayParkir {
    private Kendaraan[] kendaraan;
    private int jumlah;

    public ArrayParkir() {
        kendaraan = new Kendaraan[10];
        jumlah = 0;
    }

    public void tambahParkir(Kendaraan data) {
        if (jumlah < 10) {
            kendaraan[jumlah++] = data;
        } else {
            System.out.println("Array parkir penuh!");
        }
    }

    public void cetakLaporan() {
        if (jumlah == 0) {
            System.out.println("Tidak ada data parkir.");
            return;
        }

        System.out.println();
        System.out.println("================ LAPORAN PARKIR KENDARAAN ================");
        System.out.println();

        System.out.printf(
            "%-4s%-12s%-10s%-12s%-18s%-10s%-10s%-12s%-15s%s%n",
            "No", "No Polisi", "Jenis", "Pengguna", "Nama/NIP",
            "Masuk", "Keluar", "Lama", "Biaya", "Karakteristik"
        );

        System.out.println("-".repeat(125));

        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            kendaraan[i].cetakData(i + 1);

            total += kendaraan[i].hitungBiaya(
                kendaraan[i].hitungLamaDetik(),
                kendaraan[i].getStatus().equals("Pegawai")
            );
        }

        System.out.println("-".repeat(125));

        Pegawai format = new Pegawai();

        System.out.println("Jumlah kendaraan : " + jumlah);
        System.out.println(
            "Total pendapatan  : Rp " + format.formatRibuan(total)
        );
    }
}

class Menu {
    private int pilihan;
    private final Scanner input;

    public Menu() {
        pilihan = 0;
        input = new Scanner(System.in);
    }

    public int getPilihan() {
        return pilihan;
    }

    public void inputPegawaiLuar(Pegawai data) {
        String NIP, nama, alamat;
        int gol;

        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

        System.out.print("Masukkan alamat pegawai: ");
        alamat = input.nextLine();

        do {
            System.out.print("Masukkan golongan: ");
            gol = input.nextInt();

            if (gol < 1 || gol > 4)
                System.out.println("Golongan harus 1-4!");

        } while (gol < 1 || gol > 4);

        data.setNIP(NIP);
        data.setNama(nama);
        data.setAlamat(alamat);
        data.setGol(gol);

        input.nextLine();
    }

    public void inputWaktuLuar(Waktu waktu, String keterangan) {
        System.out.println();
        System.out.println("=== " + keterangan + " ===");

        int jam, menit, detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24)
                System.out.println("Jam harus 0-23.");

        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60)
                System.out.println("Menit harus 0-59.");

        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60)
                System.out.println("Detik harus 0-59.");

        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
        input.nextLine();
    }

    public void cetakHeader(String judul) {
        System.out.println();
        System.out.println("=== " + judul + " ===");
        System.out.println("-".repeat(180));

        System.out.printf(
            "%-4s%-10s%-14s%-20s%-5s%-10s%-10s%-10s%-12s%-15s%-12s%-15s%-12s%n",
            "No", "NIP", "Nama", "Alamat", "Gol",
            "Datang", "Pulang", "Lama", "Jam Lembur",
            "Gaji Harian", "Lembur", "Total", "Status"
        );

        System.out.println("-".repeat(180));
    }

    public void cetakTabelData(ArrayPegawai kumpulan, String judul) {
        cetakHeader(judul);

        for (int i = 0; i < kumpulan.getJumlah(); i++) {
            Pegawai data = kumpulan.getPegawai(i);
            Waktu datang = kumpulan.getWaktuDatang(i);
            Waktu pulang = kumpulan.getWaktuPulang(i);

            data.cetakPegawai(datang, pulang, i + 1);
        }

        System.out.println("-".repeat(180));
    }

    public void cetakRingkasan(ArrayPegawai kumpulan) {
        int jumlah = kumpulan.getJumlah();

        if (jumlah == 0)
            return;

        int totalSemua = 0;
        int gajiTertinggi = kumpulan.hitungGajiPadaIndex(0);
        int gajiTerendah = kumpulan.hitungGajiPadaIndex(0);

        String pegawaiTertinggi = kumpulan.getPegawai(0).getNama();
        String pegawaiTerendah = kumpulan.getPegawai(0).getNama();

        for (int i = 0; i < jumlah; i++) {
            Pegawai data = kumpulan.getPegawai(i);
            int gaji = kumpulan.hitungGajiPadaIndex(i);

            totalSemua += gaji;

            if (gaji > gajiTertinggi) {
                gajiTertinggi = gaji;
                pegawaiTertinggi = data.getNama();
            }

            if (gaji < gajiTerendah) {
                gajiTerendah = gaji;
                pegawaiTerendah = data.getNama();
            }
        }

        Pegawai format = new Pegawai();

        int rataRata = (int) ((double) totalSemua / jumlah + 0.5);

        System.out.println(
            "Rata-rata Gaji  : Rp " + format.formatRibuan(rataRata)
        );

        System.out.println(
            "Gaji Tertinggi  : Rp " + format.formatRibuan(gajiTertinggi)
            + " - " + pegawaiTertinggi
        );

        System.out.println(
            "Gaji Terendah   : Rp " + format.formatRibuan(gajiTerendah)
            + " - " + pegawaiTerendah
        );
    }

    public void cetakLaporan(ArrayPegawai kumpulan, String judul) {
        if (kumpulan.getJumlah() == 0) {
            System.out.println("Belum ada data pegawai.");
            return;
        }

        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println(
            " DAFTAR GAJI HARIAN PT INFORMATIKA - " + judul
        );
        System.out.println("=".repeat(60));

        cetakTabelData(kumpulan, "TABEL UTAMA (URUTAN INPUT)");

        cetakTabelData(
            kumpulan.sortingAscending(),
            "TABEL ASCENDING (GAJI TOTAL TERKECIL KE TERBESAR)"
        );

        cetakTabelData(
            kumpulan.sortingDescending(),
            "TABEL DESCENDING (GAJI TOTAL TERBESAR KE TERKECIL)"
        );

        System.out.println();
        System.out.println("=== STATISTIK GAJI ===");
        cetakRingkasan(kumpulan);
    }

    public void constructor() {
        System.out.println();
        System.out.println("=== CONSTRUCTOR BERPAMETER ===");

        ArrayPegawai kumpulanConstructor = new ArrayPegawai();

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Syifa", "012", 3, "Bandung"),
            new Waktu(8, 0, 0),
            new Waktu(17, 15, 10)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Amela", "051", 2, "Sumedang"),
            new Waktu(8, 0, 0),
            new Waktu(19, 30, 10)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Atika", "093", 4, "Bandung"),
            new Waktu(8, 0, 0),
            new Waktu(14, 0, 10)
        );

        cetakLaporan(kumpulanConstructor, "CONSTRUCTOR BERPAMETER");
    }

    public void setter() {
        System.out.println();
        System.out.println("=== SETTER ===");

        ArrayPegawai kumpulanSetter = new ArrayPegawai();

        Pegawai p1 = new Pegawai();
        Waktu datang1 = new Waktu();
        Waktu pulang1 = new Waktu();

        p1.setNIP("001");
        p1.setNama("Doni");
        p1.setAlamat("Bandung");
        p1.setGol(2);

        datang1.setWaktu(8, 0, 0);
        pulang1.setWaktu(16, 30, 0);

        Pegawai p2 = new Pegawai();
        Waktu datang2 = new Waktu();
        Waktu pulang2 = new Waktu();

        p2.setPegawai("Tari", "002", 1, "Sumedang");

        datang2.setWaktu(22, 0, 0);
        pulang2.setWaktu(7, 0, 0);

        Pegawai p3 = new Pegawai();
        Waktu datang3 = new Waktu();
        Waktu pulang3 = new Waktu();

        p3.setPegawai("Iqbal", "003", 4, "Garut");

        datang3.setWaktu(7, 30, 0);
        pulang3.setWaktu(16, 0, 0);

        kumpulanSetter.tambahPegawai(p1, datang1, pulang1);
        kumpulanSetter.tambahPegawai(p2, datang2, pulang2);
        kumpulanSetter.tambahPegawai(p3, datang3, pulang3);

        cetakLaporan(kumpulanSetter, "SETTER");
    }

    public void inputDalam() {
        System.out.println();
        System.out.println("=== INPUT DALAM ===");

        ArrayPegawai kumpulanDalam = new ArrayPegawai();
        int banyak;

        do {
            System.out.print("Masukkan jumlah pegawai (maksimal 10): ");
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10)
                System.out.println("Jumlah pegawai harus 1-10!");

        } while (banyak < 1 || banyak > 10);

        input.nextLine();

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===== PEGAWAI KE-" + (i + 1) + " =====");

            Pegawai pegawai = new Pegawai();
            Waktu datang = new Waktu();
            Waktu pulang = new Waktu();

            pegawai.inputPegawai(input);

            System.out.println();
            System.out.println("=== WAKTU DATANG ===");
            datang.inputWaktu(input);

            System.out.println();
            System.out.println("=== WAKTU PULANG ===");
            pulang.inputWaktu(input);

            kumpulanDalam.tambahPegawai(pegawai, datang, pulang);
        }

        cetakLaporan(kumpulanDalam, "INPUT DALAM");
    }

    public void inputLuar() {
        System.out.println();
        System.out.println("=== INPUT LUAR ===");

        ArrayPegawai kumpulanLuar = new ArrayPegawai();
        int banyak;

        do {
            System.out.print("Masukkan jumlah pegawai (maksimal 10): ");
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10)
                System.out.println("Jumlah pegawai harus 1-10!");

        } while (banyak < 1 || banyak > 10);

        input.nextLine();

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===== PEGAWAI KE-" + (i + 1) + " =====");

            Pegawai data = new Pegawai();
            Waktu waktuDatang = new Waktu();
            Waktu waktuPulang = new Waktu();

            inputPegawaiLuar(data);
            inputWaktuLuar(waktuDatang, "WAKTU DATANG");
            inputWaktuLuar(waktuPulang, "WAKTU PULANG");

            kumpulanLuar.tambahPegawai(data, waktuDatang, waktuPulang);
        }

        cetakLaporan(kumpulanLuar, "INPUT LUAR");
    }

    public void constructorParkir() {
        System.out.println();
        System.out.println("=== CONSTRUCTOR BERPAMETER PARKIR ===");

        ArrayParkir dataParkir = new ArrayParkir();

        dataParkir.tambahParkir(
            new Mobil(
                "D 1234 AB", "Amela", "051", "Pegawai",
                new Waktu(8, 0, 0), new Waktu(17, 0, 0), 4
            )
        );

        dataParkir.tambahParkir(
            new Truk(
                "D 5678 CD", "", "", "Umum",
                new Waktu(9, 0, 0), new Waktu(15, 30, 0), 10
            )
        );

        dataParkir.tambahParkir(
            new Motor(
                "D 9012 EF", "Atika", "093", "Pegawai",
                new Waktu(7, 0, 0), new Waktu(16, 0, 0), 4
            )
        );

        dataParkir.cetakLaporan();
    }

    public void setterParkir() {
        System.out.println();
        System.out.println("=== SETTER PARKIR ===");

        ArrayParkir dataParkir = new ArrayParkir();

        Mobil mobil = new Mobil();
        mobil.setMobil(
            "D 1111 AA", "Doni", "001", "Pegawai",
            new Waktu(8, 0, 0), new Waktu(17, 0, 0), 4
        );

        Truk truk = new Truk();
        truk.setTruk(
            "D 2222 BB", "", "", "Umum",
            new Waktu(9, 0, 0), new Waktu(16, 0, 0), 8
        );

        Motor motor = new Motor();
        motor.setMotor(
            "D 3333 CC", "Tari", "002", "Pegawai",
            new Waktu(7, 0, 0), new Waktu(15, 0, 0), 2
        );

        dataParkir.tambahParkir(mobil);
        dataParkir.tambahParkir(truk);
        dataParkir.tambahParkir(motor);

        dataParkir.cetakLaporan();
    }

    public void inputDalamParkir() {
        System.out.println();
        System.out.println("=== INPUT DALAM PARKIR ===");

        ArrayParkir dataParkir = new ArrayParkir();
        int banyak;

        do {
            System.out.print("Masukkan jumlah kendaraan (1-10): ");
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10)
                System.out.println("Jumlah kendaraan harus 1-10!");

        } while (banyak < 1 || banyak > 10);

        input.nextLine();

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===== KENDARAAN KE-" + (i + 1) + " =====");

            int jenis;

            do {
                System.out.print(
                    "Jenis kendaraan (1. Mobil  2. Truk  3. Motor): "
                );
                jenis = input.nextInt();

                if (jenis < 1 || jenis > 3)
                    System.out.println("Pilihan tidak valid!");

            } while (jenis < 1 || jenis > 3);

            input.nextLine();

            Kendaraan baru;

            if (jenis == 1)
                baru = new Mobil();
            else if (jenis == 2)
                baru = new Truk();
            else
                baru = new Motor();

            baru.inputKendaraan(input);
            dataParkir.tambahParkir(baru);
        }

        dataParkir.cetakLaporan();
    }

    public void inputLuarParkir() {
        System.out.println();
        System.out.println("=== INPUT LUAR PARKIR ===");

        ArrayParkir dataParkir = new ArrayParkir();
        int banyak;

        do {
            System.out.print("Masukkan jumlah kendaraan (1-10): ");
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10)
                System.out.println("Jumlah kendaraan harus 1-10!");

        } while (banyak < 1 || banyak > 10);

        input.nextLine();

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===== KENDARAAN KE-" + (i + 1) + " =====");

            String nomor, nama = "", nip = "";
            String status;
            int pengguna, jenis, ciri;

            System.out.print("Nomor polisi: ");
            nomor = input.nextLine();

            do {
                System.out.print("Jenis pengguna (1. Umum  2. Pegawai): ");
                pengguna = input.nextInt();

                if (pengguna < 1 || pengguna > 2)
                    System.out.println("Pilihan tidak valid!");

            } while (pengguna < 1 || pengguna > 2);

            input.nextLine();

            status = (pengguna == 2) ? "Pegawai" : "Umum";

            if (status.equals("Pegawai")) {
                System.out.print("Nama pegawai: ");
                nama = input.nextLine();

                System.out.print("NIP pegawai: ");
                nip = input.nextLine();
            }

            do {
                System.out.print(
                    "Jenis kendaraan (1. Mobil  2. Truk  3. Motor): "
                );
                jenis = input.nextInt();

                if (jenis < 1 || jenis > 3)
                    System.out.println("Pilihan tidak valid!");

            } while (jenis < 1 || jenis > 3);

            if (jenis == 1) {
                do {
                    System.out.print("Jumlah pintu mobil: ");
                    ciri = input.nextInt();

                    if (ciri < 2 || ciri > 6)
                        System.out.println("Jumlah pintu harus 2-6!");

                } while (ciri < 2 || ciri > 6);

            } else if (jenis == 2) {
                do {
                    System.out.print("Jumlah roda truk: ");
                    ciri = input.nextInt();

                    if (ciri < 4 || ciri > 18)
                        System.out.println("Jumlah roda harus 4-18!");

                } while (ciri < 4 || ciri > 18);

            } else {
                do {
                    System.out.print("Jenis mesin motor (2 atau 4 tak): ");
                    ciri = input.nextInt();

                    if (ciri != 2 && ciri != 4)
                        System.out.println("Isi 2 atau 4!");

                } while (ciri != 2 && ciri != 4);
            }

            input.nextLine();

            Waktu masuk = new Waktu();
            Waktu keluar = new Waktu();

            inputWaktuLuar(masuk, "WAKTU MASUK");
            inputWaktuLuar(keluar, "WAKTU KELUAR");

            Kendaraan baru;

            if (jenis == 1) {
                baru = new Mobil(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            } else if (jenis == 2) {
                baru = new Truk(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            } else {
                baru = new Motor(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            }

            dataParkir.tambahParkir(baru);
        }

        dataParkir.cetakLaporan();
    }

    public void menuUtama() {
        do {
            System.out.println();
            System.out.println("========== MENU UTAMA ==========");
            System.out.println("1. Program Pegawai");
            System.out.println("2. Program Parkir");
            System.out.println("3. Keluar");
            System.out.println("================================");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    menuPegawai();
                    break;

                case 2:
                    menuParkir();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 3);
    }

    public void menuPegawai() {
        int pilih;

        do {
            System.out.println();
            System.out.println("========== PROGRAM PEGAWAI ==========");
            System.out.println("1. Constructor Berparameter");
            System.out.println("2. Setter");
            System.out.println("3. Input Dalam");
            System.out.println("4. Input Luar");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("=====================================");
            System.out.print("Pilih menu: ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    constructor();
                    break;

                case 2:
                    setter();
                    break;

                case 3:
                    inputDalam();
                    break;

                case 4:
                    inputLuar();
                    break;

                case 5:
                    System.out.println("Kembali ke Menu Utama...");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilih != 5);
    }

    public void menuParkir() {
        int pilih;

        do {
            System.out.println();
            System.out.println("========== PROGRAM PARKIR ==========");
            System.out.println("1. Constructor Berparameter");
            System.out.println("2. Setter");
            System.out.println("3. Input Dalam");
            System.out.println("4. Input Luar");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("====================================");
            System.out.print("Pilih menu: ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    constructorParkir();
                    break;

                case 2:
                    setterParkir();
                    break;

                case 3:
                    inputDalamParkir();
                    break;

                case 4:
                    inputLuarParkir();
                    break;

                case 5:
                    System.out.println("Kembali ke Menu Utama...");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilih != 5);
    }
}

public class GajiPegawai_250012_250051_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menuUtama();
    }
}