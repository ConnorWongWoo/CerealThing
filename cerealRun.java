import java.io.*;
import java.util.*;
public class cerealRun{

    public static double average(ArrayList<Double> n) {
        double sum = 0;
        for (double i: n) {
            sum += i;
        }
        return sum / n.size(); 
    }

    public static double standardDeviation(ArrayList<Double> n) {
        double av = average(n);
        double sum = 0;
        for (double i: n) {
            sum += Math.pow(i - av, 2);
        }
        return Math.sqrt(sum / n.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("CerealData.csv"));
        Cereal[] cerealList = new Cereal[76];

        br.readLine();
        //each cereal
        for (int m = 0; m < 30; m++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            String stringData1 = new String();
            String stringData2 = new String();
            double[] dataLine = new double[13];

            stringData1 = st.nextToken();
            // System.out.println(stringData1 +" | "+ stringData2);
            stringData2 = st.nextToken();

            for (int i = 0; i < 13; i++) { 
                dataLine[i] = Double.parseDouble(st.nextToken()); 
            }
            Cereal cereal1 = new Cereal(stringData1, stringData2, dataLine[0], dataLine[1], dataLine[2], dataLine[3], dataLine[4], dataLine[5], dataLine[6], dataLine[7], dataLine[8], dataLine[9], dataLine[10], dataLine[11], dataLine[12] );
            cerealList[m] = cereal1;
            br.readLine();
        }
        // getNutritionRating(Cereal c);
        // ArrayList<Cereal> sortedCereal = new ArrayList<>();
        ArrayList<Double> ratings = new ArrayList<>();

        Map<Cereal, Double> sortedCereal = new HashMap<>();
        for (int i = 0; i < 30; i++){
            Cereal currentCereal = cerealList[i];
            double rating = currentCereal.getNutritionRating();
            sortedCereal.put(currentCereal, rating);
        }

        List<Map.Entry<Cereal, Double>> sortedList = new ArrayList<>(sortedCereal.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Cereal, Double> entry : sortedList) {
            ratings.add(entry.getValue());
            System.out.println("Rating: " + entry.getValue() + " | Cereal: " + entry.getKey().getName()); 
        }
        System.out.println("Standard deviation: " + standardDeviation(ratings));
        System.out.println("The healthiest cereal: " + sortedList.getLast().getKey().getName() + " has a standard deviation of " + ratings.getLast() + ", which is " + (Math.round(ratings.getLast()-standardDeviation(ratings))) + " points above the standard deviation.");
    }
}