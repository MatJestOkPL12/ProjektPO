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


    private long infectionPeople = 0;

    public double UpdateHealthStatus(){
        return healthLevel;
    };
    public void Infect(){
        infectionStatus = true;
        setHealthLevel() ;

    };

    /**
     * Gettery i setery dla potrzebnych pól z danej klasy
     * @return
     */

    public double setHealthLevel(){
        return healthLevel;
    }

    public boolean getInfectionStatus(){
        return infectionStatus;
    }

    public String getName(){
        return name;
    }

    public void setInfectionPeople(long infectionPeople){
        this.infectionPeople = infectionPeople;
    }
    public long getInfectionPeople(){
        return infectionPeople;
    }
    public long getPopulation(){
        return population;
    }

    public void changeInfectionStatus(){
        infectionStatus = true;
    }

}
