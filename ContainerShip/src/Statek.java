import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Statek {
    private String nazwa;
    private final int wysokosc = 5; // finall -> mozemy odczytać , ale nie zmienic
    private final int szerokosc= 30;
    private final int dlugosc = 100;
    Kontener rozlozenie[][][] = new Kontener[wysokosc][szerokosc][dlugosc];

    //szerokosc = 30 -> środek 10 kontenerow
    // dlugosc = 100
    // wysokosc = 5
    // kontenerow na 1 poziom = 3000
    // na poziomie (środek - ciężkie) 1000 => 5000 najcięższych na cały statek

    public Statek(String nazwa) {
        this.nazwa = nazwa;
        this.rozlozenie = new Kontener[30][100][5];

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nowaNazwa) {
        this.nazwa = nowaNazwa;
    }

    public void ladujKontenery() {
        Kontener[] wszystkieKontenery = new Kontener[15000];
        Kontener[] standardoweKontenery = new Kontener[10000];
        Kontener[] ciezkieKontenery = new Kontener[5000];

        try {
            Scanner sc = new Scanner(new File("database")); // Potencjalne źrodlo wyjatkow
            String[] oneline; //tablica zawierajaca stringi
            int counter = 0; //wskazujena indeks kontenerów, śledzi gdzie wlozyc kontener
            while (sc.hasNext()) { //sprawdza czy jest linijka
                oneline = sc.nextLine() // Zczytuje pojedynczą linijke z pliku (String)/(kontener)
                        .split("-"); //Dzieli stringa na tablice, rozdzielajac elementy w miejscach wystapienia "-"
                // zczytuje linijke i zwraca stringa  ==== split będzie przetwarzał stringa na tablice, dzieli tam myslnik

                System.out.println("Załadowano do sortowania kontener: " + oneline[0]);
                switch (oneline[0]) { //odwolujemy sie do indeksu 0

                    case "Bananowy":
                        wszystkieKontenery[counter] = new KontenerBananowy(Integer.parseInt(oneline[1]),
                                oneline[2],
                                oneline[3],
                                Integer.parseInt(oneline[4]),
                                oneline[5],
                                Integer.parseInt(oneline[6]));
                        break;
                    case "Chemiczny":
                        wszystkieKontenery[counter] = new KontenerChemiczny(Integer.parseInt(oneline[1]),
                                oneline[2],
                                oneline[3],
                                Boolean.parseBoolean(oneline[4]),
                                Boolean.parseBoolean(oneline[5]),
                                Boolean.parseBoolean(oneline[6]));
                        break;
                    case "ZSokami":
                        wszystkieKontenery[counter] = new KontenerZSokami(Integer.parseInt(oneline[1]),
                                oneline[2],
                                oneline[3],
                                Integer.parseInt(oneline[4]),
                                oneline[5],
                                oneline[6]);
                        break;
                    case "ZElektronika":
                        wszystkieKontenery[counter] = new KontenerZElektronika(Integer.parseInt(oneline[1]),
                                oneline[2],
                                oneline[3],
                                Boolean.parseBoolean(oneline[4]),
                                Boolean.parseBoolean(oneline[5]));
                        break;

                }
                System.out.println(wszystkieKontenery[counter]);
                counter++;


            }


        } catch (FileNotFoundException fnf) {
            System.out.println("Nie znaleziono bazy kontenerów.");
        }

        Kontener najciezszyKontener;
        int indeksNajciezszegoKonteneraWeWszystkichKontenerach = 0; //(z 15000)
        //Filtrowanie najcięższego kontenerów do oddzielonej tablicy(ciezkieKontenery)
        for (int indexDoUmieszczeniaWNajciezszeKontenery = 0;
             indexDoUmieszczeniaWNajciezszeKontenery < ciezkieKontenery.length;
             indexDoUmieszczeniaWNajciezszeKontenery++) { //index gdzie mamy go umiescic w najciezsze kontenery

            //Szukanie najcięższego kontenera, który jeszcze nie został załadowany
            najciezszyKontener = wszystkieKontenery[0];

            indeksNajciezszegoKonteneraWeWszystkichKontenerach = 0; //reset co obrót pętli

            for (int sprawdzany = 0; sprawdzany < wszystkieKontenery.length; sprawdzany++) {
                if (wszystkieKontenery[sprawdzany] == null) { //unikamy sprawdzania konteneru, ktory usunelismy z tablicy
                    continue;
                }
                //Sprawdzamy czy przypadkiem kontener na pozycji 0 nie jest nullem.
                if (najciezszyKontener == null) {
                    najciezszyKontener = wszystkieKontenery[sprawdzany];
                }
                if (wszystkieKontenery[sprawdzany].masa > najciezszyKontener.masa) { //jeżeli sprawdzany kontener jest cięższy niż chwilowo najcieższy
                    najciezszyKontener = wszystkieKontenery[sprawdzany];
                    indeksNajciezszegoKonteneraWeWszystkichKontenerach = sprawdzany;
                }
            }

            //W tym momencie znaleźliśmy już najcięższy kontener z dostępnych

            // dodajemy najcięższy kontener na pozycji indexDoUmieszczeniaWNajciezszeKontenery.
            // indexDoUmieszczeniaWNajciezszeKontenery pilnuje na ktorej pozycji ustawic kontenery

            ciezkieKontenery[indexDoUmieszczeniaWNajciezszeKontenery] = najciezszyKontener; //wkladamy do listy najciezszych

            //Usuwamy ten kontener z listy wszystkich kontenerow, zamieniajac go na nulla
            wszystkieKontenery[indeksNajciezszegoKonteneraWeWszystkichKontenerach] = null;

            //=======KONIEC WYBIERANIA NAJCIEZSZYCH=======
        }

        //W tym momencie lista najcięższych kontenerów (ciężkieKontenery) została uzupełniona.
        // Pozostało nam tylko wpisać kontenery pozostałe w wszystkieKontenery do tabliy standardoweKontenery

        int standardKontenerCounter = 0; //Gdzie mamy włożyć kontener do listy standardowych kontenerów.
        for (int kontenercount = 0; kontenercount < wszystkieKontenery.length; kontenercount++) { //kontenercount --> index wskazujemy na kontener we wszystkich kontenerach
            if (wszystkieKontenery[kontenercount] != null) { //Jeżeli sprawdzany indeks zawiera kontener ( a nie null), dodajemy go do tablicy standardowych kontenerow.
                standardoweKontenery[standardKontenerCounter] = wszystkieKontenery[kontenercount];
                wszystkieKontenery[kontenercount] = null; // Usuwanie standardowego kontenera z listy wszytskich kontenerów

                standardKontenerCounter++;
            }
        }

        int indexDoZabraniaCiezkie = 0;
        int indexDoZabraniaStandardowe = 0;
        String mainfest = "";

        for (int poziom = 0; poziom < wysokosc; poziom++){

            for (int kolumna = 0; kolumna < dlugosc; kolumna++){

                for (int pozycja = 0; pozycja< szerokosc; pozycja++){
                    if (pozycja > 9 && pozycja < 20) {
                        //to wkladamy ciezki
                        this.rozlozenie[pozycja][kolumna][poziom] = ciezkieKontenery[indexDoZabraniaCiezkie];
                        ciezkieKontenery[indexDoZabraniaCiezkie] = null; // usunięcie z tablicy ciezkich kontenerów
                        indexDoZabraniaCiezkie++;
                    }else {
                        //wkladamy standardowy
                        this.rozlozenie[pozycja][kolumna][poziom] = standardoweKontenery[indexDoZabraniaStandardowe];
                        standardoweKontenery[indexDoZabraniaStandardowe] = null; // usunięcie z tablicy standardowych kontenerów
                        indexDoZabraniaStandardowe++;
                    }
                    mainfest += this.rozlozenie[pozycja][kolumna][poziom].toString() + " Poziom: " + poziom + " Kolumna: " +  kolumna + " Pozycja: " + pozycja + "\n";
                }

            }
        }

        //zapisanie do pliku

        try {
            FileOutputStream fos = new FileOutputStream(new File("manifest.txt")); //  Potencjalne źrodlo wyjatkow
            fos.write(mainfest.getBytes());
            fos.close();
        }catch (IOException io){
            System.out.println("Błąd podczas tworzenia manifestu!");
        }
    }
}
