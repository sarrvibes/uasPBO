package model;

public class Mobil extends Kendaraan {
    private static final int TARIF_PER_JAM = 4000;

    public Mobil(String platNomor) {
        super(platNomor);
        this.jenis = "Mobil";
    }

    @Override
    public int hitungBiaya() {
        long durasi = java.time.Duration.between(jamMasuk, jamKeluar).toHours(); // pakai jamKeluar
        return (int) Math.max(durasi, 1) * TARIF_PER_JAM;
    }
}
