"""
Nama Program : Program Selisih Waktu OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 28 September 2026
Deskripsi    : Buat program OOP untuk mencari selisih waktu
                Atribut : jam, menit, detik
                Constructor, input (dalam & luar), output (dalam & luar)
                Method Proses:
                - Mencari selisih waktu dengan Return
                - Mencari selisih waktu dengan Void
"""


class Waktu:
    def __init__(self, jam=0, menit=0, detik=0):
        self.__jam = jam
        self.__menit = menit
        self.__detik = detik

    def getJam(self):
        return self.__jam

    def setJam(self, jam):
        self.__jam = jam

    def getMenit(self):
        return self.__menit

    def setMenit(self, menit):
        self.__menit = menit

    def getDetik(self):
        return self.__detik

    def setDetik(self, detik):
        self.__detik = detik

    def inputWaktu(self):
        self.__jam = int(input("Masukkan Jam: "))
        self.__menit = int(input("Masukkan Menit: "))
        self.__detik = int(input("Masukkan Detik: "))

    def setWaktu(self, jam, menit, detik):
        self.__jam = jam
        self.__menit = menit
        self.__detik = detik

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

        selisih.setJam(hasil // 3600)
        selisih.setMenit((hasil % 3600) // 60)
        selisih.setDetik(hasil % 60)

        return selisih

    def cetakWaktu(self):
        print(
            str(self.__jam) + ":" +
            str(self.__menit) + ":" +
            str(self.__detik)
        )

    def cetak(self, A, B):
        print("\n=== DATA WAKTU ===")

        print("Waktu A: ", end="")
        A.cetakWaktu()

        print("Waktu B: ", end="")
        B.cetakWaktu()

        hasilVoid = Waktu()
        hasilVoid.selisihVoid(A, B)

        hasilReturn = A.selisihReturn(B)

        print("Selisih Void: ", end="")
        hasilVoid.cetakWaktu()

        print("Selisih Return: ", end="")
        hasilReturn.cetakWaktu()


def menu():
    waktuA = Waktu()
    waktuB = Waktu()
    waktuT = Waktu()

    pilihan = 0

    while pilihan != 4:
        print("\n==============================")
        print("       MENU WAKTU")
        print("==============================")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Waktu")
        print("4. Keluar")

        pilihan = int(input("Pilih menu : "))

        if pilihan == 1:
            print("\n=== CONSTRUCTOR BERPAMETER ===")

            waktuA = Waktu(10, 15, 20)
            waktuB = Waktu(8, 20, 30)

            waktuT.cetak(waktuA, waktuB)

        elif pilihan == 2:
            print("\n=== SETTER ===")

            waktuA.setWaktu(8, 20, 30)
            waktuB.setWaktu(10, 15, 20)

            waktuT.cetak(waktuA, waktuB)

        elif pilihan == 3:
            print("\n=== INPUT WAKTU ===")

            print("\nMasukkan data Waktu A")
            waktuA.inputWaktu()

            print("\nMasukkan data Waktu B")
            waktuB.inputWaktu()

            waktuT.cetak(waktuA, waktuB)

        elif pilihan == 4:
            print("\nProgram selesai.")

        else:
            print("\nPilihan tidak tersedia!")


def main():
    menu()


if __name__ == "__main__":
    main()