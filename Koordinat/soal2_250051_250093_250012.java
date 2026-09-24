/*
Nama Program : Program Koordinat
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program mencari titik tengah dengan passing object
*/

import java.util.Scanner;

class Koordinat {
    private double absis;
    private double ordinat;

    public Koordinat() {
        absis = 0;
        ordinat = 0;
    }

    public Koordinat(double absis, double ordinat) {
        this.absis = absis;
        this.ordinat = ordinat;
    }

    public void setKoordinat(double absis, double ordinat) {
        this.absis = absis;
        this.ordinat = ordinat;
    }

    public void setAbsis(double absis) {
        this.absis = absis;
    }

    public void setOrdinat(double ordinat) {
        this.ordinat = ordinat;
    }

    public double getAbsis() {
        return absis;
    }

    public double getOrdinat() {
        return ordinat;
    }

    public void inputKoordinat(Scanner input) {
        System.out.print("Masukkan absis: ");
        absis = Double.parseDouble(input.nextLine());

        System.out.print("Masukkan ordinat: ");
        ordinat = Double.parseDouble(input.nextLine());
    }

    public void printKoordinat() {
        System.out.println("Nilai Absis   = " + absis);
        System.out.println("Nilai Ordinat = " + ordinat);
    }

    public void titikTengahVoid(Koordinat P1, Koordinat P2) {
        this.absis = (P1.absis + P2.absis) / 2;
        this.ordinat = (P1.ordinat + P2.ordinat) / 2;
    }

    public Koordinat titikTengahReturn(Koordinat P) {
        Koordinat hasil = new Koordinat();

        hasil.absis = (P.absis + this.absis) / 2;
        hasil.ordinat = (P.ordinat + this.ordinat) / 2;

        return hasil;
    }
}


public class Koordinat {
    static Scanner input = new Scanner(System.in);
    public static void menu() {
        Koordinat titikA = new Koordinat(2, 1);
        Koordinat titikB = new Koordinat(6, 3);
        Koordinat titikT = new Koordinat();

        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("\n===== MENU PASSING KOORDINAT =====");
            System.out.println("1. Titik A dipanggil ke Titik B");
            System.out.println("2. Titik B dipanggil ke Titik A");
            System.out.println("3. Titik A dan B dipanggil ke Titik T");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = Integer.parseInt(input.nextLine());

            if (pilihan == 1) {

                System.out.println("\nTitik A");
                titikA.printKoordinat();

                System.out.println("\nTitik B");
                titikB.printKoordinat();

                System.out.println("\nTitik A dipanggil ke Titik B");

                titikT = titikB.titikTengahReturn(titikA);

                System.out.println("\nTitik T");
                titikT.printKoordinat();

            } else if (pilihan == 2) {

                System.out.println("\nTitik A");
                titikA.printKoordinat();

                System.out.println("\nTitik B");
                titikB.printKoordinat();

                System.out.println("\nTitik B dipanggil ke Titik A");

                titikT = titikA.titikTengahReturn(titikB);

                System.out.println("\nTitik T");
                titikT.printKoordinat();

            } else if (pilihan == 3) {

                System.out.println("\nTitik A");
                titikA.printKoordinat();

                System.out.println("\nTitik B");
                titikB.printKoordinat();

                System.out.println("\nTitik A dan Titik B dipanggil ke Titik T");

                titikT.titikTengahVoid(titikA, titikB);

                System.out.println("\nTitik T");
                titikT.printKoordinat();

            } else if (pilihan == 4) {

                System.out.println("Program selesai.");

            } else {

                System.out.println("Menu tidak tersedia!");
            }
        }
    }


    public static void main(String[] args) {
        menu();
        input.close();
    }
}