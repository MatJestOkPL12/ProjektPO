package Game;

import Disease.Bacteria;
import Disease.DiseaseAgent;
import Disease.Virus;
import Events.EpidemicSpreadEvent;
import Events.MutationEvent;
import Events.DrugDevelopmentEvent;
import ResearchTeam.ResearchTeam;
import Word.Country;
import Word.Europe;

import java.util.Scanner;

import static Game.Game.points;

public class UI { //Klasa odpowiedzialna za cały wygląd gry. Ekrany stratowe, menu itp itp

    public UI(Scanner scanner, Game game, Europe europe, ResearchTeam researchTeam, DiseaseAgent diseaseAgent, MutationEvent mutationEvent){
        this.scanner = scanner;
        this.game = game;
        this.europe = europe;
        this.researchTeam = researchTeam;
        this.diseaseAgent = diseaseAgent;
        this.mutationEvent = mutationEvent;



    }

    private int day = 0;
    Europe europe;
    private Game game;
    private  Scanner scanner;

    private ResearchTeam researchTeam;
    private DiseaseAgent diseaseAgent;
    private MutationEvent mutationEvent;

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
            diseaseAgent = new Virus(mutationEvent);

        } else if (chooseOfDisease == 2) {
            diseaseAgent = new Bacteria(mutationEvent);

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

    } // Metoda wyswietlająca początkowe  informacje - czym gracz gra itp

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
    } // Czyśli terminal

    public void gameplay(DiseaseAgent diseaseAgent){
        showGlobalStatistic();
        game.DrawTheFirstInfectedCountry();
        showMenu();

    } // Metoda odpowiedzialna za rozgrywke

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
        System.out.println("Global health status - " + String.format("%.2f", europe.getGlobalHealthStatus()) + "%");
        System.out.println("Drug research progress - " + String.format("%.2f", researchTeam.getProgressInResearch()) + "%");
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
    {
        int exit = 0;
        do {
        horizontalCentre();
        System.out.print("Points: " + points);
        System.out.println();
        horizontalCentre();
        System.out.print("Choose what you want to do");
        System.out.println();
        horizontalCentre();
        System.out.print("1 - Moving to next day");
        System.out.println();
        horizontalCentre();
        System.out.print("2 - Upgrade your disease - ta opcja jeszce nie jest dostępna");
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
            case 2:{
                game.triggerMutationEvent();;
                break;
            }
            case 3: {
                showDiseaseStatistic(diseaseAgent);
                break;
            }
            case 4:{
                exit = -1;
            }
        }
    }while (europe.getGlobalHealthStatus() != 0 && researchTeam.getProgressInResearch() != 100 && exit == 0);

    } // Pokazuje manu graczowi i umozliwoa dokonania wyboru co chce dalej zribic



    public void nextDay(){
        day++;
        clearConsole();
        if(day > 1) {
            diseaseAgent.spread(game.getCountriesInMainArr());
            game.TrySpreadNewCountry(game.getCountriesInMainArr());
            europe.changeGlobalHealthStatus(game.getCountriesInMainArr());
            researchTeam.WorkOnDrug();
        }
        System.out.println("Welcome in Day " + day);
        if (day % 2 == 0) {
            game.getPoints();
        }
        if (day % 10 == 0)  {
            DrugDevelopmentEvent developmentevent = new DrugDevelopmentEvent();
            developmentevent.Execute();
        }
    }//Jeszce nie dokonczona, ale po prostu przechodzenie do kolejnego dnia

    public void showDiseaseStatistic(DiseaseAgent diseaseAgent) {
        String type = "";
        if (diseaseAgent instanceof Bacteria) {
            clearConsole();
            type = "Bacteria";
            verticalCentre();
            horizontalCentre();
            System.out.print("Name - " + diseaseAgent.getName());
            System.out.println();
            horizontalCentre();
            System.out.print("Type - " + type);
            System.out.println();
            horizontalCentre();
            System.out.print("Drug resistance - " + diseaseAgent.getDrugResistance());
            System.out.println();
            horizontalCentre();
            System.out.print("Reproducing method - " + ((Bacteria) diseaseAgent).getReproducingMethod());
            System.out.println();
            horizontalCentre();
            System.out.print("Reproducing speed - " + ((Bacteria) diseaseAgent).getReproducingSpeed());
            System.out.println();
            horizontalCentre();
            System.out.print("Is toxigencity - " + ((Bacteria) diseaseAgent).getToxigencity());
            System.out.println();
            horizontalCentre();
            System.out.print("Is survival in hard condition - " + ((Bacteria) diseaseAgent).getSurvivalInHardCondition());
            verticalCentre();


            scanner.nextLine();


        }
        if (diseaseAgent instanceof Virus) {
            clearConsole();
            type = "Virus";
            verticalCentre();
            horizontalCentre();
            System.out.print("Name - " + diseaseAgent.getName());
            System.out.println();
            horizontalCentre();
            System.out.print("Type - " + type);
            System.out.println();
            horizontalCentre();
            System.out.print("Drug resistance - " + diseaseAgent.getDrugResistance());
            System.out.println();
            horizontalCentre();
            System.out.print("Transmission mode - " + ((Virus) diseaseAgent).getTransmissionMode());
            System.out.println();
            horizontalCentre();
            System.out.print("Replication speed - " + ((Virus) diseaseAgent).getReplicationSpeed());
            System.out.println();
            horizontalCentre();
            System.out.print("Environmental resistance  - " + String.format("%.2f", ((Virus) diseaseAgent).getEnvironmentalResistance()));
            System.out.println();
            horizontalCentre();
            verticalCentre();

            scanner.nextLine();

        }
    }// Metoda pokazuje statystyki choroby







}



