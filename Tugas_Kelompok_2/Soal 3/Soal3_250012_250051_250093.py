"""
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
                menu dipisah Class nya
"""

class Waktu:
    def __init__(self, jam=0, menit=0, detik=0):
        self.__jam = jam
        self.__menit = menit
        self.__detik = detik

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
            print("Jam harus 0-23!")

    def setMenit(self, menit):
        if 0 <= menit < 60:
            self.__menit = menit
        else:
            self.__menit = 0
            print("Menit harus 0-59!")

    def setDetik(self, detik):
        if 0 <= detik < 60:
            self.__detik = detik
        else:
            self.__detik = 0
            print("Detik harus 0-59!")

    def setWaktu(self, jam, menit, detik):
        self.setJam(jam)
        self.setMenit(menit)
        self.setDetik(detik)

    def inputWaktu(self):
        while True:
            jam = int(input("Masukkan Jam (0-23): "))

            if 0 <= jam < 24:
                break

            print("Jam harus 0-23!")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))

            if 0 <= menit < 60:
                break

            print("Menit harus 0-59!")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))

            if 0 <= detik < 60:
                break

            print("Detik harus 0-59!")

        self.setWaktu(jam, menit, detik)

    def konvertDetik(self):
        return self.__jam * 3600 + self.__menit * 60 + self.__detik

    def selisihVoid(self, A, B):
        totalA = A.konvertDetik()
        totalB = B.konvertDetik()

        selisih = abs(totalA - totalB)

        self.__jam = selisih // 3600
        self.__menit = (selisih % 3600) // 60
        self.__detik = selisih % 60

    def selisihReturn(self, A):
        selisih = Waktu()

        totalA = A.konvertDetik()
        totalThis = self.konvertDetik()

        hasil = abs(totalA - totalThis)

        selisih.__jam = hasil // 3600
        selisih.__menit = (hasil % 3600) // 60
        selisih.__detik = hasil % 60

        return selisih

    def cetakWaktu(self):
        print(
            str(self.__jam).zfill(2) + ":" +
            str(self.__menit).zfill(2) + ":" +
            str(self.__detik).zfill(2)
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
            self.__gol = int(input("Masukkan golongan: "))

            if 1 <= self.__gol <= 4:
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

    def hitungLamaKerja(self, datang, pulang):
        totalDatang = datang.konvertDetik()
        totalPulang = pulang.konvertDetik()

        if totalPulang < totalDatang:
            totalPulang = totalPulang + (24 * 3600)

        selisih = totalPulang - totalDatang

        jam = selisih // 3600
        menit = (selisih % 3600) // 60
        detik = selisih % 60

        return Waktu(jam, menit, detik)

    def hitungJamKerja(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)
        return lama.getJam()

    def hitungJamLembur(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)

        totalDetik = lama.konvertDetik()

        if totalDetik < (9 * 3600):
            return 0

        detikLembur = totalDetik - (8 * 3600)

        return detikLembur // 3600

    def hitungLamaLembur(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)

        totalDetik = lama.konvertDetik()

        if totalDetik < (9 * 3600):
            return Waktu(0, 0, 0)

        detikLembur = totalDetik - (8 * 3600)

        jam = detikLembur // 3600
        menit = (detikLembur % 3600) // 60
        detik = detikLembur % 60

        return Waktu(jam, menit, detik)

    def hitungGajiLembur(self, datang, pulang):
        return self.hitungJamLembur(datang, pulang) * self.hitungLembur()

    def hitungGajiTotal(self, datang, pulang):
        return self.hitungGajiHarian() + self.hitungGajiLembur(datang, pulang)

    def hitungStatus(self, datang, pulang):
        lama = self.hitungLamaKerja(datang, pulang)

        if lama.konvertDetik() < (8 * 3600):
            return "peringatan"

        return "ok"

    def formatRibuan(self, angka):
        return f"{angka:,}".replace(",", ".")

    def formatWaktu(self, waktu):
        return (
            str(waktu.getJam()).zfill(2) + ":" +
            str(waktu.getMenit()).zfill(2) + ":" +
            str(waktu.getDetik()).zfill(2)
        )

    def cetakPegawai(self, datang, pulang, no):
        lamaKerja = self.hitungLamaKerja(datang, pulang)

        print(
            f"{no:<3} "
            f"{self.getNIP():<4} "
            f"{self.getNama():<10} "
            f"{self.getGol():<3} "
            f"{self.formatWaktu(datang):<9} "
            f"{self.formatWaktu(pulang):<9} "
            f"{self.formatWaktu(lamaKerja):<9} "
            f"{self.formatWaktu(self.hitungLamaLembur(datang, pulang)):<11} "
            f"{self.formatRibuan(self.hitungGajiHarian()):<12} "
            f"{self.formatRibuan(self.hitungGajiLembur(datang, pulang)):<9} "
            f"{self.formatRibuan(self.hitungGajiTotal(datang, pulang)):<9} "
            f"{self.hitungStatus(datang, pulang):<12}"
        )


class Menu:
    def __init__(self):
        self.__pilihan = 0
        self.__nomor = 1

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
        print("=== " + keterangan + " ===")

        while True:
            jam = int(input("Masukkan Jam (0-23): "))

            if 0 <= jam < 24:
                break

            print("Jam harus 0-23!")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))

            if 0 <= menit < 60:
                break

            print("Menit harus 0-59!")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))

            if 0 <= detik < 60:
                break

            print("Detik harus 0-59!")

        waktu.setWaktu(jam, menit, detik)

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
            print("\nProgram selesai.")

        else:
            print("\nPilihan tidak tersedia!")

    def getPilihan(self):
        return self.__pilihan

    def constructor(self):
        print("\n=== CONSTRUCTOR BERPAMETER ===")

        data = Pegawai("Ali", "001", 3)
        waktuDatang = Waktu(8, 0, 0)
        waktuPulang = Waktu(17, 15, 10)

        self.cetakHeader()
        self.cetakLuar(data, waktuDatang, waktuPulang)

    def setter(self):
        print("\n=== SETTER ===")

        data = Pegawai()
        waktuDatang = Waktu()
        waktuPulang = Waktu()

        data.setNIP("002")
        data.setNama("Audina")
        data.setGol(2)

        waktuDatang.setWaktu(8, 0, 0)
        waktuPulang.setWaktu(16, 30, 0)

        self.cetakHeader()
        self.cetakLuar(data, waktuDatang, waktuPulang)

    def inputDalam(self):
        print("\n=== INPUT DALAM ===")

        data = Pegawai()
        waktuDatang = Waktu()
        waktuPulang = Waktu()

        data.inputPegawai()

        print()
        print("=== WAKTU DATANG ===")
        waktuDatang.inputWaktu()

        print()
        print("=== WAKTU PULANG ===")
        waktuPulang.inputWaktu()

        self.cetakHeader()
        self.cetakLuar(data, waktuDatang, waktuPulang)

    def inputLuar(self):
        print("\n=== INPUT LUAR ===")

        data = Pegawai()
        waktuDatang = Waktu()
        waktuPulang = Waktu()

        self.inputPegawaiLuar(data)
        self.inputWaktuLuar(waktuDatang, "WAKTU DATANG")
        self.inputWaktuLuar(waktuPulang, "WAKTU PULANG")

        self.cetakHeader()
        self.cetakLuar(data, waktuDatang, waktuPulang)

    def cetakHeader(self):
        print()
        print("                 Daftar Gaji Harian PT Informatika")
        print()

        print(
            f"{'No':<3} "
            f"{'NIP':<4} "
            f"{'Nama':<10} "
            f"{'Gol':<3} "
            f"{'Datang':<9} "
            f"{'Pulang':<9} "
            f"{'Lama':<9} "
            f"{'Jam Lembur':<11} "
            f"{'Gaji Harian':<12} "
            f"{'Lembur':<9} "
            f"{'Total':<9} "
            f"{'Status':<12}"
        )

        print("-" * 115)

    def cetakLuar(self, data, waktuDatang, waktuPulang):
        data.cetakPegawai(
            waktuDatang,
            waktuPulang,
            self.__nomor
        )

        self.__nomor += 1


def main():
    menu = Menu()

    while menu.getPilihan() != 5:
        menu.tampilkanMenu()
        menu.prosesMenu()


if __name__ == "__main__":
    main()