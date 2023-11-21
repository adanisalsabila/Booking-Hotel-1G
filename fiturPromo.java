import java.util.Scanner;

public class fiturPromo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] kodePromo = { "A", "IJENMALANG", "IJEN11" };
    double[] disPromo = { 0.10, 0.15, 0.20 };

    System.out.println("Masukkan kode promo: ");
    String inKode = input.nextLine();
    boolean isPromo = false;
    double diskon = 0.0;

    for (int i = 0; i < disPromo.length; i++) {
      if (inKode.equals(kodePromo[i])) {
        isPromo= true;
        diskon = disPromo[i];
        break;
      }
    }

if (isPromo) {
  System.out.println("Selamat, nda mendapatkan diskon sebesar "+ (diskon *100)+"%!");
}else {
  System.out.println("Kode promo tidak valid. Silahkan coba lagi.");
}
input.close();
  }
}
