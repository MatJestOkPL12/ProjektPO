package Events;


import Disease.DiseaseAgent;

public class EpidemicSpreadEvent  implements Iexecute, Event {
    MutationEvent mutationEvent = new MutationEvent();
    private String affectedArea;
    private double affectedScale;

    //Tutaj tak samo jak w Klasie DrugDevelopmentEvent
    String [] spreadEventName = new String[]{"Musical even", "National holiday", "Hot week", "End of the school year", "Influencer event", "National protest", "Important political event"};

    double [] spreadBonus = new double[] {13.2, 9.9, 5.3, 7.4, 12.4, 10, 11.4, 8.2};



    @Override
    public void Execute() {
        int mutationIndex = (int) (Math.random() * mutationEvent.getMutationNameArr().length);//mutationName.length);
        int resistanceIndex = (int) (Math.random() * mutationEvent.getMutationResistanceNameArr().length);//mutationResistanceName.length);

        DiseaseAgent agent = getTargetDiseaseAgent();
        agent.applyMutation(mutationIndex);
        agent.applyResistance(resistanceIndex);

        System.out.println("Mutation applied: " + mutationEvent.getMutationName(mutationIndex));//mutationName[mutationIndex]);
        System.out.println("Resistance applied: " + mutationEvent.getMutationResistanceName(resistanceIndex));//mutationResistanceName[resistanceIndex]);
    }

    private DiseaseAgent getTargetDiseaseAgent() {
        //
        return new DiseaseAgent() {
            @Override
            public void mutate() {

            }

            @Override
            public void applyMutation(int mutationIndex) {
                //
            }

            @Override
            public void applyResistance(int resistanceIndex) {
                //
            }
        };
    }
}