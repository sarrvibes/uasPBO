package model;

import java.time.LocalDateTime;

import util.IdGenerator;

public abstract class Kendaraan {
    protected String platNomor;
    protected String jenis;
    protected String idParkir;
    protected LocalDateTime jamMasuk;
    protected LocalDateTime jamKeluar;

    public Kendaraan(String platNomor) {
        this.platNomor = platNomor;
        this.jamMasuk = LocalDateTime.now();
        this.idParkir = IdGenerator.generateId();
    }

    public abstract int hitungBiaya();

    public String getPlatNomor() {
        return platNomor;
    }

    public LocalDateTime getWaktuMasuk() {
        return jamMasuk;
    }

    public LocalDateTime getJamKeluar() {
        return jamKeluar;
    }
    
    public void setJamKeluar(LocalDateTime jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public String getJenis() {
        return jenis;
    }
    public String getIdParkir() {
        return idParkir;
    }
}