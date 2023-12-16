
import java.util.Scanner;
import java.time.LocalDate;

public class FinalCodeNew {

   // untuk menyimpan dan mendeklarasikan "apakah iya Y/N" (keMenu, next, isCekKamar, isExtraBed), menyimpan username dan password,input kode promo, & menyimpan inofrmasi contact person
static String keMenu, next,isCekKamar, isExtraBed, 
userAdmin, passAdmin,passUser, userUser, inputPromo, alatTransaksi=null,
 nama = "Hotel Ijen Suites", telepon = "08123456789", email = "Ijensuites@gmail.com";

// variabel sementara nama Pemesan
static String tempNamaPemesan;

           
// variabel untuk menyimpan (nama jenis kamar, layanan tambahan, kode PROMO)  dan memberikan jumlah penyimpanan maksimum sebanyak 100(extrabed, namaPemesan, tipe kamar yang dipilih, amenyimpan kode yang sudah digunakan)
static String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" },
            layananTambahan = { "Extra Bed", "Makanan", null },
             kodePromo = { "A", "IJENMALANG", "IJEN11" },
            extraBed = new String[3], namaPemesan = new String[100],
           tipeKamarDipilih = new String[100],
            kodeSudahDigunakan = new String[3], 
            namaPenulis = new String[100], 
            kritik = new String[100],
            saran = new String[100];
 

// variabel untuk menyimpan/deklarasi JUMLAH KAMAR, pilihan (angka 1/2/3/4/5)/ dari menu(), input jumlah (malam ,dewasa, anak kecil, extrabed ), TEMPRORARY VARIABAEL
 static int pilihMenu, pilihanKamar, jenisKamar, pilihExtraBed,
 jumlahDewasa, jumlahAnak = 0, jumlahMalam = 0,jumlahExtraBed,noRekening = 0,
            tempJumlahDewasa, tempJumlahExtraBed, tempJumlahAnak,   
             JML_MASUKAN = 0, NUM_ROOMS = 3, JML_PEMESANAN = 1,SAVE_PEMESANAN[] = new int[100],
             i, sisaKapasitas;

    // static int  lantai = 6;
    
// variabel untuk menyimpan
    static int ID_KAMAR[] = { 1, 2, 3 },   jumlahKamar[] = { 11, 15, 12 }, kamarTersedia[] = new int[3], kamarDipesan[] = new int[3], 
     jumlahKamarDiPesan[] = new int[100],
         pilihanLayanan[] = { 0, 0 }; 
             

//variabel untuk menghitung biaya pemesanan (diskon, layanan dan kamar), juga dipakai untuk menentukan max jumlah variabel
static double[] hargaPerMalam = { 750000, 500000, 2000000 }, hargaKamarDipilih = new double[100],
              totalLayanan = new double[100], hargaLayanan = { 50000, 100000, 0 }, 
            disPromo = { 0.10, 0.15, 0.20 }, totalBiaya = new double[100];

// variabel menyimpan kembalian,diskon, total biaya, pembayaran
static double kembalian, diskon,  totalPemasukan = 0.0,pembayaran = 0.0;

// deklarasi scanner supaya bisa di pakai di seluruh fungsi didalam main dan diluar main
static Scanner input = new Scanner(System.in);

 // variabel boolean untuk mengatur while
    static boolean  menu, menuLogin, menuUser, menuAdmin, menuInformasi,menuEditKamar,menuEditAdmin, isPromo, kodeTidakValid, lanjut;

  // array 2 fasilitas untuk ditampilkan pada hotel,           
    static String[][] fasilitasKamar = {
            { "Single Bed Regular Size", "Balcony ", "Pool View  ", "Soundproofing  ", "Free Wifi  ",
                    "Flat-screen TV  ", "Private Bathroom    ", "Air Conditioning " },
            { "Living Room  ", "Single Bed King Size ", "Balcony   ", "Pool View  ", "Soundproofing", "Free Wifi",
                    "Flat-screen TV", "Private Bathroom ", "Air Conditioning" },
            { "Living Room ", "Private Suite ", "Private bathroom ", "Minibar ", "Living Room",
                    "extra-large double bed", "Balcony", "Pool View", "Soundproofing", "Free Wifi",
                    "Flat-screen TV", "Private Bathroom", "Air Conditioning" }
    };

    //array 1 deklarasi dan memberikan nilai fasilitas hotel
    static String[] fasilitasHotel = { "24 Hour Room Service", "Restaurant", "Smoking Area", "Airport Transfer",
    "Coffee Shop", "Elevator", "Laundry Service / Dry Cleaning", "Business Center", "Concierge",
    "Shuttle Service", "Free Wifi in Room", "Outdoor Swimming Pool", "Fitness Center", "Spa", "Car Parking",
    "Valet Parking", "Garden", "Salon",
    "Doctor on Call 24Hours", "Free Wifi in Lounge", "Drugstore", "Luggage Storage", "Meeting Facilities",
    "Lounge", "Baby Cot", "In-House Guest Clinic", "Tour Desk/Tour Information",
    "Rooftop Bar", "Safety Deposit Boxes", "Rental Wheel Chair", "Kids Pool", "Sauna", "Steam Room", "Jacuzzi",
    "Baby Sitting", "Wi-Fi in public areas", "Massage", "24 Hour Frontdesk",
    "Non Smoking Room", "Lift", "Air Conditioning", "Ironing Service", "Fax/photocopying", "Mosque",
    "Free Welcome Drink", "Rental Car" };

    //data login register
     static String[] usernames = new String[100];
     static String[] passwords = new String[100];
     static boolean[] isAdmin = new boolean[100];
     static int JML_USER = 0;

    // Mendapatkan tanggal hari ini
    static LocalDate today = LocalDate.now();

    public static void main(String[] args) {
        userUser = null;
        passUser = null;
        do {

            menu = true;
            // 13. nomor kamar , ada 6 lantai
            System.out.println("\n=======================================");
            System.out.println("Selamat Datang di Ijen Suites Hotel!");
            tanggalHariIni(today);
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu : ");
            System.out.println("1. Login");
            System.out.println("2. Pesan kamar");
            System.out.println("3. Deskripsi Hotel");
            System.out.println("4. Fasilitas Hotel");
            System.out.println("5. Lokasi Hotel");
            System.out.println("6. Contact Person");
            System.out.println("0. Exit");
            System.out.println("=======================================");
            System.out.print("+==> Pilih Menu : ");
            pilihMenu = input.nextInt();
            System.out.println("=======================================");
            input.nextLine();

            switch (pilihMenu) {
                case 1:
                menulogin(args);
                break;
                case 2:
                pesanKamar();
                break;
                case 3:
                pesanKamar();
                break;
                case 4:
             //   fasilitasHotel();
               System.out.println("\n=======================================");
               System.out.println("=           Fasilitas Hotel :         =");
               System.out.println("=======================================");
               System.out.println();
                    for (int j = 0; j < fasilitasHotel.length; j++) {
                        System.out.println("= ^ "+ fasilitasHotel[j]);
                    
                    if (j == (fasilitasHotel.length/10))
                    System.out.println("Tekan enter unutk lanjut");
                    input.nextLine();
                }
                break;
                case 5:
                lokasiHotel();
                break;
                 case 6:
                contactPerson(nama, email, telepon);
                break;
                 case 0:
                 menu = false;
                break;
                default:
                 System.out.println("\nInput salah!");
               
                break;

            }
        } while (menu);

       
    }

    // fungsi fitur main menu login
     public static void menulogin(String[] args) {

       do {
            menuLogin = true;
               System.out.println("\n=======================================");
            System.out.println("=              Menu Login :           =");
            System.out.println("=======================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Kembali");
            System.out.println("=======================================");
            System.out.print("+==> Pilih Menu :");
            int pilihMenu = input.nextInt();
            input.nextLine();

            switch (pilihMenu) {
                case 1:
                    login(args);
                    break;
                case 2:
                    register();
                    break;
                case 0:
                    menuLogin=false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih kembali.");
                    break;
            }
        } while (menuLogin);
    }

    public static void login(String[] args) {
        clearScreen();
          System.out.println("\n===============================");
            System.out.println("=             Login :         =");
            System.out.println("===============================");
            System.out.print("Masukkan username : ");
             String username = input.next();
            System.out.print("Masukkan password : ");
           String password = input.next();
     
           //boolean apakah sudah masuk
        boolean isLoggedIn = false;

        //boolean apakah admin sudah masuk
        boolean isAdminUser = false;

        for (int i = 0; i < JML_USER; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                isLoggedIn = true;
                isAdminUser = isAdmin[i];
                break;
            }
        }

        if (isLoggedIn) {
            if (isAdminUser) {
                 System.out.println("\n===============================");
                System.out.println("=     Login Admin Berhasil    =");
                System.out.println("===============================");
                System.out.println();
                // Tambahkan logika menu admin di sini
                menuAdmin(args);
            } else {
                 System.out.println("\n===============================");
                System.out.println("=     Login User Berhasil    =");
                System.out.println("===============================");
                System.out.println();
                // Tambahkan logika menu user di sini
                menuUser(args);
            }
        } else {
            System.out.println("\n== Username atau password salah. Silakan coba lagi. ==");
        }
    }

    public static void register() {
        if (JML_USER < usernames.length) {
            System.out.println("\n===============================");
            System.out.println("=             Register :         =");
            System.out.println("===============================");
           System.out.print("Masukkan username baru : ");
             String newUsername = input.next();
           

            // Check if the username is already taken
            boolean isUsernameTaken = false;
            for (int i = 0; i < JML_USER; i++) {
                if (usernames[i].equals(newUsername)) {
                    isUsernameTaken = true;
                    break;
                }
            }

            if (isUsernameTaken) {
                System.out.println("\n== Username sudah terdaftar. Silakan pilih username lain. ==");
            } else {
                System.out.print("Masukkan password baru : ");
                String newPassword = input.next();
                System.out.print("Apakah user ini admin? (true/false) : ");
                boolean isAdminUser = input.nextBoolean();

                // Simpan username, password, dan status admin baru
                usernames[JML_USER] = newUsername;
                passwords[JML_USER] = newPassword;
                isAdmin[JML_USER] = isAdminUser;
                JML_USER++;

                System.out.println("\n== Registrasi berhasil! ==");
            }
        } else {
            System.out.println("\n== Maaf, jumlah user sudah mencapai batas maksimal. ==");
        }
    }

// fungsi halaman menu user

     public static void menuUser(String[] args) {
                do {
                    menuUser = true;
                    System.out.println("\n=======================================");
                    System.out.println("Selamat Datang di Ijen Suites Hotel!");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu : ");           
                     System.out.println("1. Detail Kamar");
                    System.out.println("2. Pesan & Cek Kamar ");
                    // System.out.println("3. Pesan Layanan Tambahan (Makanan/Extra Bed/Sewa Aula)");
                    System.out.println("3. Reservasi Gedung");
                    System.out.println("4. Kritik dan Saran");
                    System.out.println("5. Informasi Hotel");
                    System.out.println("6. Cetak Struk ");
                    System.out.println("0. Logout");
                    System.out.println("=======================================");
                    System.out.print("+==> Pilih Menu : ");
                    pilihMenu = input.nextInt();
                    System.out.println("=======================================");
                    input.nextLine();

                    switch (pilihMenu) {
                        case 1:
                            rincianKamar();
                            break;
                        case 2:
                            pesanKamar();
                            break;
                        case 3:
                              reservasiGedung();
                             break;
                        case 4:
                              kritikDanSaran();
                                break;
                        case 5:
                               informasiHotel();
                                  break;
                        case 6:
                                cetakStruk();
                                       break;                           
                        case 0:
                            JML_PEMESANAN = 1;
                            main(args);
                            break;
                           default:
                 System.out.println("\nInput salah!");
                
                            break;
                        }
                } while (menuUser);
               
           
    }
// fitur reservasi gedung hotel
public static void reservasiGedung(){

}
public static void informasiHotel()
    {
         do {

            menuInformasi = true;
            // 13. nomor kamar , ada 6 lantai
            System.out.println("\n=======================================");
            System.out.println("=            Informasi Hotel:          ");
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu : ");
            System.out.println("1. Deskripsi Hotel");
            System.out.println("2. Fasilitas Hotel");
            System.out.println("3. Lokasi Hotel");
            System.out.println("4. Contact Person");
            System.out.println("0. Kembali");
            System.out.println("=======================================");
            System.out.print("+==> Pilih Menu : ");
            pilihMenu = input.nextInt();
            System.out.println("=======================================");
            input.nextLine();

            switch (pilihMenu) {
                case 1:
               // deskripsiHotel();
                System.out.println("Keterangan :\r\n" + //
                        "Ijen Suites Resort & Convention Hotel menawarkan suasana luar biasa baik bagi pelancong bisnis maupun rekreasi di Malang."+
                        "\nDengan kombinasi desain resor dan fasilitas konvensi, Ijen Suites Resort & Convention Hotel adalah pilihan tepat untuk kebutuhan acara dan akomodasi Anda."+
                        "\nTerletak di salah satu kawasan paling bergengsi di Malang, Ijen Nirwana Residence, Ijen Suites Resort & Convention Hotel dikelilingi oleh banyak fasilitas untuk menunjang kebutuhan para tamu."+
                        " Mall Olympic Garden yang menyediakan pusat perbelanjaan, minimarket, pusat kuliner, dan ATM hanya berjarak sepelemparan batu dari Ijen Suites Resort & Convention Hotel.");
                break;
                case 2:
                pesanKamar();
                break;
                 case 3:
                lokasiHotel();
                case 4:
                contactPerson(nama, email, telepon);
                break;
                 case 0:
                 menu = false;
                break;
                default:
                 System.out.println("\nInput salah!");
                
                break;

            }
        } while (menuInformasi);

 
    }


    // funsi halaman menu admin
    public static void menuAdmin(String[] args) {
        

                do {
                    menuAdmin = true;
                    System.out.println("\n=======================================");
                    System.out.println("Selamat Datang di Menu Admin");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu : ");
                    System.out.println("1. Edit Kamar");//ketersediaan kamar
                    System.out.println("2. Edit Admin");
                    System.out.println("3. Edit Contact Person"); // tidak usah input nama
                    System.out.println("4. Edit Lokasi Hotel");
                    System.out.println("5. Edit Fasilitas Hotel");
                    System.out.println("6. Lihat Kritik dan Saran");
                    System.out.println("7. Lihat & Edit Laporan");
                    System.out.println("00. Logout");
                    System.out.println("=======================================");
                    System.out.print("+==> Pilih Menu : ");
                    pilihMenu = input.nextInt();
                    input.nextLine();

                    switch (pilihMenu) {
                        case 1:
                            menuEditKamar();
                            break;
                        case 2:
                            menuEditAdmin();
                             break;
                        case 3:
                            editContactPerson();
                            break;
                        case 4:
                            //editLokasi();
                             break;
                        case 5:
                            //editFasilitas();
                             break;
                        case 6:
                            lihatKritikSaran();
                            break;
                        case 7:
                            fiturLaporan();
                            break;
                        case 0:
                            userAdmin = null;
                            userUser = null;
                            main(args);
                            break;
                        default:
                            System.out.println("\n== Input Salah ");
                            break;
                    }
                } while (menuAdmin);
            
            input.nextLine();
       
    }

    public static void menuEditKamar(){
        do {
            
       menuEditKamar = true;
           System.out.println("\n=======================================");
                    System.out.println("=            Edit Kamar :             =");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu : ");
                    System.out.println("1. Tambah Kamar");
                    System.out.println("2. perbarui kamar");
                     System.out.println("0. Kembali");
                    System.out.println("=======================================");
                    System.out.print("+==> Pilih Menu : ");
                    int pilihMenu = input.nextInt();
                    input.nextLine();
                    switch (pilihMenu) {
                        case 1:
                            tambahJenisKamar();                          
                            break;
                        case 2:
                            editKetersediaanKamar();
                            break;
                        case 0:
                            menuEditKamar =false;
                            break;                            
                        default:
                            System.out.println("== inputan salah. ==");
                             
                            break;
                    }
                     } while (menuEditKamar);
    }

    public static void menuEditAdmin(){
        do {
            
      menuEditAdmin = false;
           System.out.println("\n=======================================");
                    System.out.println("=            Edit Admin :             =");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu : ");
                    System.out.println("1. Tambah Admin");
                    System.out.println("2. perbarui Admin");
                     System.out.println("0. Kembali");
                    System.out.println("=======================================");
                    System.out.print("+==> Pilih Menu : ");
                    int pilihMenu = input.nextInt();
                    input.nextLine();
                    switch (pilihMenu) {
                        case 1:
                            // tambahAdmin();                          
                            break;
                        case 2:
                            // perbaruiAdmin();
                            break;
                        case 0:
                            menuEditAdmin = false;
                            break;                            
                        default:
                            System.out.println("== inputan salah. ==");
                             
                            break;
                    }
                     } while (menuEditAdmin);
    }
    // fungsi bukan fitur utama dibawah ini
    
        public static void clearScreen() {
            // Menggunakan ANSI escape code untuk menghapus layar
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
    
            // Sisipkan kode program atau logika lain di sini
        }
  
    

    static void tanggalHariIni(LocalDate today) {

        // Menampilkan tanggal hari ini
        System.out.println("              " + today);
    }

    static void tekanEnterKembaliKeMain(String[] args) {
        System.out.println("\nTekan Enter untuk kembali. ");
        input.nextLine();
        main(args);
    }

    static boolean tekanEnterKembaliKeMenu() {
        System.out.println("\nTekan Enter untuk kembali. ");
        input.nextLine();
        menu = true;
        return menu;
    }

    static boolean tekanEnterKembaliKeSebelumnya() {
        System.out.println("\nTekan Enter untuk kembali. ");
        input.nextLine();
        lanjut = true;
        return lanjut;
    }

    static boolean isKembaliKeMenu(String param) {
        if (param.equalsIgnoreCase("Y")) {
            menu = true;
        }
        return menu;
    }

    public static void InvalidCetakStruk(String[] param1, String[] param2) {

        if (param1[JML_PEMESANAN - 1] == null && param2[JML_PEMESANAN - 1] == null) {

            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan isi data pemesanan kamar terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();

        }

    }

    public static void fiturPromo() {

        lanjut = false;
        System.out.println("Apakah anda ingin memasukkan kode promo? (Y/N)");
        keMenu = input.nextLine();
        if (keMenu.equalsIgnoreCase("Y")) {
            do {
                lanjut = false;
                System.out.println("=================================================");
                System.out.print("= Masukkan kode promo : ");
                inputPromo = input.nextLine();
                System.out.println("=================================================");
                isPromo = false;
                for (int i = 0; i < disPromo.length; i++) {
                    if (inputPromo.equals(kodePromo[i])) {
                        if (inputPromo.equals(kodeSudahDigunakan[i])) {
                            kodeTidakValid = true;
                            break;
                        }
                        isPromo = true;
                        diskon = (1 - disPromo[i]);
                        kodeSudahDigunakan[i] = kodePromo[i];
                        break;
                    }
                }

                if (isPromo) {
                    System.out.println("Selamat, anda mendapatkan diskon sebesar " + (diskon * 100) + "%!");

                } else if (kodeTidakValid) {
                    System.out.println("\n==            Kode sudah digunakan.          ==");
                } else {
                    kodeTidakValid = true;
                    System.out.println("\n==            Kode promo tidak valid.          ==");
                }
                if (kodeTidakValid) {
                    do {
                        kodeTidakValid = false;
                        System.out.println("\n=================================================");
                        System.out.println("       Apakah anda ingin mencoba lagi? (Y/N)   ");
                        System.out.print("+==> ");
                        keMenu = input.nextLine();
                        if (keMenu.equalsIgnoreCase("Y")) {
                            lanjut = true;
                        } else if (keMenu.equalsIgnoreCase("N")) {

                        } else {
                            System.out.println("    Input tidak valid.");
                            kodeTidakValid = true;
                        }
                    } while (kodeTidakValid);
                }

            } while (lanjut);
            // Proses perhitungan total biaya setelah mendapatkan diskon
            totalBiaya[JML_PEMESANAN - 1] = ((jumlahKamarDiPesan[JML_PEMESANAN - 1] * jumlahMalam * hargaKamarDipilih[JML_PEMESANAN - 1])
                    + totalLayanan[JML_PEMESANAN - 1]) * diskon;

            System.out.println("==  Total Biaya (Setelah Diskon): " + totalBiaya[JML_PEMESANAN - 1]);
        } else if (keMenu.equalsIgnoreCase("N")) {

        } else {
            System.out.println("    Input tidak valid.");
            kodeTidakValid = true;
        }

    }

    public static void fiturJmlDewasaAnak() {
        do {
            lanjut = false;
            sisaKapasitas = 0;

            System.out.println("==========================================");
            System.out.print("= Masukkan jumlah orang dewasa : ");
            // max 1 =2;
            tempJumlahDewasa = input.nextInt();
            if (tempJumlahDewasa <= (sisaKapasitas + (jumlahKamarDiPesan[JML_PEMESANAN - 1] * 2))) {
                jumlahDewasa = tempJumlahDewasa;
                sisaKapasitas += ((jumlahKamarDiPesan[JML_PEMESANAN - 1]) * 2 + (1 * jumlahKamarDiPesan[JML_PEMESANAN - 1])) - jumlahDewasa;
            } else {
                System.out.println(
                        "=== Jumlah orang dewasa melebihi kapasitas kamar, silahkan menambah kamar/extra bed ==");
                input.nextLine();
                System.out.println("==========================================");
                System.out.println("= apakah anda ingin menambahkan extra bed (Y/N)");
                System.out.print("+==> ");
                isExtraBed = input.nextLine();

                if (isExtraBed.equalsIgnoreCase("Y")) {
                    System.out.println("==========================================");
                    System.out.println("1. Folding Extra Bed");
                    System.out.println("2. Standing Extra Bed");
                    System.out.println("3. Baby Cot ");
                    System.out.println("==========================================");
                    do {
                        lanjut = false;

                        System.out.print("Silahkan pilih jenis extra bed (1/2/3) : ");
                        pilihExtraBed = input.nextInt();
                        if (pilihExtraBed > 3 || pilihExtraBed == 0) {
                            System.out.println("==========================================");
                            System.out.println("Innput salah.");
                            lanjut = true;
                        }
                    } while (lanjut);
                    do {
                        lanjut = false;
                        System.out.println("= Input jumlah extrabed (max 1/kamar)");
                        tempJumlahExtraBed = input.nextInt();
                        if (jumlahExtraBed <= jumlahKamarDiPesan[JML_PEMESANAN - 1] && jumlahExtraBed != 0) {
                            jumlahExtraBed = tempJumlahExtraBed;
                        } else {
                            System.out.println("==========================================");
                            System.out.println("= Jumlah tidak boleh 0 / melebihi kamar yang dipesan");
                            lanjut = true;
                        }
                    } while (lanjut);
                    input.nextLine();
                    switch (pilihExtraBed) {
                        case 1:
                            sisaKapasitas += 2 * jumlahExtraBed;
                            extraBed[pilihExtraBed] = "Folding Extra Bed";
                            break;

                        case 2:
                            sisaKapasitas += 2 * jumlahExtraBed;
                            extraBed[pilihExtraBed] = "Standing Extra Bed";
                            break;

                        case 3:

                            sisaKapasitas += 0;
                            extraBed[pilihExtraBed] = "Baby Cot (untuk bayi)";
                            break;

                        default:
                            break;
                    }
                }
                lanjut = true;
            }
        } while (lanjut);
        do {
            lanjut = false;
            System.out.println("==========================================");
            System.out.print("= Masukkan jumlah anak kecil (< 12 tahun, tidak termasuk bayi) : ");
            // dewasa + kecil <=3;
            tempJumlahAnak = input.nextInt();
            if (tempJumlahAnak <= sisaKapasitas) {
                jumlahAnak = tempJumlahAnak;
            } else {
                System.out.println("==========================================");
                System.out.println("=== Jumlah anak melebihi kapasitas kamar ===");
                input.nextLine();
                System.out.println("==========================================");
                System.out.println("= apakah anda ingin menambahkan extra bed (Y/N)");
                System.out.print("+==> ");
                isExtraBed = input.nextLine();

                if (isExtraBed.equalsIgnoreCase("Y")) {
                    System.out.println("==========================================");
                    System.out.println("1. Folding Extra Bed");
                    System.out.println("2. Standing Extra Bed");
                    System.out.println("3. Baby Cot ");
                    System.out.println("==========================================");
                    System.out.print("Silahkan pilih jenis extra bed (1/2/3) : ");
                    jumlahExtraBed = input.nextInt();
                    input.nextLine();
                    System.out.println("==========================================");
                    switch (jumlahExtraBed) {
                        case 1:
                            sisaKapasitas += 2;
                            extraBed[jumlahExtraBed] = "Folding Extra Bed";
                            break;

                        case 2:
                            sisaKapasitas += 2;
                            extraBed[jumlahExtraBed] = "Standing Extra Bed";
                            break;

                        case 3:

                            sisaKapasitas += 0;
                            extraBed[jumlahExtraBed] = "Baby Cot (untuk bayi)";
                            break;

                        default:
                            break;
                    }
                }
                if (isExtraBed.equalsIgnoreCase("N")) {
                    lanjut = true;
                }
            }

        } while (lanjut);
    }

    // fungsi fitur halaman utama bukan admin dibawah ini
    public static void rincianKamar() {

       System.out.println("\n==============================");
        System.out.println("==      :Rincian Kamar:     ==");
        System.out.println("==============================");

        System.out.println("\n=====:Pilih Jenis Kamar:=====");
        System.out.println();
        System.out.println("==============================");
        System.out.println("== 1. Superior Deluxe Room  ==");
        System.out.println("==============================");
        System.out.println("== 2. Devaxa President Room ==");
        System.out.println("==============================");
        System.out.println("== 3. Raden Salah Suite     ==");
        System.out.println("==============================");
        System.out.println();
        do {
            lanjut = false;
            do {
                lanjut = false;
                System.out.println("==========================================");
                System.out.println("Masukkan jenis kamar yang ingin Anda lihat :");
                System.out.println("==========================================");
                System.out.print("+==> ");
                jenisKamar = input.nextInt();
                // Meminta pengguna memasukkan jenis kamar yang ingin dicek
                if (jenisKamar > NUM_ROOMS) {
                    System.out.println("Inputan melebihi jumlah jenis kamar");
                    lanjut = true;
                }
            } while (lanjut);
            if ((jenisKamar) <= NUM_ROOMS) {
                // menampilkan jenis kamar
               fungsiFasilitasHotel();

            } else {
                System.out.println();
                System.out.println("== Data tidak ada, inputan salah. ==");
                System.out.println();
            }
jenisKamar=0;
            input.nextLine();
            System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
            next = input.nextLine();
            if (next != "y" | next != "Y") {
                menu = true;
            }
        } while (next.equalsIgnoreCase("Y"));
    }

    public static void cekKetersediaan() {

        System.out.println("Apakah anda ingin mengecek ketersediaan kamar dahulu ? (Y/N)");
        System.out.print("+==> ");
        isCekKamar = input.nextLine();
        if (isCekKamar.equalsIgnoreCase("y")) {

            System.out.println("\n==============================");
            System.out.println("== :Cek Ketersediaan Kamar: ==");
            System.out.println("==============================");

            System.out.println("\n=====:Pilih Jenis Kamar:=====");
            System.out.println();
            System.out.println("==============================");
            System.out.println("== 1. Superior Deluxe Room  ==");
            System.out.println("==============================");
            System.out.println("== 2. Devaxa President Room ==");
            System.out.println("==============================");
            System.out.println("== 3. Raden Salah Suite     ==");
            System.out.println("==============================");
            System.out.println();
            do {
                menu = false;
                do {
                    lanjut = false;
                    System.out.println("=========================================");
                    System.out.println("Masukkan jenis kamar yang ingin Anda cek :");
                    System.out.println("=========================================");
                    jenisKamar = input.nextInt();

                    // Meminta pengguna memasukkan jenis kamar yang ingin dicek
                    if (jenisKamar > NUM_ROOMS || jenisKamar == 0) {
                        System.out.println("Inputan melebihi jumlah jenis kamar");
                        lanjut = true;
                    }
                } while (lanjut);

                // jumlahKamarDiPesan+=jumlahKamarDiPesan;
                kamarDipesan[jenisKamar - 1] = jumlahKamarDiPesan[JML_PEMESANAN - 1];
                // Menghitung jumlah kamar yang tersedia

                kamarTersedia[jenisKamar - 1] = jumlahKamar[jenisKamar - 1] - kamarDipesan[jenisKamar - 1];

                // Mengecek ketersediaan kamar
                if (kamarTersedia[jenisKamar - 1] > 0) {
                    System.out
                            .println("== Tersedia " + kamarTersedia[jenisKamar - 1] + " kamar "
                                    + tipeKamar[jenisKamar - 1]
                                    + ". ==");
                } else {
                    System.out.println("Maaf, kamar " + tipeKamar[jenisKamar - 1] + " tidak tersedia.");
                }
                input.nextLine();
                System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
                System.out.print("+==> ");
                next = input.nextLine();

                // if (next != "y" | next != "Y") {
                // lanjut = true;
                // }
            } while (next.equalsIgnoreCase("Y"));
        }

    }

    public static void pesanKamar() {
        diskon = 1;
        if (usernames[i] == null && passwords[i] == null) {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan Login User terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();

        }

        if (userUser != null && passUser != null) {
            do {
                lanjut = false;
                // awal penambahan kode case
                System.out.println("\n=================================================");
                System.out.println("==                Pesan Kamar:                 ==");
                System.out.println("=================================================");

                cekKetersediaan();

                do {
                    lanjut = false;
                    System.out.println("print save id " + SAVE_PEMESANAN[0]);

                    System.out.println("print id " + JML_PEMESANAN);
                    System.out.println("=================================================");
                    System.out.print("= Masukkan nama pemesan: ");
                    tempNamaPemesan = input.nextLine();
                    if (namaPemesan[JML_PEMESANAN - 1] == null) {
                        namaPemesan[JML_PEMESANAN - 1] = tempNamaPemesan;
                        SAVE_PEMESANAN[JML_PEMESANAN - 1] = JML_PEMESANAN;
                        System.out.println("=================================================");
                    } else {
                        lanjut = true;
                    }

                } while (lanjut);
                // Memilih tipe kamar
                do {

                    lanjut = true;
                    System.out.println("print save id " + SAVE_PEMESANAN[0]);

                    System.out.println("= Pilih tipe kamar: ");
                    for (int i = 0; i < tipeKamar.length; i++) {
                        System.out.println("=  " + (i + 1) + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
                    }

                    System.out.println("=================================================");
                    System.out.print("= Masukkan angka untuk memilih : ");

                    pilihanKamar = input.nextInt();

                    System.out.println("=================================================");

                    if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                        kamarDipesan[pilihanKamar - 1] = jumlahKamarDiPesan[JML_PEMESANAN - 1];
                        kamarTersedia[pilihanKamar - 1] = jumlahKamar[pilihanKamar - 1]
                                - kamarDipesan[pilihanKamar - 1];

                        if (kamarTersedia[pilihanKamar - 1] == 0) {
                            System.out.println("Maaf kamar tidak tersedia, silahkan pilih kembali");

                        }
                       tipeKamarDipilih[JML_PEMESANAN - 1] = tipeKamar[pilihanKamar - 1];
                        hargaKamarDipilih[JML_PEMESANAN - 1] = hargaPerMalam[pilihanKamar - 1];
                        lanjut = false;
                    } else {
                        System.out.println("Inputan salah");
                        System.out.println("=================================================");
                    }
                } while (lanjut);

                do {

                    lanjut = true;
                    System.out.print("= Masukkan jumlah kamar yang Anda pesan : ");
                    jumlahKamarDiPesan[JML_PEMESANAN - 1] = input.nextInt();
                    if (jumlahKamarDiPesan[JML_PEMESANAN - 1] <= kamarTersedia[pilihanKamar - 1]) {
                        // do {
                        // //membuat nomor kamar hotel
                        // lanjut=false;
                        // for (int i = 0; i < lantai; i++) {
                        // //nomor kamar[id] = pilihankamar*100+jumlahKamarDiPesan;
                        // // if nomor kamar[id2] < nomor kamar[id];
                        // // nomor kamar [id2min] = nomor kamar[id] + 1
                        // // nomor kamar [id2max] = nomor kamar [id]+1 + jumlahKamarDipesan;
                        // }
                        // id++;
                        // } while (lanjut);
                        lanjut = false;
                    } else {

                        System.out.println("=================================================");
                        System.out.println("Kamar yang dipesan melebihi yang kamar yang tersedia");
                        System.out.println("=================================================");
                    }

                } while (lanjut);
                fiturJmlDewasaAnak();

                System.out.println("=================================================");
                System.out.print("= Masukkan jumlah malam menginap : ");
                jumlahMalam = input.nextInt();

                System.out.println("=================================================");
                System.out.println("= Pilih layanan tambahan :");
                for (int i = 0; i < layananTambahan.length; i++) {
                    if (layananTambahan[i] != null)
                        System.out.println("=  " + (i + 1) + ". " + layananTambahan[i] + " - $" + hargaLayanan[i]);

                }
                System.out.println("=  3. skip");

                input.nextLine(); // membersihkan buffer

                System.out.println("=================================================");
                int i = 0;
                do {
                    if (i < layananTambahan.length - 1) {
                        lanjut = true;
                        System.out.print("= Masukkan angka untuk memilih : ");

                        pilihanLayanan[i] = input.nextInt();
                        if (pilihanLayanan[i] > layananTambahan.length || pilihanLayanan[i] == 0) {
                            System.out.println("input salah");
                            System.out.println("=================================================");
                        }
                        System.out.println("=================================================");

                        if (pilihanLayanan[i] == 3) {
                            lanjut = false;
                        }
                        totalLayanan[JML_PEMESANAN - 1] += hargaLayanan[pilihanLayanan[i] - 1];

                        input.nextLine();
                        i++;

                    } else {
                        break;
                    }
                } while (lanjut);

                // hitung sebelum mendapatkan diskon
                totalBiaya[JML_PEMESANAN - 1] = (jumlahKamarDiPesan[JML_PEMESANAN - 1] * jumlahMalam * hargaKamarDipilih[JML_PEMESANAN - 1])
                        + totalLayanan[JML_PEMESANAN - 1];

                System.out.println("==          Total Biaya: " + totalBiaya[JML_PEMESANAN - 1]);
                // proses in put promo dan berhitungan biaya
                fiturPromo();

                // input jumlah malam, allat transaksi, nominal pembayaran
                do {

                    lanjut = false;

                    System.out.println("=================================================");
                    System.out.print("= Masukkan alat transaksi (cc/cash): ");
                    alatTransaksi = input.nextLine();
                    if (alatTransaksi.equalsIgnoreCase("cc")) {
                        System.out.println("=================================================");
                        System.out.print("= Masukkan no rekening anda: ");

                        noRekening = input.nextInt();
                        input.nextLine();

                    } else if (alatTransaksi.equalsIgnoreCase("cash")) {

                    } else {
                        System.out.println("=================================================");
                        System.out.println("Metode pembayaran tidak tersedia.");
                        lanjut = true;
                    }
                } while (lanjut);

                do {
                    lanjut = false;
                    System.out.println("=================================================");
                    System.out.print("= Masukkan nominal pembayaran: ");

                    pembayaran = input.nextDouble();

                    // Proses pembayaran
                    if (pembayaran >= totalBiaya[JML_PEMESANAN - 1]) {
                        kembalian = pembayaran - totalBiaya[JML_PEMESANAN - 1];

                        System.out.println("=================================================");
                        System.out.println("== Pembayaran diterima. Kembalian: Rp" + kembalian);
                        System.out.println("=================================================");
                        System.out.println("\n=================================================");
                        System.out.println("= Silahkan Cetak struk untuk konifrmasi pesanan =");
                        System.out.println("=================================================");

                    } else {

                        System.out.println("=================================================");
                        System.out.println("\nPembayaran tidak mencukupi. Silakan bayar sesuai total biaya.");
                        System.out.println();
                        lanjut = true;
                    }
                } while (lanjut);
                input.nextLine();

                do {
                    kodeTidakValid = false;
                    System.out.println("\n=================================================");
                    System.out.println("== Apakah anda sudah yakin dengan pesanan anda? (Y/N) ==");
                    System.out.print("+==> ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        input.nextLine();
                        System.out.println("\n=================================================");
                        System.out.println("\n ==== Terima kasih telah melakukan booking! ==== ");
                        JML_PEMESANAN++;
                        tekanEnterKembaliKeSebelumnya();
                        break;
                    } else if (keMenu.equalsIgnoreCase("N")) {
                        lanjut = true;
                        namaPemesan[JML_PEMESANAN - 1] = null;
                        totalBiaya[JML_PEMESANAN - 1] = 0;
                        kodeSudahDigunakan[i] = null;

                    } else {
                        System.out.println("    Input tidak valid.");
                        kodeTidakValid = true;
                    }
                } while (kodeTidakValid);
                // tekanEnterKembaliKeMenu();
                // lanjut = true;

                // batas penambahan kode case
            } while (lanjut);
        }

    }

    public static void pesanLayananTambahan() {
        boolean pesanLagi, pesanMenu;

        String pesanan = "";
        if (userUser != null && passUser != null) {

            do {
                pesanLagi = false;

                System.out.println("\n=========================================");
                System.out.println("===           Menu Makanan:           ===");
                System.out.println("=========================================");
                System.out.println("= 1. Chicken Cordon Bleu                =");
                System.out.println("=========================================");
                System.out.println("= 2. Mi Ayam                            =");
                System.out.println("=========================================");
                do {
                    pesanMenu = false;
                    System.out.println("\nPilih menu makanan yang ingin Anda pesan: ");
                    System.out.print("+==> ");
                    int pilihan = input.nextInt();

                    switch (pilihan) {

                        case 1:
                            pesanan = "Chicken Cordon Bleu";
                            break;
                        case 2:
                            pesanan = "Mi Ayam";
                            break;
                        default:
                            System.out.println("\n Menu tidak valid. Silakan pilih kembali.");
                            pesanMenu = true;
                    }
                } while (pesanMenu);
                System.out.println("\n=========================================");
                System.out.println("==  Anda memesan:" + pesanan);
                System.out.println("=========================================");
                System.out.println("\nApakah Anda ingin memesan lagi? (Y/N): ");
                String jawaban = input.next();

                pesanLagi = jawaban.equalsIgnoreCase("Y");
                if (jawaban != "y" | jawaban != "Y") {
                    menu = true;
                }

            } while (pesanLagi);
            System.out.println("\n === Terima kasih atas pesanannya! ===");
        } else {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan Login User terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();

        }

        // batas penambahan kode case
    }

    public static void contactPerson(String nama, String email, String telepon) {
        System.out.println("\n======================================");
        System.out.println("===        Contact Person:         ===");
        System.out.println("======================================");
        System.out.println("= Nama: " + nama + "            =");
        System.out.println("======================================");
        System.out.println("= Nomor Telepon: " + telepon + "         =");
        System.out.println("======================================");
        System.out.println("= Alamat Email: " + email + " =");
        System.out.println("======================================");

        tekanEnterKembaliKeMenu();
        // batas penambahan kode case

    }

    public static void lokasiHotel() {
        do {

            System.out.println("\n=================================");
            System.out.println("===       Lokasi Hotel:       ===");
            System.out.println("\n=================================");
            System.out.println("      Silakan pilih opsi:        ");
            System.out.println("=================================");
            System.out.println("= 1. Cek Lokasi Hotel           =");
            System.out.println("=================================");
            System.out.println("= 2. Tempat Terdekat dari hotel =");
            System.out.println("=================================");
            System.out.print("+==>  ");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.println(
                            "=================================================================================");

                    System.out.println(
                            "= Jalan Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116 =");

                    System.out.println(
                            "=================================================================================");

                    break;
                    case 2:
                     System.out.println(
                            "=================================================================================");
                    System.out.println("==                              Dekat dengan :                                 ==");
                    System.out.println("=================================================================================");
                    System.out.println("= ^ Pusat perbelanjaan :  Mall Olympic Garden ");
                    System.out.println("\n^ Transportasi : Malang (MLG-Abdul Rachman Saleh) - 41 mnt berkendara\r\n" + //
                                         "               Stasiun Kereta Malang - 12 mnt berkendara");
                    System.out.println("\n^ Tempat Makan :Amstirdam Coffee Mergan - 4 mnt jalan kaki\r\n" + //
                            "              Tahu Telor Jeng Anis - 4 mnt jalan kaki\r\n" + //
                            "              Subur Pork Meatball - 5 mnt jalan kaki\r\n" + //
                            "              Warung Subuh - 9 mnt jalan kaki\r\n" + //
                            "              Rujak Manis Ananas \"Pak Bejo - 4 mnt jalan kaki");
                   
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
   break;
            }
System.out.println("\nApakah anda ingin input kembali (Y/N)? : ");
       keMenu = input.next();
  if (keMenu.equalsIgnoreCase("N")) {
    menu = true;
  }

        } while (keMenu.equalsIgnoreCase("N"));
    }

    public static void kritikDanSaran() {
        // awal penambahan kode case
          if (usernames[i] != null && passwords[i] != null) { 
            
        System.out.println("\n========================================================================");
        System.out.println("===                        Kritik Saran:                             ===");
        System.out.println("========================================================================");
        System.out.print("= Masukkan Kritik dan Saran Anda: ");
       
        kritik[JML_MASUKAN] = input.nextLine();

        System.out.println("\n========================================================================");
        System.out.println("\n             ===== :Terima kasih atas feedback Anda!: =====             ");
        System.out.println("\n========================================================================");
        System.out.println("= +==>            " + kritik[JML_MASUKAN]);

        JML_MASUKAN++;
        tekanEnterKembaliKeMenu();
         } else { System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan Login User terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();
        }
        // batas penambahan kode case
    }

    public static void cetakStruk() {
        // fungsi invalid cetak struk jika belum memesan
        // InvalidCetakStruk(namaPemesan,tipeKamarDipilih);

        // awal penambahan kode case
        if (usernames[i] != null && passwords[i] != null) { 

            if (namaPemesan[JML_PEMESANAN - 1] != null &&tipeKamarDipilih[JML_PEMESANAN - 1] != null) {
                System.out.println("\n======================================================");
                System.out.println("===                 Detail Booking:                ===");
                System.out.println("======================================================");
                System.out.println("=    Nama Pemesan:" + namaPemesan[JML_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Tipe Kamar: " +tipeKamarDipilih[JML_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Harga Kamar : Rp" + hargaKamarDipilih[JML_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Layanan Tambahan:");
                i = 0;
                while (totalLayanan[JML_PEMESANAN - 1] != 0 | i < layananTambahan.length) {
                    // int pilihanLayanan = input.nextInt();
                    // int pilihanLayanan = input.nextInt();
                    for (i = 0; i < pilihanLayanan.length; i++) {
                        if (totalLayanan[JML_PEMESANAN - 1] != 0) {

                            System.out.println("=    - " + layananTambahan[pilihanLayanan[i] - 1] + " - $"
                                    + hargaLayanan[pilihanLayanan[i] - 1]);
                        }
                    }
                    break;
                }

                System.out.println("======================================================");
                System.out.println("=    Alat Transaksi: " + alatTransaksi);
                System.out.println("======================================================");

                if (alatTransaksi.equalsIgnoreCase("cc")) {
                    System.out.println("=    No Rekening Anda : " + noRekening);
                    System.out.println("======================================================");

                }
                System.out.println("=    Jumlah Malam Menginap: " + jumlahMalam);
                System.out.println("======================================================");
                System.out.println("=    Total Biaya: Rp" + totalBiaya[JML_PEMESANAN - 1]);
                System.out.println("======================================================");

                // Proses pembayaran

                kembalian = pembayaran - totalBiaya[JML_PEMESANAN - 1];
                System.out.println("=    Pembayaran diterima. Kembalian: Rp" + kembalian);
                System.out.println("======================================================");
                System.out.println("\n   ==== Terima kasih telah melakukan booking! ====    ");

                JML_PEMESANAN++;

                tekanEnterKembaliKeMenu();
                // batas penambahan kode case

            } else
                InvalidCetakStruk(namaPemesan,tipeKamarDipilih);
        } else {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan Login User terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();
        }
    }

   

    
    // fungsi fitur halaman admin dibawah ini
    public static void editKetersediaanKamar() {

        do {
            lanjut = false;
            System.out.println("\nList id kamar :");
            for (int j = 0; j < kamarDipesan.length; j++) {
                System.out.print(ID_KAMAR[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                System.out.println();
            }

            System.out.print("\nMasukkan Id Jenis Kamar yang akan diperbarui: ");
            int updateID_KAMAR = input.nextInt();
            int updateIndex = -1;
            input.nextLine();

            for (int i = 1; i <= tipeKamar.length; i++) {
                if (ID_KAMAR[i - 1] == updateID_KAMAR) {
                    updateIndex = ID_KAMAR[i - 1];
                    break;
                }
            }

            if (updateIndex != -1) {
                System.out.print("Masukkan jumlah kamar: ");
                jumlahKamar[updateID_KAMAR - 1] = input.nextInt();
                input.nextLine();

                System.out.println("\nId Kamar berhasil diperbarui: ");
                System.out.println("\nList id kamar :");
                for (int j = 0; j < kamarDipesan.length; j++) {
                    System.out.print(ID_KAMAR[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                    System.out.println();
                }
            } else {
                System.out.println("Kamar tidak ditemukan dengan ID: " + updateID_KAMAR);
                System.out.println("\nApakah anda ingin input kembali (Y/N)? : ");
                keMenu = input.nextLine();
                if (keMenu.equalsIgnoreCase("Y")) {
                    lanjut = true;
                } else if (keMenu.equalsIgnoreCase("N")) {
                    menu = true;
                }
            }

            System.out.println("\nApakah anda ingin input kembali (Y/N)? : ");
            keMenu = input.nextLine();
            if (keMenu.equalsIgnoreCase("Y")) {
                lanjut = true;
            } else if (keMenu.equalsIgnoreCase("N")) {
                menu = true;
            }
        } while (lanjut);

    }

    public static void editContactPerson() {
        do {
            lanjut = false;

            System.out.print("Input Nama Hotel : ");
            nama = input.nextLine();
            System.out.print("Input nomor telepon : ");
            telepon = input.nextLine();
            System.out.print("Input email : ");
            email = input.nextLine();

            System.out.println(
                    "\nApakah anda ingin input kembali (Y/N)? : ");
            keMenu = input.nextLine();
            if (keMenu.equalsIgnoreCase("Y")) {
                lanjut = true;
            } else if (keMenu.equalsIgnoreCase("N")) {
                menu = true;
            }
        } while (lanjut);
    }

    public static void lihatKritikSaran() {

        for (int i = 0; i < JML_MASUKAN; i++) {

            System.out.println("\nMasukkan : " + (i + 1));
            System.out.println(

                    "========================================================================");
            System.out.println("Nama:             " + namaPenulis[i]);
            System.out.println(
                    "========================================================================");
            System.out.println(
                    "====                          Kritik:                               ====");
            System.out.println(
                    "========================================================================");
            System.out.println("= +==>            " + kritik[i]);

        }

        tekanEnterKembaliKeMenu();
    }

    public static void fiturLaporan() {

        int[] numberOfRoomsList = new int[100];
        int reservationCount = 0;

        do {
            lanjut = false;
            System.out.println("\n1. Tampilkan Reservasi" +
                    "\n2. Perbarui Reservasi" +
                    "\n3. Hapus Reservasi" +
                    "\n4. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {

                case 1:
                    if (totalBiaya[JML_PEMESANAN - 1] != 0) {
                        System.out.println("Semua Reservasi:");

                        for (int i = 0; i <= JML_PEMESANAN; i++) {
                            if (namaPemesan[i] != null &&tipeKamarDipilih[i] != null)
                                System.out.println("ID Reservasi: " + SAVE_PEMESANAN[SAVE_PEMESANAN[i] - 1] +
                                        ", Nama Tamu: " + namaPemesan[SAVE_PEMESANAN[i] - 1] +
                                        ", Jenis Kamar: " +tipeKamarDipilih[SAVE_PEMESANAN[i] - 1] +
                                        ", Jumlah Kamar: " + jumlahKamarDiPesan[SAVE_PEMESANAN[i] - 1] +
                                        ", Total Bayar: " + totalBiaya[SAVE_PEMESANAN[i] - 1]);
                        }
                        for (int i = 0; i <= JML_PEMESANAN; i++) {
                            totalPemasukan += totalBiaya[SAVE_PEMESANAN[i] - 1];
                        }
                        System.out.println();
                        System.out.println("-------------------------------    Total pemasukan dari pesanan kamar = "
                                + totalPemasukan + "     -------------------------------  ");
                    } else {
                        System.out.println("\n== Belum ada data pemesanan yang telah masuk. ==");

                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 2:
                    System.out.print("Masukkan ID reservasi yang akan diperbarui: ");
                    int updateId = input.nextInt();
                    int updateIndex = -1;
                    input.nextLine();

                    for (int i = 1; i <= JML_PEMESANAN; i++) {
                        if (SAVE_PEMESANAN[i - 1] == updateId) {
                            updateIndex = SAVE_PEMESANAN[i - 1];
                            break;
                        }
                    }

                    if (updateIndex != -1) {
                        System.out.print("Masukkan nama tamu: ");
                        namaPemesan[updateIndex - 1] = input.next();
                        System.out.print("Masukkan jenis kamar: ");
                       tipeKamarDipilih[updateIndex - 1] = input.next();
                        System.out.print("Masukkan jumlah kamar: ");
                        jumlahKamarDiPesan[updateIndex - 1] = input.nextInt();

                        System.out.println("Reservasi berhasil diperbarui:\nID Reservasi: " +
                                SAVE_PEMESANAN[updateIndex - 1] +
                                ", Nama Tamu: " + namaPemesan[updateIndex - 1] +
                                ", Jenis Kamar: " +tipeKamarDipilih[updateIndex - 1] +
                                ", Jumlah Kamar: " + numberOfRoomsList[updateIndex - 1]);
                    } else {
                        System.out.println("\nReservasi tidak ditemukan dengan ID: " + updateId);
                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 3:
                    System.out.print("Masukkan ID reservasi yang akan dihapus: ");
                    int deleteId = input.nextInt();
                    int deleteIndex = -1;

                    for (int i = 1; i <= JML_PEMESANAN; i++) {
                        if (SAVE_PEMESANAN[i - 1] == deleteId) {
                            deleteIndex = SAVE_PEMESANAN[i - 1];
                            break;
                        }
                    }

                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i <= SAVE_PEMESANAN[JML_PEMESANAN - 1]; i++) {
                            SAVE_PEMESANAN[i - 1] = SAVE_PEMESANAN[i];
                            namaPemesan[i - 1] = namaPemesan[i];
                           tipeKamarDipilih[i - 1] =tipeKamarDipilih[i];
                            jumlahKamarDiPesan[i - 1] = jumlahKamarDiPesan[i];
                            break;
                        }

                        JML_PEMESANAN--;

                        System.out.println("Reservasi berhasil dihapus dengan ID: " + deleteId);
                    } else {
                        System.out.println("\nReservasi tidak ditemukan dengan ID: " + deleteId);
                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 4:
                    menu = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Harap masukkan opsi yang valid.");
            }
        } while (lanjut);
    }

    // method menambahkan jenis kamar
    public static void tambahJenisKamar() {
        int newLength = (tipeKamar.length + 1);

        String[] newTipeKamar = new String[newLength];
        int[] newJumlahKamar = new int[newLength];
        int[] newID_KAMAR = new int[newLength];
        int[] newKamarTersedia = new int[newLength];
        int[] newKamarDipesan = new int[newLength];
        double[] newHargaPerMalam = new double[newLength];
        double[] newHargaLayanan = new double[newLength];
        String[][] newFasilitas = new String[newLength][50];

        for (int i = 0; i < tipeKamar.length; i++) {
            newTipeKamar[i] = tipeKamar[i];
            newJumlahKamar[i] = jumlahKamar[i];
            newID_KAMAR[i] = ID_KAMAR[i];
            newKamarTersedia[i] = kamarTersedia[i];
            newKamarDipesan[i] = kamarDipesan[i];
            newHargaPerMalam[i] = hargaPerMalam[i];
            newHargaLayanan[i] = hargaLayanan[i];
              for (int j = 0; j < fasilitasKamar[0].length; j++) {
            newFasilitas[i][j] = fasilitasKamar[i][j];
              }
        }

        tipeKamar = newTipeKamar;
        jumlahKamar = newJumlahKamar;
        ID_KAMAR = newID_KAMAR;
        kamarTersedia = newKamarTersedia;
        kamarDipesan = newKamarDipesan;
        hargaPerMalam = newHargaPerMalam;
        hargaLayanan = newHargaLayanan;
        fasilitasKamar = newFasilitas;

        System.out.print("Masukkan Nama Tipe Kamar : ");
        String tipeKamarBaru = input.nextLine();

        System.out.println("Masukkan Fasilitas Kamar : ");
        
            for (int j = 0; j < fasilitasKamar[0].length; j++) {
                  System.out.print(" - Fasilitas ke "+(j+1)+" : ");
                  String fasilitasBaru= input.nextLine();
                  fasilitasKamar[NUM_ROOMS][j] = fasilitasBaru;
                
                      System.out.println("\n tekan X untuk berhenti, enter untuk lanjut");
                      String berhenti = input.next();
                      if (berhenti.equalsIgnoreCase("x")) {
                        break;
                      }     
            }
       
         

        System.out.print("Masukkan Jumlah Kamar : ");
        int jumlahKamarBaru = input.nextInt();

        System.out.print("Masukkan Harga Per Malam : ");
        double hargaPerMalamBaru = input.nextDouble();

        tipeKamar[NUM_ROOMS] = tipeKamarBaru;
        jumlahKamar[NUM_ROOMS] = jumlahKamarBaru;
        hargaPerMalam[NUM_ROOMS] = hargaPerMalamBaru;

        NUM_ROOMS++;

        System.out.println("Kamar telah ditambahkan.");
        input.nextLine();
        tekanEnterKembaliKeMenu();

    }

    public static void fungsiFasilitasHotel() {

       
            System.out.println("===============================");
            System.out.println(((jenisKamar-1) + 1) +". "+ tipeKamar[jenisKamar-1]);
            System.out.println("===============================");
            System.out.println("= Fasilitas: ");
            for (int j = 0; j < fasilitasKamar[jenisKamar-1].length; j++) {
        
                    if(fasilitasKamar[jenisKamar-1][j] != null){
                System.out.println("= ^ " + fasilitasKamar[jenisKamar-1][j]);
            }
            //untuk meresat agar jenis kamar tidak stuck 1 jenis kamar
        }
        

        
    }
   

  
}

