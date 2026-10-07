/*
Nama Program : Program Koordinat kartesian OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 06 Oktober 2026
Deskripsi    : Buat program OOP koordinat kartesian
                ◼ Atribut : absis dan ordinat
                ◼ Constructor, input (dalam & luar), output (dalam & luar)
               Method Proses yang diinginkan dengan cara 1 (fungsi return) dan cara 2 (void):
                ◼ Mencari titik tengah
                ◼ nilai pencerminan terhadap sumbu X
                ◼ nilai pencerminan terhadap sumbu Y
                ◼ Jarak antara 2 titik
                Class Menu dipisah
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

    public float getOrdinat(){
        return ordinat;
    }

    public void setAbsis(float absis){
        this.absis = absis;
    }

    public void setOrdinat(float ordinat){
        this.ordinat = ordinat;
    }

    public void setKoordinat(float pAbsis, float pOrdinat){
        absis = pAbsis;
        ordinat = pOrdinat;
    }

    public void inputKoordinat(Scanner input){
        System.out.print("Masukkan absis: ");
        absis = input.nextFloat();

        System.out.print("Masukkan ordinat: ");
        ordinat = input.nextFloat();
    }

    public void cetakTitik(){
        System.out.println("(" + absis + ", " + ordinat + ")");
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
}


class Menu {
    private Scanner input;
    private int pilihan;

    public Menu(Scanner input){
        this.input = input;
    }

    public void inputKoordinatLuar(Koordinat titik){
        float absis;
        float ordinat;

        System.out.print("Masukkan absis: ");
        absis = input.nextFloat();

        System.out.print("Masukkan ordinat: ");
        ordinat = input.nextFloat();

        titik.setKoordinat(absis, ordinat);
    }

    public void cetakLuar(Koordinat titik, String label) {
        System.out.print(label + " = ");
        titik.cetakTitik();
    }

    public void cetakSemua(Koordinat titikA, Koordinat titikB){
        System.out.println("\n==================================");
        System.out.println("              HASIL KOORDINAT");
        System.out.println("==================================");

        System.out.println("\n=== DATA TITIK ===");
        cetakLuar(titikA, "Titik A");
        cetakLuar(titikB, "Titik B");

        Koordinat titikTengahReturn = titikA.titikTengahReturn(titikB);
        Koordinat titikTengahVoid = new Koordinat();
        titikTengahVoid.titikTengahVoid(titikA, titikB);
        System.out.println("\n=== TITIK TENGAH ===");
        cetakLuar(titikTengahReturn, "Return");
        cetakLuar( titikTengahVoid, "Void");

        Koordinat cerminXP1Return = titikA.cerminSumbuXReturn(titikA);
        Koordinat cerminXP1Void = new Koordinat();
        cerminXP1Void.cerminSumbuXVoid(titikA);
        System.out.println("\n=== CERMIN TITIK A TERHADAP SUMBU X ===");
        cetakLuar(cerminXP1Return, "Return");
        cetakLuar(cerminXP1Void, "Void");

        Koordinat cerminXP2Return = titikB.cerminSumbuXReturn(titikB);
        Koordinat cerminXP2Void = new Koordinat();
        cerminXP2Void.cerminSumbuXVoid(titikB);
        System.out.println("\n=== CERMIN TITIK B TERHADAP SUMBU X ===");
        cetakLuar(cerminXP2Return, "Return");
        cetakLuar(cerminXP2Void, "Void");

        Koordinat cerminYP1Return = titikA.cerminSumbuYReturn(titikA);
        Koordinat cerminYP1Void = new Koordinat();
        cerminYP1Void.cerminSumbuYVoid(titikA);
        System.out.println("\n=== CERMIN TITIK A TERHADAP SUMBU Y ===");
        cetakLuar(cerminYP1Return, "Return");
        cetakLuar(cerminYP1Void, "Void");

        Koordinat cerminYP2Return = titikB.cerminSumbuYReturn(titikB);
        Koordinat cerminYP2Void = new Koordinat();
        cerminYP2Void.cerminSumbuYVoid(titikB);
        System.out.println("\n=== CERMIN TITIK B TERHADAP SUMBU Y ===");
        cetakLuar(cerminYP2Return, "Return");
        cetakLuar(cerminYP2Void, "Void");

        System.out.println("\n=== JARAK ANTARA TITIK A DAN B ===");
        double jarakReturn = titikA.jarakReturn(titikA, titikB);
        System.out.println("Return : " + jarakReturn);
        System.out.print("Void   : ");
        titikA.jarakVoid(titikA, titikB);
    }

    public void tampilkanMenu(){
        System.out.println("\n==============================");
        System.out.println("       MENU KOORDINAT");
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
        Koordinat titikA = new Koordinat(1, 2);
        Koordinat titikB = new Koordinat(5, 4);
        cetakSemua(titikA, titikB);
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");
        Koordinat titikA = new Koordinat();
        Koordinat titikB = new Koordinat();
        titikA.setAbsis(5);
        titikA.setOrdinat(1);
        titikB.setKoordinat(9, 3);
        cetakSemua(titikA, titikB);
    }

    public void inputDalam() {
        System.out.println("\n=== INPUT KOORDINAT DALAM ===");
        Koordinat titikA = new Koordinat();
        Koordinat titikB = new Koordinat();
        System.out.println("\nInput untuk Titik A:");
        titikA.inputKoordinat(input);
        System.out.println("\nInput untuk Titik B:");
        titikB.inputKoordinat(input);
        cetakSemua(titikA, titikB);
    }

    public void inputLuar() {
        System.out.println("\n=== INPUT KOORDINAT LUAR ===");
        Koordinat titikA = new Koordinat();
        Koordinat titikB = new Koordinat();
        System.out.println("\nInput untuk Titik A:");
        inputKoordinatLuar(titikA);
        System.out.println("\nInput untuk Titik B:");
        inputKoordinatLuar(titikB);
        cetakSemua(titikA, titikB);
    }
}


public class Soal1_250012_250051_250093{
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        Menu menu = new Menu(input);

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
}