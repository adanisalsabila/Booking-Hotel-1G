import java.util.Scanner;
public class FiturLokasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alamatHotel;
        int cekLokasiHotel;

        System.out.println("Selamat datang di Hotel XYZ!");
        System.out.println("Silakan pilih opsi:");
        System.out.println("1. Cek Lokasi Hotel");
        
        int option = sc.nextInt();

        switch (option) {
            case 1:
            System.out.println("===============================================================================");
            System.out.println("Jalan Ijen Nirwana Raya Blok A No.16, Malang Center, Malang, Indonesia, 65116 ");
            System.out.println("===============================================================================");
                break;
            default:
                System.out.println("Opsi tidak valid.");
        }
    }
