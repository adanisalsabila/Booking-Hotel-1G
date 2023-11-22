import java.util.Scanner;

public class testFinalCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int pilihMenu;
        int[] superiorRoomsAvailable = new int[10];
        int[] presidentRoomsAvailable = new int[10];
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
        String namaPemesan = null;
        String alatTransaksi = null;
        double pembayaran = 0.0;
        double totalLayanan = 0.0;
        double totalBiaya = 0.0;
        double kembalian;
        int jumlahMalam = 0;

        String next;
        boolean gasss;
        String keMenu;
        int jumlahDewasa, jumlahAnak, jumlahKamar;
        do {
            gasss = false;
            System.out.println("\n=======================================");
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
            System.out.println("8. Cetak Struk");
            System.out.println("=======================================");
            System.out.println("Pilih Menu 1/2/3/4/5 : ");

            pilihMenu = sc.nextInt();

            switch (pilihMenu) {
                case 1:
                do {
                        //awal penambahan kode case 
                        System.out.println("\nCek Ketersediaan Kamar");
                        System.out.println("========================");
                        System.out.println("Pilih Jenis Kamar: ");
                        System.out.println("========================");
                        System.out.println("1. Superior Deluxe Room");

                        System.out.println("Fasilitas : ");
                        System.out.println("^ Single Bed Regular Size");
                        System.out.println("^ Balcony");
                        System.out.println("^ Pool View");
                        System.out.println("^ Soundproofing");
                        System.out.println("^ Free Wifi");
                        System.out.println("^ Flat-screen TV");
                        System.out.println("^ Private Bathroom");
                        System.out.println("^ Air Conditioning");
                        System.out.println("========================");
                        System.out.println("2. Devaxa President Room");
                        System.out.println("Fasilitas : ");
                        System.out.println("^ Living Room");
                        System.out.println("^ Single Bed King Size");
                        System.out.println("^ Balcony");
                        System.out.println("^ Pool View");
                        System.out.println("^ Soundproofing");
                        System.out.println("^ Free Wifi");
                        System.out.println("^ Flat-screen TV");
                        System.out.println("^ Private Bathroom");
                        System.out.println("^ Air Conditioning");
                        System.out.println("========================");
                        System.out.println("3. Raden Salah Suite");
                        System.out.println("\nRaden Salah Suite");
                        System.out.println("^ Private Suite      ^ 53m²          ^ Air conditioning   ^ Free Wifi\r\n" + //
                                "^ Private bathroom   ^ Flat-screen   ^ Minibar            \r\n" + //
                                "\r\n" + //
                                "Room size : 53 m²\r\n" + //
                                "\r\n" + //
                                "1 extra-large double bed\r\n" + //
                                "comfy beds, 9.5 - Based on 111 reviews\r\n" + //
                                "\r\n" + //
                                "Featuring antique Javanese furniture, this suite has a separate \r\n" + //
                                "living room, an air-conditioned bedroom and en suite bathrooom\r\n" + //
                                "with a bath\r\n" + //
                                "\r\n" + //
                                "Private bathroom :\r\n" + //
                                "^ Free toiletries   ^ Bath or shower\r\n" + //
                                "^ Bathrobe          ^ Slippers\r\n" + //
                                "^ Bidget            ^ Hair dryer\r\n" + //
                                "^ Toilet            ^ Toilet paper\r\n" + //
                                "");
                        System.out.println("Fasilitas : ");
                        System.out.println("^ Living Room");
                        System.out.println("^ Single Bed King Size");
                        System.out.println("^ Balcony");
                        System.out.println("^ Pool View");
                        System.out.println("^ Soundproofing");
                        System.out.println("^ Free Wifi");
                        System.out.println("^ Flat-screen TV");
                        System.out.println("^ Private Bathroom");
                        System.out.println("^ Air Conditioning");
                        System.out.println("========================");
                        System.out.println("=======================================");
                        System.out.println("Masukkan jenis kamar yang ingin Anda cek :");

                        String jenisKamar = sc.next();

                        if (jenisKamar.equals("1") && hasAvailableRoom(superiorRoomsAvailable)) {
                            System.out.println("Superior Deluxe Room tersedia. Anda bisa memesannya!");
                            bookRoom(superiorRoomsAvailable);
                        } else if (jenisKamar.equals("2") && hasAvailableRoom(presidentRoomsAvailable)) {
                            System.out.println("Devaxa President Room tersedia. Anda bisa memesannya!");
                            bookRoom(presidentRoomsAvailable);
                        } else {
                            System.out.println(
                                    "Maaf, kamar yang Anda pilih tidak tersedia. Silahkan pilih kamar yang lain.");
                        }

                        displayRemainingRooms(superiorRoomsAvailable, "Superior Deluxe");
                        displayRemainingRooms(presidentRoomsAvailable, "Devaxa President");
                        sc.nextLine();
                        System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
                        next = sc.nextLine();
                        if (next != "y" | next != "Y") {
                            gasss = true;
                        }
                    
                    } while (next.equalsIgnoreCase("Y"));
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    //batas penambahan kode case 
                    break;

                case 2:
                //awal penambahan kode case 
                    System.out.print("\nMasukkan nama pemesan: ");
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
                    System.out.println("Masukkan jumlah kamar yang Anda pesan : ");
                    jumlahKamar = sc.nextInt();
                    System.out.println("Masukkan jumlah orang dewasa : ");
                    jumlahDewasa = sc.nextInt();
                    System.out.println("Masukkan jumlah anak kecil (dibawah 12 tahun): ");
                    jumlahAnak = sc.nextInt();
                    System.out.println("Masukkan jumlah malam menginap : ");
                    jumlahMalam = sc.nextInt();

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

                    input.nextLine();
                    System.out.print("Masukkan nominal pembayaran: ");
                    pembayaran = input.nextDouble();

                    // Proses perhitungan total biaya
                    totalBiaya = jumlahMalam * selectedRoomPrice + totalLayanan;

                    input.nextLine();

                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
//batas penambahan kode case 
                    break;

                case 3:
                //awal penambahan kode case 
                    boolean pesanLagi = false;
                    String pesanan = "";

                    do {
                        System.out.println("\nMenu Makanan:");
                        System.out.println("1. Chicken Cordon Bleu");
                        System.out.println("2. Mi Ayam");
                        System.out.println("Pilih nomor menu makanan yang ingin Anda pesan: ");
                        int pilihan = scanner.nextInt();

                        switch (pilihan) {

                            case 1:
                                pesanan = "Chicken Cordon Bleu";
                                break;
                            case 2:
                                pesanan = "Mi Ayam";
                                break;
                            default:
                                System.out.println("Menu tidak valid. Silakan pilih kembali.");
                                continue;
                        }

                        System.out.println("Anda memesan: " + pesanan);
                        System.out.print("Apakah Anda ingin memesan lagi? (ya/tidak): ");
                        String jawaban = scanner.next();

                        pesanLagi = jawaban.equalsIgnoreCase("ya");
                    } while (pesanLagi);

                    System.out.println("Terima kasih atas pesanannya!");
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
//batas penambahan kode case 
                    break;

                case 4:
                //awal penambahan kode case 
                    System.out.println("\nInfo Contact Person:");

                    String nama = "Hotel Ijen Suites";
                    String telepon = "08123456789";
                    String email = "Ijensuites@gmail.com";

                    System.out.println("Nama: " + nama);
                    System.out.println("Nomor Telepon: " + telepon);
                    System.out.println("Alamat Email: " + email);
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    //batas penambahan kode case 
                    break;

                case 5:
                //awal penambahan kode case 
                    String alamatHotel;
                    int cekLokasiHotel;

                    System.out.println("\nSelamat datang di Hotel XYZ!");
                    System.out.println("Silakan pilih opsi:");
                    System.out.println("1. Cek Lokasi Hotel");

                    int option = sc.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println(
                                    "===============================================================================");
                            System.out.println(
                                    "Jalan Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116 ");
                            System.out.println(
                                    "===============================================================================");
                            break;
                        default:
                            System.out.println("Opsi tidak valid.");
                    }
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    //batas penambahan kode case 
                    break;
                case 6:
                //awal penambahan kode case 
                    System.out.println("\nMasukkan nama Anda: ");
                    String namaPenulis = scanner.nextLine();

                    System.out.println("Masukkan fitur yang ingin Anda kritikkan: ");
                    String kritik = scanner.nextLine();

                    System.out.println("Masukkan saran fitur yang ingin Anda usulkan: ");
                    String saran = scanner.nextLine();

                    System.out.println("\nTerima kasih atas feedback Anda!");
                    System.out.println("Nama: " + namaPenulis);
                    System.out.println("Kritik: " + kritik);
                    System.out.println("Saran: " + saran);
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    // batas penambahan kode case
                    break;

                case 8:
                    // awal penambahan kode case

                    if (namaPemesan == null && selectedRoomType == null) {
                        System.out.println(
                                "\n===============================================================================");
                        System.out.println("              Silahkan isi data pemesanan kamar terlebih dahulu");
                        System.out.println(
                                "===============================================================================");
                        // Output detail booking
                        gasss = true;
                    }
                    while (namaPemesan != null && selectedRoomType != null) {
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
                        System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                        keMenu = input.nextLine();
                        if (keMenu.equalsIgnoreCase("Y")) {
                            gasss = true;
                        }
                        // batas penambahan kode case
                        break;
                    }

            }
        } while (gasss);
    }

    private static void checkHotelLocation(double latitude, double longitude) {
        System.out.println("Lokasi Hotel:");
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
    }

    private static boolean hasAvailableRoom(int[] roomsAvailable) {
        for (int room : roomsAvailable) {
            if (room == 0) {
                return true;
            }
        }
        return false;
    }

    private static void bookRoom(int[] roomsAvailable) {
        for (int i = 0; i < roomsAvailable.length; i++) {
            if (roomsAvailable[i] == 0) {
                roomsAvailable[i] = 1;
                break;
            }
        }
    }

    private static void displayRemainingRooms(int[] roomsAvailable, String roomType) {
        int remainingRooms = 0;
        for (int room : roomsAvailable) {
            if (room == 0) {
                remainingRooms++;
            }
        }
        System.out.println("Remaining " + roomType + " Rooms: " + remainingRooms);
    }
}
