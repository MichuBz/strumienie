import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toCollection;

public class Aplikacja {
    public static void main(String[] args) {

        Pracownik osoba1 = new Pracownik("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"), 100, 5411.20);
        Pracownik osoba2 = new Pracownik("Anna", "Zamojska", "1989-03-02", new Adres("Leszno", "", "55-555"), 100, 5678.23);
        Pracownik osoba3 = new Pracownik("Janina", "Kot", "1986-04-02", new Adres("Leszno", "", "55-555"), 100, 7400.20);
        Pracownik osoba4 = new Pracownik("Antoni", "Robak", "1997-12-02", new Adres("Konin", "", "55-555"), 100, 3600.50);
        Pracownik osoba5 = new Pracownik("Weronika", "Kocińska", "2001-07-14", new Adres("Leszno", "", "55-555"), 100, 2670.00);
        Pracownik osoba6 = new Pracownik("Zenon", "Abacki", "1978-02-23", new Adres("Leszno", "", "55-555"), 100, 8200.20);
        Pracownik osoba7 = new Pracownik("Piotr", "Adams", "2003-09-24", new Adres("Poznań", "Szeroka 2", "60-555"), 100, 3740.00);
        Pracownik osoba8 = new Pracownik("Lucjan", "Kacik", "1998-12-13", new Adres("Wrocław", "Wielka 12", "44-555"), 100, 4200.20);
        List<Pracownik> pracownicy = new ArrayList<Pracownik>();
        pracownicy.add(osoba1);
        pracownicy.add(osoba2);
        pracownicy.add(osoba3);
        pracownicy.add(osoba4);
        pracownicy.add(osoba5);
        pracownicy.add(osoba6);
        pracownicy.add(osoba7);
        pracownicy.add(osoba8);
        /**
         * Kombinacja klawiszy Ctrl + Alt + T tworzy na zaznaczonym fragmencie programu region w rozumieniu C#
         */


        List<Pracownik> posortowani = pracownicy
                .stream()
                .filter((p) -> p.getDataUrodzenia().getYear() <1989)
                .limit(3)
                .collect(Collectors.toList());
                posortowani.forEach(System.out.println());

        System.out.println("==================");
        Map<String,List<Pracownik>> grupy  = pracownicy
                .stream()
                .sorted((p1,p2) -> (int)(p1.getPensja() - p2.getPensja()))
                .collect(Collectors.groupingBy(Pracownik::getMiasto));
        for(Map.Entry<String,List<Pracownik>> prac: grupy.entrySet())
        {
            System.out.println(prac.getKey() + "  ;");
            for(Pracownik p : prac.getValue())
                System.out.println("\t"  + p.toString());
        }




    }




}

