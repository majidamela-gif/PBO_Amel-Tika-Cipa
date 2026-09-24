"""
Nama Program : Program Gaji Pegawai menggunakan Waktu
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program gaji pegawai menggunakan waktu secara OOP
                dibuat 2 Class (Class Pegawai dan Class Waktu)
"""

class Pegawai:
    def __init__(self, nama="", nip="", golongan=0):
        self.nama = nama
        self.nip = nip
        self.golongan = golongan

    def setNama(self, nama):
        self.nama = nama

    def setNip(self, nip):
        self.nip = nip

    def setGolongan(self, golongan):
        self.golongan = golongan

    def getNama(self):
        return self.nama

    def getNip(self):
        return self.nip

    def getGolongan(self):
        return self.golongan

    def inputDalam(self):
        self.nama = input("Masukkan nama pegawai: ")
        self.nip = input("Masukkan NIP pegawai: ")

        while True:
            golongan = int(input("Masukkan golongan: "))
            if 1 <= golongan <= 4:
                self.golongan = golongan
                break
            print("Golongan tidak valid!")

    def hitungGapok(self):
        if self.golongan == 1:
            return 1500000
        elif self.golongan == 2:
            return 2000000
        elif self.golongan == 3:
            return 3000000
        elif self.golongan == 4:
            return 5000000
        return 0

    def hitungTunjangan(self):
        if self.golongan == 1:
            return self.hitungGapok() * 0.10
        elif self.golongan == 2:
            return self.hitungGapok() * 0.12
        elif self.golongan == 3:
            return self.hitungGapok() * 0.12
        elif self.golongan == 4:
            return self.hitungGapok() * 0.15
        return 0

    def hitungPotongan(self):
        if self.golongan == 1:
            return self.hitungGapok() * 0.01
        elif self.golongan == 2:
            return self.hitungGapok() * 0.02
        elif self.golongan == 3:
            return self.hitungGapok() * 0.02
        elif self.golongan == 4:
            return self.hitungGapok() * 0.04
        return 0

    def hitungGaji(self):
        return self.hitungGapok() + self.hitungTunjangan() - self.hitungPotongan()


class Waktu:
    def __init__(self, waktuDatang="00:00:00", waktuPulang="00:00:00"):
        self.waktuDatang = waktuDatang
        self.waktuPulang = waktuPulang

    def setWaktuDatang(self, waktuDatang):
        self.waktuDatang = waktuDatang

    def setWaktuPulang(self, waktuPulang):
        self.waktuPulang = waktuPulang

    def getWaktuDatang(self):
        return self.waktuDatang

    def getWaktuPulang(self):
        return self.waktuPulang

    def keDetik(self, waktu):
        jam, menit, detik = map(int, waktu.split(":"))
        return jam * 3600 + menit * 60 + detik

    def lamaKerja(self):
        datang = self.keDetik(self.waktuDatang)
        pulang = self.keDetik(self.waktuPulang)

        lama = pulang - datang

        jam = lama // 3600
        menit = (lama % 3600) // 60
        detik = lama % 60

        return f"{jam:02d}:{menit:02d}:{detik:02d}"


def inputLuar(data):
    data.setNama(input("Masukkan nama pegawai: "))
    data.setNip(input("Masukkan NIP pegawai: "))

    while True:
        golongan = int(input("Masukkan golongan: "))
        if 1 <= golongan <= 4:
            data.setGolongan(golongan)
            break
        print("Golongan tidak valid!")


def inputWaktu(waktu):
    waktu.setWaktuDatang(input("Masukkan waktu datang (HH:MM:SS): "))
    waktu.setWaktuPulang(input("Masukkan waktu pulang (HH:MM:SS): "))


def formatRupiah(angka):
    return f"{int(angka):,}".replace(",", ".")


def cetakTabel(data, waktu):
    print()
    print("+------------------+-------------+-----+----------+----------+------------+-----------------+")
    print("|                               HASIL PERHITUNGAN GAJI                                      |")
    print("+------------------+-------------+-----+----------+----------+------------+-----------------+")
    print("| NIP              | Nama        | Gol | Datang   | Pulang   | Lama Kerja | Total Gaji      |")
    print("+------------------+-------------+-----+----------+----------+------------+-----------------+")
    print(f"| {data.getNip():<16} | {data.getNama():<11} | {data.getGolongan():<3} | "
          f"{waktu.getWaktuDatang():<8} | {waktu.getWaktuPulang():<8} | "
          f"{waktu.lamaKerja():<10} | Rp.{formatRupiah(data.hitungGaji()):<13}|")
    print("+------------------+-------------+-----+----------+----------+------------+-----------------+")


def menu():
    pilihan = 0

    while pilihan != 5:
        print()
        print("===== MENU GAJI PEGAWAI =====")
        print("1. Object 1 - Constructor Berparameter")
        print("2. Object 2 - Setter")
        print("3. Object 3 - Input Dalam")
        print("4. Object 4 - Input Luar")
        print("5. Keluar")

        pilihan = int(input("Pilih menu: "))

        if pilihan == 1:
            print("\nConstructor Berparameter")

            data1 = Pegawai("CiKaMel", "140810519312", 4)
            waktu1 = Waktu("07:30:00", "18:20:00")

            cetakTabel(data1, waktu1)

        elif pilihan == 2:
            print("\nSetter")

            data2 = Pegawai()
            data2.setNama("Atika")
            data2.setNip("140810250093")
            data2.setGolongan(2)

            waktu2 = Waktu()
            waktu2.setWaktuDatang("08:00:00")
            waktu2.setWaktuPulang("17:00:00")

            cetakTabel(data2, waktu2)

        elif pilihan == 3:
            print("\nInput Dalam")

            data3 = Pegawai()
            data3.inputDalam()

            waktu3 = Waktu()
            inputWaktu(waktu3)

            cetakTabel(data3, waktu3)

        elif pilihan == 4:
            print("\nInput Luar")

            data4 = Pegawai()
            inputLuar(data4)

            waktu4 = Waktu()
            inputWaktu(waktu4)

            cetakTabel(data4, waktu4)

        elif pilihan == 5:
            print("Program selesai.")

        else:
            print("Menu tidak tersedia!")


def main():
    menu()


if __name__ == "__main__":
    main()