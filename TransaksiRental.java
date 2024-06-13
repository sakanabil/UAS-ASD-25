public class TransaksiRental {
    private int kodeTransaksi, lamaPinjam;
    private String namaPeminjam;
    private double totalBiaya;
    private BarangRental br;

    public void TransaksiRental(int kodeTransaksi, String namaPeminjam, int lamaPinjam, double totalBiaya, BarangRental br) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.totalBiaya = totalBiaya;
        this.br = br;
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }
}