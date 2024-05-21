package Game;

import Disease.Bacteria;
import Disease.DiseaseAgent;
import Disease.Virus;
import Word.Country;

import java.util.Scanner;

public class UI {
    private Game game;
    private  Scanner scanner;
    public UI(Scanner scanner, Game game){
        this.scanner = scanner;
        this.game = game;
    }

    public void showHomeScreen() {
        horizontalCentre();
        System.out.print("Welcome in the ITE-12.73 Game.");
        System.out.println();
        System.out.println();
        System.out.println();
        horizontalCentre();
        System.out.println("Write \"start\" to Start the game");
        verticalCentre();
    }

    public DiseaseAgent chooseDisease() {
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
            return new Virus();
        } else if (chooseOfDisease == 2) {
            return new Bacteria();
        } else {
            return new DiseaseAgent(); // Default case
        }
    }

    public void displayStartMessage(DiseaseAgent diseaseAgent) {
        clearConsole();
        horizontalCentre();
        if (diseaseAgent instanceof Virus) {
            System.out.print("          You are playing as Virus");
        } else if (diseaseAgent instanceof Bacteria) {
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

    }

    private void verticalCentre() {
        for (int i = 0; i < 24; i++) {
            System.out.println();
        }
    }

    private void horizontalCentre() {
        for (int i = 0; i < 80; i++) {
            System.out.print(" ");
        }
    }

    private void horizontalCentre2() {
        for (int i = 0; i < 50; i++) {
            System.out.print(" ");
        }
    }

    public void clearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void gameplay(){

        Country[] objectCountries = game.getCountriesInMainArr();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("not infection countries : ");
        for(int i = 0; i<49; i++){
            if(!objectCountries[i].getInfectionStatus()){
                System.out.print(objectCountries[i].getName() + ", ");
            }
        }
    }
}
