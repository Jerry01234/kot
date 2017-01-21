package pl.kobietydokodu;

import pl.kobietydokodu.DAO.KotDAO;
import pl.kobietydokodu.model.Kot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Jarek on 2016-12-11.
 */
public class Interfejs {

    static Scanner sc = new Scanner(System.in);
    static KotDAO kotDAO = new KotDAO();

    public static void main(String[] args) {

        String wyborUzytkownika ;
        do {
            System.out.println("#############################################");
            System.out.println("1 - dodanie kota\n2 - pokaż koty\nx - opuść program");
            System.out.println("#############################################\n");
            wyborUzytkownika = getUserInput();

            if (wyborUzytkownika.equals("1")) {
                dodajKota();
            } else if (wyborUzytkownika.equals("2")) {
                pokazKoty();
            }
        }while (!wyborUzytkownika.equalsIgnoreCase("x"));
    }


    private static void pokazKoty() {
        int i = 0;
        for (Kot kot:kotDAO.getKoty() ) {
            System.out.println(i +" - "+kot.getImie());
            i++;
        }

        String wyborKota;
        Pattern p ;
        String formatNumeru = "[0-9]";
        do{
            System.out.println("Wprowadz nr kota: ");
            wyborKota = getUserInput();
            p = Pattern.compile(formatNumeru);


        }while (!p.matcher(wyborKota).matches());

        Integer numerKota = Integer.parseInt(wyborKota);
        if (kotDAO.getKoty().size()>numerKota) {
            Kot wybranyKot = kotDAO.getKoty().get(numerKota);
            System.out.println("Wybrany kot ma na imie "+wybranyKot.getImie()+", waży "+wybranyKot.getWaga()+", urodził się "+wybranyKot.getDataUrodzenia().toString()+", a opiekuje się nim "+wybranyKot.getImieOpiekuna());
        } else {
            System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
        }

    }
/*
    public static void pokazKotyMapa() {
        if(kotDAO.wielkoscMapy()>0){
            for (int i = 0;kotDAO.wielkoscMapy()>i;i++) {
                Kot kot = kotDAO.wezKota(i);
                System.out.println(kot.getImie() + ",   "+i);
            }
            System.out.println("Wprowadz nr kota");
        }else {
            System.out.println("Brak kotów");
        }

        try{
            System.out.println(kotDAO.wezKota(Integer.valueOf(getUserInput())).przedstawSie());
        }catch (Exception e){
            System.out.println("zły numer,nie ma takiego kota, wprowadź ponownie");
//            pokazKoty();
            //System.out.println(e.toString());
        }

    }

    public static void opuscProgram() {
        System.exit(0);
    }
*/
    public static void dodajKota() {

    Kot kot = new Kot();

        System.out.print("Podaj imię kota: ");
        kot.setImie(getUserInput());
        Pattern p;

        String dateExpression = "[0-9]{4}\\.[0-1]?[0-9]\\.[0-3]?[0-9]";
        p = Pattern.compile(dateExpression);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        do {
            System.out.print("Podaj date ur kota w formacie yyyy.MM.dd: ");
            String catBirthDay = getUserInput();
            if(p.matcher(catBirthDay).matches()) {
                try {
                    kot.setDataUrodzenia(simpleDateFormat.parse(catBirthDay));
                } catch (ParseException pe) {
                    System.out.print("blad daty: "+pe.toString());
                }

            };
        }while (kot.getDataUrodzenia() == null);

        do {
            System.out.print("Podaj wage kota w formacie numnerycznym: ");

            try {
                kot.setWaga(Float.valueOf(getUserInput()));
            } catch (NumberFormatException ne) {
                System.out.print("blad wagi: "+ne.toString());
            }
        }while (kot.getWaga() == null);

        System.out.println("Podaj imię opiekuna: ");
        kot.setImieOpiekuna(getUserInput());

        System.out.println("Imie kota: " + kot.getImie() + ", imie Opiekuna: " + kot.getImieOpiekuna());
        System.out.print(kot.przedstawSie());

        kotDAO.dodajKotaDoMapy(kotDAO.wielkoscMapy(),kot);
        kotDAO.dodajKota(kot);

        System.out.println("dodałem kota do listy");

    }

    public static String getUserInput() {
        return sc.nextLine();
    }

}
