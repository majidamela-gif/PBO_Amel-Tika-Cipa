/*
Nama Program : Program Gaji OOP dengan Class Person
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 27 Oktober 2026
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
                  Tabel Gaji Ascending
                  Tabel Gaji Descending
                  Rata-rata Gaji : ---
                  Gaji Tertinggi :
                  Gaji Terendah :
               Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output) selain class Utama
*/


import java.util.Scanner;

class Waktu {
    private int jam;
    private int menit;
    private int detik;

    public Waktu() {
        jam = 0;
        menit = 0;
        detik = 0;
    }

    public Waktu(int jam, int menit, int detik) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    public int getJam() {
        return jam;
    }

    public int getMenit() {
        return menit;
    }

    public int getDetik() {
        return detik;
    }

    public void setWaktu(int jam, int menit, int detik) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    public int konversiDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", jam, menit, detik);
    }

    public static Waktu dariDetik(int totalDetik) {
        int jam = totalDetik / 3600;
        int menit = (totalDetik % 3600) / 60;
        int detik = totalDetik % 60;

        return new Waktu(jam, menit, detik);
    }

    public static Waktu selisih(Waktu datang, Waktu pulang) {
        int totalDatang = datang.konversiDetik();
        int totalPulang = pulang.konversiDetik();

        if (totalPulang < totalDatang) {
            totalPulang += 24 * 3600;
        }

        return dariDetik(totalPulang - totalDatang);
    }

    public void inputWaktu(Scanner input, String keterangan) {
        int jam;
        int menit;
        int detik;

        System.out.println(keterangan);

        do {
            System.out.print("Jam (0-23): ");
            jam = input.nextInt();
        } while (jam < 0 || jam > 23);

        do {
            System.out.print("Menit (0-59): ");
            menit = input.nextInt();
        } while (menit < 0 || menit > 59);

        do {
            System.out.print("Detik (0-59): ");
            detik = input.nextInt();
        } while (detik < 0 || detik > 59);

        setWaktu(jam, menit, detik);
        input.nextLine();
    }
}

class Person {
    private String nama;
    private String alamat;

    public Person() {
        nama = "";
        alamat = "";
    }

    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void inputPerson(Scanner input) {
        System.out.print("Nama: ");
        nama = input.nextLine();

        System.out.print("Alamat: ");
        alamat = input.nextLine();
    }
}

class Pegawai extends Person {
    private String NIP;
    private int gol;
    private Waktu datang;
    private Waktu pulang;

    public Pegawai() {
        super();
        NIP = "";
        gol = 1;
        datang = new Waktu();
        pulang = new Waktu();
    }

    public Pegawai(String NIP, String nama, String alamat,
                   int gol, Waktu datang, Waktu pulang) {
        super(nama, alamat);
        this.NIP = NIP;
        this.gol = gol;
        this.datang = datang;
        this.pulang = pulang;
    }

    public String getNIP() {
        return NIP;
    }

    public int getGol() {
        return gol;
    }

    public Waktu getDatang() {
        return datang;
    }

    public Waktu getPulang() {
        return pulang;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setGol(int gol) {
        if (gol >= 1 && gol <= 4) {
            this.gol = gol;
        }
    }

    public void setDatang(Waktu datang) {
        this.datang = datang;
    }

    public void setPulang(Waktu pulang) {
        this.pulang = pulang;
    }

    public void inputPegawai(Scanner input) {
        System.out.print("NIP: ");
        NIP = input.nextLine();

        inputPerson(input);

        do {
            System.out.print("Golongan (1-4): ");
            gol = input.nextInt();

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan harus 1-4.");
            }
        } while (gol < 1 || gol > 4);

        input.nextLine();

        datang.inputWaktu(input, "Waktu datang");
        pulang.inputWaktu(input, "Waktu pulang");
    }

    public int hitungGajiHarian() {
        switch (gol) {
            case 1:
                return 150000;
            case 2:
                return 200000;
            case 3:
                return 400000;
            case 4:
                return 500000;
            default:
                return 0;
        }
    }

    public int tarifLembur() {
        switch (gol) {
            case 1:
                return 50000;
            case 2:
                return 75000;
            case 3:
                return 150000;
            case 4:
                return 200000;
            default:
                return 0;
        }
    }

    public Waktu hitungLamaKerja() {
        return Waktu.selisih(datang, pulang);
    }

    public int hitungJamLembur() {
        int lamaDetik = hitungLamaKerja().konversiDetik();
        int batasDetik = 8 * 3600;

        if (lamaDetik < 9 * 3600) {
            return 0;
        }

        return (lamaDetik - batasDetik) / 3600;
    }

    public Waktu hitungLamaLembur() {
        int lamaDetik = hitungLamaKerja().konversiDetik();

        if (lamaDetik < 9 * 3600) {
            return new Waktu();
        }

        return Waktu.dariDetik(lamaDetik - 8 * 3600);
    }

    public int hitungGajiLembur() {
        return hitungJamLembur() * tarifLembur();
    }

    public int hitungTotalGaji() {
        return hitungGajiHarian() + hitungGajiLembur();
    }

    public String hitungStatus() {
        if (hitungLamaKerja().konversiDetik() < 8 * 3600) {
            return "PERINGATAN";
        }

        return "OK";
    }

    public String formatRupiah(int angka) {
        return String.format("%,d", angka).replace(',', '.');
    }

    public void cetakPegawai(int nomor) {
        System.out.printf(
            "%-4d %-8s %-12s %-12s %-4d %-10s %-10s %-10s %-12s %-12s %-12s %-12s %-12s%n",
            nomor,
            NIP,
            getNama(),
            getAlamat(),
            gol,
            datang,
            pulang,
            hitungLamaKerja(),
            hitungLamaLembur(),
            formatRupiah(hitungGajiHarian()),
            formatRupiah(hitungGajiLembur()),
            formatRupiah(hitungTotalGaji()),
            hitungStatus()
        );
    }
}

class ArrayPegawai {
    private Pegawai[] data;
    private int jumlah;

    public ArrayPegawai() {
        data = new Pegawai[10];
        jumlah = 0;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Pegawai getPegawai(int index) {
        if (index >= 0 && index < jumlah) {
            return data[index];
        }

        return null;
    }

    public boolean tambahPegawai(Pegawai pegawai) {
        if (jumlah >= data.length) {
            System.out.println("Array pegawai sudah penuh.");
            return false;
        }

        data[jumlah] = pegawai;
        jumlah++;
        return true;
    }

    public int hitungTotalGaji() {
        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            total += data[i].hitungTotalGaji();
        }

        return total;
    }

    public int hitungGajiTertinggi() {
        if (jumlah == 0) {
            return 0;
        }

        int tertinggi = data[0].hitungTotalGaji();

        for (int i = 1; i < jumlah; i++) {
            if (data[i].hitungTotalGaji() > tertinggi) {
                tertinggi = data[i].hitungTotalGaji();
            }
        }

        return tertinggi;
    }

    public int hitungGajiTerendah() {
        if (jumlah == 0) {
            return 0;
        }

        int terendah = data[0].hitungTotalGaji();

        for (int i = 1; i < jumlah; i++) {
            if (data[i].hitungTotalGaji() < terendah) {
                terendah = data[i].hitungTotalGaji();
            }
        }

        return terendah;
    }

    public void cetakTabel() {
        if (jumlah == 0) {
            System.out.println("Belum ada data pegawai.");
            return;
        }

        System.out.println();
        System.out.println("DAFTAR GAJI HARIAN PT INFORMATIKA");
        System.out.println("=".repeat(151));

        System.out.printf(
            "%-4s %-8s %-12s %-12s %-4s %-10s %-10s %-10s %-12s %-12s %-12s %-12s %-12s%n",
            "No", "NIP", "Nama", "Alamat", "Gol",
            "Datang", "Pulang", "Lama", "Jam Lembur",
            "Gaji Harian", "Lembur", "Total", "Status"
        );

        System.out.println("-".repeat(151));

        for (int i = 0; i < jumlah; i++) {
            data[i].cetakPegawai(i + 1);
        }

        System.out.println("=".repeat(151));

        Pegawai pegawai = data[0];

        System.out.println("Rata-rata Gaji : "
            + pegawai.formatRupiah(hitungTotalGaji() / jumlah));

        System.out.println("Gaji Tertinggi : "
            + pegawai.formatRupiah(hitungGajiTertinggi()));

        System.out.println("Gaji Terendah  : "
            + pegawai.formatRupiah(hitungGajiTerendah()));
    }
}

class Menu {
    private Scanner input;
    private ArrayPegawai daftar;

    public Menu() {
        input = new Scanner(System.in);
        daftar = new ArrayPegawai();
    }

    public void inputData() {
        int banyak;

        do {
            System.out.print("Jumlah pegawai (1-10): ");
            banyak = input.nextInt();
            input.nextLine();

            if (banyak < 1 || banyak > 10) {
                System.out.println("Jumlah harus antara 1-10.");
            }
        } while (banyak < 1 || banyak > 10);

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("Data pegawai ke-" + (i + 1));

            Pegawai pegawai = new Pegawai();
            pegawai.inputPegawai(input);

            daftar.tambahPegawai(pegawai);
        }
    }

    public void prosesMenu() {
        int pilihan;

        do {
            System.out.println();
            System.out.println("===== MENU GAJI PEGAWAI =====");
            System.out.println("1. Input data pegawai");
            System.out.println("2. Tampilkan daftar gaji");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    inputData();
                    break;

                case 2:
                    daftar.cetakTabel();
                    break;

                case 3:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
    }
}

public class GajiPegawai_250012_250041_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.prosesMenu();
    }
}
