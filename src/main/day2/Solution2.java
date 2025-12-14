package main.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution2 {

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
                boolean repeats = true;

                if(numStr.length() < 2) {
                    num++;
                    continue;
                }

                for(int i = 0; i < numStr.length() / 2; i++) {
                    repeats = true;
                    String subStr = numStr.substring(0, i + 1);

                    for(int j = 0; j < numStr.length() - i; j += i + 1) {
                        String a = numStr.substring(j, j + i + 1);
                        String b = numStr.substring(numStr.length() - 1 - i - j, numStr.length() - j);
                        if(!subStr.equals(a) || !subStr.equals(b)) {
                            repeats = false;
                            break;
                        }
                    }

                    if(repeats) {
                        break;
                    }
                }

                if(repeats) {
                    sum += num;
                }
                num++;
            }
        }

        System.out.println("Result: " + sum);
    }
}
