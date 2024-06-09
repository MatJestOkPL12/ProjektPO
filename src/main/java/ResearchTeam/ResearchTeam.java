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
    private double efficiency = 100;
    public static double progressInResearch = 0;
    private double resources = 80;
    private double drugResistance;
    /**
     * Zmienna i jest pomocniczą zmienna która jest po to aby po zarażonych 100 000 ludzi zmienia się ona
     * i rozpoczynają się badania nad lekarstwem
     */
    int i = 0;

    /**
     * Metoda która jest odpowiedzialna za badania nad lekarstwem
     */
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
        /**
         * Rozpoczęcie badań nad lekiem
         */
        if(europe.getNumberOfInfectionPeopleInEurope() > 100000 ){
            if(i == 0){
                progressInResearch = 0.01;
                i++;
            }
            Random random = new Random();
            /**
             * Postęp w tworzeniu lekarstwa w danym dniu następuje tylko wtedy kiedy zmienna losowa
             * będzie > 4
             * Do tego jesli resources > 65 badania w danym dniu uzykują kolejny bonus w dniu który makymalnie może wynieść
             * +2,5%
             * Każdego dana zmienniana jest również efektywność zespołu i własnie zasobu
             * (mogą one rosnąć lub maleć)
             * Mają one duży wpłw na szybkość tworzenia leku
             * im mają one większą wartość tym badania idą szybciej
             */
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
    };

    public double getProgressInResearch(){
        return progressInResearch;
    }
}
