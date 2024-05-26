package Disease;

import Events.EpidemicSpreadEvent;
import Events.MutationEvent;
import Word.Country;

import java.util.Random;

public class Virus extends DiseaseAgent implements Idiesease {

    private String [] transmissionModeArr = new String[]{"Droplet transmission", "Direct contact", "Indirect contact", "Vector-borne transmission", "BloodBorne transmission"};
    private double [] replicationSpeedArr = new double[]{12.1, 10.1, 9.3, 8.1, 7.0};
    private double replicationSpeed;
    private String transmissionMode;
    private double environmentalResistance;

    public Virus(MutationEvent mutationEvent) {
        this.isVirus = true;
        this.mutationEvent = mutationEvent;
    }

    MutationEvent mutationEvent;


    public void DrawPropertiesOfVirus() {
        Random random = new Random();
        int randomNumberToChoiceOfArrays = random.nextInt(5);
        environmentalResistance = random.nextDouble() * 10;
        replicationSpeed = replicationSpeedArr[randomNumberToChoiceOfArrays];
        transmissionMode = transmissionModeArr[randomNumberToChoiceOfArrays];

    }

    @Override
    public void mutate() {
        int mutationIndex = new Random().nextInt(mutationEvent.getMutationBonusArr().length); //mutationBonus.length
        applyMutation(mutationIndex);
    }

    @Override
    public void spread(Country[] countries) {
        for(int i = 0; i<49; i++){
            if(!countries[i].getInfectionStatus()){
                continue;
            }
            else if(countries[i].getInfectionPeople() == countries[i].getPopulation()){
                continue;
            }
            else {
                long buff = countries[i].getInfectionPeople();
                buff = (long)(buff*replicationSpeed);
                countries[i].setInfectionPeople(buff);
            }
            if(countries[i].getInfectionPeople() > countries[i].getPopulation()){
                countries[i].setInfectionPeople(countries[i].getPopulation());
            }
        }
    }

    @Override
    public void applyMutation(int mutationIndex) {
        if (mutationIndex >= 0 && mutationIndex < mutationEvent.getMutationNameArr().length)//mutationBonus.length) {
            increaseRateOfSpread(mutationEvent.getMutationBonus(mutationIndex));
        }


    @Override
    public void applyResistance(int resistanceIndex) {
        if (resistanceIndex >= 0 && resistanceIndex < mutationEvent.getMutationResistanceNameArr().length) {
            increaseDrugResistance(mutationEvent.getResistanceBonus(resistanceIndex));
        }
    }
}