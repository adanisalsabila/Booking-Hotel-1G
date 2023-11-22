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
        String namaPemesan;
        String alatTransaksi;
        double pembayaran;
        double totalLayanan = 0.0;
        double totalBiaya;
        double kembalian;
        int jumlahMalam;

        String next;
        boolean gasss;

        int jumlahDewasa, jumlahAnak, jumlahKamar;
        do {
            gasss = false;
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

            pilihMenu = sc.nextInt();

            switch (pilihMenu) {
                case 1:
                    do {
                        System.out.println("Cek Ketersediaan Kamar");
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
                        System.out.println("Do you want to continue checking availability? (Y/N): ");
                        next = sc.nextLine();
                        if (next != "y" | next != "Y") {
                            gasss = true;
                        }
                    } while (next.equalsIgnoreCase("Y"));
                    break;

                case 2:
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
                        System.out.println("Masukkan jumlah kamar yang Anda pesan : ");
                        jumlahKamar = sc.nextInt();
                        System.out.println("Masukkan jumlah orang dewasa : ");
                        jumlahDewasa = sc.nextInt();
                        System.out.println("Masukkan jumlah anak kecil (dibawah 12 tahun): ");
                        jumlahAnak = sc.nextInt();
                        System.out.println("Masukkan jumlah malam Anda menginap : ");
                        jumlahMalam = sc.nextInt();

                    }
                    break;

                case 3:
                    boolean pesanLagi = false;
                    String pesanan = "";

                    do {
                        System.out.println("Menu Makanan:");
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
                    break;

                case 4:
                    System.out.println("\nInfo Contact Person:");

                    String nama = "Hotel Ijen Suites";
                    String telepon = "08123456789";
                    String email = "Ijensuites@gmail.com";

                    System.out.println("Nama: " + nama);
                    System.out.println("Nomor Telepon: " + telepon);
                    System.out.println("Alamat Email: " + email);
                    break;

                case 5:
                    String alamatHotel;
                    int cekLokasiHotel;

                    System.out.println("Selamat datang di Hotel XYZ!");
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
                    break;
                case 6:
                    System.out.println("Masukkan nama Anda: ");
                    String namaPenulis = scanner.nextLine();

                    System.out.println("Masukkan fitur yang ingin Anda kritikkan: ");
                    String kritik = scanner.nextLine();

                    System.out.println("Masukkan saran fitur yang ingin Anda usulkan: ");
                    String saran = scanner.nextLine();

                    System.out.println("\nTerima kasih atas feedback Anda!");
                    System.out.println("Nama: " + namaPenulis);
                    System.out.println("Kritik: " + kritik);
                    System.out.println("Saran: " + saran);
                    break;
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
