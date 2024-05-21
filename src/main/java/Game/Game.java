package Game;

import Disease.DiseaseAgent;
import ResearchTeam.ResearchTeam;
import Word.Country;
import Word.Europe;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Country[] countriesInMainArr = new Country[49];
    public static int day = 0;
    private Europe europe;
    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;
    private Scanner scanner;
    private UI ui;


    public Game(){
        this.europe = new Europe();
        this.researchTeam = new ResearchTeam();
        this.diseaseAgent = new DiseaseAgent();
        this.scanner = new Scanner(System.in);
        this.ui = new UI(scanner, this);
    }

    public void start() throws IOException {
        while (europe.getGlobalHealthStatus() > 0 && researchTeam.getProgressInResearch() < 100) {
            makeObjectOfEveryCountries();
            ui.clearConsole();
            ui.showHomeScreen();

            String password = scanner.nextLine().toLowerCase();
            if (password.equals("start")) {
                diseaseAgent = ui.chooseDisease();
                ui.displayStartMessage(diseaseAgent);
                ui.gameplay();
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
            countriesInMainArr[i] = country;
        }
    }

    public Country[] getCountriesInMainArr(){
        return countriesInMainArr;
    }


}
