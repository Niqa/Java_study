package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Email {
    /**
     @param name1 - zmienna która tworzy pierwszy człon emaila (np krol w krol.nikola@mex.com)
     @param name 2 - zmienna która tworzy drugi człon emaila (np. nikola w krol.nikola@mex.com)
     @param sufix - to domena meila
     */
    private String name1;
    private String name2;
    private String sufix  = "mex.com";

    /**
     *
     * @param name1 reprezentuje imię (człon drugi), zmienia przy wpisywaniu na małe litery zgodnie z formatem meila
     * @param name2 reprezentuje nazwisko (człon pierwszy), zmienia przy wpisywaniu na małe litery zgodnie z formatem meila
     */
    public Email(String name1, String name2) {
        this.name1 = name1.toLowerCase();
        this.name2 = name2.toLowerCase();
    }

    /**
     *  metoda tworzy meila
     * @return funkcja zwraca utworzony adres meilowy
     * @throws FileNotFoundException wyrzuca wyjatek jesli nie znajdzie pliku i nie bedzie mogl wyszukac istniejacego meila
     */
    public String createEmail () throws FileNotFoundException {
        String emailAddres = name2 + "." + name1 + "@" + sufix;
        int i = 2;
        /**
         * jezeli dany dany email istnieje to tworzy nowy email z licznikiem "i" i sprawdza czy taki email istnieje
         * za kazdym razem zwiekszajac "i", tworzac nowy az email nie bedzie unikalny
         */
        while(emailExist(emailAddres)) {
            emailAddres = name2 + "." + name1 + i + "@" + sufix;
            i++;
        }
        return emailAddres;
    }

    /**
     *  metoda sprawdza czy podany adres meilowy istnieje w pliku
     * @param email adres meilowy ktory jest sprawdzany czy istnieje w pliku
     * @return zwraca TRUE jesli taki adres juz istnieje lub FALSE jesli nie istnieje
     * @throws FileNotFoundException jesli nie znalazl pliku wyrzuca wyjatek
     */
    public Boolean emailExist(String email) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Nikola\\Desktop\\Projekty java\\ex45\\resources\\emails.txt"));
        while(scanner.hasNext()){
            String line = scanner.nextLine().toLowerCase().toString();
            if(line.contains(email)){
                return true;
            }
        }
        return false;
    }

    /**
     * gettery i settery dzieki ktorym mozemy pobrac zmienne prywatne
     * @return zwracaja zmienne prywatne
     */

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }
}
