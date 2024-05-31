package Events;


import Disease.DiseaseAgent;

public class EpidemicSpreadEvent  implements Iexecute, Event {
    MutationEvent mutationEvent = new MutationEvent();

    private String affectedArea;
    private double affectedScale;

    //Tutaj tak samo jak w Klasie DrugDevelopmentEvent
    String [] SpreadEventName = new String[]{"Musical even", "National holiday", "Hot week", "End of the school year", "Influencer event", "National protest", "Important political event"};

    double [] SpreadBonus = new double[] {13.2, 9.9, 5.3, 7.4, 12.4, 10, 11.4, 8.2};



    @Override

    public void Execute() {
        try{
            int SpreadIndex = (int) (Math.random() * getSpreadEventNameArr().length);
            DiseaseAgent agent = new DiseaseAgent() {
                @Override
                public void mutate() {

                }

                @Override
                public void applyMutation(int mutationIndex) {
                    increaseRateOfSpread(getSpreadBonus(SpreadIndex));
                }

                @Override
                public void applyResistance(int resistanceIndex) {

                }
            };


            System.out.println("-------------------------------------------------------");
            System.out.println("|World News: People were infected on the " + getSpreadEventName(SpreadIndex));
            System.out.println("|World News: It caused the disease to spread faster +" + getSpreadBonus(SpreadIndex) + "%");
            System.out.println("-------------------------------------------------------");
        } catch (Exception e) {
            System.err.println("An error occurred during execution: " + e.getMessage());
            e.printStackTrace();
        }

    }




    public String[] getSpreadEventNameArr() {
        return SpreadEventName;
    }


    public String getSpreadEventName(int i) {
        return SpreadEventName[i];
    }

    public double[] SpreadBonusArr() {
        return SpreadBonus;
    }


    public double getSpreadBonus(int i) {
        return SpreadBonus[i];
    }
}