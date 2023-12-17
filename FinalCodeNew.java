
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class FinalCodeNew {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // untuk menyimpan dan mendeklarasikan "apakah iya Y/N" (keMenu, next,
    // isCekKamar, isExtraBed), menyimpan username dan password,input kode promo, &
    // menyimpan inofrmasi contact person
    static String keMenu, next, isCekKamar, isExtraBed, nama = "Hotel Ijen Suites", telepon = "08123456789",
            email = "Ijensuites@gmail.com", website = "www.ijensuitesmalang.com",
            lokasi = "Jalan Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116";

    // variabel untuk menyimpan (nama jenis kamar, layanan tambahan, kode PROMO) dan
    // memberikan jumlah penyimpanan maksimum sebanyak 100(extrabed amenyimpan kode
    // yang sudah digunakan)
    static int NUM_ROOMS = 3,
            JML_MASUKAN = 0,
            kamarDipesan[] = new int[NUM_ROOMS],
            ID_KAMAR[] = { 1, 2, 3 },
            jumlahKamar[] = { 11, 15, 12 },
            kamarTersedia[] = new int[3];

    static String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" },
            layananTambahan = { "Extra Bed", "Makanan", null },
            kodePromo = { "A", "IJENMALANG", "IJEN11" };

    // variabel untuk menyimpan/deklarasi JUMLAH KAMAR, pilihan (angka 1/2/3/4/5)/
    // dari menu(), input jumlah (malam ,dewasa, anak kecil, extrabed ), TEMPRORARY
    // VARIABAEL
    static int pilihMenu, pilihanKamar, jenisKamar, pilihExtraBed, pilihanLayanan[] = { 0, 0 },
            jumlahDewasa, jumlahAnak = 0,
            tempJumlahDewasa, tempJumlahExtraBed, tempJumlahAnak,
            i, sisaKapasitas;

    // variabel untuk menghitung biaya pemesanan (diskon, layanan dan kamar), juga
    // dipakai untuk menentukan max jumlah variabel
    static double[] hargaKamar = { 750000, 500000, 2000000 }, hargaLayanan = { 50000, 100000, 0 },
            disPromo = { 0.10, 0.15, 0.20 };

    // deklarasi scanner supaya bisa di pakai di seluruh fungsi didalam main dan
    // diluar main
    static Scanner input = new Scanner(System.in);

    // variabel boolean untuk mengatur while
    static boolean menu, menuLogin, menuUser, menuAdmin, menuInformasi, menuEditKamar, menuEditAdmin,
            menuEditFasilitasHotel, isPromo,
            kodeTidakValid, lanjut, lanjut1;

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

    // array 1 deklarasi dan memberikan nilai fasilitas hotel
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

    // data login register
    static String[] usernames = new String[100];
    static String[] passwords = new String[100];
    static String[] adminuser = new String[100];
    static String[] adminpass = new String[100];
    static String[] alamat = new String[100];
    static String[] namaLengkap = new String[100];
    static boolean[] isAdmin = new boolean[100];
    static int NUM_FLOORS = 10;
    static int[][] gedungStatus = new int[NUM_FLOORS][31]; // Menyimpan status reservasi gedung
    static int HTG_USER = 0;
    static int HTG_ADMIN = 0;

    // Mendapatkan tanggal hari ini
    static LocalDate today = LocalDate.now();

    // ID user SAVE ID & pemesanan & SAVE PEMESANAN
    static int ID_USER,
            ID_SAVE[] = new int[100],
            HTG_PEMESANAN,
            SAVE_HTG_PEMESANAN[] = new int[100],
            SAVE_PEMESANAN[][] = new int[100][100],

            jumlahKamarDiPesan[][] = new int[ID_SAVE.length][SAVE_HTG_PEMESANAN.length],
            jumlahMalam[][] = new int[ID_SAVE.length][SAVE_HTG_PEMESANAN.length],
            noRekening[][] = new int[ID_SAVE.length][SAVE_HTG_PEMESANAN.length],
            jumlahExtraBed;

    static double[][] hargaKamarDipilih = new double[ID_SAVE.length][SAVE_HTG_PEMESANAN.length],
            totalLayanan = new double[ID_SAVE.length][SAVE_HTG_PEMESANAN.length],
            totalBiaya = new double[ID_SAVE.length][SAVE_HTG_PEMESANAN.length];

    static String[][] tipeKamarDipilih = new String[ID_SAVE.length][100],
            kritik = new String[ID_SAVE.length][100];

    static String inputPromo,
            alatTransaksi[][] = new String[ID_SAVE.length][SAVE_HTG_PEMESANAN.length];

    static String extraBed[] = new String[3],
            kodeSudahDigunakan[][] = new String[ID_SAVE.length][3];
    // variabel menyimpan kembalian,diskon, total biaya, pembayaran
    static double kembalian, diskon, totalPemasukan = 0.0, pembayaran = 0.0;

    public static void pesanKamar() {
        diskon = 1;
        if (ID_USER == 0) {
            System.out.println(
                    "\n===============================================================================");
            System.out.println("              Silahkan Login User terlebih dahulu");
            System.out.println(
                    "===============================================================================");
            // Output detail booking

            tekanEnterKembaliKeMenu();

        }
        if (ID_USER == 0) {

        } else if (usernames[ID_USER - 1] != null && passwords[ID_USER - 1] != null) {
            do {
                lanjut = false;
                // awal penambahan kode case
                System.out.println("\n=================================================");
                System.out.println("==                Pesan Kamar:                 ==");
                System.out.println("=================================================");

                cekKetersediaan();
                do {

                    lanjut = true;
                    System.out.println("=================================================");
                    System.out.println("= Pilih tipe kamar: ");
                    for (int i = 0; i < tipeKamar.length; i++) {
                        System.out.println("=  " + (i + 1) + ". " + tipeKamar[i] + " - $" + hargaKamar[i]);
                    }

                    System.out.println("=================================================");
                    System.out.print("= Masukkan angka untuk memilih : ");

                    pilihanKamar = input.nextInt();

                    System.out.println("=================================================");

                    if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                        kamarDipesan[pilihanKamar - 1] = jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1];
                        kamarTersedia[pilihanKamar - 1] = jumlahKamar[pilihanKamar - 1]
                                - kamarDipesan[pilihanKamar - 1];

                        if (kamarTersedia[pilihanKamar - 1] == 0) {
                            System.out.println("Maaf kamar tidak tersedia, silahkan pilih kembali");

                        }
                        tipeKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1] = tipeKamar[pilihanKamar - 1];
                        hargaKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1] = hargaKamar[pilihanKamar - 1];
                        lanjut = false;
                    } else {
                        System.out.println("Inputan salah");
                        System.out.println("=================================================");
                    }
                } while (lanjut);

                do {

                    lanjut = true;
                    System.out.print("= Masukkan jumlah kamar yang Anda pesan : ");
                    jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1] = input.nextInt();
                    if (jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1] <= kamarTersedia[pilihanKamar - 1]) {
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
                jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1] = input.nextInt();

                hitungHariBooking();

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
                        totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1] += hargaLayanan[pilihanLayanan[i] - 1];

                        input.nextLine();
                        i++;

                    } else {
                        break;
                    }
                } while (lanjut);

                // hitung sebelum mendapatkan diskon
                totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1] = (jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1]
                        * jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1]
                        * hargaKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1])
                        + totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1];

                System.out.println("==          Total Biaya: " + totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1]);
                // proses in put promo dan berhitungan biaya
                fiturPromo();

                // input jumlah malam, allat transaksi, nominal pembayaran
                do {

                    lanjut = false;

                    System.out.println("=================================================");
                    System.out.print("= Masukkan alat transaksi (cc/cash): ");
                    alatTransaksi[ID_USER - 1][HTG_PEMESANAN - 1] = input.nextLine();
                    if (alatTransaksi[ID_USER - 1][HTG_PEMESANAN - 1].equalsIgnoreCase("cc")) {
                        System.out.println("=================================================");
                        System.out.print("= Masukkan no rekening anda: ");

                        noRekening[ID_USER - 1][HTG_PEMESANAN - 1] = input.nextInt();
                        input.nextLine();

                    } else if (alatTransaksi[ID_USER - 1][HTG_PEMESANAN - 1].equalsIgnoreCase("cash")) {

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
                    if (pembayaran >= totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1]) {
                        kembalian = pembayaran - totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1];

                        System.out.println("=================================================");
                        System.out.println("== Pembayaran diterima. Kembalian: Rp" + kembalian);
                        System.out.println("=================================================");
                        System.out.println("\n=================================================");
                        System.out.println("= Silahkan Cetak struk untuk konfirmasi pesanan =");
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
                        System.out.println("\nTekan Enter untuk Cetak Struk. ");
                        input.nextLine();
                        cetakStruk();
                        break;
                    } else if (keMenu.equalsIgnoreCase("N")) {
                        lanjut = true;
                        totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1] = 0.0;
                        jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1] = 0;
                        kodeSudahDigunakan[ID_USER - 1][i] = null;
                        totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1] = 0.0;
                        isPromo = false;

                    } else {
                        System.out.println("    Input tidak valid.");
                        input.nextLine();
                        kodeTidakValid = true;
                    }
                } while (kodeTidakValid);
                // tekanEnterKembaliKeMenu();
                // lanjut = true;

                // batas penambahan kode case
            } while (lanjut);
        }

    }

    // fungsi fitur main menu login

    // fungsi bukan fitur utama dibawah ini

    static void tanggalHariIni(LocalDate today) {

        // Menampilkan tanggal hari ini
        System.out.println("              " + today);
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

    public static void InvalidCetakStruk(String[][] param) {

        if (param[ID_USER - 1][HTG_PEMESANAN - 1] == null) {

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
                        for (int j = 0; j < ID_SAVE.length; j++) {
                            if (inputPromo.equals(kodeSudahDigunakan[j][i])) {
                                kodeTidakValid = true;
                                break;
                            }
                        }
                        isPromo = true;
                        diskon = (1 - disPromo[i]);
                        kodeSudahDigunakan[ID_USER - 1][i] = kodePromo[i];
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
            totalBiaya[ID_USER
                    - 1][HTG_PEMESANAN
                            - 1] = ((jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1]
                                    * jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1]
                                    * hargaKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1])
                                    + totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1]) * diskon;

            System.out.println("==  Total Biaya (Setelah Diskon): " + totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1]);
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
            if (tempJumlahDewasa <= (sisaKapasitas + (jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1] * 2))) {
                jumlahDewasa = tempJumlahDewasa;
                sisaKapasitas += ((jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1]) * 2
                        + (1 * jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1])) - jumlahDewasa;
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
                        if (jumlahExtraBed <= jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1]
                                && jumlahExtraBed != 0) {
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

        for (int i = 0; i < tipeKamar.length; i++) {
            System.out.println("==============================");
            System.out.println("== " + (i + 1) + ". " + tipeKamar[i]);
        }
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
            jenisKamar = 0;
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
            for (int i = 0; i < tipeKamar.length; i++) {
                System.out.println("==============================");
                System.out.println("== " + (i + 1) + ". " + tipeKamar[i]);
            }

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
                kamarDipesan[jenisKamar - 1] = jumlahKamarDiPesan[ID_USER - 1][HTG_PEMESANAN - 1];
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

    public static void pesanLayananTambahan() {
        boolean pesanLagi, pesanMenu;

        String pesanan = "";
        if (usernames[ID_USER - 1] != null && passwords[ID_USER - 1] != null) {

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
            System.out.println("=================================");
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
                            "= " + lokasi + " =");

                    System.out.println(
                            "=================================================================================");

                    break;
                case 2:
                    System.out.println(
                            "=================================================================================");
                    System.out.println(
                            "=                               Dekat dengan :                                  =");
                    System.out.println(
                            "=================================================================================");
                    System.out.println(
                            "= Pusat perbelanjaan :                                                          =");
                    System.out.println(
                            "= - Mall Olympic Garden                                                         =");
                    System.out.println(
                            "= Transportasi :                                                                =");
                    System.out.println(
                            "= Malang (MLG-Abdul Rachman Saleh) - 41 mnt berkendara                          =");
                    System.out.println(
                            "= - Stasiun Kereta Malang - 12 mnt berkendara                                   =");
                    System.out.println(
                            "= Tempat Makan :                                                                =");
                    System.out.println(
                            "= - Amstirdam Coffee Mergan - 4 mnt jalan kaki                                  =");
                    System.out.println(
                            "= - Tahu Telor Jeng Anis - 4 mnt jalan kak                                      =");
                    System.out.println(
                            "= - Subur Pork Meatball - 5 mnt jalan kaki                                      =");
                    System.out.println(
                            "= - Warung Subuh - 9 mnt jalan kaki                                             =");
                    System.out.println(
                            "= - Rujak Manis Ananas \"Pak Bejo - 4 mnt jalan kaki                             =");
                    System.out.println(
                            "=================================================================================");

                    break;
                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }
            System.out.print("\nApakah anda ingin input kembali (Y/N)? : ");
            keMenu = input.next();
            if (keMenu.equalsIgnoreCase("N")) {
                menu = false;
            }

        } while (keMenu.equalsIgnoreCase("Y"));
    }

    public static void kritikDanSaran() {
        // awal penambahan kode case
        if (usernames[ID_USER - 1] != null && passwords[ID_USER - 1] != null) {

            System.out.println("\n========================================================================");
            System.out.println("===                        Kritik Saran:                             ===");
            System.out.println("========================================================================");
            System.out.print("+==> : ");
            kritik[ID_USER - 1][JML_MASUKAN] = input.nextLine();

            System.out.println("\n========================================================================");
            System.out.println("==                 :Terima kasih atas feedback Anda!:                 ==");
            System.out.println("========================================================================");

            JML_MASUKAN++;
            tekanEnterKembaliKeMenu();
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

    public static void cetakStruk() {
        // fungsi invalid cetak struk jika belum memesan
        // InvalidCetakStruk(namaPemesan,tipeKamarDipilih);

        // awal penambahan kode case
        if (usernames[ID_USER - 1] != null && passwords[ID_USER - 1] != null) {

            if (tipeKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1] != null) {
                System.out.println("\n======================================================");
                System.out.println("===                 Detail Booking:                ===");
                System.out.println("======================================================");
                System.out.println("=    Nama Pemesan:" + namaLengkap[ID_USER - 1]);
                System.out.println("======================================================");
                System.out.println("=    Tipe Kamar: " + tipeKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Harga Kamar : Rp" + hargaKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Layanan Tambahan:");
                i = 0;
                while (totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1] != 0 | i < layananTambahan.length) {
                    // int pilihanLayanan = input.nextInt();
                    // int pilihanLayanan = input.nextInt();
                    for (i = 0; i < pilihanLayanan.length; i++) {
                        if (totalLayanan[ID_USER - 1][HTG_PEMESANAN - 1] != 0) {

                            System.out.println("=    - " + layananTambahan[pilihanLayanan[i] - 1] + " - $"
                                    + hargaLayanan[pilihanLayanan[i] - 1]);
                        }
                    }
                    break;
                }

                System.out.println("======================================================");
                System.out.println("=    Alat Transaksi: " + alatTransaksi[ID_USER - 1][HTG_PEMESANAN - 1]);
                System.out.println("======================================================");

                if (alatTransaksi[ID_USER - 1][HTG_PEMESANAN - 1].equalsIgnoreCase("cc")) {
                    System.out.println("=    No Rekening Anda : " + noRekening[ID_USER - 1][HTG_PEMESANAN - 1]);
                    System.out.println("======================================================");

                }
                System.out.println("=    Jumlah Malam Menginap: " + jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1]);
                System.out.println("======================================================");
                System.out.println("=    Total Biaya: Rp" + totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1]);
                System.out.println("======================================================");

                // Proses pembayaran

                kembalian = pembayaran - totalBiaya[ID_USER - 1][HTG_PEMESANAN - 1];
                System.out.println("=    Pembayaran diterima. Kembalian: Rp" + kembalian);
                System.out.println("======================================================");
                System.out.println("\n   ==== Terima kasih telah melakukan booking! ====    ");

                HTG_PEMESANAN++;

                tekanEnterKembaliKeMenu();
                // batas penambahan kode case

            } else {
                if (tipeKamarDipilih[ID_USER - 1][HTG_PEMESANAN - 1] == null) {

                    System.out.println(
                            "\n===============================================================================");
                    System.out.println("              Silahkan isi data pemesanan kamar terlebih dahulu");
                    System.out.println(
                            "===============================================================================");
                    // Output detail booking

                    tekanEnterKembaliKeMenu();

                }
            }
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

            // untuk edit contact person
            System.out.print("Input Nomor Telepon : ");
            telepon = input.nextLine();
            System.out.print("Input Email : ");
            email = input.nextLine();
            System.out.print("Input Website : ");
            website = input.nextLine();

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

        if (kritik[ID_USER - 1][JML_MASUKAN] == null) {
            System.out.println("\n==   Belum ada data kritik saran yang masuk. ==");
            System.out.println("\nTekan Enter untuk kembali. ");
            input.nextLine();
        }

        for (int i = 0; i < JML_MASUKAN; i++) {

            System.out.println("\nMasukkan : " + (i + 1));
            System.out.println(

                    "========================================================================");
            System.out.println("Nama:             " + usernames[ID_USER - 1]);
            System.out.println(
                    "========================================================================");
            System.out.println("====                          Kritik:                               ====");
            System.out.println(
                    "========================================================================");
            System.out.println("= +==>            " + kritik[ID_USER - 1][JML_MASUKAN]);

        }

    }

    public static void fiturLaporan() {

        do {
            lanjut = true;
            System.out.println("\n1. Tampilkan Reservasi" +
                    "\n2. Perbarui Reservasi" +
                    "\n3. Hapus Reservasi" +
                    "\n0. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {

                case 1:
                    System.out.println("Semua Reservasi:");
                    lanjut1 = true;
                    for (int i = 0; i <= ID_SAVE.length; i++) {
                        for (int j = 0; j < SAVE_HTG_PEMESANAN.length; j++) {
                            if (totalBiaya[i][j] == 0) {
                                System.out.println("\n== Belum ada data pemesanan yang telah masuk. ==");
                                lanjut1 = false;
                                System.out.println("\nTekan Enter untuk kembali. ");
                                input.nextLine();
                                break;
                            }
                        }
                        break;
                    }
                    while (lanjut1) {
                        for (int i = 0; i < ID_SAVE.length; i++) {
                            for (int j = 0; j < SAVE_HTG_PEMESANAN.length; j++) {
                                if (totalBiaya[i][j] != 0) {
                                    System.out.println("ID Reservasi: " + ID_SAVE[i] +
                                            ", Nama Tamu: " + namaLengkap[i] +
                                            ", Jenis Kamar: " + tipeKamarDipilih[i][j] +
                                            ", Jumlah Kamar: " + jumlahKamarDiPesan[i][j] +
                                            ", Total Bayar: " + totalBiaya[i][j]);
                                }
                            }
                        }

                        for (int i = 0; i < ID_SAVE.length; i++) {
                            for (int j = 0; j < SAVE_HTG_PEMESANAN.length; j++) {
                                if (totalBiaya[i][j] != 0) {
                                    totalPemasukan += totalBiaya[i][j];
                                }
                            }
                        }
                        System.out.println();
                        System.out.println("-------------------------------    Total pemasukan dari pesanan kamar = "
                                + totalPemasukan + "     -------------------------------  ");

                        tekanEnterKembaliKeSebelumnya();
                    }
                    break;
                case 2:
                    System.out.print("Masukkan ID user yang akan diperbarui: ");
                    int updateId = input.nextInt();
                    System.out.print("Masukkan No pesanan yang akan diperbarui: ");
                    int updateNo = input.nextInt();
                    int updateIndex = -1;
                    input.nextLine();

                    for (int i = 1; i <= ID_SAVE.length; i++) {
                        for (int j = 1; j <= SAVE_HTG_PEMESANAN.length; j++) {
                            if (ID_SAVE[i - 1] == updateId && SAVE_HTG_PEMESANAN[j - 1] == updateNo) {
                                updateIndex = ID_SAVE[i - 1];
                                break;
                            }
                        }
                        break;
                    }

                    if (updateIndex != -1) {

                        // untuk menampilkan jenis kamar perulangan
                        System.out.println("\n=====:Pilih Jenis Kamar:=====");
                        System.out.println();
                        for (int i = 0; i < tipeKamar.length; i++) {
                            System.out.println("==============================");
                            System.out.println("== " + (i + 1) + ". " + tipeKamar[i]);
                        }
                        System.out.println("==============================");
                        System.out.println();
                        System.out.print("Masukkan jenis kamar: ");
                        int pilihan = input.nextInt();
                        tipeKamarDipilih[updateIndex - 1][updateNo - 1] = tipeKamar[pilihan - 1];
                        System.out.print("Masukkan jumlah kamar: ");
                        jumlahKamarDiPesan[updateIndex - 1][updateNo - 1] = input.nextInt();

                        System.out.println("Reservasi berhasil diperbarui:\nID Reservasi: " +
                                ID_SAVE[updateIndex - 1] + ",No Pesanan: " + updateNo +
                                ", Nama Tamu: " + namaLengkap[updateIndex - 1] +
                                ", Jenis Kamar: " + tipeKamarDipilih[updateIndex - 1][updateNo - 1] +
                                ", Jumlah Kamar: " + jumlahKamarDiPesan[updateIndex - 1][updateNo - 1]);
                    } else {
                        System.out.println(
                                "\nReservasi tidak ditemukan dengan ID: " + updateId + ", No pesanan: " + updateNo);

                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 3:
                    System.out.print("Masukkan ID reservasi yang akan dihapus: ");
                    int deleteId = input.nextInt();
                    System.out.print("Masukkan No pesanan yang akan diperbarui: ");
                    int deleteNo = input.nextInt();
                    input.nextLine();
                    int deleteIndex = -1;

                    for (int i = 1; i <= ID_SAVE.length; i++) {
                        for (int j = 1; j <= SAVE_HTG_PEMESANAN.length; j++) {
                            if (ID_SAVE[i - 1] == deleteId && SAVE_HTG_PEMESANAN[j - 1] == deleteNo) {
                                deleteIndex = ID_SAVE[i - 1];
                                break;
                            }
                        }
                        break;
                    }

                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i <= ID_SAVE[ID_USER - 1]; i++) {

                            tipeKamarDipilih[i][deleteNo - 1] = tipeKamarDipilih[i][deleteNo];
                            jumlahKamarDiPesan[i][deleteNo - 1] = jumlahKamarDiPesan[i][deleteNo];
                            break;

                        }

                        ID_USER--;

                        System.out.println(
                                "Reservasi berhasil dihapus dengan ID: " + deleteId + ", No pesanan: " + deleteNo);

                    } else {
                        System.out.println(
                                "\nReservasi tidak ditemukan dengan ID: " + deleteId + ", No pesanan: " + deleteNo);
                    }
                    tekanEnterKembaliKeSebelumnya();
                    break;
                case 0:
                    lanjut = false;
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
        double[] newhargaKamar = new double[newLength];
        double[] newHargaLayanan = new double[newLength];
        String[][] newFasilitas = new String[newLength][50];

        for (int i = 0; i < tipeKamar.length; i++) {
            newTipeKamar[i] = tipeKamar[i];
            newJumlahKamar[i] = jumlahKamar[i];
            newID_KAMAR[i] = ID_KAMAR[i];
            newKamarTersedia[i] = kamarTersedia[i];
            newKamarDipesan[i] = kamarDipesan[i];
            newhargaKamar[i] = hargaKamar[i];
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
        hargaKamar = newhargaKamar;
        hargaLayanan = newHargaLayanan;
        fasilitasKamar = newFasilitas;

        System.out.print("Masukkan Nama Tipe Kamar : ");
        String tipeKamarBaru = input.nextLine();

        System.out.println("Masukkan Fasilitas Kamar : ");

        for (int j = 0; j < fasilitasKamar[0].length; j++) {
            System.out.print(" - Fasilitas ke " + (j + 1) + " : ");
            String fasilitasBaru = input.nextLine();
            fasilitasKamar[NUM_ROOMS][j] = fasilitasBaru;
            if (j % 10 == 0) {
                System.out.println("\n tekan X untuk berhenti, enter untuk lanjut");
                String berhenti = input.next();
                if (berhenti.equalsIgnoreCase("x")) {
                    break;
                }
            }
        }

        System.out.print("Masukkan Jumlah Kamar : ");
        int jumlahKamarBaru = input.nextInt();

        System.out.print("Masukkan Harga Per Malam : ");
        double hargaKamarBaru = input.nextDouble();

        ID_KAMAR = newID_KAMAR;
        tipeKamar[NUM_ROOMS] = tipeKamarBaru;
        jumlahKamar[NUM_ROOMS] = jumlahKamarBaru;
        hargaKamar[NUM_ROOMS] = hargaKamarBaru;

        tipeKamar = newTipeKamar;
        jumlahKamar = newJumlahKamar;

        ID_KAMAR[NUM_ROOMS] = NUM_ROOMS + 1;

        NUM_ROOMS++;

        System.out.println("Kamar telah ditambahkan.");
        input.nextLine();
        tekanEnterKembaliKeMenu();

    }

    public static void fungsiFasilitasHotel() {

        System.out.println("===============================");
        System.out.println(((jenisKamar - 1) + 1) + ". " + tipeKamar[jenisKamar - 1]);
        System.out.println("===============================");
        System.out.println("= Fasilitas: ");
        for (int j = 0; j < fasilitasKamar[jenisKamar - 1].length; j++) {

            if (fasilitasKamar[jenisKamar - 1][j] != null) {
                System.out.println("= ^ " + fasilitasKamar[jenisKamar - 1][j]);
            }
            // untuk meresat agar jenis kamar tidak stuck 1 jenis kamar
        }

    }

    public static void main(String[] args) {
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
            System.out.println("3. Informasi Hotel");
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
                    informasiHotel();
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

    public static void menulogin(String[] args) {

        do {
            menuLogin = true;
            ID_USER = 0;
            System.out.println("\n=======================================");
            System.out.println("=              Menu Login :           =");
            System.out.println("=======================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Kembali");
            System.out.println("=======================================");
            System.out.print("+==> Pilih Menu : ");
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
                    menuLogin = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih kembali.");
                    break;
            }
        } while (menuLogin);
    }

    public static void login(String[] args) {

        System.out.println("\n=======================================");
        System.out.println("=             Login :         =");
        System.out.println("=======================================");
        System.out.print("Masukkan username : ");
        String username = input.next();
        System.out.print("Masukkan password : ");
        String password = input.next();

        for (int i = 0; i < HTG_USER; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                ID_USER = i + 1;
                ID_SAVE[i] = ID_USER;
                HTG_PEMESANAN = 1;
                System.out.println("\n=======================================");
                System.out.println("=          Login User Berhasil        =");
                System.out.println("=======================================");
                System.out.println();
                // Tambahkan logika menu user di sini
                menuUser(args);
            } else if (username.equalsIgnoreCase(adminuser[i]) && password.equalsIgnoreCase(adminpass[i])
                    || username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")) {
                System.out.println("\n=======================================");
                System.out.println("=          Login Admin Berhasil       =");
                System.out.println("=======================================");
                System.out.println();
                // Tambahkan logika menu admin di sini
                menuAdmin(args);
            } else {
                System.out.println("\n== Username atau password salah. Silakan coba lagi. ==");
            }
        }
    }

    public static void register() {
        if (HTG_USER < usernames.length) {

            System.out.println("\n=======================================");
            System.out.println("=               Register :            =");
            System.out.println("=======================================");
            System.out.print("Masukkan Username : ");
            String newUsername = input.nextLine();

            // Check if the username is already taken
            boolean isUsernameTaken = false;
            for (int i = 0; i < HTG_USER; i++) {
                if (usernames[i].equals(newUsername)) {
                    isUsernameTaken = true;
                    break;
                }
            }

            if (isUsernameTaken) {
                System.out.println("\n== Username sudah terdaftar. Silakan pilih username lain. ==");
            } else {
                System.out.print("Masukkan Nama Lengkap : ");
                String newNamaLengkap = input.nextLine();
                System.out.print("Masukkan Alamat : ");
                String newAlamat = input.nextLine();
                System.out.print("Masukkan Password : ");
                String newPassword = input.nextLine();

                // Simpan username, password, dan status admin baru
                usernames[HTG_USER] = newUsername;
                passwords[HTG_USER] = newPassword;
                namaLengkap[HTG_USER] = newNamaLengkap;
                alamat[HTG_USER] = newAlamat;

                HTG_USER++;

                System.out.println("\n==        Registrasi berhasil!       ==");

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
            System.out.println("3. Reservasi Gedung");
            System.out.println("4. Kritik dan Saran");
            System.out.println("5. Informasi Hotel");
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
                    reservasiGedungHotel();
                    break;
                case 4:
                    kritikDanSaran();
                    break;
                case 5:
                    informasiHotel();
                    break;
                case 0:
                    ID_USER = 0;
                    HTG_PEMESANAN = 0;
                    main(args);
                    break;
                default:
                    System.out.println("\nInput salah!");

                    break;
            }
        } while (menuUser);

    }


    public static void informasiHotel() {
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
                    deskripsiHotel();
                    break;
                case 2:
                    fasilitasHotel();
                    break;
                case 3:
                    lokasiHotel();
                case 4:
                    contactPerson(nama, email, telepon);
                    break;
                case 0:
                    menuInformasi = false;
                    break;
                default:
                    System.out.println("\nInput salah!");

                    break;

            }
        } while (menuInformasi);

    }

    // fungsi menampilkan deskripsi hotel
    public static void deskripsiHotel() {
        System.out.println("\nDeskripsi : ");
        System.out.println("===================================================================================");
        System.out.println("=                                                                                 =");
        System.out.println("=  Ijen Suites Resort & Convention Hotel menawarkan suasana luar biasa baik bagi  =" +
                "\n=  pelancong bisnis maupun rekreasi di Malang. Dengan kombinasi desain resor dan  =" +
                "\n=  fasilitas konvensi, Ijen Suites Resort & Convention Hotel adalah pilihan tepat =" +
                "\n=  untuk kebutuhan acara dan akomodasi Anda. Terletak di salah satu kawasan       =" +
                "\n=  paling bergengsi di Malang, Ijen Nirwana Residence, Ijen Suites Resort &       =" +
                "\n=  Convention Hotel dikelilingi oleh banyak fasilitas untuk menunjang kebutuhan,  =" +
                "\n=  para tamu. Mall Olympic Garden yang menyediakan pusat perbelanjaan, minimarket =" +
                "\n=  pusat kuliner, dan ATM hanya berjarak sepelemparan batu dari Ijen Suites       =" +
                "\n=  Resort & Convention Hotel.                                                     =");
        System.out.println("=                                                                                 =");
        System.out.println("===================================================================================");

        System.out.println("\nTekan enter untuk kembali");
        input.nextLine();
        System.out.println("=======================================");
    }

    // fungsi menampilkan semua fasilitas hotel
    public static void fasilitasHotel() {
        System.out.println("\n=======================================");
        System.out.println("=           Fasilitas Hotel :         =");
        System.out.println("=======================================");

        for (int j = 0; j < fasilitasHotel.length; j++) {
            System.out.println("= ^ " + fasilitasHotel[j]);

            if (j != 0 && j % 10 == 0) {
                System.out.println("Tekan enter untuk lanjut");
                input.nextLine();
                System.out.println("=======================================");
            }
        }
    }

    // funsi halaman menu admin
    public static void menuAdmin(String[] args) {

        do {
            menuAdmin = true;
            System.out.println("\n=======================================");
            System.out.println("Selamat Datang di Menu Admin");
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu : ");
            System.out.println("1. Edit Kamar");// ketersediaan kamar
            System.out.println("2. Edit Admin");
            System.out.println("3. Edit Contact Person");
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
                    editLokasi();
                    break;
                case 5:
                    editFasilitasHotel();
                    break;
                case 6:
                    lihatKritikSaran();
                    break;
                case 7:
                    fiturLaporan();
                    break;
                case 0:
                    main(args);
                    break;
                default:
                    System.out.println("\n== Input Salah ");
                    break;
            }
        } while (menuAdmin);

        input.nextLine();

    }

    public static void editLokasi() {
        do {
            lanjut = true;

            // untuk edit contact person

            System.out.print("Input Lokasi : ");
            website = input.nextLine();

            System.out.println(
                    "\nApakah anda ingin input kembali (Y/N)? : ");
            keMenu = input.nextLine();
            if (keMenu.equalsIgnoreCase("Y")) {

            } else if (keMenu.equalsIgnoreCase("N")) {
                lanjut = false;
            }
        } while (lanjut);

    }

    public static void editFasilitasHotel() {
        do {
            menuEditFasilitasHotel = true;
            System.out.println("\n=======================================");
            System.out.println("=            Edit Admin :             =");
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu : ");
            System.out.println("1. Tambah Fasilitas Hotel");
            System.out.println("2. Perbarui Fasilitas Hotel");
            System.out.println("0. Kembali");
            System.out.println("=======================================");
            System.out.print("+==> Pilih Menu : ");
            int pilihMenu = input.nextInt();
            input.nextLine();
            switch (pilihMenu) {
                case 1:
                    // perbaruiFasilitas();
                    System.out.print("Masukkan Fasilitas Hotel : ");

                    for (int j = 0; j < fasilitasKamar[0].length; j++) {
                        System.out.print(" - Fasilitas ke " + (j + 1) + " : ");
                        String fasilitasHotelBaru = input.nextLine();
                        fasilitasHotel[j] = fasilitasHotelBaru;
                        if (j % 10 == 0) {
                            System.out.println("\n tekan X untuk berhenti, enter untuk lanjut");
                            String berhenti = input.next();
                            if (berhenti.equalsIgnoreCase("x")) {
                                break;
                            }
                        }
                    }

                    System.out.println("Fasilitas telah ditambahkan.");
                    input.nextLine();
                    tekanEnterKembaliKeMenu();

                    break;
                case 2:
                    // tambahFasilitasHotel();
                    int newLength = (fasilitasHotel.length + 1);
                    String[] newFasilitasHotel = new String[newLength];

                    for (int i = 0; i < fasilitasHotel.length; i++) {
                        newFasilitasHotel[i] = fasilitasHotel[i];
                    }

                    fasilitasHotel = newFasilitasHotel;

                    System.out.print("Masukkan Fasilitas Hotel : ");

                    for (int j = 0; j < fasilitasKamar[0].length; j++) {
                        System.out.print(" - Fasilitas ke " + (j + 1) + " : ");
                        String fasilitasHotelBaru = input.nextLine();
                        fasilitasHotel[j] = fasilitasHotelBaru;
                        if (j % 10 == 0) {
                            System.out.println("\n tekan X untuk berhenti, enter untuk lanjut");
                            String berhenti = input.next();
                            if (berhenti.equalsIgnoreCase("x")) {
                                break;
                            }
                        }
                    }

                    System.out.println("Fasilitas telah diperbarui.");
                    input.nextLine();
                    tekanEnterKembaliKeMenu();

                    break;
                case 0:
                    menuEditFasilitasHotel = false;
                    break;
                default:
                    System.out.println("== inputan salah. ==");

                    break;
            }
        } while (menuEditFasilitasHotel);
    }

    public static void menuEditKamar() {
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
                    menuEditKamar = false;
                    break;
                default:
                    System.out.println("== inputan salah. ==");

                    break;
            }
        } while (menuEditKamar);
    }

    public static void menuEditAdmin() {
        do {

            menuEditAdmin = true;
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
                    if (HTG_ADMIN < usernames.length) {

                        System.out.println("\n=======================================");
                        System.out.println("=               Tambah Admin :            =");
                        System.out.println("=======================================");
                        System.out.print("Masukkan Username : ");
                        String newUsername = input.nextLine();
                        System.out.print("Masukkan Password : ");
                        String newPassword = input.nextLine();

                        // Simpan username, password, dan status admin baru
                        adminuser[HTG_ADMIN] = newUsername;
                        adminpass[HTG_ADMIN] = newPassword;

                        HTG_ADMIN++;

                        System.out.println("\n==       Tambah Admin berhasil!       ==");

                    } else {
                        System.out.println("\n== Maaf, jumlah Admin sudah mencapai batas maksimal. ==");
                    }

                    break;
                case 2:

                    System.out.println("\n=======================================");
                    System.out.println("=               Perbarui Admin :            =");
                    System.out.println("=======================================");
                    System.out.println("Masukkan ID Admin :");
                    int adminid = input.nextInt();

                    if (adminuser[adminid] != null) {
                        for (int i = adminid; i < adminuser.length; i++) {
                            System.out.print("Masukkan Username baru: ");
                            adminuser[i] = input.nextLine();
                            System.out.print("Masukkan Password : ");
                            adminpass[i] = input.nextLine();
                        }
                    } else {
                        System.out.println("ID tidak ditemukan. ");

                    }

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

    public static void hitungHariBooking() {
        // Meminta estimasi hari menginap
 System.out.println("=================================================");
        System.out.println("= Waktu Menginap : " + jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1] + " hari");

        // Menerima input tanggal menginap
         System.out.println("=================================================");
        System.out.print("= Masukkan Tanggal Check In (dd/MM/yyyy) : ");
        String inputTanggalCheckin = input.next(); // Membaca input tanggal
        // Parsing input tanggal menginap menjadi objek LocalDate

        LocalDate tanggalCheckin = LocalDate.parse(inputTanggalCheckin, formatter);// mengonversi input tanggal checkin
                                                                                   // dari string ke objek LocalDate
          System.out.println("=================================================");                                                                          
        System.out.println("= Tanggal Check In : " + tanggalCheckin.format(formatter));

        // Menghitung dan menampilkan tanggal checkout berdasarkan hari
        LocalDate tanggalCheckout = tanggalCheckin.plusDays(jumlahMalam[ID_USER - 1][HTG_PEMESANAN - 1]);
         System.out.println("=================================================");
        System.out.println("= Tanggal Check Out : " + tanggalCheckout.format(formatter));
    }

    public static void reservasiGedungHotel() {
       

        System.out.println("=======================================");
        System.out.println("        Reservasi Gedung Hotel        ");
        System.out.println("=======================================");

        // Input acara apa
        System.out.print("Masukkan jenis acara: ");
        String jenisAcara = input.nextLine();

        // Input lantai berapa
        System.out.print("Masukkan lantai gedung (1-" + NUM_FLOORS + "): ");
        int lantai = input.nextInt();
        if (lantai < 1 || lantai > NUM_FLOORS) {
            System.out.println("Lantai tidak valid.");
            return;
        }

        // Input tanggal mulai
        System.out.print("Masukkan tanggal mulai (1-30): ");
        int tanggalMulai = input.nextInt();
        if (tanggalMulai < 1 || tanggalMulai > 30) {
            System.out.println("Tanggal tidak valid.");
            return;
        }

        // Input tanggal selesai
        System.out.print("Masukkan tanggal selesai (tanggal harus setelah tanggal mulai): ");
        int tanggalSelesai = input.nextInt();
        if (tanggalSelesai < tanggalMulai || tanggalSelesai > 30) {
            System.out.println("Tanggal tidak valid.");
            return;
        }

        // Cek ketersediaan gedung
        if (cekKetersediaanGedung(lantai, tanggalMulai, tanggalSelesai)) {
            // Lakukan reservasi
            reservasiGedung(lantai, tanggalMulai, tanggalSelesai, jenisAcara);
            System.out.println("Reservasi berhasil!");
        } else {
            System.out.println("Gedung tidak tersedia pada tanggal tersebut.");
        }
    }

    // Fungsi untuk mengecek ketersediaan gedung pada tanggal tertentu di lantai
   
    static boolean cekKetersediaanGedung(int lantai, int tanggalMulai, int tanggalSelesai) {
        for (int tanggal = tanggalMulai; tanggal <= tanggalSelesai; tanggal++) {
            if (gedungStatus[lantai - 1][tanggal] == 1) {
                return false; // Gedung sudah dipesan pada tanggal tersebut
            }
        }
        return true; // Gedung tersedia pada tanggal tersebut
    }

    // Fungsi untuk melakukan reservasi gedung pada tanggal tertentu di lantai
   
    static void reservasiGedung(int lantai, int tanggalMulai, int tanggalSelesai, String jenisAcara) {
        for (int tanggal = tanggalMulai; tanggal <= tanggalSelesai; tanggal++) {
            gedungStatus[lantai - 1][tanggal] = 1; // Menandakan gedung sudah dipesan pada tanggal tersebut
        }

        // Tambahkan logika lain yang diperlukan untuk menyimpan informasi reservasi

        System.out.println("Reservasi untuk acara " + jenisAcara + " di lantai " + lantai +
                " dari tanggal " + tanggalMulai + " sampai tanggal " + tanggalSelesai + ".");

                System.out.println("Tekan enter untuk kembali.");
                input.nextLine();
    }
}
