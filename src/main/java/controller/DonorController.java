/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Donor;
import model.Pendonor;
import model.Petugas;

public class DonorController {

    private final ArrayList<Donor> daftarDonor;

    public DonorController(
            PendonorController pendonorController,
            PetugasController petugasController) {

        daftarDonor = new ArrayList<>();

        // Mengambil dummy data Pendonor dan Petugas
        Pendonor pendonor = pendonorController.cariPendonor("P001");
        Petugas petugas = petugasController.cariPetugas("PT001");

        // Dummy data awal Donor
        daftarDonor.add(
                new Donor(
                        "D001",
                        pendonor,
                        petugas,
                        "24-09-2026",
                        350
                )
        );
    }

    public ArrayList<Donor> getDaftarDonor() {
        return daftarDonor;
    }

    public void tambahDonor(Donor donor) {
        daftarDonor.add(donor);
    }

    public Donor cariDonor(String idDonor) {
        for (Donor donor : daftarDonor) {
            if (donor.getIdDonor().equalsIgnoreCase(idDonor)) {
                return donor;
            }
        }

        return null;
    }

    public boolean idSudahAda(String idDonor) {
        return cariDonor(idDonor) != null;
    }

    public boolean updateDonor(
            String idDonor,
            Pendonor pendonor,
            Petugas petugas,
            String tanggalDonor,
            int jumlahDarah) {

        Donor donor = cariDonor(idDonor);

        if (donor == null) {
            return false;
        }

        donor.setPendonor(pendonor);
        donor.setPetugas(petugas);
        donor.setTanggalDonor(tanggalDonor);
        donor.setJumlahDarah(jumlahDarah);

        return true;
    }

    public boolean hapusDonor(String idDonor) {
        Donor donor = cariDonor(idDonor);

        if (donor == null) {
            return false;
        }

        daftarDonor.remove(donor);
        return true;
    }

    public boolean pendonorMemilikiDataDonor(String idPendonor) {
        for (Donor donor : daftarDonor) {
            if (donor.getPendonor().getId().equalsIgnoreCase(idPendonor)) {
                return true;
            }
        }

        return false;
    }

    public boolean petugasMemilikiDataDonor(String idPetugas) {
        for (Donor donor : daftarDonor) {
            if (donor.getPetugas().getId().equalsIgnoreCase(idPetugas)) {
                return true;
            }
        }

        return false;
    }

    public int hitungJumlahDonorPendonor(String idPendonor) {
        int jumlah = 0;

        for (Donor donor : daftarDonor) {
            if (donor.getPendonor().getId().equalsIgnoreCase(idPendonor)) {
                jumlah++;
            }
        }

        return jumlah;
    }
}