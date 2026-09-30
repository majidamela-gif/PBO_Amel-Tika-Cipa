/*
Nama Program : Program Gaji OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 29 September 2026
Deskripsi    : Buatlah program OOP untuk mencari gaji harian da lembur berdasarkan lama kerja pegawai dgn aturan sbb:
                • Input : NIP, nama, gol, waktu datang, waktu pulang
                • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
                    Gol     gaji harian     lembur >= 8 jam kerja
                    1       150 rb          50.000 /jam
                    2       200 rb          75.000 /jam
                    3       400 rb          150.000 /jam
                    4       500 rb          200.000 /jam
                • Proses : gaji Harian = gapok + lembur
                • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
                • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
                Buat tampilan Output tabel
                Buat 2 class (Waktu dan Pegawai)
                • Waktu (atribut, Method (constructor, input-proses-output)
                • Pegawai ( atribut, Method (constructor, input-proses-output)
                Utama : pakai menu d minimal 3 object
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

public:
    Waktu() {
        jamDatang = 0;
        menitDatang = 0;
        detikDatang = 0;

        jamPulang = 0;
        menitPulang = 0;
        detikPulang = 0;
    }

    Waktu(int jamDatang, int menitDatang, int detikDatang, int jamPulang, int menitPulang, int detikPulang) {
        this->jamDatang = jamDatang;
        this->menitDatang = menitDatang;
        this->detikDatang = detikDatang;

        this->jamPulang = jamPulang;
        this->menitPulang = menitPulang;
        this->detikPulang = detikPulang;
    }

    int getJamDatang() {
        return jamDatang;
    }

    void setJamDatang(int jamDatang) {
        this->jamDatang = jamDatang;
    }

    int getMenitDatang() {
        return menitDatang;
    }

    void setMenitDatang(int menitDatang) {
        this->menitDatang = menitDatang;
    }

    int getDetikDatang() {
        return detikDatang;
    }

    void setDetikDatang(int detikDatang) {
        this->detikDatang = detikDatang;
    }

    int getJamPulang() {
        return jamPulang;
    }

    void setJamPulang(int jamPulang) {
        this->jamPulang = jamPulang;
    }

    int getMenitPulang() {
        return menitPulang;
    }

    void setMenitPulang(int menitPulang) {
        this->menitPulang = menitPulang;
    }

    int getDetikPulang() {
        return detikPulang;
    }

    void setDetikPulang(int detikPulang) {
        this->detikPulang = detikPulang;
    }

    void inputWaktu() {
        cout << "Masukkan jam datang: ";
        cin >> jamDatang;
        cout << "Masukkan menit datang: ";
        cin >> menitDatang;
        cout << "Masukkan detik datang: ";
        cin >> detikDatang;
        cout << "Masukkan jam pulang: ";
        cin >> jamPulang;
        cout << "Masukkan menit pulang: ";
        cin >> menitPulang;
        cout << "Masukkan detik pulang: ";
        cin >> detikPulang;
    }

    int hitungDurasiDetik() {
        int totalDetikDatang = jamDatang * 3600 + menitDatang * 60 + detikDatang;
        int totalDetikPulang = jamPulang * 3600 + menitPulang * 60 + detikPulang;
        int durasi = totalDetikPulang - totalDetikDatang;

        if (durasi < 0) {
            durasi += 24 * 3600;
        }

        return durasi;
    }

    void hitungLamaKerja() {
        int durasi = hitungDurasiDetik();
        int jam = durasi / 3600;
        int menit = (durasi % 3600) / 60;
        int detik = durasi % 60;

        cout << setfill('0')
             << setw(2) << jam << ":"
             << setw(2) << menit << ":"
             << setw(2) << detik
             << setfill(' ');
    }

    int hitungJamLembur() {
        int durasi = hitungDurasiDetik();

        if (durasi <= 8 * 3600) {
            return 0;
        }

        return (durasi - 8 * 3600) / 3600;
    }

    void hitungLamaLembur() {
        int durasi = hitungDurasiDetik();

        if (durasi <= 8 * 3600) {
            cout << "00:00:00";
            return;
        }

        int lembur = durasi - 8 * 3600;
        int jam = lembur / 3600;
        int menit = (lembur % 3600) / 60;
        int detik = lembur % 60;

        cout << setfill('0')
             << setw(2) << jam << ":"
             << setw(2) << menit << ":"
             << setw(2) << detik
             << setfill(' ');
    }

    void cetakWaktuDatang() {
        cout << setfill('0')
             << setw(2) << jamDatang << ":"
             << setw(2) << menitDatang << ":"
             << setw(2) << detikDatang
             << setfill(' ');
    }

    void cetakWaktuPulang() {
        cout << setfill('0')
             << setw(2) << jamPulang << ":"
             << setw(2) << menitPulang << ":"
             << setw(2) << detikPulang
             << setfill(' ');
    }
};

class Pegawai {
private:
    string nama;
    string NIP;
    int gol;

public:
    Pegawai() {
        nama = "";
        NIP = "";
        gol = 0;
    }

    Pegawai(string nama, string NIP, int gol) {
        this->nama = nama;
        this->NIP = NIP;
        this->gol = gol;
    }

    string getNama() {
        return nama;
    }

    void setNama(string nama) {
        this->nama = nama;
    }

    string getNIP() {
        return NIP;
    }

    void setNIP(string NIP) {
        this->NIP = NIP;
    }

    int getGol() {
        return gol;
    }

    void setGol(int gol) {
        this->gol = gol;
    }

    void setPegawai(string nama, string NIP, int gol) {
        this->nama = nama;
        this->NIP = NIP;
        this->gol = gol;
    }

    void inputPegawai() {
        cout << "Masukkan NIP pegawai: ";
        cin >> NIP;

        cin.ignore();

        cout << "Masukkan nama pegawai: ";
        getline(cin, nama);

        do {
            cout << "Masukkan golongan: ";
            cin >> gol;

            if (gol != 1 && gol != 2 && gol != 3 && gol != 4) {
                cout << "Golongan tidak valid." << endl;
                cout << "Silahkan pilih golongan dengan rentang 1-4!" << endl;
                cout << endl;
            }

        } while (gol != 1 && gol != 2 && gol != 3 && gol != 4);
    }

    int hitungGajiHarian() {
        int gaji = 0;

        if (gol == 1) {
            gaji = 150000;
        } else if (gol == 2) {
            gaji = 200000;
        } else if (gol == 3) {
            gaji = 400000;
        } else if (gol == 4) {
            gaji = 500000;
        }

        return gaji;
    }

    int hitungLembur() {
        int lembur = 0;

        if (gol == 1) {
            lembur = 50000;
        } else if (gol == 2) {
            lembur = 75000;
        } else if (gol == 3) {
            lembur = 150000;
        } else if (gol == 4) {
            lembur = 200000;
        }

        return lembur;
    }

    int hitungGajiLembur(Waktu waktu) {
        return waktu.hitungJamLembur() * hitungLembur();
    }

    int hitungGajiTotal(Waktu waktu) {
        return hitungGajiHarian() + hitungGajiLembur(waktu);
    }

    string hitungStatus(Waktu waktu) {
        if (waktu.hitungDurasiDetik() < 8 * 3600) {
            return "Peringatan";
        }

        return "OK";
    }

    string formatRibuan(int angka) {
        string strAngka = to_string(angka);
        string hasil = "";
        int hitung = 0;

        for (int i = strAngka.length() - 1; i >= 0; i--) {
            hasil = strAngka[i] + hasil;
            hitung++;

            if (hitung % 3 == 0 && i > 0) {
                hasil = "." + hasil;
            }
        }

        return hasil;
    }

    void cetakPegawai(Waktu waktu, int no) {
        cout << left
             << setw(4) << no
             << setw(10) << NIP
             << setw(10) << nama
             << setw(5) << gol;

        cout << right;

        waktu.cetakWaktuDatang();
        cout << "   ";

        waktu.cetakWaktuPulang();
        cout << "   ";

        waktu.hitungLamaKerja();
        cout << "     ";

        waktu.hitungLamaLembur();
        cout << "       ";

        cout << left
             << setw(14) << formatRibuan(hitungGajiHarian());
        cout << setw(11) << formatRibuan(hitungGajiLembur(waktu));
        cout << setw(12) << formatRibuan(hitungGajiTotal(waktu));
        cout << setw(12) << hitungStatus(waktu);

        cout << endl;
    }
};

int nomor = 1;

int menu() {
    cout << endl;
    cout << "===== MENU GAJI PEGAWAI =====" << endl;
    cout << "1. Constructor Berparameter" << endl;
    cout << "2. Setter" << endl;
    cout << "3. Input Pegawai" << endl;
    cout << "4. Keluar" << endl;
    cout << "Pilih menu: ";

    int pilihan;
    cin >> pilihan;

    return pilihan;
}

void tampilkanGaris() {
    cout << "------------------------------------------------------------------------------------------------------------------------" << endl;
}

void tampilkanHeader() {
    cout << endl;
    cout << "                         Daftar Gaji Harian PT Informatika" << endl;
    cout << endl;

    tampilkanGaris();

    cout << left
         << setw(4) << "No"
         << setw(10) << "NIP"
         << setw(10) << "Nama"
         << setw(5) << "Gol"
         << setw(11) << "Datang"
         << setw(11) << "Pulang"
         << setw(11) << "Lama"
         << setw(13) << "Jam Lembur"
         << setw(14) << "Gaji Harian"
         << setw(11) << "Lembur"
         << setw(12) << "Total"
         << setw(12) << "Status"
         << endl;

    tampilkanGaris();
}

int main() {
    int pilihan;

    do {
        pilihan = menu();

        switch (pilihan) {

            case 1: {
                cout << "\n=== CONSTRUCTOR BERPAMETER ===" << endl;

                Pegawai data1("Athian", "001", 1);
                Waktu waktu1(7, 30, 0, 16, 20, 15);

                tampilkanHeader();
                data1.cetakPegawai(waktu1, nomor++);
                tampilkanGaris();

                break;
            }

            case 2: {
                cout << "\n=== SETTER ===" << endl;

                Pegawai data2;
                Waktu waktu2;

                data2.setNIP("002");
                data2.setNama("Dila");
                data2.setGol(2);

                waktu2.setJamDatang(8);
                waktu2.setMenitDatang(25);
                waktu2.setDetikDatang(0);

                waktu2.setJamPulang(16);
                waktu2.setMenitPulang(30);
                waktu2.setDetikPulang(7);

                tampilkanHeader();
                data2.cetakPegawai(waktu2, nomor++);
                tampilkanGaris();

                break;
            }

            case 3: {
                cout << "\n=== INPUT PEGAWAI ===" << endl;

                Pegawai data3;
                Waktu waktu3;

                data3.inputPegawai();
                waktu3.inputWaktu();

                tampilkanHeader();
                data3.cetakPegawai(waktu3, nomor++);
                tampilkanGaris();

                break;
            }

            case 4:
                cout << "\nProgram selesai." << endl;
                break;

            default:
                cout << "\nPilihan tidak tersedia!" << endl;
        }

    } while (pilihan != 4);

    return 0;
}