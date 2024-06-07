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

import javax.swing.*;
import java.util.Random;
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
    public UI(){}

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
        horizontal(76);
        System.out.print("Welcome in the ITE-12.73 Game.");
        System.out.println();
        horizontal(76);
        System.out.print("Write \"start\" to Start the game");
        vertical(17);
    }//Metoda wyswietlana ekranu startowego

    public void chooseDisease() {
        vertical(24);
        horizontal(60);
        System.out.println("                     Choose your disease: ");
        System.out.println();
        System.out.println();
        horizontal(35);
        System.out.println("  Virus: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Bacteria:");
        horizontal(35);
        System.out.println("- faster spread in Word.Europe\t\t\t\t\t\t\t\t\t\t\t\t - most resistant");
        horizontal(35);
        System.out.println("- Fewer upgrades but they are more expensive\t\t\t\t\t\t\t\t\t - More upgrades, but they are cheaper");
        System.out.println();
        System.out.println();
        System.out.println();
        horizontal(57);
        System.out.print("      If you want to play as VIRUS press 1, or as BACTERIA press 2 ");
        vertical(13);

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
        horizontal(60);
        System.out.print("                    Day 0 ");
        System.out.println();
        horizontal(61);
        if (diseaseAgent instanceof Virus) {
            diseaseAgent.changeIsVirus();
            ((Virus) diseaseAgent).DrawPropertiesOfVirus();
            System.out.print("          You are playing as Virus!");
        } else if (diseaseAgent instanceof Bacteria) {
            diseaseAgent.changeIsBaceria();
            ((Bacteria) diseaseAgent).DrawPropertiesOfBacteria();
            System.out.print("          You are playing as Bacteria!");
        }
        vertical(4);
        horizontal(50);
        System.out.print("In the next day your disease will start spread in random country in Europe");
        System.out.println();
        horizontal(57);
        System.out.print("            Press \"Enter\" to start the day 1");
        vertical(14);
        scanner.nextLine();
        ;

    } // Metoda wyswietlająca początkowe  informacje - czym gracz gra itp

    public void clearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    } // Czyśli terminal

    public void gameplay(DiseaseAgent diseaseAgent){
        showGlobalStatistic();
        game.DrawTheFirstInfectedCountry();
        showMenu();

        if(researchTeam.getProgressInResearch() == 100){
            clearConsole();
            vertical(12);
            horizontal(74);
            System.out.print("You Lose! Try ones again");
            vertical(17);
            scanner.nextLine();

        }
        if(europe.getGlobalHealthStatus() == 0){
            clearConsole();
            vertical(12);
            horizontal(74);
            System.out.print("You Win! Congratulations");
            vertical(17);
        }

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

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Number of infection countries : " + infectionCountries);
        System.out.println("Number of not infection countries : " + notInfectionCountries);
        System.out.println("Global health status - " + String.format("%.2f", europe.getGlobalHealthStatus()) + "%");
        System.out.println("Drug research progress - " + String.format("%.2f", researchTeam.getProgressInResearch()) + "%");
        System.out.println("Number of infection people - " + europe.getNumberOfInfectionPeopleInEurope());
        System.out.println("Points - " + points);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        infectionCountries = 0;
        notInfectionCountries = 0;
       vertical(2);

    } // Pokazuje statystyki dotyczace calej europy, zarazone i niezarazone kraje, % badania leku i zarazonej europy
    public void showMenu()
    {
        int exit = 0;
        do {
            try {


                horizontal(75);
                System.out.print("Choose what you want to do");
                System.out.println();
                horizontal(75);
                System.out.print("1 - Moving to next day");
                System.out.println();
                horizontal(75);
                System.out.print("2 - Upgrade your disease [Cost: 100 points]");
                System.out.println();
                horizontal(75);
                System.out.print("3 - Show your disease statistic");
                System.out.println();
                horizontal(75);
                System.out.print("4 - Exit Game");
                vertical(6);

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        nextDay();
                        showGlobalStatistic();
                        break;
                    }
                    case 2: {
                        if (points >= 100) {
                            points = points - 100;
                            //game.triggerMutationEvent();
                            upgradeStatisticMenu(diseaseAgent);

                        } else {
                            System.out.println("You have not enough money to upgrade!");
                        }
                        break;
                    }
                    case 3: {
                        showDiseaseStatistic(diseaseAgent);
                        break;
                    }
                    case 4: {
                        exit = -1;
                    }
                }
            }
            catch (Exception e){
                System.out.println("Unexpected error, please try again. " + e.getMessage());
            }
            } while (europe.getGlobalHealthStatus() != 0 && researchTeam.getProgressInResearch() != 100 && exit == 0) ;



    } // Pokazuje manu graczowi i umozliwoa dokonania wyboru co chce dalej zribic

    public void nextDay(){
        day++;
        clearConsole();
        Random random = new Random();
        if(day > 1) {
            diseaseAgent.spread(game.getCountriesInMainArr());
            game.TrySpreadNewCountry(game.getCountriesInMainArr());
            europe.changeGlobalHealthStatus(game.getCountriesInMainArr());
            researchTeam.WorkOnDrug();
        }
        System.out.println("Welcome in Day " + day);
        if (day % (random.nextInt(3) + 1) == 0) {
            game.getPoints();
        }
        if (day % (random.nextInt(20) + 5) == 0)  {
            DrugDevelopmentEvent developmentevent = new DrugDevelopmentEvent();
            developmentevent.Execute(diseaseAgent);
        }
        if (day % (random.nextInt(10) + 5) == 0)  {
            EpidemicSpreadEvent spreadevent = new EpidemicSpreadEvent();
            spreadevent.Execute(diseaseAgent);
        }
    }

    public void upgradeStatisticMenu(DiseaseAgent diseaseAgent){
        clearConsole();
        horizontal(72);
        System.out.print("Every upgrade cost 100 points");
        if(diseaseAgent instanceof Bacteria){
            vertical(2);
            horizontal(72);
            System.out.print("Reproducing speed +5 - press 1");
            System.out.println();
            horizontal(72);
            System.out.print("Drug resistance +5 - press 2");
            vertical(15);
            int upgradeChoice = scanner.nextInt();
            clearConsole();
            switch (upgradeChoice){
                case 1: ((Bacteria) diseaseAgent).setReproducingSpeed(5); break;
                case 2: ((Bacteria) diseaseAgent).setDrugResistance(5); break;
                default:{
                    System.out.println("Error, pres any button to proceed");
                    scanner.nextLine();
                    break;
                }
            }

        }
        else if (diseaseAgent instanceof Virus){
            vertical(2);
            horizontal(72);
            System.out.print("Reproducing speed (+5) - press 1");
            System.out.println();
            horizontal(72);
            System.out.print("Environmental resistance (+5) - press 2");
            System.out.println();
            horizontal(72);
            System.out.print("Drug resistance (+5) - press 3");
            vertical(15);
            int upgradeChoice = scanner.nextInt();
            clearConsole();
            switch (upgradeChoice){
                case 1:{
                    ((Virus) diseaseAgent).setReproducingSpeed(5);
                    break;
                }
                case 2:{
                    ((Virus) diseaseAgent).setEnvironmentalResistance(5);
                    break;
                }
                case 3:{
                    ((Virus) diseaseAgent).setDrugResistance(5);
                    break;
                }
                default:{
                    System.out.println("Error, pres any button to proceed");
                    scanner.nextLine();
                    break;
                }
            }
        }
    }

    public void showDiseaseStatistic(DiseaseAgent diseaseAgent) {
        String type = "";
        if (diseaseAgent instanceof Bacteria) {
            clearConsole();
            type = "Bacteria";
            vertical(24);
            horizontal(80);
            System.out.print("Name - " + diseaseAgent.getName());
            System.out.println();
            horizontal(80);
            System.out.print("Type - " + type);
            System.out.println();
            horizontal(80);
            System.out.print("Drug resistance - " + ((Bacteria) diseaseAgent).getDrugResistance());
            System.out.println();
            horizontal(80);
            System.out.print("Reproducing method - " + ((Bacteria) diseaseAgent).getReproducingMethod());
            System.out.println();
            horizontal(80);
            System.out.print("Reproducing speed - " + ((Bacteria) diseaseAgent).getReproducingSpeed());
            System.out.println();
            horizontal(80);
            System.out.print("Is toxigencity - " + ((Bacteria) diseaseAgent).getToxigencity());
            System.out.println();
            horizontal(80);
            System.out.print("Is survival in hard condition - " + ((Bacteria) diseaseAgent).getSurvivalInHardCondition());
            System.out.println();
            horizontal(80);
           vertical(12);


            scanner.nextLine();
            clearConsole();


        }
        else if (diseaseAgent instanceof Virus) {
            clearConsole();
            type = "Virus";
            vertical(24);
            horizontal(80);
            System.out.print("Name - " + diseaseAgent.getName());
            System.out.println();
            horizontal(80);
            System.out.print("Type - " + type);
            System.out.println();
            horizontal(80);
            System.out.print("Drug resistance - " + ((Virus) diseaseAgent).getDrugResistance());
            System.out.println();
            horizontal(80);
            System.out.print("Transmission mode - " + ((Virus) diseaseAgent).getTransmissionMode());
            System.out.println();
            horizontal(80);
            System.out.print("Replication speed - " + ((Virus) diseaseAgent).getReplicationSpeed());
            System.out.println();
            horizontal(80);
            System.out.print("Environmental resistance  - " + String.format("%.2f", ((Virus) diseaseAgent).getEnvironmentalResistance()));
            System.out.println();
            horizontal(80);
            vertical(12);

            scanner.nextLine();
            clearConsole();

        }
    }// Metoda pokazuje statystyki choroby

    public void vertical(int i){
        for (int j = 0; j < i; j++) {
            System.out.println();
        }
    }//pion
    public void horizontal(int i){
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
    }//poziom






}



