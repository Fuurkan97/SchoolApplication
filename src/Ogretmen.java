import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String , String> ogretmenlerMap = new HashMap<>();

    public static void ogretmenEkle(){
        ogretmenlerMap.put("123456789","Furkan,Erdem,1997,Fizik");
        ogretmenlerMap.put("123456788","Ali,Cabbar,1997,Matematik");
        ogretmenlerMap.put("123456787","Venom,Snake,1997,Beden");
        ogretmenlerMap.put("123456786","Tomy,Vcetti,1997,Kimya");
        ogretmenlerMap.put("123456785","Carl,Johnson,1997 Bilgisayar");

    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih ="";
        do{
            System.out.println( "====== OGRETMEN MENU ===========\n" +
                    "   1- Ogretmenler Listesi Yazdir\n" +
                    "   2- Soyisimden Ogretmen Bulma Menu\n" +
                    "   3- Branstan Ogretmen Bulma \n" +
                    "   4- Bilgilerini Girerek Ogretmen Ekleme \n"+
                    "   5- Kimlik No Ile Kayit Silme\n" +
                    "   A- ANAMENU\n"+
                    "   Q- ÇIKIŞ\n");
            tercih=scan.nextLine();
            switch(tercih){
                case "1" :
                    ogretmenListesiYazdir();
                    break;
                case "2" :
                    soyisimdenOgretmenBulma();
                    break;
                case "3" :
                    bransdanOgretmenBulma();
                    break;
                case "4" :
                    ogretmenBilgiEkleme();
                    break;
                case "5" :
                    kimlikNoKayıtSilme();
                    break;
                case "a" :
                case "A" :
                    Depo.anaMenu();
                    break;
                case "q" :
                case "Q" :
                    break;
                default:
                    ogretmenMenu();
                    break;

            }


        }while(!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void kimlikNoKayıtSilme() throws InterruptedException {
        System.out.println("Silinicek ögretmenin tc kimlik no'sunu giriniz");
        String silinecekOgretmen = scan.next();

        String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);

        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e){
            System.out.println("İstediginiz Tc numarasi ile ogrenci bulunamadi");
        }
        Thread.sleep(2000);
    }

    public static void ogretmenBilgiEkleme() {
        System.out.println("TC no :");
        String tcNo = scan.next();
        System.out.println("İsim :");
        String isim= scan.next();
        System.out.println("Soy isim :");
        String soyisim= scan.next();
        System.out.println("Dogum yili :");
        String dYili = scan.next();
        System.out.println("Brans :");
        String brans=scan.next();

        String eklenecekValue = isim + ", " + soyisim + ", " + dYili + ", " + brans;
        ogretmenlerMap.put(tcNo, eklenecekValue);

    }

    public static void bransdanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogretmenin bransini giriniz");

        String istenenBrans = scan.next();

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();

        System.out.println("====== MISTIK KOLEJI ======\n" +
                "====== BRANS ARAMA ====\n" +
                "TcNo       Isim       Soyisim     D.Yili    Brans");
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[] = eachValue.split(",");

            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.printf("%-9s %-10s %-10s %-9s %s\n", eachKey, eachValuarr[0], eachValuarr[1], eachValuarr[2], eachValuarr[3]);
            }

        }
        Thread.sleep(3000);
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {
            System.out.println("Aradiginiz ogretmenin soyismini giriniz");

            String istenenSoyisim = scan.next();

            Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();

            System.out.println("====== MISTIK KOLEJI ======\n" +
                    "====== OGRETMEN ARAMA ====\n" +
                    "TcNo       Isim       Soyisim     D.Yili    Brans");
            for (Map.Entry<String, String> each : ogretmenEntrySet) {
                String eachKey = each.getKey();
                String eachValue = each.getValue();

                String eachValuarr[] = eachValue.split(",");
                if (istenenSoyisim.equalsIgnoreCase(eachValuarr[1])) {
                    System.out.printf("%-9s %-10s %-10s %-9s %s\n", eachKey, eachValuarr[0], eachValuarr[1], eachValuarr[2], eachValuarr[3]);

                }
            }
            Thread.sleep(3000);
    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String,String>> ogretmenEntrySet = ogretmenlerMap.entrySet();

        System.out.println("====== MISTIK KOLEJI ======\n" +
                "====== OGRETMEN LISTESI ====\n" +
                "TcNo       Isim       Soyisim     D.Yili    Brans");

        for(Map.Entry<String,String> each :ogretmenEntrySet){
            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[] = eachValue.split(",");
            System.out.printf("%-9s %-10s %-10s %-9s %s\n", eachKey,eachValuarr[0],eachValuarr[1],eachValuarr[2],eachValuarr[3]);

        }
        Thread.sleep(3000);
    }
}


