package Events;

public class MutationEvent  implements Iexecute, Event{
    private double mutationRate;
    private String type = "Mutation Events.Event";

    String [] mutationName = new String[]{"Air transmision", "Water Transmision", "Animal Transmision", "Pchysical Transmision", "Respiratory Symptoms"
            ,"Gastrointestinal Symptoms", "Genetic mutation", "Cough", "Fever", "Loss of taste", "Loss of smell"};

    double [] mutationBonus = new double[]{9.3, 6.3, 5.2, 9.0, 10.2, 3.1, 7.12, 4.5, 2.1, 1.2, 1.5};

    String [] mutationResistanceName = new String[]{"Drug resistance", "Environmental resistance", "Immunological resistance", "Heat resistance", "Cold resistance"};

    double [] resistanceBonus = new double[]{12.5, 6.7, 9.4, 5.5, 5.5};





    @Override
    public void Execute() {

    }
}
