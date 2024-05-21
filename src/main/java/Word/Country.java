package Word;

public class Country {

    public Country(String name, long population, String climate){
        this.name = name;
        this.population = population;
        this.climate = climate;
    }
    private String name;
    private long population;
    private double healthLevel=100;
    private String climate;
    private boolean infectionStatus = false;
    private double sanitationCondition=100;

    public double UpdateHealthStatus(){
        return healthLevel;
    };
    public void Infect(){
        infectionStatus = true;
        setHealthLevel() ;

    };

    public double setHealthLevel(){
        return healthLevel;
    }

    public boolean getInfectionStatus(){
        return infectionStatus;
    }

    public String getName(){
        return name;
    }

}
