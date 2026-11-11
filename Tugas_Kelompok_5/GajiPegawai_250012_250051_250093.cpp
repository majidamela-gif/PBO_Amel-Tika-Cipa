/*
Nama Program : Program Gaji OOP dengan tambahan parkir
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 09 November 2026
Deskripsi    : Buatlah program OOP Array of Object dengan menambahkan class person (minimal ada nama, Alamat, dll) yang melakukan inheritance dengan class pegawai untuk mencari gaji harian dan lembur
               berdasarkan lama kerja pegawai dgn aturan sbb:
                • Input : NIP, nama, Alamat, gol, waktu datang, waktu pulang
                • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
                    Gol gaji harian lembur >= 8 jam kerja
                    1 150 rb 50.000 /jam
                    2 200 rb 75.000 /jam
                    3 400 rb 150.000 /jam
                    4 500 rb 200.000 /jam
                • Proses : gaji Harian = gapok + lembur
                • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
                • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
                  Tabel
                  Rata-rata Gaji : ---
                  Gaji Tertinggi :
                  Gaji Terendah :
               Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output ) selain class Utama
               Buat program parkir kendaraan berdasarkan kendaraan --> mobil, truk dan motor ( inheritance dan polimorfisma)
               Biaya parkir :
                untuk umum (person atau tanpa identitas) : 3000, 5000 dan 2000 perjam
                untuk pegawai : 6000, dan 3000 per hari (<=24 jam) --> hanya mobil dan motor. Truk sesuai umum
               Parkir kendaraan juga berbentuk array (buatkan tabel laporannya)
               Lakukan improvisasi. Tuliskan spek dan aturan terbaik yang lain berdasarkan spek dasar ini.
*/

#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

class Waktu {
private:
    int jam;
    int menit;
    int detik;

public:
    Waktu(int jam = 0, int menit = 0, int detik = 0) {
        this->jam = 0;
        this->menit = 0;
        this->detik = 0;
        setWaktu(jam, menit, detik);
    }

    int getJam() { return jam; }
    int getMenit() { return menit; }
    int getDetik() { return detik; }

    void setJam(int jam) {
        if (jam >= 0 && jam < 24) this->jam = jam;
        else {
            this->jam = 0;
            cout << "Jam harus 0-23." << endl;
        }
    }

    void setMenit(int menit) {
        if (menit >= 0 && menit < 60) this->menit = menit;
        else {
            this->menit = 0;
            cout << "Menit harus 0-59." << endl;
        }
    }

    void setDetik(int detik) {
        if (detik >= 0 && detik < 60) this->detik = detik;
        else {
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
        int jam, menit, detik;

        do {
            cout << "Masukkan Jam (0-23): ";
            cin >> jam;
            if (jam < 0 || jam >= 24) cout << "Jam harus 0-23." << endl;
        } while (jam < 0 || jam >= 24);

        do {
            cout << "Masukkan Menit (0-59): ";
            cin >> menit;
            if (menit < 0 || menit >= 60) cout << "Menit harus 0-59." << endl;
        } while (menit < 0 || menit >= 60);

        do {
            cout << "Masukkan Detik (0-59): ";
            cin >> detik;
            if (detik < 0 || detik >= 60) cout << "Detik harus 0-59." << endl;
        } while (detik < 0 || detik >= 60);

        setWaktu(jam, menit, detik);
        cin.ignore();
    }

    int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }
};

class Person {
protected:
    string nama;
    string alamat;

public:
    Person(string nama = "", string alamat = "") {
        this->nama = nama;
        this->alamat = alamat;
    }

    string getNama() { return nama; }
    string getAlamat() { return alamat; }

    void setNama(string nama) { this->nama = nama; }
    void setAlamat(string alamat) { this->alamat = alamat; }

    void setPerson(string nama, string alamat) {
        this->nama = nama;
        this->alamat = alamat;
    }

    void inputPerson() {
        cout << "Masukkan nama: ";
        getline(cin, nama);
        cout << "Masukkan alamat: ";
        getline(cin, alamat);
    }

    void cetakPerson() {
        cout << "Nama   : " << nama << endl;
        cout << "Alamat : " << alamat << endl;
    }
};

class Pegawai : public Person {
private:
    string NIP;
    int gol;

public:
    Pegawai(string nama = "", string NIP = "", int gol = 0, string alamat = "")
        : Person(nama, alamat) {
        this->NIP = NIP;
        this->gol = gol;
    }

    string getNIP() { return NIP; }
    int getGol() { return gol; }

    void setNIP(string NIP) { this->NIP = NIP; }
    void setGol(int gol) { this->gol = gol; }

    void setPegawai(string nama, string NIP, int gol, string alamat = "") {
        setPerson(nama, alamat);
        this->NIP = NIP;
        this->gol = gol;
    }

    void inputPegawai() {
        cout << "Masukkan NIP pegawai: ";
        getline(cin, NIP);
        cout << "Masukkan nama pegawai: ";
        setNamaFromInput();
        cout << "Masukkan alamat pegawai: ";
        string alamat;
        getline(cin, alamat);
        setAlamat(alamat);

        do {
            cout << "Masukkan golongan: ";
            cin >> gol;
            if (gol < 1 || gol > 4) {
                cout << "Golongan tidak valid." << endl;
                cout << "Silahkan pilih golongan dengan rentang 1-4!" << endl << endl;
            }
        } while (gol < 1 || gol > 4);
        cin.ignore();
    }

    void setNamaFromInput() {
        string nama;
        getline(cin, nama);
        setNama(nama);
    }

    int hitungGajiHarian() {
        if (gol == 1) return 150000;
        else if (gol == 2) return 200000;
        else if (gol == 3) return 400000;
        else if (gol == 4) return 500000;
        return 0;
    }

    int hitungLembur() {
        if (gol == 1) return 50000;
        else if (gol == 2) return 75000;
        else if (gol == 3) return 150000;
        else if (gol == 4) return 200000;
        return 0;
    }

    Waktu hitungLamaKerja(Waktu datang, Waktu pulang) {
        int totalDatang = datang.konvertDetik();
        int totalPulang = pulang.konvertDetik();
        if (totalPulang < totalDatang) totalPulang += 24 * 3600;

        int selisih = totalPulang - totalDatang;
        return Waktu(selisih / 3600, (selisih % 3600) / 60, selisih % 60);
    }

    int hitungJamLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();
        if (totalDetik < 9 * 3600) return 0;
        int detikLembur = totalDetik - 8 * 3600;
        return detikLembur / 3600;
    }

    int hitungGajiLembur(Waktu datang, Waktu pulang) {
        return hitungJamLembur(datang, pulang) * hitungLembur();
    }

    int hitungGajiTotal(Waktu datang, Waktu pulang) {
        return hitungGajiHarian() + hitungGajiLembur(datang, pulang);
    }

    string hitungStatus(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        if (lama.konvertDetik() < 8 * 3600) return "peringatan";
        return "ok";
    }

    string formatRibuan(int angka) {
        string strAngka = to_string(angka);
        string hasil = "";
        int hitung = 0;
        for (int i = static_cast<int>(strAngka.length()) - 1; i >= 0; i--) {
            hasil = strAngka[i] + hasil;
            hitung++;
            if (hitung % 3 == 0 && i > 0) hasil = "." + hasil;
        }
        return hasil;
    }

    string formatWaktu(Waktu waktu) {
        string hasil = "";
        if (waktu.getJam() < 10) hasil += "0";
        hasil += to_string(waktu.getJam()) + ":";
        if (waktu.getMenit() < 10) hasil += "0";
        hasil += to_string(waktu.getMenit()) + ":";
        if (waktu.getDetik() < 10) hasil += "0";
        hasil += to_string(waktu.getDetik());
        return hasil;
    }

    void cetakPegawai(Waktu datang, Waktu pulang, int no) {
        Waktu lamaKerja = hitungLamaKerja(datang, pulang);
        cout << left
             << setw(4) << no
             << setw(10) << getNIP()
             << setw(14) << getNama()
             << setw(20) << getAlamat()
             << setw(5) << getGol()
             << setw(10) << formatWaktu(datang)
             << setw(10) << formatWaktu(pulang)
             << setw(10) << formatWaktu(lamaKerja)
             << setw(12) << hitungJamLembur(datang, pulang)
             << setw(15) << formatRibuan(hitungGajiHarian())
             << setw(12) << formatRibuan(hitungGajiLembur(datang, pulang))
             << setw(15) << formatRibuan(hitungGajiTotal(datang, pulang))
             << setw(12) << hitungStatus(datang, pulang) << endl;
    }
};

class ArrayPegawai {
private:
    Pegawai data[10];
    Waktu waktuDatang[10];
    Waktu waktuPulang[10];
    int jumlah;

public:
    ArrayPegawai() { jumlah = 0; }

    int getJumlah() { return jumlah; }

    Pegawai getPegawai(int index) { return data[index]; }
    Waktu getWaktuDatang(int index) { return waktuDatang[index]; }
    Waktu getWaktuPulang(int index) { return waktuPulang[index]; }

    void tambahPegawai(Pegawai pegawai, Waktu datang, Waktu pulang) {
        if (jumlah < 10) {
            data[jumlah] = pegawai;
            waktuDatang[jumlah] = datang;
            waktuPulang[jumlah] = pulang;
            jumlah++;
        } else {
            cout << "Array pegawai sudah penuh!" << endl;
        }
    }

    int hitungGajiPadaIndex(int index) {
        return data[index].hitungGajiTotal(waktuDatang[index], waktuPulang[index]);
    }

    void tukarData(int i, int j) {
        Pegawai tempPegawai = data[i];
        data[i] = data[j];
        data[j] = tempPegawai;

        Waktu tempDatang = waktuDatang[i];
        waktuDatang[i] = waktuDatang[j];
        waktuDatang[j] = tempDatang;

        Waktu tempPulang = waktuPulang[i];
        waktuPulang[i] = waktuPulang[j];
        waktuPulang[j] = tempPulang;
    }

    ArrayPegawai sortingAscending() {
        ArrayPegawai hasil = *this;
        for (int i = 0; i < hasil.jumlah - 1; i++) {
            for (int j = 0; j < hasil.jumlah - i - 1; j++) {
                if (hasil.hitungGajiPadaIndex(j) > hasil.hitungGajiPadaIndex(j + 1)) {
                    hasil.tukarData(j, j + 1);
                }
            }
        }
        return hasil;
    }

    ArrayPegawai sortingDescending() {
        ArrayPegawai hasil = *this;
        for (int i = 0; i < hasil.jumlah - 1; i++) {
            for (int j = 0; j < hasil.jumlah - i - 1; j++) {
                if (hasil.hitungGajiPadaIndex(j) < hasil.hitungGajiPadaIndex(j + 1)) {
                    hasil.tukarData(j, j + 1);
                }
            }
        }
        return hasil;
    }
};

// ==================== CLASS PARKIR KENDARAAN ====================

class Orang {
private:
    string nama;

public:
    Orang(string nama = "") { this->nama = nama; }

    string getNama() { return nama; }
    void setNama(string nama) { this->nama = nama; }
};

class Kendaraan {
protected:
    string nomorPolisi, NIP, status;
    Orang pemilik;
    Waktu waktuMasuk, waktuKeluar;

public:
    Kendaraan(string nomor = "", string nama = "", string nip = "",
              string status = "Umum", Waktu masuk = Waktu(),
              Waktu keluar = Waktu()) {
        nomorPolisi = nomor;
        pemilik.setNama(nama);
        NIP = nip;
        this->status = status;
        waktuMasuk = masuk;
        waktuKeluar = keluar;
    }

    virtual ~Kendaraan() {}

    string getNomorPolisi() { return nomorPolisi; }
    string getStatus() { return status; }

    int hitungLamaDetik() {
        int awal = waktuMasuk.konvertDetik();
        int akhir = waktuKeluar.konvertDetik();

        if (akhir < awal) {
            akhir += 24 * 3600;
        }

        return akhir - awal;
    }

    void setKendaraan(string nomor, string nama, string nip, string status, Waktu masuk, Waktu keluar) {
        nomorPolisi = nomor;
        pemilik.setNama(nama);
        NIP = nip;
        this->status = status;
        waktuMasuk = masuk;
        waktuKeluar = keluar;
    }

    void inputDataDasar() {
        int pengguna;

        cout << "Nomor polisi: ";
        getline(cin, nomorPolisi);

        do {
            cout << "Jenis pengguna (1. Umum  2. Pegawai): ";
            cin >> pengguna;

            if (pengguna < 1 || pengguna > 2)
                cout << "Pilihan tidak valid!" << endl;

        } while (pengguna < 1 || pengguna > 2);

        cin.ignore();

        if (pengguna == 2) {
            status = "Pegawai";

            cout << "Nama pegawai: ";
            string nama;
            getline(cin, nama);
            pemilik.setNama(nama);

            cout << "NIP pegawai: ";
            getline(cin, NIP);
        } else {
            status = "Umum";
            pemilik.setNama("");
            NIP = "";
        }
    }

    virtual string getJenis() = 0;
    virtual void cetakKarakteristik() = 0;
    virtual int hitungBiaya(int lamaDetik, bool pegawai) = 0;
    virtual void inputKendaraan() = 0;

    void cetakData(int no) {
        Pegawai format;

        string identitas = (status == "Pegawai")
            ? pemilik.getNama() + "/" + NIP : "-";

        int detik = hitungLamaDetik();

        string lama = to_string(detik / 3600) + "j " +
                    to_string((detik % 3600) / 60) + "m";

        cout << left
            << setw(4) << no
            << setw(12) << nomorPolisi
            << setw(10) << getJenis()
            << setw(12) << status
            << setw(18) << identitas
            << setw(10) << format.formatWaktu(waktuMasuk)
            << setw(10) << format.formatWaktu(waktuKeluar)
            << setw(12) << lama
            << setw(15) << ("Rp " + format.formatRibuan(
                    hitungBiaya(detik, status == "Pegawai")))
            ;

        cetakKarakteristik();

        cout << endl;
    }
};

class Mobil : public Kendaraan {
private:
    int jumlahPintu;

public:
    Mobil(string nomor = "", string nama = "", string nip = "",
          string status = "Umum", Waktu masuk = Waktu(),
          Waktu keluar = Waktu(), int pintu = 4)
        : Kendaraan(nomor, nama, nip, status, masuk, keluar) {
        jumlahPintu = pintu;
    }

    void setMobil(string nomor, string nama, string nip, string status, Waktu masuk, Waktu keluar, int pintu) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahPintu = pintu;
    }

    void inputKendaraan() override {
        inputDataDasar();

        do {
            cout << "Jumlah pintu mobil: ";
            cin >> jumlahPintu;

            if (jumlahPintu < 2 || jumlahPintu > 6)
                cout << "Jumlah pintu harus 2-6!" << endl;

        } while (jumlahPintu < 2 || jumlahPintu > 6);

        cin.ignore();

        cout << "-- Waktu masuk --" << endl;
        waktuMasuk.inputWaktu();

        cout << "-- Waktu keluar --" << endl;
        waktuKeluar.inputWaktu();
    }

    string getJenis() override { return "Mobil"; }

    void cetakKarakteristik() override {
        cout << "Jumlah pintu: " << jumlahPintu;
    }

    int hitungBiaya(int lamaDetik, bool pegawai) override {
        if (pegawai)
            return ((lamaDetik + 86400 - 1) / 86400) * 6000;

        return ((lamaDetik + 3600 - 1) / 3600) * 3000;
    }
};

class Truk : public Kendaraan {
private:
    int jumlahRoda;

public:
    Truk(string nomor = "", string nama = "", string nip = "",
         string status = "Umum", Waktu masuk = Waktu(),
         Waktu keluar = Waktu(), int roda = 6)
        : Kendaraan(nomor, nama, nip, status, masuk, keluar) {
        jumlahRoda = roda;
    }

    void setTruk(string nomor, string nama, string nip, string status, Waktu masuk, Waktu keluar, int roda) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahRoda = roda;
    }

    void inputKendaraan() override {
        inputDataDasar();

        do {
            cout << "Jumlah roda truk: ";
            cin >> jumlahRoda;

            if (jumlahRoda < 4 || jumlahRoda > 18)
                cout << "Jumlah roda harus 4-18!" << endl;

        } while (jumlahRoda < 4 || jumlahRoda > 18);

        cin.ignore();

        cout << "-- Waktu masuk --" << endl;
        waktuMasuk.inputWaktu();

        cout << "-- Waktu keluar --" << endl;
        waktuKeluar.inputWaktu();
    }

    string getJenis() override { return "Truk"; }

    void cetakKarakteristik() override {
        cout << "Jumlah roda: " << jumlahRoda;
    }

    int hitungBiaya(int lamaDetik, bool pegawai) override {
        return ((lamaDetik + 3600 - 1) / 3600) * 5000;
    }
};

class Motor : public Kendaraan {
private:
    int jumlahTak;

public:
    Motor(string nomor = "", string nama = "", string nip = "",
          string status = "Umum", Waktu masuk = Waktu(),
          Waktu keluar = Waktu(), int tak = 4)
        : Kendaraan(nomor, nama, nip, status, masuk, keluar) {
        jumlahTak = tak;
    }

    void setMotor(string nomor, string nama, string nip, string status, Waktu masuk, Waktu keluar, int tak) {
        setKendaraan(nomor, nama, nip, status, masuk, keluar);
        jumlahTak = tak;
    }

    void inputKendaraan() override {
        inputDataDasar();

        do {
            cout << "Jenis mesin motor (2 atau 4 tak): ";
            cin >> jumlahTak;

            if (jumlahTak != 2 && jumlahTak != 4)
                cout << "Isi 2 atau 4!" << endl;

        } while (jumlahTak != 2 && jumlahTak != 4);

        cin.ignore();

        cout << "-- Waktu masuk --" << endl;
        waktuMasuk.inputWaktu();

        cout << "-- Waktu keluar --" << endl;
        waktuKeluar.inputWaktu();
    }

    string getJenis() override { return "Motor"; }

    void cetakKarakteristik() override {
        cout << "Jenis mesin: " << jumlahTak << "-tak";
    }

    int hitungBiaya(int lamaDetik, bool pegawai) override {
        if (pegawai)
            return ((lamaDetik + 86400 - 1) / 86400) * 3000;

        return ((lamaDetik + 3600 - 1) / 3600) * 2000;
    }
};

class ArrayParkir {
private:
    Kendaraan* kendaraan[10];
    int jumlah;

public:
    ArrayParkir() { jumlah = 0; }

    ~ArrayParkir() {
        for (int i = 0; i < jumlah; i++)
            delete kendaraan[i];
    }

    void tambahParkir(Kendaraan* data) {
        if (jumlah < 10)
            kendaraan[jumlah++] = data;
        else {
            delete data;
            cout << "Array parkir penuh!" << endl;
        }
    }

    void cetakLaporan() {
        if (jumlah == 0) {
            cout << "Tidak ada data parkir." << endl;
            return;
        }

        cout << endl << "================ LAPORAN PARKIR KENDARAAN ================" << endl;
        cout << endl;
        cout << left
            << setw(4) << "No"
            << setw(12) << "No Polisi"
            << setw(10) << "Jenis"
            << setw(12) << "Pengguna"
            << setw(18) << "Nama/NIP"
            << setw(10) << "Masuk"
            << setw(10) << "Keluar"
            << setw(12) << "Lama"
            << setw(15) << "Biaya"
            << "Karakteristik" << endl;

        cout << string(125, '-') << endl;

        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            kendaraan[i]->cetakData(i + 1);

            total += kendaraan[i]->hitungBiaya(
                kendaraan[i]->hitungLamaDetik(),
                kendaraan[i]->getStatus() == "Pegawai");
        }

        cout << string(125, '-') << endl;

        Pegawai format;

        cout << "Jumlah kendaraan : " << jumlah << endl;
        cout << "Total pendapatan  : Rp "
             << format.formatRibuan(total) << endl;
    }
};

class Menu {
private:
    int pilihan;

public:
    Menu() { pilihan = 0; }

    int getPilihan() { return pilihan; }

    void inputPegawaiLuar(Pegawai &data) {
        string NIP, nama, alamat;
        int gol;

        cout << "Masukkan NIP pegawai: ";
        getline(cin, NIP);

        cout << "Masukkan nama pegawai: ";
        getline(cin, nama);

        cout << "Masukkan alamat pegawai: ";
        getline(cin, alamat);

        do {
            cout << "Masukkan golongan: ";
            cin >> gol;
            if (gol < 1 || gol > 4)
                cout << "Golongan harus 1-4!" << endl;
        } while (gol < 1 || gol > 4);

        data.setNIP(NIP);
        data.setNama(nama);
        data.setAlamat(alamat);
        data.setGol(gol);

        cin.ignore();
    }

    void inputWaktuLuar(Waktu &waktu, string keterangan) {
        cout << endl << "=== " << keterangan << " ===" << endl;

        int jam, menit, detik;

        do {
            cout << "Masukkan Jam (0-23): ";
            cin >> jam;
            if (jam < 0 || jam >= 24)
                cout << "Jam harus 0-23." << endl;
        } while (jam < 0 || jam >= 24);

        do {
            cout << "Masukkan Menit (0-59): ";
            cin >> menit;
            if (menit < 0 || menit >= 60)
                cout << "Menit harus 0-59." << endl;
        } while (menit < 0 || menit >= 60);

        do {
            cout << "Masukkan Detik (0-59): ";
            cin >> detik;
            if (detik < 0 || detik >= 60)
                cout << "Detik harus 0-59." << endl;
        } while (detik < 0 || detik >= 60);

        waktu.setWaktu(jam, menit, detik);
        cin.ignore();
    }

    void cetakHeader(string judul = "Tabel Utama") {
        cout << endl << "=== " << judul << " ===" << endl;
        cout << string(180, '-') << endl;

        cout << left
             << setw(4) << "No"
             << setw(10) << "NIP"
             << setw(14) << "Nama"
             << setw(20) << "Alamat"
             << setw(5) << "Gol"
             << setw(10) << "Datang"
             << setw(10) << "Pulang"
             << setw(10) << "Lama"
             << setw(12) << "Jam Lembur"
             << setw(15) << "Gaji Harian"
             << setw(12) << "Lembur"
             << setw(15) << "Total"
             << setw(12) << "Status" << endl;

        cout << string(180, '-') << endl;
    }

    void cetakTabelData(ArrayPegawai kumpulan, string judul) {
        cetakHeader(judul);

        for (int i = 0; i < kumpulan.getJumlah(); i++) {
            Pegawai data = kumpulan.getPegawai(i);
            Waktu datang = kumpulan.getWaktuDatang(i);
            Waktu pulang = kumpulan.getWaktuPulang(i);

            data.cetakPegawai(datang, pulang, i + 1);
        }

        cout << string(180, '-') << endl;
    }

    void cetakRingkasan(ArrayPegawai kumpulan) {
        int jumlah = kumpulan.getJumlah();
        if (jumlah == 0) return;

        int totalSemua = 0;
        int gajiTertinggi = kumpulan.hitungGajiPadaIndex(0);
        int gajiTerendah = kumpulan.hitungGajiPadaIndex(0);

        string pegawaiTertinggi = kumpulan.getPegawai(0).getNama();
        string pegawaiTerendah = kumpulan.getPegawai(0).getNama();

        for (int i = 0; i < jumlah; i++) {
            Pegawai data = kumpulan.getPegawai(i);
            int gaji = kumpulan.hitungGajiPadaIndex(i);

            totalSemua += gaji;

            if (gaji > gajiTertinggi) {
                gajiTertinggi = gaji;
                pegawaiTertinggi = data.getNama();
            }

            if (gaji < gajiTerendah) {
                gajiTerendah = gaji;
                pegawaiTerendah = data.getNama();
            }
        }

        Pegawai format;

        int rataRata = static_cast<int>(
            static_cast<double>(totalSemua) / jumlah + 0.5
        );

        cout << "Rata-rata Gaji  : Rp "
             << format.formatRibuan(rataRata) << endl;

        cout << "Gaji Tertinggi  : Rp "
             << format.formatRibuan(gajiTertinggi)
             << " - " << pegawaiTertinggi << endl;

        cout << "Gaji Terendah   : Rp "
             << format.formatRibuan(gajiTerendah)
             << " - " << pegawaiTerendah << endl;
    }

    void cetakLaporan(ArrayPegawai kumpulan, string judul) {
        if (kumpulan.getJumlah() == 0) {
            cout << "Belum ada data pegawai." << endl;
            return;
        }

        cout << endl << string(60, '=') << endl;
        cout << " DAFTAR GAJI HARIAN PT INFORMATIKA - "
             << judul << endl;
        cout << string(60, '=') << endl;

        cetakTabelData(kumpulan, "TABEL UTAMA (URUTAN INPUT)");

        cetakTabelData(
            kumpulan.sortingAscending(),
            "TABEL ASCENDING (GAJI TOTAL TERKECIL KE TERBESAR)"
        );

        cetakTabelData(
            kumpulan.sortingDescending(),
            "TABEL DESCENDING (GAJI TOTAL TERBESAR KE TERKECIL)"
        );

        cout << endl << "=== STATISTIK GAJI ===" << endl;
        cetakRingkasan(kumpulan);
    }

    void constructor() {
        cout << endl << "=== CONSTRUCTOR BERPAMETER ===" << endl;

        ArrayPegawai kumpulanConstructor;

        kumpulanConstructor.tambahPegawai(
            Pegawai("Syifa", "012", 3, "Bandung"),
            Waktu(8, 0, 0), Waktu(17, 15, 10)
        );

        kumpulanConstructor.tambahPegawai(
            Pegawai("Amela", "051", 2, "Sumedang"),
            Waktu(8, 0, 0), Waktu(19, 30, 10)
        );

        kumpulanConstructor.tambahPegawai(
            Pegawai("Atika", "093", 4, "Bandung"),
            Waktu(8, 0, 0), Waktu(14, 0, 10)
        );

        cetakLaporan(kumpulanConstructor, "CONSTRUCTOR BERPAMETER");
    }

    void setter() {
        cout << endl << "=== SETTER ===" << endl;

        ArrayPegawai kumpulanSetter;

        Pegawai p1;
        Waktu datang1, pulang1;

        p1.setNIP("001");
        p1.setNama("Doni");
        p1.setAlamat("Bandung");
        p1.setGol(2);

        datang1.setWaktu(8, 0, 0);
        pulang1.setWaktu(16, 30, 0);

        Pegawai p2;
        Waktu datang2, pulang2;

        p2.setPegawai("Tari", "002", 1, "Sumedang");

        datang2.setWaktu(22, 0, 0);
        pulang2.setWaktu(7, 0, 0);

        Pegawai p3;
        Waktu datang3, pulang3;

        p3.setPegawai("Iqbal", "003", 4, "Garut");

        datang3.setWaktu(7, 30, 0);
        pulang3.setWaktu(16, 0, 0);

        kumpulanSetter.tambahPegawai(p1, datang1, pulang1);
        kumpulanSetter.tambahPegawai(p2, datang2, pulang2);
        kumpulanSetter.tambahPegawai(p3, datang3, pulang3);

        cetakLaporan(kumpulanSetter, "SETTER");
    }

    void inputDalam() {
        cout << endl << "=== INPUT DALAM ===" << endl;

        ArrayPegawai kumpulanDalam;

        int banyak;

        do {
            cout << "Masukkan jumlah pegawai (maksimal 10): ";
            cin >> banyak;

            if (banyak < 1 || banyak > 10)
                cout << "Jumlah pegawai harus 1-10!" << endl;

        } while (banyak < 1 || banyak > 10);

        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== PEGAWAI KE-"
                 << i + 1 << " =====" << endl;

            Pegawai pegawai;
            Waktu datang, pulang;

            pegawai.inputPegawai();

            cout << endl << "=== WAKTU DATANG ===" << endl;
            datang.inputWaktu();

            cout << endl << "=== WAKTU PULANG ===" << endl;
            pulang.inputWaktu();

            kumpulanDalam.tambahPegawai(pegawai, datang, pulang);
        }

        cetakLaporan(kumpulanDalam, "INPUT DALAM");
    }

    void inputLuar() {
        cout << endl << "=== INPUT LUAR ===" << endl;

        ArrayPegawai kumpulanLuar;

        int banyak;

        do {
            cout << "Masukkan jumlah pegawai (maksimal 10): ";
            cin >> banyak;

            if (banyak < 1 || banyak > 10)
                cout << "Jumlah pegawai harus 1-10!" << endl;

        } while (banyak < 1 || banyak > 10);

        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== PEGAWAI KE-"
                 << i + 1 << " =====" << endl;

            Pegawai data;
            Waktu waktuDatang, waktuPulang;

            inputPegawaiLuar(data);
            inputWaktuLuar(waktuDatang, "WAKTU DATANG");
            inputWaktuLuar(waktuPulang, "WAKTU PULANG");

            kumpulanLuar.tambahPegawai(
                data, waktuDatang, waktuPulang
            );
        }

        cetakLaporan(kumpulanLuar, "INPUT LUAR");
    }

    void constructorParkir() {
        cout << endl << "=== CONSTRUCTOR BERPAMETER PARKIR ===" << endl;

        ArrayParkir dataParkir;

        dataParkir.tambahParkir(
            new Mobil("D 1234 AB", "Amela", "051", "Pegawai",
                    Waktu(8, 0, 0), Waktu(17, 0, 0), 4)
        );

        dataParkir.tambahParkir(
            new Truk("D 5678 CD", "", "", "Umum",
                    Waktu(9, 0, 0), Waktu(15, 30, 0), 10)
        );

        dataParkir.tambahParkir(
            new Motor("D 9012 EF", "Atika", "093", "Pegawai",
                    Waktu(7, 0, 0), Waktu(16, 0, 0), 4)
        );

        dataParkir.cetakLaporan();
    }

    void setterParkir() {
        cout << endl << "=== SETTER PARKIR ===" << endl;

        ArrayParkir dataParkir;

        Mobil* mobil = new Mobil();
        mobil->setMobil(
            "D 1111 AA", "Doni", "001", "Pegawai",
            Waktu(8, 0, 0), Waktu(17, 0, 0), 4
        );

        Truk* truk = new Truk();
        truk->setTruk(
            "D 2222 BB", "", "", "Umum",
            Waktu(9, 0, 0), Waktu(16, 0, 0), 8
        );

        Motor* motor = new Motor();
        motor->setMotor(
            "D 3333 CC", "Tari", "002", "Pegawai",
            Waktu(7, 0, 0), Waktu(15, 0, 0), 2
        );

        dataParkir.tambahParkir(mobil);
        dataParkir.tambahParkir(truk);
        dataParkir.tambahParkir(motor);

        dataParkir.cetakLaporan();
    }

        void inputDalamParkir() {
        cout << endl << "=== INPUT DALAM PARKIR ===" << endl;

        ArrayParkir dataParkir;
        int banyak;

        do {
            cout << "Masukkan jumlah kendaraan (1-10): ";
            cin >> banyak;

            if (banyak < 1 || banyak > 10)
                cout << "Jumlah kendaraan harus 1-10!" << endl;

        } while (banyak < 1 || banyak > 10);

        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== KENDARAAN KE-"
                << i + 1 << " =====" << endl;

            int jenis;

            do {
                cout << "Jenis kendaraan "
                    << "(1. Mobil  2. Truk  3. Motor): ";
                cin >> jenis;

                if (jenis < 1 || jenis > 3)
                    cout << "Pilihan tidak valid!" << endl;

            } while (jenis < 1 || jenis > 3);

            cin.ignore();

            Kendaraan* baru;

            if (jenis == 1)
                baru = new Mobil();
            else if (jenis == 2)
                baru = new Truk();
            else
                baru = new Motor();

            baru->inputKendaraan();

            dataParkir.tambahParkir(baru);
        }

        dataParkir.cetakLaporan();
    }

    void inputLuarParkir() {
        cout << endl << "=== INPUT LUAR PARKIR ===" << endl;

        ArrayParkir dataParkir;
        int banyak;

        do {
            cout << "Masukkan jumlah kendaraan (1-10): ";
            cin >> banyak;

            if (banyak < 1 || banyak > 10)
                cout << "Jumlah kendaraan harus 1-10!" << endl;

        } while (banyak < 1 || banyak > 10);

        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== KENDARAAN KE-"
                << i + 1 << " =====" << endl;

            string nomor, nama = "", nip = "";
            string status;
            int pengguna, jenis, ciri;

            cout << "Nomor polisi: ";
            getline(cin, nomor);

            do {
                cout << "Jenis pengguna (1. Umum  2. Pegawai): ";
                cin >> pengguna;

                if (pengguna < 1 || pengguna > 2)
                    cout << "Pilihan tidak valid!" << endl;

            } while (pengguna < 1 || pengguna > 2);

            cin.ignore();

            status = (pengguna == 2) ? "Pegawai" : "Umum";

            if (status == "Pegawai") {
                cout << "Nama pegawai: ";
                getline(cin, nama);

                cout << "NIP pegawai: ";
                getline(cin, nip);
            }

            do {
                cout << "Jenis kendaraan (1. Mobil  2. Truk  3. Motor): ";
                cin >> jenis;

                if (jenis < 1 || jenis > 3)
                    cout << "Pilihan tidak valid!" << endl;

            } while (jenis < 1 || jenis > 3);

            if (jenis == 1) {
                do {
                    cout << "Jumlah pintu mobil: ";
                    cin >> ciri;

                    if (ciri < 2 || ciri > 6)
                        cout << "Jumlah pintu harus 2-6!" << endl;

                } while (ciri < 2 || ciri > 6);

            } else if (jenis == 2) {
                do {
                    cout << "Jumlah roda truk: ";
                    cin >> ciri;

                    if (ciri < 4 || ciri > 18)
                        cout << "Jumlah roda harus 4-18!" << endl;

                } while (ciri < 4 || ciri > 18);

            } else {
                do {
                    cout << "Jenis mesin motor (2 atau 4 tak): ";
                    cin >> ciri;

                    if (ciri != 2 && ciri != 4)
                        cout << "Isi 2 atau 4!" << endl;

                } while (ciri != 2 && ciri != 4);
            }

            cin.ignore();

            Waktu masuk, keluar;

            inputWaktuLuar(masuk, "WAKTU MASUK");
            inputWaktuLuar(keluar, "WAKTU KELUAR");

            Kendaraan* baru;

            if (jenis == 1) {
                baru = new Mobil(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            } else if (jenis == 2) {
                baru = new Truk(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            } else {
                baru = new Motor(
                    nomor, nama, nip, status, masuk, keluar, ciri
                );
            }

            dataParkir.tambahParkir(baru);
        }

        dataParkir.cetakLaporan();
    }

    void menuUtama() {
        do {
            cout << endl;
            cout << "========== MENU UTAMA ==========" << endl;
            cout << "1. Program Pegawai" << endl;
            cout << "2. Program Parkir" << endl;
            cout << "3. Keluar" << endl;
            cout << "================================" << endl;
            cout << "Pilih menu: ";

            cin >> pilihan;
            cin.ignore();

            switch (pilihan) {
                case 1:
                    menuPegawai();
                    break;

                case 2:
                    menuParkir();
                    break;

                case 3:
                    cout << endl << "Program selesai." << endl;
                    break;

                default:
                    cout << "Pilihan tidak tersedia!" << endl;
            }

        } while (pilihan != 3);
    }

    void menuPegawai() {
        int pilih;

        do {
            cout << endl;
            cout << "========== PROGRAM PEGAWAI ==========" << endl;
            cout << "1. Constructor Berparameter" << endl;
            cout << "2. Setter" << endl;
            cout << "3. Input Dalam" << endl;
            cout << "4. Input Luar" << endl;
            cout << "5. Kembali ke Menu Utama" << endl;
            cout << "=====================================" << endl;
            cout << "Pilih menu: ";

            cin >> pilih;
            cin.ignore();

            switch (pilih) {
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
                    cout << "Kembali ke Menu Utama..." << endl;
                    break;

                default:
                    cout << "Pilihan tidak tersedia!" << endl;
            }

        } while (pilih != 5);
    }

    void menuParkir() {
        int pilih;

        do {
            cout << endl;
            cout << "========== PROGRAM PARKIR ==========" << endl;
            cout << "1. Constructor Berparameter" << endl;
            cout << "2. Setter" << endl;
            cout << "3. Input Dalam" << endl;
            cout << "4. Input Luar" << endl;
            cout << "5. Kembali ke Menu Utama" << endl;
            cout << "====================================" << endl;
            cout << "Pilih menu: ";

            cin >> pilih;
            cin.ignore();

            switch (pilih) {
                case 1:
                    constructorParkir();
                    break;

                case 2:
                    setterParkir();
                    break;

                case 3:
                    inputDalamParkir();
                    break;

                case 4:
                    inputLuarParkir();
                    break;

                case 5:
                    cout << "Kembali ke Menu Utama..." << endl;
                    break;

                default:
                    cout << "Pilihan tidak tersedia!" << endl;
            }

        } while (pilih != 5);
    }
};


int main() {
    Menu menu;
    menu.menuUtama();

    return 0;
}