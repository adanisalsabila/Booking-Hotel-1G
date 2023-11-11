import java.util.Scanner;

/**
 * Login
 */
public class Login {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jenisKamar, superiorRoom, presidentRoom;
        int jumlahKamar, pilihMenu;
        int superiorRoomsAvailable, presidentRoomsAvailable;
      


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
                            System.out.println("Sorry, the selected room is not available. Please choose another room.");
                        }
    
                        System.out.println("Remaining Superior Deluxe Rooms: " + superiorRoomsAvailable);
                        System.out.println("Remaining Devaxa President Rooms: " + presidentRoomsAvailable);
    
                    } while (!isValidRoomType(jenisKamar));
                    break;



    
        Scanner sc01 = new Scanner(System.in);
        int baris, kolom, pilihMenu = 0;
        String nama, next = null;
        String[][] penonton = new String[4][2];

        while (true) {
            System.out.println("=========================");
            System.out.println("Pilih Menu : ");
            System.out.println("1. Input Data Penonton");
            System.out.println("2. Tampilkan Daftar Penonton");
            System.out.println("3. Exit");
            System.out.println("=========================");
            System.out.println("Pilih Menu 1/2/3 : ");

            pilihMenu = sc01.nextInt(); 

            switch (pilihMenu) {
                case 1:
                    do {
                        System.out.println("Masukkan nama: ");
                        nama = sc01.next();
                        System.out.println("Masukkan baris: ");
                        baris = sc01.nextInt();
                        System.out.println("Masukkan kolom: ");
                        kolom = sc01.nextInt();
                        sc01.nextLine(); 

                        if (baris > 0 && baris <= 4 && kolom > 0 && kolom <= 2) {
                            if (penonton[baris - 1][kolom - 1] == null) {
                                penonton[baris - 1][kolom - 1] = nama;
                            } else {
                                System.out.println("Kursi baris " + baris + ", kolom " + kolom + " sudah terisi");
                                System.out.println("Silahkan pilih baris dan kolom lainnya.");
                            }

                            System.out.println("Input penonton lainnya? (y/n) : ");
                            next = sc01.next();
                        } else {
                            System.out.println("Nomor baris/kolom kursi tidak tersedia. Silahkan masukkan nomor yang valid.");
                        }
                    } while (next.equalsIgnoreCase("y"));
                    break;

                case 2:
                    System.out.println("Daftar Penonton");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++) {
                            if (penonton[i][j] != null) {
                                System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": " + penonton[i][j]);
                            } else {
                                 System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": ****");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exit");
                    System.exit(0); 
                    break;

                default:
                    System.out.println("Menu yang Anda pilih tidak valid. Silahkan pilih menu yang lain!");
                    break;
            }
        }
    }
}

        
    }

