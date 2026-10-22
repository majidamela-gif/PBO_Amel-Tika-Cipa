/* 
Nama Program : Program Nilai (Array 1 dimensi)
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 13 Oktober 2026
Deskripsi    : Buat program OOP untuk mencari nilai rata-rata, nilai tertinggi, nilai terendah dan sorting
               dari kumpulan data bertipe array of integer.
*/

import java.util.Scanner;

class Nilai {
    private int ukuran;
    private int[] nilai;

    public Nilai() {
        ukuran = 0;
        nilai = new int[ukuran];
    }

    public Nilai(int ukuran) {
        this.ukuran = ukuran;
        nilai = new int[ukuran];
    }

    public Nilai(int ukuran, int[] nilai) {
        this.ukuran = ukuran;
        this.nilai = new int[ukuran];
        for (int i = 0; i < ukuran; i++) {
            this.nilai[i] = nilai[i];
        }
    }

    public int getUkuran() {
        return ukuran;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
        nilai = new int[ukuran];
    }

    public void setNilai(int i, int nilai) {
        this.nilai[i] = nilai;
    }

    public int inputUkuran(Scanner input) {
        int ukuran;
        System.out.print("Masukkan ukuran larik: ");
        ukuran = input.nextInt();

        while (ukuran <= 0) {
            System.out.println("Ukuran harus lebih dari 0!");
            System.out.print("Masukkan ukuran larik: ");
            ukuran = input.nextInt();
        }
        return ukuran;
    }

    public void isiNilai(Scanner input) {
        for (int i = 0; i < ukuran; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + " : ");
            nilai[i] = input.nextInt();
        }
    }

    public double cariRata() {
        int jumlah = 0;
        for (int i = 0; i < ukuran; i++) {
            jumlah += nilai[i];
        }
        return (double) jumlah / ukuran;
    }

    public void cariRataVoid(Nilai A) {
        setUkuran(A.getUkuran());
        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        int jumlah = 0;
        for (int i = 0; i < ukuran; i++) {
            jumlah += nilai[i];
        }

        double rata = (double) jumlah / ukuran;
        System.out.println("Rata-rata (Void) : " + rata);
    }

    public int nilaiMax() {
        int max = nilai[0];
        for (int i = 0; i < ukuran; i++) {
            if (nilai[i] > max) {
                max = nilai[i];
            }
        }
        return max;
    }

    public void nilaiMaxVoid(Nilai A) {
        setUkuran(A.getUkuran());
        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        int max = nilai[0];
        for (int i = 0; i < ukuran; i++) {
            if (nilai[i] > max) {
                max = nilai[i];
            }
        }
        System.out.println("Nilai Tertinggi (Void) : " + max);
    }

    public int nilaiMin() {
        int min = nilai[0];
        for (int i = 0; i < ukuran; i++) {
            if (nilai[i] < min) {
                min = nilai[i];
            }
        }
        return min;
    }

    public void nilaiMinVoid(Nilai A) {
        setUkuran(A.getUkuran());
        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        int min = nilai[0];
        for (int i = 0; i < ukuran; i++) {
            if (nilai[i] < min) {
                min = nilai[i];
            }
        }
        System.out.println("Nilai Terendah (Void) : " + min);
    }

    public Nilai sortingAsc(Nilai A) {
        Nilai hasil = new Nilai(A.getUkuran(), A.nilai);
        for (int i = 0; i < hasil.ukuran - 1; i++) {
            for (int j = 0; j < hasil.ukuran - 1 - i; j++) {
                if (hasil.nilai[j] > hasil.nilai[j + 1]) {
                    int temp = hasil.nilai[j];
                    hasil.nilai[j] = hasil.nilai[j + 1];
                    hasil.nilai[j + 1] = temp;
                }
            }
        }
        return hasil;
    }

    public void sortingAscVoid(Nilai A) {
        setUkuran(A.getUkuran());
        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        for (int i = 0; i < ukuran - 1; i++) {
            for (int j = 0; j < ukuran - 1 - i; j++) {
                if (nilai[j] > nilai[j + 1]) {
                    int temp = nilai[j];
                    nilai[j] = nilai[j + 1];
                    nilai[j + 1] = temp;
                }
            }
        }
    }

    public Nilai sortingDesc(Nilai A) {
        Nilai hasil = new Nilai(A.getUkuran(), A.nilai);
        for (int i = 0; i < hasil.ukuran - 1; i++) {
            for (int j = 0; j < hasil.ukuran - 1 - i; j++) {
                if (hasil.nilai[j] < hasil.nilai[j + 1]) {
                    int temp = hasil.nilai[j];
                    hasil.nilai[j] = hasil.nilai[j + 1];
                    hasil.nilai[j + 1] = temp;
                }
            }
        }
        return hasil;
    }

    public void sortingDescVoid(Nilai A) {
        setUkuran(A.getUkuran());
        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        for (int i = 0; i < ukuran - 1; i++) {
            for (int j = 0; j < ukuran - 1 - i; j++) {
                if (nilai[j] < nilai[j + 1]) {
                    int temp = nilai[j];
                    nilai[j] = nilai[j + 1];
                    nilai[j + 1] = temp;
                }
            }
        }
    }

    public void cetakNilai() {
        System.out.print("Nilai: [");
        for (int i = 0; i < ukuran; i++) {
            System.out.print(nilai[i]);

            if (i < ukuran - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void cetakHasil() {
        System.out.println("\n=== HASIL FUNGSI (RETURN) ===");
        System.out.println("Rata-rata : " + cariRata());
        System.out.println("Nilai Tertinggi : " + nilaiMax());
        System.out.println("Nilai Terendah : " + nilaiMin());

        System.out.println("\n=== HASIL VOID ===");
        Nilai hasilVoid = new Nilai();
        hasilVoid.cariRataVoid(this);
        hasilVoid.nilaiMaxVoid(this);
        hasilVoid.nilaiMinVoid(this);
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
        System.out.println("       MENU PROGRAM NILAI");
        System.out.println("==============================");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Input Luar");
        System.out.println("5. Keluar");
        System.out.println("==============================");
        System.out.print("Pilih menu: ");

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
                System.out.println("\nProgram selesai.");
                break;

            default:
                System.out.println("\nPilihan tidak tersedia!");
        }
    }

    public int inputUkuran() {
        int ukuran;
        System.out.print("Masukkan ukuran larik: ");
        ukuran = input.nextInt();

        while (ukuran <= 0) {
            System.out.println("Ukuran harus lebih dari 0!");
            System.out.print("Masukkan ukuran larik: ");
            ukuran = input.nextInt();
        }
        return ukuran;
    }

    public void inputLarikLuar(Nilai A) {
        for (int i = 0; i < A.getUkuran(); i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + " = ");
            int nilai = input.nextInt();
            A.setNilai(i, nilai);
        }
    }

    public void cetakLuar(Nilai A, String label) {
        System.out.println(label);
        A.cetakNilai();
    }

    public void cetakSemua(Nilai A) {
        System.out.println("\n==================================");
        System.out.println("         HASIL PROGRAM NILAI");
        System.out.println("==================================");

        System.out.println("=== DATA LARIK ===");
        cetakLuar(A, "Data Larik A:");

        A.cetakHasil();

        Nilai hasilReturn = A.sortingAsc(A);
        Nilai hasilVoid = new Nilai();
        hasilVoid.sortingAscVoid(A);

        System.out.println("\n=== SORTING RETURN (ASCENDING) ===");
        hasilReturn.cetakNilai();

        System.out.println("\n=== SORTING VOID (ASCENDING) ===");
        hasilVoid.cetakNilai();

        hasilReturn = A.sortingDesc(A);
        hasilVoid = new Nilai();
        hasilVoid.sortingDescVoid(A);

        System.out.println("\n=== SORTING RETURN (DESCENDING) ===");
        hasilReturn.cetakNilai();

        System.out.println("\n=== SORTING VOID (DESCENDING) ===");
        hasilVoid.cetakNilai();
    }

    public void constructor() {
        System.out.println("\n=== CONSTRUCTOR BERPAMETER ===");
        Nilai A = new Nilai(5, new int[]{60, 77, 95, 79, 100});
        cetakSemua(A);
    }

    public void setter() {
        System.out.println("\n=== SETTER ===");

        Nilai A = new Nilai();
        A.setUkuran(5);
        A.setNilai(0, 78);
        A.setNilai(1, 67);
        A.setNilai(2, 69);
        A.setNilai(3, 95);
        A.setNilai(4, 100);

        cetakSemua(A);
    }

    public void inputDalam() {
        System.out.println("\n=== INPUT LARIK DALAM ===");

        Nilai A = new Nilai();
        int ukuran = A.inputUkuran(input);

        A.setUkuran(ukuran);
        A.isiNilai(input);

        cetakSemua(A);
    }

    public void inputLuar() {
        System.out.println("\n=== INPUT LARIK LUAR ===");

        int ukuran = inputUkuran();
        Nilai A = new Nilai(ukuran);

        inputLarikLuar(A);
        cetakSemua(A);
    }
}

public class Soal1_250012_250051_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
}