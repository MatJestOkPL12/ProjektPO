package ResearchTeam;

import Word.Europe;

import java.util.Random;

public class ResearchTeam { // Tu jeszce nic nie bylo robione prawie
    public ResearchTeam(Europe europe){
        this.europe = europe;
    }
    private Europe europe;
    private double efficiency = 100; // Efektywnosc zespołu, im wyższa tym szybciej idą badania
    private double progressInResearch = 0; //
    private double resources = 80;
    int i = 0; //Zmienna zrobiona po to zeby po przekrocznieu 100 000 chorych zacząc badanie nad lekarstwem i ustawic progres in reasech jednorazowo na 0,01 ;)
    public void WorkOnDrug(){
        if(europe.getNumberOfInfectionPeopleInEurope() > 100000 ){
            if(i == 0){
                progressInResearch = 0.01;
                i++;
            }
            Random random = new Random();
            int randomNumber = random.nextInt(15);
            if(randomNumber >4) {
                double increaseProgres = random.nextDouble() * 2;
                progressInResearch = progressInResearch + increaseProgres + (increaseProgres*efficiency/100);

                if(resources >65){
                    double increaseProgresFromResources = random.nextDouble() * 3;
                    progressInResearch = progressInResearch + increaseProgresFromResources;
                }


                int changeOfEfficiency = random.nextInt(21) - 10; //Liczby losowane z zakresu -10, 10
                int changeOfResources = random.nextInt(21) - 10;
                efficiency = efficiency + changeOfEfficiency;
                resources = resources + changeOfResources;
                if (efficiency < 0) {
                    efficiency = 0;
                }
                if (efficiency > 100) {
                    efficiency = 100;
                }
                if (resources < 0) {
                    resources = 0;
                }
                if (resources > 100) {
                    resources = 100;
                }
                if (progressInResearch > 100) {
                    progressInResearch = 100;
                }
            }
        }
    };

    public double getProgressInResearch(){
        return progressInResearch;
    }
}
