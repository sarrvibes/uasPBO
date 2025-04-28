import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDateTime;

import model.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, Kendaraan> dataParkir = new HashMap<>();
    static Petugas petugasAktif;

    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("\n=== SISTEM PARKIR ===");
            System.out.println("1. Input Petugas Jaga");
            System.out.println("2. Parkir Mobil");
            System.out.println("3. Parkir Motor");
            System.out.println("4. Kendaraan Keluar");
            System.out.println("0. Keluar Program");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    inputPetugas();
                    break;
                case 2:
                    parkirKendaraan("mobil");
                    break;
                case 3:
                    parkirKendaraan("motor");
                    break;
                case 4:
                    kendaraanKeluar();
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 0);
    }

    static void inputPetugas() {
        System.out.print("Masukkan nama petugas: ");
        String nama = input.nextLine();
        petugasAktif = new Petugas(nama);
        System.out.println("Petugas " + nama + " siap bertugas.");
    }

    static void parkirKendaraan(String tipe) {
        if (petugasAktif == null) {
            System.out.println("Silakan input petugas terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan plat nomor: ");
        String plat = input.nextLine();

        Kendaraan kendaraan;
        if (tipe.equals("mobil")) {
            kendaraan = new Mobil(plat);
        } else {
            kendaraan = new Motor(plat);
        }

        kendaraan.setWaktuMasuk(LocalDateTime.now());
        String tiket = "TIKET-" + System.currentTimeMillis();
        dataParkir.put(tiket, kendaraan);

        System.out.println("Tiket berhasil dibuat: " + tiket);
        System.out.println("Waktu masuk: " + kendaraan.getWaktuMasuk());
    }

    static void kendaraanKeluar() {
        System.out.print("Masukkan ID tiket: ");
        String tiket = input.nextLine();

        Kendaraan kendaraan = dataParkir.remove(tiket);

        if (kendaraan == null) {
            System.out.println("Tiket tidak ditemukan.");
            return;
        }

        LocalDateTime waktuKeluar = LocalDateTime.now();
        long durasiMenit = java.time.Duration.between(kendaraan.getWaktuMasuk(), waktuKeluar).toMinutes();
        int biaya = kendaraan.hitungBiaya(durasiMenit);

        System.out.println("==== STRUK PARKIR ====");
        System.out.println("Petugas       : " + petugasAktif.getNama());
        System.out.println("Plat Nomor    : " + kendaraan.getPlatNomor());
        System.out.println("Durasi        : " + durasiMenit + " menit");
        System.out.println("Total Bayar   : Rp " + biaya);
    }
}
