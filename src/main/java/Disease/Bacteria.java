package Disease;

public class Bacteria extends DiseaseAgent implements  Idiesease{

   public Bacteria(){
        isBacteria = true;
    }
    private boolean toxigencity = false;
    private boolean survivalInHardCondition = false;
    private String [] ReproducingMethod = new String[]{"Cell division", "Transduction", "Transformation", "Conjugation"};
    private double [] ReproducingSpeed = new double[]{9.9, 8.2, 7.1, 3.1};



    @Override
    public void mutate() {

    }

    @Override
    public void spread() {

    }
}
