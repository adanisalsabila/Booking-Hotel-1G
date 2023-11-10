import java.util.Scanner;

public class HotelBookingSystem {

    public static void main(String[] args) {
        String[] tipeKamar = { "Superior", "Deluxe", "President Suite" };
        double[] hargaPerMalam = { 750000, 500000, 2000000 };
        String[] layananTambahan = { "Extra Bed", "Makanan", null };
        double[] hargaLayanan = { 50000, 100000, 0 };
        int pilihanKamar;
        String selectedRoomType = null;
        double selectedRoomPrice = 0;
        boolean lanjut = true;
        boolean lanjut2 = true;
        int noRekening = 0;
        int pilihanLayanan[] = { 0, 0 };
        String namaPemesan;
        String alatTransaksi;
        double pembayaran;
        double totalLayanan = 0.0;
        double totalBiaya;
        double kembalian;
        int jumlahMalam;
        // Deklarasi dan inisialisasi variabel input
        Scanner input = new Scanner(System.in);

        // Input data dari pengguna
        System.out.println("Selamat datang di Ijen Suites Hotel!");
        System.out.print("Masukkan nama pemesan: ");
        namaPemesan = input.nextLine();
        // Memilih tipe kamar
        while (lanjut) {
            System.out.println("Pilih tipe kamar:");
            for (int i = 0; i < tipeKamar.length; i++) {
                System.out.println(i + 1 + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
            }
            System.out.println("Masukkan angka untuk memilih :");
            pilihanKamar = input.nextInt();

            if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                selectedRoomType = tipeKamar[pilihanKamar - 1];
                selectedRoomPrice = hargaPerMalam[pilihanKamar - 1];
                lanjut = false;
            } else {
                System.out.println("Inputan salah");
            }
        }