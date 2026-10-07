"""
Nama Program : Program Koordinat kartesian OOP
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 06 Oktober 2026
Deskripsi    : Buat program OOP koordinat kartesian
                ◼ Atribut : absis dan ordinat
                ◼ Constructor, input (dalam & luar), output (dalam & luar)
               Method Proses yang diinginkan dengan cara 1 (fungsi return) dan cara 2 (void):
                ◼ Mencari titik tengah
                ◼ nilai pencerminan terhadap sumbu X
                ◼ nilai pencerminan terhadap sumbu Y
                ◼ Jarak antara 2 titik
                Class Menu dipisah
"""

class Koordinat:
    def __init__(self, absis=0, ordinat=0):
        self.__absis = absis
        self.__ordinat = ordinat

    def getAbsis(self):
        return self.__absis

    def getOrdinat(self):
        return self.__ordinat

    def setAbsis(self, absis):
        self.__absis = absis

    def setOrdinat(self, ordinat):
        self.__ordinat = ordinat

    def setKoordinat(self, pAbsis, pOrdinat):
        self.__absis = pAbsis
        self.__ordinat = pOrdinat

    def inputKoordinat(self):
        self.__absis = float(input("Masukkan absis: "))
        self.__ordinat = float(input("Masukkan ordinat: "))

    def cetakTitik(self):
        print("(" + str(self.__absis) + ", " + str(self.__ordinat) + ")")

    def titikTengahVoid(self, p1, p2):
        self.__absis = (p1.__absis + p2.__absis) / 2
        self.__ordinat = (p1.__ordinat + p2.__ordinat) / 2

    def titikTengahReturn(self, p):
        hasil = Koordinat()

        hasil.__absis = (p.__absis + self.__absis) / 2
        hasil.__ordinat = (p.__ordinat + self.__ordinat) / 2

        return hasil

    def cerminSumbuXVoid(self, p):
        self.__absis = p.__absis
        self.__ordinat = p.__ordinat * (-1)

    def cerminSumbuXReturn(self, p):
        hasil = Koordinat()

        hasil.__absis = p.__absis
        hasil.__ordinat = p.__ordinat * (-1)

        return hasil

    def cerminSumbuYVoid(self, p):
        self.__absis = p.__absis * (-1)
        self.__ordinat = p.__ordinat

    def cerminSumbuYReturn(self, p):
        hasil = Koordinat()

        hasil.__absis = p.__absis * (-1)
        hasil.__ordinat = p.__ordinat

        return hasil

    def jarakVoid(self, p1, p2):
        import math

        jarak = math.sqrt(
            (p2.__absis - p1.__absis) ** 2 +
            (p2.__ordinat - p1.__ordinat) ** 2
        )

        print(jarak)

    def jarakReturn(self, p1, p2):
        import math

        return math.sqrt(
            (p2.__absis - p1.__absis) ** 2 +
            (p2.__ordinat - p1.__ordinat) ** 2
        )


class Menu:
    def __init__(self):
        self.__pilihan = 0

    def inputKoordinatLuar(self, titik):
        absis = float(input("Masukkan absis: "))
        ordinat = float(input("Masukkan ordinat: "))

        titik.setKoordinat(absis, ordinat)

    def cetakLuar(self, titik, label):
        print(label + " = ", end="")
        titik.cetakTitik()

    def cetakSemua(self, titikA, titikB):
        print("\n==================================")
        print("          HASIL KOORDINAT")
        print("==================================")

        print("\n=== DATA TITIK ===")
        self.cetakLuar(titikA, "Titik A")
        self.cetakLuar(titikB, "Titik B")

        titikTengahReturn = titikA.titikTengahReturn(titikB)

        titikTengahVoid = Koordinat()
        titikTengahVoid.titikTengahVoid(titikA, titikB)

        print("\n=== TITIK TENGAH ===")
        self.cetakLuar(titikTengahReturn, "Return")
        self.cetakLuar(titikTengahVoid, "Void")

        cerminXP1Return = titikA.cerminSumbuXReturn(titikA)

        cerminXP1Void = Koordinat()
        cerminXP1Void.cerminSumbuXVoid(titikA)

        print("\n=== CERMIN TITIK A TERHADAP SUMBU X ===")
        self.cetakLuar(cerminXP1Return, "Return")
        self.cetakLuar(cerminXP1Void, "Void")

        cerminXP2Return = titikB.cerminSumbuXReturn(titikB)

        cerminXP2Void = Koordinat()
        cerminXP2Void.cerminSumbuXVoid(titikB)

        print("\n=== CERMIN TITIK B TERHADAP SUMBU X ===")
        self.cetakLuar(cerminXP2Return, "Return")
        self.cetakLuar(cerminXP2Void, "Void")

        cerminYP1Return = titikA.cerminSumbuYReturn(titikA)

        cerminYP1Void = Koordinat()
        cerminYP1Void.cerminSumbuYVoid(titikA)

        print("\n=== CERMIN TITIK A TERHADAP SUMBU Y ===")
        self.cetakLuar(cerminYP1Return, "Return")
        self.cetakLuar(cerminYP1Void, "Void")

        cerminYP2Return = titikB.cerminSumbuYReturn(titikB)

        cerminYP2Void = Koordinat()
        cerminYP2Void.cerminSumbuYVoid(titikB)

        print("\n=== CERMIN TITIK B TERHADAP SUMBU Y ===")
        self.cetakLuar(cerminYP2Return, "Return")
        self.cetakLuar(cerminYP2Void, "Void")

        print("\n=== JARAK ANTARA TITIK A DAN B ===")

        jarakReturn = titikA.jarakReturn(titikA, titikB)
        print("Return :", jarakReturn)

        print("Void   :", end=" ")
        titikA.jarakVoid(titikA, titikB)

    def tampilkanMenu(self):
        print("\n==============================")
        print("       MENU KOORDINAT")
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

    def getPilihan(self):
        return self.__pilihan

    def constructor(self):
        print("\n=== CONSTRUCTOR BERPAMETER ===")

        titikA = Koordinat(1, 2)
        titikB = Koordinat(5, 4)

        self.cetakSemua(titikA, titikB)

    def setter(self):
        print("\n=== SETTER ===")

        titikA = Koordinat()
        titikB = Koordinat()

        titikA.setAbsis(5)
        titikA.setOrdinat(1)

        titikB.setKoordinat(9, 3)

        self.cetakSemua(titikA, titikB)

    def inputDalam(self):
        print("\n=== INPUT KOORDINAT DALAM ===")

        titikA = Koordinat()
        titikB = Koordinat()

        print("\nInput untuk Titik A:")
        titikA.inputKoordinat()

        print("\nInput untuk Titik B:")
        titikB.inputKoordinat()

        self.cetakSemua(titikA, titikB)

    def inputLuar(self):
        print("\n=== INPUT KOORDINAT LUAR ===")

        titikA = Koordinat()
        titikB = Koordinat()

        print("\nInput untuk Titik A:")
        self.inputKoordinatLuar(titikA)

        print("\nInput untuk Titik B:")
        self.inputKoordinatLuar(titikB)

        self.cetakSemua(titikA, titikB)


def main():
    menu = Menu()

    while menu.getPilihan() != 5:
        menu.tampilkanMenu()
        menu.prosesMenu()


if __name__ == "__main__":
    main()