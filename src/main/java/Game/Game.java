package Game;
import java.util.Random;
import Disease.DiseaseAgent;
import Disease.Virus;
import Disease.Bacteria;
import Events.EpidemicSpreadEvent;
import ResearchTeam.ResearchTeam;
import Word.Country;
import Word.Europe;
import Events.MutationEvent;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Game {

    public Game(){

        this.researchTeam = new ResearchTeam(europe, diseaseAgent);
        this.scanner = new Scanner(System.in);
        this.ui = new UI(scanner, this, europe, researchTeam, diseaseAgent, mutationEvent );
    }


    private Country[] objectCountries = new Country[49];
    public static int day = 0;
    private Europe europe = new Europe();
    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;
    private Scanner scanner;
    private UI ui;
    private MutationEvent mutationEvent;
    public static int points = 0;

    /**
     * Metoda startująca całą rozgrywke
     * @throws IOException
     */
    public void start() throws IOException {
        while (europe.getGlobalHealthStatus() != 0.0 && researchTeam.getProgressInResearch() != 100.0) {
            makeObjectOfEveryCountries();
            ui.clearConsole();
            ui.showHomeScreen();

            String password = scanner.nextLine().toLowerCase();
            if (password.equals("start")) {
                ui.chooseDisease();
                diseaseAgent = ui.getDiseaseAgent();
                ui.displayStartMessage();
                ui.gameplay(diseaseAgent);
                scanner.next(); // To pause the game
                break;
            } else {
                break;
            }
        }
    }

    /**
     * Metoda która tworzy wszystkie kraje w Europie jako obiektry i dodaje je do specjalniej tablicy gdzie są one
     * przechowywane
     */
    private void makeObjectOfEveryCountries() {
        for (int i = 0; i < 49; i++) {
            Country country = new Country(europe.getCountries(i), europe.getPopulation(i), europe.getClimates(i));
            objectCountries[i] = country;
        }
    }


    /**
     * Metoda losująca pierwszy kraj w którym zostanie zarażona pierwsza osoba
     */
    public void DrawTheFirstInfectedCountry(){
        Random random = new Random();
        int radnomNumber = random.nextInt(50);
        objectCountries[radnomNumber].changeInfectionStatus();
        objectCountries[radnomNumber].setInfectionPeople(1);
    }

    /**
     * W tej metodzie próbujemy wybrac kraj lub kraje w którym zostaną zarażone kolejne osoby
     * @param countries
     */
    public void TrySpreadNewCountry(Country [] countries){
        int numberOfInfectionCountries = 0;
        /**
         * Na początku zliczamy wszystkie kraje które są już zainfekowane
         */
        for(int  i = 0; i<49; i++) {
            if (countries[i].getInfectionStatus()) {
                numberOfInfectionCountries++;
            }
        }
        /**
         * Następnie losujemy liczbe z przedzialu 0-10 która będzie deccydować o tym czy jakis kraj zostanie zarażony
         * lub ile zostanie ich zarażónych
         */

        /**
         * Jesli zarażonych kraji będzie <15, a wylosowana liczba będzie >=2 zostaje wygenerowana liczba z przedzialu 0-49 która
         * wybiera nowo zarażony kraj, jesli jest juz on zarażony nic się nie dzieje
         * jednak jednak wylowowana liczba będzie >5 zostają sprawdzone dwa dodatkowe kraje na ideksie +1 oraz +2 od poprzedniego i następuje taka sama procedura
         *
         */


        /**
         * Jeżeli liczba zarażonych kraji zwiększy się do przedzialu >=15  <=34 wylosowana liczba musi byc > 1
         * Kolejne kroki identyczne jak w przypadku powyżej
         */

        /**
         * Jeżeli natomiast zarażonych kraji jest więcej niż 34 wtedy na pewno zostanie zarażone jakieś państwo,
         * wybierane jest to na podstawie tablicy w klasie europe
         * Zarażane jest państwo z najniższym indeksem które jeszce nie jest zarażóne
         */

        Random random = new Random();
            int randomNumber = random.nextInt(11);
            if(numberOfInfectionCountries <15) {
                if (randomNumber >= 2) {
                    int newPossiblyInfectionCountry = random.nextInt(49);
                    if (!countries[newPossiblyInfectionCountry].getInfectionStatus()) {
                        countries[newPossiblyInfectionCountry].changeInfectionStatus();
                        countries[newPossiblyInfectionCountry].setInfectionPeople(1);
                        if (randomNumber > 5) {
                            if (!countries[newPossiblyInfectionCountry + 1].getInfectionStatus()) {
                                countries[newPossiblyInfectionCountry + 1].changeInfectionStatus();
                                countries[newPossiblyInfectionCountry + 1].setInfectionPeople(1);
                                if (!countries[newPossiblyInfectionCountry + 2].getInfectionStatus()) {
                                    countries[newPossiblyInfectionCountry + 2].changeInfectionStatus();
                                    countries[newPossiblyInfectionCountry + 2].setInfectionPeople(1);
                                }
                            }
                        }
                    }
                }
            }
                if (numberOfInfectionCountries >= 15 && numberOfInfectionCountries < 34) {
                    if (randomNumber > 1) {
                        int newPossiblyInfectionCountry = random.nextInt(49);
                        if (!countries[newPossiblyInfectionCountry].getInfectionStatus()) {
                            countries[newPossiblyInfectionCountry].changeInfectionStatus();
                            countries[newPossiblyInfectionCountry].setInfectionPeople(1);
                            if (randomNumber > 3) {
                                if (!countries[newPossiblyInfectionCountry + 1].getInfectionStatus()) {
                                    countries[newPossiblyInfectionCountry + 1].changeInfectionStatus();
                                    countries[newPossiblyInfectionCountry + 1].setInfectionPeople(1);
                                    if (!countries[newPossiblyInfectionCountry + 2].getInfectionStatus()) {
                                        countries[newPossiblyInfectionCountry + 2].changeInfectionStatus();
                                        countries[newPossiblyInfectionCountry + 2].setInfectionPeople(1);
                                    }
                                }
                            }
                        }
                    }
                }


             if(numberOfInfectionCountries >= 34){
                for(int j = 0; j<49; j++){
                    if(!countries[j].getInfectionStatus()){
                        countries[j].changeInfectionStatus();
                        countries[j].setInfectionPeople(1);
                        break;
                    }

                }
            }
        } // Metoda odpowiadajaca za zarazanie nowych kraji


    /**
     * Metoda która dodaje nam punkty za które możemy ulepszać naszą chorobe
     */
    public void getPoints(){
        Random random = new Random();
        if(europe.getNumberOfInfectionPeopleInEurope() < 10000000){
            points = points + random.nextInt(50) + 10;
        }else{
            points = points + random.nextInt(100) + 10;
        }
    }


    /**
     * Getter tablicy krajów
     * @return
     */
    public Country[] getCountriesInMainArr(){
        return objectCountries;
    }

    }




