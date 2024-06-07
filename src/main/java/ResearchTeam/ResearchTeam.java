package ResearchTeam;

import Disease.Bacteria;
import Disease.DiseaseAgent;
import Disease.Virus;
import Word.Europe;

import java.util.Random;

public class ResearchTeam {
    public ResearchTeam(Europe europe, DiseaseAgent diseaseAgent){
        this.europe = europe;
        this.diseaseAgent = diseaseAgent;

    }
    private DiseaseAgent diseaseAgent;
    private Europe europe;
    private double efficiency = 100; // Efektywnosc zespołu, im wyższa tym szybciej idą badania
    public static double progressInResearch = 0; // Progress w badaniach - jesli wyniesie 100 gra sie konczy
    private double resources = 80; // Zasoby - mogą przyspieszyc badania nad chorobą
    private double drugResistance;
    int i = 0; //Zmienna zrobiona po to zeby po przekrocznieu 100 000 chorych zacząc badanie nad lekarstwem i ustawic progres in reasech jednorazowo na 0,01 ;)
    public void WorkOnDrug(){
        if(diseaseAgent instanceof Virus virus){
            drugResistance = virus.getDrugResistance();
        }
        else if(diseaseAgent instanceof  Bacteria bacteria) {
            drugResistance = bacteria.getDrugResistance();
        }
        else{
            drugResistance = 0;
        }
        if(europe.getNumberOfInfectionPeopleInEurope() > 100000 ){
            if(i == 0){
                progressInResearch = 0.01;
                i++;
            }
            Random random = new Random();
            int randomNumber = random.nextInt(15);
            if(randomNumber >4) {
                double increaseProgres = random.nextDouble() * 1.5;
                progressInResearch = progressInResearch + increaseProgres + (increaseProgres*efficiency/100.0);
                progressInResearch = progressInResearch - (progressInResearch*(drugResistance/100.0));


                if(resources >65){
                    double increaseProgresFromResources = random.nextDouble() * 2.5;
                    progressInResearch = progressInResearch + increaseProgresFromResources;
                    progressInResearch = progressInResearch - (progressInResearch*(drugResistance/100.0));
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
    }; // Metoda odpowiedzialna za badania nad lekiem

    public double getProgressInResearch(){
        return progressInResearch;
    }
}
