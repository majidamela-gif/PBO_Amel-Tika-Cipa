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

#include <iostream>
#include <cmath>
using namespace std;

class Koordinat {
private:
    float absis;
    float ordinat;

public:
    Koordinat(){
        absis = 0;
        ordinat = 0;
    }

    Koordinat(float absis, float ordinat) {
        this->absis = absis;
        this->ordinat = ordinat; 
    }

    float getAbsis() {
        return absis;
    }

    void setAbsis(float absis) {
        this->absis = absis;
    }

    float getOrdinat() {
        return ordinat;
    }

    void setOrdinat(float ordinat) {
        this->ordinat = ordinat;
    }

    void inputKoordinat() {
        cout << "Masukkan absis: ";
        cin >> absis;
        cout << "Masukkan ordinat: ";
        cin >> ordinat;
    }

    void setKoordinat(float pAbsis, float pOrdinat) {
        absis = pAbsis;
        ordinat = pOrdinat;
    }

    void titikTengahVoid(Koordinat p1, Koordinat p2) {
        this->absis = (p1.absis + p2.absis) / 2;
        this->ordinat = (p1.ordinat + p2.ordinat) / 2;
    }

    Koordinat titikTengahReturn(Koordinat p) {
        Koordinat hasil;

        hasil.absis = (p.absis + this->absis) / 2;
        hasil.ordinat = (p.ordinat + this->ordinat) / 2;

        return hasil;
    }

    void cerminSumbuXVoid(Koordinat p) {
        this->absis = p.absis;
        this->ordinat = p.ordinat * (-1);
    }

    Koordinat cerminSumbuXReturn(Koordinat p) {
        Koordinat hasil;

        hasil.absis = p.absis;
        hasil.ordinat = p.ordinat * (-1);

        return hasil;
    }

    void cerminSumbuYVoid(Koordinat p) {
        this->absis = p.absis * (-1);
        this->ordinat = p.ordinat;
    }

    Koordinat cerminSumbuYReturn(Koordinat p) {
        Koordinat hasil;

        hasil.absis = p.absis * (-1);
        hasil.ordinat = p.ordinat;

        return hasil;
    }

    void jarakVoid(Koordinat p1, Koordinat p2) {
        double jarak = sqrt(pow(p2.absis - p1.absis, 2) + pow(p2.ordinat - p1.ordinat, 2));
        cout << jarak << endl;
    }

    double jarakReturn(Koordinat p1, Koordinat p2) {
        return sqrt(pow(p2.absis - p1.absis, 2) + pow(p2.ordinat - p1.ordinat, 2));
    }

    void cetakTitik() {
        cout << "(" << absis << ", " << ordinat << ")" << endl;
    }

    void cetak(Koordinat p1, Koordinat p2) {
        cout << "\n=== DATA TITIK ===" << endl;
        cout << "Titik A : ";
        p1.cetakTitik();

        cout << "Titik B : ";
        p2.cetakTitik();

        Koordinat hasilVoid;
        hasilVoid.titikTengahVoid(p1, p2);

        Koordinat hasilReturn = p1.titikTengahReturn(p2);

        cout << "\n=== TITIK TENGAH ===" << endl;

        cout << "Void   : ";
        hasilVoid.cetakTitik();

        cout << "Return : ";
        hasilReturn.cetakTitik();

        Koordinat cerminXP1Void;
        cerminXP1Void.cerminSumbuXVoid(p1);

        Koordinat cerminXP1Return = p1.cerminSumbuXReturn(p1);

        cout << "\n=== CERMIN A TERHADAP SUMBU X ===" << endl;

        cout << "Void   : ";
        cerminXP1Void.cetakTitik();

        cout << "Return : ";
        cerminXP1Return.cetakTitik();

        Koordinat cerminXP2Void;
        cerminXP2Void.cerminSumbuXVoid(p2);

        Koordinat cerminXP2Return = p2.cerminSumbuXReturn(p2);

        cout << "\n=== CERMIN B TERHADAP SUMBU X ===" << endl;

        cout << "Void   : ";
        cerminXP2Void.cetakTitik();

        cout << "Return : ";
        cerminXP2Return.cetakTitik();

        Koordinat cerminYP1Void;
        cerminYP1Void.cerminSumbuYVoid(p1);

        Koordinat cerminYP1Return = p1.cerminSumbuYReturn(p1);

        cout << "\n=== CERMIN A TERHADAP SUMBU Y ===" << endl;

        cout << "Void   : ";
        cerminYP1Void.cetakTitik();

        cout << "Return : ";
        cerminYP1Return.cetakTitik();

        Koordinat cerminYP2Void;
        cerminYP2Void.cerminSumbuYVoid(p2);

        Koordinat cerminYP2Return = p2.cerminSumbuYReturn(p2);

        cout << "\n=== CERMIN B TERHADAP SUMBU Y ===" << endl;

        cout << "Void   : ";
        cerminYP2Void.cetakTitik();

        cout << "Return : ";
        cerminYP2Return.cetakTitik();

        cout << "\n=== JARAK ===" << endl;

        cout << "Void   : ";
        p1.jarakVoid(p1, p2);

        double jarakReturn = p1.jarakReturn(p1, p2);

        cout << "Return : " << jarakReturn << endl;
    }
};

int menu() {
    cout << "\n==============================" << endl;
    cout << "       MENU KOORDINAT" << endl;
    cout << "==============================" << endl;
    cout << "1. Constructor Berparameter" << endl;
    cout << "2. Setter" << endl;
    cout << "3. Input Koordinat" << endl;
    cout << "0. Keluar" << endl;
    cout << "Pilih menu : ";

    int pilihan;
    cin >> pilihan;

    return pilihan;
}

int main() {
    int pilihan;

    Koordinat titikA;
    Koordinat titikB;
    Koordinat titikT;

    do {
        pilihan = menu();

        switch (pilihan) {
            case 1:
                cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;

                titikA = Koordinat(1, 2);
                titikB = Koordinat(5, 4);

                titikT.cetak(titikA, titikB);

                break;

            case 2:
                cout << "\n=== SETTER ===" << endl;

                titikA.setKoordinat(5, 1);
                titikB.setKoordinat(9, 3);

                titikT.cetak(titikA, titikB);

                break;

            case 3:
                cout << "\n=== INPUT KOORDINAT ===" << endl;

                cout << "\nMasukkan data Titik A" << endl;
                titikA.inputKoordinat();

                cout << "\nMasukkan data Titik B" << endl;
                titikB.inputKoordinat();

                titikT.cetak(titikA, titikB);

                break;

            case 0:
                cout << "\nProgram selesai." << endl;
                break;

            default:
                cout << "\nPilihan tidak tersedia!" << endl;
        }

    } while (pilihan != 0);

    return 0;
}