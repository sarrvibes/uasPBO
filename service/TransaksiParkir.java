package service;

import model.*;

import java.time.LocalDateTime;
import java.time.Duration;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TransaksiParkir {
    private Map<String, Kendaraan> dataParkir = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public void masuk(Kendaraan kendaraan) {
        dataParkir.put(kendaraan.getPlatNomor(), kendaraan);
        System.out.println(kendaraan.getJenis() + " dengan plat " + kendaraan.getPlatNomor() + " masuk.");

        System.out.println("\n==== TIKET PARKIR ====");
        System.out.println("ID Parkir     : " + kendaraan.getIdParkir());
        System.out.println("Plat Nomor    : " + kendaraan.getPlatNomor());
        System.out.println("Jenis         : " + kendaraan.getJenis());
        System.out.println("Waktu Masuk   : " + kendaraan.getWaktuMasuk().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("=======================");
    }

    public void keluar(String platNomor) {
    Kendaraan kendaraan = dataParkir.get(platNomor);
    if (kendaraan != null) {
        kendaraan.setJamKeluar(LocalDateTime.now()); // ⬅ pakai LocalDateTime!

        // Hitung durasi
        Duration durasi = Duration.between(kendaraan.getWaktuMasuk(), kendaraan.getJamKeluar());
        long jam = durasi.toHours();
        long menit = durasi.toMinutes() % 60;

        int biaya = kendaraan.hitungBiaya(); // Kamu bisa hitung manual durasi di sini juga kalo mau.

        // Cetak STRUK
        System.out.println("\n==== STRUK KELUAR ====");
        System.out.println("ID Parkir     : " + kendaraan.getIdParkir());
        System.out.println("Plat Nomor    : " + kendaraan.getPlatNomor());
        System.out.println("Jenis         : " + kendaraan.getJenis());
        System.out.println("Waktu Masuk   : " + kendaraan.getWaktuMasuk().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("Waktu Keluar  : " + kendaraan.getJamKeluar().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("Durasi Parkir : " + jam + " jam " + menit + " menit");
        System.out.println("Total Bayar   : Rp " + biaya);
        System.out.println("=======================");
        
        dataParkir.remove(platNomor);
    } else {
        System.out.println("Kendaraan tidak ditemukan.");
    }
}

    public void tampilkanData() {
        if (dataParkir.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang sedang parkir.");
        } else {
            for (Map.Entry<String, Kendaraan> entry : dataParkir.entrySet()) {
                Kendaraan k = entry.getValue();
                String waktuFormat = k.getWaktuMasuk().format(formatter);
                System.out.println(k.getClass().getSimpleName() + " - Plat: " + k.getPlatNomor() + ", Jam Masuk: " + waktuFormat);
            }
        }
    }
}
