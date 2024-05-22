package Events;

public class EpidemicSpreadEvent  implements Iexecute, Event {
    private String affectedArea;
    private double affectedScale;

    //Tutaj tak samo jak w Klasie DrugDevelopmentEvent
    String [] spreadEventName = new String[]{"Musical even", "National holiday", "Hot week", "End of the school year", "Influencer event", "National protest", "Important political event"};

    double [] spreadBonus = new double[] {13.2, 9.9, 5.3, 7.4, 12.4, 10, 11.4, 8.2};



    @Override
    public void Execute() {

    }
}
