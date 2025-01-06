import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. 
     * She tabulates the number of times she breaks her season record for most points and least points in a game. 
     * Points scored in the first game establish her record for the season, and she begins counting from there.
     * 
     *
     * 
     * The function returns an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     * An array with the numbers of times she broke her records. 
     * Index 0 is for breaking most points records, and index 1 is for breaking least points records.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    
    int breakHigh = 0;
    int breakLow = 0;
    
    int currentHigh = scores.get(0);
    int currentLow = scores.get(0);
    
    for (int i = 1; i < scores.size(); i ++) {
        if (scores.get(i) > currentHigh) {
            breakHigh ++;
            currentHigh = scores.get(i);
            continue;
        } else if (scores.get(i) < currentLow){
            breakLow ++;
            currentLow = scores.get(i);
            continue;
        }
    }
    
    List<Integer> result = new ArrayList<>();
    result.add(breakHigh);
    result.add(breakLow);
    
    return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
