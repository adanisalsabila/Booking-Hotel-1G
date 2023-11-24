import java.util.Scanner;

public class testFinalCode {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pilihMenu;

        String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" };
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
        //cek ketersediaan
   boolean sedia;
   int jenisKamar;
//Kritik saran
String namaPenulis=null, kritik=null, saran=null;
//contact person
  String nama = "Hotel Ijen Suites";
                    String telepon = "08123456789";
                    String email = "Ijensuites@gmail.com";

        String next;
        boolean gasss;
        String keMenu;
        int jumlahDewasa, jumlahAnak, jumlahKamarDiPesan = 0;

        boolean bayar;

        // Jumlah total kamar hotel
        int jumlahKamar[] = { 11, 15, 12 };

        // Jumlah kamar yang sudah dipesan
        int kamarDipesan[] = new int[3];

        // user pass
        String userAdmin, passAdmin;
        boolean admin, adminMenu, inKamar, inCP;
        do {
            gasss = false;
            System.out.println("\n=======================================");
            System.out.println("Selamat Datang di Ijen Suites Hotel!");
            System.out.println("=======================================");
            System.out.println("Silahkan Pilih Menu");
            System.out.println("0. Rincian Kamar");
            System.out.println("1. Cek Ketersediaan Kamar");
            System.out.println("2. Pesan Kamar");
            System.out.println("3. Pesan Layanan Tambahan (Makanan/Extra Bed/Sewa Aula)");
            System.out.println("4. Contact Person");
            System.out.println("5. Lokasi Hotel");
            System.out.println("6. Kritik dan Saran");
            System.out.println("7. Fasilitas Hotel");
            System.out.println("8. Cetak Struk");
            System.out.println("9. Login Admin");
            System.out.println("=======================================");
            System.out.print("     Pilih Menu 1/2/3/4/5/6/7/8/9 : ");
            pilihMenu = input.nextInt();
            System.out.println("=======================================");
            input.nextLine();
            switch (pilihMenu) {
                case 0:
                String kamar []= {"    ===============================\r\n" + //
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
            "    ================================"};


        Scanner sc = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("==  1. Superior Deluxe Room  ==");
        System.out.println("===============================");
        System.out.println("= Fasilitas :                 =");
        System.out.println("=  ^ Single Bed Regular Size  =");
        System.out.println("=  ^ Balcony                  =");
        System.out.println("=  ^ Pool View                =");
        System.out.println("=  ^ Soundproofing            =");
        System.out.println("=  ^ Free Wifi                =");
        System.out.println("=  ^ Flat-screen TV           =");
        System.out.println("=  ^ Private Bathroom         =");
        System.out.println("=  ^ Air Conditioning         =");
        System.out.println("===============================");
        System.out.println();
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
                        do{
    sedia = false;    do{
            sedia=false;
                        System.out.println("==========================================");
                        System.out.println("Masukkan jenis kamar yang ingin Anda lihat :");
System.out.println("==========================================");
System.out.print("+==> ");
                        jenisKamar = input.nextInt();
                        // Meminta pengguna memasukkan jenis kamar yang ingin dicek
if (jenisKamar > kamarDipesan.length){
    System.out.println("Inputan melebihi jumlah jenis kamar");
    sedia=true;
} }while (sedia);
                        if ((jenisKamar) <= kamar.length) {
                             //menampilkan jenis kamar
                        System.out.println(kamar[jenisKamar-1]);

                        } else {
                            System.out.println();
                            System.out.println("== Data tidak ada, inputan salah. ==");
                    System.out.println();}
                       
     
                        input.nextLine();
                        System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
                        next = input.nextLine();
                        if (next != "y" | next != "Y") {
                            gasss=true;
                        }
                    }while(next.equalsIgnoreCase("Y"));
                break;
                case 1:
                  
                       
        
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
                        do{
                              sedia=false;
                            do{
            sedia=false;
                        System.out.println("=========================================");
                        System.out.println("Masukkan jenis kamar yang ingin Anda cek :");
System.out.println("=========================================");
                         jenisKamar = input.nextInt();
                        // Meminta pengguna memasukkan jenis kamar yang ingin dicek
if (jenisKamar > kamarDipesan.length){
    System.out.println("Inputan melebihi jumlah jenis kamar");
    sedia=true;
} }while (sedia);

    
                        kamarDipesan[jenisKamar - 1] = jumlahKamarDiPesan;
                        // Menghitung jumlah kamar yang tersedia

                        int kamarTersedia = jumlahKamar[jenisKamar - 1] - kamarDipesan[jenisKamar - 1];

                        // Mengecek ketersediaan kamar
                        if (kamarTersedia > 0) {
                            System.out
                                    .println("== Tersedia " + kamarTersedia + " kamar " + tipeKamar[jenisKamar - 1] + ". ==");
                        } else {
                            System.out.println("Maaf, kamar " + tipeKamar[jenisKamar - 1] + " tidak tersedia.");
                        }
                        input.nextLine();
                        System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
                        next = input.nextLine();
                        if (next != "y" | next != "Y") {
                            gasss=true;
                        }
                    }while(next.equalsIgnoreCase("Y"));
                   
                    
                    break;

                case 2:

                    // awal penambahan kode case
                    System.out.println("\n=================================================");
                    System.out.println("==                Pesan Kamar:                 ==");
                    System.out.println("=================================================");
                    System.out.print("= Masukkan nama pemesan: ");
                    namaPemesan = input.nextLine();
                    System.out.println("=================================================");
                    // Memilih tipe kamar
                    while (lanjut) {
                        System.out.println("= Pilih tipe kamar: ");
                        for (int i = 0; i < tipeKamar.length; i++) {
                            System.out.println("=  " + (i + 1) + ". " + tipeKamar[i] + " - $" + hargaPerMalam[i]);
                        }
                        System.out.println("=================================================");
                        System.out.print("= Masukkan angka untuk memilih : ");
                        pilihanKamar = input.nextInt();
                        System.out.println("=================================================");

                        if (pilihanKamar <= tipeKamar.length && pilihanKamar > 0) {
                            selectedRoomType = tipeKamar[pilihanKamar - 1];
                            selectedRoomPrice = hargaPerMalam[pilihanKamar - 1];
                            lanjut = false;
                        } else {
                            System.out.println("Inputan salah");
                        }
                    }

                    System.out.print("= Masukkan jumlah kamar yang Anda pesan : ");
                    jumlahKamarDiPesan = input.nextInt();
                    System.out.println("=================================================");
                    System.out.print("= Masukkan jumlah orang dewasa : ");
                    jumlahDewasa = input.nextInt();
                    System.out.println("=================================================");
                    System.out.print("= Masukkan jumlah anak kecil ( < 12 tahun): ");
                    jumlahAnak = input.nextInt();
                    System.out.println("=================================================");
                    System.out.print("= Masukkan jumlah malam menginap : ");
                    jumlahMalam = input.nextInt();

                    //
                    // Memilih layanan tambahan
                    System.out.println("=================================================");
                    System.out.println("= Pilih layanan tambahan :");
                    for (int i = 0; i < layananTambahan.length; i++) {
                        if (layananTambahan[i] != null)
                            System.out.println("=  " + (i + 1) + ". " + layananTambahan[i] + " - $" + hargaLayanan[i]);
                    }
                    System.out.println("=  3. skip");

                    input.nextLine(); // membersihkan buffer

                    int i = 0;
                    System.out.println("=================================================");
                    while (lanjut2 && i < layananTambahan.length - 1) {
                        System.out.print("= Masukkan angka untuk memilih : ");
                        pilihanLayanan[i] = input.nextInt();
                        System.out.println("=================================================");

                        if (pilihanLayanan[i] == 3) {
                            lanjut2 = false;
                        }
                        totalLayanan += hargaLayanan[pilihanLayanan[i] - 1];

                        input.nextLine();
                        i++;

                    }

                    // Proses perhitungan total biaya
                    totalBiaya = jumlahKamarDiPesan * jumlahMalam * selectedRoomPrice + totalLayanan;

                    System.out.println("==          Total Biaya: " + totalBiaya);

                    // input jumlah malam, allat transaksi, nominal pembayaran
                    System.out.println("=================================================");
                    System.out.print("= Masukkan alat transaksi (cc/cash): ");
                    alatTransaksi = input.nextLine();
                    if (alatTransaksi.equalsIgnoreCase("cc")) {
                        System.out.println("=================================================");
                        System.out.print("= Masukkan no rekening anda: ");
                        noRekening = input.nextInt();
                        input.nextLine();
                    }

                    do {
                        bayar = false;
                        System.out.println("=================================================");
                        System.out.print("= Masukkan nominal pembayaran: ");
                        pembayaran = input.nextDouble();

                        // Proses pembayaran
                        if (pembayaran >= totalBiaya) {
                            kembalian = pembayaran - totalBiaya;
                            System.out.println("=================================================");
                            System.out.println("== Pembayaran diterima. Kembalian: Rp" + kembalian);
                            System.out.println("=================================================");
                            System.out.println("\n ==== Terima kasih telah melakukan booking! ==== ");
                        } else {
                            System.out.println("=================================================");
                            System.out.println("\nPembayaran tidak mencukupi. Silakan bayar sesuai total biaya.");
                            System.out.println();
                            bayar = true;
                        }
                    } while (bayar);
                    input.nextLine();

                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    // batas penambahan kode case
                    break;

                case 3:
                    // awal penambahan kode case
                    boolean pesanLagi, pesanMenu;
                    String pesanan = "";

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
                            gasss = true;
                        }
                    } while (pesanLagi);
                    System.out.println("\n === Terima kasih atas pesanannya! ===");

                    // batas penambahan kode case
                    break;

                case 4:

                    // awal penambahan kode case

                  

                    System.out.println("\n======================================");
                    System.out.println("===        Contact Person:         ===");
                    System.out.println("======================================");
                    System.out.println("= Nama: " + nama + "            =");
                    System.out.println("======================================");
                    System.out.println("= Nomor Telepon: " + telepon + "         =");
                    System.out.println("======================================");
                    System.out.println("= Alamat Email: " + email + " =");
                    System.out.println("======================================");

                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    // batas penambahan kode case
                    break;

                case 5:
                    // awal penambahan kode case

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
                    System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                    keMenu = input.nextLine();
                    if (keMenu.equalsIgnoreCase("Y")) {
                        gasss = true;
                    }
                    // batas penambahan kode case
                    break;
                case 6:

                    // awal penambahan kode case
                    System.out.println("\n========================================================================");
                    System.out.println("===                        Kritik Saran:                             ===");
                    System.out.println("========================================================================");
                    System.out.print("= Masukkan nama Anda: ");
                     namaPenulis = input.nextLine();
                    System.out.println("========================================================================");
                    System.out.println("==          Masukkan kritik fitur yang ingin Anda tambahkan:          ==");
                    System.out.println("========================================================================");
                    System.out.print("= +==>: ");
                    kritik = input.nextLine();
                    System.out.println("========================================================================");
                    System.out.println("==           Masukkan saran fitur yang ingin Anda usulkan:            ==");
                    System.out.println("========================================================================");
                    System.out.print("= +==>: ");
                    saran = input.nextLine();

                    System.out.println("\n             ===== :Terima kasih atas feedback Anda!: =====             ");
                    System.out.println("\n========================================================================");
                    System.out.println("Nama: " + namaPenulis);
                    System.out.println("========================================================================");
                    System.out.println("====                          Kritik:                               ====");
                    System.out.println("========================================================================");
                    System.out.println("= +==>            " + kritik);

                    System.out.println("========================================================================");
                    System.out.println("====                          Saran:                                ====");
                    System.out.println("========================================================================");
                    System.out.println("= +==>            " + saran);
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
                        System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                        keMenu = input.nextLine();
                        if (keMenu.equalsIgnoreCase("Y")) {
                            gasss = true;
                        }
                    }

                    while (namaPemesan != null && selectedRoomType != null) {
                        System.out.println("\n======================================================");
                        System.out.println("===                 Detail Booking:                ===");
                        System.out.println("======================================================");
                        System.out.println("=    Nama Pemesan:" + namaPemesan);
                        System.out.println("======================================================");
                        System.out.println("=    Tipe Kamar: " + selectedRoomType);
                        System.out.println("======================================================");
                        System.out.println("=    Harga Kamar : Rp" + selectedRoomPrice);
                        System.out.println("======================================================");
                        System.out.println("=    Layanan Tambahan:");
                        i = 0;
                        while (totalLayanan != 0 | i < layananTambahan.length) {
                            // int pilihanLayanan = input.nextInt();
                            for (i = 0; i < pilihanLayanan.length; i++) {
                                if (totalLayanan != 0) {
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
                        System.out.println("=    Total Biaya: Rp" + totalBiaya);
                        System.out.println("======================================================");

                        // Proses pembayaran

                        kembalian = pembayaran - totalBiaya;
                        System.out.println("=    Pembayaran diterima. Kembalian: Rp" + kembalian);
                        System.out.println("======================================================");
                        System.out.println("\n   ==== Terima kasih telah melakukan booking! ====    ");

                        System.out.println("\nApakah anda ingin kembali ke menu ? (Y/N): ");
                        keMenu = input.nextLine();
                        if (keMenu.equalsIgnoreCase("Y")) {
                            gasss = true;
                        }
                        // batas penambahan kode case
                        break;
                    }
                case 9:
                    do {
                        System.out.println("\n===============================");
                        System.out.println("=        Login Admin:         =");
                        System.out.println("===============================");
                        admin = false;
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
                                adminMenu = false;
                                System.out.println("\n=======================================");
                                System.out.println("Selamat Datang di Menu Admin");
                                System.out.println("=======================================");
                                System.out.println("Silahkan Pilih Menu");
                                System.out.println("1. Edit Ketersediaan Kamar");
                                System.out.println("2. Edit Contact Person");
                                System.out.println("3. Edit Lokasi Hotel");
                                System.out.println("4. Lihat Kritik dan Saran");
                                System.out.println("5. Edit Fasilitas Hotel");
                                System.out.println("6. Logout");
                                System.out.println("=======================================");
                                System.out.print("     Pilih Menu 1/2/3/4/5/6 : ");
                                int menuAdmin = input.nextInt();
                                input.nextLine();

                                switch (menuAdmin) {
                                    case 1:
                                        do {
                                            inKamar = false;
                                            for (int j = 0; j < kamarDipesan.length; j++) {
                                                System.out.print("Input jumlah kamar " + (tipeKamar[j]) + " : ");
                                                int inputJumlahKamar = input.nextInt();
                                                jumlahKamar[j] = inputJumlahKamar;
                                                input.nextLine();
                                            }

                                            System.out.println(
                                                    "\nApakah anda ingin kembali ke menu (Y) / input kembali (N)? : ");
                                            keMenu = input.nextLine();
                                            if (keMenu.equalsIgnoreCase("Y")) {
                                                adminMenu = true;
                                            } else if (keMenu.equalsIgnoreCase("N")) {
                                                inKamar = true;
                                            }
                                        } while (inKamar);

                                        break;
                                    case 2:
                                        do {
                                            inCP = false;

                                            System.out.print("Input Nama Hotel : ");
                                            nama = input.nextLine();
                                            System.out.print("Input nomor telepon : ");
                                            telepon = input.nextLine();
                                            System.out.print("Input email : ");
                                            email = input.nextLine();

                                            System.out.println(
                                                    "\nApakah anda ingin kembali ke menu (Y) / input kembali (N)? : ");
                                            keMenu = input.nextLine();
                                            if (keMenu.equalsIgnoreCase("Y")) {
                                                adminMenu = true;
                                            } else if (keMenu.equalsIgnoreCase("N")) {
                                                inKamar = true;
                                            }
                                        } while (inCP);

                                        break;
                                        case 4:
                                        for (int j = 0; j < kamarDipesan.length; j++) {
                                            
                                            System.out.println("\n========================================================================");
                                            System.out.println("Nama: " + namaPenulis);
                                            System.out.println("========================================================================");
                                            System.out.println("====                          Kritik:                               ====");
                                            System.out.println("========================================================================");
                                            System.out.println("= +==>            " + kritik);
                                            
                                            System.out.println("========================================================================");
                                            System.out.println("====                          Saran:                                ====");
                                            System.out.println("========================================================================");
                                            System.out.println("= +==>            " + saran);
                                        }
                                        break;
                                    case 6:
                                        gasss = true;
                                        break;

                                    default:
                                        break;
                                }
                            } while (adminMenu);

                        } else {
                            System.out.println("===============================");
                            System.out.println("=        Login Gagal!        =");
                            System.out.println("===============================");
                            System.out.println("\nApakah anda ingin kembali ke menu (Y) / input kembali (N)? : ");
                            keMenu = input.nextLine();
                            if (keMenu.equalsIgnoreCase("Y")) {
                                gasss = true;
                            } else if (keMenu.equalsIgnoreCase("N")) {
                                admin = true;
                            }
                        }
                    } while (admin);
                    break;
            }
        } while (gasss);

        input.close();
    }

}