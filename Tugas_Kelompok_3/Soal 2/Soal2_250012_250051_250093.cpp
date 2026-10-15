/*
Nama Program : Program Penjumlahan dan Perkalian 2 Matriks
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 15 Oktober 2026
Deskripsi    : Program OOP untuk mencari penjumlahan dan perkalian
               2 buah matriks menggunakan fungsi return dan void
               dengan passing object.
*/

#include <iostream>
using namespace std;

class Matriks {
private:
    int baris, kolom;
    int nilai[10][10];

public:
    Matriks(int b = 0, int k = 0) {
        baris = b;
        kolom = k;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nilai[i][j] = 0;
            }
        }
    }

    int getBaris() {
        return baris;
    }

    void setBaris(int b) {
        baris = b;
    }

    int getKolom() {
        return kolom;
    }

    void setKolom(int k) {
        kolom = k;
    }

    void setNilai(int i, int j, int x) {
        nilai[i][j] = x;
    }

    void inputMatriks() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                cout << "Nilai [" << i + 1 << "][" << j + 1 << "] = ";
                cin >> nilai[i][j];
            }
        }
    }

    void cetakMatriks() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                cout << nilai[i][j] << "\t";
            }
            cout << endl;
        }
    }

    void addMatriksVoid(Matriks A, Matriks B) {
        baris = A.baris;
        kolom = A.kolom;

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }
    }

    Matriks addMatriksReturn(Matriks A, Matriks B) {
        Matriks hasil(A.baris, A.kolom);

        for (int i = 0; i < A.baris; i++) {
            for (int j = 0; j < A.kolom; j++) {
                hasil.nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }

        return hasil;
    }

    void kaliMatriksVoid(Matriks A, Matriks B) {
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

    Matriks kaliMatriksReturn(Matriks A, Matriks B) {
        Matriks hasil(A.baris, B.kolom);

        for (int i = 0; i < A.baris; i++) {
            for (int j = 0; j < B.kolom; j++) {
                hasil.nilai[i][j] = 0;

                for (int k = 0; k < A.kolom; k++) {
                    hasil.nilai[i][j] +=
                        A.nilai[i][k] * B.nilai[k][j];
                }
            }
        }

        return hasil;
    }
};

class Menu {
private:
    int pilihan;

public:
    Menu() {
        pilihan = 0;
    }

    void tampilkanMenu() {
        cout << "\n==============================" << endl;
        cout << "         MENU MATRIKS" << endl;
        cout << "==============================" << endl;
        cout << "1. Constructor Berparameter" << endl;
        cout << "2. Setter" << endl;
        cout << "3. Input Dalam" << endl;
        cout << "4. Input Luar" << endl;
        cout << "5. Keluar" << endl;
        cout << "Pilih menu : ";
        cin >> pilihan;
    }

    int getPilihan() {
        return pilihan;
    }

    void prosesMenu() {
        if (pilihan == 1) {
            constructor();
        } else if (pilihan == 2) {
            setter();
        } else if (pilihan == 3) {
            inputDalam();
        } else if (pilihan == 4) {
            inputLuar();
        } else if (pilihan == 5) {
            cout << "\nProgram Selesai." << endl;
        } else {
            cout << "\nPilihan tidak tersedia!" << endl;
        }
    }

    void cetakLuar(Matriks matriks, const char* label) {
        cout << label << endl;
        matriks.cetakMatriks();
    }

    void cetakSemua(Matriks A, Matriks B) {
        cout << "\n==================================" << endl;
        cout << "          HASIL MATRIKS" << endl;
        cout << "==================================" << endl;
        cout << "=== DATA MATRIKS ===" << endl;

        cetakLuar(A, "Matriks A :");
        cout << endl;
        cetakLuar(B, "Matriks B :");

        if (A.getBaris() == B.getBaris() &&
            A.getKolom() == B.getKolom()) {

            Matriks hasilTambahReturn =
                A.addMatriksReturn(A, B);

            Matriks hasilTambahVoid;
            hasilTambahVoid.addMatriksVoid(A, B);

            cout << "\n=== PENJUMLAHAN A + B ===" << endl;
            cout << "Return :" << endl;
            hasilTambahReturn.cetakMatriks();

            cout << "\nVoid :" << endl;
            hasilTambahVoid.cetakMatriks();

        } else {
            cout << "\n=== PENJUMLAHAN A + B ===" << endl;
            cout << "Matriks A dan B tidak dapat dijumlahkan."
                 << endl;
            cout << "Ukuran matriks harus sama." << endl;
        }

        if (A.getKolom() == B.getBaris()) {

            Matriks hasilKaliReturn =
                A.kaliMatriksReturn(A, B);

            Matriks hasilKaliVoid;
            hasilKaliVoid.kaliMatriksVoid(A, B);

            cout << "\n=== PERKALIAN A x B ===" << endl;
            cout << "Return :" << endl;
            hasilKaliReturn.cetakMatriks();

            cout << "\nVoid :" << endl;
            hasilKaliVoid.cetakMatriks();

        } else {
            cout << "\n=== PERKALIAN A x B ===" << endl;
            cout << "Matriks A dan B tidak dapat dikalikan."
                 << endl;
            cout << "Kolom A harus sama dengan baris B."
                 << endl;
        }
    }

    void constructor() {
        cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;

        Matriks A(3, 3);
        Matriks B(3, 3);

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

    void setter() {
        cout << "\n=== SETTER ===" << endl;

        Matriks A;
        Matriks B;

        A.setBaris(2);
        A.setKolom(2);
        B.setBaris(2);
        B.setKolom(2);

        cout << "\nMatriks A" << endl;
        A.setNilai(0, 0, 1);
        A.setNilai(0, 1, 2);
        A.setNilai(1, 0, 3);
        A.setNilai(1, 1, 4);

        cout << "\nMatriks B" << endl;
        B.setNilai(0, 0, 5);
        B.setNilai(0, 1, 6);
        B.setNilai(1, 0, 7);
        B.setNilai(1, 1, 8);

        cetakSemua(A, B);
    }

    void inputUkuran(int &baris, int &kolom) {
        do {
            cout << "Masukkan jumlah baris (1-10) : ";
            cin >> baris;
        } while (baris < 1 || baris > 10);

        do {
            cout << "Masukkan jumlah kolom (1-10) : ";
            cin >> kolom;
        } while (kolom < 1 || kolom > 10);
    }

    void inputDalam() {
        cout << "\n=== INPUT MATRIKS DALAM ===" << endl;

        int barisA, kolomA;
        int barisB, kolomB;

        cout << "Ukuran Matriks A" << endl;
        inputUkuran(barisA, kolomA);

        Matriks A(barisA, kolomA);

        cout << "\nMatriks A" << endl;
        A.inputMatriks();

        cout << "\nUkuran Matriks B" << endl;
        inputUkuran(barisB, kolomB);

        Matriks B(barisB, kolomB);

        cout << "\nMatriks B" << endl;
        B.inputMatriks();

        cetakSemua(A, B);
    }

    void inputMatriksLuar(Matriks &M) {
        for (int i = 0; i < M.getBaris(); i++) {
            for (int j = 0; j < M.getKolom(); j++) {
                int nilai;
                cout << "Nilai [" << i + 1 << "]["
                     << j + 1 << "] = ";
                cin >> nilai;
                M.setNilai(i, j, nilai);
            }
        }
    }

    void inputLuar() {
        cout << "\n=== INPUT MATRIKS LUAR ===" << endl;

        int barisA, kolomA;
        int barisB, kolomB;

        cout << "Ukuran Matriks A" << endl;
        inputUkuran(barisA, kolomA);

        Matriks A(barisA, kolomA);

        cout << "\nMatriks A" << endl;
        inputMatriksLuar(A);

        cout << "\nUkuran Matriks B" << endl;
        inputUkuran(barisB, kolomB);

        Matriks B(barisB, kolomB);

        cout << "\nMatriks B" << endl;
        inputMatriksLuar(B);

        cetakSemua(A, B);
    }
};

int main() {
    Menu menu;

    while (true) {
        menu.tampilkanMenu();
        menu.prosesMenu();

        if (menu.getPilihan() == 5) {
            break;
        }
    }

    return 0;
}
