"""
Nama Program : Program Gaji OOP dengan tambahan parkir
Anggota      : - Amela Dzakiah Majid (140810250051)
               - Atika Shafira (140810250093)
               - Syifa Dwi Amirah (140810250012)
Tanggal Buat : 09 November 2026
Deskripsi    : Buatlah program OOP Array of Object dengan menambahkan class person (minimal ada nama, Alamat, dll) yang melakukan inheritance dengan class pegawai untuk mencari gaji harian dan lembur
               berdasarkan lama kerja pegawai dgn aturan sbb:
                • Input : NIP, nama, Alamat, gol, waktu datang, waktu pulang
                • Aturan gaji lembur : >= 8 jam (minimal kelebihan 1 jam / pembulatan ke bawah)
                    Gol gaji harian lembur >= 8 jam kerja
                    1 150 rb 50.000 /jam
                    2 200 rb 75.000 /jam
                    3 400 rb 150.000 /jam
                    4 500 rb 200.000 /jam
                • Proses : gaji Harian = gapok + lembur
                • Untuk pegawai yg kurang dari 8 jam diberi status peringatan
                • Output : NIP, nama, gol, datang, pulang, lama kerja, jam lembur, gaji Harian, statusPeringatan
                  Tabel
                  Rata-rata Gaji : ---
                  Gaji Tertinggi :
                  Gaji Terendah :
               Buat 5 class (Waktu, Person, Pegawai, Array of Pegawai dan Menu) yang masing masing memiliki constructor, method input-proses-output ) selain class Utama
               Buat program parkir kendaraan berdasarkan kendaraan --> mobil, truk dan motor ( inheritance dan polimorfisma)
               Biaya parkir :
                untuk umum (person atau tanpa identitas) : 3000, 5000 dan 2000 perjam
                untuk pegawai : 6000, dan 3000 per hari (<=24 jam) --> hanya mobil dan motor. Truk sesuai umum
               Parkir kendaraan juga berbentuk array (buatkan tabel laporannya)
               Lakukan improvisasi. Tuliskan spek dan aturan terbaik yang lain berdasarkan spek dasar ini.
"""

class Waktu:

  def __init__(self, jam=0, menit=0, detik=0):
    self._jam = 0
    self._menit = 0
    self._detik = 0
    self.set_waktu(jam, menit, detik)

  def get_jam(self):
    return self._jam

  def get_menit(self):
    return self._menit

  def get_detik(self):
    return self._detik

  def set_jam(self, jam):
    if 0 <= jam < 24:
      self._jam = jam
    else:
      self._jam = 0
      print("Jam harus 0-23.")

  def set_menit(self, menit):
    if 0 <= menit < 60:
      self._menit = menit
    else:
      self._menit = 0
      print("Menit harus 0-59.")

  def set_detik(self, detik):
    if 0 <= detik < 60:
      self._detik = detik
    else:
      self._detik = 0
      print("Detik harus 0-59.")

  def set_waktu(self, jam, menit, detik):
    self.set_jam(jam)
    self.set_menit(menit)
    self.set_detik(detik)

  def input_waktu(self):
    while True:
      try:
        jam = int(input("Masukkan Jam (0-23): "))
        if 0 <= jam < 24:
          break
        print("Jam harus 0-23.")
      except ValueError:
        print("Masukkan angka yang valid.")

    while True:
      try:
        menit = int(input("Masukkan Menit (0-59): "))
        if 0 <= menit < 60:
          break
        print("Menit harus 0-59.")
      except ValueError:
        print("Masukkan angka yang valid.")

    while True:
      try:
        detik = int(input("Masukkan Detik (0-59): "))
        if 0 <= detik < 60:
          break
        print("Detik harus 0-59.")
      except ValueError:
        print("Masukkan angka yang valid.")

    self.set_waktu(jam, menit, detik)

  def konvert_detik(self):
    return self._jam * 3600 + self._menit * 60 + self._detik


class Person:

  def __init__(self, nama="", alamat=""):
    self._nama = nama
    self._alamat = alamat

  def get_nama(self):
    return self._nama

  def get_alamat(self):
    return self._alamat

  def set_nama(self, nama):
    self._nama = nama

  def set_alamat(self, alamat):
    self._alamat = alamat

  def set_person(self, nama, alamat):
    self._nama = nama
    self._alamat = alamat

  def input_person(self):
    self._nama = input("Masukkan nama: ")
    self._alamat = input("Masukkan alamat: ")

  def cetak_person(self):
    print(f"Nama   : {self._nama}")
    print(f"Alamat : {self._alamat}")


class Pegawai(Person):

  def __init__(self, nama="", nip="", gol=0, alamat=""):
    super().__init__(nama, alamat)
    self._nip = nip
    self._gol = gol

  def get_nip(self):
    return self._nip

  def get_gol(self):
    return self._gol

  def set_nip(self, nip):
    self._nip = nip

  def set_gol(self, gol):
    self._gol = gol

  def set_pegawai(self, nama, nip, gol, alamat=""):
    self.set_person(nama, alamat)
    self._nip = nip
    self._gol = gol

  def input_pegawai(self):
    self._nip = input("Masukkan NIP pegawai: ")
    self._nama = input("Masukkan nama pegawai: ")
    self._alamat = input("Masukkan alamat pegawai: ")

    while True:
      try:
        self._gol = int(input("Masukkan golongan: "))
        if 1 <= self._gol <= 4:
          break
        print(
            "Golongan tidak valid.\nSilahkan pilih golongan dengan rentang"
            " 1-4!\n"
        )
      except ValueError:
        print("Masukkan angka yang valid.")

  def hitung_gaji_harian(self):
    if self._gol == 1:
      return 150000
    elif self._gol == 2:
      return 200000
    elif self._gol == 3:
      return 400000
    elif self._gol == 4:
      return 500000
    return 0

  def hitung_lembur(self):
    if self._gol == 1:
      return 50000
    elif self._gol == 2:
      return 75000
    elif self._gol == 3:
      return 150000
    elif self._gol == 4:
      return 200000
    return 0

  def hitung_lama_kerja(self, datang, pulang):
    total_datang = datang.konvert_detik()
    total_pulang = pulang.konvert_detik()
    if total_pulang < total_datang:
      total_pulang += 24 * 3600

    selisih = total_pulang - total_datang
    return Waktu(selisih // 3600, (selisih % 3600) // 60, selisih % 60)

  def hitung_jam_lembur(self, datang, pulang):
    lama = self.hitung_lama_kerja(datang, pulang)
    total_detik = lama.konvert_detik()
    if total_detik < 9 * 3600:
      return 0
    detik_lembur = total_detik - 8 * 3600
    return detik_lembur // 3600

  def hitung_gaji_lembur(self, datang, pulang):
    return self.hitung_jam_lembur(datang, pulang) * self.hitung_lembur()

  def hitung_gaji_total(self, datang, pulang):
    return self.hitung_gaji_harian() + self.hitung_gaji_lembur(datang, pulang)

  def hitung_status(self, datang, pulang):
    lama = self.hitung_lama_kerja(datang, pulang)
    if lama.konvert_detik() < 8 * 3600:
      return "peringatan"
    return "ok"

  def format_ribuan(self, angka):
    return f"{angka:,}".replace(",", ".")

  def format_waktu(self, waktu):
    return (
        f"{waktu.get_jam():02d}:{waktu.get_menit():02d}:"
        f"{waktu.get_detik():02d}"
    )

  def cetak_pegawai(self, datang, pulang, no):
    lama_kerja = self.hitung_lama_kerja(datang, pulang)
    print(
        f"{no:<4}"
        f"{self._nip:<10}"
        f"{self._nama:<14}"
        f"{self._alamat:<20}"
        f"{self._gol:<5}"
        f"{self.format_waktu(datang):<10}"
        f"{self.format_waktu(pulang):<10}"
        f"{self.format_waktu(lama_kerja):<10}"
        f"{self.hitung_jam_lembur(datang, pulang):<12}"
        f"{self.format_ribuan(self.hitung_gaji_harian()):<15}"
        f"{self.format_ribuan(self.hitung_gaji_lembur(datang, pulang)):<12}"
        f"{self.format_ribuan(self.hitung_gaji_total(datang, pulang)):<15}"
        f"{self.hitung_status(datang, pulang):<12}"
    )


class ArrayPegawai:

  def __init__(self):
    self._data = []
    self._waktu_datang = []
    self._waktu_pulang = []

  def get_jumlah(self):
    return len(self._data)

  def get_pegawai(self, index):
    return self._data[index]

  def get_waktu_datang(self, index):
    return self._waktu_datang[index]

  def get_waktu_pulang(self, index):
    return self._waktu_pulang[index]

  def tambah_pegawai(self, pegawai, datang, pulang):
    if len(self._data) < 10:
      self._data.append(pegawai)
      self._waktu_datang.append(datang)
      self._waktu_pulang.append(pulang)
    else:
      print("Array pegawai sudah penuh!")

  def hitung_gaji_pada_index(self, index):
    return self._data[index].hitung_gaji_total(
        self._waktu_datang[index], self._waktu_pulang[index]
    )

  def tukar_data(self, i, j, target):
    (
        target._data[i],
        target._data[j],
    ) = (
        target._data[j],
        target._data[i],
    )
    (
        target._waktu_datang[i],
        target._waktu_datang[j],
    ) = (
        target._waktu_datang[j],
        target._waktu_datang[i],
    )
    (
        target._waktu_pulang[i],
        target._waktu_pulang[j],
    ) = (
        target._waktu_pulang[j],
        target._waktu_pulang[i],
    )

  def sorting_ascending(self):
    hasil = ArrayPegawai()
    hasil._data = list(self._data)
    hasil._waktu_datang = list(self._waktu_datang)
    hasil._waktu_pulang = list(self._waktu_pulang)

    n = hasil.get_jumlah()
    for i in range(n - 1):
      for j in range(n - i - 1):
        if hasil.hitung_gaji_pada_index(j) > hasil.hitung_gaji_pada_index(j + 1):
          self.tukar_data(j, j + 1, hasil)
    return hasil

  def sorting_descending(self):
    hasil = ArrayPegawai()
    hasil._data = list(self._data)
    hasil._waktu_datang = list(self._waktu_datang)
    hasil._waktu_pulang = list(self._waktu_pulang)

    n = hasil.get_jumlah()
    for i in range(n - 1):
      for j in range(n - i - 1):
        if hasil.hitung_gaji_pada_index(j) < hasil.hitung_gaji_pada_index(j + 1):
          self.tukar_data(j, j + 1, hasil)
    return hasil


class Orang:

  def __init__(self, nama=""):
    self._nama = nama

  def get_nama(self):
    return self._nama

  def set_nama(self, nama):
    self._nama = nama


class Kendaraan:
  def __init__(
      self,
      nomor="",
      nama="",
      nip="",
      status="Umum",
      masuk=None,
      keluar=None,
  ):
    self._nomor_polisi = nomor
    self._nip = nip
    self._status = status
    self._pemilik = Orang(nama)
    self._waktu_masuk = masuk if masuk else Waktu()
    self._waktu_keluar = keluar if keluar else Waktu()

  def get_nomor_polisi(self):
    return self._nomor_polisi

  def get_status(self):
    return self._status

  def hitung_lama_detik(self):
    awal = self._waktu_masuk.konvert_detik()
    akhir = self._waktu_keluar.konvert_detik()
    if akhir < awal:
      akhir += 24 * 3600
    return akhir - awal

  def set_kendaraan(self, nomor, nama, nip, status, masuk, keluar):
    self._nomor_polisi = nomor
    self._pemilik.set_nama(nama)
    self._nip = nip
    self._status = status
    self._waktu_masuk = masuk
    self._waktu_keluar = keluar

  def input_data_dasar(self):
    self._nomor_polisi = input("Nomor polisi: ")
    while True:
      try:
        pengguna = int(input("Jenis pengguna (1. Umum  2. Pegawai): "))
        if 1 <= pengguna <= 2:
          break
        print("Pilihan tidak valid!")
      except ValueError:
        print("Masukkan angka yang valid.")

    if pengguna == 2:
      self._status = "Pegawai"
      self._pemilik.set_nama(input("Nama pegawai: "))
      self._nip = input("NIP pegawai: ")
    else:
      self._status = "Umum"
      self._pemilik.set_nama("")
      self._nip = ""

  def get_jenis(self):
    raise NotImplementedError

  def cetak_karakteristik(self):
    raise NotImplementedError

  def hitung_biaya(self, lama_detik, pegawai):
    raise NotImplementedError

  def input_kendaraan(self):
    raise NotImplementedError

  def cetak_data(self, no):
    format_helper = Pegawai()
    identitas = (
        f"{self._pemilik.get_nama()}/{self._nip}"
        if self._status == "Pegawai"
        else "-"
    )
    detik = self.hitung_lama_detik()
    lama = f"{detik // 3600}j {(detik % 3600) // 60}m"

    print(
        f"{no:<4}"
        f"{self._nomor_polisi:<12}"
        f"{self.get_jenis():<10}"
        f"{self._status:<12}"
        f"{identitas:<18}"
        f"{format_helper.format_waktu(self._waktu_masuk):<10}"
        f"{format_helper.format_waktu(self._waktu_keluar):<10}"
        f"{lama:<12}"
        f"Rp {format_helper.format_ribuan(self.hitung_biaya(detik, self._status == 'Pegawai')):<12} ",
        end="",
    )
    self.cetak_karakteristik()
    print()


class Mobil(Kendaraan):

  def __init__(
      self,
      nomor="",
      nama="",
      nip="",
      status="Umum",
      masuk=None,
      keluar=None,
      pintu=4,
  ):
    super().__init__(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_pintu = pintu

  def set_mobil(self, nomor, nama, nip, status, masuk, keluar, pintu):
    self.set_kendaraan(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_pintu = pintu

  def input_kendaraan(self):
    self.input_data_dasar()
    while True:
      try:
        self._jumlah_pintu = int(input("Jumlah pintu mobil: "))
        if 2 <= self._jumlah_pintu <= 6:
          break
        print("Jumlah pintu harus 2-6!")
      except ValueError:
        print("Masukkan angka yang valid.")

    print("-- Waktu masuk --")
    self._waktu_masuk.input_waktu()
    print("-- Waktu keluar --")
    self._waktu_keluar.input_waktu()

  def get_jenis(self):
    return "Mobil"

  def cetak_karakteristik(self):
    print(f"Jumlah pintu: {self._jumlah_pintu}", end="")

  def hitung_biaya(self, lama_detik, pegawai):
    if pegawai:
      return ((lama_detik + 86400 - 1) // 86400) * 6000
    return ((lama_detik + 3600 - 1) // 3600) * 3000


class Truk(Kendaraan):
  def __init__(
      self,
      nomor="",
      nama="",
      nip="",
      status="Umum",
      masuk=None,
      keluar=None,
      roda=6,
  ):
    super().__init__(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_roda = roda

  def set_truk(self, nomor, nama, nip, status, masuk, keluar, roda):
    self.set_kendaraan(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_roda = roda

  def input_kendaraan(self):
    self.input_data_dasar()
    while True:
      try:
        self._jumlah_roda = int(input("Jumlah roda truk: "))
        if 4 <= self._jumlah_roda <= 18:
          break
        print("Jumlah roda harus 4-18!")
      except ValueError:
        print("Masukkan angka yang valid.")

    print("-- Waktu masuk --")
    self._waktu_masuk.input_waktu()
    print("-- Waktu keluar --")
    self._waktu_keluar.input_waktu()

  def get_jenis(self):
    return "Truk"

  def cetak_karakteristik(self):
    print(f"Jumlah roda: {self._jumlah_roda}", end="")

  def hitung_biaya(self, lama_detik, pegawai):
    return ((lama_detik + 3600 - 1) // 3600) * 5000


class Motor(Kendaraan):
  def __init__(
      self,
      nomor="",
      nama="",
      nip="",
      status="Umum",
      masuk=None,
      keluar=None,
      tak=4,
  ):
    super().__init__(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_tak = tak

  def set_motor(self, nomor, nama, nip, status, masuk, keluar, tak):
    self.set_kendaraan(nomor, nama, nip, status, masuk, keluar)
    self._jumlah_tak = tak

  def input_kendaraan(self):
    self.input_data_dasar()
    while True:
      try:
        self._jumlah_tak = int(input("Jenis mesin motor (2 atau 4 tak): "))
        if self._jumlah_tak in (2, 4):
          break
        print("Isi 2 atau 4!")
      except ValueError:
        print("Masukkan angka yang valid.")

    print("-- Waktu masuk --")
    self._waktu_masuk.input_waktu()
    print("-- Waktu keluar --")
    self._waktu_keluar.input_waktu()

  def get_jenis(self):
    return "Motor"

  def cetak_karakteristik(self):
    print(f"Jenis mesin: {self._jumlah_tak}-tak", end="")

  def hitung_biaya(self, lama_detik, pegawai):
    if pegawai:
      return ((lama_detik + 86400 - 1) // 86400) * 3000
    return ((lama_detik + 3600 - 1) // 3600) * 2000


class ArrayParkir:
  def __init__(self):
    self._kendaraan = []

  def tambah_parkir(self, data):
    if len(self._kendaraan) < 10:
      self._kendaraan.append(data)
    else:
      print("Array parkir penuh!")

  def cetak_laporan(self):
    if len(self._kendaraan) == 0:
      print("Tidak ada data parkir.")
      return

    print(f"\n{('=' * 40)} LAPORAN PARKIR KENDARAAN {('=' * 40)}\n")
    print(
        f"{'No':<4}{'No Polisi':<12}{'Jenis':<10}{'Pengguna':<12}{'Nama/NIP':<18}"
        f"{'Masuk':<10}{'Keluar':<10}{'Lama':<12}{'Biaya':<15}Karakteristik"
    )
    print("-" * 125)

    total = 0
    for i, kend in enumerate(self._kendaraan):
      kend.cetak_data(i + 1)
      total += kend.hitung_biaya(
          kend.hitung_lama_detik(), kend.get_status() == "Pegawai"
      )

    print("-" * 125)
    format_helper = Pegawai()
    print(f"Jumlah kendaraan : {len(self._kendaraan)}")
    print(f"Total pendapatan  : Rp {format_helper.format_ribuan(total)}")


class Menu:
  def __init__(self):
    self._pilihan = 0

  def input_pegawai_luar(self, data):
    nip = input("Masukkan NIP pegawai: ")
    nama = input("Masukkan nama pegawai: ")
    alamat = input("Masukkan alamat pegawai: ")
    while True:
      try:
        gol = int(input("Masukkan golongan: "))
        if 1 <= gol <= 4:
          break
        print("Golongan harus 1-4!")
      except ValueError:
        print("Masukkan angka yang valid.")

    data.set_pegawai(nama, nip, gol, alamat)

  def input_waktu_luar(self, waktu, keterangan):
    print(f"\n=== {keterangan} ===")
    while True:
      try:
        jam = int(input("Masukkan Jam (0-23): "))
        if 0 <= jam < 24:
          break
        print("Jam harus 0-23.")
      except ValueError:
        print("Masukkan angka yang valid.")

    while True:
      try:
        menit = int(input("Masukkan Menit (0-59): "))
        if 0 <= menit < 60:
          break
        print("Menit harus 0-59.")
      except ValueError:
        print("Masukkan angka yang valid.")

    while True:
      try:
        detik = int(input("Masukkan Detik (0-59): "))
        if 0 <= detik < 60:
          break
        print("Detik harus 0-59.")
      except ValueError:
        print("Masukkan angka yang valid.")

    waktu.set_waktu(jam, menit, detik)

  def cetak_header(self, judul="Tabel Utama"):
    print(f"\n=== {judul} ===")
    print("-" * 180)
    print(
        f"{'No':<4}{'NIP':<10}{'Nama':<14}{'Alamat':<20}{'Gol':<5}"
        f"{'Datang':<10}{'Pulang':<10}{'Lama':<10}{'Jam Lembur':<12}"
        f"{'Gaji Harian':<15}{'Lembur':<12}{'Total':<15}{'Status':<12}"
    )
    print("-" * 180)

  def cetak_tabel_data(self, kumpulan, judul):
    self.cetak_header(judul)
    for i in range(kumpulan.get_jumlah()):
      data = kumpulan.get_pegawai(i)
      datang = kumpulan.get_waktu_datang(i)
      pulang = kumpulan.get_waktu_pulang(i)
      data.cetak_pegawai(datang, pulang, i + 1)
    print("-" * 180)

  def cetak_ringkasan(self, kumpulan):
    jumlah = kumpulan.get_jumlah()
    if jumlah == 0:
      return

    total_semua = 0
    gaji_tertinggi = kumpulan.hitung_gaji_pada_index(0)
    gaji_terendah = kumpulan.hitung_gaji_pada_index(0)

    pegawai_tertinggi = kumpulan.get_pegawai(0).get_nama()
    pegawai_terendah = kumpulan.get_pegawai(0).get_nama()

    for i in range(jumlah):
      data = kumpulan.get_pegawai(i)
      gaji = kumpulan.hitung_gaji_pada_index(i)
      total_semua += gaji

      if gaji > gaji_tertinggi:
        gaji_tertinggi = gaji
        pegawai_tertinggi = data.get_nama()

      if gaji < gaji_terendah:
        gaji_terendah = gaji
        pegawai_terendah = data.get_nama()

    format_helper = Pegawai()
    rata_rata = int(total_semua / jumlah + 0.5)

    print(f"Rata-rata Gaji  : Rp {format_helper.format_ribuan(rata_rata)}")
    print(
        f"Gaji Tertinggi  : Rp"
        f" {format_helper.format_ribuan(gaji_tertinggi)} -"
        f" {pegawai_tertinggi}"
    )
    print(
        f"Gaji Terendah   : Rp {format_helper.format_ribuan(gaji_terendah)} -"
        f" {pegawai_terendah}"
    )

  def cetak_laporan(self, kumpulan, judul):
    if kumpulan.get_jumlah() == 0:
      print("Belum ada data pegawai.")
      return

    print(f"\n{('=' * 60)}")
    print(f" DAFTAR GAJI HARIAN PT INFORMATIKA - {judul}")
    print(f"{('=' * 60)}")

    self.cetak_tabel_data(kumpulan, "TABEL UTAMA (URUTAN INPUT)")
    self.cetak_tabel_data(
        kumpulan.sorting_ascending(),
        "TABEL ASCENDING (GAJI TOTAL TERKECIL KE TERBESAR)",
    )
    self.cetak_tabel_data(
        kumpulan.sorting_descending(),
        "TABEL DESCENDING (GAJI TOTAL TERBESAR KE TERKECIL)",
    )

    print("\n=== STATISTIK GAJI ===")
    self.cetak_ringkasan(kumpulan)

  def constructor(self):
    print("\n=== CONSTRUCTOR BERPARAMETER ===")
    kumpulan = ArrayPegawai()
    kumpulan.tambah_pegawai(
        Pegawai("Syifa", "012", 3, "Bandung"),
        Waktu(8, 0, 0),
        Waktu(17, 15, 10),
    )
    kumpulan.tambah_pegawai(
        Pegawai("Amela", "051", 2, "Sumedang"),
        Waktu(8, 0, 0),
        Waktu(19, 30, 10),
    )
    kumpulan.tambah_pegawai(
        Pegawai("Atika", "093", 4, "Bandung"), Waktu(8, 0, 0), Waktu(14, 0, 10)
    )
    self.cetak_laporan(kumpulan, "CONSTRUCTOR BERPARAMETER")

  def setter(self):
    print("\n=== SETTER ===")
    kumpulan = ArrayPegawai()

    p1 = Pegawai()
    p1.set_nip("001")
    p1.set_nama("Doni")
    p1.set_alamat("Bandung")
    p1.set_gol(2)
    datang1 = Waktu(8, 0, 0)
    pulang1 = Waktu(16, 30, 0)

    p2 = Pegawai()
    p2.set_pegawai("Tari", "002", 1, "Sumedang")
    datang2 = Waktu(22, 0, 0)
    pulang2 = Waktu(7, 0, 0)

    p3 = Pegawai()
    p3.set_pegawai("Iqbal", "003", 4, "Garut")
    datang3 = Waktu(7, 30, 0)
    pulang3 = Waktu(16, 0, 0)

    kumpulan.tambah_pegawai(p1, datang1, pulang1)
    kumpulan.tambah_pegawai(p2, datang2, pulang2)
    kumpulan.tambah_pegawai(p3, datang3, pulang3)

    self.cetak_laporan(kumpulan, "SETTER")

  def input_dalam(self):
    print("\n=== INPUT DALAM ===")
    kumpulan = ArrayPegawai()
    while True:
      try:
        banyak = int(input("Masukkan jumlah pegawai (maksimal 10): "))
        if 1 <= banyak <= 10:
          break
        print("Jumlah pegawai harus 1-10!")
      except ValueError:
        print("Masukkan angka yang valid.")

    for i in range(banyak):
      print(f"\n===== PEGAWAI KE-{i + 1} =====")
      pegawai = Pegawai()
      datang = Waktu()
      pulang = Waktu()

      pegawai.input_pegawai()
      print("\n=== WAKTU DATANG ===")
      datang.input_waktu()
      print("\n=== WAKTU PULANG ===")
      pulang.input_waktu()

      kumpulan.tambah_pegawai(pegawai, datang, pulang)

    self.cetak_laporan(kumpulan, "INPUT DALAM")

  def input_luar(self):
    print("\n=== INPUT LUAR ===")
    kumpulan = ArrayPegawai()
    while True:
      try:
        banyak = int(input("Masukkan jumlah pegawai (maksimal 10): "))
        if 1 <= banyak <= 10:
          break
        print("Jumlah pegawai harus 1-10!")
      except ValueError:
        print("Masukkan angka yang valid.")

    for i in range(banyak):
      print(f"\n===== PEGAWAI KE-{i + 1} =====")
      data = Pegawai()
      waktu_datang = Waktu()
      waktu_pulang = Waktu()

      self.input_pegawai_luar(data)
      self.input_waktu_luar(waktu_datang, "WAKTU DATANG")
      self.input_waktu_luar(waktu_pulang, "WAKTU PULANG")

      kumpulan.tambah_pegawai(data, waktu_datang, waktu_pulang)

    self.cetak_laporan(kumpulan, "INPUT LUAR")

  def constructor_parkir(self):
    print("\n=== CONSTRUCTOR BERPAMETER PARKIR ===")
    data_parkir = ArrayParkir()
    data_parkir.tambah_parkir(
        Mobil(
            "D 1234 AB",
            "Syifa",
            "012",
            "Pegawai",
            Waktu(8, 23, 55),
            Waktu(17, 34, 0),
            4,
        )
    )
    data_parkir.tambah_parkir(
        Truk(
            "D 5338 CD", "", "", "Umum", Waktu(9, 22, 22), Waktu(15, 30, 56), 10
        )
    )
    data_parkir.tambah_parkir(
        Motor(
            "D 9012 EF",
            "Atika",
            "093",
            "Pegawai",
            Waktu(7, 9, 3),
            Waktu(13, 0, 0),
            4,
        )
    )
    data_parkir.cetak_laporan()

  def setter_parkir(self):
    print("\n=== SETTER PARKIR ===")
    data_parkir = ArrayParkir()

    mobil = Mobil()
    mobil.set_mobil(
        "D 1111 AA", "Athian", "001", "Pegawai", Waktu(8, 34, 12), Waktu(17, 33, 1), 4
    )

    truk = Truk()
    truk.set_truk(
        "D 2222 BB", "", "", "Umum", Waktu(9, 0, 0), Waktu(16, 0, 0), 8
    )

    motor = Motor()
    motor.set_motor(
        "D 3333 CC", "Dila", "002", "Pegawai", Waktu(5, 0, 0), Waktu(17, 0, 0), 2
    )

    data_parkir.tambah_parkir(mobil)
    data_parkir.tambah_parkir(truk)
    data_parkir.tambah_parkir(motor)
    data_parkir.cetak_laporan()

  def input_dalam_parkir(self):
    print("\n=== INPUT DALAM PARKIR ===")
    data_parkir = ArrayParkir()
    while True:
      try:
        banyak = int(input("Masukkan jumlah kendaraan (1-10): "))
        if 1 <= banyak <= 10:
          break
        print("Jumlah kendaraan harus 1-10!")
      except ValueError:
        print("Masukkan angka yang valid.")

    for i in range(banyak):
      print(f"\n===== KENDARAAN KE-{i + 1} =====")
      while True:
        try:
          jenis = int(input("Jenis kendaraan (1. Mobil  2. Truk  3. Motor): "))
          if 1 <= jenis <= 3:
            break
          print("Pilihan tidak valid!")
        except ValueError:
          print("Masukkan angka yang valid.")

      if jenis == 1:
        baru = Mobil()
      elif jenis == 2:
        baru = Truk()
      else:
        baru = Motor()

      baru.input_kendaraan()
      data_parkir.tambah_parkir(baru)

    data_parkir.cetak_laporan()

  def input_luar_parkir(self):
    print("\n=== INPUT LUAR PARKIR ===")
    data_parkir = ArrayParkir()
    while True:
      try:
        banyak = int(input("Masukkan jumlah kendaraan (1-10): "))
        if 1 <= banyak <= 10:
          break
        print("Jumlah kendaraan harus 1-10!")
      except ValueError:
        print("Masukkan angka yang valid.")

    for i in range(banyak):
      print(f"\n===== KENDARAAN KE-{i + 1} =====")
      nomor = input("Nomor polisi: ")
      while True:
        try:
          pengguna = int(input("Jenis pengguna (1. Umum  2. Pegawai): "))
          if 1 <= pengguna <= 2:
            break
          print("Pilihan tidak valid!")
        except ValueError:
          print("Masukkan angka yang valid.")

      status = "Pegawai" if pengguna == 2 else "Umum"
      nama = ""
      nip = ""
      if status == "Pegawai":
        nama = input("Nama pegawai: ")
        nip = input("NIP pegawai: ")

      while True:
        try:
          jenis = int(input("Jenis kendaraan (1. Mobil  2. Truk  3. Motor): "))
          if 1 <= jenis <= 3:
            break
          print("Pilihan tidak valid!")
        except ValueError:
          print("Masukkan angka yang valid.")

      if jenis == 1:
        while True:
          try:
            ciri = int(input("Jumlah pintu mobil: "))
            if 2 <= ciri <= 6:
              break
            print("Jumlah pintu harus 2-6!")
          except ValueError:
            print("Masukkan angka yang valid.")
      elif jenis == 2:
        while True:
          try:
            ciri = int(input("Jumlah roda truk: "))
            if 4 <= ciri <= 18:
              break
            print("Jumlah roda harus 4-18!")
          except ValueError:
            print("Masukkan angka yang valid.")
      else:
        while True:
          try:
            ciri = int(input("Jenis mesin motor (2 atau 4 tak): "))
            if ciri in (2, 4):
              break
            print("Isi 2 atau 4!")
          except ValueError:
            print("Masukkan angka yang valid.")

      masuk = Waktu()
      keluar = Waktu()
      self.input_waktu_luar(masuk, "WAKTU MASUK")
      self.input_waktu_luar(keluar, "WAKTU KELUAR")

      if jenis == 1:
        baru = Mobil(nomor, nama, nip, status, masuk, keluar, ciri)
      elif jenis == 2:
        baru = Truk(nomor, nama, nip, status, masuk, keluar, ciri)
      else:
        baru = Motor(nomor, nama, nip, status, masuk, keluar, ciri)

      data_parkir.tambah_parkir(baru)

    data_parkir.cetak_laporan()

  def menu_utama(self):
    while True:
      print("\n========== MENU UTAMA ==========")
      print("1. Program Pegawai")
      print("2. Program Parkir")
      print("3. Keluar")
      print("================================")
      try:
        self._pilihan = int(input("Pilih menu: "))
      except ValueError:
        print("Masukkan angka yang valid.")
        continue

      if self._pilihan == 1:
        self.menu_pegawai()
      elif self._pilihan == 2:
        self.menu_parkir()
      elif self._pilihan == 3:
        print("\nProgram selesai.")
        break
      else:
        print("Pilihan tidak tersedia!")

  def menu_pegawai(self):
    while True:
      print("\n========== PROGRAM PEGAWAI ==========")
      print("1. Constructor Berparameter")
      print("2. Setter")
      print("3. Input Dalam")
      print("4. Input Luar")
      print("5. Kembali ke Menu Utama")
      print("=====================================")
      try:
        pilih = int(input("Pilih menu: "))
      except ValueError:
        print("Masukkan angka yang valid.")
        continue

      if pilih == 1:
        self.constructor()
      elif pilih == 2:
        self.setter()
      elif pilih == 3:
        self.input_dalam()
      elif pilih == 4:
        self.input_luar()
      elif pilih == 5:
        print("Kembali ke Menu Utama...")
        break
      else:
        print("Pilihan tidak tersedia!")

  def menu_parkir(self):
    while True:
      print("\n========== PROGRAM PARKIR ==========")
      print("1. Constructor Berparameter")
      print("2. Setter")
      print("3. Input Dalam")
      print("4. Input Luar")
      print("5. Kembali ke Menu Utama")
      print("====================================")
      try:
        pilih = int(input("Pilih menu: "))
      except ValueError:
        print("Masukkan angka yang valid.")
        continue

      if pilih == 1:
        self.constructor_parkir()
      elif pilih == 2:
        self.setter_parkir()
      elif pilih == 3:
        self.input_dalam_parkir()
      elif pilih == 4:
        self.input_luar_parkir()
      elif pilih == 5:
        print("Kembali ke Menu Utama...")
        break
      else:
        print("Pilihan tidak tersedia!")


if __name__ == "__main__":
  menu = Menu()
  menu.menu_utama()