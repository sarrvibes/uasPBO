package model;

public class Motor extends Kendaraan {
    private static final int TARIF_PER_JAM = 2000;

    public Motor(String platNomor) {
        super(platNomor);
        this.jenis = "Motor";
    }

    @Override
    public int hitungBiaya() {
    long durasi = java.time.Duration.between(jamMasuk, jamKeluar).toHours(); // pakai jamKeluar
    return (int) Math.max(durasi, 1) * TARIF_PER_JAM;
    }
}
