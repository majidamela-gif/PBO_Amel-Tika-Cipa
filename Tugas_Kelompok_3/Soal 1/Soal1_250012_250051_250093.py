"""
Nama Program : Program Nilai (Array 1 dimensi)
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 13 Oktober 2026
Deskripsi    : Buat program OOP untuk mencari nilai rata-rata, nilai tertinggi, nilai terendah dan sorting
                dari kumpulan data bertipe array of integer.
"""

class MyNilai:
    def __init__(self, ukuran=0, nilai=None):
        self.__ukuran = ukuran
        if nilai is None:
            self.__nilai = [0] * ukuran
        else:
            self.__nilai = nilai.copy()

    def getUkuran(self):
        return self.__ukuran

    def setUkuran(self, ukuran):
        self.__ukuran = ukuran
        self.__nilai = [0] * ukuran

    def setNilai(self, i, nilai):
        self.__nilai[i] = nilai

    def inputUkuran(self):
        ukuran = int(input("Masukkan ukuran Larik: "))
        while ukuran <= 0:
            print("Ukuran harus lebih dari 0!")
            ukuran = int(input("Masukkan ukuran Larik: "))
        return ukuran

    def isiNilai(self):
        for i in range(self.__ukuran):
            self.__nilai[i] = int(
                input(f"Masukkan nilai ke-{i + 1} = ")
            )

    def cariRata(self):
        jumlah = 0
        for i in range(self.__ukuran):
            jumlah += self.__nilai[i]
        return jumlah / self.__ukuran

    def cariRataVoid(self, A):
        self.setUkuran(A.getUkuran())
        for i in range(A.getUkuran()):
            self.__nilai[i] = A.__nilai[i]

        jumlah = 0
        for i in range(self.__ukuran):
            jumlah += self.__nilai[i]
        rata = jumlah / self.__ukuran
        print("Rata-rata (Void) =", rata)

    def nilaiMax(self):
        tertinggi = self.__nilai[0]
        for i in range(self.__ukuran):
            if self.__nilai[i] > tertinggi:
                tertinggi = self.__nilai[i]
        return tertinggi

    def nilaiMaxVoid(self, A):
        self.setUkuran(A.getUkuran())
        for i in range(A.getUkuran()):
            self.__nilai[i] = A.__nilai[i]

        tertinggi = self.__nilai[0]
        for i in range(self.__ukuran):
            if self.__nilai[i] > tertinggi:
                tertinggi = self.__nilai[i]
        print("Nilai Tertinggi (Void) =", tertinggi)

    def nilaiMin(self):
        terendah = self.__nilai[0]
        for i in range(self.__ukuran):
            if self.__nilai[i] < terendah:
                terendah = self.__nilai[i]
        return terendah

    def nilaiMinVoid(self, A):
        self.setUkuran(A.getUkuran())
        for i in range(A.getUkuran()):
            self.__nilai[i] = A.__nilai[i]

        terendah = self.__nilai[0]
        for i in range(self.__ukuran):
            if self.__nilai[i] < terendah:
                terendah = self.__nilai[i]
        print("Nilai Terendah (Void) =", terendah)

    def sortingAsc(self):
        hasil = MyNilai(self.getUkuran(), self.__nilai)

        for i in range(hasil.__ukuran - 1):
            for j in range(hasil.__ukuran - 1 - i):
                if hasil.__nilai[j] > hasil.__nilai[j + 1]:
                    temp = hasil.__nilai[j]
                    hasil.__nilai[j] = hasil.__nilai[j + 1]
                    hasil.__nilai[j + 1] = temp

        return hasil

    def sortingAscVoid(self, A):
        self.setUkuran(A.getUkuran())
        for i in range(A.getUkuran()):
            self.__nilai[i] = A.__nilai[i]

        for i in range(self.__ukuran - 1):
            for j in range(self.__ukuran - 1 - i):
                if self.__nilai[j] > self.__nilai[j + 1]:
                    temp = self.__nilai[j]
                    self.__nilai[j] = self.__nilai[j + 1]
                    self.__nilai[j + 1] = temp

    def sortingDesc(self):
        hasil = MyNilai(self.getUkuran(), self.__nilai)
        for i in range(hasil.__ukuran - 1):
            for j in range(hasil.__ukuran - 1 - i):
                if hasil.__nilai[j] < hasil.__nilai[j + 1]:
                    temp = hasil.__nilai[j]
                    hasil.__nilai[j] = hasil.__nilai[j + 1]
                    hasil.__nilai[j + 1] = temp
    
        return hasil
    
    def sortingDescVoid(self, A):
        self.setUkuran(A.getUkuran())
        for i in range(A.getUkuran()):
            self.__nilai[i] = A.__nilai[i]
    
        for i in range(self.__ukuran - 1):
            for j in range(self.__ukuran - 1 - i):
                if self.__nilai[j] < self.__nilai[j + 1]:
                    temp = self.__nilai[j]
                    self.__nilai[j] = self.__nilai[j + 1]
                    self.__nilai[j + 1] = temp

    def cetakNilai(self):
        print("Nilai: ", self.__nilai)

    def cetakHasil(self):
        print("\n=== HASIL FUNGSI (RETURN) ===")
        print("Rata-rata =", self.cariRata())
        print("Nilai Tertinggi =", self.nilaiMax())
        print("Nilai Terendah =", self.nilaiMin())

        print("\n=== HASIL VOID ===")
        hasilVoid = MyNilai()
        hasilVoid.cariRataVoid(self)
        hasilVoid.nilaiMaxVoid(self)
        hasilVoid.nilaiMinVoid(self)


class Menu:
    def __init__(self):
        self.pilihan = 0

    def inputUkuran(self):
        ukuran = int(input("Masukkan ukuran Larik: "))
        while ukuran <= 0:
            print("Ukuran harus lebih dari 0!")
            ukuran = int(input("Masukkan ukuran Larik: "))
        return ukuran

    def tampilkanMenu(self):
        print("\n==============================")
        print("       MENU PROGRAM NILAI")
        print("==============================")
        print("1. Constructor Berparameter")
        print("2. Setter")
        print("3. Input Dalam")
        print("4. Input Luar")
        print("5. Keluar")
        print("==============================")
        self.pilihan = int(input("Pilih menu: "))

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
            print("\nProgram selesai.")
        else:
            print("\nPilihan tidak tersedia!")

    def inputLarikLuar(self, A):
        for i in range(A.getUkuran()):
            nilai = int(
                input(f"Masukkan nilai ke-{i + 1} = ")
            )
            A.setNilai(i, nilai)

    def cetakLuar(self, A, label):
        print(label)
        A.cetakNilai()

    def cetakSemua(self, A):
        print("\n==============================")
        print("       HASIL PROGRAM NILAI")
        print("==============================")

        self.cetakLuar(A, "\nData Larik A:")
        A.cetakHasil()

        hasilReturn = A.sortingAsc()
        hasilVoid = MyNilai()
        hasilVoid.sortingAscVoid(A)
        print("\n=== SORTING RETURN (ASCENDING) ===")
        hasilReturn.cetakNilai()
        print("\n=== SORTING VOID (ASCENDING) ===")
        hasilVoid.cetakNilai()

        hasilReturn = A.sortingDesc()
        hasilVoid = MyNilai()
        hasilVoid.sortingDescVoid(A)
        print("\n=== SORTING RETURN (DESCENDING) ===")
        hasilReturn.cetakNilai()
        print("\n=== SORTING VOID (DESCENDING) ===")
        hasilVoid.cetakNilai()

    def constructor(self):
        print("\n=== CONSTRUCTOR BERPAMETER ===")
        A = MyNilai(5, [80, 60, 90, 70, 100])
        self.cetakSemua(A)

    def setter(self):
        print("\n=== SETTER ===")
        A = MyNilai()
        A.setUkuran(5)
        A.setNilai(0, 75)
        A.setNilai(1, 85)
        A.setNilai(2, 65)
        A.setNilai(3, 95)
        A.setNilai(4, 80)
        self.cetakSemua(A)

    def inputDalam(self):
        print("\n=== INPUT DALAM ===")
        A = MyNilai()
        ukuran = A.inputUkuran()
        A.setUkuran(ukuran)
        A.isiNilai()
        self.cetakSemua(A)

    def inputLuar(self):
        print("\n=== INPUT LUAR ===")
        ukuran = self.inputUkuran()
        A = MyNilai(ukuran)
        self.inputLarikLuar(A)
        self.cetakSemua(A)


class Main:
    @staticmethod
    def main():
        menu = Menu()

        while True:
            menu.tampilkanMenu()
            menu.prosesMenu()
            if menu.getPilihan() == 5:
                break

if __name__ == "__main__":
    Main.main()