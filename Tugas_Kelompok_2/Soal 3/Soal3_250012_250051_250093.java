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

class Waktu{
    private int jam;
    private int menit;
    private int detik;

    public Waktu(){
        jam = 0;
        menit = 0;
        detik = 0;    
    }

    public Waktu(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    public int getJam(){
        return jam;
    }

    public int getMenit(){
        return menit;
    }

    public int getDetik(){
        return detik;
    }

    public void setJam(int jam){
        this.jam = jam;
    }

    public void setMenit(int menit){
        this.menit = menit;
    }

    public void setDetik(int detik){
        this.detik = detik;
    }

    public void setWaktu(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    public void inputWaktu(Scanner input){
        System.out.print("Masukkan Jam: ");
        jam = input.nextInt();
        System.out.print("Masukkan Menit: ");
        menit = input.nextInt();
        System.out.print("Masukkan Detik: ");
        detik = input.nextInt();
    }

    public int konvertDetik(){
        return jam * 3600 + menit * 60 + detik;
    }

    public void selisihVoid(Waktu A, Waktu B){
        int totalA = A.konvertDetik();
        int totalB = B.konvertDetik();
        int selisih = Math.abs(totalA - totalB);

        this.jam = selisih / 3600;
        this.menit = (selisih % 3600) / 60;
        this.detik = selisih % 60;
    }

    public Waktu selisihReturn(Waktu A){
        Waktu selisih = new Waktu();

        int totalA = A.konvertDetik();
        int totalThis = this.konvertDetik();
        int hasil = Math.abs(totalA - totalThis);

        selisih.jam = hasil / 3600;
        selisih.menit = (hasil % 3600) / 60;
        selisih.detik = hasil % 60;

        return selisih;
    }

    public void cetakWaktu(){
        System.out.println(jam + ":" + menit + ":" + detik);
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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public int getGol() {
        return gol;
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
            if (gol != 1 && gol != 2 && gol != 3 && gol != 4) {
                System.out.println("Golongan tidak valid.");
                System.out.println("Silahkan pilih golongan dengan rentang 1-4!");
                System.out.println();
            }
        } while (gol != 1 && gol != 2 && gol != 3 && gol != 4);
    }

    public int hitungGajiHarian() {
        int gaji = 0;
        if (gol == 1) {
            gaji = 150000;
        }
        else if (gol == 2) {
            gaji = 200000;
        }
        else if (gol == 3) {
            gaji = 400000;
        }
        else if (gol == 4) {
            gaji = 500000;
        }
        return gaji;
    }

    public int hitungLembur() {
        int lembur = 0;
        if (gol == 1) {
            lembur = 50000;
        }
        else if (gol == 2) {
            lembur = 75000;
        }
        else if (gol == 3) {
            lembur = 150000;
        }
        else if (gol == 4) {
            lembur = 200000;
        }
        return lembur;
    }

    public int hitungGajiLembur(Waktu waktu) {
        return waktu.hitungJamLembur() * hitungLembur();
    }

    public int hitungGajiTotal(Waktu waktu) {
        return hitungGajiHarian() + hitungGajiLembur(waktu);
    }

    public String hitungStatus(Waktu waktu) {
        if (waktu.hitungDurasiDetik() < 8 * 3600) {
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

    public void cetakPegawai(Waktu waktu, int no) {
        System.out.printf(
            "%-4d %-10s %-10s %-5d %-11s %-11s %-11s %-13s %-14s %-11s %-11s %-12s%n",
            no,
            getNIP(),
            getNama(),
            getGol(),
            waktu.getWaktuDatang(),
            waktu.getWaktuPulang(),
            waktu.hitungLamaKerja(),
            waktu.hitungLamaLembur(),
            formatRibuan(hitungGajiHarian()),
            formatRibuan(hitungGajiLembur(waktu)),
            formatRibuan(hitungGajiTotal(waktu)),
            hitungStatus(waktu)
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

    public void tampilkanMenu() {
        System.out.println();
        System.out.println("===== MENU GAJI PEGAWAI =====");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Pegawai");
        System.out.println("4. Keluar");
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
                inputPegawai();
                break;

            case 4:
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
        Waktu waktu = new Waktu(8, 0, 0, 17, 15, 10);

        tampilkanHeader();
        data.cetakPegawai(waktu, nomor++);
        tampilkanGaris();
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");

        Pegawai data = new Pegawai();
        Waktu waktu = new Waktu();

        data.setNIP("002");
        data.setNama("Budi");
        data.setGol(2);

        waktu.setWaktuDatang(LocalTime.of(8, 0, 0));
        waktu.setWaktuPulang(LocalTime.of(16, 30, 0));

        tampilkanHeader();
        data.cetakPegawai(waktu, nomor++);
        tampilkanGaris();
    }

    public void inputPegawai() {
        System.out.println("\n=== INPUT PEGAWAI ===");

        Pegawai data = new Pegawai();
        Waktu waktu = new Waktu();

        data.inputPegawai(input);
        waktu.inputWaktu(input);

        tampilkanHeader();
        data.cetakPegawai(waktu, nomor++);
        tampilkanGaris();
    }

    public void tampilkanGaris() {
        System.out.println(
            "----------------------------------------------------------------------------------------------------------------------------------"
        );
    }

    public void tampilkanHeader() {
        System.out.println();
        System.out.println("                                                Daftar Gaji Harian PT Informatika");
        System.out.println();

        tampilkanGaris();

        System.out.printf(
            "%-4s %-10s %-10s %-5s %-11s %-11s %-11s %-13s %-14s %-11s %-11s %-12s%n",
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

        tampilkanGaris();
    }
}

public class Soal3_250012_250051_250093 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu(input);

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 4);
    }
}