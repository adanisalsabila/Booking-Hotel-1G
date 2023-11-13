
import java.util.Scanner;

public class testFiturBooking {

    public static void main(String[] args) {
        String[] tipeKamar = { "Superior" , "Deluxe", "President Suite" };
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

        //
        // Memilih layanan tambahan

        System.out.println("Pilih layanan tambahan :");
        for (int i = 0; i < layananTambahan.length; i++) {
            if (layananTambahan[i] != null)
                System.out.println(i + 1 + ". " + layananTambahan[i] + " - $" + hargaLayanan[i]);
        }
        System.out.println("3. skip");

        input.nextLine(); // membersihkan buffer

        int i = 0;
        while (lanjut2 && i < layananTambahan.length - 1) {
            System.out.println("Masukkan angka untuk memilih :");
            pilihanLayanan[i] = input.nextInt();

            if (pilihanLayanan[i] == 3) {
                lanjut2 = false;
            }
            totalLayanan += hargaLayanan[pilihanLayanan[i] - 1];

            input.nextLine();
            i++;

        }

        // input jumlah malam, allat transaksi, nominal pembayaran

        System.out.print("Masukkan alat transaksi (cc/cash/dll.): ");
        alatTransaksi = input.nextLine();
        if (alatTransaksi.equalsIgnoreCase("cc")) {
            System.out.print("Masukkan no rekening anda: ");
            noRekening = input.nextInt();
        }
        System.out.print("Masukkan jumlah malam menginap: ");
        jumlahMalam = input.nextInt();

        System.out.print("Masukkan nominal pembayaran: ");
        pembayaran = input.nextDouble();

        // Proses perhitungan total biaya
        totalBiaya = jumlahMalam * selectedRoomPrice + totalLayanan;
System.out.println(totalLayanan);
        // Output detail booking
        System.out.println("\nDetail Booking:");
        System.out.println("Nama Pemesan: " + namaPemesan);
        System.out.println("Tipe Kamar: " + selectedRoomType);
        System.out.println("Harga Kamar : Rp" + selectedRoomPrice);
        System.out.println("Layanan Tambahan:");
         i = 0;
        while (totalLayanan != 0 | i < layananTambahan.length) {
            // int pilihanLayanan = scanner.nextInt();
            for (i = 0; i < pilihanLayanan.length; i++) {
                if ( totalLayanan != 0 ) {
                    System.out.println("- " + layananTambahan[pilihanLayanan[i] - 1] + " - $"  + hargaLayanan[pilihanLayanan[i] - 1]);
                }
            }
            break;
        }
        System.out.println("Alat Transaksi: " + alatTransaksi);
        if (alatTransaksi.equalsIgnoreCase("cc")) {
            System.out.println("No Rekening Anda : " + noRekening);
        }
        System.out.println("Jumlah Malam Menginap: " + jumlahMalam);
        System.out.println("Total Biaya: Rp" + totalBiaya);

        // Proses pembayaran
        if (pembayaran >= totalBiaya) {
            kembalian = pembayaran - totalBiaya;
            System.out.println("Pembayaran diterima. Kembalian: Rp" + kembalian);
            System.out.println("Terima kasih telah melakukan booking!");
        } else {
            System.out.println("Pembayaran tidak mencukupi. Silakan bayar sesuai total biaya.");
        }

        // Tutup input
        input.close();
    }
}
