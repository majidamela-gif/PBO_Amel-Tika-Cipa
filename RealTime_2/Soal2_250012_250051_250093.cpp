/*
Nama Program : Program Penjumlahan dan Perkalian 2 Matriks
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 08 Oktober 2026
Deskripsi    : Program OOP untuk mencari penjumlahan dan perkalian 2 buah matriks
               Prosesnya berbentuk fungsi dan berbentuk void (passing object)
*/

#include <iostream>
using namespace std;

class Matriks {
private:
    int baris;
    int kolom;
    int nilai[10][10];

public:
    Matriks() {
        baris = 0;
        kolom = 0;
    }

    Matriks(int baris, int kolom) {
        this->baris = baris;
        this->kolom = kolom;

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = 0;
            }
        }
    }

    int getBaris() {
        return baris;
    }

    int getKolom() {
        return kolom;
    }

    void setBaris(int baris) {
        this->baris = baris;
    }

    void setKolom(int kolom) {
        this->kolom = kolom;
    }

    void setNilai(int i, int j, int nilai) {
        this->nilai[i][j] = nilai;
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

    void addMatriksVoid(const Matriks &A, const Matriks &B) {
        baris = A.baris;
        kolom = A.kolom;

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }
    }

    Matriks addMatriksReturn(const Matriks &A, const Matriks &B) {
        Matriks hasil(A.baris, A.kolom);

        for (int i = 0; i < A.baris; i++) {
            for (int j = 0; j < A.kolom; j++) {
                hasil.nilai[i][j] = A.nilai[i][j] + B.nilai[i][j];
            }
        }
        return hasil;
    }

    void kaliMatriksVoid(const Matriks &A, const Matriks &B) {
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

    Matriks kaliMatriksReturn(const Matriks &A, const Matriks &B) {
        Matriks hasil(A.baris, B.kolom);

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
};

class Menu {
private:
    int pilihan;

public:
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
                cout << "\nProgram selesai." << endl;
                break;

            default:
                cout << "\nPilihan tidak tersedia!" << endl;
        }
    }

    void cetakLuar(Matriks matriks, string label) {
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

        if (A.getBaris() == B.getBaris() && A.getKolom() == B.getKolom()) {
            Matriks hasilTambahReturn = A.addMatriksReturn(A, B);

            Matriks hasilTambahVoid;
            hasilTambahVoid.addMatriksVoid(A, B);

            cout << "\n=== PENJUMLAHAN A + B ===" << endl;
            cout << "Return :" << endl;
            hasilTambahReturn.cetakMatriks();

            cout << "\nVoid :" << endl;
            hasilTambahVoid.cetakMatriks();
        } else {
            cout << "\n=== PENJUMLAHAN A + B ===" << endl;
            cout << "Matriks A dan B tidak dapat dijumlahkan." << endl;
            cout << "Ukuran matriks harus sama." << endl;
        }

        if (A.getKolom() == B.getBaris()) {
            Matriks hasilKaliReturn = A.kaliMatriksReturn(A, B);

            Matriks hasilKaliVoid;
            hasilKaliVoid.kaliMatriksVoid(A, B);

            cout << "\n=== PERKALIAN A x B ===" << endl;
            cout << "Return :" << endl;
            hasilKaliReturn.cetakMatriks();

            cout << "\nVoid :" << endl;
            hasilKaliVoid.cetakMatriks();
        }
        else {
            cout << "\n=== PERKALIAN A x B ===" << endl;
            cout << "Matriks A dan B tidak dapat dikalikan." << endl;
            cout << "Kolom A harus sama dengan baris B." << endl;
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

    void inputDalam() {
        cout << "\n=== INPUT MATRIKS DALAM ===" << endl;
        int barisA, kolomA;
        int barisB, kolomB;

        cout << "Ukuran Matriks A" << endl;
        cout << "Masukkan jumlah baris : ";
        cin >> barisA;
        cout << "Masukkan jumlah kolom : ";
        cin >> kolomA;

        Matriks A(barisA, kolomA);
        cout << "\nMatriks A" << endl;
        A.inputMatriks();

        cout << "\nUkuran Matriks B" << endl;
        cout << "Masukkan jumlah baris : ";
        cin >> barisB;
        cout << "Masukkan jumlah kolom : ";
        cin >> kolomB;

        Matriks B(barisB, kolomB);
        cout << "\nMatriks B" << endl;
        B.inputMatriks();

        cetakSemua(A, B);
    }

    void inputMatriksLuar(Matriks &M) {
        for (int i = 0; i < M.getBaris(); i++) {
            for (int j = 0; j < M.getKolom(); j++) {
                int nilai;
                cout << "Nilai [" << i + 1 << "][" << j + 1 << "] = ";
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
        cout << "Masukkan jumlah baris : ";
        cin >> barisA;
        cout << "Masukkan jumlah kolom : ";
        cin >> kolomA;

        Matriks A(barisA, kolomA);
        cout << "\nMatriks A" << endl;
        inputMatriksLuar(A);

        cout << "\nUkuran Matriks B" << endl;
        cout << "Masukkan jumlah baris : ";
        cin >> barisB;
        cout << "Masukkan jumlah kolom : ";
        cin >> kolomB;

        Matriks B(barisB, kolomB);
        cout << "\nMatriks B" << endl;
        inputMatriksLuar(B);

        cetakSemua(A, B);
    }
};


int main() {
    Menu menu;

    do {
        menu.tampilkanMenu();
        menu.prosesMenu();
    } while (menu.getPilihan() != 5);

    return 0;
}