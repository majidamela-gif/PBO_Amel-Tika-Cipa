/*
Nama Program : Program Gaji Pegawai menggunakan Waktu
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program koordinat mencari titik tengah, cerminX dan cerminY
*/

#include <iostream>

using namespace std;

class Koordinat {
private:
    float absis;
    float ordinat;

public:
    Koordinat();
    Koordinat(float absis, float ordinat);

    void setAbsis(float absis);
    void setOrdinat(float ordinat);

    float getAbsis();
    float getOrdinat();

    void inputKoordinat();

    Koordinat titikTengah(Koordinat B);
    Koordinat cerminX();
    Koordinat cerminY();

    void cetakKoordinat();
};


Koordinat::Koordinat() {
    absis = 0;
    ordinat = 0;
}

Koordinat::Koordinat(float absis, float ordinat) {
    this->absis = absis;
    this->ordinat = ordinat;
}

void Koordinat::setAbsis(float absis) {
    this->absis = absis;
}

void Koordinat::setOrdinat(float ordinat) {
    this->ordinat = ordinat;
}

float Koordinat::getAbsis() {
    return absis;
}

float Koordinat::getOrdinat() {
    return ordinat;
}

void Koordinat::inputKoordinat() {
    cout << "Masukkan absis   : ";
    cin >> absis;

    cout << "Masukkan ordinat : ";
    cin >> ordinat;
}

Koordinat Koordinat::titikTengah(Koordinat B) {
    Koordinat T;

    T.absis = (absis + B.absis) / 2;
    T.ordinat = (ordinat + B.ordinat) / 2;

    return T;
}

Koordinat Koordinat::cerminX() {
    Koordinat C;

    C.absis = absis;
    C.ordinat = -ordinat;

    return C;
}

Koordinat Koordinat::cerminY() {
    Koordinat C;

    C.absis = -absis;
    C.ordinat = ordinat;

    return C;
}

void Koordinat::cetakKoordinat() {
    cout << "(" << absis << ", " << ordinat << ")" << endl;
}


void tampilkanMenu() {
    cout << endl;
    cout << "==================================" << endl;
    cout << "       MENU PROGRAM KOORDINAT" << endl;
    cout << "==================================" << endl;
    cout << "1. Input dari Luar Class" << endl;
    cout << "2. Input dari Dalam Class" << endl;
    cout << "3. Nilai melalui Constructor" << endl;
    cout << "4. Nilai melalui Setter" << endl;
    cout << "0. Keluar" << endl;
    cout << "==================================" << endl;
}

int pilihMenu() {
    int pilihan;

    do {
        cout << "Pilih cara input (1-4): ";
        cin >> pilihan;

        if (pilihan < 0 || pilihan > 4) {
            cout << "Pilihan tidak tersedia." << endl;
        }
    } while (pilihan < 0 || pilihan > 4);

    return pilihan;
}


int main() {
    int pilihan;

    do {
        tampilkanMenu();

        pilihan = pilihMenu();

        cout << endl;

        if (pilihan == 1) {
            cout << "OBJEK 1 (Input dari Luar Class)" << endl;

            Koordinat A;
            Koordinat B;

            float absis;
            float ordinat;

            cout << "Koordinat A" << endl;
            cout << "Masukkan absis   : ";
            cin >> absis;
            A.setAbsis(absis);

            cout << "Masukkan ordinat : ";
            cin >> ordinat;
            A.setOrdinat(ordinat);

            cout << endl;

            cout << "Koordinat B" << endl;
            cout << "Masukkan absis   : ";
            cin >> absis;
            B.setAbsis(absis);

            cout << "Masukkan ordinat : ";
            cin >> ordinat;
            B.setOrdinat(ordinat);

            Koordinat T = A.titikTengah(B);

            Koordinat CAX = A.cerminX();
            Koordinat CAY = A.cerminY();

            Koordinat CBX = B.cerminX();
            Koordinat CBY = B.cerminY();

            cout << endl;
            cout << "Koordinat A       : ";
            A.cetakKoordinat();

            cout << "Koordinat B       : ";
            B.cetakKoordinat();

            cout << "Titik tengah      : ";
            T.cetakKoordinat();

            cout << "Cermin X dari A   : ";
            CAX.cetakKoordinat();

            cout << "Cermin Y dari A   : ";
            CAY.cetakKoordinat();

            cout << "Cermin X dari B   : ";
            CBX.cetakKoordinat();

            cout << "Cermin Y dari B   : ";
            CBY.cetakKoordinat();
        }

        else if (pilihan == 2) {
            cout << "OBJEK 2 (Input dari Dalam Class)" << endl;

            Koordinat A;
            Koordinat B;

            cout << "Koordinat A" << endl;
            A.inputKoordinat();

            cout << endl;

            cout << "Koordinat B" << endl;
            B.inputKoordinat();

            Koordinat T = A.titikTengah(B);

            Koordinat CAX = A.cerminX();
            Koordinat CAY = A.cerminY();

            Koordinat CBX = B.cerminX();
            Koordinat CBY = B.cerminY();

            cout << endl;
            cout << "Koordinat A       : ";
            A.cetakKoordinat();

            cout << "Koordinat B       : ";
            B.cetakKoordinat();

            cout << "Titik tengah      : ";
            T.cetakKoordinat();

            cout << "Cermin X dari A   : ";
            CAX.cetakKoordinat();

            cout << "Cermin Y dari A   : ";
            CAY.cetakKoordinat();

            cout << "Cermin X dari B   : ";
            CBX.cetakKoordinat();

            cout << "Cermin Y dari B   : ";
            CBY.cetakKoordinat();
        }

        else if (pilihan == 3) {
            cout << "OBJEK 3 (Nilai melalui Constructor)" << endl;

            Koordinat A(2, 1);
            Koordinat B(6, 3);

            Koordinat T = A.titikTengah(B);

            Koordinat CAX = A.cerminX();
            Koordinat CAY = A.cerminY();

            Koordinat CBX = B.cerminX();
            Koordinat CBY = B.cerminY();

            cout << "Koordinat A       : ";
            A.cetakKoordinat();

            cout << "Koordinat B       : ";
            B.cetakKoordinat();

            cout << "Titik tengah      : ";
            T.cetakKoordinat();

            cout << "Cermin X dari A   : ";
            CAX.cetakKoordinat();

            cout << "Cermin Y dari A   : ";
            CAY.cetakKoordinat();

            cout << "Cermin X dari B   : ";
            CBX.cetakKoordinat();

            cout << "Cermin Y dari B   : ";
            CBY.cetakKoordinat();
        }

        else if (pilihan == 4) {
            cout << "OBJEK 4 (Set / Get Manual)" << endl;

            Koordinat A;
            Koordinat B;

            A.setAbsis(2);
            A.setOrdinat(1);

            B.setAbsis(6);
            B.setOrdinat(3);

            cout << "Absis A melalui getter   : "
                 << A.getAbsis() << endl;

            cout << "Ordinat A melalui getter : "
                 << A.getOrdinat() << endl;

            cout << endl;

            Koordinat T = A.titikTengah(B);

            Koordinat CAX = A.cerminX();
            Koordinat CAY = A.cerminY();

            Koordinat CBX = B.cerminX();
            Koordinat CBY = B.cerminY();

            cout << "Koordinat A       : ";
            A.cetakKoordinat();

            cout << "Koordinat B       : ";
            B.cetakKoordinat();

            cout << "Titik tengah      : ";
            T.cetakKoordinat();

            cout << "Cermin X dari A   : ";
            CAX.cetakKoordinat();

            cout << "Cermin Y dari A   : ";
            CAY.cetakKoordinat();

            cout << "Cermin X dari B   : ";
            CBX.cetakKoordinat();

            cout << "Cermin Y dari B   : ";
            CBY.cetakKoordinat();
        }

        else if (pilihan == 0) {
            cout << "Program selesai." << endl;
        }

    } while (pilihan != 0);

    return 0;
}