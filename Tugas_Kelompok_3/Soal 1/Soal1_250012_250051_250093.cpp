
/*
Nama Program : Program Nilai (Array 1 Dimensi)
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 13 Oktober 2026
Deskripsi    : Program OOP untuk mencari nilai rata-rata,
               nilai tertinggi, nilai terendah, dan sorting
               dari kumpulan data bertipe array of integer.
*/

#include <iostream>
#include <string>
using namespace std;

class MyLarik {
private:
    int ukuran;
    int* nilai;

public:
    MyLarik() {
        ukuran = 0;
        nilai = nullptr;
    }

    MyLarik(int ukuran) {
        this->ukuran = ukuran;
        nilai = new int[ukuran];

        for (int i = 0; i < ukuran; i++) {
            nilai[i] = 0;
        }
    }

    MyLarik(int ukuran, int data[]) {
        this->ukuran = ukuran;
        nilai = new int[ukuran];

        for (int i = 0; i < ukuran; i++) {
            nilai[i] = data[i];
        }
    }

    MyLarik(const MyLarik& A) {
        ukuran = A.ukuran;

        if (ukuran > 0) {
            nilai = new int[ukuran];

            for (int i = 0; i < ukuran; i++) {
                nilai[i] = A.nilai[i];
            }
        } else {
            nilai = nullptr;
        }
    }

    MyLarik& operator=(const MyLarik& A) {
        if (this != &A) {
            delete[] nilai;
            ukuran = A.ukuran;

            if (ukuran > 0) {
                nilai = new int[ukuran];

                for (int i = 0; i < ukuran; i++) {
                    nilai[i] = A.nilai[i];
                }
            } else {
                nilai = nullptr;
            }
        }

        return *this;
    }

    ~MyLarik() {
        delete[] nilai;
    }

    int getUkuran() const {
        return ukuran;
    }

    int getNilai(int i) const {
        return nilai[i];
    }

    void setUkuran(int ukuran) {
        delete[] nilai;

        this->ukuran = ukuran;

        if (ukuran > 0) {
            nilai = new int[ukuran];

            for (int i = 0; i < ukuran; i++) {
                nilai[i] = 0;
            }
        } else {
            nilai = nullptr;
        }
    }

    void setNilai(int i, int nilai) {
        this->nilai[i] = nilai;
    }

    int inputUkuran() {
        int ukuran;

        cout << "Masukkan ukuran Larik: ";
        cin >> ukuran;

        while (ukuran <= 0) {
            cout << "Ukuran harus lebih dari 0!" << endl;
            cout << "Masukkan ukuran Larik: ";
            cin >> ukuran;
        }

        return ukuran;
    }

    void isiNilai() {
        for (int i = 0; i < ukuran; i++) {
            cout << "Masukkan nilai ke-" << i + 1 << " = ";
            cin >> nilai[i];
        }
    }

    double cariRata() const {
        double jumlah = 0;

        for (int i = 0; i < ukuran; i++) {
            jumlah += nilai[i];
        }

        return jumlah / ukuran;
    }

    void cariRataVoid(const MyLarik& A) {
        setUkuran(A.getUkuran());

        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        double jumlah = 0;

        for (int i = 0; i < ukuran; i++) {
            jumlah += nilai[i];
        }

        cout << "Rata-rata (Void) = "
             << jumlah / ukuran << endl;
    }

    int nilaiMax() const {
        int tertinggi = nilai[0];

        for (int i = 1; i < ukuran; i++) {
            if (nilai[i] > tertinggi) {
                tertinggi = nilai[i];
            }
        }

        return tertinggi;
    }

    void nilaiMaxVoid(const MyLarik& A) {
        setUkuran(A.getUkuran());

        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        int tertinggi = nilai[0];

        for (int i = 1; i < ukuran; i++) {
            if (nilai[i] > tertinggi) {
                tertinggi = nilai[i];
            }
        }

        cout << "Nilai Tertinggi (Void) = "
             << tertinggi << endl;
    }

    int nilaiMin() const {
        int terendah = nilai[0];

        for (int i = 1; i < ukuran; i++) {
            if (nilai[i] < terendah) {
                terendah = nilai[i];
            }
        }

        return terendah;
    }

    void nilaiMinVoid(const MyLarik& A) {
        setUkuran(A.getUkuran());

        for (int i = 0; i < ukuran; i++) {
            nilai[i] = A.nilai[i];
        }

        int terendah = nilai[0];

        for (int i = 1; i < ukuran; i++) {
            if (nilai[i] < terendah) {
                terendah = nilai[i];
            }
        }

        cout << "Nilai Terendah (Void) = "
             << terendah << endl;
    }

    MyLarik sortingAsc(const MyLarik& A) const {
        MyLarik hasil(A);

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

    void sortingAscVoid(const MyLarik& A) {
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

    MyLarik sortingDesc(const MyLarik& A) const {
        MyLarik hasil(A);

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

    void sortingDescVoid(const MyLarik& A) {
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

    void cetakNilai() const {
        cout << "Nilai: ";

        for (int i = 0; i < ukuran; i++) {
            cout << nilai[i] << " ";
        }

        cout << endl;
    }

    void cetakHasil() {
        cout << "\n=== HASIL FUNGSI (RETURN) ===" << endl;
        cout << "Rata-rata = " << cariRata() << endl;
        cout << "Nilai Tertinggi = " << nilaiMax() << endl;
        cout << "Nilai Terendah = " << nilaiMin() << endl;

        cout << "\n=== HASIL VOID ===" << endl;

        MyLarik hasilVoid;
        hasilVoid.cariRataVoid(*this);
        hasilVoid.nilaiMaxVoid(*this);
        hasilVoid.nilaiMinVoid(*this);
    }
};

class Menu {
private:
    int pilihan;

public:
    void tampilkanMenu() {
        cout << "\n==============================" << endl;
        cout << "       MENU PROGRAM NILAI" << endl;
        cout << "==============================" << endl;
        cout << "1. Constructor Berparameter" << endl;
        cout << "2. Setter" << endl;
        cout << "3. Input Dalam" << endl;
        cout << "4. Input Luar" << endl;
        cout << "5. Keluar" << endl;
        cout << "==============================" << endl;
        cout << "Pilih menu: ";
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

    void inputLarikLuar(MyLarik& A) {
        for (int i = 0; i < A.getUkuran(); i++) {
            int nilai;

            cout << "Masukkan nilai ke-" << i + 1 << " = ";
            cin >> nilai;

            A.setNilai(i, nilai);
        }
    }

    void cetakLuar(const MyLarik& A, string label) {
        cout << label << endl;
        A.cetakNilai();
    }

    void cetakSemua(MyLarik& A) {
        cout << "\n==============================" << endl;
        cout << "       HASIL PROGRAM NILAI" << endl;
        cout << "==============================" << endl;

        cetakLuar(A, "\nData Larik A:");
        A.cetakHasil();

        MyLarik hasilReturn = A.sortingAsc(A);
        MyLarik hasilVoid;

        hasilVoid.sortingAscVoid(A);

        cout << "\n=== SORTING RETURN (ASCENDING) ===" << endl;
        hasilReturn.cetakNilai();

        cout << "\n=== SORTING VOID (ASCENDING) ===" << endl;
        hasilVoid.cetakNilai();

        hasilReturn = A.sortingDesc(A);
        hasilVoid.sortingDescVoid(A);

        cout << "\n=== SORTING RETURN (DESCENDING) ===" << endl;
        hasilReturn.cetakNilai();

        cout << "\n=== SORTING VOID (DESCENDING) ===" << endl;
        hasilVoid.cetakNilai();
    }

    void constructor() {
        cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;

        int data[5] = {80, 60, 90, 70, 100};
        MyLarik A(5, data);

        cetakSemua(A);
    }

    void setter() {
        cout << "\n=== SETTER ===" << endl;

        MyLarik A;
        A.setUkuran(5);
        A.setNilai(0, 75);
        A.setNilai(1, 85);
        A.setNilai(2, 65);
        A.setNilai(3, 95);
        A.setNilai(4, 80);

        cetakSemua(A);
    }

    void inputDalam() {
        cout << "\n=== INPUT DALAM ===" << endl;

        MyLarik A;
        int ukuran = A.inputUkuran();

        A.setUkuran(ukuran);
        A.isiNilai();

        cetakSemua(A);
    }

    void inputLuar() {
        cout << "\n=== INPUT LUAR ===" << endl;

        MyLarik sementara;
        int ukuran = sementara.inputUkuran();

        MyLarik A(ukuran);
        inputLarikLuar(A);

        cetakSemua(A);
    }
};

class Main {
public:
    static void main() {
        Menu menu;
        int pilihan;

        do {
            menu.tampilkanMenu();
            pilihan = menu.getPilihan();
            menu.prosesMenu();
        } while (pilihan != 5);
    }
};

int main() {
    Main::main();
    return 0;
}
