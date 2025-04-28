package model;

public class Petugas {
    private String nama;
    private String idPetugas;

    public Petugas(String nama, String idPetugas) {
        this.nama = nama;
        this.idPetugas = idPetugas;
    }

    public String getNama() {
        return nama;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public void tampilkanInfo() {
        System.out.println("🧍 Petugas Aktif:");
        System.out.println("- Nama     : " + nama);
        System.out.println("- ID Petugas: " + idPetugas);
    }
}
