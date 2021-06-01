import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        generateContainers(15000);
        Statek statek = new Statek("Titanic");
        statek.ladujKontenery();
    }

    public static void generateContainers(int ilosc) {
        String toFile = "";

        for (int i = 0; i < ilosc; i++) {
            switch (rnum(4)) {// random zwroci 0-1, a *4 zwraca 0-4
                case 0:
                    //Bananowy - 0
                    toFile += "Bananowy-" + rnum(10000) + "-" + rproducent() + "-Banany" + "-" + rnum(5) + "-" + "Elektroniczna" + "-" + rnum(120) + "\n";
                    break; // jesli brak to wczyta po kolei

                case 1:
                    //Chemiczny - 1
                    toFile += "Chemiczny-" + rnum(10000) + "-" + rproducent() + "-" + rchemia() + "-" + rbool() + "-" + rbool() + "-" + rbool() + "\n";
                    break;

                case 2:
                    //ZSokami - 2
                    toFile += "ZSokami-" + rnum(1000) + "-" + rproducent() + "-" + rsoki() + "-" + rnum(6) + "-" + "Azotowa" + "-" + "Pudełko" + "\n";
                    break;

                case 3:
                    //ZElektronika - 3
                    toFile += "ZElektronika-" + rnum(1000) + "-" + rproducent() + "-" + relektronika() + "-" + rbool() + "-" + rbool() + "\n";
                    break;
            }
        }

        //Zapisywanie do pliku
        try {
            FileOutputStream fos = new FileOutputStream(new File("database")); //  Potencjalne źrodlo wyjatkow
            fos.write(toFile.getBytes());
            fos.close();
        } catch (IOException io) {
            System.out.println("Błąd podczas zapisywania danych!");
        }
    }

    // zwraca losowo liczbe pomiedzy 0 a limit(agrmunet) - 1. UWAGA rnum nie zwroci nigdy wartosci rownej argumentowi limit.
    public static int rnum(int limit) { // limit od 0 do ilu
        return (int) (Math.random() * limit);
    }

    // zwroci lb miedzy np -10 a 10( zwraca losowa wartosc pomiedzy - limit a limit)
    public static int negnum(int limit) {
        return rbool() ? rnum(limit) * -1 : rnum(limit); //warunek ? true : false

    }

    // Zwraca losowego producenta
    public static String rproducent() { //r - random
        String[] producent = {"Maersk", "Evergreen", "Matson", "Swire", "COSCO", "CMA CMG"};
        return producent[rnum(producent.length)]; // Zwroci rozmiar tablicy ile jest elementow rnum.
        // Zwroci lb ktora jest miedzy 0 a argumentem (wielkosc tablicy) indeks ktory znajduje sie w tablicy.
    }

    // Zwraca losowa wartosc true/false
    public static boolean rbool() {
        return rnum(10) % 2 == 0; // losuje liczbe i sprawdzamy czy reszta z dzielenia przez dwa rowna sie zero.
    }

    // Zwraca losowe płyny
    public static String rchemia() {
        String[] plyny = {"Ropa", "Farba", "Kwas", "Rozpuszczalnik"};
        return plyny[rnum(plyny.length)];
    }

    // Zwraca losowe soki
    public static String rsoki() {
        String[] soki = {"Sok pomarańczowy", "Sok jabłkowy", "Sok porzeczkowy", "Sok wiśniowy"};
        return soki[rnum(soki.length)];
    }

    // Zwraca losową elektronikę
    public static String relektronika() {
        String[] elektronika = {"Komputer", "Telefon", "Procesor", "Telewizor"};
        return elektronika[rnum(elektronika.length)];
    }
}