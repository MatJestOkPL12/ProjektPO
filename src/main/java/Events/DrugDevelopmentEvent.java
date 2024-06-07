package Events;

import Disease.DiseaseAgent;
import Game.UI;

import java.util.Scanner;

import static ResearchTeam.ResearchTeam.progressInResearch;

public class DrugDevelopmentEvent implements Iexecute, Event {
    Scanner scanner = new Scanner(System.in);
    private double bonus;
    private double ResearchSpeed;
    UI ui = new UI();

    //Tu jaakas randomowa h eventów co mogą przypieszyc badania nad chorobą
    static String[] developmentEventName = new String[]{"Groundbreaking discovery", "Funding from the European Union", "Pay raise", "Aid from a country outside of Word.Europe", " Hiring more researchers"};

    //A tu tablica która o tyle zwieksza no i jeszcze sie trzeba zastanowić czyh to zwiekszać bedzie np o tyle % czy o tyle punktów badania (wymyslilem te liczby losowo XD)
    double[] developmentBonus = new double[]{15.2, 7.3, 4.2, 9.4, 8.3};

    @Override
    public void Execute(DiseaseAgent diseaseAgent) {
        try{
            ui.horizontal(65);
            System.out.print("!!WARNING!!WARNING!!WARNING!!");
            int developmentIndex = (int) (Math.random() * developmentEventNameArr().length);

            progressInResearch = progressInResearch + getdevelopmentBonus(developmentIndex);
            System.out.println();
            ui.horizontal(65);
            System.out.print("-------------------------------------------------------");
            System.out.println();
            ui.horizontal(65);
            System.out.print("|Research Team: " + getdevelopmentName(developmentIndex));
            System.out.println();
            ui.horizontal(65);
            System.out.print("|Research Team: Progress in developing drug +" + getdevelopmentBonus(developmentIndex) + "%");
            System.out.println();
            ui.horizontal(65);
            System.out.print("-------------------------------------------------------");
            ui.vertical(14);
            scanner.nextLine();

        } catch (Exception e) {
            System.err.println("An error occurred during execution: " + e.getMessage());
            e.printStackTrace();

        }
    }

    public String[] developmentEventNameArr() {
        return developmentEventName;
    }


    public String getdevelopmentName(int i) {
        return developmentEventName[i];
    }

    public double[] developmentBonusArr() {
        return developmentBonus;
    }


    public double getdevelopmentBonus(int i) {
        return developmentBonus[i];
    }
}