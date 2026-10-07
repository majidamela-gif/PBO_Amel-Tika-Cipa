/*
Nama Program : Program Selisih Waktu OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 06 Oktober 2026
Deskripsi    : Buat program OOP untuk mencari selisih waktu
                ◼ Atribut : jam, menit, detik
                ◼ constructor, input (dalam & luar), output (dalam& luar)
               Method Proses (Cari selisih waktu) dengan cara 1 (fungsi return) dan cara 2 (void)
               Class Menu dipisah
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
        setWaktu(jam, menit, detik);
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
        if (jam >= 0 && jam < 24){
            this.jam = jam;
        } else {
            this.jam = 0;
            System.out.println("Jam harus 0-23!");
        }
    }

    public void setMenit(int menit){
        if (menit >= 0 && menit < 60){
            this.menit = menit;
        } else {
            this.menit = 0;
            System.out.println("Menit harus 0-59!");
        }
    }

    public void setDetik(int detik){
        if (detik >= 0 && detik < 60){
            this.detik = detik;
        } else {
            this.detik = 0;
            System.out.println("Detik harus 0-59!");
        }
    }

    public void setWaktu(int jam, int menit, int detik){
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }

    public void inputWaktu(Scanner input){
        int jam;
        int menit;
        int detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24){
                System.out.println("Jam harus 0-23!");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60){
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


class Menu {
    private Scanner input;
    private int pilihan;

    public Menu(Scanner input){
        this.input = input;
    }

    public void inputWaktuLuar(Waktu waktu){
        int jam;
        int menit;
        int detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24){
                System.out.println("Jam harus 0-23!");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60){
                System.out.println("Menit harus 0-59!");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60){
                System.out.println("Detik harus 0-59!");
            }
        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
    }

    public void cetakLuar(Waktu waktu, String label){
        System.out.print(label + " = ");
        waktu.cetakWaktu();
    }

    public void cetakSemua(Waktu A, Waktu B){
        System.out.println("\n=== DATA WAKTU ===");
        cetakLuar(A, "Waktu A");
        cetakLuar(B, "Waktu B");
        
        Waktu hasilVoid = new Waktu();
        hasilVoid.selisihVoid(A, B);
        Waktu hasilReturn = A.selisihReturn(B);
        cetakLuar(hasilVoid, "Void");
        cetakLuar(hasilReturn, "Return");
    }

    public void tampilkanMenu(){
        System.out.println("\n==============================");
        System.out.println("       MENU WAKTU");
        System.out.println("==============================");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Input Luar");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu : ");

        pilihan = input.nextInt();
    }

    public void prosesMenu(){
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
        Waktu waktuA = new Waktu(10, 15, 20);
        Waktu waktuB = new Waktu(8, 20, 30);
        cetakSemua(waktuA, waktuB);
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");
        Waktu waktuA = new Waktu();
        Waktu waktuB = new Waktu();
        waktuA.setWaktu(8, 20, 30);
        waktuB.setWaktu(10, 15, 20);
        cetakSemua(waktuA, waktuB);
    }

    public void inputDalam() {
        System.out.println("\n=== INPUT WAKTU DALAM ===");
        Waktu waktuA = new Waktu();
        Waktu waktuB = new Waktu();
        System.out.println("\nInput untuk Waktu A:");
        waktuA.inputWaktu(input);
        System.out.println("\nInput untuk Waktu B:");
        waktuB.inputWaktu(input);
        cetakSemua(waktuA, waktuB);
    }

    public void inputLuar() {
        System.out.println("\n=== INPUT WAKTU LUAR ===");
        Waktu waktuA = new Waktu();
        Waktu waktuB = new Waktu();
        System.out.println("\nInput untuk Waktu A:");
        inputWaktuLuar(waktuA);
        System.out.println("\nInput untuk Waktu B:");
        inputWaktuLuar(waktuB);
        cetakSemua(waktuA, waktuB);
    }
}

public class Soal2_250012_250051_250093{
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        Menu menu = new Menu(input);

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);

        input.close();
    }
}