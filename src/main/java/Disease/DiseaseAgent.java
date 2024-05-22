package Disease;

import Word.Country;

public  class DiseaseAgent {
    private String name = "ITE-12.73";
    protected boolean isBacteria = false;

    protected boolean isVirus = false;
    protected double rateOfSpread;
    protected double drugResistance;

    public void Mutate(){};
    public  void spread(Country [] countries){
        System.out.println("tak");
    };

    public void Adapt(){};

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

    public void przedstawsie(){
        System.out.println("jestem choroba");
    }


}
