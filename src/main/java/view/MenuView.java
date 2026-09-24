/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DonorController;
import controller.PendonorController;
import controller.PetugasController;
import java.util.Scanner;
import model.Donor;
import model.Orang;
import model.Pendonor;
import model.Petugas;

public class MenuView {

    private final Scanner input;
    private final PendonorController pendonorController;
    private final PetugasController petugasController;
    private final DonorController donorController;

    public MenuView() {
        input = new Scanner(System.in);

        pendonorController = new PendonorController();
        petugasController = new PetugasController();
        donorController = new DonorController(
                pendonorController,
                petugasController
        );
    }

    // ==================== MENU UTAMA ====================

    public void tampilkanMenuUtama() {
        int pilihan;

        do {
            System.out.println("\n==========================================");
            System.out.println("    SISTEM MANAJEMEN DATA DONOR DARAH");
            System.out.println("==========================================");
            System.out.println("1. Kelola Data Pendonor");
            System.out.println("2. Kelola Data Petugas");
            System.out.println("3. Kelola Data Donor");
            System.out.println("4. Tampilkan Data Orang");
            System.out.println("0. Keluar");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    menuPendonor();
                    break;

                case 2:
                    menuPetugas();
                    break;

                case 3:
                    menuDonor();
                    break;

                case 4:
                    tampilkanDataOrang();
                    break;

                case 0:
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // ==================== MENU PENDONOR ====================

    private void menuPendonor() {
        int pilihan;

        do {
            System.out.println("\n==========================================");
            System.out.println("             KELOLA PENDONOR");
            System.out.println("==========================================");
            System.out.println("1. Tambah Pendonor");
            System.out.println("2. Lihat Pendonor");
            System.out.println("3. Update Pendonor");
            System.out.println("4. Hapus Pendonor");
            System.out.println("0. Kembali");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahPendonor();
                    break;

                case 2:
                    tampilkanPendonor();
                    break;

                case 3:
                    updatePendonor();
                    break;

                case 4:
                    hapusPendonor();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    private void tambahPendonor() {
        System.out.println("\n========== TAMBAH PENDONOR ==========");

        String id;

        while (true) {
            id = inputTidakKosong("ID Pendonor: ");

            if (pendonorController.idSudahAda(id)) {
                System.out.println("ID Pendonor sudah digunakan!");
            } else {
                break;
            }
        }

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String golonganDarah = inputGolonganDarah();

        Pendonor pendonor = new Pendonor(
                id,
                nama,
                noHp,
                golonganDarah
        );

        pendonorController.tambahPendonor(pendonor);

        System.out.println("\nPendonor berhasil ditambahkan.");
    }

    private void tampilkanPendonor() {
        System.out.println("\n=============== DATA PENDONOR ===============");

        if (pendonorController.getDaftarPendonor().isEmpty()) {
            System.out.println("Belum ada data pendonor.");
            return;
        }

        for (Pendonor pendonor
                : pendonorController.getDaftarPendonor()) {

            System.out.println("---------------------------------------------");
            System.out.println(pendonor.getInfo());

            int jumlahDonor
                    = donorController.hitungJumlahDonorPendonor(
                            pendonor.getId()
                    );

            System.out.println("Jumlah Donor   : "
                    + jumlahDonor + " kali");
        }

        System.out.println("---------------------------------------------");
    }

    private void updatePendonor() {
        System.out.println("\n========== UPDATE PENDONOR ==========");

        String id = inputTidakKosong(
                "Masukkan ID Pendonor yang akan diupdate: "
        );

        Pendonor pendonor = pendonorController.cariPendonor(id);

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        System.out.println("\nData saat ini:");
        System.out.println(pendonor.getInfo());

        System.out.println("\nMasukkan data baru:");

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String golonganDarah = inputGolonganDarah();

        boolean berhasil = pendonorController.updatePendonor(
                id,
                nama,
                noHp,
                golonganDarah
        );

        if (berhasil) {
            System.out.println("\nData pendonor berhasil diupdate.");
        }
    }

    private void hapusPendonor() {
        System.out.println("\n========== HAPUS PENDONOR ==========");

        String id = inputTidakKosong(
                "Masukkan ID Pendonor yang akan dihapus: "
        );

        Pendonor pendonor = pendonorController.cariPendonor(id);

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        if (donorController.pendonorMemilikiDataDonor(id)) {
            System.out.println(
                    "Pendonor tidak dapat dihapus karena "
                    + "masih memiliki data donor!"
            );
            return;
        }

        boolean berhasil = pendonorController.hapusPendonor(id);

        if (berhasil) {
            System.out.println("Pendonor berhasil dihapus.");
        }
    }

    // ==================== MENU PETUGAS ====================

    private void menuPetugas() {
        int pilihan;

        do {
            System.out.println("\n==========================================");
            System.out.println("              KELOLA PETUGAS");
            System.out.println("==========================================");
            System.out.println("1. Tambah Petugas");
            System.out.println("2. Lihat Petugas");
            System.out.println("3. Update Petugas");
            System.out.println("4. Hapus Petugas");
            System.out.println("0. Kembali");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahPetugas();
                    break;

                case 2:
                    tampilkanPetugas();
                    break;

                case 3:
                    updatePetugas();
                    break;

                case 4:
                    hapusPetugas();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    private void tambahPetugas() {
        System.out.println("\n========== TAMBAH PETUGAS ==========");

        String id;

        while (true) {
            id = inputTidakKosong("ID Petugas: ");

            if (petugasController.idSudahAda(id)) {
                System.out.println("ID Petugas sudah digunakan!");
            } else {
                break;
            }
        }

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String jabatan = inputTidakKosong("Jabatan: ");

        Petugas petugas = new Petugas(
                id,
                nama,
                noHp,
                jabatan
        );

        petugasController.tambahPetugas(petugas);

        System.out.println("\nPetugas berhasil ditambahkan.");
    }

    private void tampilkanPetugas() {
        System.out.println("\n=============== DATA PETUGAS ===============");

        if (petugasController.getDaftarPetugas().isEmpty()) {
            System.out.println("Belum ada data petugas.");
            return;
        }

        for (Petugas petugas
                : petugasController.getDaftarPetugas()) {

            System.out.println("--------------------------------------------");
            System.out.println(petugas.getInfo());
        }

        System.out.println("--------------------------------------------");
    }

    private void updatePetugas() {
        System.out.println("\n========== UPDATE PETUGAS ==========");

        String id = inputTidakKosong(
                "Masukkan ID Petugas yang akan diupdate: "
        );

        Petugas petugas = petugasController.cariPetugas(id);

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        System.out.println("\nData saat ini:");
        System.out.println(petugas.getInfo());

        System.out.println("\nMasukkan data baru:");

        String nama = inputTidakKosong("Nama: ");
        String noHp = inputNoHp("No. HP: ");
        String jabatan = inputTidakKosong("Jabatan: ");

        boolean berhasil = petugasController.updatePetugas(
                id,
                nama,
                noHp,
                jabatan
        );

        if (berhasil) {
            System.out.println("\nData petugas berhasil diupdate.");
        }
    }

    private void hapusPetugas() {
        System.out.println("\n========== HAPUS PETUGAS ==========");

        String id = inputTidakKosong(
                "Masukkan ID Petugas yang akan dihapus: "
        );

        Petugas petugas = petugasController.cariPetugas(id);

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        if (donorController.petugasMemilikiDataDonor(id)) {
            System.out.println(
                    "Petugas tidak dapat dihapus karena "
                    + "masih digunakan pada data donor!"
            );
            return;
        }

        boolean berhasil = petugasController.hapusPetugas(id);

        if (berhasil) {
            System.out.println("Petugas berhasil dihapus.");
        }
    }

    // ==================== MENU DONOR ====================

    private void menuDonor() {
        int pilihan;

        do {
            System.out.println("\n==========================================");
            System.out.println("               KELOLA DONOR");
            System.out.println("==========================================");
            System.out.println("1. Tambah Data Donor");
            System.out.println("2. Lihat Data Donor");
            System.out.println("3. Update Data Donor");
            System.out.println("4. Hapus Data Donor");
            System.out.println("0. Kembali");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahDonor();
                    break;

                case 2:
                    tampilkanDonor();
                    break;

                case 3:
                    updateDonor();
                    break;

                case 4:
                    hapusDonor();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    private void tambahDonor() {
        System.out.println("\n========== TAMBAH DATA DONOR ==========");

        String idDonor;

        while (true) {
            idDonor = inputTidakKosong("ID Donor: ");

            if (donorController.idSudahAda(idDonor)) {
                System.out.println("ID Donor sudah digunakan!");
            } else {
                break;
            }
        }

        String idPendonor = inputTidakKosong("ID Pendonor: ");
        Pendonor pendonor
                = pendonorController.cariPendonor(idPendonor);

        if (pendonor == null) {
            System.out.println(
                    "Pendonor tidak ditemukan. "
                    + "Tambahkan data pendonor terlebih dahulu!"
            );
            return;
        }

        String idPetugas = inputTidakKosong("ID Petugas: ");
        Petugas petugas
                = petugasController.cariPetugas(idPetugas);

        if (petugas == null) {
            System.out.println(
                    "Petugas tidak ditemukan. "
                    + "Tambahkan data petugas terlebih dahulu!"
            );
            return;
        }

        String tanggal = inputTidakKosong(
                "Tanggal Donor (DD-MM-YYYY): "
        );

        int jumlahDarah = inputAngkaPositif(
                "Jumlah Darah (ml): "
        );

        Donor donor = new Donor(
                idDonor,
                pendonor,
                petugas,
                tanggal,
                jumlahDarah
        );

        donorController.tambahDonor(donor);

        System.out.println("\nData donor berhasil ditambahkan.");
    }

    private void tampilkanDonor() {
        System.out.println("\n================ DATA DONOR ================");

        if (donorController.getDaftarDonor().isEmpty()) {
            System.out.println("Belum ada data donor.");
            return;
        }

        for (Donor donor : donorController.getDaftarDonor()) {
            System.out.println("--------------------------------------------");
            System.out.println(donor);
        }

        System.out.println("--------------------------------------------");
    }

    private void updateDonor() {
        System.out.println("\n========== UPDATE DATA DONOR ==========");

        String idDonor = inputTidakKosong(
                "Masukkan ID Donor yang akan diupdate: "
        );

        Donor donor = donorController.cariDonor(idDonor);

        if (donor == null) {
            System.out.println("Data donor tidak ditemukan!");
            return;
        }

        System.out.println("\nData saat ini:");
        System.out.println(donor);

        String idPendonor = inputTidakKosong(
                "\nID Pendonor baru: "
        );

        Pendonor pendonor
                = pendonorController.cariPendonor(idPendonor);

        if (pendonor == null) {
            System.out.println("Pendonor tidak ditemukan!");
            return;
        }

        String idPetugas = inputTidakKosong(
                "ID Petugas baru: "
        );

        Petugas petugas
                = petugasController.cariPetugas(idPetugas);

        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan!");
            return;
        }

        String tanggal = inputTidakKosong(
                "Tanggal Donor baru (DD-MM-YYYY): "
        );

        int jumlahDarah = inputAngkaPositif(
                "Jumlah Darah baru (ml): "
        );

        boolean berhasil = donorController.updateDonor(
                idDonor,
                pendonor,
                petugas,
                tanggal,
                jumlahDarah
        );

        if (berhasil) {
            System.out.println("\nData donor berhasil diupdate.");
        }
    }

    private void hapusDonor() {
        System.out.println("\n========== HAPUS DATA DONOR ==========");

        String idDonor = inputTidakKosong(
                "Masukkan ID Donor yang akan dihapus: "
        );

        boolean berhasil
                = donorController.hapusDonor(idDonor);

        if (berhasil) {
            System.out.println("Data donor berhasil dihapus.");
        } else {
            System.out.println("Data donor tidak ditemukan!");
        }
    }

    // ==================== POLYMORPHISM ====================

    private void tampilkanDataOrang() {
        System.out.println("\n========== DATA ORANG ==========");

        for (Pendonor pendonor
                : pendonorController.getDaftarPendonor()) {

            Orang orang = pendonor;

            System.out.println("\n[PENDONOR]");
            System.out.println(orang.getInfo());
        }

        for (Petugas petugas
                : petugasController.getDaftarPetugas()) {

            Orang orang = petugas;

            System.out.println("\n[PETUGAS]");
            System.out.println(orang.getInfo());
        }
    }

    // ==================== VALIDASI INPUT ====================

    private String inputTidakKosong(String pesan) {
        while (true) {
            System.out.print(pesan);

            String nilai = input.nextLine().trim();

            if (!nilai.isEmpty()) {
                return nilai;
            }

            System.out.println("Input tidak boleh kosong!");
        }
    }

    private int inputAngka(String pesan) {
        while (true) {
            System.out.print(pesan);

            String nilai = input.nextLine().trim();

            try {
                return Integer.parseInt(nilai);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    private int inputAngkaPositif(String pesan) {
        while (true) {
            int nilai = inputAngka(pesan);

            if (nilai > 0) {
                return nilai;
            }

            System.out.println("Angka harus lebih dari 0!");
        }
    }

    private String inputNoHp(String pesan) {
        while (true) {
            String noHp = inputTidakKosong(pesan);

            if (noHp.matches("[0-9]+")) {
                return noHp;
            }

            System.out.println(
                    "Nomor HP hanya boleh berisi angka!"
            );
        }
    }

    private String inputGolonganDarah() {
        while (true) {
            String golonganDarah
                    = inputTidakKosong(
                            "Golongan Darah (A/B/AB/O): "
                    ).toUpperCase();

            if (golonganDarah.equals("A")
                    || golonganDarah.equals("B")
                    || golonganDarah.equals("AB")
                    || golonganDarah.equals("O")) {

                return golonganDarah;
            }

            System.out.println(
                    "Golongan darah harus A, B, AB, atau O!"
            );
        }
    }
}