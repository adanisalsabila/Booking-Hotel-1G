
import java.util.Scanner;

public class FinalCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihMenu;
        String[] tipeKamar = { "Superior" , "Deluxe", "President Suite" };
        double[] hargaPerMalam = { 750000, 500000, 2000000 };
        String[] layananTambahan = { "Extra Bed", "Makanan", null };
        double[] hargaLayanan = { 50000, 100000, 0 };
        int pilihanKamar;
        String kamarPilihan = null;
        double selectedRoomPrice = 0;
        boolean lanjut = true;
        boolean lanjut2 = true;
        boolean kamarSuperiorTersedia = true;
        int noRekening = 0;
        int pilihanLayanan[] = { 0, 0 };
        String namaPemesan, alatTransaksi;
        double pembayaran, totalLayanan = 0.0, totalBiaya, kembalian;
        int jumlahMalam;
    

        //fitur menu
        System.out.println("=======================================");
        System.out.println("Selamat Datang di Ijen Suites Hotel!");
        System.out.println("=======================================");
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Cek Ketersediaan Kamar");
        System.out.println("2. Pesan Kamar");
        System.out.println("3. Pesan Layanan Tambahan (Makanan/Extra Bed/Sewa Aula)");
        System.out.println("4. Contact Person");
        System.out.println("5. Lokasi Hotel");
        System.out.println("6. Kritik dan Saran");
        System.out.println("7. Fasilitas Hotel");
        System.out.println("=======================================");
        System.out.println("Pilih Menu 1/2/3/4/5 : ");

        pilihMenu = input.nextInt();

        switch (pilihMenu) {
            case 1:
                do {
                    System.out.println("Cek Ketersediaan Kamar");
                    System.out.println("========================");
                    System.out.println("Pilih Jenis Kamar: ");
                    System.out.println("========================");
                    System.out.println("1. Superior Deluxe Room");
                    System.out.println("2. Devaxa President Room");
                    System.out.println("========================");
                    System.out.println("Masukkan jenis kamar yang ingin Anda cek :");
                    kamarPilihan = input.nextLine();

                    if (kamarPilihan == 1 && kamarTersedia(kamarSuperiorTersedia)) {
                    System.out.println("Superior Deluxe Room tersedia. Anda bisa memesannya!");
                    pesanKamar(kamarSuperiorTersedia);
                    } else if (kamarPilihan == 2 && kamarTersedia(kamarPresidentTersedia)) {
                    System.out.println("Devaxa President Room tersedia. Anda bisa memesannya!");
                    pesanKamar(kamarPresidentTersedia); 
                    } else {
                    System.out.println("Maaf, kamar yang Anda pilih tidak tersedia. Silahkan pilih kamar yang lain.");
                    break; 
                    case 2:
                do {
                    System.out.print("Masukkan nama pemesan: ");
                    namaPemesan = input.nextLine();
                    // Memilih tipe kamar
                while (lanjut) {
                    System.out.println("Pilih tipe kamar:");
                    for (int i = 0; i < tipeKamar.length; i++) {
                    System.out.println(i + 1 + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
                    }
                    System.out.println("Masukkan angka untuk memilih :");
                    kamarPilihan = input.nextInt();

                    if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                    kamarPilihan = tipeKamar[pilihanKamar - 1];
                    selectedRoomPrice = hargaPerMalam[pilihanKamar - 1];
                    lanjut = false;
                    } else {
                    System.out.println("Inputan salah");
            }
        }
                        break;
       case 3 :
            do {
            System.out.println("Pilih layanan tambahan :");
            for (int i = 0; i < layananTambahan.length; i++) {
            if (layananTambahan[i] != null)
                System.out.println(i + 1 + ". " + layananTambahan[i] + " - $" + hargaLayanan[i]);
            }
            System.out.println("3. skip");

            input.nextLine(); 

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
                if (totalLayanan != 0) {
                    System.out.println("- " + layananTambahan[pilihanLayanan[i] - 1] + " - $"
                            + hargaLayanan[pilihanLayanan[i] - 1]);
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
        }
