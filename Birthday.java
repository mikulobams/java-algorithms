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

class Birthday {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d, the sum of the integers in array of length m
     *  3. INTEGER m: the length of the subarray
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Initialize a counter to track the number of valid segments
        int amount = 0;

        // Iterate over the list `s`, considering each index as a potential starting point
        for (int i = 0; i < s.size(); i++) {
            // If the current starting index plus the segment size exceeds the list size,
            // break out of the loop as we can't form a valid segment
            if (i + m > s.size())
                break;

            // Extract a sublist of size `m` starting at index `i`
            // Use a stream to calculate the sum of elements in the sublist
            int sum = s.subList(i, i + m).stream()
                       .mapToInt(Integer::intValue) // Convert Integer to int
                       .sum(); // Calculate the sum of the integers

            // If the sum of the current segment matches the target `d`, increment the counter
            if (sum == d)
                amount++;
        }

        // Return the total count of valid segments
        return amount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
