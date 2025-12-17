package main.day3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution1 {

    public static int maxJolt(char[] bank, int start, int lim) {
        int max = -1;
        int maxIdx = start;
        for(int i = start; i < lim; i++) {
            int current = Integer.parseInt(String.valueOf(bank[i]));
            if(max < current) {
                max = current;
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> banks = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            banks.add(line.trim().toCharArray());
            line = br.readLine();
        }
        
        int tot = 0;

        for(char[] bank : banks) {
            int leftIdx = maxJolt(bank, 0, bank.length - 1);
            int rightIdx = maxJolt(bank, leftIdx + 1, bank.length);
            int sum = Integer.parseInt(String.valueOf(bank[leftIdx] + "" + bank[rightIdx]));

            tot += sum;
        }

        System.out.println(tot);
    }
}
