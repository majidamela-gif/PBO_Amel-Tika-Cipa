/*
Nama Program : Program Gaji Pegawai menggunakan Waktu
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program gaji pegawai (nomor 3) ditambahkan waktu secara OOP
                dibuat 2 Class (Class Pegawai dan Class Waktu)
                Waktu: Waktu datang, Waktu pulang, waktu lama kerja
*/

import java.util.Scanner;
import java.time.LocalTime;

class Pegawai{
    private String nama;
    private String NIP;
    private int gol;

    public Pegawai(){
        nama = "";
        NIP = "";
        gol = 0;
    }

    public Pegawai(String nama, int gol, String NIP){
        this.nama = nama;
        this.NIP = NIP;
        this.gol = gol;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNIP(String NIP){
        this.NIP = NIP;
    }

    public void setGol(int gol){
        this.gol = gol;
    }

    public void setPegawai(String nama, int gol, String NIP){
        this.nama = nama;
        this.gol = gol;
        this.NIP = NIP;
    }

    public String getNama(){
        return nama;
    }

    public String getNIP(){
        return NIP;
    }

    public int getGol(){
        return gol;
    }

    public void inputDalam(Scanner input){
        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        do{
            System.out.print("Masukkan golongan: ");
            gol = Integer.parseInt(input.nextLine());

            if (gol != 1 && gol != 2 && gol != 3 && gol != 4){
                System.out.println("Golongan tidak valid");
                System.out.println("Silahkan pilih golongan dengan rentang 1-4!");
                System.out.println();
            }
        }while(gol != 1 && gol != 2 && gol != 3 && gol != 4);
    }

    public int hitungGapok(){
        int gapok = 0;

        if (gol == 1){
            gapok = 1500000;
        }
        else if (gol == 2){
            gapok = 2000000;
        }
        else if (gol == 3){
            gapok = 3000000;
        }
        else if (gol == 4){
            gapok = 5000000;
        }

        return gapok;
    }

    public double hitungTunjangan(){
        double tunjangan = 0;

        if (gol == 1){
            tunjangan = hitungGapok() * 0.10;
        }
        else if (gol == 2){
            tunjangan = hitungGapok() * 0.12;
        }
        else if (gol == 3){
            tunjangan = hitungGapok() * 0.12;
        }
        else if (gol == 4){
            tunjangan = hitungGapok() * 0.15;
        }

        return tunjangan;
    }

    public double hitungPotongan(){
        double potongan = 0;

        if (gol == 1){
            potongan = hitungGapok() * 0.01;
        }
        else if (gol == 2){
            potongan = hitungGapok() * 0.02;
        }
        else if (gol == 3){
            potongan = hitungGapok() * 0.02;
        }
        else if (gol == 4){
            potongan = hitungGapok() * 0.04;
        }

        return potongan;
    }

    public double hitungGatot() {
        double gatot;
        gatot = hitungGapok() + hitungTunjangan() - hitungPotongan();
        return gatot;
    }

    public String formatRibuan(double angka){
        long nilai = (long) angka;
        String strAngka = String.valueOf(nilai);
        String hasil = "";
        int hitung = 0;

        for(int i = strAngka.length() - 1; i >= 0; i--){
            hasil = strAngka.charAt(i) + hasil;
            hitung++;
            if (hitung % 3 == 0 && i > 0){
            hasil = "." + hasil;
            }
        }

        return hasil;
    }

    public void cetakPegawai() {
        System.out.println("-".repeat(112));

        System.out.printf("| %-15s | %-15s | %-3s | %-13s | %-13s | %-13s | %-15s |\n",
            "NIP", "Nama", "Gol", "Gapok", "Tunjangan", "Potongan", "Total Gaji");

        System.out.println("-".repeat(112));

        System.out.printf("| %-15s | %-15s | %-3d | Rp. %-10s | Rp. %-10s | Rp. %-10s | Rp. %-12s |\n",
            getNIP(),
            getNama(),
            getGol(),
            formatRibuan(hitungGapok()),
            formatRibuan(hitungTunjangan()),
            formatRibuan(hitungPotongan()),
            formatRibuan(hitungGatot()));

        System.out.println("-".repeat(112));
    }
}


class Waktu{
    private LocalTime waktuDatang;
    private LocalTime waktuPulang;

    public Waktu(){
        waktuDatang = null;
        waktuPulang = null;
    }

    public Waktu(int jamDatang, int menitDatang, int detikDatang, int jamPulang, int menitPulang, int detikPulang){
        this.waktuDatang = LocalTime.of(jamDatang, menitDatang, detikDatang);
        this.waktuPulang = LocalTime.of(jamPulang, menitPulang, detikPulang);
    }

    public void setWaktuDatang(LocalTime waktuDatang){
        this.waktuDatang = waktuDatang;
    }

    public void setWaktuPulang(LocalTime waktuPulang){
        this.waktuPulang = waktuPulang;
    }

    public LocalTime getWaktuDatang(){
        return waktuDatang;
    }

    public LocalTime getWaktuPulang(){
        return waktuPulang;
    }

    public void inputWaktu(Scanner input){
        System.out.print("Masukkan jam datang   : ");
        int jamDatang = Integer.parseInt(input.nextLine());

        System.out.print("Masukkan menit datang : ");
        int menitDatang = Integer.parseInt(input.nextLine());

        System.out.print("Masukkan detik datang : ");
        int detikDatang = Integer.parseInt(input.nextLine());

        System.out.print("Masukkan jam pulang   : ");
        int jamPulang = Integer.parseInt(input.nextLine());

        System.out.print("Masukkan menit pulang : ");
        int menitPulang = Integer.parseInt(input.nextLine());

        System.out.print("Masukkan detik pulang : ");
        int detikPulang = Integer.parseInt(input.nextLine());

        setWaktuDatang(LocalTime.of(jamDatang, menitDatang, detikDatang));
        setWaktuPulang(LocalTime.of(jamPulang, menitPulang, detikPulang));
    }

    public int hitungDurasiDetik(){
        int detikDatang = getWaktuDatang().getHour() * 3600 + getWaktuDatang().getMinute() * 60 + getWaktuDatang().getSecond();
        int detikPulang = getWaktuPulang().getHour() * 3600 + getWaktuPulang().getMinute() * 60 + getWaktuPulang().getSecond();
        int durasi = detikPulang - detikDatang;
        if (durasi < 0){
            durasi += 24 * 3600;
        }
        return durasi;
    }

    public int hitungDurasiJam(){
        return hitungDurasiDetik() / 3600;
    }

    public int hitungDurasiMenit(){
        return (hitungDurasiDetik() % 3600) / 60;
    }

    public int hitungDurasiSisaDetik(){
        return hitungDurasiDetik() % 60;
    }

    public String hitungLamaKerja(){
        int jam = hitungDurasiJam();
        int menit = hitungDurasiMenit();
        int detik = hitungDurasiSisaDetik();

        return jam + " jam " + menit + " menit " + detik + " detik"; 
    }

    public void cetakWaktu() {
        System.out.println("-".repeat(70));

        System.out.printf("| %-15s | %-15s | %-15s |\n",
            "Waktu Datang", "Waktu Pulang", "Lama Kerja");

        System.out.println("-".repeat(70));

        System.out.printf("| %-15s | %-15s | %-15s |\n",
            getWaktuDatang(),
            getWaktuPulang(),
            hitungLamaKerja());

        System.out.println("-".repeat(70));
    }
}

public class soal1_250051_250093_250012 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){        
        int pilihan;
        do{
            pilihan = menu();
            switch (pilihan){
                case 1:
                    System.out.println("\nConstructor Berparameter");
                    Pegawai data1 = new Pegawai("Audina", 3, "140810250054");
                    Waktu waktu1 = new Waktu(8, 10, 30, 17, 0, 5);
                    data1.cetakPegawai();
                    waktu1.cetakWaktu();
                    break;

                case 2:
                    System.out.println("\nSetter");
                    Pegawai data2 = new Pegawai();
                    Waktu waktu2 = new Waktu();
                    data2.setNIP("140810250054");
                    data2.setNama("Audina");
                    data2.setGol(3);
                    waktu2.setWaktuDatang(LocalTime.of(8,0,0));
                    waktu2.setWaktuPulang(LocalTime.of(19,0,30));
                    data2.cetakPegawai();
                    waktu2.cetakWaktu();
                    break;

                case 3:
                    System.out.println("\nInput Dalam");
                    Pegawai data3 = new Pegawai();
                    Waktu waktu3 = new Waktu();
                    data3.inputDalam(input);
                    waktu3.inputWaktu(input);
                    data3.cetakPegawai();
                    waktu3.cetakWaktu();
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }
        }while(pilihan != 4);
        input.close();
    }

    static int menu(){
        System.out.println("===== MENU GAJI PEGAWAI =====");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");

        return Integer.parseInt(input.nextLine());
    }
}