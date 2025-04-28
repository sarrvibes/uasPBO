package model;

import java.time.LocalDateTime;

public abstract class Kendaraan {
    protected String platNomor;
    protected LocalDateTime waktuMasuk;

    public Kendaraan(String platNomor) {
        this.platNomor = platNomor;
        this.waktuMasuk = LocalDateTime.now(); // otomatis tercatat saat masuk
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    // Method abstrak, harus di-override oleh class anak
    public abstract int hitungBiaya(long durasiJam);
}