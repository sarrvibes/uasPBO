import model.*;
import service.TransaksiParkir;
import util.IdGenerator;

import java.util.Scanner;

public class ParkirApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransaksiParkir transaksi = new TransaksiParkir();

        System.out.print("Nama Petugas: ");
        String nama = scanner.nextLine();
        Petugas petugas = new Petugas(nama, IdGenerator.generateId());

        while (true) {
            System.out.println("\n== Sistem Parkir ==");
            System.out.println("1. Masuk");
            System.out.println("2. Keluar");
            System.out.println("3. Tampilkan Data Parkir");
            System.out.println("4. Keluar Aplikasi");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Jenis kendaraan (Mobil/Motor): ");
                    String jenis = scanner.nextLine();
                    System.out.print("Plat Nomor: ");
                    String plat = scanner.nextLine();

                    Kendaraan kendaraan;
                    if (jenis.equalsIgnoreCase("mobil")) {
                        kendaraan = new Mobil(plat);
                    } else {
                        kendaraan = new Motor(plat);
                    }
                    transaksi.masuk(kendaraan);
                    break;

                case 2:
                    System.out.print("Plat Nomor: ");
                    String platKeluar = scanner.nextLine();
                    transaksi.keluar(platKeluar);
                    break;

                case 3:
                    transaksi.tampilkanData();
                    break;

                case 4:
                    System.out.println("Sampai jumpa, " + petugas.getNama() + "!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
