# Mini Project 2 PBO - Sistem Manajemen Data Donor Darah

**Nama:** Muhammad Kevin Athfalyuna  
**Kelas:** B  
**Mata Kuliah:** Pemrograman Berorientasi Objek

## Deskripsi Program

Sistem Manajemen Data Donor Darah merupakan program berbasis Java yang digunakan untuk mengelola data pendonor, petugas, dan kegiatan donor darah.

Program ini merupakan pengembangan dari Mini Project 1 dengan menerapkan konsep Pemrograman Berorientasi Objek (PBO), seperti encapsulation, inheritance, access modifier, serta validasi input. Program juga menerapkan MVC dan polymorphism sebagai nilai tambah.

Program menyediakan fitur untuk menambah, melihat, mengubah, dan menghapus data pendonor, petugas, serta data donor darah.

---

## Struktur Project

Program menerapkan struktur MVC (Model-View-Controller) dengan pembagian package sebagai berikut:

```text
src/main/java
│
├── model
│   ├── Orang.java
│   ├── Pendonor.java
│   ├── Petugas.java
│   └── Donor.java
│
├── controller
│   ├── PendonorController.java
│   ├── PetugasController.java
│   └── DonorController.java
│
├── view
│   └── MenuView.java
│
└── main
    └── Main.java
```

### Model
Package `model` berisi class yang digunakan untuk merepresentasikan data pada program, yaitu `Orang`, `Pendonor`, `Petugas`, dan `Donor`.

### Controller
Package `controller` digunakan untuk mengatur proses pengelolaan data seperti menambah, mencari, mengubah, dan menghapus data.

### View
Package `view` berisi `MenuView` yang digunakan untuk menampilkan menu serta menerima input dari pengguna.

### Main
Package `main` berisi class `Main` yang digunakan sebagai titik awal untuk menjalankan program.

---

# Alur Program

## 1. Menu Utama

<img width="470" height="235" alt="Screenshot 2026-09-24 204446" src="https://github.com/user-attachments/assets/dd72a80c-6dab-44d5-8312-d24d93f6b9a8" />

**Gambar 1. Menu Utama Program**

Pada saat program dijalankan, pengguna akan melihat menu utama yang menyediakan pilihan untuk mengelola data pendonor, petugas, data donor, serta menampilkan data orang.

---

## 2. Data Pendonor

<img width="428" height="218" alt="Screenshot 2026-09-24 204627" src="https://github.com/user-attachments/assets/a4060e44-851e-4091-b8f6-128c70e59396" />

**Gambar 2. Menampilkan Data Pendonor**

Menu pendonor digunakan untuk melakukan proses tambah, lihat, update, dan hapus data pendonor. Program telah memiliki dummy data awal sehingga data dapat langsung ditampilkan tanpa harus melakukan input terlebih dahulu.

Pada data pendonor juga ditampilkan jumlah kegiatan donor yang pernah dilakukan oleh masing-masing pendonor.

---

## 3. Tambah Data Pendonor

<img width="367" height="165" alt="Screenshot 2026-09-24 204932" src="https://github.com/user-attachments/assets/c81490b1-71c8-4aa4-bbd0-be076624c99d" />

**Gambar 3. Menambahkan Data Pendonor**

Pengguna dapat menambahkan pendonor baru dengan memasukkan ID pendonor, nama, nomor HP, dan golongan darah. Data yang berhasil dimasukkan akan disimpan ke dalam `ArrayList`.

Program juga melakukan validasi agar ID pendonor yang sama tidak dapat digunakan lebih dari satu kali.

---

## 4. Update Data Pendonor

<img width="441" height="340" alt="Screenshot 2026-09-24 205051" src="https://github.com/user-attachments/assets/4dc67d5c-3c99-4958-9349-0c017a91b8b3" />

**Gambar 4. Mengubah Data Pendonor**

Fitur update digunakan untuk mengubah data pendonor berdasarkan ID. Perubahan data dilakukan menggunakan method setter yang terdapat pada class `Pendonor` dan superclass `Orang`.

---

## 5. Data Petugas

<img width="415" height="222" alt="Screenshot 2026-09-24 205206" src="https://github.com/user-attachments/assets/2593f2b3-e44e-411d-b082-9f2ea8081ed6" />

**Gambar 5. Menampilkan Data Petugas**

Menu petugas digunakan untuk mengelola data petugas yang bertanggung jawab pada kegiatan donor darah. Data petugas dapat ditambah, ditampilkan, diubah, dan dihapus.

---

## 6. Update Data Petugas
   
<img width="455" height="341" alt="Screenshot 2026-09-24 211803" src="https://github.com/user-attachments/assets/b3eb6f4b-382e-4479-bde3-80ba866d2eb5" />

**Gambar 6. Mengubah Data Petugas**

Fitur update digunakan untuk mengubah data petugas berdasarkan ID. Perubahan data dilakukan menggunakan method setter yang terdapat pada class `Petugas` dan superclass `Orang`.

## 7. Tambah Data Petugas

<img width="360" height="176" alt="Screenshot 2026-09-24 211303" src="https://github.com/user-attachments/assets/7e16a4d4-21b0-4875-8f96-18217473f34b" />

**Gambar 7. Menambahkan Data Petugas**

Pengguna dapat menambahkan petugas baru dengan memasukkan ID petugas, nama, nomor HP, dan jabatan. Data yang berhasil dimasukkan akan disimpan ke dalam `ArrayList`.

Program juga melakukan validasi agar ID pendonor yang sama tidak dapat digunakan lebih dari satu kali.

---

## 8. Data Donor

<img width="407" height="208" alt="Screenshot 2026-09-24 205353" src="https://github.com/user-attachments/assets/c4df5375-78a9-49dd-bc87-68fd2acdcb94" />

**Gambar 8. Menampilkan Data Donor**

Data donor menyimpan informasi kegiatan donor yang terdiri dari ID donor, pendonor, petugas, tanggal donor, dan jumlah darah.

Data donor terhubung dengan objek `Pendonor` dan `Petugas`, sehingga informasi yang ditampilkan tidak hanya berupa ID tetapi juga informasi pendonor dan petugas yang berkaitan.

---

## 9. Tambah Data Donor

<img width="387" height="197" alt="Screenshot 2026-09-24 205520" src="https://github.com/user-attachments/assets/058bfa8b-9a1b-4247-bef4-5d57a1724acf" />

**Gambar 9. Menambahkan Data Donor**

Pengguna dapat menambahkan kegiatan donor dengan memasukkan ID donor, ID pendonor, ID petugas, tanggal donor, dan jumlah darah.

ID pendonor dan ID petugas akan diperiksa terlebih dahulu untuk memastikan data tersebut tersedia di dalam program.

---

## 10. Validasi Input

<img width="377" height="291" alt="Screenshot 2026-09-24 205841" src="https://github.com/user-attachments/assets/504e32dd-1cbf-42e0-ac93-a127c18fdd4b" />

**Gambar 10. Validasi Input**

Program menerapkan validasi input untuk mencegah input yang tidak sesuai. Beberapa validasi yang diterapkan antara lain input tidak boleh kosong, input angka harus berupa angka, nomor HP hanya dapat berisi angka, golongan darah hanya dapat berupa A, B, AB, atau O, serta ID tidak boleh duplikat.

---

# Penerapan Konsep PBO

## 1. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut class.

Contoh pada superclass `Orang`:

```java
private String id;
private String nama;
private String noHp;
```

Atribut tersebut diakses dan diubah menggunakan method getter dan setter.

Contoh:

```java
public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}
```

Method setter juga digunakan pada fitur update sehingga penerapan encapsulation digunakan secara langsung dalam program.

---

## 2. Inheritance

Inheritance diterapkan menggunakan superclass `Orang` dan dua subclass yaitu `Pendonor` dan `Petugas`.

Struktur inheritance:

```text
             Orang
            /     \
       Pendonor   Petugas
```

Class `Pendonor`:

```java
public class Pendonor extends Orang {
```

Class `Petugas`:

```java
public class Petugas extends Orang {
```

Atribut yang dimiliki bersama seperti ID, nama, dan nomor HP ditempatkan pada superclass `Orang`, sedangkan atribut khusus ditempatkan pada masing-masing subclass.

`Pendonor` memiliki atribut `golonganDarah`, sedangkan `Petugas` memiliki atribut `jabatan`.

---

# Nilai Tambah

## 1. MVC (Model-View-Controller)

Program menerapkan struktur MVC dengan memisahkan program menjadi package `model`, `controller`, dan `view`.

- **Model** digunakan untuk merepresentasikan objek dan data.
- **View** digunakan untuk menampilkan menu dan menerima input pengguna.
- **Controller** digunakan untuk mengatur proses pengelolaan data.

Pemisahan tersebut membuat struktur program lebih terorganisir dan memisahkan tanggung jawab masing-masing bagian program.

---

## 2. Polymorphism

Polymorphism diterapkan melalui method overriding pada method `getInfo()`.

Superclass `Orang` memiliki method:

```java
public String getInfo()
```

Method tersebut kemudian di-override oleh class `Pendonor` dan `Petugas` menggunakan:

```java
@Override
public String getInfo()
```

Penerapan polymorphism digunakan ketika objek `Pendonor` atau `Petugas` disimpan dalam reference bertipe `Orang`.

Contoh:

```java
Orang orang = pendonor;
System.out.println(orang.getInfo());
```

Walaupun reference menggunakan tipe `Orang`, method `getInfo()` yang dijalankan mengikuti jenis objek sebenarnya.

---

## Dummy Data

Program memiliki dummy data awal yang langsung dimasukkan ke dalam `ArrayList` ketika program dijalankan.

Contoh data awal:

```text
Pendonor : P001 - Budi Santoso
Petugas  : PT001 - Siti Rahma
Donor    : D001
```

Dengan adanya dummy data, fitur Read dapat langsung menampilkan data ketika program pertama kali dijalankan tanpa pengguna harus memasukkan data terlebih dahulu.

---

# Kesimpulan

Sistem Manajemen Data Donor Darah dapat digunakan untuk melakukan pengelolaan data pendonor, petugas, dan kegiatan donor darah melalui fitur CRUD.

Program telah menerapkan konsep Pemrograman Berorientasi Objek berupa access modifier, encapsulation, inheritance, serta validasi input. Selain itu, program menerapkan MVC dan polymorphism sebagai nilai tambah.

---

