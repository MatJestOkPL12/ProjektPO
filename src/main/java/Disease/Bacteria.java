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
    /**
    * Ponizej tablice okreslające sposób i szybkosc rozmnazania sie bakteri. Są one umieszczone na odpowiednio swoich miejscach.
    * Jesli Transformation znajduje się w tablicy pod indeksem 2 to jego szybkosc jest w drugiej tablicy pod indeksem 2
     */
    private String [] ReproducingMethodArr = new String[]{"Cell division", "Transduction", "Transformation", "Conjugation"};
    private double [] ReproducingSpeedArr = new double[]{11.9, 10.2, 9.1, 5.1};

    private String reproducingMethod;
    private double reproducingSpeed;

/**
 * Metoda losuje właściwości bakterii
 * Takie jak metoda rozprzestrzeniania, szybkosc rozprzestrzeniania itp
 */
 public void DrawPropertiesOfBacteria() {
  drugResistance = 0.0;
  Random random = new Random();
  int reproducing = random.nextInt(4);
  int TrueOrFalse = random.nextInt(11);
  reproducingMethod = ReproducingMethodArr[reproducing];
  reproducingSpeed = ReproducingSpeedArr[reproducing];
  /**
   * Tutaj blok kodu który poprzez pseudowylosowaną liczbe wybiera właściwości bakteri takie jak czy jest toksyczna
   * i czy jest w stanie przetrwac w ciezkich warunkach
   * Jesli zmienna TruOrFalse ma wartość 10 zmienne toxigencity i survival in hard condition ustawia się na true
   * Jesli jest z przedialu 9-5 toxigencity = true
   * A jesli mniejsza od 5 survival in hard contition = true
   */
  if (TrueOrFalse == 10) {
   toxigencity = true;
   survivalInHardCondition = true;
  } else if (TrueOrFalse < 10 && TrueOrFalse > 5) {
   toxigencity = true;
  } else if (TrueOrFalse <= 5 && TrueOrFalse > 0) {
   survivalInHardCondition = true;
  }
 }

 /**
  * Metoda odopwiedzialna za zarażanie osob
  */
 @Override
 public void spread(Country[] countries) {
  /**
   * Pętla sprawdzająca czy kraj ma już jakiekolwiek zarażenie na swoim terytorium
   * i jesli licba zakażonych jest mniejsza niz cała populacja choroba zaraża ludzi
   */
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
 public void mutate() {

 }

 /**
  * Metoda aplikuje losowa mutacje do naszej choroby
  * @param mutationIndex
  */
 @Override
 public void applyMutation(int mutationIndex) {
  if (mutationIndex >= 0 && mutationIndex < mutationEvent.getMutationNameArr().length) {
   increaseRateOfSpread(mutationEvent.getMutationBonus(mutationIndex));
  }
 }

 /**
  * Metoda aplikuje losową ochrone i utrudnia badanie leku nad nasza chorobą
  * @param resistanceIndex
  */
 @Override
 public void applyResistance(int resistanceIndex) {
  if (resistanceIndex >= 0 && resistanceIndex < mutationEvent.getResistanceBonusArr().length) {
   increaseDrugResistance(mutationEvent.getResistanceBonus(resistanceIndex));
  }
 }

 /**
  * Getery i settery pól potrzebych w innych klasach
  * @return
  */
 public boolean getToxigencity(){return  toxigencity;}
 public boolean getSurvivalInHardCondition(){return survivalInHardCondition;}
 public String getReproducingMethod(){ return reproducingMethod;}
 public double getReproducingSpeed(){return reproducingSpeed;}

 public double getDrugResistance(){return drugResistance;}
 public void setDrugResistance(double i ){
  drugResistance += i;
 }
 public void setReproducingSpeed(double i){
  reproducingSpeed += i;
 }
}