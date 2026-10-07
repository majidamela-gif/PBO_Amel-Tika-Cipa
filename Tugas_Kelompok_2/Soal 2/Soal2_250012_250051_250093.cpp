/*
Nama Program : Program Selisih Waktu OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 06 Oktober 2026
Deskripsi    : Buat program OOP untuk mencari selisih waktu
                ◼ Atribut : jam, menit, detik
                ◼ constructor, input (dalam & luar), output (dalam & luar)
               Method Proses (Cari selisih waktu) dengan cara 1 (fungsi return) dan cara 2 (void)
               Class Menu dipisah
*/

#include <iostream>
#include <cmath>
#include <string>
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
        setWaktu(jam, menit, detik);
    }

    int getJam() {
        return jam;
    }

    int getMenit() {
        return menit;
    }

    int getDetik() {
        return detik;
    }

    void setJam(int jam) {
        if (jam >= 0 && jam < 24) {
            this->jam = jam;
        } else {
            this->jam = 0;
            cout << "Jam harus 0-23." << endl;
        }
    }

    void setMenit(int menit) {
        if (menit >= 0 && menit < 60) {
            this->menit = menit;
        } else {
            this->menit = 0;
            cout << "Menit harus 0-59." << endl;
        }
    }

    void setDetik(int detik) {
        if (detik >= 0 && detik < 60) {
            this->detik = detik;
        } else {
            this->detik = 0;
            cout << "Detik harus 0-59." << endl;
        }
    }

    void setWaktu(int jam, int menit, int detik) {
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }

    void inputWaktu() {
        int jam;
        int menit;
        int detik;

        do {
            cout << "Masukkan Jam (0-23): ";
            cin >> jam;

            if (jam < 0 || jam >= 24) {
                cout << "Jam harus 0-23." << endl;
            }
        } while (jam < 0 || jam >= 24);

        do {
            cout << "Masukkan Menit (0-59): ";
            cin >> menit;

            if (menit < 0 || menit >= 60) {
                cout << "Menit harus 0-59." << endl;
            }
        } while (menit < 0 || menit >= 60);

        do {
            cout << "Masukkan Detik (0-59): ";
            cin >> detik;

            if (detik < 0 || detik >= 60) {
                cout << "Detik harus 0-59." << endl;
            }
        } while (detik < 0 || detik >= 60);

        setWaktu(jam, menit, detik);
    }

    int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    void selisihVoid(Waktu A, Waktu B) {
        int totalA = A.konvertDetik();
        int totalB = B.konvertDetik();

        int selisih = abs(totalA - totalB);

        this->jam = selisih / 3600;
        this->menit = (selisih % 3600) / 60;
        this->detik = selisih % 60;
    }

    Waktu selisihReturn(Waktu A) {
        Waktu selisih;

        int totalA = A.konvertDetik();
        int totalThis = this->konvertDetik();

        int hasil = abs(totalA - totalThis);

        selisih.jam = hasil / 3600;
        selisih.menit = (hasil % 3600) / 60;
        selisih.detik = hasil % 60;

        return selisih;
    }

    void cetakWaktu() {
        cout << jam << ":" << menit << ":" << detik << endl;
    }
};


class Menu {
private:
    int pilihan;

public:
    void inputWaktuLuar(Waktu &waktu) {
        int jam;
        int menit;
        int detik;

        do {
            cout << "Masukkan Jam (0-23): ";
            cin >> jam;

            if (jam < 0 || jam >= 24) {
                cout << "Jam harus 0-23." << endl;
            }
        } while (jam < 0 || jam >= 24);

        do {
            cout << "Masukkan Menit (0-59): ";
            cin >> menit;

            if (menit < 0 || menit >= 60) {
                cout << "Menit harus 0-59." << endl;
            }
        } while (menit < 0 || menit >= 60);

        do {
            cout << "Masukkan Detik (0-59): ";
            cin >> detik;

            if (detik < 0 || detik >= 60) {
                cout << "Detik harus 0-59." << endl;
            }
        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
    }

    void cetakLuar(Waktu waktu, string label) {
        cout << label << " = ";
        waktu.cetakWaktu();
    }

    void cetakSemua(Waktu A, Waktu B) {
        cout << "\n=== DATA WAKTU ===" << endl;

        cetakLuar(A, "Waktu A");
        cetakLuar(B, "Waktu B");

        Waktu hasilVoid;
        hasilVoid.selisihVoid(A, B);

        Waktu hasilReturn = A.selisihReturn(B);

        cetakLuar(hasilVoid, "Void");
        cetakLuar(hasilReturn, "Return");
    }

    void tampilkanMenu() {
        cout << "\n==============================" << endl;
        cout << "          MENU WAKTU" << endl;
        cout << "==============================" << endl;
        cout << "1. Constructor Berparameter" << endl;
        cout << "2. Setter" << endl;
        cout << "3. Input Dalam" << endl;
        cout << "4. Input Luar" << endl;
        cout << "5. Keluar" << endl;
        cout << "Pilih menu : ";

        cin >> pilihan;
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

    int getPilihan() {
        return pilihan;
    }

    void constructor() {
        cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;

        Waktu waktuA(13, 19, 44);
        Waktu waktuB(21, 26, 55);

        cetakSemua(waktuA, waktuB);
    }

    void setter() {
        cout << "\n=== SETTER ===" << endl;

        Waktu waktuA;
        Waktu waktuB;

        waktuA.setWaktu(7, 21, 34);
        waktuB.setWaktu(12, 10, 14);

        cetakSemua(waktuA, waktuB);
    }

    void inputDalam() {
        cout << "\n=== INPUT WAKTU DALAM ===" << endl;

        Waktu waktuA;
        Waktu waktuB;

        cout << "\nWaktu A" << endl;
        waktuA.inputWaktu();

        cout << "\nWaktu B" << endl;
        waktuB.inputWaktu();

        cetakSemua(waktuA, waktuB);
    }

    void inputLuar() {
        cout << "\n=== INPUT WAKTU LUAR ===" << endl;

        Waktu waktuA;
        Waktu waktuB;

        cout << "\nWaktu A" << endl;
        inputWaktuLuar(waktuA);

        cout << "\nWaktu B" << endl;
        inputWaktuLuar(waktuB);

        cetakSemua(waktuA, waktuB);
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