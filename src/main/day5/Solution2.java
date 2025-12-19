package main.day5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<Long[]> ranges = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            Long from = Long.parseLong(line.trim().split("-")[0]);
            Long to = Long.parseLong(line.trim().split("-")[1]);
            ranges.add(new Long[]{from, to});
            line = br.readLine();
        }

        ranges.sort(Comparator.comparingLong((Long[] range) -> range[0]));

        Long result = 0L;
        Long max = -1L;
        for(Long[] range : ranges) {
            if(range[0] > max) {
                result += Math.abs(range[0] - range[1]) + 1;
                max = range[1];
            }
            else if(range[1] > max) {
                result += Math.abs(range[0] - range[1]) + 1 - Math.abs(range[0] - max) - 1;
                max = range[1];
            }
        }

        System.out.println("Result: " + result);

    }
}
