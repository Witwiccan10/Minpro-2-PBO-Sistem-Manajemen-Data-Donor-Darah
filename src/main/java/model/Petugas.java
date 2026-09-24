/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Petugas extends Orang {

    private String jabatan;

    public Petugas(
            String id,
            String nama,
            String noHp,
            String jabatan) {

        super(id, nama, noHp);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public String getInfo() {
        return "ID Petugas     : " + getId()
                + "\nNama           : " + getNama()
                + "\nNo. HP         : " + getNoHp()
                + "\nJabatan        : " + jabatan;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}