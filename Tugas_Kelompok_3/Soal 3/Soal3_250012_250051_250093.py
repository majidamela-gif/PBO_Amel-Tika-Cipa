"""
Nama Program : Program Gaji OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 14 Oktober 2026
Deskripsi    : Buatlah program OOP Array of Object untuk mencari gaji harian da lembur berdasarkan lama kerja pegawai dgn aturan sbb:
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
                Buat 4 class (Waktu, Pegawai, Array of Pegawai dan Menu yang masing-masing memiliki constructor, method input-proses-output) selain class utama
"""
class Waktu:
    def __init__(self, jam=0, menit=0, detik=0):
        self.__jam = 0
        self.__menit = 0
        self.__detik = 0
        self.setWaktu(jam, menit, detik)

    def getJam(self):
        return self.__jam

    def getMenit(self):
        return self.__menit

    def getDetik(self):
        return self.__detik

    def setJam(self, jam):
        if 0 <= jam < 24:
            self.__jam = jam
        else:
            self.__jam = 0
            print("Jam harus 0-23.")

    def setMenit(self, menit):
        if 0 <= menit < 60:
            self.__menit = menit
        else:
            self.__menit = 0
            print("Menit harus 0-59.")

    def setDetik(self, detik):
        if 0 <= detik < 60:
            self.__detik = detik
        else:
            self.__detik = 0
            print("Detik harus 0-59.")

    def setWaktu(self, jam, menit, detik):
        self.setJam(jam)
        self.setMenit(menit)
        self.setDetik(detik)

    def inputWaktu(self):
        while True:
            jam = int(input("Masukkan Jam (0-23): "))
            if 0 <= jam < 24:
                break
            print("Jam harus 0-23.")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))
            if 0 <= menit < 60:
                break
            print("Menit harus 0-59.")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))
            if 0 <= detik < 60:
                break
            print("Detik harus 0-59.")

        self.setWaktu(jam, menit, detik)

    def konvertDetik(self):
        return self.__jam * 3600 + self.__menit * 60 + self.__detik

    def selisihVoid(self, A, B):
        totalA = A.konvertDetik()
        totalB = B.konvertDetik()

        if totalA >= totalB:
            selisih = totalA - totalB
        else:
            selisih = totalB - totalA

        self.__jam = selisih // 3600
        self.__menit = (selisih % 3600) // 60
        self.__detik = selisih % 60

    def selisihReturn(self, A):
        totalA = A.konvertDetik()
        totalThis = self.konvertDetik()

        if totalA >= totalThis:
            hasil = totalA - totalThis
        else:
            hasil = totalThis - totalA

        selisih = Waktu()
        selisih.__jam = hasil // 3600
        selisih.__menit = (hasil % 3600) // 60
        selisih.__detik = hasil % 60

        return selisih

    def cetakWaktu(self):
        print(
            f"{self.__jam:02d}:"
            f"{self.__menit:02d}:"
            f"{self.__detik:02d}",
            end=""
        )

class Pegawai:
    def __init__(self, nama="", NIP="", gol=0):
        self.__nama = nama
        self.__NIP = NIP
        self.__gol = gol

    def getNama(self):
        return self.__nama

    def getNIP(self):
        return self.__NIP

    def getGol(self):
        return self.__gol

    def setNama(self, nama):
        self.__nama = nama

    def setNIP(self, NIP):
        self.__NIP = NIP

    def setGol(self, gol):
        self.__gol = gol

    def setPegawai(self, nama, NIP, gol):
        self.__nama = nama
        self.__NIP = NIP
        self.__gol = gol

    def inputPegawai(self):
        self.__NIP = input("Masukkan NIP pegawai: ")
        self.__nama = input("Masukkan nama pegawai: ")

        while True:
            gol = int(input("Masukkan golongan: "))

            if 1 <= gol <= 4:
                self.__gol = gol
                break

            print("Golongan tidak valid.")
            print("Silahkan pilih golongan dengan rentang 1-4!")
            print()

    def hitungGajiHarian(self):
        if self.__gol == 1:
            return 150000
        elif self.__gol == 2:
            return 200000
        elif self.__gol == 3:
            return 400000
        elif self.__gol == 4:
            return 500000

        return 0

    def hitungLembur(self):
        if self.__gol == 1:
            return 50000
        elif self.__gol == 2:
            return 75000
        elif self.__gol == 3:
            return 150000
        elif self.__gol == 4:
            return 200000

        return 0

    def hitungLamaKerja(self, datang, pulang):
        totalDatang = datang.konvertDetik()
        totalPulang = pulang.konvertDetik()

        if totalPulang < totalDatang:
            totalPulang += 24 * 3600

        selisih = totalPulang - totalDatang

        jam = selisih // 3600
        menit = (selisih % 3600) // 60
        detik = selisih % 60

        lama = Waktu()
        lama._Waktu__jam = jam
        lama._Waktu__menit = menit
        lama._Waktu__detik = detik

        return lama

    def hitungJamKerja(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)
        return lama.getJam()

    def hitungJamLembur(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)
        totalDetik = lama.konvertDetik()

        if totalDetik < 9 * 3600:
            return 0

        detikLembur = totalDetik - 8 * 3600

        return detikLembur // 3600

    def hitungLamaLembur(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)
        totalDetik = lama.konvertDetik()

        if totalDetik < 9 * 3600:
            return Waktu(0, 0, 0)

        detikLembur = totalDetik - 8 * 3600

        jam = detikLembur // 3600
        menit = (detikLembur % 3600) // 60
        detik = detikLembur % 60

        lembur = Waktu()
        lembur._Waktu__jam = jam
        lembur._Waktu__menit = menit
        lembur._Waktu__detik = detik

        return lembur

    def hitungGajiLembur(self, datang, pulang):
        return self.hitungJamLembur(datang, pulang) * self.hitungLembur()

    def hitungGajiTotal(self, datang, pulang):
        return self.hitungGajiHarian() + self.hitungGajiLembur(
            datang, pulang
        )

    def hitungStatus(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)

        if lama.konvertDetik() < 8 * 3600:
            return "peringatan"

        return "ok"

    def formatRibuan(self, angka):
        return f"{angka:,}".replace(",", ".")

    def formatWaktu(self, waktu):
        return (
            f"{waktu.getJam():02d}:"
            f"{waktu.getMenit():02d}:"
            f"{waktu.getDetik():02d}"
        )

    def cetakPegawai(self, datang, pulang, no):
        lamaKerja = self.hitungLamaKerja(datang, pulang)

        print(
            f"{no:<4}"
            f"{self.getNIP():<10}"
            f"{self.getNama():<12}"
            f"{self.getGol():<5}"
            f"{self.formatWaktu(datang):<10}"
            f"{self.formatWaktu(pulang):<10}"
            f"{self.formatWaktu(lamaKerja):<10}"
            f"{self.formatWaktu(self.hitungLamaLembur(datang, pulang)):<12}"
            f"{self.formatRibuan(self.hitungGajiHarian()):<15}"
            f"{self.formatRibuan(self.hitungGajiLembur(datang, pulang)):<12}"
            f"{self.formatRibuan(self.hitungGajiTotal(datang, pulang)):<15}"
            f"{self.hitungStatus(datang, pulang):<12}"
        )

class ArrayPegawai:
    def __init__(self):
        self.__data = [Pegawai() for _ in range(10)]
        self.__waktuDatang = [Waktu() for _ in range(10)]
        self.__waktuPulang = [Waktu() for _ in range(10)]
        self.__jumlah = 0

    def getJumlah(self):
        return self.__jumlah

    def getPegawai(self, index):
        p = self.__data[index]

        return Pegawai(
            p.getNama(),
            p.getNIP(),
            p.getGol()
        )

    def getWaktuDatang(self, index):
        w = self.__waktuDatang[index]

        return Waktu(
            w.getJam(),
            w.getMenit(),
            w.getDetik()
        )

    def getWaktuPulang(self, index):
        w = self.__waktuPulang[index]

        return Waktu(
            w.getJam(),
            w.getMenit(),
            w.getDetik()
        )

    def tambahPegawai(self, pegawai, datang, pulang):
        if self.__jumlah < 10:
            i = self.__jumlah

            self.__data[i] = Pegawai(
                pegawai.getNama(),
                pegawai.getNIP(),
                pegawai.getGol()
            )

            self.__waktuDatang[i] = Waktu(
                datang.getJam(),
                datang.getMenit(),
                datang.getDetik()
            )

            self.__waktuPulang[i] = Waktu(
                pulang.getJam(),
                pulang.getMenit(),
                pulang.getDetik()
            )

            self.__jumlah += 1

        else:
            print("Array pegawai sudah penuh!")

class Menu:
    def __init__(self):
        self.__pilihan = 0
        self.__kumpulan = ArrayPegawai()

    def getPilihan(self):
        return self.__pilihan

    def inputPegawaiLuar(self, data):
        NIP = input("Masukkan NIP pegawai: ")
        nama = input("Masukkan nama pegawai: ")

        while True:
            gol = int(input("Masukkan golongan: "))

            if 1 <= gol <= 4:
                break

            print("Golongan harus 1-4!")

        data.setNIP(NIP)
        data.setNama(nama)
        data.setGol(gol)

    def inputWaktuLuar(self, waktu, keterangan):
        print()
        print(f"=== {keterangan} ===")

        while True:
            jam = int(input("Masukkan Jam (0-23): "))

            if 0 <= jam < 24:
                break

            print("Jam harus 0-23.")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))

            if 0 <= menit < 60:
                break

            print("Menit harus 0-59.")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))

            if 0 <= detik < 60:
                break

            print("Detik harus 0-59.")

        waktu.setWaktu(jam, menit, detik)

    def cetakHeader(self):
        print()
        print("                 Daftar Gaji Harian PT Informatika")
        print()
        print("-" * 140)

        print(
            f"{'No':<4}"
            f"{'NIP':<10}"
            f"{'Nama':<12}"
            f"{'Gol':<5}"
            f"{'Datang':<10}"
            f"{'Pulang':<10}"
            f"{'Lama':<10}"
            f"{'Jam Lembur':<12}"
            f"{'Gaji Harian':<15}"
            f"{'Lembur':<12}"
            f"{'Total':<15}"
            f"{'Status':<12}"
        )

        print("-" * 140)

    def cetakTabel(self):
        if self.__kumpulan.getJumlah() == 0:
            print("Belum ada data pegawai.")
            return

        self.cetakHeader()

        for i in range(self.__kumpulan.getJumlah()):
            data = self.__kumpulan.getPegawai(i)
            datang = self.__kumpulan.getWaktuDatang(i)
            pulang = self.__kumpulan.getWaktuPulang(i)

            data.cetakPegawai(datang, pulang, i + 1)

        print("-" * 140)

    def constructor(self):
        print()
        print("=== CONSTRUCTOR BERPAMETER ===")

        kumpulanConstructor = ArrayPegawai()

        kumpulanConstructor.tambahPegawai(
            Pegawai("Syifa", "012", 3),
            Waktu(8, 0, 0),
            Waktu(17, 15, 10)
        )

        kumpulanConstructor.tambahPegawai(
            Pegawai("Amela", "051", 2),
            Waktu(8, 0, 0),
            Waktu(19, 30, 10)
        )

        kumpulanConstructor.tambahPegawai(
            Pegawai("Atika", "093", 4),
            Waktu(8, 0, 0),
            Waktu(14, 0, 10)
        )

        print()

        if kumpulanConstructor.getJumlah() > 0:
            self.cetakHeader()

            for i in range(kumpulanConstructor.getJumlah()):
                data = kumpulanConstructor.getPegawai(i)
                datang = kumpulanConstructor.getWaktuDatang(i)
                pulang = kumpulanConstructor.getWaktuPulang(i)

                data.cetakPegawai(datang, pulang, i + 1)

            print("-" * 140)

    def setter(self):
        print()
        print("=== SETTER ===")

        kumpulanSetter = ArrayPegawai()

        p1 = Pegawai()
        datang1 = Waktu()
        pulang1 = Waktu()

        p1.setNIP("001")
        p1.setNama("Doni")
        p1.setGol(2)

        datang1.setWaktu(8, 0, 0)
        pulang1.setWaktu(16, 30, 0)

        p2 = Pegawai()
        datang2 = Waktu()
        pulang2 = Waktu()

        p2.setPegawai("Tari", "002", 1)

        datang2.setWaktu(22, 0, 0)
        pulang2.setWaktu(7, 0, 0)

        p3 = Pegawai()
        datang3 = Waktu()
        pulang3 = Waktu()

        p3.setPegawai("Iqbal", "003", 4)

        datang3.setWaktu(7, 30, 0)
        pulang3.setWaktu(16, 0, 0)

        kumpulanSetter.tambahPegawai(p1, datang1, pulang1)
        kumpulanSetter.tambahPegawai(p2, datang2, pulang2)
        kumpulanSetter.tambahPegawai(p3, datang3, pulang3)

        self.cetakHeader()

        for i in range(kumpulanSetter.getJumlah()):
            data = kumpulanSetter.getPegawai(i)
            datang = kumpulanSetter.getWaktuDatang(i)
            pulang = kumpulanSetter.getWaktuPulang(i)

            data.cetakPegawai(datang, pulang, i + 1)

        print("-" * 140)

    def inputDalam(self):
        print()
        print("=== INPUT DALAM ===")

        while True:
            banyak = int(
                input("Masukkan jumlah pegawai (maksimal 10): ")
            )

            if 1 <= banyak <= 10:
                break

            print("Jumlah pegawai harus 1-10!")

        for i in range(banyak):
            print()
            print(f"===== PEGAWAI KE-{i + 1} =====")

            pegawai = Pegawai()
            datang = Waktu()
            pulang = Waktu()

            pegawai.inputPegawai()

            print()
            print("=== WAKTU DATANG ===")
            datang.inputWaktu()

            print()
            print("=== WAKTU PULANG ===")
            pulang.inputWaktu()

            self.__kumpulan.tambahPegawai(
                pegawai, datang, pulang
            )

        self.cetakTabel()

    def inputLuar(self):
        print()
        print("=== INPUT LUAR ===")

        while True:
            banyak = int(
                input("Masukkan jumlah pegawai (maksimal 10): ")
            )

            if 1 <= banyak <= 10:
                break

            print("Jumlah pegawai harus 1-10!")

        for i in range(banyak):
            print()
            print(f"===== PEGAWAI KE-{i + 1} =====")

            data = Pegawai()
            waktuDatang = Waktu()
            waktuPulang = Waktu()

            self.inputPegawaiLuar(data)

            self.inputWaktuLuar(
                waktuDatang, "WAKTU DATANG"
            )

            self.inputWaktuLuar(
                waktuPulang, "WAKTU PULANG"
            )

            self.__kumpulan.tambahPegawai(
                data, waktuDatang, waktuPulang
            )

        self.cetakTabel()

    def tampilkanMenu(self):
        print()
        print("===== MENU GAJI PEGAWAI =====")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Dalam")
        print("4. Input Luar")
        print("5. Keluar")
        print("=============================")

        self.__pilihan = int(input("Pilih menu: "))

    def prosesMenu(self):
        if self.__pilihan == 1:
            self.constructor()

        elif self.__pilihan == 2:
            self.setter()

        elif self.__pilihan == 3:
            self.inputDalam()

        elif self.__pilihan == 4:
            self.inputLuar()

        elif self.__pilihan == 5:
            print()
            print("Program selesai.")

        else:
            print()
            print("Pilihan tidak tersedia!")

def main():
    menu = Menu()

    while True:
        menu.tampilkanMenu()
        menu.prosesMenu()

        if menu.getPilihan() == 5:
            break

if __name__ == "__main__":
    main()