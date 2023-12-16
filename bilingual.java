package finalcode;

import java.time.LocalDate;
import java.util.Scanner;

public class bilingual {
    static String keMenu, next, userAdmin, passAdmin, alatTransaksi = null, inKode,
             nama = "Hotel Ijen Suites", telepon = "08123456789",
            email = "Ijensuites@gmail.com", passUser, userUser, isCekKamar, konfirmasiBed, tempNamaPemesan;
            static int counterKS=0;
    static String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" },

            layananTambahan = { "Extra Bed", "Makanan", null }, extraBed = new String[3], namaPemesan = new String[100],
            selectedRoomType = new String[100], kodePromo = { "A", "IJENMALANG", "IJEN11" },
            kodeSudahDigunakan = new String[3],namaPenulis = new String[100], kritik = new String[100], saran = new String[100];
    static boolean lanjut, menu, isPromo, kodeTidakValid;
    static Scanner input = new Scanner(System.in);
    static int pilihMenu, pilihanKamar, jenisKamar, jumlahDewasa, jumlahAnak = 0, i, noRekening = 0, jumlahMalam = 0,
            tempJumlahDewasa, sisaKapasitas, tempJumlahAnak, jumlahExtraBed, pilihExtraBed, id = 1, lantai = 6,
            tempJumlahExtraBed;
    static double kembalian, pembayaran = 0.0, totalPemasukan = 0.0, diskon;
    static int jumlahKamar[] = { 11, 15, 12 }, idKamar[] = { 1, 2, 3 }, kamarTersedia[] = new int[3],
            kamarDipesan[] = new int[3], 
            pilihanLayanan[] = { 0, 0 }, idSave[] = new int[100], jumlahKamarDiPesan[] = new int[100];
    static double[] hargaPerMalam = { 750000, 500000, 2000000 }, hargaLayanan = { 50000, 100000, 0 },
            selectedRoomPrice = new double[100], totalBiaya = new double[100], totalLayanan = new double[100],
            disPromo = { 0.10, 0.15, 0.20 };
    // Mendapatkan tanggal hari ini
    static LocalDate today = LocalDate.now();

    public static void main(String[] args) {
        userUser = null;
        passUser = null;

        // 3. Bisa gak pesan 2 kamar jenis berbeda
        // 5. Tanggal
        // 11. Menambah jenis kamar baru (admin)
        // 12. Membership
        

        // yg mungkin bisa dkerjakan tanpa bantuan

        // 2. Rincian tipe kamar dibuat array 2 dimensi
            // 4. Billingual

        //progress
 // 1. Array untuk kritik saran

        // hampir selesai
        // 6. Stok kamar (hampir selesai)
        // 8. Pelaporan dari sisi admin ( hampir selesai)

        // selesai
            // 3. fitur promo(selesai)
        // 2. Stok kamar 0 tdk bisa dipesan
        // 1. Login pengguna
        // 7. Log out pengguna [selesai]
        // 10. Menu pesan jd satu ke ketersediaan kamar [sudah]
        do {

            menu = false;
// 13. nomor kamar , ada 6 lantai
            System.out.println("\n=======================================");
            System.out.println("Welcome to Ijen Suites Hotel!");
            tanggalHariIni(today);
            System.out.println("=======================================");
            System.out.println("Please select the menu");
            System.out.println("1. Room details");
            System.out.println("2. Book and Check rooms ");
            System.out.println("3. Book Additional Services (Meals/Extra Bed/Hall Rental)");
            System.out.println("4. Contact Person");
            System.out.println("5. Hotel Location");
            System.out.println("6. Comments and Suggestions");
            System.out.println("7. Hotel Facilities");
            System.out.println("8. Cetak Struk");
            System.out.println("98. Login User");
            System.out.println("99. Login Admin");

            System.out.println("=======================================");
            System.out.print("+==> Select the menu : ");
            pilihMenu = input.nextInt();
            System.out.println("=======================================");
            input.nextLine();

            switch (pilihMenu) {
                case 1:
                    rincianKamar();
                    break;
                case 2:
                    pesanKamar();
                    // tekan enter untuk kembali
                    // apakah anda ingin memesan kembali?
                    break;
                case 3:
                    pesanLayananTambahan();
                    break;
                case 4:
                    contactPerson(nama, email, telepon);
                    break;
                case 5:
                    lokasiHotel();
                    break;
                case 6:
                    kritikDanSaran();
                    break;
                case 8:
                    cetakStruk();
                    // unutk konifrmasi
                    break;
                case 98:
                    loginUser(args);
                    break;
                case 99:
                    loginAdmin(args);
                    break;
                case 00:
                    break;

                default:
                    System.out.println("\nWrong Input!");
                    lanjut = true;
                    break;

            }
        } while (menu);

        input.close();
    }
    // fungsi bukan fitur utama dibawah ini

    static void tanggalHariIni(LocalDate today) {

        // Menampilkan tanggal hari ini
        System.out.println("              " + today);
    }

    static void tekanEnterKembaliKeMain(String[] args) {
        System.out.println("\nPlease enter to return. ");
        input.nextLine();
        main(args);
    }

    static boolean tekanEnterKembaliKeMenu() {
        System.out.println("\nPLease enter to return. ");
        input.nextLine();
        menu = true;
        return menu;
    }

    static boolean tekanEnterKembaliKeSebelumnya() {
        System.out.println("\nPlease enter to return. ");
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

        if (param1[id - 1] == null && param2[id - 1] == null) {

            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Please fill in the room reservation data first");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();

        }

    }

    public static void fiturPromo() {

        lanjut = false;
        System.out.println("Do you want to enter a promo code? (Y/N)");
        keMenu = input.nextLine();
        if (keMenu.equalsIgnoreCase("Y")) {
            do {
                lanjut = false;
                System.out.println("=================================================");
                System.out.print("= Enter promo code : ");
                inKode = input.nextLine();
                System.out.println("=================================================");
                isPromo = false;
                for (int i = 0; i < disPromo.length; i++) {
                    if (inKode.equals(kodePromo[i])) {
                        if (inKode.equals(kodeSudahDigunakan[i])) {
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
                    System.out.println("Congratulations, you get a discount of " + (diskon * 100) + "%!");

                } else if (kodeTidakValid) {
                    System.out.println("\n==           The code is already in use.         ==");
                } else {
                    kodeTidakValid = true;
                    System.out.println("\n==           Invalid promo code.         ==");
                }
                if (kodeTidakValid) {
                    do {
                        kodeTidakValid = false;
                        System.out.println("\n=================================================");
                        System.out.println("       Would you like to try again? (Y/N)   ");
                        System.out.print("+==> ");
                        keMenu = input.nextLine();
                        if (keMenu.equalsIgnoreCase("Y")) {
                            lanjut = true;
                        } else if (keMenu.equalsIgnoreCase("N")) {

                        } else {
                            System.out.println("   Invalid input.");
                            kodeTidakValid = true;
                        }
                    } while (kodeTidakValid);
                }

            } while (lanjut);
            // Proses perhitungan total biaya setelah mendapatkan diskon
            totalBiaya[id - 1] = ((jumlahKamarDiPesan[id - 1] * jumlahMalam * selectedRoomPrice[id - 1])
                    + totalLayanan[id - 1]) * diskon;

            System.out.println("==  Total Cost (After Discount): " + totalBiaya[id - 1]);
        } else if (keMenu.equalsIgnoreCase("N")) {

        } else {
            System.out.println("    Invalid input");
            kodeTidakValid = true;
        }

    }

    public static void fiturJmlDewasaAnak() {
        do {
            lanjut = false;
            sisaKapasitas = 0;

            System.out.println("==========================================");
            System.out.print("= Enter the number of adults: ");
            // max 1 =2;
            tempJumlahDewasa = input.nextInt();
            if (tempJumlahDewasa <= (sisaKapasitas + (jumlahKamarDiPesan[id - 1] * 2))) {
                jumlahDewasa = tempJumlahDewasa;
                sisaKapasitas += ((jumlahKamarDiPesan[id - 1]) * 2 + (1 * jumlahKamarDiPesan[id - 1])) - jumlahDewasa;
            } else {
                System.out.println(
                        "=== The number of adults exceeds the room capacity, please add a room / extra bed ==");
                input.nextLine();
                System.out.println("==========================================");
                System.out.println("= do you want to add an extra bed (Y/N)");
                System.out.print("+==> ");
                konfirmasiBed = input.nextLine();

                if (konfirmasiBed.equalsIgnoreCase("Y")) {
                    System.out.println("==========================================");
                    System.out.println("1. Folding Extra Bed");
                    System.out.println("2. Standing Extra Bed");
                    System.out.println("3. Baby Cot ");
                    System.out.println("==========================================");
                    do {
                        lanjut = false;

                        System.out.print("Please select the type of extra bed (1/2/3) : ");
                        pilihExtraBed = input.nextInt();
                        if (pilihExtraBed > 3 || pilihExtraBed == 0) {
                            System.out.println("==========================================");
                            System.out.println("Wrong Input.");
                            lanjut = true;
                        }
                    } while (lanjut);
                    do {
                        lanjut = false;
                        System.out.println("= Input number of extrabeds (max 1/room)");
                        tempJumlahExtraBed = input.nextInt();
                        if (jumlahExtraBed <= jumlahKamarDiPesan[id - 1] && jumlahExtraBed != 0) {
                            jumlahExtraBed = tempJumlahExtraBed;
                        } else {
                            System.out.println("==========================================");
                            System.out.println("= Amount cannot be 0/exceed the booked room");
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
                            extraBed[pilihExtraBed] = "Baby Cot (for baby)";
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
                System.out.println("=== Number of children exceeds room capacity ===");
                input.nextLine();
                System.out.println("==========================================");
                System.out.println("= do you want to add an extra bed(Y/N)");
                System.out.print("+==> ");
                konfirmasiBed = input.nextLine();

                if (konfirmasiBed.equalsIgnoreCase("Y")) {
                    System.out.println("==========================================");
                    System.out.println("1. Folding Extra Bed");
                    System.out.println("2. Standing Extra Bed");
                    System.out.println("3. Baby Cot ");
                    System.out.println("==========================================");
                    System.out.print("Please select the type of extra bed (1/2/3) : ");
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
                            extraBed[jumlahExtraBed] = "Baby Cot (for baby)";
                            break;

                        default:
                            break;
                    }
                }
                if (konfirmasiBed.equalsIgnoreCase("N")) {
                    lanjut = true;
                }
            }

        } while (lanjut);
    }

    // fungsi fitur halaman utama bukan admin dibawah ini
    public static void rincianKamar() {
        String kamar[] = { "    ===============================\r\n" + //
                "    ==  1. Superior Deluxe Room  ==\r\n" + //
                "    ===============================\r\n" + //
                "    = Fasilitas :                 =\r\n" + //
                "    =  ^ Single Bed Regular Size  =\r\n" + //
                "    =  ^ Balcony                  =\r\n" + //
                "    =  ^ Pool View                =\r\n" + //
                "    =  ^ Soundproofing            =\r\n" + //
                "    =  ^ Free Wifi                =\r\n" + //
                "    =  ^ Flat-screen TV           =\r\n" + //
                "    =  ^ Private Bathroom         =\r\n" + //
                "    =  ^ Air Conditioning         =\r\n" + //
                "    ===============================",
                "    ================================\r\n" + //
                        "    ==  2. Devaxa President Room  ==\r\n" + //
                        "    ================================\r\n" + //
                        "    = Fasilitas :                  =\r\n" + //
                        "    =  ^ Living Room               =\r\n" + //
                        "    =  ^ Single Bed King Size      =\r\n" + //
                        "    =  ^ Balcony\t\t   =\r\n" + //
                        "    =  ^ Pool View\t\t   =\r\n" + //
                        "    =  ^ Soundproofing\t\t   =\t\r\n" + //
                        "    =  ^ Free Wifi\t\t   =\r\n" + //
                        "    =  ^ Flat-screen TV\t\t   =\r\n" + //
                        "    =  ^ Private Bathroom \t   =\r\n" + //
                        "    =  ^ Air Conditioning\t   =\r\n" + //
                        "    ================================",
                "\r\n" + //
                        "    ================================\r\n" + //
                        "    ==  3. Raden Salah Suite      ==\r\n" + //
                        "    ================================\r\n" + //
                        "    = Fasilitas :                  =\r\n" + //
                        "    =  ^ Living Room               =\r\n" + //
                        "    =  ^ Private Suite    \t   =\r\n" + //
                        "    =  ^ Private bathroom  \t   =\r\n" + //
                        "    =  ^ Minibar \t\t   =\r\n" + //
                        "    =  ^ Living Room\t\t   =\r\n" + //
                        "    =  ^ extra-large double bed\t   =\r\n" + //
                        "    =  ^ Balcony\t\t   =\r\n" + //
                        "    =  ^ Pool View\t\t   =\r\n" + //
                        "    =  ^ Soundproofing\t\t   =\r\n" + //
                        "    =  ^ Free Wifi\t       \t   =\r\n" + //
                        "    =  ^ Flat-screen TV \t   =\r\n" + //
                        "    =  ^ Private Bathroom \t   =\r\n" + //
                        "    =  ^ Air Conditioning\t   =\r\n" + //
                        "    ================================" };

        System.out.println("\n==============================");
        System.out.println("==      :Room Detail:     ==");
        System.out.println("==============================");

        System.out.println("\n=====:Select room type:=====");
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
                System.out.println("Enter the room type you wish to view :");
                System.out.println("==========================================");
                System.out.print("+==> ");
                jenisKamar = input.nextInt();
                // Meminta pengguna memasukkan jenis kamar yang ingin dicek
                if (jenisKamar > kamarDipesan.length) {
                    System.out.println("Input exceeds the number of room types");
                    lanjut = true;
                }
            } while (lanjut);
            if ((jenisKamar) <= kamar.length) {
                // menampilkan jenis kamar
                System.out.println(kamar[jenisKamar - 1]);

            } else {
                System.out.println();
                System.out.println("== No data, wrong input. ==");
                System.out.println();
            }

            input.nextLine();
            System.out.println("Would you like to continue checking room availability? (Y/N): ");
            next = input.nextLine();
            if (next != "y" | next != "Y") {
                menu = true;
            }
        } while (next.equalsIgnoreCase("Y"));
    }

    public static void cekKetersediaan() {

        System.out.println("Would you like to check room availability first? (Y/N)");
        System.out.print("+==> ");
        isCekKamar = input.nextLine();
        if (isCekKamar.equalsIgnoreCase("y")) {

            System.out.println("\n==============================");
            System.out.println("== :Check Room Availability: ==");
            System.out.println("==============================");

            System.out.println("\n=====:Please select room type:=====");
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
                    System.out.println("Enter the room type you want to check :");
                    System.out.println("=========================================");
                    jenisKamar = input.nextInt();

                    // Meminta pengguna memasukkan jenis kamar yang ingin dicek
                    if (jenisKamar > kamarDipesan.length || jenisKamar == 0) {
                        System.out.println("Input exceeds the number of room types ");
                        lanjut = true;
                    }
                } while (lanjut);

                // jumlahKamarDiPesan+=jumlahKamarDiPesan;
                kamarDipesan[jenisKamar - 1] = jumlahKamarDiPesan[id - 1];
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
                System.out.println("Would you like to continue checking room availability? (Y/N): ");
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
        if (userUser == null && passUser == null) {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Please Login User first");
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
                System.out.println("==                Book room:                 ==");
                System.out.println("=================================================");

                cekKetersediaan();

                do {
                    lanjut = false;
                    System.out.println("print save id " + idSave[0]);

                    System.out.println("print id " + id);
                    System.out.println("=================================================");
                    System.out.print("= Enter the orderer's name: ");
                    tempNamaPemesan = input.nextLine();
                    if (namaPemesan[id - 1] == null) {
                        namaPemesan[id - 1] = tempNamaPemesan;
                        idSave[id - 1] = id;
                        System.out.println("=================================================");
                    } else {
                        lanjut = true;
                    }

                } while (lanjut);
                // Memilih tipe kamar
                do {

                    lanjut = true;
                    System.out.println("print save id " + idSave[0]);

                    System.out.println("= Please choose room type: ");
                    for (int i = 0; i < tipeKamar.length; i++) {
                        System.out.println("=  " + (i + 1) + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
                    }

                    System.out.println("=================================================");
                    System.out.print("= Enter a number to select : ");

                    pilihanKamar = input.nextInt();

                    System.out.println("=================================================");

                    if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                        kamarDipesan[pilihanKamar - 1] = jumlahKamarDiPesan[id - 1];
                        kamarTersedia[pilihanKamar - 1] = jumlahKamar[pilihanKamar - 1]
                                - kamarDipesan[pilihanKamar - 1];

                        if (kamarTersedia[pilihanKamar - 1] == 0) {
                            System.out.println("Sorry room not available, please select again");

                        }
                        selectedRoomType[id - 1] = tipeKamar[pilihanKamar - 1];
                        selectedRoomPrice[id - 1] = hargaPerMalam[pilihanKamar - 1];
                        lanjut = false;
                    } else {
                        System.out.println("Wrong Input");
                        System.out.println("=================================================");
                    }
                } while (lanjut);

                do {

                    lanjut = true;
                    System.out.print("= Enter the number of rooms you are booking: ");
                    jumlahKamarDiPesan[id - 1] = input.nextInt();
                    if (jumlahKamarDiPesan[id - 1] <= kamarTersedia[pilihanKamar - 1]) {
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
                        System.out.println("Booked rooms exceeded available rooms");
                        System.out.println("=================================================");
                    }

                } while (lanjut);
                fiturJmlDewasaAnak();

                System.out.println("=================================================");
                System.out.print("= Enter the number of nights to stay : ");
                jumlahMalam = input.nextInt();

                System.out.println("=================================================");
                System.out.println("= Choose additional services :");
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
                            System.out.println("Wrong Input");
                            System.out.println("=================================================");
                        }
                        System.out.println("=================================================");

                        if (pilihanLayanan[i] == 3) {
                            lanjut = false;
                        }
                        totalLayanan[id - 1] += hargaLayanan[pilihanLayanan[i] - 1];

                        input.nextLine();
                        i++;

                    } else {
                        break;
                    }
                } while (lanjut);

                // hitung sebelum mendapatkan diskon
                totalBiaya[id - 1] = (jumlahKamarDiPesan[id - 1] * jumlahMalam * selectedRoomPrice[id - 1])
                        + totalLayanan[id - 1];

                System.out.println("==          Total cost: " + totalBiaya[id - 1]);
                // proses in put promo dan berhitungan biaya
                fiturPromo();

                // input jumlah malam, allat transaksi, nominal pembayaran
                do {

                    lanjut = false;

                    System.out.println("=================================================");
                    System.out.print("= insert transaction tool (cc/cash): ");
                    alatTransaksi = input.nextLine();
                    if (alatTransaksi.equalsIgnoreCase("cc")) {
                        System.out.println("=================================================");
                        System.out.print("= Enter your account number: ");

                        noRekening = input.nextInt();
                        input.nextLine();

                    } else if (alatTransaksi.equalsIgnoreCase("cash")) {

                    } else {
                        System.out.println("=================================================");
                        System.out.println("Payment method not available.");
                        lanjut = true;
                    }
                } while (lanjut);

                do {
                    lanjut = false;
                    System.out.println("=================================================");
                    System.out.print("= Enter the payment amount: ");

                    pembayaran = input.nextDouble();

                    // Proses pembayaran
                    if (pembayaran >= totalBiaya[id - 1]) {
                        kembalian = pembayaran - totalBiaya[id - 1];

                        System.out.println("=================================================");
                        System.out.println("== Payment received. Return: Rp" + kembalian);
                        System.out.println("=================================================");
                        System.out.println("\n=================================================");
                        System.out.println("= Please print the receipt to confirm the order. =");
                        System.out.println("=================================================");

                    } else {

                        System.out.println("=================================================");
                        System.out.println("\nInsufficient payment. Please pay according to the total cost.");
                        System.out.println();
                        lanjut = true;
                    }
                } while (lanjut);
                input.nextLine();

                do {
                    kodeTidakValid = false;
                    System.out.println("\n=================================================");
                    System.out.println("== Are you sure about your order? (Y/N) ==");
                    System.out.print("+==> ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        input.nextLine();
                        System.out.println("\n=================================================");
                        System.out.println("\n ==== Thank you for booking! ==== ");
                        id++;
                        tekanEnterKembaliKeSebelumnya();
                        break;
                    } else if (keMenu.equalsIgnoreCase("N")) {
                        lanjut = true;
                        namaPemesan[id - 1] = null;
                        totalBiaya[id - 1] = 0;
                        kodeSudahDigunakan[i] = null;

                    } else {
                        System.out.println(" Invalid input.");
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
                System.out.println("===           Food Menu:           ===");
                System.out.println("=========================================");
                System.out.println("= 1. Chicken Cordon Bleu                =");
                System.out.println("=========================================");
                System.out.println("= 2. Chicken noodle                           =");
                System.out.println("=========================================");
                do {
                    pesanMenu = false;
                    System.out.println("\nChoose the food menu you want to order: ");
                    System.out.print("+==> ");
                    int pilihan = input.nextInt();

                    switch (pilihan) {

                        case 1:
                            pesanan = "Chicken Cordon Bleu";
                            break;
                        case 2:
                            pesanan = "Chicken Noodle";
                            break;
                        default:
                            System.out.println("\n Invalid menu. Please select again.");
                            pesanMenu = true;
                    }
                } while (pesanMenu);
                System.out.println("\n=========================================");
                System.out.println("==  You place an order:" + pesanan);
                System.out.println("=========================================");
                System.out.println("\nWould you like to order again? (Y/N): ");
                String jawaban = input.next();

                pesanLagi = jawaban.equalsIgnoreCase("Y");
                if (jawaban != "y" | jawaban != "Y") {
                    menu = true;
                }

            } while (pesanLagi);
            System.out.println("\n === Thank you for the order! ===");
        } else {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Please Login User first");
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
        System.out.println("= Name: " + nama + "            =");
        System.out.println("======================================");
        System.out.println("= Phone Number: " + telepon + "         =");
        System.out.println("======================================");
        System.out.println("= Email Address: " + email + " =");
        System.out.println("======================================");

        tekanEnterKembaliKeMenu();
        // batas penambahan kode case

    }

    public static void lokasiHotel() {
        do {

            System.out.println("\n=================================");
            System.out.println("===       Hotel Location:       ===");
            System.out.println("\n=================================");
            System.out.println("     Please select the option:        ");
            System.out.println("=================================");
            System.out.println("= 1. Check Hotel Location           =");
            System.out.println("=================================");
            System.out.println("= 2. Places Nearby from the hotel =");
            System.out.println("=================================");
            System.out.print("+==>  ");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.println(
                            "=================================================================================");

                    System.out.println(
                            "= Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116 =");

                    System.out.println(
                            "=================================================================================");

                    break;
                default:
                    System.out.println("Invalid option.");
            }

            tekanEnterKembaliKeMenu();

        } while (keMenu.equalsIgnoreCase("N"));
    }

    public static void kritikDanSaran() {
        // awal penambahan kode case
        System.out.println("\n========================================================================");
        System.out.println("===                        critique suggestions:                             ===");
        System.out.println("========================================================================");
        System.out.print("= Please input your name: ");
        namaPenulis[counterKS] = input.nextLine();
        System.out.println("========================================================================");
        System.out.println("==          Enter the critiques & features you want to add:          ==");
        System.out.println("========================================================================");
        System.out.print("= +==>: ");
        kritik[counterKS] = input.nextLine();

        System.out.println("\n========================================================================");
        System.out.println("\n             ===== :Thank you for your feedback!!: =====             ");
        System.out.println("\n========================================================================");
        System.out.println("Nama: " + namaPenulis[counterKS]);
        System.out.println("========================================================================");
        System.out.println("====                          Criiques:                               ====");
        System.out.println("========================================================================");
        System.out.println("= +==>            " + kritik[counterKS]);

    
counterKS++;
        tekanEnterKembaliKeMenu();
        // batas penambahan kode case
    }

    public static void cetakStruk() {
        // fungsi invalid cetak struk jika belum memesan
        // InvalidCetakStruk(namaPemesan, selectedRoomType);

        // awal penambahan kode case
        if (userUser != null && passUser != null) {

            if (namaPemesan[id - 1] != null && selectedRoomType[id - 1] != null) {
                System.out.println("\n======================================================");
                System.out.println("===                 Detail Booking:                ===");
                System.out.println("======================================================");
                System.out.println("=  Orderer Name:" + namaPemesan[id - 1]);
                System.out.println("======================================================");
                System.out.println("=    Room type: " + selectedRoomType[id - 1]);
                System.out.println("======================================================");
                System.out.println("=    Room price : Rp" + selectedRoomPrice[id - 1]);
                System.out.println("======================================================");
                System.out.println("=   Additional Services:");
                i = 0;
                while (totalLayanan[id - 1] != 0 | i < layananTambahan.length) {
                    // int pilihanLayanan = input.nextInt();
                    // int pilihanLayanan = input.nextInt();
                    for (i = 0; i < pilihanLayanan.length; i++) {
                        if (totalLayanan[id - 1] != 0) {

                            System.out.println("=    - " + layananTambahan[pilihanLayanan[i] - 1] + " - $"
                                    + hargaLayanan[pilihanLayanan[i] - 1]);
                        }
                    }
                    break;
                }

                System.out.println("======================================================");
                System.out.println("=    Transaction tool: " + alatTransaksi);
                System.out.println("======================================================");

                if (alatTransaksi.equalsIgnoreCase("cc")) {
                    System.out.println("=    Your bank account number : " + noRekening);
                    System.out.println("======================================================");

                }
                System.out.println("=   Number of Night Stay: " + jumlahMalam);
                System.out.println("======================================================");
                System.out.println("=    Total Cost: Rp" + totalBiaya[id - 1]);
                System.out.println("======================================================");

                // Proses pembayaran

                kembalian = pembayaran - totalBiaya[id - 1];
                System.out.println("=    Payment received. Return: Rp" + kembalian);
                System.out.println("======================================================");
                System.out.println("\n   ==== Thank you for making a booking! ====    ");

                id++;

                tekanEnterKembaliKeMenu();
                // batas penambahan kode case

            } else
                InvalidCetakStruk(namaPemesan, selectedRoomType);
        } else {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Please Login User first");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();
        }
    }

    public static void loginUser(String[] args) {
        do {
            System.out.println("\n===============================");
            System.out.println("=        Login User:         =");
            System.out.println("===============================");
            lanjut = false;
            System.out.print("Please input Username : ");
            userUser = input.nextLine();
            System.out.print("Please input Password : ");
            passUser = input.nextLine();
            if (userUser.equals("user") && passUser.equals("12345")) {
                System.out.println("===============================");
                System.out.println("=        Login Succesful        =");
                System.out.println("===============================");
                System.out.println();
                do {
                    menu = false;
                    System.out.println("\n=======================================");
                    System.out.println("Welcome to Ijen Suites Hotel!");
                    System.out.println("=======================================");
                    System.out.println("PLease choose the menu");
                    System.out.println("1. Room detail");
                    System.out.println("2. Book and check room ");
                    System.out.println("3. Book Additional Services (Meals/Extra Bed/Hall Rental)");
                    System.out.println("4. Contact Person");
                    System.out.println("5. Hotel Location");
                    System.out.println("6. critique suggestion");
                    System.out.println("7. Hotel Facilities");
                    System.out.println("8. Print receipts ");
                    System.out.println("00. Logout");
                    System.out.println("=======================================");
                    System.out.print("     Pilih Menu 1/2/3/4/5/6/7/8/9/10 : ");
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
                            pesanLayananTambahan();
                            break;
                        case 4:
                            contactPerson(nama, email, telepon);
                            break;
                        case 5:
                            lokasiHotel();
                            break;
                        case 6:
                            kritikDanSaran();
                            break;
                        case 8:
                            cetakStruk();
                            break;
                        case 00:
                            id = 1;
                            main(args);
                            break;
                    }
                } while (menu);
            } else {
                System.out.println("===============================");
                System.out.println("=        Failed Login!        =");
                System.out.println("===============================");
                System.out.println("\nWould you like to input again (Y/N)? : ");
                keMenu = input.next();
                if (keMenu.equalsIgnoreCase("Y")) {
                    lanjut = true;
                }
                if (keMenu.equalsIgnoreCase("N")) {
                    main(args);
                }
            }
            input.nextLine();
        } while (lanjut);
    }

    public static void loginAdmin(String[] args) {
        do {

            System.out.println("\n===============================");
            System.out.println("=        Login Admin:         =");
            System.out.println("===============================");
            lanjut = false;
            System.out.print("Please input Username : ");
            userAdmin = input.nextLine();
            System.out.print("Please input Password : ");
            passAdmin = input.nextLine();

            if (userAdmin.equals("admin") && passAdmin.equals("12345")) {
                System.out.println("===============================");
                System.out.println("=        Login Succesful        =");
                System.out.println("===============================");
                System.out.println();
                do {
                    menu = false;
                    System.out.println("\n=======================================");
                    System.out.println("Welcome to the Admin Menu");
                    System.out.println("=======================================");
                    System.out.println("Please choose the menu");
                    System.out.println("1. Edit Room Availability");
                    System.out.println("2. Edit Contact Person");
                    System.out.println("3. Edit hotel location");
                    System.out.println("4. See Comments and Suggestions");
                    System.out.println("5. Edit Hotel Facilities");
                    System.out.println("6. View & Edit Reports");
                    System.out.println("00. Logout");
                    System.out.println("=======================================");
                    System.out.print("     Choose Menu 1/2/3/4/5/6 : ");
                    int menuAdmin = input.nextInt();
                    input.nextLine();

                    switch (menuAdmin) {
                        case 1:
                            editKetersediaanKamar();
                            break;
                        case 2:
                            editContactPerson();
                            break;
                        case 4:
                            lihatKritikSaran();
                            break;
                        case 6:
                            fiturLaporan();
                            break;
                        case 00:
                            userAdmin = null;
                            userUser = null;
                            main(args);
                            break;

                        default:
                            menu = true;
                            break;
                    }
                } while (menu);

            } else {
                System.out.println("===============================");
                System.out.println("=        Login Failed!        =");
                System.out.println("===============================");
                System.out.println("\nWould you like to input again (Y/N)? : ");
                keMenu = input.next();
                if (keMenu.equalsIgnoreCase("Y")) {
                    lanjut = true;
                }
                if (keMenu.equalsIgnoreCase("N")) {
                    main(args);
                }
            }
            input.nextLine();
        } while (lanjut);
    }

    // fungsi fitur halaman admin dibawah ini
    public static void editKetersediaanKamar() {

        do {
            lanjut = false;
            System.out.println("\nList of room id :");
            for (int j = 0; j < kamarDipesan.length; j++) {
                System.out.print(idKamar[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                System.out.println();
            }

            System.out.print("\nInput id of room that you want to change : ");
            int updateIdKamar = input.nextInt();
            int updateIndex = -1;
            input.nextLine();

            for (int i = 1; i <= tipeKamar.length; i++) {
                if (idKamar[i - 1] == updateIdKamar) {
                    updateIndex = idKamar[i - 1];
                    break;
                }
            }

            if (updateIndex != -1) {
                System.out.print("Input the number of rooms: ");
                jumlahKamar[updateIdKamar - 1] = input.nextInt();
                input.nextLine();

                System.out.println("\nRoom Id has been changed: ");
                System.out.println("\nList of Room Id :");
                for (int j = 0; j < kamarDipesan.length; j++) {
                    System.out.print(idKamar[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                    System.out.println();
                }
            } else {
                System.out.println("Can't find room with ID: " + updateIdKamar);
                System.out.println("\nWould you like to input again (Y/N)? : ");
                keMenu = input.nextLine();
                if (keMenu.equalsIgnoreCase("Y")) {
                    lanjut = true;
                } else if (keMenu.equalsIgnoreCase("N")) {
                    menu = true;
                }
            }

            System.out.println("\nWould you like to input again (Y/N)? : ");
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

            System.out.print("Enter Your Name : ");
            nama = input.nextLine();
            System.out.print("Enter Your Phone Number : ");
            telepon = input.nextLine();
            System.out.print("Enter Your Email : ");
            email = input.nextLine();

            System.out.println(
                    "\nWould you like to input again (Y/N)? : ");
            keMenu = input.nextLine();
            if (keMenu.equalsIgnoreCase("Y")) {
                lanjut = true;
            } else if (keMenu.equalsIgnoreCase("N")) {
                menu = true;
            }
        } while (lanjut);
    }

    public static void lihatKritikSaran() {
    
    for (int i = 0; i < counterKS; i++) {
        
        System.out.println("\nEnter : "+(i+1));
        System.out.println(
            
            "========================================================================");
            System.out.println("Name:             " + namaPenulis[i]);
            System.out.println(
                "========================================================================");
                System.out.println(
                    "====                          Critics:                               ====");
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
            System.out.println("\n1. Show Reservation" +
                    "\n2. Update Reservation" +
                    "\n3. Delete Reservation" +
                    "\n4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {

                case 1:
                    if (totalBiaya[id - 1] != 0) {
                        System.out.println("All Reservations:");

                        for (int i = 0; i <= id; i++) {
                            if (namaPemesan[i] != null && selectedRoomType[i] != null)
                                System.out.println("Reservation ID: " + idSave[idSave[i] - 1] +
                                        ", Guest Name: " + namaPemesan[idSave[i] - 1] +
                                        ", Type Of Room: " + selectedRoomType[idSave[i] - 1] +
                                        ", Total Rooms: " + jumlahKamarDiPesan[idSave[i] - 1] +
                                        ", Bills: " + totalBiaya[idSave[i] - 1]);
                        }
                        for (int i = 0; i <= id; i++) {
                            totalPemasukan += totalBiaya[idSave[i] - 1];
                        }
                        System.out.println();
                        System.out.println("-------------------------------    Total income from room bookings = "
                                + totalPemasukan + "     -------------------------------  ");
                    } else {
                        System.out.println("\n== No order data has been entered yet. ==");

                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 2:
                    System.out.print("Enter the reservation ID to be updated: ");
                    int updateId = input.nextInt();
                    int updateIndex = -1;
                    input.nextLine();

                    for (int i = 1; i <= id; i++) {
                        if (idSave[i - 1] == updateId) {
                            updateIndex = idSave[i - 1];
                            break;
                        }
                    }

                    if (updateIndex != -1) {
                        System.out.print("Enter Guest Name: ");
                        namaPemesan[updateIndex - 1] = input.next();
                        System.out.print("Enter Type Of Room: ");
                        selectedRoomType[updateIndex - 1] = input.next();
                        System.out.print("Enter Total Rooms: ");
                        jumlahKamarDiPesan[updateIndex - 1] = input.nextInt();

                        System.out.println("Reservation has been changed :\nReservation ID: " +
                                idSave[updateIndex - 1] +
                                ", Guest Name: " + namaPemesan[updateIndex - 1] +
                                ", Type Of Room: " + selectedRoomType[updateIndex - 1] +
                                ", Total Room: " + numberOfRoomsList[updateIndex - 1]);
                    } else {
                        System.out.println("\nCan't find reservation with ID: " + updateId);
                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 3:
                    System.out.print("Enter reservation ID to be deleted: ");
                    int deleteId = input.nextInt();
                    int deleteIndex = -1;

                    for (int i = 1; i <= id; i++) {
                        if (idSave[i - 1] == deleteId) {
                            deleteIndex = idSave[i - 1];
                            break;
                        }
                    }

                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i <= idSave[id - 1]; i++) {
                            idSave[i - 1] = idSave[i];
                            namaPemesan[i - 1] = namaPemesan[i];
                            selectedRoomType[i - 1] = selectedRoomType[i];
                            jumlahKamarDiPesan[i - 1] = jumlahKamarDiPesan[i];
                            break;
                        }

                        id--;

                        System.out.println("Reservation has been deleted with ID :" + deleteId);
                    } else {
                        System.out.println("\nCan't find reservation with ID: " + deleteId);
                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 4:
                    menu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter the valid choice.");
            }
        } while (lanjut);
    }
}
    



