/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Donor {

    private String idDonor;
    private Pendonor pendonor;
    private Petugas petugas;
    private String tanggalDonor;
    private int jumlahDarah;

    public Donor(
            String idDonor,
            Pendonor pendonor,
            Petugas petugas,
            String tanggalDonor,
            int jumlahDarah) {

        this.idDonor = idDonor;
        this.pendonor = pendonor;
        this.petugas = petugas;
        this.tanggalDonor = tanggalDonor;
        this.jumlahDarah = jumlahDarah;
    }

    public String getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(String idDonor) {
        this.idDonor = idDonor;
    }

    public Pendonor getPendonor() {
        return pendonor;
    }

    public void setPendonor(Pendonor pendonor) {
        this.pendonor = pendonor;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }

    public String getTanggalDonor() {
        return tanggalDonor;
    }

    public void setTanggalDonor(String tanggalDonor) {
        this.tanggalDonor = tanggalDonor;
    }

    public int getJumlahDarah() {
        return jumlahDarah;
    }

    public void setJumlahDarah(int jumlahDarah) {
        this.jumlahDarah = jumlahDarah;
    }

    @Override
    public String toString() {
        return "ID Donor       : " + idDonor
                + "\nPendonor       : " + pendonor.getNama()
                + " (" + pendonor.getGolonganDarah() + ")"
                + "\nPetugas        : " + petugas.getNama()
                + "\nTanggal Donor  : " + tanggalDonor
                + "\nJumlah Darah   : " + jumlahDarah + " ml";
    }
}