
import java.util.Scanner;
import java.time.LocalDate;

public class testFinalCode {
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
            System.out.println("Selamat Datang di Ijen Suites Hotel!");
            tanggalHariIni(today);
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu");
            System.out.println("1. Rincian Kamar");
            System.out.println("2. Pesan & Cek Kamar ");
            System.out.println("3. Pesan Layanan Tambahan (Makanan/Extra Bed/Sewa Aula)");
            System.out.println("4. Contact Person");
            System.out.println("5. Lokasi Hotel");
            System.out.println("6. Kritik dan Saran");
            System.out.println("7. Fasilitas Hotel");
            System.out.println("8. Cetak Struk");
            System.out.println("98. Login User");
            System.out.println("99. Login Admin");

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
                    System.out.println("\nInput salah!");
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

        if (param1[id - 1] == null && param2[id - 1] == null) {

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
            totalBiaya[id - 1] = ((jumlahKamarDiPesan[id - 1] * jumlahMalam * selectedRoomPrice[id - 1])
                    + totalLayanan[id - 1]) * diskon;

            System.out.println("==  Total Biaya (Setelah Diskon): " + totalBiaya[id - 1]);
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
            if (tempJumlahDewasa <= (sisaKapasitas + (jumlahKamarDiPesan[id - 1] * 2))) {
                jumlahDewasa = tempJumlahDewasa;
                sisaKapasitas += ((jumlahKamarDiPesan[id - 1]) * 2 + (1 * jumlahKamarDiPesan[id - 1])) - jumlahDewasa;
            } else {
                System.out.println(
                        "=== Jumlah orang dewasa melebihi kapasitas kamar, silahkan menambah kamar/extra bed ==");
                input.nextLine();
                System.out.println("==========================================");
                System.out.println("= apakah anda ingin menambahkan extra bed (Y/N)");
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
                        if (jumlahExtraBed <= jumlahKamarDiPesan[id - 1] && jumlahExtraBed != 0) {
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
                konfirmasiBed = input.nextLine();

                if (konfirmasiBed.equalsIgnoreCase("Y")) {
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
                if (jenisKamar > kamarDipesan.length) {
                    System.out.println("Inputan melebihi jumlah jenis kamar");
                    lanjut = true;
                }
            } while (lanjut);
            if ((jenisKamar) <= kamar.length) {
                // menampilkan jenis kamar
                System.out.println(kamar[jenisKamar - 1]);

            } else {
                System.out.println();
                System.out.println("== Data tidak ada, inputan salah. ==");
                System.out.println();
            }

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
                    if (jenisKamar > kamarDipesan.length || jenisKamar == 0) {
                        System.out.println("Inputan melebihi jumlah jenis kamar");
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
        if (userUser == null && passUser == null) {
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
                    System.out.println("print save id " + idSave[0]);

                    System.out.println("print id " + id);
                    System.out.println("=================================================");
                    System.out.print("= Masukkan nama pemesan: ");
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

                    System.out.println("= Pilih tipe kamar: ");
                    for (int i = 0; i < tipeKamar.length; i++) {
                        System.out.println("=  " + (i + 1) + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
                    }

                    System.out.println("=================================================");
                    System.out.print("= Masukkan angka untuk memilih : ");

                    pilihanKamar = input.nextInt();

                    System.out.println("=================================================");

                    if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                        kamarDipesan[pilihanKamar - 1] = jumlahKamarDiPesan[id - 1];
                        kamarTersedia[pilihanKamar - 1] = jumlahKamar[pilihanKamar - 1]
                                - kamarDipesan[pilihanKamar - 1];

                        if (kamarTersedia[pilihanKamar - 1] == 0) {
                            System.out.println("Maaf kamar tidak tersedia, silahkan pilih kembali");

                        }
                        selectedRoomType[id - 1] = tipeKamar[pilihanKamar - 1];
                        selectedRoomPrice[id - 1] = hargaPerMalam[pilihanKamar - 1];
                        lanjut = false;
                    } else {
                        System.out.println("Inputan salah");
                        System.out.println("=================================================");
                    }
                } while (lanjut);

                do {

                    lanjut = true;
                    System.out.print("= Masukkan jumlah kamar yang Anda pesan : ");
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

                System.out.println("==          Total Biaya: " + totalBiaya[id - 1]);
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
                    if (pembayaran >= totalBiaya[id - 1]) {
                        kembalian = pembayaran - totalBiaya[id - 1];

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
                        id++;
                        tekanEnterKembaliKeSebelumnya();
                        break;
                    } else if (keMenu.equalsIgnoreCase("N")) {
                        lanjut = true;
                        namaPemesan[id - 1] = null;
                        totalBiaya[id - 1] = 0;
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
                default:
                    System.out.println("Opsi tidak valid.");
            }

            tekanEnterKembaliKeMenu();

        } while (keMenu.equalsIgnoreCase("N"));
    }

    public static void kritikDanSaran() {
        // awal penambahan kode case
        System.out.println("\n========================================================================");
        System.out.println("===                        Kritik Saran:                             ===");
        System.out.println("========================================================================");
        System.out.print("= Masukkan nama Anda: ");
        namaPenulis[counterKS] = input.nextLine();
        System.out.println("========================================================================");
        System.out.println("==          Masukkan kritik & fitur yang ingin Anda tambahkan:          ==");
        System.out.println("========================================================================");
        System.out.print("= +==>: ");
        kritik[counterKS] = input.nextLine();

        System.out.println("\n========================================================================");
        System.out.println("\n             ===== :Terima kasih atas feedback Anda!: =====             ");
        System.out.println("\n========================================================================");
        System.out.println("Nama: " + namaPenulis[counterKS]);
        System.out.println("========================================================================");
        System.out.println("====                          Kritik:                               ====");
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
                System.out.println("=    Nama Pemesan:" + namaPemesan[id - 1]);
                System.out.println("======================================================");
                System.out.println("=    Tipe Kamar: " + selectedRoomType[id - 1]);
                System.out.println("======================================================");
                System.out.println("=    Harga Kamar : Rp" + selectedRoomPrice[id - 1]);
                System.out.println("======================================================");
                System.out.println("=    Layanan Tambahan:");
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
                System.out.println("=    Alat Transaksi: " + alatTransaksi);
                System.out.println("======================================================");

                if (alatTransaksi.equalsIgnoreCase("cc")) {
                    System.out.println("=    No Rekening Anda : " + noRekening);
                    System.out.println("======================================================");

                }
                System.out.println("=    Jumlah Malam Menginap: " + jumlahMalam);
                System.out.println("======================================================");
                System.out.println("=    Total Biaya: Rp" + totalBiaya[id - 1]);
                System.out.println("======================================================");

                // Proses pembayaran

                kembalian = pembayaran - totalBiaya[id - 1];
                System.out.println("=    Pembayaran diterima. Kembalian: Rp" + kembalian);
                System.out.println("======================================================");
                System.out.println("\n   ==== Terima kasih telah melakukan booking! ====    ");

                id++;

                tekanEnterKembaliKeMenu();
                // batas penambahan kode case

            } else
                InvalidCetakStruk(namaPemesan, selectedRoomType);
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

    public static void loginUser(String[] args) {
        do {
            System.out.println("\n===============================");
            System.out.println("=        Login User:         =");
            System.out.println("===============================");
            lanjut = false;
            System.out.print("Masukkan username : ");
            userUser = input.nextLine();
            System.out.print("Masukkan password : ");
            passUser = input.nextLine();
            if (userUser.equals("user") && passUser.equals("12345")) {
                System.out.println("===============================");
                System.out.println("=        Login Berhasil         =");
                System.out.println("===============================");
                System.out.println();
                do {
                    menu = false;
                    System.out.println("\n=======================================");
                    System.out.println("Selamat Datang di Ijen Suites Hotel!");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu");
                    System.out.println("1. Rincian Kamar");
                    System.out.println("2. Pesan & Cek Kamar ");
                    System.out.println("3. Pesan Layanan Tambahan (Makanan/Extra Bed/Sewa Aula)");
                    System.out.println("4. Contact Person");
                    System.out.println("5. Lokasi Hotel");
                    System.out.println("6. Kritik dan Saran");
                    System.out.println("7. Fasilitas Hotel");
                    System.out.println("8. Cetak Struk ");
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
                System.out.println("=        Login Gagal!        =");
                System.out.println("===============================");
                System.out.println("\nApakah anda ingin input kembali (Y/N)? : ");
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
            System.out.print("Masukkan username : ");
            userAdmin = input.nextLine();
            System.out.print("Masukkan password : ");
            passAdmin = input.nextLine();

            if (userAdmin.equals("admin") && passAdmin.equals("12345")) {
                System.out.println("===============================");
                System.out.println("=        Login Berhasil         =");
                System.out.println("===============================");
                System.out.println();
                do {
                    menu = false;
                    System.out.println("\n=======================================");
                    System.out.println("Selamat Datang di Menu Admin");
                    System.out.println("=======================================");
                    System.out.println("Silahkan Pilih Menu");
                    System.out.println("1. Edit Ketersediaan Kamar");
                    System.out.println("2. Edit Contact Person");
                    System.out.println("3. Edit Lokasi Hotel");
                    System.out.println("4. Lihat Kritik dan Saran");
                    System.out.println("5. Edit Fasilitas Hotel");
                    System.out.println("6. Lihat & Edit Laporan");
                    System.out.println("00. Logout");
                    System.out.println("=======================================");
                    System.out.print("     Pilih Menu 1/2/3/4/5/6 : ");
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
                System.out.println("=        Login Gagal!        =");
                System.out.println("===============================");
                System.out.println("\nApakah anda ingin input kembali (Y/N)? : ");
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
            System.out.println("\nList id kamar :");
            for (int j = 0; j < kamarDipesan.length; j++) {
                System.out.print(idKamar[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                System.out.println();
            }

            System.out.print("\nMasukkan Id Jenis Kamar yang akan diperbarui: ");
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
                System.out.print("Masukkan jumlah kamar: ");
                jumlahKamar[updateIdKamar - 1] = input.nextInt();
                input.nextLine();

                System.out.println("\nId Kamar berhasil diperbarui: ");
                System.out.println("\nList id kamar :");
                for (int j = 0; j < kamarDipesan.length; j++) {
                    System.out.print(idKamar[j] + ". " + (tipeKamar[j]) + " : " + jumlahKamar[j]);
                    System.out.println();
                }
            } else {
                System.out.println("Kamar tidak ditemukan dengan ID: " + updateIdKamar);
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
    
    for (int i = 0; i < counterKS; i++) {
        
        System.out.println("\nMasukkan : "+(i+1));
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
                    if (totalBiaya[id - 1] != 0) {
                        System.out.println("Semua Reservasi:");

                        for (int i = 0; i <= id; i++) {
                            if (namaPemesan[i] != null && selectedRoomType[i] != null)
                                System.out.println("ID Reservasi: " + idSave[idSave[i] - 1] +
                                        ", Nama Tamu: " + namaPemesan[idSave[i] - 1] +
                                        ", Jenis Kamar: " + selectedRoomType[idSave[i] - 1] +
                                        ", Jumlah Kamar: " + jumlahKamarDiPesan[idSave[i] - 1] +
                                        ", Total Bayar: " + totalBiaya[idSave[i] - 1]);
                        }
                        for (int i = 0; i <= id; i++) {
                            totalPemasukan += totalBiaya[idSave[i] - 1];
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

                    for (int i = 1; i <= id; i++) {
                        if (idSave[i - 1] == updateId) {
                            updateIndex = idSave[i - 1];
                            break;
                        }
                    }

                    if (updateIndex != -1) {
                        System.out.print("Masukkan nama tamu: ");
                        namaPemesan[updateIndex - 1] = input.next();
                        System.out.print("Masukkan jenis kamar: ");
                        selectedRoomType[updateIndex - 1] = input.next();
                        System.out.print("Masukkan jumlah kamar: ");
                        jumlahKamarDiPesan[updateIndex - 1] = input.nextInt();

                        System.out.println("Reservasi berhasil diperbarui:\nID Reservasi: " +
                                idSave[updateIndex - 1] +
                                ", Nama Tamu: " + namaPemesan[updateIndex - 1] +
                                ", Jenis Kamar: " + selectedRoomType[updateIndex - 1] +
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
}