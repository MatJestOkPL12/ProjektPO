package Game;

import Disease.Bacteria;
import Disease.DiseaseAgent;
import Disease.Virus;
import ResearchTeam.ResearchTeam;
import Word.Country;
import Word.Europe;

import java.util.Scanner;

public class UI { //Klasa odpowiedzialna za cały wygląd gry. Ekrany stratowe, menu itp itp

    public UI(Scanner scanner, Game game, Europe europe, ResearchTeam researchTeam, DiseaseAgent diseaseAgent){
        this.scanner = scanner;
        this.game = game;
        this.europe = europe;
        this.researchTeam = researchTeam;
        this.diseaseAgent = diseaseAgent;

    }

    private int day = 0;
    Europe europe;
    private Game game;
    private  Scanner scanner;

    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;

    public DiseaseAgent getDiseaseAgent(){
        return diseaseAgent;
    }


    public void showHomeScreen() {
        horizontalCentre();
        System.out.print("Welcome in the ITE-12.73 Game.");
        //te wszystkie system.out.printy sa po to zeby wszystko wygladało ladniej, byly odstępy, równo itp
        System.out.println();
        System.out.println();
        System.out.println();
        horizontalCentre();
        System.out.println("Write \"start\" to Start the game");
        verticalCentre();
    }//Metoda wyswietlana ekranu startowego

    public void chooseDisease() {
        verticalCentre();
        horizontalCentre();
        System.out.println("                     Choose your disease: ");
        System.out.println();
        System.out.println();
        horizontalCentre2();
        System.out.println("  Virus: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Bacteria:");
        horizontalCentre2();
        System.out.println("- faster spread in Word.Europe\t\t\t\t\t\t\t\t\t\t\t\t - most resistant");
        horizontalCentre2();
        System.out.println("- Fewer upgrades but they are more expensive\t\t\t\t\t\t\t\t\t - More upgrades, but they are cheaper");
        System.out.println();
        System.out.println();
        System.out.println();
        horizontalCentre();
        System.out.print("      If you want to play as VIRUS press 1, or as BACTERIA press 2 ");
        verticalCentre();

        int chooseOfDisease = scanner.nextInt();
        scanner.nextLine();
        if (chooseOfDisease == 1) {
            diseaseAgent = new Virus();

        } else if (chooseOfDisease == 2) {
            diseaseAgent = new Bacteria();

        } else {
            System.out.println("Wrong choice");
        }
    }//Metoda dajaca graczowi wybór czy wirus czy bakteria

    public void displayStartMessage() {
        clearConsole();
        horizontalCentre();
        if (diseaseAgent instanceof Virus) {
            diseaseAgent.changeIsVirus();
            ((Virus) diseaseAgent).DrawPropertiesOfVirus();
            System.out.print("          You are playing as Virus");
        } else if (diseaseAgent instanceof Bacteria) {
            diseaseAgent.changeIsBaceria();
            ((Bacteria) diseaseAgent).DrawPropertiesOfBacteria();
            System.out.print("          You are playing as Bacteria");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        horizontalCentre();
        System.out.print("                    Day 0 ");
        System.out.println();
        System.out.println();
        horizontalCentre();
        System.out.print("In the next day your disease will start spread in random country in Europe");
        System.out.println();
        horizontalCentre();
        System.out.print("            Press \"Enter\" to start the day 1");
        verticalCentre();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        scanner.nextLine();
        ;

    } // Jakas tam wiadomosc poczatkowa, czym gracz gra itp

    private void verticalCentre() {
        for (int i = 0; i < 24; i++) {
            System.out.println();
        }
    } // Wysrodkowanie pionowe

    private void horizontalCentre() {
        for (int i = 0; i < 80; i++) {
            System.out.print(" ");
        }
    } // Wyśrodkowanie poziome

    private void horizontalCentre2() {
        for (int i = 0; i < 50; i++) {
            System.out.print(" ");
        }
    } // Wyśrodkowanie poziome 2
    // Te wypośrodkowania trzeba zmienic troche wsm żeby lepiej dzialaly pozniej to zrobie bo wlasnie wymyslilem jak

    public void clearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void gameplay(DiseaseAgent diseaseAgent){

        showGlobalStatistic();
        game.DrawTheFirstInfectedCountry();
        showMenu();

    }

    public void showGlobalStatistic(){
        int infectionCountries = 0;
        int notInfectionCountries = 0;

        Country[] objectCountries = game.getCountriesInMainArr();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Not infection countries : ");
        for(int i = 0; i<49; i++){
            if(!objectCountries[i].getInfectionStatus()){
                System.out.print(objectCountries[i].getName() + ", ");
                notInfectionCountries++;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Infection countries: ");
        for(int i = 0; i<49; i++){
            if(objectCountries[i].getInfectionStatus()){
                System.out.print(objectCountries[i].getName() + ", ");
                infectionCountries++;
            }
        }

        System.out.println("------------------------------------------------------------------------------------------" +
                "------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Number of infection countries : " + infectionCountries);
        System.out.println("Number of not infection countries : " + notInfectionCountries);
        System.out.println("Global health status - " + europe.getGlobalHealthStatus() + "%");
        System.out.println("Drug research progress - " + researchTeam.getProgressInResearch()+"%");
        System.out.println("Number of infection people - " + europe.getNumberOfInfectionPeopleInEurope());
        System.out.println("-------------------------------");
        for(int i = 0; i<49; i++){

        }
        infectionCountries = 0;
        notInfectionCountries = 0;
        System.out.println();
        System.out.println();
        System.out.println();

    } // Pokazuje statystyki dotyczace calej europy, zarazone i niezarazone kraje, % badania leku i zarazonej europy
    public void showMenu()
    {  do {
        horizontalCentre();
        System.out.print("Choose what you want to do");
        System.out.println();
        horizontalCentre();
        System.out.print("1 - Moving to next day");
        System.out.println();
        horizontalCentre();
        System.out.print("2 - Upgrade your disease");
        System.out.println();
        horizontalCentre();
        System.out.print("3 - Show your disease statistic");
        System.out.println();
        horizontalCentre();
        System.out.print("4 - Exit Game");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: {
                nextDay();
                showGlobalStatistic();
                break;
            }
        }
    }while (true);

    } // Pokazuje manu graczowi i umozliwoa dokonania wyboru co chce dalej zribic

    public void nextDay(){
        day++;
        clearConsole();
        if(day > 1) {
            diseaseAgent.spread(game.getCountriesInMainArr());
            game.TrySpreadNewCountry(game.getCountriesInMainArr());
            europe.changeGlobalHealthStatus(game.getCountriesInMainArr());
        }
        System.out.println("Welcome in Day " + day);
    }//Jeszce nie dokonczona, ale po prostu przechodzenie do kolejnego dnia

    // No i tu trzeba teraz dorobic metode ulepszenia i pokazywania statystyk choroby
}
