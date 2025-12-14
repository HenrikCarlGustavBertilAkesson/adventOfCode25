package main.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution1 {

    public static Long repeats(String num, int split, Long count) {
        String left = num.substring(0, split);
        String right = num.substring(split, num.length());

        if(left.equals(right) && Long.parseLong(left) > 0L) {
            return Long.parseLong(left + right);
        }

        return 0L;

        // return repeats(left, left.length() / 2, count) + 
        //     repeats(right, right.length() / 2, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(",");
        ArrayList<Long[]> ranges = new ArrayList<>();

        for(String range : line) {
            Long start = Long.parseLong(range.split("-")[0]);
            Long end = Long.parseLong(range.split("-")[1]);
            ranges.add(new Long[]{start, end});
        }

        Long sum = 0L;
        for(Long[] range : ranges) {
            Long num = range[0];
            while(num <= range[1]) {
                String numStr = String.valueOf(num);
                sum += repeats(numStr, numStr.length() / 2, sum);
                num++;
            }
        }
        
        System.out.println("Result: " + sum);
    }
}
