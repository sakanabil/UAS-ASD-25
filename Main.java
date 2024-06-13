import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarangRental[] daftarKendaraan = new BarangRental[5];
        TransaksiRental[] daftarTransaksi = new TransaksiRental[5];
        int pilihan;

        daftarKendaraan[0] = new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 10000);
        daftarKendaraan[1] = new BarangRental("N 4511 VS", "Honda Vario", "Motor", 2018, 10000);
        daftarKendaraan[2] = new BarangRental("N 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000);
        daftarKendaraan[3] = new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000);
        daftarKendaraan[4] = new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000);

        do {
            displayMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    displayDaftarKendaraan(daftarKendaraan);
                    break;
                case 2:
                    processPeminjaman(daftarKendaraan, daftarTransaksi, scanner);
                    break;
                case 3:
                    displayDaftarTransaksi(daftarTransaksi);
                    break;
                case 4:
                    sortTransaksi(daftarTransaksi);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Peminjaman");
        System.out.println("3. Tampilkan seluruh transaksi");
        System.out.println("4. Urutkan Transaksi urut no TNKB");
        System.out.println("5. Keluar");
        System.out.print("Pilih(1-5): ");
    }

    private static void displayDaftarKendaraan(BarangRental[] daftarKendaraan) {
        System.out.println("\n--- Daftar Kendaraan ---");
        System.out.println("| Nomor TNKB | Nama Kendaraan | Jenis | Tahun | Biaya Sewa Perjam |");
        System.out.println("------------------------------------------------------------------");
        for (BarangRental br : daftarKendaraan) {
            if (br != null) {
                System.out.printf("| %s | %s | %s | %d | %d |\n",
                        br.getNoTNKB(), br.getNamaKendaraan(), br.getJenisKendaraan(), br.getTahun(), br.getBiayaSewa());
            }
        }
    }

    private static void processPeminjaman(BarangRental[] daftarKendaraan, TransaksiRental[] daftarTransaksi, Scanner scanner) {
        int kodeTransaksi = daftarTransaksi.length + 1;
        int lamaPinjam;
        double totalBiaya;
        String namaPeminjam;
        int pilihanKendaraan;

        System.out.println("\n--- Proses Peminjaman ---");
        displayDaftarKendaraan(daftarKendaraan);

        System.out.print("\nMasukkan nomor TNKB kendaraan yang ingin dipinjam: ");
        String noTNKB = scanner.nextLine();
        BarangRental br = cariKendaraan(daftarKendaraan, noTNKB);
        if (br != null) {
            System.out.print("Masukkan nama peminjam: ");
            namaPeminjam = scanner.nextLine();
            System.out.print("Masukkan lama peminjaman (hari): ");
            lamaPinjam = scanner.nextInt();
            scanner.nextLine();

            totalBiaya = br.getBiayaSewa() * lamaPinjam;
            TransaksiRental transaksi = new TransaksiRental(kodeTransaksi, namaPeminjam, lamaPinjam, totalBiaya, br);
            daftarTransaksi[kodeTransaksi - 1] = transaksi;

            System.out.println("\nTransaksi peminjaman berhasil!");
            System.out.println("Kode Transaksi: " + transaksi.getKodeTransaksi());
        }
    }
}