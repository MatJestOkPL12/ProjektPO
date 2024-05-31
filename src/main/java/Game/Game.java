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

        this.researchTeam = new ResearchTeam(europe);
        this.diseaseAgent = new DiseaseAgent() {
            @Override
            public void mutate() {

            }

            @Override
            public void applyMutation(int mutationIndex) {

            }

            @Override
            public void applyResistance(int resistanceIndex) {

            }
        };
        this.scanner = new Scanner(System.in);
        this.ui = new UI(scanner, this, europe, researchTeam, diseaseAgent, mutationEvent );
    }


    private Country[] objectCountries = new Country[49];// Tablica zawierajaca obiekty klasy Country
    public static int day = 0;
    private Europe europe = new Europe();
    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;
    private Scanner scanner;
    private UI ui;
    private MutationEvent mutationEvent;


    //Metoda startująca rozgrywke
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

    //Metoda tworząca obiekty wszystkich krajów w tablicy
    private void makeObjectOfEveryCountries() {
        for (int i = 0; i < 49; i++) {
            Country country = new Country(europe.getCountries(i), europe.getPopulation(i), europe.getClimates(i));
            objectCountries[i] = country;
        }
    }


    //Metoda losujaca i zarazajaca pierwszą osobe w losoym kraju w Europie
    public void DrawTheFirstInfectedCountry(){
        Random random = new Random();
        int radnomNumber = random.nextInt(50);
        objectCountries[radnomNumber].changeInfectionStatus();
        objectCountries[radnomNumber].setInfectionPeople(1);
    }

    public void TrySpreadNewCountry(Country [] countries){
        int numberOfInfectionCountries = 0;
        for(int  i = 0; i<49; i++) {//Zlicza wszystkie zarazone kraje
            if (countries[i].getInfectionStatus()) {
                numberOfInfectionCountries++;
            }
        }
            Random random = new Random();
            int randomNumber = random.nextInt(11); // Zmienna odpowadająca za to czy wirus przeniesie sie do innego kraju czy nie, np jesli wylosuje sie liczba między 5-10 choroba zostanie przeniesiona do innego kraju
            if(numberOfInfectionCountries <15){
                if(randomNumber>=5){
                    int newPossiblyInfectionCountry = random.nextInt(50);
                        if(!countries[newPossiblyInfectionCountry].getInfectionStatus()){
                            countries[newPossiblyInfectionCountry].changeInfectionStatus();
                            countries[newPossiblyInfectionCountry].setInfectionPeople(1);
                        }
                }
            }
            else if (numberOfInfectionCountries >=15 && numberOfInfectionCountries < 34){
                if(randomNumber >3){
                    int newPossiblyInfectionCountry = random.nextInt(50);
                        if(!countries[newPossiblyInfectionCountry].getInfectionStatus()){
                            countries[newPossiblyInfectionCountry].changeInfectionStatus();
                            countries[newPossiblyInfectionCountry].setInfectionPeople(1);
                        }
                }
            }

            else if(numberOfInfectionCountries >= 34){
                for(int j = 0; j<49; j++){
                    if(!countries[j].getInfectionStatus()){
                        countries[j].changeInfectionStatus();
                        countries[j].setInfectionPeople(1);
                        break;
                    }

                }
            }
        } // Metoda odpowiadajaca za zarazanie nowych kraji



    void triggerMutationEvent() {
        MutationEvent mutationEvent = new MutationEvent();
        mutationEvent.Execute();
    }
    public void getPoints(){
        Random random = new Random();
        if(europe.getNumberOfInfectionPeopleInEurope() < 10000000){
            points = points + random.nextInt(50) + 10;
        }else{
            points = points + random.nextInt(100) + 10;
        }
    }
    public static int points = 0;


    public Country[] getCountriesInMainArr(){
        return objectCountries;
    }

    } // Metoda w nowym dniu w sposob pseudolowywy wybiera Czy nowe państwo ma zostać zarażone i w sposób przeudolosowy wybiera Która ma zostać zarażone




