import java.util.Scanner;
public class Depo {

   static Scanner scan = new Scanner(System.in);
    public static void anaMenu() throws InterruptedException {
        String tercih="";
        do {
            System.out.println("====== MISTIK KOLEJI ======\n" +
                    "====== ANA MENU ===========\n" +
                    "   1- Okul Bilgileri Goruntule\n" +
                    "   2-Ogretmen Menu\n" +
                    "   3-Ogrenci Menu \n" +
                    "   Q- ÇIKIŞ\n");
            System.out.println("Lütfen Menuden tercihinizi yapiniz");

            tercih = scan.next();

        switch (tercih){
            case "1" :
                Depo.okulBilgileriniYazdir();
                break;
            case "2" :
                Ogretmen.ogretmenMenu();
                break;
            case "3" :
                Ogrenci.ogrenciMenu();
                break;
            case "q" :
               case "Q" :
                break;
             default :
                 System.out.println("Lutfen gecerli bir tercih giriniz");
        }

           }while(!tercih.equalsIgnoreCase("q"));
                 Depo.projeDurdur();
    }

    private static void okulBilgileriniYazdir() throws InterruptedException {
        System.out.println("====== MISTIK KOLEJI ======\n" +
                "  Adres : " +Okul.adres +"\n" +
                "  Telefon : " +Okul.telefon + "\n");
        Thread.sleep(3000);

    }

    public static void projeDurdur(){

        System.out.println("Proje kapandi");
        System.exit(0);
    }
}
