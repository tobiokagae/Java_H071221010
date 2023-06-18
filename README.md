*PENJELASAN CODE*

Sebuah kode sederhana tentang implementasi dari sebuah manajer database menggunakan Java dan JDBC (Java Database Connectivity)

**Import Paket**

import java.sql.*;
import java.util.Scanner;

<!-- Untuk mengimpor paket paket yang diperlukan nantinya. -->

**Deklarasi Database**

private static final String DB_URL = "jdbc:mysql://localhost:3306 db_kasir";
private static final String USERNAME = "root";
private static final String PASSWORD = "";

<!-- Untuk menyimpan URL database, username, dan password agar dapat terhubung ke database MySQL nya. -->

**Main**

public static void main(String[] args) {
    // ...
}

<!-- Method tempat program utama berjalan -->

**Menu Database**

while (choice != 5) {
    // ...
}

<!-- Perulangan while pada method main akan terus berjalan sampai pengguna memilih choice = 5. Perulangan ini berguna untuk menampilkan menu pilihan kepada user dan mengambil pilihan user. -->

**Read Data**

private static void readData() {
    // ...
}

<!-- Method yang digunakan untuk membaca data dari database. Method ini akan menjalankan query SELECT untuk mengambil data dari tabel tb_kasir dan menampilkannya ke layar. -->

**Insert Data**

private static void insertData() {
    // ...
}

<!-- Method ini digunakan untuk memasukkan data baru ke dalam database. Method ini nantinya akan meminta user memasukkan NAMA, HARGA, dan JUMLAH, kemudian menjalankan query INSERT untuk menambahkan dan menyimpan data ke dalam tb_kasir. -->

**Edit Data**

private static void editData() {
    // ...
}

<!-- Method ini digunakan untuk mengedit data yang sudah tersimpan dalam database. Method ini akan meminta user untuk memasukkan ID data yang ingin diubah, kemudian meminta user untuk mengubah/mengedit NAMA, HARGA, dan JUMLAH, kemudian menjalankan query UPDATE untuk memperbarui data yang sesuai dalam tabel tb_kasir. -->

**Delete Data**

private static void deleteData() {
    // ...
}

<!-- Method ini digunakan untuk menghapus data dari database. Nantinya method ini akan meminta user untuk memasukkan ID data yang ingin dihapus, kemudian menjalankan query DELETE untuk menghapus data yang diinginkan dari tabel tb_kasir. -->

**Koneksi ke Database**

try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
    // ...
} catch (SQLException e) {
    e.printStackTrace();
}

<!-- Di dalam setiap method, koneksi ke database dibuat menggunakan DriverManager.getConnection() dengan URL database, username, dan password yang telah ditentukan. -->

**Statement SQL**

PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_login");


<!-- Pernyataan SQL dipersiapkan menggunakan objek PreparedStatement. -->

**Eksekusi Statement**

ResultSet resultSet = statement.executeQuery();

<!-- Statement SQL yang telah dipersiapkan dieksekusi menggunakan metode executeQuery(). Hasilnya disimpan dalam objek ResultSet yang berisi data yang ditemukan dari database. -->

**ResultSet**

while (resultSet.next()) {
    // ...
}

<!-- Hasil dari eksekusi query diiterasi menggunakan perulangan while dengan resultSet.next(). Ini akan berjalan melalui setiap baris hasil dan mengambil nilai dari setiap kolom menggunakan metode getInt() dan getString(). -->

**Menutup Koneksi**

resultSet.close();

<!-- Setelah selesai menggunakan ResultSet, perlu menutupnya dengan memanggil metode close(). -->

*MEKANISME KODE*

1. Menghubungkan ke Database:
    Kode DriverManager.getConnection(DB_URL, USERNAME, PASSWORD) digunakan untuk membuat koneksi dengan database menggunakan URL, username, dan password yang telah ditentukan sebelumnya. Ini memastikan bahwa program dapat terhubung ke database yang diinginkan.

2. Menampilkan Menu dan Meminta Pilihan:
    Setelah terhubung ke database, program akan menampilkan menu pilihan kepada user menggunakan perulangan while. user diminta untuk memilih satu opsi dari menu dengan memasukkan angka terkait.

3. Menjalankan Operasi Sesuai Pilihan:
    Program menggunakan pernyataan switch-case untuk menjalankan operasi yang sesuai berdasarkan pilihan user. Terdapat empat opsi yang dapat dipilih: membaca data, memasukkan data baru, mengedit data yang ada, atau menghapus data.

4. Membaca Data:
    Jika user memilih opsi "Read Data", program akan menjalankan metode readData(). Metode ini akan membuat pernyataan SQL SELECT untuk mengambil data dari tabel tb_kasir. Hasilnya disimpan dalam objek ResultSet dan kemudian ditampilkan ke layar.

5. Memasukkan Data:
    Jika user memilih opsi "Insert Data", program akan menjalankan metode insertData(). Metode ini meminta user untuk memasukkan informasi user baru seperti NAMA, HARGA, dan JUMLAH. Kemudian, pernyataan SQL INSERT akan dieksekusi dengan menggunakan nilai-nilai yang dimasukkan user.

6. Mengedit Data:
    Jika user memilih opsi "Edit Data", program akan menjalankan metode editData(). Metode ini meminta user untuk memasukkan ID data yang ingin diubah, kemudian meminta informasi user yang diperbarui seperti NAMA, HARGA, dan JUMLAH. Pernyataan SQL UPDATE akan dieksekusi dengan menggunakan nilai-nilai yang dimasukkan user.

7. Menghapus Data:
    Jika user memilih opsi "Delete Data", program akan menjalankan metode deleteData(). Metode ini meminta user untuk memasukkan ID data yang ingin dihapus. Pernyataan SQL DELETE akan dieksekusi dengan menggunakan ID yang dimasukkan user.

8. Menutup Koneksi dan Sumber Daya:
    Setelah operasi selesai, program akan menutup sumber daya yang digunakan, termasuk koneksi ke database dan objek scanner yang digunakan untuk menerima input dari user.

Dengan mekanisme ini, program memungkinkan user untuk berinteraksi dengan database, melakukan operasi seperti membaca, memasukkan, mengedit, atau menghapus data, dan memberikan umpan balik melalui tampilan konsol.

*PENJELASAN FILE*

1. CashierApp.java
    Dalam file ini menyimpan seluruh program yang akan dijalankan, mulai dari method, main class, dan juga semua yang dibutuhkan untuk menjalankan code, namun ada lagi 1 file yang dibutuhkan agar lebih mudah untuk mengakses seluruh menu

2. ResetID.java
    file ini adalah program Java yang digunakan untuk mereset nilai kolom primary key pada tabel database, fungsinya adalah untuk mengatur ulang urutan nilai primary key pada tabel database. Ketika data dihapus atau kolom primary key diperbarui, urutan nilai primary key tidak otomatis diubah. Hal ini dapat mengakibatkan ketidakkonsistenan dalam urutan nilai primary key.

    Dengan menggunakan perintah ALTER TABLE dan mengatur nilai AUTO_INCREMENT ke 1, kita dapat mereset nilai kolom primary key agar dimulai dari 1 dan diurutkan secara berurutan. Ini membantu menjaga konsistensi dan memastikan bahwa nilai primary key pada tabel dimulai dari angka yang sesuai.

    Misalnya, jika kita memiliki tabel dengan kolom primary key yang diatur sebagai AUTO_INCREMENT, dan kita menghapus beberapa baris data dari tabel tersebut, maka nilai primary key yang tersisa mungkin tidak berurutan. Dengan mereset nilai kolom primary key, kita dapat mengatur ulang urutan nilai primary key sehingga berurutan lagi dan dimulai dari 1.

