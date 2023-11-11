import java.util.Scanner;

/**
 * Login
 */
public class FiturLogIn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jenisKamar, superiorRoom, presidentRoom;
        int jumlahKamar, pilihMenu;
        int superiorRoomsAvailable=0, presidentRoomsAvailable=0;
      


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
                        System.out.println("1. Cek Ketersediaan Kamar");
                        System.out.println("Pilih Jenis Kamar: ");
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
                        jenisKamar = sc.next();
                       
                        if (jenisKamar.equals("1") && superiorRoomsAvailable > 0) {
                            System.out.println("Superior Deluxe Room tersedia. Anda bisa memesannya!");
                            superiorRoomsAvailable--; 
                        } else if (jenisKamar.equals("2") && presidentRoomsAvailable > 0) {
                            System.out.println("Devaxa President Room tersedia. Anda bisa memesannya!");
                            presidentRoomsAvailable--;
                        } else {
                            System.out.println("Maaf, kamar yang Anda pilih tidak tersedia. Silahkan pilih kamar yang lain.");
                        }
    
                        System.out.println("Remaining Superior Deluxe Rooms: " + superiorRoomsAvailable);
                        System.out.println("Remaining Devaxa President Rooms: " + presidentRoomsAvailable);
    
                     } while (jenisKamar.equalsIgnoreCase("y"));
                    break;
                  }
               }
            }
         