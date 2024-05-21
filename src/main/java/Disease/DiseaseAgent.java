package Disease;

public  class DiseaseAgent {
    private String name = "ITE-12.73";
    protected boolean isBacteria = false;

    protected boolean isVirus = false;
    protected double rateOfSpread;
    protected double drugResistance;

    public void Mutate(){};
    public void Spread(){};

    public void Adapt(){};

}
