/*
Nama Program : Program Gaji OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 07 Oktober 2026
Deskripsi    : Buatlah program OOP untuk mencari gaji harian da lembur berdasarkan lama kerja pegawai dgn aturan sbb:
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
                Buat 2 class (Waktu dan Pegawai)
                • Waktu (atribut, Method (constructor, input-proses-output)
                • Pegawai ( atribut, Method (constructor, input-proses-output)
                Utama : pakai menu d minimal 3 object
                menu dipisah Class nya
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
            System.out.println("Jam harus 0-23!");
        }
    }

    public void setMenit(int menit) {
        if (menit >= 0 && menit < 60) {
            this.menit = menit;
        } else {
            this.menit = 0;
            System.out.println("Menit harus 0-59!");
        }
    }

    public void setDetik(int detik) {
        if (detik >= 0 && detik < 60) {
            this.detik = detik;
        } else {
            this.detik = 0;
            System.out.println("Detik harus 0-59!");
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
                System.out.println("Jam harus 0-23!");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60) {
                System.out.println("Menit harus 0-59!");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60) {
                System.out.println("Detik harus 0-59!");
            }
        } while (detik < 0 || detik >= 60);

        setWaktu(jam, menit, detik);
    }

    public int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    public void selisihVoid(Waktu A, Waktu B) {
        int totalA = A.konvertDetik();
        int totalB = B.konvertDetik();

        int selisih = Math.abs(totalA - totalB);

        this.jam = selisih / 3600;
        this.menit = (selisih % 3600) / 60;
        this.detik = selisih % 60;
    }

    public Waktu selisihReturn(Waktu A) {
        Waktu selisih = new Waktu();

        int totalA = A.konvertDetik();
        int totalThis = this.konvertDetik();

        int hasil = Math.abs(totalA - totalThis);

        selisih.jam = hasil / 3600;
        selisih.menit = (hasil % 3600) / 60;
        selisih.detik = hasil % 60;

        return selisih;
    }

    public void cetakWaktu() {
        System.out.printf("%02d:%02d:%02d%n", jam, menit, detik);
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
            gol = Integer.parseInt(input.nextLine());

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan tidak valid.");
                System.out.println("Silahkan pilih golongan dengan rentang 1-4!");
                System.out.println();
            }

        } while (gol < 1 || gol > 4);
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
            return "peringatan";
        }

        return "ok";
    }

    public String formatRibuan(int angka) {
        long nilai = (long) angka;
        String strAngka = String.valueOf(nilai);

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

    public void cetakPegawai(Waktu datang, Waktu pulang,int no) {
        Waktu lamaKerja = hitungLamaKerja(datang, pulang);
        System.out.printf(
                "%-3d %-4s %-10s %-3d %-9s %-9s %-9s %-11s %-12s %-9s %-9s %-12s%n",
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


class Menu {
    private Scanner input;
    private int pilihan;
    private int nomor = 1;

    public Menu(Scanner input) {
        this.input = input;
    }

    public void inputPegawaiLuar(Pegawai data) {
        System.out.print("Masukkan NIP pegawai: ");
        String NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        String nama = input.nextLine();

        int gol;

        do {
            System.out.print("Masukkan golongan: ");
            gol = Integer.parseInt(input.nextLine());

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan harus 1-4!");
            }
        } while (gol < 1 || gol > 4);

        data.setNIP(NIP);
        data.setNama(nama);
        data.setGol(gol);
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
                System.out.println("Jam harus 0-23!");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60) {
                System.out.println("Menit harus 0-59!");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60) {
                System.out.println("Detik harus 0-59!");
            }
        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
        input.nextLine();
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

        pilihan = Integer.parseInt(input.nextLine());
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
                System.out.println("\nProgram selesai.");
                break;

            default:
                System.out.println("\nPilihan tidak tersedia!");
        }
    }

    public int getPilihan() {
        return pilihan;
    }

    public void constructor() {
        System.out.println("\n=== CONSTRUCTOR BERPAMETER ===");

        Pegawai data = new Pegawai("Ali", "001", 3);
        Waktu waktuDatang = new Waktu(8, 0, 0);
        Waktu waktuPulang = new Waktu(17, 15, 10);

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");

        Pegawai data = new Pegawai();
        Waktu waktuDatang = new Waktu();
        Waktu waktuPulang = new Waktu();

        data.setNIP("002");
        data.setNama("Audina");
        data.setGol(2);

        waktuDatang.setWaktu(8, 0, 0);
        waktuPulang.setWaktu(16, 30, 0);

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    public void inputDalam() {
        System.out.println("\n=== INPUT DALAM ===");

        Pegawai data = new Pegawai();
        Waktu waktuDatang = new Waktu();
        Waktu waktuPulang = new Waktu();

        data.inputPegawai(input);

        System.out.println();
        System.out.println("=== WAKTU DATANG ===");
        waktuDatang.inputWaktu(input);

        System.out.println();
        System.out.println("=== WAKTU PULANG ===");
        waktuPulang.inputWaktu(input);

        input.nextLine();
        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    public void inputLuar() {
        System.out.println("\n=== INPUT LUAR ===");

        Pegawai data = new Pegawai();
        Waktu waktuDatang = new Waktu();
        Waktu waktuPulang = new Waktu();

        inputPegawaiLuar(data);
        inputWaktuLuar(waktuDatang, "WAKTU DATANG");
        inputWaktuLuar(waktuPulang, "WAKTU PULANG");

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    public void cetakHeader() {
        System.out.println();
        System.out.println("                 Daftar Gaji Harian PT Informatika");

        System.out.println();
        System.out.printf(
                "%-3s %-4s %-10s %-3s %-9s %-9s %-9s %-11s %-12s %-9s %-9s %-12s%n",
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

        System.out.println(
                "---------------------------------------------------------------------------------------------------------"
        );
    }

    public void cetakLuar(Pegawai data, Waktu waktuDatang, Waktu waktuPulang) {
        data.cetakPegawai(waktuDatang, waktuPulang, nomor);
        nomor++;
    }
}


public class Soal3_250012_250051_250093 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu(input);

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);

        input.close();
    }
}