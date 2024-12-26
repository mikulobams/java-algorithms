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

    /*
     * 'timeConversion'
     *
     * The function returns a STRING in time 24h format e.g 00:00:00
     * The function accepts STRING s as parameter in 12h format e.g 12:00:00AM
     */

    public static String timeConversion(String s) {
        // Write your code here
        String format = s.substring(s.length()-2);
        String newTime = "";
        
        if (format.equals("PM") ) {
            if (s.substring(0,2).equals("12")) {
                newTime = s.substring(0, s.length()-2);
            } else {
                int newHour = Integer.parseInt(s.substring(0,2)) + 12;
                newTime = Integer.toString(newHour) + s.substring(2, s.length()-2);
            }
        } else {
            if (s.substring(0,2).equals("12")) {
                newTime = "00:" + s.substring(3, s.length()-2);
            } 
            
            else {
                newTime = s.substring(0, s.length()-2);
            }
        }
        
        return newTime;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
