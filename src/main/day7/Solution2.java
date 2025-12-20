package main.day7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2 {

    static Long[][] splitters;

    public static Long startBeam(ArrayList<char[]> diagram, int row, int col) {
        
        if(row >= diagram.size() - 1) return 1L;
        if(row < 0 || row >= diagram.size() || col < 0 || col >= diagram.get(0).length) return 0L;

        char x = diagram.get(row)[col];

        if(x == '^' && splitters[row][col] > 0L) {
            return splitters[row][col]; // return num of timelines possible from splitter at (row, col)
        } else if(x == '^') {
            Long timelines = startBeam(diagram, row + 1, col + 1) + startBeam(diagram, row + 1, col - 1);
            splitters[row][col] = timelines;
            return timelines;
        }

        return startBeam(diagram, row + 1, col);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> diagram = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            diagram.add(line.trim().toCharArray());
            line = br.readLine();
        }

        splitters = new Long[diagram.size()][];
        for(int i = 0; i < diagram.size(); i++) {
            splitters[i] = new Long[diagram.get(0).length];
            for(int j = 0; j < diagram.get(0).length; j++) {
                splitters[i][j] = 0L;
            }
        }

        int col = 0;
        for(int i = 0; i < diagram.get(0).length; i++) {
            if(diagram.get(0)[i] == 'S') {
                col = i;
                break;
            }
        }

        Long totTimelines = startBeam(diagram, 0, col);

        System.out.println(totTimelines);
    }
}