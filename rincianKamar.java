import java.util.Scanner;

public class rincianKamar {
    public static void main(String[] args) {
                // Jumlah total kamar hotel
         int jumlahKamar[] = { 11, 15, 12 };

         // Jumlah kamar yang sudah dipesan
         int kamarDipesan[] = new int[3];
         String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" };
         int jumlahKamarDiPesan=0;
String next;

boolean sedia;

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
    sedia = false;
                        System.out.println("==========================================");
                        System.out.println("Masukkan jenis kamar yang ingin Anda lihat :");
System.out.println("==========================================");
System.out.print("+==> ");
                        int jenisKamar = sc.nextInt();
                        // Meminta pengguna memasukkan jenis kamar yang ingin dicek

                        if ((jenisKamar) <= kamar.length) {
                             //menampilkan jenis kamar
                        System.out.println(kamar[jenisKamar-1]);

                        } else {
                            System.out.println();
                            System.out.println("== Data tidak ada, inputan salah. ==");
                    System.out.println();}
                       
     
                        sc.nextLine();
                        System.out.println("Apakah anda ingin tetap melanjutkan melihat rincian kamar ? (Y/N): ");
                        next = sc.nextLine();
                        if (next != "y" | next != "Y") {
                            sedia=false;
                        } 
                    }while(next.equalsIgnoreCase("Y"));
    }
}

    
