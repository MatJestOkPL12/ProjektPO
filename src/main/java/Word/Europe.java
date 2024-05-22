package Word;

public class Europe {

// Tablica Kraji w Europie
    private String [] countries = new String[]{"Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium", "Bosnia and Herzegovina" ,
            "Bulgaria", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Hungary",
    "Iceland", "Ireland", "Italy", "Kazakhstan", "Latvia", "Lichtenstein", "Lithuania"," Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands",
     "North Macedonia", "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey" ,
            "Ukraine", "United Kingdom"};
    //Tablica ludnośći w danym kraju
    public long[] population = new long[]{2854710,79034,2790974,8922082,10312992,9578167,11611419,3270943,6885868,4060135,1244188,10510751,5854240,1328701,535992,64531444,3757980
    ,83408554,10445365,9709786,370335,4986526,59340329, 19196465,1873919, 39039,2786651,639321,526748, 3061506, 36686,627859, 17501696, 2103330, 5403021,38307726, 10290103, 19328560,145102755,
    33745, 7296769, 5447622, 2119410, 47486935, 10467097, 8691406, 84775404, 43531422, 67281039};

    // Tablica klimatu w danym kraju
    private String[] climates = {"Mediterranean", "Alpine", "Continental", "Continental", "Dry subtropical", "Continental", "Maritime", "Continental",
            "Continental", "Mediterranean", "Mediterranean", "Continental", "Maritime", "Maritime", "Maritime", "Maritime", "Continental", "Maritime", "Mediterranean", "Mediterranean",
            "Maritime", "Maritime", "Maritime", "Continental", "Continental", "Continental", "Continental", "Maritime", "Maritime", "Continental", "Continental", "Continental",
            "Continental", "Continental", "Continental", "Continental", "Maritime", "Continental", "Continental", "Continental", "Continental", "Continental",
            "Maritime", "Continental", "Continental", "Continental", "Maritime", "Continental", "Continental", "Continental"};

    //Kraje, ludność i klimat w poszczególnych krajach są w odpowiadających do siebie miejscach w tablicy - tzn jeśli Blegia jest pod indeksem 6 w tablicy Country
    //to jej populacja i klimat też są w odpowiednich tablicach na 6 miejscu

    private double globalHealthStatus = 100; // % zdrowia całej europy - jesli spadnie do 0 gra sie konczy - Gracz wygrywa


    private long numberOfPeoplesInEurope =860346749; //

    //Gettery i settery do zmiennych w klasie Europe

    public double getGlobalHealthStatus(){
        return globalHealthStatus;
    }

    public void setGlobalHealthStatus(double globalHealthStatus){
        this.globalHealthStatus = globalHealthStatus;
    }



    //Gettery do odpowiednich danych w tablicach
    public String getCountries(int i ){
        return countries[i];
    }
    public long getPopulation( int i){
        return population[i];
    }
    public String getClimates( int i ){
        return climates[i];
    }
}
