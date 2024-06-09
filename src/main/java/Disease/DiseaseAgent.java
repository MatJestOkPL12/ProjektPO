
package Disease;

import Word.Country;

public abstract class DiseaseAgent {
    private String name = "ITE-12.73";
    protected boolean isBacteria = false;
    protected boolean isVirus = false;
    protected double rateOfSpread;
    protected double drugResistance;



    public DiseaseAgent() {
        this.rateOfSpread = 0.0;
        this.drugResistance = 0.0;
    }

    /**
     * Abstakcyjne metody aplikowania mutacji i obrony przed lekami rozbudowane w klasie bakteria i wirus
     * @param mutationIndex
     *
     */
    public abstract void applyMutation(int mutationIndex);

    public abstract void applyResistance(int resistanceIndex);


    public void spread(Country[] countries) {

    }

    public void changeIsVirus(){
        if(isVirus){
            isVirus = false;
        }
        else {
            isVirus = true;
        }

    }
    public void changeIsBaceria(){
        if(isBacteria){
            isBacteria = false;
        }
        else {
            isBacteria = true;
        }
    }

    /**
     * Metoda która zwiększa szybkość przenoszenia choroby
     * @param bonus
     */
    public void increaseRateOfSpread(double bonus) {
        this.rateOfSpread += bonus;
        System.out.println("Rate of spread increased by: " + bonus);
    }

    /**
     * Metoda która zwiększa odporność na leki
     * @param bonus
     */

    public void increaseDrugResistance(double bonus) {
        this.drugResistance += bonus;
        System.out.println("Drug resistance increased by: " + bonus);
    }

    /**
     * Gettery i settery potrzebnych pól
     * @return
     */
    public double getRateOfSpread() {
        return rateOfSpread;
    }

    public String getName(){
        return name;
    }


}
