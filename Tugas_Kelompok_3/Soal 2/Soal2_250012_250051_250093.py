"""
Nama Program : Program Penjumlahan dan Perkalian 2 Matriks
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 14 Oktober 2026
Deskripsi    : Program OOP untuk mencari penjumlahan dan perkalian 2 buah matriks
               Prosesnya berbentuk fungsi dan berbentuk void (passing object)
"""

class Matriks:
    def __init__(self, baris=0, kolom=0):
        self.__baris = baris
        self.__kolom = kolom
        self.__nilai = [[0 for _ in range(10)] for _ in range(10)]

    def getBaris(self):
        return self.__baris

    def setBaris(self, baris):
        self.__baris = baris

    def getKolom(self):
        return self.__kolom

    def setKolom(self, kolom):
        self.__kolom = kolom

    def setNilai(self, i, j, nilai):
        self.__nilai[i][j] = nilai

    def inputMatriks(self):
        for i in range(self.__baris):
            for j in range(self.__kolom):
                self.__nilai[i][j] = int(input(f"Nilai [{i + 1}][{j + 1}] = "))

    def cetakMatriks(self):
        for i in range(self.__baris):
            for j in range(self.__kolom):
                print(self.__nilai[i][j], end="\t")
            print()

    def addMatriksVoid(self, A, B):
        self.__baris = A.__baris
        self.__kolom = A.__kolom
        for i in range(self.__baris):
            for j in range(self.__kolom):
                self.__nilai[i][j] = A.__nilai[i][j] + B.__nilai[i][j]

    def addMatriksReturn(self, B):
        hasil = Matriks(self.__baris, self.__kolom)
        for i in range(self.__baris):
            for j in range(self.__kolom):
                hasil.__nilai[i][j] = self.__nilai[i][j] + B.__nilai[i][j]
        return hasil

    def kaliMatriksVoid(self, A, B):
        self.__baris = A.__baris
        self.__kolom = B.__kolom
        for i in range(self.__baris):
            for j in range(self.__kolom):
                self.__nilai[i][j] = 0
                for k in range(A.__kolom):
                    self.__nilai[i][j] += A.__nilai[i][k] * B.__nilai[k][j]

    def kaliMatriksReturn(self, B):
        hasil = Matriks(self.__baris, B.__kolom)
        for i in range(self.__baris):
            for j in range(B.__kolom):
                hasil.__nilai[i][j] = 0
                for k in range(self.__kolom):
                    hasil.__nilai[i][j] += self.__nilai[i][k] * B.__nilai[k][j]
        return hasil


class Menu:
    def __init__(self):
        self.pilihan = 0

    def tampilkanMenu(self):
        print("\n==============================")
        print("         MENU MATRIKS")
        print("==============================")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Dalam")
        print("4. Input Luar")
        print("5. Keluar")
        self.pilihan = int(input("Pilih menu : "))

    def getPilihan(self):
        return self.pilihan

    def prosesMenu(self):
        if self.pilihan == 1:
            self.constructor()
        elif self.pilihan == 2:
            self.setter()
        elif self.pilihan == 3:
            self.inputDalam()
        elif self.pilihan == 4:
            self.inputLuar()
        elif self.pilihan == 5:
            print("\nProgram Selesai.")
        else:
            print("\nPilihan tidak tersedia!")

    def cetakLuar(self, matriks, label):
        print(label)
        matriks.cetakMatriks()

    def cetakSemua(self, A, B):
        print("\n==================================")
        print("          HASIL MATRIKS")
        print("==================================")
        print("=== DATA MATRIKS ===")
        self.cetakLuar(A, "Matriks A :")
        print()
        self.cetakLuar(B, "Matriks B :")

        if A.getBaris() == B.getBaris() and A.getKolom() == B.getKolom():
            hasilTambahReturn = A.addMatriksReturn(B)
            hasilTambahVoid = Matriks()
            hasilTambahVoid.addMatriksVoid(A, B)

            print("\n=== PENJUMLAHAN A + B ===")
            print("Return :")
            hasilTambahReturn.cetakMatriks()
            print("\nVoid :")
            hasilTambahVoid.cetakMatriks()
        else:
            print("\n=== PENJUMLAHAN A + B ===")
            print("Matriks A dan B tidak dapat dijumlahkan.")
            print("Ukuran matriks harus sama.")

        if A.getKolom() == B.getBaris():
            hasilKaliReturn = A.kaliMatriksReturn(B)
            hasilKaliVoid = Matriks()
            hasilKaliVoid.kaliMatriksVoid(A, B)

            print("\n=== PERKALIAN A x B ===")
            print("Return :")
            hasilKaliReturn.cetakMatriks()
            print("\nVoid :")
            hasilKaliVoid.cetakMatriks()
        else:
            print("\n=== PERKALIAN A x B ===")
            print("Matriks A dan B tidak dapat dikalikan.")
            print("Kolom A harus sama dengan baris B.")

    def constructor(self):
        print("\n=== CONSTRUCTOR BERPAMETER ===")
        A = Matriks(3, 3)
        B = Matriks(3, 3)

        A.setNilai(0, 0, 1)
        A.setNilai(0, 1, 2)
        A.setNilai(0, 2, 3)
        A.setNilai(1, 0, 4)
        A.setNilai(1, 1, 5)
        A.setNilai(1, 2, 6)
        A.setNilai(2, 0, 7)
        A.setNilai(2, 1, 8)
        A.setNilai(2, 2, 9)

        B.setNilai(0, 0, -2)
        B.setNilai(0, 1, 0)
        B.setNilai(0, 2, 5)
        B.setNilai(1, 0, 6)
        B.setNilai(1, 1, 1)
        B.setNilai(1, 2, 3)
        B.setNilai(2, 0, 3)
        B.setNilai(2, 1, 2)
        B.setNilai(2, 2, -8)

        self.cetakSemua(A, B)

    def setter(self):
        print("\n=== SETTER ===")
        A = Matriks()
        B = Matriks()
        A.setBaris(2)
        A.setKolom(2)
        B.setBaris(2)
        B.setKolom(2)

        print("\nMatriks A")
        A.setNilai(0, 0, 1)
        A.setNilai(0, 1, 2)
        A.setNilai(1, 0, 3)
        A.setNilai(1, 1, 4)

        print("\nMatriks B")
        B.setNilai(0, 0, 5)
        B.setNilai(0, 1, 6)
        B.setNilai(1, 0, 7)
        B.setNilai(1, 1, 8)
        self.cetakSemua(A, B)

    def inputDalam(self):
        print("\n=== INPUT MATRIKS DALAM ===")
        print("Ukuran Matriks A")
        barisA = int(input("Masukkan jumlah baris : "))
        kolomA = int(input("Masukkan jumlah kolom : "))
        A = Matriks(barisA, kolomA)

        print("\nMatriks A")
        A.inputMatriks()

        print("\nUkuran Matriks B")
        barisB = int(input("Masukkan jumlah baris : "))
        kolomB = int(input("Masukkan jumlah kolom : "))
        B = Matriks(barisB, kolomB)

        print("\nMatriks B")
        B.inputMatriks()
        self.cetakSemua(A, B)

    def inputMatriksLuar(self, M):
        for i in range(M.getBaris()):
            for j in range(M.getKolom()):
                nilai = int(input(f"Nilai [{i + 1}][{j + 1}] = "))
                M.setNilai(i, j, nilai)

    def inputLuar(self):
        print("\n=== INPUT MATRIKS LUAR ===")
        print("Ukuran Matriks A")
        barisA = int(input("Masukkan jumlah baris : "))
        kolomA = int(input("Masukkan jumlah kolom : "))
        A = Matriks(barisA, kolomA)

        print("\nMatriks A")
        self.inputMatriksLuar(A)

        print("\nUkuran Matriks B")
        barisB = int(input("Masukkan jumlah baris : "))
        kolomB = int(input("Masukkan jumlah kolom : "))
        B = Matriks(barisB, kolomB)

        print("\nMatriks B")
        self.inputMatriksLuar(B)
        self.cetakSemua(A, B)


def main():
    menu = Menu()
    while True:
        menu.tampilkanMenu()
        menu.prosesMenu()
        if menu.getPilihan() == 5:
            break


if __name__ == "__main__":
    main()