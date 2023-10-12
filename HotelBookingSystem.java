import java.util.Scanner;
public class HotelBookingSystem {
    public static void main(String[] args) {
        // Deklarasi dan inisialisasi variabel input
        Scanner input = new Scanner(System.in);
        String namaPemesan;
        String tipeKamar;
        String alatTransaksi;
        double pembayaran;
        int jumlahMalam;
        double hargaPerMalam = 750000; // Harga kamar per malam
        
        // Input data dari pengguna
        System.out.println("Selamat datang di Ijen Suites Hotel!");
        System.out.print("Masukkan nama pemesan: ");
        namaPemesan = input.nextLine();
       System.out.print("Masukkan tipe kamar (superior/president/deluxe): ");
        tipeKamar = input.nextLine();
        System.out.print("Masukkan alat transaksi (cc/cash/dll.): ");
        alatTransaksi = input.nextLine();
        System.out.print("Masukkan jumlah malam menginap: ");
        jumlahMalam = input.nextInt();
        System.out.print("Masukkan pembayaran: ");
        pembayaran = input.nextDouble();

         // Proses perhitungan total biaya
         double totalBiaya = jumlahMalam * hargaPerMalam;
        
         // Output detail booking
         System.out.println("\nDetail Booking:");
         System.out.println("Nama Pemesan: " + namaPemesan);
         System.out.println("Tipe Kamar: " + tipeKamar);
         System.out.println("Alat Transaksi: " + alatTransaksi);
         System.out.println("Jumlah Malam Menginap: " + jumlahMalam);
         System.out.println("Harga Kamar per Malam: Rp" + hargaPerMalam);
         System.out.println("Total Biaya: Rp" + totalBiaya);
         
         // Proses pembayaran
         if (pembayaran >= totalBiaya) {
             double kembalian = pembayaran - totalBiaya;
             System.out.println("Pembayaran diterima. Kembalian: Rp" + kembalian);
             System.out.println("Terima kasih telah melakukan booking!");
         } else {
             System.out.println("Pembayaran tidak mencukupi. Silakan bayar sesuai total biaya.");
         }
         
         // Tutup input
         input.close();
     }
         
    }
if (pembayaran >= totalBiaya) {
             double kembalian = pembayaran - totalBiaya;
             System.out.println("Pembayaran diterima. Kembalian: Rp" + kembalian);
             System.out.println("Terima kasih telah melakukan booking!");
         } else {
             System.out.println("Pembayaran tidak mencukupi. Silakan bayar sesuai total biaya.")
                 import java.util.Scanner;

public class HotelBookingSystem {
    static String[] tipeKamar = {"Superior", "Deluxe", "President Suite"};
    static double[] hargaKamar = {750.0, 500.0, 2000.0};
    static String[] layananTambahan = {"Extra Bed", "Makanan"};
    static double[] hargaLayanan = {10.0, 20.0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Memilih tipe kamar
        System.out.println("Pilih tipe kamar:");
        for (int i = 0; i < tipeKamar.length; i++) {
            System.out.println(i + 1 + ". " + tipeKamar[i] + " - $" + hargaKamar[i]);
        }
        int pilihanKamar = scanner.nextInt();
        String selectedRoomType = tipeKamar[pilihanKamar - 1];
        double selectedRoomPrice = hargaKamar[pilihanKamar - 1];
