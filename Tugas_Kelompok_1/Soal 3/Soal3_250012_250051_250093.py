"""
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
"""


class Waktu:
    def __init__(self, jamDatang=0, menitDatang=0, detikDatang=0,
                 jamPulang=0, menitPulang=0, detikPulang=0):
        self.__jamDatang = jamDatang
        self.__menitDatang = menitDatang
        self.__detikDatang = detikDatang
        self.__jamPulang = jamPulang
        self.__menitPulang = menitPulang
        self.__detikPulang = detikPulang

    def getWaktuDatang(self):
        return (
            self.__jamDatang,
            self.__menitDatang,
            self.__detikDatang
        )

    def setWaktuDatang(self, jam, menit, detik):
        self.__jamDatang = jam
        self.__menitDatang = menit
        self.__detikDatang = detik

    def getWaktuPulang(self):
        return (
            self.__jamPulang,
            self.__menitPulang,
            self.__detikPulang
        )

    def setWaktuPulang(self, jam, menit, detik):
        self.__jamPulang = jam
        self.__menitPulang = menit
        self.__detikPulang = detik

    def inputWaktu(self):
        print("Masukkan waktu datang")
        jamDatang = int(input("Masukkan jam datang: "))
        menitDatang = int(input("Masukkan menit datang: "))
        detikDatang = int(input("Masukkan detik datang: "))

        print("Masukkan waktu pulang")
        jamPulang = int(input("Masukkan jam pulang: "))
        menitPulang = int(input("Masukkan menit pulang: "))
        detikPulang = int(input("Masukkan detik pulang: "))

        self.setWaktuDatang(jamDatang, menitDatang, detikDatang)
        self.setWaktuPulang(jamPulang, menitPulang, detikPulang)

    def hitungDurasiDetik(self):
        detikDatang = (
            self.__jamDatang * 3600 +
            self.__menitDatang * 60 +
            self.__detikDatang
        )

        detikPulang = (
            self.__jamPulang * 3600 +
            self.__menitPulang * 60 +
            self.__detikPulang
        )

        durasi = detikPulang - detikDatang

        if durasi < 0:
            durasi += 24 * 3600

        return durasi

    def hitungDurasiJam(self):
        return self.hitungDurasiDetik() // 3600

    def hitungDurasiMenit(self):
        return (self.hitungDurasiDetik() % 3600) // 60

    def hitungDurasiSisaDetik(self):
        return self.hitungDurasiDetik() % 60

    def hitungLamaKerja(self):
        jam = self.hitungDurasiJam()
        menit = self.hitungDurasiMenit()
        detik = self.hitungDurasiSisaDetik()

        return f"{jam:02d}:{menit:02d}:{detik:02d}"

    def hitungJamLembur(self):
        durasi = self.hitungDurasiDetik()

        if durasi < 8 * 3600:
            return 0

        return (durasi - 8 * 3600) // 3600

    def hitungLamaLembur(self):
        durasi = self.hitungDurasiDetik()

        if durasi < 8 * 3600:
            return "00:00:00"

        lembur = durasi - 8 * 3600

        jam = lembur // 3600
        menit = (lembur % 3600) // 60
        detik = lembur % 60

        return f"{jam:02d}:{menit:02d}:{detik:02d}"


class Pegawai:
    def __init__(self, nama="", NIP="", gol=0):
        self.__nama = nama
        self.__NIP = NIP
        self.__gol = gol

    def getNama(self):
        return self.__nama

    def setNama(self, nama):
        self.__nama = nama

    def getNIP(self):
        return self.__NIP

    def setNIP(self, NIP):
        self.__NIP = NIP

    def getGol(self):
        return self.__gol

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
            self.__gol = int(input("Masukkan golongan: "))

            if self.__gol == 1 or self.__gol == 2 or self.__gol == 3 or self.__gol == 4:
                break

            print("Golongan tidak valid.")
            print("Silahkan pilih golongan dengan rentang 1-4!")
            print()

    def hitungGajiHarian(self):
        gaji = 0

        if self.__gol == 1:
            gaji = 150000
        elif self.__gol == 2:
            gaji = 200000
        elif self.__gol == 3:
            gaji = 400000
        elif self.__gol == 4:
            gaji = 500000

        return gaji

    def hitungLembur(self):
        lembur = 0

        if self.__gol == 1:
            lembur = 50000
        elif self.__gol == 2:
            lembur = 75000
        elif self.__gol == 3:
            lembur = 150000
        elif self.__gol == 4:
            lembur = 200000

        return lembur

    def hitungGajiLembur(self, waktu):
        return waktu.hitungJamLembur() * self.hitungLembur()

    def hitungGajiTotal(self, waktu):
        return self.hitungGajiHarian() + self.hitungGajiLembur(waktu)

    def hitungStatus(self, waktu):
        if waktu.hitungDurasiDetik() < 8 * 3600:
            return "peringatan"

        return "ok"

    def formatRibuan(self, angka):
        return f"{angka:,}".replace(",", ".")

    def cetakPegawai(self, waktu, no):
        print(
            f"{no:<4} "
            f"{self.getNIP():<10} "
            f"{self.getNama():<10} "
            f"{self.getGol():<5} "
            f"{self.formatWaktu(waktu.getWaktuDatang()):<11} "
            f"{self.formatWaktu(waktu.getWaktuPulang()):<11} "
            f"{waktu.hitungLamaKerja():<11} "
            f"{waktu.hitungLamaLembur():<13} "
            f"{self.formatRibuan(self.hitungGajiHarian()):<14} "
            f"{self.formatRibuan(self.hitungGajiLembur(waktu)):<11} "
            f"{self.formatRibuan(self.hitungGajiTotal(waktu)):<11} "
            f"{self.hitungStatus(waktu):<12}"
        )

    def formatWaktu(self, waktu):
        jam, menit, detik = waktu
        return f"{jam:02d}:{menit:02d}:{detik:02d}"


def tampilkanGaris():
    print("-" * 155)


def tampilkanHeader():
    print()
    print("                                                Daftar Gaji Harian PT Informatika")
    print()
    tampilkanGaris()

    print(
        f"{'No':<4} "
        f"{'NIP':<10} "
        f"{'Nama':<10} "
        f"{'Gol':<5} "
        f"{'Datang':<11} "
        f"{'Pulang':<11} "
        f"{'Lama':<11} "
        f"{'Jam Lembur':<13} "
        f"{'Gaji Harian':<14} "
        f"{'Lembur':<11} "
        f"{'Total':<11} "
        f"{'Status':<12}"
    )

    tampilkanGaris()


def menu():
    nomor = 1
    pilihan = 0

    while pilihan != 4:
        print()
        print("===== MENU GAJI PEGAWAI =====")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Pegawai")
        print("4. Keluar")

        pilihan = int(input("Pilih menu: "))

        if pilihan == 1:
            print("\n=== CONSTRUCTOR BERPAMETER ===")

            data1 = Pegawai("Ali", "001", 3)
            waktu1 = Waktu(8, 0, 0, 17, 15, 10)

            tampilkanHeader()
            data1.cetakPegawai(waktu1, nomor)
            nomor += 1
            tampilkanGaris()

        elif pilihan == 2:
            print("\n=== SETTER ===")

            data2 = Pegawai()
            waktu2 = Waktu()

            data2.setNIP("002")
            data2.setNama("Budi")
            data2.setGol(2)

            waktu2.setWaktuDatang(8, 0, 0)
            waktu2.setWaktuPulang(16, 30, 0)

            tampilkanHeader()
            data2.cetakPegawai(waktu2, nomor)
            nomor += 1
            tampilkanGaris()

        elif pilihan == 3:
            print("\n=== INPUT PEGAWAI ===")

            data3 = Pegawai()
            waktu3 = Waktu()

            data3.inputPegawai()
            waktu3.inputWaktu()

            tampilkanHeader()
            data3.cetakPegawai(waktu3, nomor)
            nomor += 1
            tampilkanGaris()

        elif pilihan == 4:
            print("\nProgram selesai.")

        else:
            print("\nPilihan tidak tersedia!")


def main():
    menu()


if __name__ == "__main__":
    main()