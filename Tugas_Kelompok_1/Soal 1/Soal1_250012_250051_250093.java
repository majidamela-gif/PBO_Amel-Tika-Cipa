/*
Nama Program : Program Koordinat kartesian OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 28 September 2026
Deskripsi    : Buat program OOP koordinat kartesian
                ◼ Atribut : absis dan ordinat
                ◼ Constructor, input (dalam & luar), output (dalam & luar)
               Method Proses yang diinginkan dengan cara 1 (fungsi return) dan cara 2 (void):
                ◼ Mencari titik tengah
                ◼ nilai pencerminan terhadap sumbu X
                ◼ nilai pencerminan terhadap sumbu Y
                ◼ Jarak antara 2 titik
*/

import java.util.Scanner;

class Koordinat {
    private float absis;
    private float ordinat;

    public Koordinat(){
        absis = 0;
        ordinat = 0;
    }

    public Koordinat(float absis, float ordinat){
        this.absis = absis;
        this.ordinat = ordinat;
    }

    public float getAbsis(){
        return absis;
    }

    public void setAbsis(float absis){
        this.absis = absis;
    }

    public float getOrdinat(){
        return ordinat;
    }

    public void setOrdinat(float ordinat){
        this.ordinat = ordinat;
    }

    public void inputKoordinat(Scanner input){
        System.out.print("Masukkan absis: ");
        absis = input.nextFloat();
        System.out.print("Masukkan ordinat: ");
        ordinat = input.nextFloat();
    }

    public void setKoordinat(float pAbsis, float pOrdinat){
        absis = pAbsis;
        ordinat = pOrdinat;
    }

    public void titikTengahVoid(Koordinat p1, Koordinat p2){
        this.absis = (p1.absis + p2.absis)/2;
        this.ordinat = (p1.ordinat + p2.ordinat)/2;
    }

    public Koordinat titikTengahReturn(Koordinat p) {
        Koordinat hasil = new Koordinat();

        hasil.absis = (p.absis + this.absis) / 2;
        hasil.ordinat = (p.ordinat + this.ordinat) / 2;

        return hasil;
    }

    public void cerminSumbuXVoid(Koordinat p){
        this.absis = p.absis;
        this.ordinat = p.ordinat * (-1);
    }

    public Koordinat cerminSumbuXReturn(Koordinat p){
        Koordinat hasil = new Koordinat();

        hasil.absis = p.absis;
        hasil.ordinat = p.ordinat * (-1);

        return hasil;
    }

    public void cerminSumbuYVoid(Koordinat p){
        this.absis = p.absis * (-1);
        this.ordinat = p.ordinat;
    }

    public Koordinat cerminSumbuYReturn(Koordinat p){
        Koordinat hasil = new Koordinat();

        hasil.absis = p.absis * (-1);
        hasil.ordinat = p.ordinat;

        return hasil;
    }

    public void jarakVoid(Koordinat p1, Koordinat p2){
        double jarak = Math.sqrt(Math.pow(p2.absis - p1.absis, 2) + Math.pow(p2.ordinat - p1.ordinat, 2));
        System.out.println(jarak);
    }

    public double jarakReturn(Koordinat p1, Koordinat p2){
        return Math.sqrt(Math.pow(p2.absis - p1.absis, 2) + Math.pow(p2.ordinat - p1.ordinat, 2));
    }

    public void cetakTitik(){
        System.out.println("(" + absis + ", " + ordinat + ")");
    }

    public void cetak(Koordinat p1, Koordinat p2){
        System.out.println("=== DATA TITIK ===");
        System.out.print("Titik A = ");
        p1.cetakTitik();
        System.out.print("Titik B = ");
        p2.cetakTitik();

        Koordinat hasilVoid = new Koordinat();
        hasilVoid.titikTengahVoid(p1, p2);
        Koordinat hasilReturn = p1.titikTengahReturn(p2);
        System.out.println("\n=== TITIK TENGAH ===");
        System.out.print("Void   : ");
        hasilVoid.cetakTitik();
        System.out.print("Return : ");
        hasilReturn.cetakTitik();

        Koordinat cerminXP1Void = new Koordinat();
        cerminXP1Void.cerminSumbuXVoid(p1);
        Koordinat cerminXP1Return = p1.cerminSumbuXReturn(p1);
        System.out.println("\n=== CERMIN A TERHADAP SUMBU X ===");
        System.out.print("Void   : ");
        cerminXP1Void.cetakTitik();
        System.out.print("Return : ");
        cerminXP1Return.cetakTitik();

        Koordinat cerminXP2Void = new Koordinat();
        cerminXP2Void.cerminSumbuXVoid(p2);
        Koordinat cerminXP2Return = p2.cerminSumbuXReturn(p2);
        System.out.println("\n=== CERMIN B TERHADAP SUMBU X ===");
        System.out.print("Void   : ");
        cerminXP2Void.cetakTitik();
        System.out.print("Return : ");
        cerminXP2Return.cetakTitik();

        Koordinat cerminYP1Void = new Koordinat();
        cerminYP1Void.cerminSumbuYVoid(p1);
        Koordinat cerminYP1Return = p1.cerminSumbuYReturn(p1);
        System.out.println("\n=== CERMIN A TERHADAP SUMBU Y ===");
        System.out.print("Void   : ");
        cerminYP1Void.cetakTitik();
        System.out.print("Return : ");
        cerminYP1Return.cetakTitik();

        Koordinat cerminYP2Void = new Koordinat();
        cerminYP2Void.cerminSumbuYVoid(p2);
        Koordinat cerminYP2Return = p2.cerminSumbuYReturn(p2);
        System.out.println("\n=== CERMIN B TERHADAP SUMBU Y ===");
        System.out.print("Void   : ");
        cerminYP2Void.cetakTitik();
        System.out.print("Return : ");
        cerminYP2Return.cetakTitik();

        System.out.println("\n=== JARAK ===");
        System.out.print("Void   : ");
        p1.jarakVoid(p1, p2);
        double jarakReturn = p1.jarakReturn(p1, p2);
        System.out.println("Return : " + jarakReturn);
    }
}

public class Soal1_250012_250051_250093{
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int pilihan;
        Koordinat titikA = new Koordinat();
        Koordinat titikB = new Koordinat();
        Koordinat titikT = new Koordinat();

        do {
            pilihan = menu();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== CONSTRUCTOR BERPAMETER ===");
                    titikA = new Koordinat(1, 2);
                    titikB = new Koordinat(5, 4);
                    titikT.cetak(titikA, titikB);

                    break;

                case 2:
                    System.out.println("\n=== SETTER ===");
                    titikA.setKoordinat(5, 1);
                    titikB.setKoordinat(9, 3);
                    titikT.cetak(titikA, titikB);

                    break;

                case 3:
                    System.out.println("\n=== INPUT KOORDINAT ===");
                    System.out.println("\nMasukkan data Titik A");
                    titikA.inputKoordinat(input);
                    System.out.println("\nMasukkan data Titik B");
                    titikB.inputKoordinat(input);
                    titikT.cetak(titikA, titikB);

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
        System.out.println("       MENU KOORDINAT");
        System.out.println("==============================");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Koordinat");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu : ");

        return input.nextInt();
    }
}