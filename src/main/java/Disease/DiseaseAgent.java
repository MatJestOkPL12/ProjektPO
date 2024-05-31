
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

    public abstract void mutate();

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

    public static void increaseRateOfSpread(double bonus) {
        this.rateOfSpread += bonus;
        System.out.println("Rate of spread increased by: " + bonus);
    }

    public void increaseDrugResistance(double bonus) {
        this.drugResistance += bonus;
        System.out.println("Drug resistance increased by: " + bonus);
    }

    public double getRateOfSpread() {
        return rateOfSpread;
    }

    public double getDrugResistance() {
        return drugResistance;
    }
    public String getName(){
        return name;
    }


}
