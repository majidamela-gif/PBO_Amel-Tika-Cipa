/*
Nama Program : Program Gaji Pegawai menggunakan Waktu
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program gaji pegawai (nomor 3) ditambahkan waktu secara OOP
               dibuat 2 Class (Class GajiPegawai dan Class Waktu)
               Waktu: Waktu datang, Waktu pulang, waktu lamaKerja
*/

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Waktu {
private:
    int jamDatang;
    int menitDatang;
    int detikDatang;

    int jamPulang;
    int menitPulang;
    int detikPulang;

    int jamLamaKerja;
    int menitLamaKerja;
    int detikLamaKerja;

public:
    Waktu();
    Waktu(int jamDatang, int menitDatang, int detikDatang,
          int jamPulang, int menitPulang, int detikPulang);

    void setJamDatang(int jamDatang);
    void setMenitDatang(int menitDatang);
    void setDetikDatang(int detikDatang);

    void setJamPulang(int jamPulang);
    void setMenitPulang(int menitPulang);
    void setDetikPulang(int detikPulang);

    int getJamDatang();
    int getMenitDatang();
    int getDetikDatang();

    int getJamPulang();
    int getMenitPulang();
    int getDetikPulang();

    int getJamLamaKerja();
    int getMenitLamaKerja();
    int getDetikLamaKerja();

    void inputWaktu();
    void hitungLamaKerja();
};


Waktu::Waktu() {
    jamDatang = 0;
    menitDatang = 0;
    detikDatang = 0;

    jamPulang = 0;
    menitPulang = 0;
    detikPulang = 0;

    jamLamaKerja = 0;
    menitLamaKerja = 0;
    detikLamaKerja = 0;
}


Waktu::Waktu(int jamDatang, int menitDatang, int detikDatang,
             int jamPulang, int menitPulang, int detikPulang) {
    this->jamDatang = jamDatang;
    this->menitDatang = menitDatang;
    this->detikDatang = detikDatang;

    this->jamPulang = jamPulang;
    this->menitPulang = menitPulang;
    this->detikPulang = detikPulang;

    jamLamaKerja = 0;
    menitLamaKerja = 0;
    detikLamaKerja = 0;
}


void Waktu::setJamDatang(int jamDatang) {
    this->jamDatang = jamDatang;
}

void Waktu::setMenitDatang(int menitDatang) {
    this->menitDatang = menitDatang;
}

void Waktu::setDetikDatang(int detikDatang) {
    this->detikDatang = detikDatang;
}


void Waktu::setJamPulang(int jamPulang) {
    this->jamPulang = jamPulang;
}

void Waktu::setMenitPulang(int menitPulang) {
    this->menitPulang = menitPulang;
}

void Waktu::setDetikPulang(int detikPulang) {
    this->detikPulang = detikPulang;
}


int Waktu::getJamDatang() {
    return jamDatang;
}

int Waktu::getMenitDatang() {
    return menitDatang;
}

int Waktu::getDetikDatang() {
    return detikDatang;
}


int Waktu::getJamPulang() {
    return jamPulang;
}

int Waktu::getMenitPulang() {
    return menitPulang;
}

int Waktu::getDetikPulang() {
    return detikPulang;
}


int Waktu::getJamLamaKerja() {
    return jamLamaKerja;
}

int Waktu::getMenitLamaKerja() {
    return menitLamaKerja;
}

int Waktu::getDetikLamaKerja() {
    return detikLamaKerja;
}


void Waktu::inputWaktu() {
    cout << "Masukkan Waktu Datang" << endl;

    cout << "Jam datang   : ";
    cin >> jamDatang;

    cout << "Menit datang : ";
    cin >> menitDatang;

    cout << "Detik datang : ";
    cin >> detikDatang;

    cout << endl;

    cout << "Masukkan Waktu Pulang" << endl;

    cout << "Jam pulang   : ";
    cin >> jamPulang;

    cout << "Menit pulang : ";
    cin >> menitPulang;

    cout << "Detik pulang : ";
    cin >> detikPulang;

    hitungLamaKerja();
}


void Waktu::hitungLamaKerja() {
    int waktuDatang;
    int waktuPulang;
    int lamaKerja;

    waktuDatang = jamDatang * 3600
                + menitDatang * 60
                + detikDatang;

    waktuPulang = jamPulang * 3600
                + menitPulang * 60
                + detikPulang;

    lamaKerja = waktuPulang - waktuDatang;

    jamLamaKerja = lamaKerja / 3600;
    lamaKerja = lamaKerja % 3600;

    menitLamaKerja = lamaKerja / 60;
    detikLamaKerja = lamaKerja % 60;
}


class GajiPegawai {
private:
    string nip;
    string nama;
    int gol;
    Waktu waktu;

public:
    GajiPegawai();
    GajiPegawai(string nip, string nama, int gol, Waktu waktu);

    void setNama(string nama);
    void setNip(string nip);
    bool setGol(int gol);
    void setWaktu(Waktu waktu);
    void setGajiPegawai(string nip, string nama, int gol, Waktu waktu);

    string getNama();
    string getNip();
    int getGol();
    Waktu getWaktu();

    void inputGajiPegawai();

    double hitungGapok();
    double hitungTunjangan();
    double hitungPotongan();
    double hitungGatot();

    void output();
};


GajiPegawai::GajiPegawai() {
    nip = "";
    nama = "";
    gol = 0;
    waktu = Waktu();
}


GajiPegawai::GajiPegawai(string nip, string nama, int gol, Waktu waktu) {
    this->nip = nip;
    this->nama = nama;
    setGol(gol);
    this->waktu = waktu;
}


void GajiPegawai::setNama(string nama) {
    this->nama = nama;
}

void GajiPegawai::setNip(string nip) {
    this->nip = nip;
}

bool GajiPegawai::setGol(int gol) {
    if (gol >= 1 && gol <= 4) {
        this->gol = gol;
        return true;
    }

    return false;
}

void GajiPegawai::setWaktu(Waktu waktu) {
    this->waktu = waktu;
}

void GajiPegawai::setGajiPegawai(string nip, string nama, int gol, Waktu waktu) {
    this->nip = nip;
    this->nama = nama;
    setGol(gol);
    this->waktu = waktu;
}


string GajiPegawai::getNama() {
    return nama;
}

string GajiPegawai::getNip() {
    return nip;
}

int GajiPegawai::getGol() {
    return gol;
}

Waktu GajiPegawai::getWaktu() {
    return waktu;
}


void GajiPegawai::inputGajiPegawai() {
    cout << "Masukkan NIP : ";
    cin >> nip;

    cin.ignore();

    cout << "Masukkan Nama : ";
    getline(cin, nama);

    int golInput;
    bool valid;

    do {
        cout << "Masukkan Gol : ";
        cin >> golInput;

        valid = setGol(golInput);

        if (!valid) {
            cout << "Gol pegawai hanya boleh 1 - 4." << endl;
        }

    } while (!valid);

    cout << endl;

    waktu.inputWaktu();
}


double GajiPegawai::hitungGapok() {
    double gapok = 0;

    if (this->gol == 1) {
        gapok = 1500000;
    }
    else if (this->gol == 2) {
        gapok = 2000000;
    }
    else if (this->gol == 3) {
        gapok = 3000000;
    }
    else if (this->gol == 4) {
        gapok = 5000000;
    }

    return gapok;
}


double GajiPegawai::hitungTunjangan() {
    double persen = 0;

    if (this->gol == 1) {
        persen = 10;
    }
    else if (this->gol == 2 || this->gol == 3) {
        persen = 12;
    }
    else if (this->gol == 4) {
        persen = 15;
    }

    return hitungGapok() * persen / 100;
}


double GajiPegawai::hitungPotongan() {
    double persen = 0;

    if (this->gol == 1) {
        persen = 1;
    }
    else if (this->gol == 2 || this->gol == 3) {
        persen = 2;
    }
    else if (this->gol == 4) {
        persen = 4;
    }

    return hitungGapok() * persen / 100;
}


double GajiPegawai::hitungGatot() {
    return hitungGapok() + hitungTunjangan() - hitungPotongan();
}


string formatRupiah(double angka) {
    long long nilai = (long long) angka;
    string hasil = to_string(nilai);

    int posisi = hasil.length() - 3;

    while (posisi > 0) {
        hasil.insert(posisi, ".");
        posisi -= 3;
    }

    return "Rp " + hasil;
}


void GajiPegawai::output() {
    string datang =
        (waktu.getJamDatang() < 10 ? "0" : "") + to_string(waktu.getJamDatang()) + ":" +
        (waktu.getMenitDatang() < 10 ? "0" : "") + to_string(waktu.getMenitDatang()) + ":" +
        (waktu.getDetikDatang() < 10 ? "0" : "") + to_string(waktu.getDetikDatang());

    string pulang =
        (waktu.getJamPulang() < 10 ? "0" : "") + to_string(waktu.getJamPulang()) + ":" +
        (waktu.getMenitPulang() < 10 ? "0" : "") + to_string(waktu.getMenitPulang()) + ":" +
        (waktu.getDetikPulang() < 10 ? "0" : "") + to_string(waktu.getDetikPulang());

    string lamaKerja =
        (waktu.getJamLamaKerja() < 10 ? "0" : "") + to_string(waktu.getJamLamaKerja()) + ":" +
        (waktu.getMenitLamaKerja() < 10 ? "0" : "") + to_string(waktu.getMenitLamaKerja()) + ":" +
        (waktu.getDetikLamaKerja() < 10 ? "0" : "") + to_string(waktu.getDetikLamaKerja());

    cout << endl;

    cout << "========================================================================================================================" << endl;

    cout << "| "
         << left << setw(14) << "NIP"
         << "| "
         << left << setw(20) << "Nama"
         << "| "
         << left << setw(5) << "Gol"
         << "| "
         << right << setw(16) << "Gapok"
         << " | "
         << right << setw(16) << "Tunjangan"
         << " | "
         << right << setw(16) << "Potongan"
         << " | "
         << right << setw(16) << "Gatot"
         << " |" << endl;

    cout << "========================================================================================================================" << endl;

    cout << "| "
         << left << setw(14) << nip
         << "| "
         << left << setw(20) << nama
         << "| "
         << left << setw(5) << gol
         << "| "
         << right << setw(16) << formatRupiah(hitungGapok())
         << " | "
         << right << setw(16) << formatRupiah(hitungTunjangan())
         << " | "
         << right << setw(16) << formatRupiah(hitungPotongan())
         << " | "
         << right << setw(16) << formatRupiah(hitungGatot())
         << " |" << endl;

    cout << "========================================================================================================================" << endl;

    cout << "| "
         << left << setw(20) << "Waktu Datang"
         << "| "
         << left << setw(20) << "Waktu Pulang"
         << "| "
         << left << setw(20) << "Lama Kerja"
         << "|" << endl;

    cout << "---------------------------------------------------------------" << endl;

    cout << "| "
         << left << setw(20) << datang
         << "| "
         << left << setw(20) << pulang
         << "| "
         << left << setw(20) << lamaKerja
         << "|" << endl;

    cout << "===============================================================" << endl;
}


void tampilkanMenu() {
    cout << endl;
    cout << "==================================" << endl;
    cout << "        PROGRAM GAJI PEGAWAI" << endl;
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

            GajiPegawai pegawai1;

            string nip;
            string nama;
            int gol;
            bool valid;

            int jamDatang;
            int menitDatang;
            int detikDatang;

            int jamPulang;
            int menitPulang;
            int detikPulang;

            cout << "Masukkan NIP : ";
            cin >> nip;

            cin.ignore();

            cout << "Masukkan Nama : ";
            getline(cin, nama);

            do {
                cout << "Masukkan Gol : ";
                cin >> gol;

                valid = pegawai1.setGol(gol);

                if (!valid) {
                    cout << "Gol pegawai hanya boleh 1 - 4." << endl;
                }

            } while (!valid);

            cout << endl;

            cout << "Masukkan Waktu Datang" << endl;

            cout << "Jam datang   : ";
            cin >> jamDatang;

            cout << "Menit datang : ";
            cin >> menitDatang;

            cout << "Detik datang : ";
            cin >> detikDatang;

            cout << endl;

            cout << "Masukkan Waktu Pulang" << endl;

            cout << "Jam pulang   : ";
            cin >> jamPulang;

            cout << "Menit pulang : ";
            cin >> menitPulang;

            cout << "Detik pulang : ";
            cin >> detikPulang;

            Waktu waktu(
                jamDatang,
                menitDatang,
                detikDatang,
                jamPulang,
                menitPulang,
                detikPulang
            );

            waktu.hitungLamaKerja();

            pegawai1.setNip(nip);
            pegawai1.setNama(nama);
            pegawai1.setWaktu(waktu);

            cout << endl;
            pegawai1.output();
        }

        else if (pilihan == 2) {
            cout << "OBJEK 2 (Input dari Dalam Class)" << endl;

            GajiPegawai pegawai2;

            pegawai2.inputGajiPegawai();

            cout << endl;
            pegawai2.output();
        }

        else if (pilihan == 3) {
            cout << "OBJEK 3 (Nilai melalui Constructor)" << endl;

            Waktu waktu3(
                8, 0, 0,
                16, 30, 0
            );

            waktu3.hitungLamaKerja();

            GajiPegawai pegawai3(
                "140810250051",
                "Amela Dzakiah",
                3,
                waktu3
            );

            pegawai3.output();
        }

        else if (pilihan == 4) {
            cout << "OBJEK 4 (Set / Get Manual)" << endl;

            GajiPegawai pegawai4;

            Waktu waktu4;

            waktu4.setJamDatang(8);
            waktu4.setMenitDatang(0);
            waktu4.setDetikDatang(0);

            waktu4.setJamPulang(17);
            waktu4.setMenitPulang(0);
            waktu4.setDetikPulang(0);

            waktu4.hitungLamaKerja();

            pegawai4.setNip("140810250093");
            pegawai4.setNama("Atika Shafira");
            pegawai4.setGol(4);
            pegawai4.setWaktu(waktu4);

            cout << "NIP : " << pegawai4.getNip() << endl;

            cout << "Nama : " << pegawai4.getNama() << endl;

            cout << "Gol : " << pegawai4.getGol() << endl;

            cout << endl;

            pegawai4.output();
        }

        else if (pilihan == 0) {
            cout << "Program selesai." << endl;
        }

    } while (pilihan != 0);

    return 0;
}