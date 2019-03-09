import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sklep {
    private List<Towar> towaryWSklepie;
    private String nazwaSklepu;
    private double utarg;
    public Sklep(String nazwa) {
        this.nazwaSklepu = nazwa;
        this.utarg = 0;
        towaryWSklepie = new ArrayList<Towar>();
        wczytajTowary();
        //załadujSklep();
    }
    public void wczytajTowary() {
        towaryWSklepie = new ArrayList<Towar>();
        String plik = this.getNazwaSklepu() + ".txt";
        File file = new File(plik);
        try {
            Scanner skan = new Scanner(file);
            boolean koniec = false;
            do {
                String linia = skan.nextLine();
                String[] wyrazy = linia.split(";");
                Towar towar = new Towar(wyrazy[0], Double.parseDouble(wyrazy[1]));
                towaryWSklepie.add(towar);
                if (!skan.hasNextLine())
                    koniec = true;
            } while (!koniec);
            skan.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public void zapiszTowaryJSON() {
        Gson gson = new Gson();
        // poniższy kod ładniej wyświetla dane
        // Gson gson = new GsonBuilder()
        //        .setPrettyPrinting()
        //          .create();
        String efekt = gson.toJson(towaryWSklepie);
        File file = new File(nazwaSklepu + ".json");
        try {
            PrintStream fp = new PrintStream(file);
            fp.println(efekt);
            fp.close();
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
    }
    public void wyświetlTowaryWSklepie() {
        System.out.println("====== Lista towarów w sklepie: " + this.nazwaSklepu  + " =====");
        for(Towar towar : towaryWSklepie) {
            System.out.println(String.format("%-24s", towar.nazwa) + " " + String.format("%7.2f", towar.cena));
        }
        System.out.println("====== koniec listy towarów  ======");
    }
    public void załadujSklep() {
        Towar t1 = new Towar("spodnie Levis", 234.56);
        Towar t2 = new Towar("telefon Galaxy S99", 1134.56);
        Towar t3 = new Towar("sok jabłko-mięta", 2.5);
        Towar t4 = new Towar("gramofon", 250.9);
        Towar t5 = new Towar("stół", 550.9);
        towaryWSklepie.add(t1);
        towaryWSklepie.add(t2);
        towaryWSklepie.add(t3);
        towaryWSklepie.add(t4);
        towaryWSklepie.add(t5);
        //Collections.sort(towaryWSklepie); // nie da się sortować, bo nie ma interfejsu Comparable i jego metody compareTo<Towar>
    }
    public void zapisz() {
        String plik = this.getNazwaSklepu() + ".txt";
        File file = new File(plik);
        try {
            PrintStream stream = new PrintStream(file);
            for(Towar towar : towaryWSklepie)
                stream.println(towar.nazwa + ";" + towar.cena + ";");
            stream.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public ArrayList<Towar> getTowary() {
        ArrayList<Towar> listaDoOdebrania = new ArrayList<Towar>();
        for(Towar towar : towaryWSklepie) {
            Towar t = new Towar(towar.nazwa, towar.cena);
            listaDoOdebrania.add(t);
        }
        return listaDoOdebrania;
    }
    public void dodajDoUtargu(double kwota) {
        this.utarg = this.getUtarg() + kwota;
    }

    public String getNazwaSklepu() {
        return nazwaSklepu;
    }

    public double getUtarg() {
        return utarg;
    }
    public void dodajTowar(Towar towar) {
        towaryWSklepie.add(towar);
    }
    public boolean usuńTowar(Towar towar) {
        boolean jest = false, koniec = false;
        int i = 0;
        do {
            if (towaryWSklepie.get(i).nazwa.equals(towar.nazwa)) {
                jest = true;
                koniec = true;
                towaryWSklepie.remove(i);
            }
            else {
                i++;
                if (i >= towaryWSklepie.size())
                    koniec = true;
            }
        } while (!koniec);
        if (jest)
            return true;
        else
            return false;
    }
}

