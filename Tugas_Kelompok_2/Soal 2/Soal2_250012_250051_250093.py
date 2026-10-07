"""
Nama Program : Program Selisih Waktu OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 06 Oktober 2026
Deskripsi    : Buat program OOP untuk mencari selisih waktu
                ◼ Atribut : jam, menit, detik
                ◼ constructor, input (dalam & luar), output (dalam& luar)
               Method Proses (Cari selisih waktu) dengan cara 1 (fungsi return) dan cara 2 (void)
               Class Menu dipisah
"""

class Waktu:
    def __init__(self, jam=0, menit=0, detik=0):
        self.__jam = 0
        self.__menit = 0
        self.__detik = 0

        self.setJam(jam)
        self.setMenit(menit)
        self.setDetik(detik)

    def getJam(self):
        return self.__jam

    def setJam(self, jam):
        if 0 <= jam <= 23:
            self.__jam = jam
        else:
            self.__jam = 0
            print("Jam harus 0-23!")

    def getMenit(self):
        return self.__menit

    def setMenit(self, menit):
        if 0 <= menit <= 59:
            self.__menit = menit
        else:
            self.__menit = 0
            print("Menit harus 0-59!")

    def getDetik(self):
        return self.__detik

    def setDetik(self, detik):
        if 0 <= detik <= 59:
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
            if 0 <= jam <= 23:
                break
            print("Jam harus 0-23!")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))
            if 0 <= menit <= 59:
                break
            print("Menit harus 0-59!")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))
            if 0 <= detik <= 59:
                break
            print("Detik harus 0-59!")

        self.setWaktu(jam, menit, detik)

    def konvertDetik(self):
        return self.__jam * 3600 + self.__menit * 60 + self.__detik

    def selisihVoid(self, waktuA, waktuB):
        totalA = waktuA.konvertDetik()
        totalB = waktuB.konvertDetik()

        selisih = abs(totalA - totalB)

        self.__jam = selisih // 3600
        self.__menit = (selisih % 3600) // 60
        self.__detik = selisih % 60

    def selisihReturn(self, waktu):
        totalA = self.konvertDetik()
        totalB = waktu.konvertDetik()

        selisih = abs(totalA - totalB)

        hasil = Waktu()

        hasil.__jam = selisih // 3600
        hasil.__menit = (selisih % 3600) // 60
        hasil.__detik = selisih % 60

        return hasil

    def cetakWaktu(self):
        print(
            str(self.__jam).zfill(2) + ":" +
            str(self.__menit).zfill(2) + ":" +
            str(self.__detik).zfill(2)
        )


class Menu:
    def __init__(self):
        self.__pilihan = 0

    def getPilihan(self):
        return self.__pilihan

    def inputWaktuLuar(self, waktu):
        while True:
            jam = int(input("Masukkan Jam (0-23): "))
            if 0 <= jam <= 23:
                break
            print("Jam harus 0-23!")

        while True:
            menit = int(input("Masukkan Menit (0-59): "))
            if 0 <= menit <= 59:
                break
            print("Menit harus 0-59!")

        while True:
            detik = int(input("Masukkan Detik (0-59): "))
            if 0 <= detik <= 59:
                break
            print("Detik harus 0-59!")

        waktu.setWaktu(jam, menit, detik)

    def cetakLuar(self, waktu, label):
        print(label + " = ", end="")
        waktu.cetakWaktu()

    def cetakOutput(self, waktuA, waktuB):
        print("\n=== DATA WAKTU ===")

        self.cetakLuar(waktuA, "Waktu A")
        self.cetakLuar(waktuB, "Waktu B")

        hasilVoid = Waktu()
        hasilVoid.selisihVoid(waktuA, waktuB)

        hasilReturn = waktuA.selisihReturn(waktuB)

        self.cetakLuar(hasilVoid, "Void")
        self.cetakLuar(hasilReturn, "Return")

    def tampilkanMenu(self):
        print("\n==============================")
        print("       MENU WAKTU")
        print("==============================")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Dalam")
        print("4. Input Luar")
        print("5. Keluar")
        self.__pilihan = int(input("Pilih menu : "))

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

    def constructor(self):
        print("\n=== CONSTRUCTOR BERPAMETER ===")

        waktuA = Waktu(10, 15, 20)
        waktuB = Waktu(8, 20, 30)

        self.cetakOutput(waktuA, waktuB)

    def setter(self):
        print("\n=== SETTER ===")

        waktuA = Waktu()
        waktuB = Waktu()

        waktuA.setWaktu(8, 20, 30)
        waktuB.setWaktu(10, 15, 20)

        self.cetakOutput(waktuA, waktuB)

    def inputDalam(self):
        print("\n=== INPUT WAKTU DALAM ===")

        waktuA = Waktu()
        waktuB = Waktu()

        print("\nInput untuk Waktu A:")
        waktuA.inputWaktu()

        print("\nInput untuk Waktu B:")
        waktuB.inputWaktu()

        self.cetakOutput(waktuA, waktuB)

    def inputLuar(self):
        print("\n=== INPUT WAKTU LUAR ===")

        waktuA = Waktu()
        waktuB = Waktu()

        print("\nInput untuk Waktu A:")
        self.inputWaktuLuar(waktuA)

        print("\nInput untuk Waktu B:")
        self.inputWaktuLuar(waktuB)

        self.cetakOutput(waktuA, waktuB)


def main():
    menu = Menu()

    while menu.getPilihan() != 5:
        menu.tampilkanMenu()
        menu.prosesMenu()


if __name__ == "__main__":
    main()