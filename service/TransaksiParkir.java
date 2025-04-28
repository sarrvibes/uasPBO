package service;

import model.Kendaraan;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class TransaksiParkir {
    private HashMap<String, Kendaraan> dataParkir = new HashMap<>();

    // Simpan kendaraan yang baru masuk dan buat tiket ID-nya
    public String kendaraanMasuk(Kendaraan kendaraan) {
        String tiketID = UUID.randomUUID().toString().substring(0, 8); //membuat id acak
        dataParkir.put(tiketID, kendaraan);
        System.out.println("Tiket ID: " + tiketID + " | Plat: " + kendaraan.getPlatNomor() + " | Waktu masuk: " + kendaraan.getWaktuMasuk());
        return tiketID;
    }

    //menghitung harga kendaraan keluar
    public void kendaraanKeluar(String tiketID) {
        if (!dataParkir.containsKey(tiketID)) {
            System.out.println("❌ Tiket tidak ditemukan.");
            return;
        }

        Kendaraan kendaraan = dataParkir.get(tiketID);
        LocalDateTime waktuKeluar = LocalDateTime.now();

        long durasi = Duration.between(kendaraan.getWaktuMasuk(), waktuKeluar).toMinutes();

        long jam = durasi / 60;
        if (durasi % 60 > 0) jam++; // pembulatan ke atas

        // long jam = Duration.between(kendaraan.getWaktuMasuk(), waktuKeluar).toMinutes();
        int total = kendaraan.hitungBiaya(jam);

        System.out.println("===== Bukti Parkir =====");
        System.out.println("Tiket ID     : " + tiketID);
        System.out.println("Plat Nomor   : " + kendaraan.getPlatNomor());
        System.out.println("Waktu Masuk  : " + kendaraan.getWaktuMasuk());
        System.out.println("Waktu Keluar : " + waktuKeluar);
        System.out.println("Durasi       : " + jam + " jam");
        System.out.println("Total Bayar  : Rp " + total);
        System.out.println("========================");

        dataParkir.remove(tiketID);
    }
}
