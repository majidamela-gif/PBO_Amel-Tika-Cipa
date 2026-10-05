/*
Nama Program : Program Gaji OOP 4 class
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 05 Oktober 2026
Deskripsi    : Ubah Soal 3 tugas pertemuan sebelumnya, tambahkan class menu, jadi total 4 class (waktu, pegawai, menu, main)
*/

import java.util.Scanner;
import java.time.LocalTime;

class Waktu {
    private LocalTime waktuDatang;
    private LocalTime waktuPulang;

    public Waktu() {
        waktuDatang = null;
        waktuPulang = null;
    }

    public Waktu(int jamDatang, int menitDatang, int detikDatang, int jamPulang, int menitPulang, int detikPulang) {
        this.waktuDatang = LocalTime.of(jamDatang, menitDatang, detikDatang);
        this.waktuPulang = LocalTime.of(jamPulang, menitPulang, detikPulang);
    }

    public LocalTime getWaktuDatang() {
        return waktuDatang;
    }

    public void setWaktuDatang(LocalTime waktuDatang) {
        this.waktuDatang = waktuDatang;
    }

    public LocalTime getWaktuPulang() {
        return waktuPulang;
    }

    public void setWaktuPulang(LocalTime waktuPulang) {
        this.waktuPulang = waktuPulang;
    }

    public void inputWaktu(Scanner input) {
        System.out.print("Masukkan jam datang: ");
        int jamDatang = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan menit datang: ");
        int menitDatang = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan detik datang: ");
        int detikDatang = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan jam pulang: ");
        int jamPulang = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan menit pulang: ");
        int menitPulang = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan detik pulang: ");
        int detikPulang = Integer.parseInt(input.nextLine());

        setWaktuDatang(LocalTime.of(jamDatang, menitDatang, detikDatang));
        setWaktuPulang(LocalTime.of(jamPulang, menitPulang, detikPulang));
    }

    public int hitungDurasiDetik() {
        int detikDatang = getWaktuDatang().getHour() * 3600 + getWaktuDatang().getMinute() * 60 + getWaktuDatang().getSecond();
        int detikPulang = getWaktuPulang().getHour() * 3600 + getWaktuPulang().getMinute() * 60 + getWaktuPulang().getSecond();

        int durasi = detikPulang - detikDatang;
        if (durasi < 0) {
            durasi += 24 * 3600;
        }
        return durasi;
    }

    public int hitungDurasiJam() {
        return hitungDurasiDetik() / 3600;
    }

    public int hitungDurasiMenit() {
        return (hitungDurasiDetik() % 3600) / 60;
    }

    public int hitungDurasiSisaDetik() {
        return hitungDurasiDetik() % 60;
    }

    public String hitungLamaKerja() {
        int jam = hitungDurasiJam();
        int menit = hitungDurasiMenit();
        int detik = hitungDurasiSisaDetik();

        return String.format("%02d:%02d:%02d",jam, menit, detik);
    }

    public int hitungJamLembur() {
        int durasi = hitungDurasiDetik();
        if (durasi < 8 * 3600) {
            return 0;
        }
        return (durasi - 8 * 3600) / 3600;
    }

    public String hitungLamaLembur() {
        int durasi = hitungDurasiDetik();
        if (durasi < 8 * 3600) {
            return "00:00:00";
        }

        int lembur = durasi - 8 * 3600;
        int jam = lembur / 3600;
        int menit = (lembur % 3600) / 60;
        int detik = lembur % 60;

        return String.format("%02d:%02d:%02d", jam, menit, detik);
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
        Menu menu = new Menu();

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 4);
    }
}