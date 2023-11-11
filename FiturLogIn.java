import java.util.Scanner;

public class FiturLogIn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihMenu;
        int[] superiorRoomsAvailable = new int[10];
        int[] presidentRoomsAvailable = new int[10];

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
                    System.out.println("Masukkan jenis kamar yang ingin Anda cek :"+jenisKamar);
 
                    String jenisKamar = sc.next();

                   
                    if (jenisKamar.equals("1") && hasAvailableRoom(superiorRoomsAvailable)) {
                        System.out.println("Superior Deluxe Room tersedia. Anda bisa memesannya!");
                        bookRoom(superiorRoomsAvailable);
                    } else if (jenisKamar.equals("2") && hasAvailableRoom(presidentRoomsAvailable)) {
                        System.out.println("Devaxa President Room tersedia. Anda bisa memesannya!");
                        bookRoom(presidentRoomsAvailable);
                    } else {
                        System.out.println("Maaf, kamar yang Anda pilih tidak tersedia. Silahkan pilih kamar yang lain.");
                    }

                    displayRemainingRooms(superiorRoomsAvailable, "Superior Deluxe");
                    displayRemainingRooms(presidentRoomsAvailable, "Devaxa President");

                    System.out.println("Do you want to continue checking availability? (Y/N): ");
                } while (sc.next().equalsIgnoreCase("Y"));
                break;
        }
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
