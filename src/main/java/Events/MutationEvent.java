package Events;

import Disease.DiseaseAgent;

public class MutationEvent implements Iexecute, Event {
    private double mutationRate;
    private String type = "Mutation Event";

    /**
     * Tak jak w przypadku innych tablic sa tu możliwe nazwy i wielkości ich bonusów które są na odpowiadających miejsach w tablicy
     * Air transmision jest na indeksie 0 wiec wielkość jego bonusu rónież jest na ndeksie 0
     */
    private String[] mutationName = new String[]{
            "Air transmission", "Water transmission", "Animal transmission", "Physical transmission",
            "Respiratory Symptoms", "Gastrointestinal Symptoms", "Genetic mutation", "Cough",
            "Fever", "Loss of taste", "Loss of smell", "Rapid Replication", "Increased Virulence",
            "Neurological Symptoms", "Skin Rash", "Blood Clotting", "Immune System Evasion",
            "Enhanced Environmental Resistance", "Drug Resistance", "Increased Spread Rate"
    };

    private double[] mutationBonus = new double[]{
            9.3, 6.3, 5.2, 9.0, 10.2, 3.1, 7.12, 4.5, 2.1, 1.2, 1.5, 8.0, 11.0,
            4.0, 5.5, 3.3, 6.8, 10.0, 12.0, 15.0
    };

    private String[] mutationResistanceName = new String[]{
            "Drug resistance", "Environmental resistance", "Immunological resistance", "Heat resistance", "Cold resistance",
            "UV resistance", "Antibiotic resistance", "Vaccine resistance", "Antiviral resistance"
    };

    private double[] resistanceBonus = new double[]{
            12.5, 6.7, 9.4, 5.5, 5.5, 7.8, 10.0, 8.5, 9.0
    };

    /**
     * Gettery potrzebych pól
     * @return
     */
    public String[] getMutationNameArr() {
        return mutationName;
    }

    public String[] getMutationResistanceNameArr() {
        return mutationResistanceName;
    }

    public String getMutationName(int i) {
        return mutationName[i];
    }

    public String getMutationResistanceName(int i) {
        return mutationResistanceName[i];
    }

    public double[] getMutationBonusArr() {
        return mutationBonus;
    }

    public double[] getResistanceBonusArr() {
        return resistanceBonus;
    }

    public double getMutationBonus(int i) {
        return mutationBonus[i];
    }

    public double getResistanceBonus(int i) {
        return resistanceBonus[i];
    }

    /**
     * Metoda aplikująca mutacje do naszej choroby
     * @param agent
     * @param mutationIndex
     */
    public void applyMutation(DiseaseAgent agent, int mutationIndex) {
        if (mutationIndex >= 0 && mutationIndex < mutationBonus.length) {
            agent.increaseRateOfSpread(mutationBonus[mutationIndex]);
        }
    }

    /**
     * Metoda aplikująca ochrone przed lekiem dla naszej choroby
     * @param agent
     * @param resistanceIndex
     */
    public void applyResistance(DiseaseAgent agent, int resistanceIndex) {
        if (resistanceIndex >= 0 && resistanceIndex < resistanceBonus.length) {
            agent.increaseDrugResistance(resistanceBonus[resistanceIndex]);
        }
    }

    @Override
    /**
     * Metoda która wywołuje oraz wybiera nam jakąś losową wybraną mutacje dla naszej choroby przez co  staje sie ona
     * silniejsza
     */
    public void Execute(DiseaseAgent agent) {
        int mutationIndex = (int) (Math.random() * mutationName.length);
        int resistanceIndex = (int) (Math.random() * mutationResistanceName.length);


        applyMutation(agent, mutationIndex);
        applyResistance(agent, resistanceIndex);

        System.out.println("-------------------------------------------------------");
        System.out.println("|Mutation applied: " + mutationName[mutationIndex] +
                " with bonus: " + mutationBonus[mutationIndex]);
        System.out.println("|Resistance applied: " + mutationResistanceName[resistanceIndex] +
                " with bonus: " + resistanceBonus[resistanceIndex]);
        System.out.println("-------------------------------------------------------");
    }


}
