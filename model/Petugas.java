package model;

public class Petugas {
    private String nama;
    private String id;

    public Petugas(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }
}
