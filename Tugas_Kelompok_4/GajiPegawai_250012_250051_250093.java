/*
Nama Program : Program Gaji OOP dengan Class Person
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 27 Oktober 2026
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
                  Tabel Gaji Ascending
                  Tabel Gaji Descending
                  Rata-rata Gaji : ---
                  Gaji Tertinggi :
                  Gaji Terendah :
               Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output) selain class Utama
*/

import java.util.Scanner;

class Waktu {
    private int jam;
    private int menit;
    private int detik;

    public Waktu() {
        jam = 0;
        menit = 0;
        detik = 0;
    }

    public Waktu(int jam, int menit, int detik) {
        setWaktu(jam, menit, detik);
    }

    public int getJam() {
        return jam;
    }

    public int getMenit() {
        return menit;
    }

    public int getDetik() {
        return detik;
    }

    public void setJam(int jam) {
        if (jam >= 0 && jam < 24) {
            this.jam = jam;
        } else {
            this.jam = 0;
            System.out.println("Jam harus 0-23.");
        }
    }

    public void setMenit(int menit) {
        if (menit >= 0 && menit < 60) {
            this.menit = menit;
        } else {
            this.menit = 0;
            System.out.println("Menit harus 0-59.");
        }
    }

    public void setDetik(int detik) {
        if (detik >= 0 && detik < 60) {
            this.detik = detik;
        } else {
            this.detik = 0;
            System.out.println("Detik harus 0-59.");
        }
    }

    public void setWaktu(int jam, int menit, int detik) {
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }

    public int konvertDetik() {
        return jam * 3600 + menit * 60 + detik;
    }

    public void setDariDetik(int totalDetik) {
        jam = totalDetik / 3600;
        menit = (totalDetik % 3600) / 60;
        detik = totalDetik % 60;
    }

    public void selisihVoid(Waktu A, Waktu B) {
        int selisih = Math.abs(
            A.konvertDetik() - B.konvertDetik()
        );

        setDariDetik(selisih);
    }

    public Waktu selisihReturn(Waktu A) {
        int selisih = Math.abs(
            A.konvertDetik() - konvertDetik()
        );

        Waktu hasil = new Waktu();
        hasil.setDariDetik(selisih);

        return hasil;
    }

    public void inputWaktu(Scanner input) {
        int jam;
        int menit;
        int detik;

        do {
            System.out.print("Masukkan Jam (0-23): ");
            jam = input.nextInt();

            if (jam < 0 || jam >= 24) {
                System.out.println("Jam harus 0-23.");
            }
        } while (jam < 0 || jam >= 24);

        do {
            System.out.print("Masukkan Menit (0-59): ");
            menit = input.nextInt();

            if (menit < 0 || menit >= 60) {
                System.out.println("Menit harus 0-59.");
            }
        } while (menit < 0 || menit >= 60);

        do {
            System.out.print("Masukkan Detik (0-59): ");
            detik = input.nextInt();

            if (detik < 0 || detik >= 60) {
                System.out.println("Detik harus 0-59.");
            }
        } while (detik < 0 || detik >= 60);

        input.nextLine();

        setWaktu(jam, menit, detik);
    }

    @Override
    public String toString() {
        return String.format(
            "%02d:%02d:%02d",
            jam, menit, detik
        );
    }

    public void cetakWaktu() {
        System.out.print(toString());
    }
}

class Person {
    protected String nama;
    protected String alamat;

    public Person() {
        nama = "";
        alamat = "";
    }

    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPerson(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public void inputPerson(Scanner input) {
        System.out.print("Masukkan nama: ");
        nama = input.nextLine();

        System.out.print("Masukkan alamat: ");
        alamat = input.nextLine();
    }

    public void cetakPerson() {
        System.out.println("Nama   : " + nama);
        System.out.println("Alamat : " + alamat);
    }
}

class Pegawai extends Person {
    private String NIP;
    private int gol;

    public Pegawai() {
        super();
        NIP = "";
        gol = 0;
    }

    public Pegawai(
        String nama, String NIP, int gol, String alamat
    ) {
        super(nama, alamat);
        this.NIP = NIP;
        this.gol = gol;
    }

    public String getNIP() {
        return NIP;
    }

    public int getGol() {
        return gol;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public void setPegawai(
        String nama, String NIP, int gol, String alamat
    ) {
        super.setPerson(nama, alamat);
        this.NIP = NIP;
        this.gol = gol;
    }

    public void inputPegawai(Scanner input) {
        System.out.print("Masukkan NIP pegawai: ");
        NIP = input.nextLine();

        System.out.print("Masukkan nama pegawai: ");
        nama = input.nextLine();

        System.out.print("Masukkan alamat pegawai: ");
        alamat = input.nextLine();

        do {
            System.out.print("Masukkan golongan: ");
            gol = input.nextInt();
            input.nextLine();

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan tidak valid.");
                System.out.println(
                    "Silahkan pilih golongan dengan rentang 1-4!"
                );
                System.out.println();
            }
        } while (gol < 1 || gol > 4);
    }

    public int hitungGajiHarian() {
        switch (gol) {
            case 1:
                return 150000;
            case 2:
                return 200000;
            case 3:
                return 400000;
            case 4:
                return 500000;
            default:
                return 0;
        }
    }

    public int hitungLembur() {
        switch (gol) {
            case 1:
                return 50000;
            case 2:
                return 75000;
            case 3:
                return 150000;
            case 4:
                return 200000;
            default:
                return 0;
        }
    }

    public Waktu hitungLamaKerja(
        Waktu datang, Waktu pulang
    ) {
        int totalDatang = datang.konvertDetik();
        int totalPulang = pulang.konvertDetik();

        if (totalPulang < totalDatang) {
            totalPulang += 24 * 3600;
        }

        Waktu lama = new Waktu();
        lama.setDariDetik(totalPulang - totalDatang);

        return lama;
    }

    public int hitungJamKerja(
        Waktu datang, Waktu pulang
    ) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        return lama.getJam();
    }

    public int hitungJamLembur(
        Waktu datang, Waktu pulang
    ) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();

        if (totalDetik < 9 * 3600) {
            return 0;
        }

        int detikLembur = totalDetik - 8 * 3600;

        return detikLembur / 3600;
    }

    public Waktu hitungLamaLembur(
        Waktu datang, Waktu pulang
    ) {
        Waktu lama = hitungLamaKerja(datang, pulang);
        int totalDetik = lama.konvertDetik();

        if (totalDetik < 9 * 3600) {
            return new Waktu();
        }

        int detikLembur = totalDetik - 8 * 3600;

        Waktu lembur = new Waktu();
        lembur.setDariDetik(detikLembur);

        return lembur;
    }

    public int hitungGajiLembur(
        Waktu datang, Waktu pulang
    ) {
        return hitungJamLembur(datang, pulang)
            * hitungLembur();
    }

    public int hitungGajiTotal(
        Waktu datang, Waktu pulang
    ) {
        return hitungGajiHarian()
            + hitungGajiLembur(datang, pulang);
    }

    public String hitungStatus(
        Waktu datang, Waktu pulang
    ) {
        Waktu lama = hitungLamaKerja(datang, pulang);

        if (lama.konvertDetik() < 8 * 3600) {
            return "peringatan";
        }

        return "ok";
    }

    public String formatRibuan(int angka) {
        return String.format("%,d", angka)
            .replace(',', '.');
    }

    public String formatWaktu(Waktu waktu) {
        return String.format(
            "%02d:%02d:%02d",
            waktu.getJam(),
            waktu.getMenit(),
            waktu.getDetik()
        );
    }

    public void cetakPegawai(
        Waktu datang, Waktu pulang, int no
    ) {
        Waktu lamaKerja = hitungLamaKerja(datang, pulang);

        System.out.printf(
            "%-4d%-10s%-14s%-20s%-5d%-10s%-10s%-10s%-12d%-15s%-12s%-15s%-12s%n",
            no,
            getNIP(),
            getNama(),
            getAlamat(),
            getGol(),
            formatWaktu(datang),
            formatWaktu(pulang),
            formatWaktu(lamaKerja),
            hitungJamLembur(datang, pulang),
            formatRibuan(hitungGajiHarian()),
            formatRibuan(hitungGajiLembur(datang, pulang)),
            formatRibuan(hitungGajiTotal(datang, pulang)),
            hitungStatus(datang, pulang)
        );
    }
}

class ArrayPegawai {
    private Pegawai[] data;
    private Waktu[] waktuDatang;
    private Waktu[] waktuPulang;
    private int jumlah;

    public ArrayPegawai() {
        data = new Pegawai[10];
        waktuDatang = new Waktu[10];
        waktuPulang = new Waktu[10];
        jumlah = 0;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Pegawai getPegawai(int index) {
        Pegawai p = data[index];

        return new Pegawai(
            p.getNama(),
            p.getNIP(),
            p.getGol(),
            p.getAlamat()
        );
    }

    public Waktu getWaktuDatang(int index) {
        Waktu waktu = waktuDatang[index];

        return new Waktu(
            waktu.getJam(),
            waktu.getMenit(),
            waktu.getDetik()
        );
    }

    public Waktu getWaktuPulang(int index) {
        Waktu waktu = waktuPulang[index];

        return new Waktu(
            waktu.getJam(),
            waktu.getMenit(),
            waktu.getDetik()
        );
    }

    public void tambahPegawai(
        Pegawai pegawai, Waktu datang, Waktu pulang
    ) {
        if (jumlah < data.length) {
            data[jumlah] = new Pegawai(
                pegawai.getNama(),
                pegawai.getNIP(),
                pegawai.getGol(),
                pegawai.getAlamat()
            );

            waktuDatang[jumlah] = new Waktu(
                datang.getJam(),
                datang.getMenit(),
                datang.getDetik()
            );

            waktuPulang[jumlah] = new Waktu(
                pulang.getJam(),
                pulang.getMenit(),
                pulang.getDetik()
            );

            jumlah++;
        } else {
            System.out.println("Array pegawai sudah penuh!");
        }
    }

    public int hitungTotalSemuaGaji() {
        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            total += data[i].hitungGajiTotal(
                waktuDatang[i], waktuPulang[i]
            );
        }

        return total;
    }

    public int hitungGajiTertinggi() {
        if (jumlah == 0) {
            return 0;
        }

        int tertinggi = data[0].hitungGajiTotal(
            waktuDatang[0], waktuPulang[0]
        );

        for (int i = 1; i < jumlah; i++) {
            int gaji = data[i].hitungGajiTotal(
                waktuDatang[i], waktuPulang[i]
            );

            if (gaji > tertinggi) {
                tertinggi = gaji;
            }
        }

        return tertinggi;
    }

    public int hitungGajiTerendah() {
        if (jumlah == 0) {
            return 0;
        }

        int terendah = data[0].hitungGajiTotal(
            waktuDatang[0], waktuPulang[0]
        );

        for (int i = 1; i < jumlah; i++) {
            int gaji = data[i].hitungGajiTotal(
                waktuDatang[i], waktuPulang[i]
            );

            if (gaji < terendah) {
                terendah = gaji;
            }
        }

        return terendah;
    }

    public void cetakRingkasan() {
        if (jumlah == 0) {
            return;
        }

        Pegawai pegawai = data[0];

        System.out.println(
            "Rata-rata Gaji  : Rp "
            + pegawai.formatRibuan(
                hitungTotalSemuaGaji() / jumlah
            )
        );

        System.out.println(
            "Gaji Tertinggi  : Rp "
            + pegawai.formatRibuan(hitungGajiTertinggi())
        );

        System.out.println(
            "Gaji Terendah   : Rp "
            + pegawai.formatRibuan(hitungGajiTerendah())
        );
    }
}

class Menu {
    private int pilihan;
    private final Scanner input;
    private ArrayPegawai kumpulan;

    public Menu() {
        pilihan = 0;
        input = new Scanner(System.in);
        kumpulan = new ArrayPegawai();
    }

    public int getPilihan() {
        return pilihan;
    }

    public void inputPegawaiLuar(Pegawai data) {
        System.out.print("Masukkan NIP pegawai: ");
        data.setNIP(input.nextLine());

        System.out.print("Masukkan nama pegawai: ");
        data.setNama(input.nextLine());

        System.out.print("Masukkan alamat pegawai: ");
        data.setAlamat(input.nextLine());

        int gol;

        do {
            System.out.print("Masukkan golongan: ");
            gol = input.nextInt();
            input.nextLine();

            if (gol < 1 || gol > 4) {
                System.out.println("Golongan harus 1-4!");
            }
        } while (gol < 1 || gol > 4);

        data.setGol(gol);
    }

    public void inputWaktuLuar(
        Waktu waktu, String keterangan
    ) {
        System.out.println();
        System.out.println("=== " + keterangan + " ===");
        waktu.inputWaktu(input);
    }

    public void cetakHeader(String judul) {
        System.out.println();
        System.out.println("=== " + judul + " ===");
        System.out.println("-".repeat(180));

        System.out.printf(
            "%-4s%-10s%-14s%-20s%-5s%-10s%-10s%-10s%-12s%-15s%-12s%-15s%-12s%n",
            "No", "NIP", "Nama", "Alamat", "Gol",
            "Datang", "Pulang", "Lama", "Jam Lembur",
            "Gaji Harian", "Lembur", "Total", "Status"
        );

        System.out.println("-".repeat(180));
    }

    public void cetakTabelData(
        ArrayPegawai kumpulan,
        String judul,
        int[] dataUrut
    ) {
        cetakHeader(judul);

        for (int nomor = 0; nomor < dataUrut.length; nomor++) {
            int i = dataUrut[nomor];

            kumpulan.getPegawai(i).cetakPegawai(
                kumpulan.getWaktuDatang(i),
                kumpulan.getWaktuPulang(i),
                nomor + 1
            );
        }

        System.out.println("-".repeat(180));
    }

    public void cetakLaporan(
        ArrayPegawai kumpulan, String judul
    ) {
        if (kumpulan.getJumlah() == 0) {
            System.out.println("Belum ada data pegawai.");
            return;
        }

        System.out.println();
        System.out.println(
            "============================================================"
        );
        System.out.println(
            " DAFTAR GAJI HARIAN PT INFORMATIKA "
        );
        System.out.println(
            "============================================================"
        );

        int jumlah = kumpulan.getJumlah();
        int[] indeks = new int[jumlah];

        for (int i = 0; i < jumlah; i++) {
            indeks[i] = i;
        }

        cetakTabelData(kumpulan, "TABEL UTAMA", indeks);

        int[] ascending = indeks.clone();

        for (int i = 0; i < jumlah - 1; i++) {
            for (int j = 0; j < jumlah - 1 - i; j++) {
                int gajiA = totalGaji(kumpulan, ascending[j]);
                int gajiB = totalGaji(kumpulan, ascending[j + 1]);

                if (gajiA > gajiB) {
                    int sementara = ascending[j];
                    ascending[j] = ascending[j + 1];
                    ascending[j + 1] = sementara;
                }
            }
        }

        int[] descending = ascending.clone();

        for (int i = 0; i < jumlah / 2; i++) {
            int sementara = descending[i];
            descending[i] = descending[jumlah - 1 - i];
            descending[jumlah - 1 - i] = sementara;
        }

        cetakTabelData(
            kumpulan,
            "TABEL ASCENDING (GAJI TOTAL TERKECIL KE TERBESAR)",
            ascending
        );

        cetakTabelData(
            kumpulan,
            "TABEL DESCENDING (GAJI TOTAL TERBESAR KE TERKECIL)",
            descending
        );

        System.out.println();
        System.out.println("=== STATISTIK GAJI ===");
        kumpulan.cetakRingkasan();
    }

    private int totalGaji(
        ArrayPegawai kumpulan, int index
    ) {
        Pegawai pegawai = kumpulan.getPegawai(index);

        return pegawai.hitungGajiTotal(
            kumpulan.getWaktuDatang(index),
            kumpulan.getWaktuPulang(index)
        );
    }

    public void constructor() {
        System.out.println();
        System.out.println("=== CONSTRUCTOR BERPAMETER ===");

        ArrayPegawai kumpulanConstructor = new ArrayPegawai();

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Syifa", "012", 3, "Bandung"),
            new Waktu(8, 0, 0),
            new Waktu(17, 15, 10)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Amela", "051", 2, "Sumedang"),
            new Waktu(8, 0, 0),
            new Waktu(19, 30, 10)
        );

        kumpulanConstructor.tambahPegawai(
            new Pegawai("Atika", "093", 4, "Bandung"),
            new Waktu(8, 0, 0),
            new Waktu(14, 0, 10)
        );

        cetakLaporan(
            kumpulanConstructor, "Constructor Berparameter"
        );
    }

    public void setter() {
        System.out.println();
        System.out.println("=== SETTER ===");

        ArrayPegawai kumpulanSetter = new ArrayPegawai();

        Pegawai p1 = new Pegawai();
        Waktu datang1 = new Waktu();
        Waktu pulang1 = new Waktu();

        p1.setNIP("001");
        p1.setNama("Athian");
        p1.setAlamat("Bandung");
        p1.setGol(2);

        datang1.setWaktu(8, 0, 0);
        pulang1.setWaktu(16, 30, 0);

        Pegawai p2 = new Pegawai();
        Waktu datang2 = new Waktu();
        Waktu pulang2 = new Waktu();

        p2.setPegawai("Dzar", "002", 1, "Sumedang");

        datang2.setWaktu(22, 0, 0);
        pulang2.setWaktu(7, 0, 0);

        Pegawai p3 = new Pegawai();
        Waktu datang3 = new Waktu();
        Waktu pulang3 = new Waktu();

        p3.setPegawai("Dila", "003", 4, "Garut");

        datang3.setWaktu(7, 30, 0);
        pulang3.setWaktu(16, 0, 0);

        kumpulanSetter.tambahPegawai(p1, datang1, pulang1);
        kumpulanSetter.tambahPegawai(p2, datang2, pulang2);
        kumpulanSetter.tambahPegawai(p3, datang3, pulang3);

        cetakLaporan(kumpulanSetter, "Setter");
    }

    public void inputDalam() {
        System.out.println();
        System.out.println("=== INPUT DALAM ===");

        ArrayPegawai kumpulanDalam = new ArrayPegawai();
        int banyak;

        do {
            System.out.print(
                "Masukkan jumlah pegawai (maksimal 10): "
            );
            banyak = input.nextInt();
            input.nextLine();

            if (banyak < 1 || banyak > 10) {
                System.out.println(
                    "Jumlah pegawai harus 1-10!"
                );
            }
        } while (banyak < 1 || banyak > 10);

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println(
                "===== PEGAWAI KE-" + (i + 1) + " ====="
            );

            Pegawai pegawai = new Pegawai();
            Waktu datang = new Waktu();
            Waktu pulang = new Waktu();

            pegawai.inputPegawai(input);

            System.out.println();
            System.out.println("=== WAKTU DATANG ===");
            datang.inputWaktu(input);

            System.out.println();
            System.out.println("=== WAKTU PULANG ===");
            pulang.inputWaktu(input);

            kumpulanDalam.tambahPegawai(
                pegawai, datang, pulang
            );
        }

        cetakLaporan(kumpulanDalam, "Input Dalam");
    }

    public void inputLuar() {
        System.out.println();
        System.out.println("=== INPUT LUAR ===");

        ArrayPegawai kumpulanLuar = new ArrayPegawai();
        int banyak;

        do {
            System.out.print(
                "Masukkan jumlah pegawai (maksimal 10): "
            );
            banyak = input.nextInt();
            input.nextLine();

            if (banyak < 1 || banyak > 10) {
                System.out.println(
                    "Jumlah pegawai harus 1-10!"
                );
            }
        } while (banyak < 1 || banyak > 10);

        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println(
                "===== PEGAWAI KE-" + (i + 1) + " ====="
            );

            Pegawai data = new Pegawai();
            Waktu waktuDatang = new Waktu();
            Waktu waktuPulang = new Waktu();

            inputPegawaiLuar(data);
            inputWaktuLuar(waktuDatang, "WAKTU DATANG");
            inputWaktuLuar(waktuPulang, "WAKTU PULANG");

            kumpulanLuar.tambahPegawai(
                data, waktuDatang, waktuPulang
            );
        }

        cetakLaporan(kumpulanLuar, "Input Luar");
    }

    public void tampilkanMenu() {
        System.out.println();
        System.out.println("===== MENU GAJI PEGAWAI =====");
        System.out.println("1. Constructor Berparameter");
        System.out.println("2. Setter");
        System.out.println("3. Input Dalam");
        System.out.println("4. Input Luar");
        System.out.println("5. Keluar");
        System.out.println("=============================");
        System.out.print("Pilih menu: ");

        pilihan = input.nextInt();
        input.nextLine();
    }

    public void prosesMenu() {
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
                System.out.println();
                System.out.println("Program selesai.");
                break;
            default:
                System.out.println();
                System.out.println("Pilihan tidak tersedia!");
        }
    }
}

public class GajiPegawai_250012_250051_250093 {
    public static void main(String[] args) {
        Menu menu = new Menu();

        do {
            menu.tampilkanMenu();
            menu.prosesMenu();
        } while (menu.getPilihan() != 5);
    }
}