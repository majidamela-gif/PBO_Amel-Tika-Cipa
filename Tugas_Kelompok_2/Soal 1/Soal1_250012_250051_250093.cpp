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

#include <iostream>
#include <cmath>
using namespace std;

class Koordinat {
private:
    float absis;
    float ordinat;

public:
    Koordinat() {
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

    float getOrdinat() {
        return ordinat;
    }

    void setAbsis(float absis) {
        this->absis = absis;
    }

    void setOrdinat(float ordinat) {
        this->ordinat = ordinat;
    }

    void setKoordinat(float pAbsis, float pOrdinat) {
        absis = pAbsis;
        ordinat = pOrdinat;
    }

    void inputKoordinat() {
        cout << "Masukkan absis: ";
        cin >> absis;
        cout << "Masukkan ordinat: ";
        cin >> ordinat;
    }

    void cetakTitik() {
        cout << "(" << absis << ", " << ordinat << ")" << endl;
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
};


class Menu {
private:
    int pilihan;

public:
    void inputKoordinatLuar(Koordinat &titik) {
        float absis;
        float ordinat;

        cout << "Masukkan absis: ";
        cin >> absis;
        cout << "Masukkan ordinat: ";
        cin >> ordinat;

        titik.setKoordinat(absis, ordinat);
    }

    void cetakLuar(Koordinat titik, string label) {
        cout << label << " = ";
        titik.cetakTitik();
    }

    void cetakSemua(Koordinat titikA, Koordinat titikB) {
        cout << "\n==================================" << endl;
        cout << "          HASIL KOORDINAT" << endl;
        cout << "==================================" << endl;

        cout << "\n=== DATA TITIK ===" << endl;
        cetakLuar(titikA, "Titik A");
        cetakLuar(titikB, "Titik B");

        Koordinat titikTengahReturn = titikA.titikTengahReturn(titikB);

        Koordinat titikTengahVoid;
        titikTengahVoid.titikTengahVoid(titikA, titikB);

        cout << "\n=== TITIK TENGAH ===" << endl;
        cetakLuar(titikTengahReturn, "Return");
        cetakLuar(titikTengahVoid, "Void");

        Koordinat cerminXP1Return = titikA.cerminSumbuXReturn(titikA);

        Koordinat cerminXP1Void;
        cerminXP1Void.cerminSumbuXVoid(titikA);

        cout << "\n=== CERMIN TITIK A TERHADAP SUMBU X ===" << endl;
        cetakLuar(cerminXP1Return, "Return");
        cetakLuar(cerminXP1Void, "Void");

        Koordinat cerminXP2Return = titikB.cerminSumbuXReturn(titikB);

        Koordinat cerminXP2Void;
        cerminXP2Void.cerminSumbuXVoid(titikB);

        cout << "\n=== CERMIN TITIK B TERHADAP SUMBU X ===" << endl;
        cetakLuar(cerminXP2Return, "Return");
        cetakLuar(cerminXP2Void, "Void");

        Koordinat cerminYP1Return = titikA.cerminSumbuYReturn(titikA);

        Koordinat cerminYP1Void;
        cerminYP1Void.cerminSumbuYVoid(titikA);

        cout << "\n=== CERMIN TITIK A TERHADAP SUMBU Y ===" << endl;
        cetakLuar(cerminYP1Return, "Return");
        cetakLuar(cerminYP1Void, "Void");

        Koordinat cerminYP2Return = titikB.cerminSumbuYReturn(titikB);

        Koordinat cerminYP2Void;
        cerminYP2Void.cerminSumbuYVoid(titikB);

        cout << "\n=== CERMIN TITIK B TERHADAP SUMBU Y ===" << endl;
        cetakLuar(cerminYP2Return, "Return");
        cetakLuar(cerminYP2Void, "Void");

        cout << "\n=== JARAK ANTARA TITIK A DAN B ===" << endl;

        double jarakReturn = titikA.jarakReturn(titikA, titikB);

        cout << "Return : " << jarakReturn << endl;

        cout << "Void   : ";
        titikA.jarakVoid(titikA, titikB);
    }

    void tampilkanMenu() {
        cout << "\n==============================" << endl;
        cout << "       MENU KOORDINAT" << endl;
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
        Koordinat titikA(1, 2);
        Koordinat titikB(5, 4);

        cetakSemua(titikA, titikB);
    }

    void setter() {
        cout << "\n=== SETTER ===" << endl;
        Koordinat titikA;
        Koordinat titikB;

        titikA.setAbsis(5);
        titikA.setOrdinat(1);

        titikB.setKoordinat(9, 3);

        cetakSemua(titikA, titikB);
    }

    void inputDalam() {
        cout << "\n=== INPUT KOORDINAT DALAM ===" << endl;
        Koordinat titikA;
        Koordinat titikB;

        cout << "\nTitik A" << endl;
        titikA.inputKoordinat();

        cout << "\nTitik B" << endl;
        titikB.inputKoordinat();

        cetakSemua(titikA, titikB);
    }

    void inputLuar() {
        cout << "\n=== INPUT KOORDINAT LUAR ===" << endl;
        Koordinat titikA;
        Koordinat titikB;

        cout << "\nTitik A" << endl;
        inputKoordinatLuar(titikA);

        cout << "\nTitik B" << endl;
        inputKoordinatLuar(titikB);

        cetakSemua(titikA, titikB);
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