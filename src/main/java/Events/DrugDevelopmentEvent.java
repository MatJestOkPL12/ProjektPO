package Events;

public class DrugDevelopmentEvent implements Iexecute, Event{
    private double bonus;
    private double ResearchSpeed;

    //Tu jaakas randomowa tablica losowych eventów co mogą przypieszyc badania nad chorobą
    String [] developmentEventName = new String[]{"Groundbreaking discovery", "Funding from the European Union", "Pay raise", "Aid from a country outside of Word.Europe", " Hiring more researchers"};

    //A tu tablica która o tyle zwieksza no i jeszcze sie trzeba zastanowić czyh to zwiekszać bedzie np o tyle % czy o tyle punktów badania (wymyslilem te liczby losowo XD)
    double [] develompnetBonus = new double[]{15.2, 7.3, 4.2, 9.4, 8.3};

    @Override
    public void Execute() {

    }
}
