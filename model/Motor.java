package model;

public class Motor extends Kendaraan {

    public Motor(String platNomor) {
        super(platNomor);
    }

    @Override
    public int hitungBiaya(long durasiJam) {
        return (int) durasiJam * 2000; // misalnya Rp2.000/jam
        }
}