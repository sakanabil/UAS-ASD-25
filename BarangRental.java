public class BarangRental {
    private String noTNKB, namaKendaraan, jenisKendaraan;
    private int tahun, biayaSewa;

    public BarangRental(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa) {
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan =jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String getNamaKendaraan() {    
        return namaKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getTahun() {
        return tahun;
    }

    public int getBiayaSewa() {
        return biayaSewa;
    }

    
    private static BarangRental cariKendaraan(BarangRental[] daftarKendaraan, String noTNKB) {
        for (BarangRental br : daftarKendaraan) {
            if (br != null && br.getNoTNKB().equals(noTNKB)) {
                return br;
            }
        }
        return null;
    }
}