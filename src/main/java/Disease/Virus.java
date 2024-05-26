package Disease;

import Word.Country;

import java.util.Random;

public class Virus extends DiseaseAgent implements Idiesease {

    private String [] transmissionModeArr = new String[]{"Droplet transmission", "Direct contact", "Indirect contact", "Vector-borne transmission", "BloodBorne transmission"};
    private double [] replicationSpeedArr = new double[]{12.1, 10.1, 9.3, 8.1, 7.0};
    private double replicationSpeed;
    private String TransmissionMode;
    private double environmentalResistance;

    public Virus() {
        this.isVirus = true;
    }

    public void DrawPropertiesOfVirus() {
        Random random = new Random();
        int randomNumberToChoiceOfArrays = random.nextInt(5);
        environmentalResistance = random.nextDouble() * 10;
    }

    @Override
    public void mutate() {
        int mutationIndex = new Random().nextInt(mutationBonus.length);
        applyMutation(mutationIndex);
    }

    @Override
    public void spread(Country[] countries) {
        // Implement spreading logic specific to Virus
    }

    @Override
    public void applyMutation(int mutationIndex) {
        if (mutationIndex >= 0 && mutationIndex < mutationBonus.length) {
            increaseRateOfSpread(mutationBonus[mutationIndex]);
        }
    }

    @Override
    public void applyResistance(int resistanceIndex) {
        if (resistanceIndex >= 0 && resistanceIndex < resistanceBonus.length) {
            increaseDrugResistance(resistanceBonus[resistanceIndex]);
        }
    }
}