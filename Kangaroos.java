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
     * You are choreographing a circus show with various animals. 
     * For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
     * The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
     * The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
     * You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. 
     * If it is possible, return YES, otherwise return NO.
     * main constraints 0 <= x1 < x2 <= 10000
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
    // Write your code here
        if (v1 < v2) return "NO";
        if (x1 > x2) return "NO";
        if (v1 == v2) return "NO";
        //after one jump
        int pos1 = x1 + v1;
        int pos2 = x2 + v2;
        
        if (pos1 == pos2) {
            return "YES";
        } else return kangaroo (pos1, v1, pos2, v2);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
