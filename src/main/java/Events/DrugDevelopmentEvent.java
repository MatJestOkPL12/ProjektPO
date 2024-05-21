package Events;

public class DrugDevelopmentEvent implements Iexecute, Event{
    private double bonus;
    private double ResearchSpeed;

    String [] developmentEventName = new String[]{"Groundbreaking discovery", "Funding from the European Union", "Pay raise", "Aid from a country outside of Word.Europe", " Hiring more researchers"};
    double [] develompnetBonus = new double[]{15.2, 7.3, 4.2, 9.4, 8.3};

    @Override
    public void Execute() {

    }
}
