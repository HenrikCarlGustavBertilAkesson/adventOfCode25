package main.day6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution2 {

    public static boolean isEmptyCol(ArrayList<char[]> problems, int col) {
        for(char[] row : problems) {
            if(row[col] >= '0' && row[col] <= '9') {
                return false;
            }
        }

        return true;
    }

    public static boolean isEmptyCol(char[] operations, int col) {
        return operations[col] != '+' && operations[col] != '*';
    }

    public static Long getNumInCol(ArrayList<char[]> problems, int col) {
        StringBuilder num = new StringBuilder();
        for(char[] row : problems) {
            if(row[col] >= '0' && row[col] <= '9') {
                num.append(row[col]);
            }
        }

        if(num.isEmpty()) {
            System.out.println("No number in column " + col);
            return -1L;
        }

        return Long.parseLong(num.toString());
    }

    public static char getOperationInCol(char[] operations, int col) {
        for(int i = 0; i < operations.length; i++) {
            if((operations[i] == '*' || operations[i] == '+') && i == col) {
                return operations[i];
            }
        }

        System.out.println("No operation in column " + col);

        return ' ';
    }

    public static Long getTotal(ArrayList<char[]> problems, char[] operations, Long tot) {
        int col = problems.get(0).length - 1;
        ArrayList<Long> numbers = new ArrayList<>();
        while(col > -1) {
            if(!isEmptyCol(operations, col)) {
                char op = getOperationInCol(operations, col);
                numbers.add(getNumInCol(problems, col));
                Long num = numbers.get(0);
                for(int i = 1; i < numbers.size(); i++) {
                    num = op == '+' ?
                            num + numbers.get(i) :
                            num * numbers.get(i);
                }
                tot += num;
            } else if(!isEmptyCol(problems, col)) {
                numbers.add(getNumInCol(problems, col));
            }

            if(isEmptyCol(problems, col)) numbers = new ArrayList<>();

            col--;
        }

        return tot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> problems = new ArrayList<>();
        char[] operations = null;
        Pattern pattern = Pattern.compile("\\d+");
        
        while (line != null && !line.isEmpty()) {
            if(pattern.matcher(line).find()) {
                problems.add(line.toCharArray());
            } else {
                operations = line.toCharArray();
            }
            line = br.readLine();
        }

        Long tot = getTotal(problems, operations, 0L);

        System.out.println("Result: " + tot);
    }
}