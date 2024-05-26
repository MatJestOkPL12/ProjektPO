package Game;

import Disease.DiseaseAgent;
import Disease.Virus;
import Disease.Bacteria;
import ResearchTeam.ResearchTeam;
import Word.Country;
import Word.Europe;
import Events.MutationEvent;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Game {

    public Game(){
        this.europe = new Europe();
        this.researchTeam = new ResearchTeam();
        this.diseaseAgent = new DiseaseAgent();
        this.scanner = new Scanner(System.in);
        this.ui = new UI(scanner, this, europe, researchTeam, diseaseAgent);
    }


    private Country[] objectCountries = new Country[49];
    public static int day = 0;
    private Europe europe;
    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;
    private Scanner scanner;
    private UI ui;



    public void start() throws IOException {
        while (europe.getGlobalHealthStatus() > 0 && researchTeam.getProgressInResearch() < 100) {
            makeObjectOfEveryCountries();
            ui.clearConsole();
            ui.showHomeScreen();

            String password = scanner.nextLine().toLowerCase();
            if (password.equals("start")) {
                ui.chooseDisease();
                diseaseAgent = ui.getDiseaseAgent();
                diseaseAgent.przedstawsie();
                ui.displayStartMessage();
                ui.gameplay(diseaseAgent);
                scanner.next(); // To pause the game
                break;
            } else {
                break;
            }
        }
    }

    private void makeObjectOfEveryCountries() {
        for (int i = 0; i < 49; i++) {
            Country country = new Country(europe.getCountries(i), europe.getPopulation(i), europe.getClimates(i));
            objectCountries[i] = country;
        }
    }

    public Country[] getCountriesInMainArr(){
        return objectCountries;
    }

    public void DrawTheFirstInfectedCountry(){
        Random random = new Random();
        int radnomNumber = random.nextInt(50);
        objectCountries[radnomNumber].changeInfectionStatus();
        objectCountries[radnomNumber].setInfectionPeople(1);
    }

    public void TrySpreadNewCountry(Country [] countries){
        int numberOfInfectionCountries = 0;
        for(int  i = 0; i<49; i++) {
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
        }
    void triggerMutationEvent() {
        MutationEvent mutationEvent = new MutationEvent();
        mutationEvent.Execute();
    }


    } // Metoda w nowym dniu w sposob pseudolowywy wybiera Czy nowe państwo ma zostać zarażone i w sposób przeudolosowy wybiera Która ma zostać zarażone




