"""
Nama Program : Program Koordinat
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 24 September 2026
Deskripsi    : Membuat program mencari titik tengah dengan passing object
"""
class Koordinat:
    def __init__(self, absis=0, ordinat=0):
        self.absis = absis
        self.ordinat = ordinat

    def setKoordinat(self, absis, ordinat):
        self.absis = absis
        self.ordinat = ordinat

    def setAbsis(self, absis):
        self.absis = absis

    def setOrdinat(self, ordinat):
        self.ordinat = ordinat

    def getAbsis(self):
        return self.absis

    def getOrdinat(self):
        return self.ordinat

    def inputKoordinat(self):
        self.absis = float(input("Masukkan absis: "))
        self.ordinat = float(input("Masukkan ordinat: "))

    def printKoordinat(self):
        print("Nilai Absis   =", self.absis)
        print("Nilai Ordinat =", self.ordinat)

    def titikTengahVoid(self, P1, P2):
        self.absis = (P1.absis + P2.absis) / 2
        self.ordinat = (P1.ordinat + P2.ordinat) / 2

    def titikTengahReturn(self, P):
        hasil = Koordinat()
        hasil.absis = (P.absis + self.absis) / 2
        hasil.ordinat = (P.ordinat + self.ordinat) / 2
        return hasil


def menu():
    titikA = Koordinat(2, 1)
    titikB = Koordinat(6, 3)
    titikT = Koordinat()

    pilihan = 0

    while pilihan != 4:
        print("\n===== MENU PASSING KOORDINAT =====")
        print("1. Titik A dipanggil ke Titik B")
        print("2. Titik B dipanggil ke Titik A")
        print("3. Titik A dan B dipanggil ke Titik T")
        print("4. Keluar")

        pilihan = int(input("Pilih menu: "))

        if pilihan == 1:
            print("\nTitik A")
            titikA.printKoordinat()

            print("\nTitik B")
            titikB.printKoordinat()

            print("\nTitik A dipanggil ke Titik B")
            titikT = titikB.titikTengahReturn(titikA)

            print("\nTitik T")
            titikT.printKoordinat()

        elif pilihan == 2:
            print("\nTitik A")
            titikA.printKoordinat()

            print("\nTitik B")
            titikB.printKoordinat()

            print("\nTitik B dipanggil ke Titik A")
            titikT = titikA.titikTengahReturn(titikB)

            print("\nTitik T")
            titikT.printKoordinat()

        elif pilihan == 3:
            print("\nTitik A")
            titikA.printKoordinat()

            print("\nTitik B")
            titikB.printKoordinat()

            print("\nTitik A dan Titik B dipanggil ke Titik T")
            titikT.titikTengahVoid(titikA, titikB)

            print("\nTitik T")
            titikT.printKoordinat()

        elif pilihan == 4:
            print("Program selesai.")

        else:
            print("Menu tidak tersedia!")


def main():
    menu()


if __name__ == "__main__":
    main()