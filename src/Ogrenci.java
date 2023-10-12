import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Ogrenci {
    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogrencilerMap = new HashMap<>();

    public static void ogrenciEkle() {
        ogrencilerMap.put("223456789", "Phantom,Assasin,1997 , 10 , 10/A ");
        ogrencilerMap.put("323456788", "Death,Knight,1998,11,10/A ");
        ogrencilerMap.put("423456787", "Veno,Mancer,1999,12,10/A ");
        ogrencilerMap.put("523456786", "Necro,Mancer,2000,13,10/A ");
        ogrencilerMap.put("623456785", "Crystal,Maiden,2001,14,10/A ");

    }

    public static void ogrenciMenu() throws InterruptedException {
        String tercih = "";
        do {
            System.out.println("====== OGRENCI MENU ===========\n" +
                    "   1- Ogrenci Listesi Yazdir\n" +
                    "   2- Soyisimden Ogrenci Bulma Menu\n" +
                    "   3- Bilgilerini Girerek Ogrenci Ekleme \n" +
                    "   4- Kimlik No Ile Kayit Silme\n" +
                    "   A- ANAMENU\n" +
                    "   Q- ÇIKIŞ\n");

            tercih = scan.next();
            switch (tercih) {
                case "1" :
                    ogrenciListesiYazdir();
                    break;
                case "2" :
                    SoyisimdenOgrenciBulma();
                    break;
                case "3" :
                    OgrenciBilgiEkleme();
                    break;
                case "4" :
                    OgrenciKayitSilme();
                    break;
                case "a" :
                case "A" :
                    Depo.anaMenu();
                    break;
                case "q" :
                case "Q" :
                    break;
                default:
                    ogrenciMenu();

            }
        }while(!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void OgrenciKayitSilme() throws InterruptedException {
        System.out.println("Silinicek öğrencinin tc kimlik no'sunu giriniz");
        String silinecekOgrenci = scan.next();

        String silinecekValue=ogrencilerMap.get(silinecekOgrenci);

        String sonucValue = ogrencilerMap.remove(silinecekOgrenci);

        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e){
            System.out.println("İstediginiz Tc numarasi ile ogrenci bulunamadi");
        }
        Thread.sleep(3000);
    }

    public static void OgrenciBilgiEkleme() {
        System.out.println("TC no :");
        String tcNo = scan.next();
        System.out.println("İsim :");
        String isim= scan.next();
        System.out.println("Soy isim :");
        String soyisim= scan.next();
        System.out.println("Dogum yili :");
        String dYili = scan.next();
        System.out.println("Okul No :");
        String okulNo=scan.next();
        System.out.println("Sınıf ve Şube :");
        String sinifVeSube = scan.next();

        String eklenecekValue = isim + "," + soyisim + "," + dYili + "," + okulNo + "," + sinifVeSube;
        ogrencilerMap.put(tcNo, eklenecekValue);

    }

    public static void SoyisimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogretmenin soyismini giriniz");

        String soyIsim = scan.next();

        Set<Map.Entry<String , String>> ogrenciEntrySet = ogrencilerMap.entrySet();

        System.out.println("====== MISTIK KOLEJI ======\n" +
                "====== OGRENCI ARAMA ====\n" +
                "TcNo       Isim   Soyisim  D.Yili  OkulNo SınıfVeSube");


        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[] = eachValue.split(",");

            if (soyIsim.equalsIgnoreCase(eachValuarr[1])) {
                System.out.printf("%-9s %-10s %-10s %-7s %-6s %-15s\n",eachKey,eachValuarr[0],eachValuarr[1],
                        eachValuarr[2],eachValuarr[3],eachValuarr[4]);
            }
        }
        Thread.sleep(3000);
    }

    public static void ogrenciListesiYazdir() throws InterruptedException {
        Set<Map.Entry<String,String>> ogrenciEntrySet = ogrencilerMap.entrySet();

        System.out.println("====== MISTIK KOLEJI ======\n" +
                "====== OGRENCI LISTESI ====\n" +
                "TcNo       Isim   Soyisim  D.Yili  OkulNo SınıfVeSube");

        for(Map.Entry<String,String> each :ogrenciEntrySet){
            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValuarr[] = eachValue.split(",");
            System.out.printf("%-9s %-10s %-10s %-7s %-6s %-15s\n",eachKey,eachValuarr[0],eachValuarr[1],
                    eachValuarr[2],eachValuarr[3],eachValuarr[4]);

        }
        Thread.sleep(3000);
    }
}

