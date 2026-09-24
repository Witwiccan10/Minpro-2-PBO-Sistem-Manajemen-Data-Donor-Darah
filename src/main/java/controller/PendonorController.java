/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pendonor;

public class PendonorController {

    private final ArrayList<Pendonor> daftarPendonor;

    public PendonorController() {
        daftarPendonor = new ArrayList<>();

        // Dummy data awal
        daftarPendonor.add(
                new Pendonor(
                        "P001",
                        "Budi Santoso",
                        "081234567890",
                        "O"
                )
        );
    }

    public ArrayList<Pendonor> getDaftarPendonor() {
        return daftarPendonor;
    }

    public void tambahPendonor(Pendonor pendonor) {
        daftarPendonor.add(pendonor);
    }

    public Pendonor cariPendonor(String id) {
        for (Pendonor pendonor : daftarPendonor) {
            if (pendonor.getId().equalsIgnoreCase(id)) {
                return pendonor;
            }
        }

        return null;
    }

    public boolean idSudahAda(String id) {
        return cariPendonor(id) != null;
    }

    public boolean updatePendonor(
            String id,
            String nama,
            String noHp,
            String golonganDarah) {

        Pendonor pendonor = cariPendonor(id);

        if (pendonor == null) {
            return false;
        }

        pendonor.setNama(nama);
        pendonor.setNoHp(noHp);
        pendonor.setGolonganDarah(golonganDarah);

        return true;
    }

    public boolean hapusPendonor(String id) {
        Pendonor pendonor = cariPendonor(id);

        if (pendonor == null) {
            return false;
        }

        daftarPendonor.remove(pendonor);
        return true;
    }
}