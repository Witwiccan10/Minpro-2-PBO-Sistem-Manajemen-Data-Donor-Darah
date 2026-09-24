/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Petugas;

public class PetugasController {

    private final ArrayList<Petugas> daftarPetugas;

    public PetugasController() {
        daftarPetugas = new ArrayList<>();

        // Dummy data awal
        daftarPetugas.add(
                new Petugas(
                        "PT001",
                        "Siti Rahma",
                        "081298765432",
                        "Petugas Donor"
                )
        );
    }

    public ArrayList<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }

    public void tambahPetugas(Petugas petugas) {
        daftarPetugas.add(petugas);
    }

    public Petugas cariPetugas(String id) {
        for (Petugas petugas : daftarPetugas) {
            if (petugas.getId().equalsIgnoreCase(id)) {
                return petugas;
            }
        }

        return null;
    }

    public boolean idSudahAda(String id) {
        return cariPetugas(id) != null;
    }

    public boolean updatePetugas(
            String id,
            String nama,
            String noHp,
            String jabatan) {

        Petugas petugas = cariPetugas(id);

        if (petugas == null) {
            return false;
        }

        petugas.setNama(nama);
        petugas.setNoHp(noHp);
        petugas.setJabatan(jabatan);

        return true;
    }

    public boolean hapusPetugas(String id) {
        Petugas petugas = cariPetugas(id);

        if (petugas == null) {
            return false;
        }

        daftarPetugas.remove(petugas);
        return true;
    }
}