package Disease;

import Events.MutationEvent;
import Word.Country;

import java.util.Random;

public class Bacteria extends DiseaseAgent implements  Idiesease{

   public Bacteria(MutationEvent mutationEvent){

    isBacteria = true;
    this.mutationEvent = mutationEvent;
    }
    MutationEvent mutationEvent;
    private boolean toxigencity = false;
    private boolean survivalInHardCondition = false;
    private String [] ReproducingMethodArr = new String[]{"Cell division", "Transduction", "Transformation", "Conjugation"};
    private double [] ReproducingSpeedArr = new double[]{9.9, 8.2, 7.1, 3.1};

    private String reproducingMethod;
    private double reproducingSpeed;


 public void DrawPropertiesOfBacteria() {
  Random random = new Random();
  int reproducing = random.nextInt(5);
  int TrueOfFalse = random.nextInt(11);
  reproducingMethod = ReproducingMethodArr[reproducing];
  reproducingSpeed = ReproducingSpeedArr[reproducing];

  if (TrueOfFalse == 10) {
   toxigencity = true;
   survivalInHardCondition = true;
  } else if (TrueOfFalse < 10 && TrueOfFalse > 5) {
   toxigencity = true;
  } else if (TrueOfFalse <= 5 && TrueOfFalse > 0) {
   survivalInHardCondition = true;
  }
 }

 @Override
 public void mutate() {
  int mutationIndex = new Random().nextInt(mutationEvent.getMutationBonusArr().length);
  applyMutation(mutationIndex);
 }

 @Override
 public void spread(Country[] countries) {
  for (int i = 0; i < 49; i++) {
   if (!countries[i].getInfectionStatus()) {
    continue;
   } else if (countries[i].getInfectionPeople() == countries[i].getPopulation()) {
    continue;
   } else {
    long buff = countries[i].getInfectionPeople();
    buff = (long) (buff * reproducingSpeed);
    countries[i].setInfectionPeople(buff);

    if (countries[i].getInfectionPeople() > countries[i].getPopulation()) {
     countries[i].setInfectionPeople(countries[i].getPopulation());
    }
   }
  }
 }

 @Override
 public void applyMutation(int mutationIndex) {
  if (mutationIndex >= 0 && mutationIndex < mutationEvent.getMutationNameArr().length) {
   increaseRateOfSpread(mutationEvent.getMutationBonus(mutationIndex));
  }
 }

 @Override
 public void applyResistance(int resistanceIndex) {
  if (resistanceIndex >= 0 && resistanceIndex < mutationEvent.getResistanceBonusArr().length) {
   increaseDrugResistance(mutationEvent.getResistanceBonus(resistanceIndex));
  }
 }

 public boolean getToxigencity(){return  toxigencity;}
 public boolean getSurvivalInHardCondition(){return survivalInHardCondition;}
 public String getReproducingMethod(){ return reproducingMethod;}
 public double getReproducingSpeed(){return reproducingSpeed;}
}