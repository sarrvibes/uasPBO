package model;

public class Mobil extends Kendaraan {

    public Mobil(String platNomor) {
        super(platNomor);
    }

    @Override
    public int hitungBiaya(long durasiJam) {
        return (int) durasiJam * 5000; // misalnya Rp5.000/jam
        
    }
}