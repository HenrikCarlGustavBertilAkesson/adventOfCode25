package main.day3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution2 {

    static int jolts;
    static int len;
    static int lim;
    static String sum = "";

    public static String maxJolt(String bank) {
        int max = -1;
        int maxIdx = 0;
        for(int i = 0; i < lim; i++) {
            int current = Integer.parseInt(String.valueOf(bank.charAt(i)));
            if(max < current) {
                max = current;
                maxIdx = i;
            }
        }

        sum += String.valueOf(max);
        bank = bank.substring(maxIdx + 1);
        --jolts;
        lim = bank.length() - jolts + 1;

        return bank;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<String> banks = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            banks.add(line.trim());
            line = br.readLine();
        }
        
        Long tot = 0L;
        
        for(String bank : banks) {
            
            jolts = 12;
            len = banks.get(0).length();
            lim = len - jolts;
            sum = "";

            for(int i = 0; i < 12; i++) {
                bank = maxJolt(bank);
            }

            tot += Long.parseLong(sum);
        }

        System.out.println("result: " + tot);
    }
}
