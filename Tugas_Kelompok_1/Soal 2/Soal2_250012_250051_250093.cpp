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

#include <iostream>
#include <cmath>
using namespace std;

class Waktu {
private:
    int jam;
    int menit;
    int detik;

public:
    Waktu() {
        jam = 0;
        menit = 0;
        detik = 0;
    }

    Waktu(int jam, int menit, int detik) {
        this->jam = jam;
        this->menit = menit;
        this->detik = detik;
    }

    int getJam() {
        return jam;
    }

    void setJam(int jam) {
        this->jam = jam;
    }

    int getMenit() {
        return menit;
    }

    void setMenit(int menit) {
        this->menit = menit;
    }

    int getDetik() {
        return detik;
    }

    void setDetik(int detik) {
        this->detik = detik;
    }

    void inputWaktu() {
        cout << "Masukkan Jam: ";
        cin >> jam;
        cout << "Masukkan Menit: ";
        cin >> menit;
        cout << "Masukkan Detik: ";
        cin >> detik;
    }

    void setWaktu(int jam, int menit, int detik) {
        this->jam = jam;
        this->menit = menit;
        this->detik = detik;
    }

    int konversiDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    void selisihVoid(Waktu A, Waktu B) {
        int totalA = A.konversiDetik();
        int totalB = B.konversiDetik();

        int selisih = abs(totalA - totalB);

        this->jam = selisih / 3600;
        this->menit = (selisih % 3600) / 60;
        this->detik = selisih % 60;
    }

    Waktu selisihReturn(Waktu A) {
        Waktu selisih;

        int totalA = A.konversiDetik();
        int totalThis = this->konversiDetik();

        int hasil = abs(totalA - totalThis);

        selisih.jam = hasil / 3600;
        selisih.menit = (hasil % 3600) / 60;
        selisih.detik = hasil % 60;

        return selisih;
    }

    void cetakWaktu() {
        cout << jam << ":" << menit << ":" << detik << endl;
    }

    void cetak(Waktu A, Waktu B) {
        cout << "\n=== DATA WAKTU ===" << endl;
        cout << "Waktu A: ";
        A.cetakWaktu();
        cout << "Waktu B: ";
        B.cetakWaktu();

        Waktu hasilVoid;
        hasilVoid.selisihVoid(A, B);

        Waktu hasilReturn = A.selisihReturn(B);

        cout << "Selisih Void: ";
        hasilVoid.cetakWaktu();
        cout << "Selisih Return: ";
        hasilReturn.cetakWaktu();
    }
};

int menu() {
    cout << "\n==============================" << endl;
    cout << "          MENU WAKTU" << endl;
    cout << "==============================" << endl;
    cout << "1. Constructor Berparameter" << endl;
    cout << "2. Setter" << endl;
    cout << "3. Input Waktu" << endl;
    cout << "4. Keluar" << endl;
    cout << "Pilih menu : ";

    int pilihan;
    cin >> pilihan;

    return pilihan;
}

int main() {
    int pilihan;

    Waktu waktuA;
    Waktu waktuB;
    Waktu waktuT;

    do {
        pilihan = menu();

        switch (pilihan) {
            case 1:
                cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;
                waktuA = Waktu(8, 30, 15);
                waktuB = Waktu(11, 45, 10);
                waktuT.cetak(waktuA, waktuB);

                break;

            case 2:
                cout << "\n=== SETTER ===" << endl;
                waktuA.setWaktu(7, 24, 45);
                waktuB.setWaktu(16, 15, 30);
                waktuT.cetak(waktuA, waktuB);

                break;

            case 3:
                cout << "\n=== INPUT WAKTU ===" << endl;
                cout << "\nMasukkan data Waktu A" << endl;
                waktuA.inputWaktu();
                cout << "\nMasukkan data Waktu B" << endl;
                waktuB.inputWaktu();
                waktuT.cetak(waktuA, waktuB);

                break;

            case 4:
                cout << "\nProgram selesai." << endl;
                break;

            default:
                cout << "\nPilihan tidak tersedia!" << endl;
        }

    } while (pilihan != 4);

    return 0;
}