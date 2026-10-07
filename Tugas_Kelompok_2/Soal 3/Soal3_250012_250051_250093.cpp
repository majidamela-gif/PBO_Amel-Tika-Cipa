/*
Nama Program : Program Gaji OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 07 Oktober 2026
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
                Menu dipisah Class nya
*/

#include <iostream>
#include <iomanip>
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
        cout << setfill('0') << setw(2) << jam << ":"
             << setw(2) << menit << ":"
             << setw(2) << detik << setfill(' ') << endl;
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

    string getNIP() {
        return NIP;
    }

    int getGol() {
        return gol;
    }

    void setNama(string nama) {
        this->nama = nama;
    }

    void setNIP(string NIP) {
        this->NIP = NIP;
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
        getline(cin, NIP);

        cout << "Masukkan nama pegawai: ";
        getline(cin, nama);

        do {
            cout << "Masukkan golongan: ";
            cin >> gol;

            if (gol < 1 || gol > 4) {
                cout << "Golongan tidak valid." << endl;
                cout << "Silahkan pilih golongan dengan rentang 1-4!" << endl;
                cout << endl;
            }
        } while (gol < 1 || gol > 4);

        cin.ignore(1000, '\n');
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

    Waktu hitungLamaKerja(Waktu datang, Waktu pulang) {
        int totalDatang = datang.konvertDetik();
        int totalPulang = pulang.konvertDetik();

        if (totalPulang < totalDatang) {
            totalPulang = totalPulang + (24 * 3600);
        }

        int selisih = totalPulang - totalDatang;

        int jam = selisih / 3600;
        int menit = (selisih % 3600) / 60;
        int detik = selisih % 60;

        return Waktu(jam, menit, detik);
    }

    int hitungJamKerja(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        return lama.getJam();
    }

    int hitungJamLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        int totalDetik = lama.konvertDetik();

        if (totalDetik < (9 * 3600)) {
            return 0;
        }

        int detikLembur = totalDetik - (8 * 3600);

        return detikLembur / 3600;
    }

    Waktu hitungLamaLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        int totalDetik = lama.konvertDetik();

        if (totalDetik < (9 * 3600)) {
            return Waktu(0, 0, 0);
        }

        int detikLembur = totalDetik - (8 * 3600);
        int jam = detikLembur / 3600;
        int menit = (detikLembur % 3600) / 60;
        int detik = detikLembur % 60;

        return Waktu(jam, menit, detik);
    }

    int hitungGajiLembur(Waktu datang, Waktu pulang) {
        return hitungJamLembur(datang, pulang) * hitungLembur();
    }

    int hitungGajiTotal(Waktu datang, Waktu pulang) {
        return hitungGajiHarian() + hitungGajiLembur(datang, pulang);
    }

    string hitungStatus(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        if (lama.konvertDetik() < (8 * 3600)) {
            return "peringatan";
        }

        return "ok";
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

    string formatWaktu(Waktu waktu) {
        string hasil;

        if (waktu.getJam() < 10) {
            hasil += "0";
        }

        hasil += to_string(waktu.getJam());
        hasil += ":";

        if (waktu.getMenit() < 10) {
            hasil += "0";
        }

        hasil += to_string(waktu.getMenit());
        hasil += ":";

        if (waktu.getDetik() < 10) {
            hasil += "0";
        }

        hasil += to_string(waktu.getDetik());

        return hasil;
    }

    void cetakPegawai(Waktu datang, Waktu pulang, int no) {
        Waktu lamaKerja = hitungLamaKerja(datang, pulang);

        cout << left
             << setw(3) << no
             << setw(4) << getNIP()
             << setw(10) << getNama()
             << setw(3) << getGol()
             << setw(9) << formatWaktu(datang)
             << setw(9) << formatWaktu(pulang)
             << setw(9) << formatWaktu(lamaKerja)
             << setw(11) << formatWaktu(hitungLamaLembur(datang, pulang))
             << setw(12) << formatRibuan(hitungGajiHarian())
             << setw(9) << formatRibuan(hitungGajiLembur(datang, pulang))
             << setw(9) << formatRibuan(hitungGajiTotal(datang, pulang))
             << setw(12) << hitungStatus(datang, pulang)
             << endl;
    }
};


class Menu {
private:
    int pilihan;
    int nomor;

public:
    Menu() {
        pilihan = 0;
        nomor = 1;
    }

    void inputPegawaiLuar(Pegawai &data) {
        string NIP;
        string nama;
        int gol;

        cout << "Masukkan NIP pegawai: ";
        getline(cin, NIP);

        cout << "Masukkan nama pegawai: ";
        getline(cin, nama);

        do {
            cout << "Masukkan golongan: ";
            cin >> gol;

            if (gol < 1 || gol > 4) {
                cout << "Golongan harus 1-4!" << endl;
            }
        } while (gol < 1 || gol > 4);

        data.setNIP(NIP);
        data.setNama(nama);
        data.setGol(gol);

        cin.ignore(1000, '\n');
    }

    void inputWaktuLuar(Waktu &waktu, string keterangan) {
        cout << endl;
        cout << "=== " << keterangan << " ===" << endl;

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

        cin.ignore(1000, '\n');
    }

    void tampilkanMenu() {
        cout << endl;
        cout << "===== MENU GAJI PEGAWAI =====" << endl;
        cout << "1. Constructor Berparameter" << endl;
        cout << "2. Setter" << endl;
        cout << "3. Input Dalam" << endl;
        cout << "4. Input Luar" << endl;
        cout << "5. Keluar" << endl;
        cout << "=============================" << endl;
        cout << "Pilih menu: ";

        cin >> pilihan;
        cin.ignore(1000, '\n');
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

        Pegawai data("Athian", "001", 3);
        Waktu waktuDatang(9, 0, 0);
        Waktu waktuPulang(17, 15, 10);

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    void setter() {
        cout << "\n=== SETTER ===" << endl;

        Pegawai data;
        Waktu waktuDatang;
        Waktu waktuPulang;

        data.setNIP("002");
        data.setNama("Dila");
        data.setGol(2);

        waktuDatang.setWaktu(8, 0, 0);
        waktuPulang.setWaktu(16, 30, 0);

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    void inputDalam() {
        cout << "\n=== INPUT DALAM ===" << endl;

        Pegawai data;
        Waktu waktuDatang;
        Waktu waktuPulang;

        data.inputPegawai();

        cout << endl;
        cout << "=== WAKTU DATANG ===" << endl;
        waktuDatang.inputWaktu();

        cout << endl;
        cout << "=== WAKTU PULANG ===" << endl;
        waktuPulang.inputWaktu();

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    void inputLuar() {
        cout << "\n=== INPUT LUAR ===" << endl;

        Pegawai data;
        Waktu waktuDatang;
        Waktu waktuPulang;

        inputPegawaiLuar(data);
        inputWaktuLuar(waktuDatang, "WAKTU DATANG");
        inputWaktuLuar(waktuPulang, "WAKTU PULANG");

        cetakHeader();
        cetakLuar(data, waktuDatang, waktuPulang);
    }

    void cetakHeader() {
        nomor = 1;

        cout << endl;
        cout << "                 Daftar Gaji Harian PT Informatika" << endl;
        cout << endl;

        cout << left
             << setw(3) << "No"
             << setw(4) << "NIP"
             << setw(10) << "Nama"
             << setw(3) << "Gol"
             << setw(9) << "Datang"
             << setw(9) << "Pulang"
             << setw(9) << "Lama"
             << setw(11) << "Jam Lembur"
             << setw(12) << "Gaji Harian"
             << setw(9) << "Lembur"
             << setw(9) << "Total"
             << setw(12) << "Status"
             << endl;

        cout << "---------------------------------------------------------------------------------------------------------" << endl;
    }

    void cetakLuar(Pegawai data, Waktu waktuDatang, Waktu waktuPulang) {
        data.cetakPegawai(waktuDatang, waktuPulang, nomor);
        nomor++;
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