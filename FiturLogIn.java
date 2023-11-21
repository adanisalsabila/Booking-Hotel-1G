import java.util.Scanner;

public class FiturLogIn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihMenu;
        int[][] roomAvailability = new int[2][10];
        int[] superiorRoomsAvailable = new int[10];
        int[] presidentRoomsAvailable = new int[10];
        int[] jenisKamar = new int[2];
        boolean pesanKamar=true;
        String[] tipeKamar = { "Superior", "Deluxe", "President Suite" };
        double[] hargaPerMalam = { 750000, 500000, 2000000 };
        String[] layananTambahan = { "Extra Bed", "Makanan", null };
        double[] hargaLayanan = { 50000, 100000, 0 };
        int bookRoom;
        
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
                    System.out.println("=======================================");
                
                    System.out.println("Masukkan jenis kamar yang ingin Anda cek :");

                    int selectedRoomType = sc.nextInt();
                    if (selectedRoomType == 1 && hasAvailableRoom(superiorRoomsAvailable)) {
                    System.out.println("Superior Deluxe Room tersedia. Anda bisa memesannya!");
                    bookRoom(superiorRoomsAvailable);
                    } else if (selectedRoomType == 2 && hasAvailableRoom(presidentRoomsAvailable)) {
                    System.out.println("Devaxa President Room tersedia. Anda bisa memesannya!");
                    bookRoom(presidentRoomsAvailable);
                    } else {
                    System.out.println("Maaf, kamar yang Anda pilih tidak tersedia. Silahkan pilih kamar yang lain.");
}
                break; 
            case 2:
            do {
                    System.out.println("Pesan Kamar");
                    System.out.println("Masukkan nama Anda : ");
                    String namaPemesan = sc.next();
                    System.out.println("Masukkan jenis kamar yang Anda pilih : ");
                    jenisKamar = sc.nextLine();
                    System.out.println("Masukkan jumlah kamar yang Anda pesan : ");
                    int jumlahKamar = sc.nextInt();
                    System.out.println("Masukkan jumlah malam Anda menginap : ");
                    int jumlahMalam = sc.nextInt();
            while (pesanKamar) {
                for (int i = 0; i < jenisKamar.length; i++) {
                    System.out.println(i + 1 + ". " + jenisKamar[i] + " - $" + hargaPerMalam[i]);
                }
            }            
                break;
            case 3:
                
                break;
            case 4:
                
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
            System.out.println("===============================================================================");
            System.out.println("Jalan Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116 ");
            System.out.println("===============================================================================");
                break;
            default:
                System.out.println("Opsi tidak valid.");
        }
    }

    private static void checkHotelLocation(double latitude, double longitude) {
        System.out.println("Lokasi Hotel:");
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
    }
}


                break;
            case 6:
                 System.out.println("Masukkan nama Anda: ");
        String nama = scanner.nextLine();

        System.out.println("Masukkan fitur yang ingin Anda kritikkan: ");
        String kritik = scanner.nextLine();

        System.out.println("Masukkan saran fitur yang ingin Anda usulkan: ");
        String saran = scanner.nextLine();

        System.out.println("\nTerima kasih atas feedback Anda!");
        System.out.println("Nama: " + nama);
        System.out.println("Kritik: " + kritik);
        System.out.println("Saran: " + saran);
    }
}
                break;
            case 7:
                
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
        
    }
}
    }
}
