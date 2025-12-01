package main.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> linesList = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            linesList.add(line);
        }

        char[] dir = new char[linesList.size()];
        int[] steps = new int[linesList.size()];
        for (int i = 0; i < linesList.size(); i++) {
            dir[i] = linesList.get(i).charAt(0);
            steps[i] = Integer.parseInt(linesList.get(i).substring(1));
        }

        int start = 50;
        int mod = 100;
        int res = 0;

        for(int i = 0; i < dir.length; i++) {
            int end, numZeros;
            if(dir[i] == 'R') {
                end = start + steps[i];
                // numZeros = end == 0 ? 1 : end / mod; 
                end = end % mod;
            } else {
                end = start - steps[i];
                // numZeros = end == 0 ? 1 : (start + steps[i]) / mod;
                // System.out.println("L " + numZeros + " start + steps % mod " + (start + steps[i]));
                end = (end + mod) % mod;
            }
            numZeros = end == 0 ? 1 : 0;
            start = end;
            res += numZeros;
        }
            
        if(res <= 6368) System.out.println("too low " + res);
        else System.out.println(res);
    }
}
