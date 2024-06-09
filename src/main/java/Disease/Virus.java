package Disease;

import Events.MutationEvent;
import Word.Country;

import java.util.Random;

public class Virus extends DiseaseAgent implements Idiesease {
    /**
     * Tablice które zawierają dane o mozliwych mozliwościach przenoszenia choroby i jej szybkości
     * Miejsca w tablicy transmissionModeArr odowiadają miejscami w tablicy replicationSpeedArr, to znaczy, że np
     * BlooodBorne transmission jest na miejscu o indeksie 4 więc jego szybkość jest ustalona w drugiej tablicy na indeksie również 4
     */
    private String[] transmissionModeArr = new String[]{
            "Droplet transmission", "Direct contact", "Indirect contact", "Vector-borne transmission", "BloodBorne transmission"
    };
    private double[] replicationSpeedArr = new double[]{
            14.1, 12.1, 11.3, 10.1, 9.0
    };
    private double replicationSpeed;
    private String transmissionMode;
    private double environmentalResistance;
    private MutationEvent mutationEvent;

    public Virus(MutationEvent mutationEvent) {
        this.isVirus = true;
        this.mutationEvent = mutationEvent;
    }

    /**
     * Metoda któa losuje właściowości wirusa t
     */
    public void DrawPropertiesOfVirus() {
        drugResistance= 0.0;
        Random random = new Random();
        int randomNumberToChoiceOfArrays = random.nextInt(5);
        environmentalResistance = random.nextDouble() * 10;
        replicationSpeed = replicationSpeedArr[randomNumberToChoiceOfArrays];
        transmissionMode = transmissionModeArr[randomNumberToChoiceOfArrays];
    }

    @Override
    public void mutate() {
        int mutationIndex = new Random().nextInt(mutationEvent.getMutationBonusArr().length);
        applyMutation(mutationIndex);
    }

    /**
     * Metoda odpowiedzialna za zarażanie ludzi
     * @param countries
     */
    @Override
    public void spread(Country[] countries) {
        /**
         * Pętla najpier sprawdza czy dany kraj ma jakąś zarażoną osobe na terenie swojego kraju, jeśli nie nic się nie dzieje
         * jesli tak kolejne osoby są zarażane
         */
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

    /**
     * Metoda aplikuje losowa mutacje i bonsy dla naszego wirusa
     * @param mutationIndex
     */
    @Override
    public void applyMutation(int mutationIndex) {
        if (mutationIndex >= 0 && mutationIndex < mutationEvent.getMutationNameArr().length) {
            increaseRateOfSpread(mutationEvent.getMutationBonus(mutationIndex));
        }
    }

    /**
     * Metoda aplikuje pewną odporność na tworzone leki, przez co cięzej wytworzyć lekarstwo
     * @param resistanceIndex
     */
    @Override
    public void applyResistance(int resistanceIndex) {
        if (resistanceIndex >= 0 && resistanceIndex < mutationEvent.getMutationResistanceNameArr().length) {
            increaseDrugResistance(mutationEvent.getResistanceBonus(resistanceIndex));
        }
    }


    /**
     * Getery i settery potrzebych pól
     * @return
     */
    public double getReplicationSpeed(){return replicationSpeed;}
    public String getTransmissionMode(){return transmissionMode;}
    public double getEnvironmentalResistance(){return environmentalResistance;}
    public void setReproducingSpeed(int i ){
        replicationSpeed +=i;
    }
    public void setEnvironmentalResistance(int i){environmentalResistance +=i;}
    public void setDrugResistance(int i){drugResistance += i;}

    public double getDrugResistance(){return drugResistance;}
}