/*
Nama Program : Program Selisih Waktu OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 28 September 2026
Deskripsi    : Buat program OOP untuk mencari selisih waktu
                ◼ Atribut : jam, menit, detik
                ◼ constructor, input (dalam & luar), output (dalam& luar)
               Method Proses (Cari selisih waktu) dengan cara 1 (fungsi return) dan cara 2 (void):
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

    public void setJam(int jam){
        this.jam = jam;
    }

    public int getMenit(){
        return menit;
    }

    public void setMenit(int menit){
        this.menit = menit;
    }

    public int getDetik(){
        return detik;
    }

    public void setDetik(int detik){
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

    public void setWaktu(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
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

    public void cetak(Waktu A, Waktu B){
        System.out.println("\n=== DATA WAKTU ===");
        System.out.print("Waktu A: ");
        A.cetakWaktu();
        System.out.print("Waktu B: ");
        B.cetakWaktu();

        Waktu hasilVoid = new Waktu();
        hasilVoid.selisihVoid(A, B);
        Waktu hasilReturn = A.selisihReturn(B);
        System.out.print("Selisih Void: ");
        hasilVoid.cetakWaktu();
        System.out.print("Selisih Return: ");
        hasilReturn.cetakWaktu();
    }
}

public class Soal2_250012_250051_250093{
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int pilihan;
        Waktu waktuA = new Waktu();
        Waktu waktuB = new Waktu();
        Waktu waktuT = new Waktu();

        do {
            pilihan = menu();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== CONSTRUCTOR BERPAMETER ===");
                    waktuA = new Waktu(10, 15, 20);
                    waktuB = new Waktu(8, 20, 30);
                    waktuT.cetak(waktuA, waktuB);

                    break;

                case 2:
                    System.out.println("\n=== SETTER ===");
                    waktuA.setWaktu(8, 20, 30);
                    waktuB.setWaktu(10, 15, 20);
                    waktuT.cetak(waktuA, waktuB);

                    break;

                case 3:
                    System.out.println("\n=== INPUT WAKTU ===");
                    System.out.println("\nMasukkan data Waktu A");
                    waktuA.inputWaktu(input);
                    System.out.println("\nMasukkan data Waktu B");
                    waktuB.inputWaktu(input);
                    waktuT.cetak(waktuA, waktuB);

                    break;

                case 4:
                    System.out.println("\nProgram selesai.");
                    break;

                default:
                    System.out.println("\nPilihan tidak tersedia!");
            }
        } while (pilihan != 4);
        input.close();
    }

    static int menu() {
        System.out.println("\n==============================");
        System.out.println("       MENU WAKTU");
        System.out.println("==============================");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Waktu");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu : ");

        return input.nextInt();
    }
}