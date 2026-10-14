/*
Nama Program : Program Penjumlahan dan Perkalian 2 Matriks
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 14 Oktober 2026
Deskripsi    : Program OOP untuk mencari penjumlahan dan perkalian 2 buah matriks
               Prosesnya berbentuk fungsi dan berbentuk void (passing object)
*/

import java.util.Scanner;

class Matriks {
    private int baris;
    private int kolom;
    private int[][] nilai;

    public Matriks() {
        baris = 0;
        kolom = 0;
        nilai = new int[10][10];
    }

    public Matriks(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        nilai = new int[10][10];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = 0;
            }
        }
    }

    public int getBaris() {
        return baris;
    }

    public void setBaris(int baris) {
        this.baris = baris;
    }

    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public void setNilai(int i, int j, int nilai) {
        this.nilai[i][j] = nilai;
    }

    public void inputMatriks(Scanner input) {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print("Nilai [" + (i + 1) + "][" + (j + 1) + "] = ");
                nilai[i][j] = input.nextInt();
            }
        }
    }

    public void cetakMatriks() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void addMatriksVoid(Matriks A, Matriks B) {
        baris = A.baris;
        kolom = A.kolom;
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }
    }

    public Matriks addMatriksReturn(Matriks A, Matriks B) {
        Matriks hasil = new Matriks(A.baris, A.kolom);
        for (int i = 0; i < A.baris; i++) {
            for (int j = 0; j < A.kolom; j++) {
                hasil.nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }
        return hasil;
    }

    public void kaliMatriksVoid(Matriks A, Matriks B) {
        baris = A.baris;
        kolom = B.kolom;

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = 0;

                for (int k = 0; k < A.kolom; k++) {
                    nilai[i][j] += A.nilai[i][k] * B.nilai[k][j];
                }
            }
        }
    }

    public Matriks kaliMatriksReturn(Matriks A, Matriks B) {
        Matriks hasil = new Matriks(A.baris, B.kolom);
        for (int i = 0; i < A.baris; i++) {
            for (int j = 0; j < B.kolom; j++) {
                hasil.nilai[i][j] = 0;

                for (int k = 0; k < A.kolom; k++) {
                    hasil.nilai[i][j] += A.nilai[i][k] * B.nilai[k][j];
                }
            }
        }
        return hasil;
    }
}

class Menu {
    private int pilihan;
    private final Scanner input;

    public Menu() {
        input = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println("         MENU MATRIKS");
        System.out.println("==============================");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Input Luar");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu : ");

        pilihan = input.nextInt();
    }

    public int getPilihan() {
        return pilihan;
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
                System.out.println("\nProgram Selesai.");
                break;

            default:
                System.out.println("\nPilihan tidak tersedia!");
        }
    }

    public void cetakLuar(Matriks matriks, String label) {
        System.out.println(label);
        matriks.cetakMatriks();
    }

    public void cetakSemua(Matriks A, Matriks B) {
        System.out.println("\n==================================");
        System.out.println("          HASIL MATRIKS");
        System.out.println("==================================");

        System.out.println("=== DATA MATRIKS ===");
        cetakLuar(A, "Matriks A :");
        System.out.println();
        cetakLuar(B, "Matriks B :");

        if (A.getBaris() == B.getBaris() && A.getKolom() == B.getKolom()) {
            Matriks hasilTambahReturn = A.addMatriksReturn(A, B);

            Matriks hasilTambahVoid = new Matriks();
            hasilTambahVoid.addMatriksVoid(A, B);

            System.out.println("\n=== PENJUMLAHAN A + B ===");
            System.out.println("Return :");
            hasilTambahReturn.cetakMatriks();

            System.out.println("\nVoid :");
            hasilTambahVoid.cetakMatriks();
        } else {
            System.out.println("\n=== PENJUMLAHAN A + B ===");
            System.out.println("Matriks A dan B tidak dapat dijumlahkan.");
            System.out.println("Ukuran matriks harus sama.");
        }

        if (A.getKolom() == B.getBaris()) {
            Matriks hasilKaliReturn = A.kaliMatriksReturn(A, B);

            Matriks hasilKaliVoid = new Matriks();
            hasilKaliVoid.kaliMatriksVoid(A, B);

            System.out.println("\n=== PERKALIAN A x B ===");
            System.out.println("Return :");
            hasilKaliReturn.cetakMatriks();

            System.out.println("\nVoid :");
            hasilKaliVoid.cetakMatriks();
        } else {
            System.out.println("\n=== PERKALIAN A x B ===");
            System.out.println("Matriks A dan B tidak dapat dikalikan.");
            System.out.println("Kolom A harus sama dengan baris B.");
        }
    }

    public void constructor() {
        System.out.println("\n=== CONSTRUCTOR BERPAMETER ===");
        Matriks A = new Matriks(3, 3);
        Matriks B = new Matriks(3, 3);

        A.setNilai(0, 0, 1);
        A.setNilai(0, 1, 2);
        A.setNilai(0, 2, 3);

        A.setNilai(1, 0, 4);
        A.setNilai(1, 1, 5);
        A.setNilai(1, 2, 6);

        A.setNilai(2, 0, 7);
        A.setNilai(2, 1, 8);
        A.setNilai(2, 2, 9);

        B.setNilai(0, 0, -2);
        B.setNilai(0, 1, 0);
        B.setNilai(0, 2, 5);

        B.setNilai(1, 0, 6);
        B.setNilai(1, 1, 1);
        B.setNilai(1, 2, 3);

        B.setNilai(2, 0, 3);
        B.setNilai(2, 1, 2);
        B.setNilai(2, 2, -8);

        cetakSemua(A, B);
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");
        Matriks A = new Matriks();
        Matriks B = new Matriks();

        A.setBaris(2);
        A.setKolom(2);

        B.setBaris(2);
        B.setKolom(2);

        System.out.println("\nMatriks A");
        A.setNilai(0, 0, 1);
        A.setNilai(0, 1, 2);
        A.setNilai(1, 0, 3);
        A.setNilai(1, 1, 4);

        System.out.println("\nMatriks B");
        B.setNilai(0, 0, 5);
        B.setNilai(0, 1, 6);
        B.setNilai(1, 0, 7);
        B.setNilai(1, 1, 8);

        cetakSemua(A, B);
    }

    public void inputDalam() {
        System.out.println("\n=== INPUT MATRIKS DALAM ===");
        int barisA, kolomA;
        int barisB, kolomB;

        System.out.println("Ukuran Matriks A");
        System.out.print("Masukkan jumlah baris : ");
        barisA = input.nextInt();
        System.out.print("Masukkan jumlah kolom : ");
        kolomA = input.nextInt();

        Matriks A = new Matriks(barisA, kolomA);

        System.out.println("\nMatriks A");
        A.inputMatriks(input);

        System.out.println("\nUkuran Matriks B");
        System.out.print("Masukkan jumlah baris : ");
        barisB = input.nextInt();
        System.out.print("Masukkan jumlah kolom : ");
        kolomB = input.nextInt();

        Matriks B = new Matriks(barisB, kolomB);

        System.out.println("\nMatriks B");
        B.inputMatriks(input);

        cetakSemua(A, B);
    }

    public void inputMatriksLuar(Matriks M) {
        for (int i = 0; i < M.getBaris(); i++) {
            for (int j = 0; j < M.getKolom(); j++) {
                System.out.print("Nilai [" + (i + 1) + "][" + (j + 1) + "] = ");
                int nilai = input.nextInt();
                M.setNilai(i, j, nilai);
            }
        }
    }

    public void inputLuar() {
        System.out.println("\n=== INPUT MATRIKS LUAR ===");
        int barisA, kolomA;
        int barisB, kolomB;

        System.out.println("Ukuran Matriks A");
        System.out.print("Masukkan jumlah baris : ");
        barisA = input.nextInt();
        System.out.print("Masukkan jumlah kolom : ");
        kolomA = input.nextInt();

        Matriks A = new Matriks(barisA, kolomA);

        System.out.println("\nMatriks A");
        inputMatriksLuar(A);

        System.out.println("\nUkuran Matriks B");
        System.out.print("Masukkan jumlah baris : ");
        barisB = input.nextInt();
        System.out.print("Masukkan jumlah kolom : ");
        kolomB = input.nextInt();

        Matriks B = new Matriks(barisB, kolomB);

        System.out.println("\nMatriks B");
        inputMatriksLuar(B);

        cetakSemua(A, B);
    }
}

public class Soal2_250012_250051_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
}