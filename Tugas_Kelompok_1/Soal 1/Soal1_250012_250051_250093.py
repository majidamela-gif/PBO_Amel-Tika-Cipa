"""
Nama Program : Program Koordinat kartesian OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 28 September 2026
Deskripsi    : Buat program OOP koordinat kartesian
                Atribut : absis dan ordinat
                Constructor, input (dalam & luar), output (dalam & luar)
                Method Proses:
                - Mencari titik tengah
                - Nilai pencerminan terhadap sumbu X
                - Nilai pencerminan terhadap sumbu Y
                - Jarak antara 2 titik
"""

import math


class Koordinat:
    def __init__(self, absis=0, ordinat=0):
        self.__absis = absis
        self.__ordinat = ordinat

    def getAbsis(self):
        return self.__absis

    def setAbsis(self, absis):
        self.__absis = absis

    def getOrdinat(self):
        return self.__ordinat

    def setOrdinat(self, ordinat):
        self.__ordinat = ordinat

    def inputKoordinat(self):
        self.__absis = float(input("Masukkan absis: "))
        self.__ordinat = float(input("Masukkan ordinat: "))

    def setKoordinat(self, pAbsis, pOrdinat):
        self.__absis = pAbsis
        self.__ordinat = pOrdinat

    def titikTengahVoid(self, P1, P2):
        self.__absis = (P1.getAbsis() + P2.getAbsis()) / 2
        self.__ordinat = (P1.getOrdinat() + P2.getOrdinat()) / 2

    def titikTengahReturn(self, P):
        hasil = Koordinat()

        hasil.setAbsis(
            (P.getAbsis() + self.getAbsis()) / 2
        )

        hasil.setOrdinat(
            (P.getOrdinat() + self.getOrdinat()) / 2
        )

        return hasil

    def cerminSumbuXVoid(self, P):
        self.__absis = P.getAbsis()
        self.__ordinat = P.getOrdinat() * (-1)

    def cerminSumbuXReturn(self, P):
        hasil = Koordinat()

        hasil.setAbsis(P.getAbsis())
        hasil.setOrdinat(P.getOrdinat() * (-1))

        return hasil

    def cerminSumbuYVoid(self, P):
        self.__absis = P.getAbsis() * (-1)
        self.__ordinat = P.getOrdinat()

    def cerminSumbuYReturn(self, P):
        hasil = Koordinat()

        hasil.setAbsis(P.getAbsis() * (-1))
        hasil.setOrdinat(P.getOrdinat())

        return hasil

    def jarakVoid(self, P1, P2):
        jarak = math.sqrt(
            (P2.getAbsis() - P1.getAbsis()) ** 2 +
            (P2.getOrdinat() - P1.getOrdinat()) ** 2
        )
        print(jarak)

    def jarakReturn(self, P1, P2):
        return math.sqrt(
            (P2.getAbsis() - P1.getAbsis()) ** 2 +
            (P2.getOrdinat() - P1.getOrdinat()) ** 2
        )

    def cetakTitik(self):
        print("(" + str(self.__absis) + ", " + str(self.__ordinat) + ")")

    def cetak(self, P1, P2):
        print("=== DATA TITIK ===")

        print("Titik A = ", end="")
        P1.cetakTitik()

        print("Titik B = ", end="")
        P2.cetakTitik()

        hasilVoid = Koordinat()
        hasilVoid.titikTengahVoid(P1, P2)

        hasilReturn = P1.titikTengahReturn(P2)

        print("\n=== TITIK TENGAH ===")

        print("Void   : ", end="")
        hasilVoid.cetakTitik()

        print("Return : ", end="")
        hasilReturn.cetakTitik()

        cerminXP1Void = Koordinat()
        cerminXP1Void.cerminSumbuXVoid(P1)

        cerminXP1Return = P1.cerminSumbuXReturn(P1)

        print("\n=== CERMIN A TERHADAP SUMBU X ===")

        print("Void   : ", end="")
        cerminXP1Void.cetakTitik()

        print("Return : ", end="")
        cerminXP1Return.cetakTitik()

        cerminXP2Void = Koordinat()
        cerminXP2Void.cerminSumbuXVoid(P2)

        cerminXP2Return = P2.cerminSumbuXReturn(P2)

        print("\n=== CERMIN B TERHADAP SUMBU X ===")

        print("Void   : ", end="")
        cerminXP2Void.cetakTitik()

        print("Return : ", end="")
        cerminXP2Return.cetakTitik()

        cerminYP1Void = Koordinat()
        cerminYP1Void.cerminSumbuYVoid(P1)

        cerminYP1Return = P1.cerminSumbuYReturn(P1)

        print("\n=== CERMIN A TERHADAP SUMBU Y ===")

        print("Void   : ", end="")
        cerminYP1Void.cetakTitik()

        print("Return : ", end="")
        cerminYP1Return.cetakTitik()

        cerminYP2Void = Koordinat()
        cerminYP2Void.cerminSumbuYVoid(P2)

        cerminYP2Return = P2.cerminSumbuYReturn(P2)

        print("\n=== CERMIN B TERHADAP SUMBU Y ===")

        print("Void   : ", end="")
        cerminYP2Void.cetakTitik()

        print("Return : ", end="")
        cerminYP2Return.cetakTitik()

        print("\n=== JARAK ===")

        print("Void   : ", end="")
        P1.jarakVoid(P1, P2)

        jarakReturn = P1.jarakReturn(P1, P2)
        print("Return : ", jarakReturn)


def menu():
    titikA = Koordinat()
    titikB = Koordinat()
    titikT = Koordinat()

    pilihan = 0

    while pilihan != 4:
        print("\n==============================")
        print("       MENU KOORDINAT")
        print("==============================")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Koordinat")
        print("4. Keluar")

        pilihan = int(input("Pilih menu : "))

        if pilihan == 1:
            print("\n=== CONSTRUCTOR BERPAMETER ===")

            titikA = Koordinat(1, 2)
            titikB = Koordinat(5, 4)

            titikT.cetak(titikA, titikB)

        elif pilihan == 2:
            print("\n=== SETTER ===")

            titikA.setKoordinat(5, 1)
            titikB.setKoordinat(9, 3)

            titikT.cetak(titikA, titikB)

        elif pilihan == 3:
            print("\n=== INPUT KOORDINAT ===")

            print("\nMasukkan data Titik A")
            titikA.inputKoordinat()

            print("\nMasukkan data Titik B")
            titikB.inputKoordinat()

            titikT.cetak(titikA, titikB)

        elif pilihan == 4:
            print("\nProgram selesai.")

        else:
            print("\nPilihan tidak tersedia!")


def main():
    menu()


if __name__ == "__main__":
    main()