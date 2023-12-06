import java.util.Scanner;

public class ketersediaan {
    public static void main(String[] args) {
         // Jumlah total kamar hotel
         int jumlahKamar[] = { 11, 15, 12 };

         // Jumlah kamar yang sudah dipesan
         int kamarDipesan[] = new int[3];
         String[] tipeKamar = { "Superior Deluxe Room", "Devaxa President Room", "Raden Salah Suite" };
         int jumlahKamarDiPesan=0;
String next;
boolean sedia;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n=============================");
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
                        System.out.println("=========================================");
                        System.out.println("Masukkan jenis kamar yang ingin Anda cek :");
System.out.println("=========================================");
                        int jenisKamar = sc.nextInt();
                        // Meminta pengguna memasukkan jenis kamar yang ingin dicek

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
                        sc.nextLine();
                        System.out.println("Apakah anda ingin tetap melanjutkan mengecek ketersediaan kamar ? (Y/N): ");
                        next = sc.nextLine();
                        if (next != "y" | next != "Y") {
                            sedia=false;
                        }
                    }while(next.equalsIgnoreCase("Y"));
    }
}
