package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * @author Nikola Król
 * @author www.github.com/Niqa
 * Zadanie na zajęcia z Programowania Obiektowego Java
 */

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * @param name imie wprowadzane z klawiatury
         * @param surname nazwisko wprowadzane z klawiatury
         * @param scanner zmienna wejscia (pobieranie z klawiatury)
         * @param pause zmienna ktora koontynuje program lub konczy
         * @param email zmienna reprezentujaca obiekt Email
         * @param employee zmienna reprezentujaca obiekt Employee
         * @param file zmienna reprezentujaca plik emails.txt do ktorego sa zapisywane adresy email
         */
        String name;
        String surname;
        Scanner scanner = new Scanner(System.in);
        char pause = 't';
        Email email = null;
        Employee employee = null;
        File file = new File("C:\\Users\\Nikola\\Desktop\\Projekty java\\ex45\\resources\\emails.txt");

        /**
         * petla nieskonczona umozliwiajaca koontynuacje programu
         */
        while (pause == 't') {

            /**
             * wprowadzanie imienia i nazwiska i przypisanie wartosci do zmiennych
             */
            System.out.println("Podaj imię: ");
            name = scanner.nextLine();
            System.out.println("Podaj nazwisko: ");
            surname = scanner.nextLine();

            /**
             * twrzenie obiektu email na podstawie wartosci zmiennych name i surname
             * stworzenie obiektu Employee na podstawie wartosci name, surname i wartosci String zwracajacej
             * przez funkcje createEmail() wywolana z obiektu email
             */
            email = new Email(name, surname);
            employee = new Employee(name, surname, email);

            /**
             * wywolanie metody zapisujacej do pliku
             * @param file plik do ktorego zapisujemy
             * @param employee obiekt Employee
             */
            writeToFile(file, employee);

            /**
             * wypisanie emaila w konsoli
             */
            System.out.println("E-mail: \n" + employee.getEmail().getEmailAdress());

            System.out.println("Czy chcesz dodać osobę? [t/n]");
            pause = scanner.nextLine().toLowerCase().charAt(0);
        }

    }

    /**
     * metoda zapisujaca dane pracownika do pliku
     * @param file plik do ktorego zapisujemy dane
     * @param employee obiekt z danymi pracownika
     * @throws IOException wyrzuca wyjate wejscia/wyjscia
     */
    public static void writeToFile (File file, Employee employee) throws IOException {

        /**
         * zmienne pozwalajace na zapis i odczyt pliku
         */
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        /**
         * sprawdzamy czy plik istnieje
         * jesli nie to go tworzymy
         */
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            /**
             * tworzymy obiekty pozwalajace na zapis do pliku i nie nadpisuje pliku - tylko dopisuje
             * zapisujemy imie, nazwisko, email do pliku
             */
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            writer = new BufferedWriter(fileWriter);
            writer.write(employee.getName() + " " + employee.getSurname() + ": " + employee.getEmail().getEmailAdress() + "\n");

            /**
             * obsluga wyjatku wejscia/ wyjscia
             * np. gdy nie mamy prawa dostepu do pliku, wyleci wyjatek i w tym miejscu zostanie obsluzony
             */
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        } finally {
            /**
             * sekcja "finally" bedzie zawsze obsluzona czy wyjatek sie pojawi czy nie
             * w sekcji tej sprawdzamy czy strumienie nie są puste i zamykamy je
             */
            if(writer != null){
                writer.close();
            }
            if (fileWriter != null){
                fileWriter.close();
            }
        }
    }
}
