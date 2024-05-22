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
    private double sanitationCondition=100; // Okresla w jakim stanie jest kondycja szpitali i lekarzy w danym kraju - pomysl byl taki zeby tam im nizsza tym wolniej rósł postęp nad badaniami leku ale nie wiem czy to sie przuda wsm XD

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
