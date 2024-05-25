package Events;

import Disease.DiseaseAgent;

public class MutationEvent implements Iexecute, Event {
    private double mutationRate;
    private String type = "Mutation Event";

    private String[] mutationName = new String[]{
            "Air transmission", "Water transmission", "Animal transmission", "Physical transmission",
            "Respiratory Symptoms", "Gastrointestinal Symptoms", "Genetic mutation", "Cough",
            "Fever", "Loss of taste", "Loss of smell", "Rapid Replication", "Increased Virulence"
    };

    private double[] mutationBonus = new double[]{
            9.3, 6.3, 5.2, 9.0, 10.2, 3.1, 7.12, 4.5, 2.1, 1.2, 1.5, 8.0, 11.0
    };

    private String[] mutationResistanceName = new String[]{
            "Drug resistance", "Environmental resistance", "Immunological resistance", "Heat resistance", "Cold resistance",
            "UV resistance", "Antibiotic resistance"
    };

    private double[] resistanceBonus = new double[]{
            12.5, 6.7, 9.4, 5.5, 5.5, 7.8, 10.0
    };

    public void applyMutation(DiseaseAgent agent, int mutationIndex) {
        if (mutationIndex >= 0 && mutationIndex < mutationBonus.length) {
            agent.increaseRateOfSpread(mutationBonus[mutationIndex]);
        }
    }

    public void applyResistance(DiseaseAgent agent, int resistanceIndex) {
        if (resistanceIndex >= 0 && resistanceIndex < resistanceBonus.length) {
            agent.increaseDrugResistance(resistanceBonus[resistanceIndex]);
        }
    }

    @Override
    public void Execute() {
        int mutationIndex = (int) (Math.random() * mutationName.length);
        int resistanceIndex = (int) (Math.random() * mutationResistanceName.length);

        DiseaseAgent agent = getTargetDiseaseAgent();
        applyMutation(agent, mutationIndex);
        applyResistance(agent, resistanceIndex);

        System.out.println("Mutation applied: " + mutationName[mutationIndex] +
                " with bonus: " + mutationBonus[mutationIndex]);
        System.out.println("Resistance applied: " + mutationResistanceName[resistanceIndex] +
                " with bonus: " + resistanceBonus[resistanceIndex]);
    }

    private DiseaseAgent getTargetDiseaseAgent() {
        return new DiseaseAgent(); // Placeholder method, should be implemented to get the actual target DiseaseAgent
    }
}
