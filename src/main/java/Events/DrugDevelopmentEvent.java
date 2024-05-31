package Events;

import static ResearchTeam.ResearchTeam.progressInResearch;

public class DrugDevelopmentEvent implements Iexecute, Event {
    private double bonus;
    private double ResearchSpeed;

    //Tu jaakas randomowa h eventów co mogą przypieszyc badania nad chorobą
    static String[] developmentEventName = new String[]{"Groundbreaking discovery", "Funding from the European Union", "Pay raise", "Aid from a country outside of Word.Europe", " Hiring more researchers"};

    //A tu tablica która o tyle zwieksza no i jeszcze sie trzeba zastanowić czyh to zwiekszać bedzie np o tyle % czy o tyle punktów badania (wymyslilem te liczby losowo XD)
    double[] developmentBonus = new double[]{15.2, 7.3, 4.2, 9.4, 8.3};

    @Override
    public void Execute() {
        int developmentIndex = (int) (Math.random() * developmentEventNameArr().length);

        progressInResearch = progressInResearch + getdevelopmentBonus(developmentIndex);
        System.out.println("-------------------------------------------------------");
        System.out.println("|Research Team: " + getdevelopmentName(developmentIndex));
        System.out.println("|Research Team: Progress in developing drug +" + getdevelopmentBonus(developmentIndex) + "%");
        System.out.println("-------------------------------------------------------");
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