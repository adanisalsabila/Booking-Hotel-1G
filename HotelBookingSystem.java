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
        System.out.println("Selamat datang di sistem booking hotel!");
        System.out.print("Masukkan nama pemesan: ");
        namaPemesan = input.nextLine();
       System.out.print("Masukkan tipe kamar (superior/president): ");
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
 
 
 
    }
