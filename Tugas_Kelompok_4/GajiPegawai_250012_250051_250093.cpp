// Nama Program : Program Gaji OOP dengan Class Person
// Anggota      : - Amela Dzakiah Majid (140810250051)
//                - Atika Shafira (140810250093)
//                - Syifa Dwi Amirah (140810250012)
// Tanggal Buat : 27 Oktober 2026
// Deskripsi    : Buatlah program OOP Array of Object dengan menambahkan class person (minimal ada nama, Alamat, dll) yang melakukan inheritance dengan class pegawai untuk mencari gaji harian dan lembur
//                berdasarkan lama kerja pegawai dgn aturan sbb:
//                 • Input : NIP, nama, Alamat, gol, waktu datang, waktu pulang
//                 • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
//                     Gol gaji harian lembur >= 8 jam kerja
//                     1 150 rb 50.000 /jam
//                     2 200 rb 75.000 /jam
//                     3 400 rb 150.000 /jam
//                     4 500 rb 200.000 /jam
//                 • Proses : gaji Harian = gapok + lembur
//                 • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
//                 • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
//                   Tabel
//                   Rata-rata Gaji : ---
//                   Gaji Tertinggi :
//                   Gaji Terendah :
//                Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output ) selain class Utama


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

    void selisihVoid(Waktu A, Waktu B) {
        int totalA = A.konvertDetik();
        int totalB = B.konvertDetik();
        int selisih = (totalA >= totalB) ? totalA - totalB : totalB - totalA;

        jam = selisih / 3600;
        menit = (selisih % 3600) / 60;
        detik = selisih % 60;
    }

    Waktu selisihReturn(Waktu A) {
        int totalA = A.konvertDetik();
        int totalThis = konvertDetik();
        int hasil = (totalA >= totalThis) ? totalA - totalThis : totalThis - totalA;

        return Waktu(hasil / 3600, (hasil % 3600) / 60, hasil % 60);
    }

    void cetakWaktu() {
        cout << setfill('0') << setw(2) << jam << ":"
             << setw(2) << menit << ":" << setw(2) << detik
             << setfill(' ');
    }
};

class Person {
private:
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

    int hitungJamKerja(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        return lama.getJam();
    }

    int hitungJamLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();
        if (totalDetik < 9 * 3600) return 0;
        int detikLembur = totalDetik - 8 * 3600;
        return detikLembur / 3600;
    }

    Waktu hitungLamaLembur(Waktu datang, Waktu pulang) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();
        if (totalDetik < 9 * 3600) return Waktu(0, 0, 0);
        int detikLembur = totalDetik - 8 * 3600;
        return Waktu(detikLembur / 3600, (detikLembur % 3600) / 60, detikLembur % 60);
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
            if (gol < 1 || gol > 4) cout << "Golongan harus 1-4!" << endl;
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
        int rataRata = static_cast<int>(static_cast<double>(totalSemua) / jumlah + 0.5);
        cout << "Rata-rata Gaji  : Rp " << format.formatRibuan(rataRata) << endl;
        cout << "Gaji Tertinggi  : Rp " << format.formatRibuan(gajiTertinggi)
             << " - " << pegawaiTertinggi << endl;
        cout << "Gaji Terendah   : Rp " << format.formatRibuan(gajiTerendah)
             << " - " << pegawaiTerendah << endl;
    }

    void cetakLaporan(ArrayPegawai kumpulan, string judul) {
        if (kumpulan.getJumlah() == 0) {
            cout << "Belum ada data pegawai." << endl;
            return;
        }

        cout << endl << string(60, '=') << endl;
        cout << " DAFTAR GAJI HARIAN PT INFORMATIKA " << endl;
        cout << string(60, '=') << endl;

        cetakTabelData(kumpulan, "TABEL UTAMA");
        cetakTabelData(kumpulan.sortingAscending(),
                       "TABEL ASCENDING (GAJI TOTAL TERKECIL KE TERBESAR)");
        cetakTabelData(kumpulan.sortingDescending(),
                       "TABEL DESCENDING (GAJI TOTAL TERBESAR KE TERKECIL)");

        cout << endl << "=== STATISTIK GAJI ===" << endl;
        cetakRingkasan(kumpulan);
    }

    void constructor() {
        cout << endl << "=== CONSTRUCTOR BERPAMETER ===" << endl;
        ArrayPegawai kumpulanConstructor;

        kumpulanConstructor.tambahPegawai(
            Pegawai("Syifa", "012", 3, "Bandung"),
            Waktu(8, 0, 0), Waktu(17, 15, 10));

        kumpulanConstructor.tambahPegawai(
            Pegawai("Amela", "051", 2, "Sumedang"),
            Waktu(8, 0, 0), Waktu(19, 30, 10));

        kumpulanConstructor.tambahPegawai(
            Pegawai("Atika", "093", 4, "Bandung"),
            Waktu(8, 0, 0), Waktu(14, 0, 10));

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
            if (banyak < 1 || banyak > 10) cout << "Jumlah pegawai harus 1-10!" << endl;
        } while (banyak < 1 || banyak > 10);
        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== PEGAWAI KE-" << i + 1 << " =====" << endl;
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
            if (banyak < 1 || banyak > 10) cout << "Jumlah pegawai harus 1-10!" << endl;
        } while (banyak < 1 || banyak > 10);
        cin.ignore();

        for (int i = 0; i < banyak; i++) {
            cout << endl << "===== PEGAWAI KE-" << i + 1 << " =====" << endl;
            Pegawai data;
            Waktu waktuDatang, waktuPulang;

            inputPegawaiLuar(data);
            inputWaktuLuar(waktuDatang, "WAKTU DATANG");
            inputWaktuLuar(waktuPulang, "WAKTU PULANG");

            kumpulanLuar.tambahPegawai(data, waktuDatang, waktuPulang);
        }

        cetakLaporan(kumpulanLuar, "INPUT LUAR");
    }

    void tampilkanMenu() {
        cout << endl << "===== MENU GAJI PEGAWAI =====" << endl;
        cout << "1. Constructor Berparameter" << endl;
        cout << "2. Setter" << endl;
        cout << "3. Input Dalam" << endl;
        cout << "4. Input Luar" << endl;
        cout << "5. Keluar" << endl;
        cout << "=============================" << endl;
        cout << "Pilih menu: ";
        cin >> pilihan;
        cin.ignore();
    }

    void prosesMenu() {
        switch (pilihan) {
            case 1: constructor(); break;
            case 2: setter(); break;
            case 3: inputDalam(); break;
            case 4: inputLuar(); break;
            case 5: cout << endl << "Program selesai." << endl; break;
            default: cout << endl << "Pilihan tidak tersedia!" << endl;
        }
    }
};

class Main {
public:
    static void main() {
        Menu menu;
        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
};

int main() {
    Main::main();
    return 0;
}