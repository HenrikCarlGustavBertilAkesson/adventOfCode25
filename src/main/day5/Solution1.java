package main.day5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<Long[]> ranges = new ArrayList<>();
        ArrayList<Long> ids = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            Long from = Long.parseLong(line.trim().split("-")[0]);
            Long to = Long.parseLong(line.trim().split("-")[1]);
            ranges.add(new Long[]{from, to});
            line = br.readLine();
        }

        line = br.readLine();
        while (line != null && !line.isEmpty()) {
            ids.add(Long.parseLong(line.trim()));
            line = br.readLine();
        }

        int result = 0;
        for(Long id : ids) {
            for(Long[] range : ranges) {
                if(id >= range[0] && id <= range[1]) {
                    result++;
                    break;
                }
            }
        }

        System.out.println("Result: " + result);

    }
}
