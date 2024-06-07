package Events;


import Disease.DiseaseAgent;
import Game.UI;

import java.util.Scanner;

public class EpidemicSpreadEvent  implements Iexecute, Event {
    MutationEvent mutationEvent = new MutationEvent();
    UI ui = new UI();
    Scanner scanner = new Scanner(System.in);

    private String affectedArea;
    private double affectedScale;

    //Tutaj tak samo jak w Klasie DrugDevelopmentEvent
    String [] SpreadEventName = new String[]{"Musical even", "National holiday", "Hot week", "End of the school year", "Influencer event", "National protest", "Important political event"};

    double [] SpreadBonus = new double[] {13.2, 9.9, 5.3, 7.4, 12.4, 10, 11.4, 8.2};



    @Override

    public void Execute(DiseaseAgent diseaseAgent) {
        try{
            int SpreadIndex = (int) (Math.random() * getSpreadEventNameArr().length);
            ui.horizontal(65);
            System.out.print("!!!WARNING!!!WARNING!!!WARNING!!!");
            System.out.println();
            ui.horizontal(65);
            System.out.print("-------------------------------------------------------");
            System.out.println();
            ui.horizontal(65);
            System.out.print("|World News: People were infected on the " + getSpreadEventName(SpreadIndex));
            System.out.println();
            ui.horizontal(65);
            System.out.print("|World News: It caused the disease to spread faster +" + getSpreadBonus(SpreadIndex) + "%");
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




    public String[] getSpreadEventNameArr() {
        return SpreadEventName;
    }


    public String getSpreadEventName(int i) {
        return SpreadEventName[i];
    }

    public double[] SpreadBonusArr() {
        return SpreadBonus;
    }


    public double getSpreadBonus(int i) {
        return SpreadBonus[i];
    }
}