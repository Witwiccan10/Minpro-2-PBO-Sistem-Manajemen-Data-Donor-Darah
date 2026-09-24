/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Pendonor extends Orang {

    private String golonganDarah;

    public Pendonor(
            String id,
            String nama,
            String noHp,
            String golonganDarah) {

        super(id, nama, noHp);
        this.golonganDarah = golonganDarah;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    @Override
    public String getInfo() {
        return "ID Pendonor    : " + getId()
                + "\nNama           : " + getNama()
                + "\nNo. HP         : " + getNoHp()
                + "\nGolongan Darah : " + golonganDarah;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}