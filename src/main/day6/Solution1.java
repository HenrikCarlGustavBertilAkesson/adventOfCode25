package main.day6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution1 {

    public static Long getTotal(ArrayList<Long[]> problems, String[] operations, Long tot) {
        for(int col = 0; col < problems.get(0).length; col++) {
            Long sum = problems.get(0)[col];
            for(int row = 1; row < problems.size(); row++) {
                if(operations != null) {
                    sum = operations[col].equals("*") ? 
                        sum * problems.get(row)[col] : 
                        sum + problems.get(row)[col];
                }   
            }
            tot += sum;
        }

        return tot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<Long[]> problems = new ArrayList<>();
        String[] operations = null;
        Pattern pattern = Pattern.compile("\\d+");

        while (line != null && !line.isEmpty()) {
            if(pattern.matcher(line).find()) {
                String[] numberStr = line.strip().split("\\s+");
                Long[] numbers = new Long[numberStr.length];
                int i = 0;
                for(String num : numberStr) {
                    numbers[i++] = Long.parseLong(num);
                }
                problems.add(numbers);
            } else {
                operations = line.strip().split("\\s+");
            }

            line = br.readLine();
        }

        Long tot = getTotal(problems, operations, 0L);

        System.out.println("Result: " + tot);
    }
}