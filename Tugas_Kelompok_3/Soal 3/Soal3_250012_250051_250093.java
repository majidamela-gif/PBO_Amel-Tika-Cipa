/*
Nama Program : Program Gaji OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 14 Oktober 2026
Deskripsi    : Buatlah program OOP Array of Object untuk mencari gaji harian da lembur berdasarkan lama kerja pegawai dgn aturan sbb:
                • Input : NIP, nama, gol, waktu datang, waktu pulang
                • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
                    Gol     gaji harian     lembur >= 8 jam kerja
                    1       150 rb          50.000 /jam
                    2       200 rb          75.000 /jam
                    3       400 rb          150.000 /jam
                    4       500 rb          200.000 /jam
                • Proses : gaji Harian = gapok + lembur
                • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
                • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
                Buat tampilan Output tabel
                Buat 4 class (Waktu, Pegawai, Array of Pegawai dan Menu yang masing-masing memiliki constructor, method input-proses-output) selain class utama
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
        setWaktu(jam, menit, detik);
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

    public void setJam(int jam) {
        if (jam >= 0 && jam < 24) {
            this.jam = jam;
        } else {
            this.jam = 0;
            System.out.println("Jam harus 0-23.");
        }
    }

    public void setMenit(int menit) {
        if (menit >= 0 && menit < 60) {
            this.menit = menit;
        } else {
            this.menit = 0;
            System.out.println("Menit harus 0-59.");
        }
    }

    public void setDetik(int detik) {
        if (detik >= 0 && detik < 60) {
            this.detik = detik;
        } else {
            this.detik = 0;
            System.out.println("Detik harus 0-59.");
        }
    }

    public void setWaktu(int jam, int menit, int detik) {
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }

    public void inputWaktu(Scanner input) {
        int jam;
        int menit;
        int detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24) {
                System.out.println("Jam harus 0-23.");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60) {
                System.out.println("Menit harus 0-59.");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60) {
                System.out.println("Detik harus 0-59.");
            }
        } while (detik < 0 || detik >= 60);

        setWaktu(jam, menit, detik);
        input.nextLine();
    }

    public int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    public void selisihVoid(Waktu A, Waktu B) {
        int totalA = A.konvertDetik();
        int totalB = B.konvertDetik();
        int selisih;

        if (totalA >= totalB) {
            selisih = totalA - totalB;
        } else {
            selisih = totalB - totalA;
        }

        jam = selisih / 3600;
        menit = (selisih % 3600) / 60;
        detik = selisih % 60;
    }

    public Waktu selisihReturn(Waktu A) {
        Waktu selisih = new Waktu();
        int totalA = A.konvertDetik();
        int totalThis = konvertDetik();
        int hasil;

        if (totalA >= totalThis) {
            hasil = totalA - totalThis;
        } else {
            hasil = totalThis - totalA;
        }

        selisih.jam = hasil / 3600;
        selisih.menit = (hasil % 3600) / 60;
        selisih.detik = hasil % 60;

        return selisih;
    }

    public void cetakWaktu() {
        System.out.printf("%02d:%02d:%02d", jam, menit, detik);
    }
}

class Pegawai {
    private String nama;
    private String NIP;
    private int gol;

    public Pegawai() {
        nama = "";
        NIP = "";
        gol = 0;
    }

    public Pegawai(String nama, String NIP, int gol) {
        this.nama = nama;
        this.NIP = NIP;
        this.gol = gol;
    }

    public String getNama() {
        return nama;
    }

    public String getNIP() {
        return NIP;
    }

    public int getGol() {
        return gol;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public void setPegawai(String nama, String NIP, int gol) {
        this.nama = nama;
        this.NIP = NIP;
        this.gol = gol;
    }

    public void inputPegawai(Scanner input) {
        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

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
        int gaji = 0;

        if (gol == 1) {
            gaji = 150000;
        } else if (gol == 2) {
            gaji = 200000;
        } else if (gol == 3) {
            gaji = 400000;
        } else if (gol == 4) {
            gaji = 500000;
        }

        return gaji;
    }

    public int hitungLembur() {
        int lembur = 0;

        if (gol == 1) {
            lembur = 50000;
        } else if (gol == 2) {
            lembur = 75000;
        } else if (gol == 3) {
            lembur = 150000;
        } else if (gol == 4) {
            lembur = 200000;
        }

        return lembur;
    }

    public Waktu hitungLamaKerja(Waktu datang, Waktu pulang) {
        int totalDatang = datang.konvertDetik();
        int totalPulang = pulang.konvertDetik();

        if (totalPulang < totalDatang) {
            totalPulang = totalPulang + (24 * 3600);
        }

        int selisih = totalPulang - totalDatang;
        int jam = selisih / 3600;
        int menit = (selisih % 3600) / 60;
        int detik = selisih % 60;

        return new Waktu(jam, menit, detik);
    }

    public int hitungJamKerja(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        return lama.getJam();
    }

    public int hitungJamLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();

        if (totalDetik < (9 * 3600)) {
            return 0;
        }

        int detikLembur = totalDetik - (8 * 3600);
        return detikLembur / 3600;
    }

    public Waktu hitungLamaLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();

        if (totalDetik < (9 * 3600)) {
            return new Waktu(0, 0, 0);
        }

        int detikLembur = totalDetik - (8 * 3600);
        int jam = detikLembur / 3600;
        int menit = (detikLembur % 3600) / 60;
        int detik = detikLembur % 60;

        return new Waktu(jam, menit, detik);
    }

    public int hitungGajiLembur(Waktu datang, Waktu pulang) {
        return hitungJamLembur(datang, pulang) * hitungLembur();
    }

    public int hitungGajiTotal(Waktu datang, Waktu pulang) {
        return hitungGajiHarian() + hitungGajiLembur(datang, pulang);
    }

    public String hitungStatus(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        if (lama.konvertDetik() < (8 * 3600)) {
            return "Peringatan";
        }

        return "OK";
    }

    public String formatRibuan(int angka) {
        String strAngka = String.valueOf(angka);
        String hasil = "";
        int hitung = 0;

        for (int i = strAngka.length() - 1; i >= 0; i--) {
            hasil = strAngka.charAt(i) + hasil;
            hitung++;

            if (hitung % 3 == 0 && i > 0) {
                hasil = "." + hasil;
            }
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
        Waktu lamaKerja = hitungLamaKerja(datang, pulang);

        System.out.printf(
            "%-4d%-10s%-12s%-5d%-10s%-10s%-10s%-12s%-15s%-12s%-15s%-12s%n",
            no,
            getNIP(),
            getNama(),
            getGol(),
            formatWaktu(datang),
            formatWaktu(pulang),
            formatWaktu(lamaKerja),
            formatWaktu(hitungLamaLembur(datang, pulang)),
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

        for (int i = 0; i < 10; i++) {
            data[i] = new Pegawai();
            waktuDatang[i] = new Waktu();
            waktuPulang[i] = new Waktu();
        }
    }

    public int getJumlah() {
        return jumlah;
    }

    public Pegawai getPegawai(int index) {
        return data[index];
    }

    public Waktu getWaktuDatang(int index) {
        return waktuDatang[index];
    }

    public Waktu getWaktuPulang(int index) {
        return waktuPulang[index];
    }

    public void tambahPegawai(
        Pegawai pegawai,
        Waktu datang,
        Waktu pulang
    ) {
        if (jumlah < 10) {
            data[jumlah] = pegawai;
            waktuDatang[jumlah] = datang;
            waktuPulang[jumlah] = pulang;
            jumlah++;
        } else {
            System.out.println("Array pegawai sudah penuh!");
        }
    }
}

class Menu {
    private int pilihan;
    private final Scanner input;
    private ArrayPegawai kumpulan;

    public Menu() {
        pilihan = 0;
        input = new Scanner(System.in);
        kumpulan = new ArrayPegawai();
    }

    public int getPilihan() {
        return pilihan;
    }

    public void inputPegawaiLuar(Pegawai data) {
        String NIP;
        String nama;
        int gol;

        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

        do {
            System.out.print("Masukkan golongan: ");
            gol = input.nextInt();

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan harus 1-4!");
            }
        } while (gol < 1 || gol > 4);

        data.setNIP(NIP);
        data.setNama(nama);
        data.setGol(gol);

        input.nextLine();
    }

    public void inputWaktuLuar(Waktu waktu, String keterangan) {
        System.out.println();
        System.out.println("=== " + keterangan + " ===");

        int jam;
        int menit;
        int detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24) {
                System.out.println("Jam harus 0-23.");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60) {
                System.out.println("Menit harus 0-59.");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60) {
                System.out.println("Detik harus 0-59.");
            }
        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
        input.nextLine();
    }

    public void cetakHeader() {
        System.out.println();
        System.out.println(
            "                 Daftar Gaji Harian PT Informatika"
        );
        System.out.println();

        System.out.println("-".repeat(140));

        System.out.printf(
            "%-4s%-10s%-12s%-5s%-10s%-10s%-10s%-12s%-15s%-12s%-15s%-12s%n",
            "No",
            "NIP",
            "Nama",
            "Gol",
            "Datang",
            "Pulang",
            "Lama",
            "Jam Lembur",
            "Gaji Harian",
            "Lembur",
            "Total",
            "Status"
        );

        System.out.println("-".repeat(140));
    }

    public void cetakTabel() {
        if (kumpulan.getJumlah() == 0) {
            System.out.println("Belum ada data pegawai.");
            return;
        }

        cetakHeader();

        for (int i = 0; i < kumpulan.getJumlah(); i++) {
            Pegawai data = kumpulan.getPegawai(i);
            Waktu datang = kumpulan.getWaktuDatang(i);
            Waktu pulang = kumpulan.getWaktuPulang(i);

            data.cetakPegawai(datang, pulang, i + 1);
        }

        System.out.println("-".repeat(140));
    }

    public void constructor() {
        System.out.println();
        System.out.println("=== CONSTRUCTOR BERPAMETER ===");

        ArrayPegawai kumpulanConstructor = new ArrayPegawai();

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Syifa", "012", 2),
            new Waktu(8, 20, 3),
            new Waktu(18, 20, 10)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Amela", "051", 3),
            new Waktu(7, 45, 0),
            new Waktu(17, 10, 0)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Atika", "093", 4),
            new Waktu(8, 55, 21),
            new Waktu(14, 5, 10)
        );

        System.out.println();

        if (kumpulanConstructor.getJumlah() > 0) {
            cetakHeader();

            for (int i = 0;
                 i < kumpulanConstructor.getJumlah(); i++) {

                Pegawai data = kumpulanConstructor.getPegawai(i);
                Waktu datang = kumpulanConstructor.getWaktuDatang(i);
                Waktu pulang = kumpulanConstructor.getWaktuPulang(i);

                data.cetakPegawai(datang, pulang, i + 1);
            }

            System.out.println("-".repeat(140));
        }
    }

    public void setter() {
        System.out.println();
        System.out.println("=== SETTER ===");

        ArrayPegawai kumpulanSetter = new ArrayPegawai();

        Pegawai p1 = new Pegawai();
        Waktu datang1 = new Waktu();
        Waktu pulang1 = new Waktu();

        p1.setNIP("001");
        p1.setNama("Athian");
        p1.setGol(2);
        datang1.setWaktu(7, 10, 13);
        pulang1.setWaktu(18, 6, 34);

        Pegawai p2 = new Pegawai();
        Waktu datang2 = new Waktu();
        Waktu pulang2 = new Waktu();

        p2.setPegawai("Nabila", "002", 1);
        datang2.setWaktu(21, 5, 0);
        pulang2.setWaktu(7, 0, 3);

        Pegawai p3 = new Pegawai();
        Waktu datang3 = new Waktu();
        Waktu pulang3 = new Waktu();

        p3.setPegawai("Zeus", "003", 4);
        datang3.setWaktu(10, 30, 0);
        pulang3.setWaktu(16, 45, 0);

        kumpulanSetter.tambahPegawai(p1, datang1, pulang1);
        kumpulanSetter.tambahPegawai(p2, datang2, pulang2);
        kumpulanSetter.tambahPegawai(p3, datang3, pulang3);

        cetakHeader();

        for (int i = 0; i < kumpulanSetter.getJumlah(); i++) {
            Pegawai data = kumpulanSetter.getPegawai(i);
            Waktu datang = kumpulanSetter.getWaktuDatang(i);
            Waktu pulang = kumpulanSetter.getWaktuPulang(i);

            data.cetakPegawai(datang, pulang, i + 1);
        }

        System.out.println("-".repeat(140));
    }

    public void inputDalam() {
        System.out.println();
        System.out.println("=== INPUT DALAM ===");

        int banyak;

        do {
            System.out.print(
                "Masukkan jumlah pegawai (maksimal 10): "
            );
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10) {
                System.out.println("Jumlah pegawai harus 1-10!");
            }
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

            kumpulan.tambahPegawai(pegawai, datang, pulang);
        }

        cetakTabel();
    }

    public void inputLuar() {
        System.out.println();
        System.out.println("=== INPUT LUAR ===");

        int banyak;

        do {
            System.out.print(
                "Masukkan jumlah pegawai (maksimal 10): "
            );
            banyak = input.nextInt();

            if (banyak < 1 || banyak > 10) {
                System.out.println("Jumlah pegawai harus 1-10!");
            }
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

            kumpulan.tambahPegawai(
                data, waktuDatang, waktuPulang
            );
        }

        cetakTabel();
    }

    public void tampilkanMenu() {
        System.out.println();
        System.out.println("===== MENU GAJI PEGAWAI =====");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Input Luar");
        System.out.println("5. Keluar");
        System.out.println("=============================");
        System.out.print("Pilih menu: ");

        pilihan = input.nextInt();
        input.nextLine();
    }

    public void prosesMenu() {
        switch (pilihan) {
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
                System.out.println();
                System.out.println("Program selesai.");
                break;

            default:
                System.out.println();
                System.out.println("Pilihan tidak tersedia!");
        }
    }
}

public class Soal3_250012_250051_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
}
