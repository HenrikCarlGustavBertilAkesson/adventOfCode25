package main.day7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution1 {

    static HashSet<Splitter> splitters = new HashSet<>();

    public static void startBeam(ArrayList<char[]> diagram, int row, int col) {
        
        if(row < 0 || row >= diagram.size() || col < 0 || col >= diagram.get(0).length) return;

        char x = diagram.get(row)[col];

        if(x == '^') {
            if(splitters.contains(new Splitter(row, col))) return;
            splitters.add(new Splitter(row, col));

            startBeam(diagram, row + 1, col - 1);
            startBeam(diagram, row + 1, col + 1);

            return;
        } 

        startBeam(diagram, row + 1, col);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> diagram = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            diagram.add(line.trim().toCharArray());
            line = br.readLine();
        }

        int col = 0;
        for(int i = 0; i < diagram.get(0).length; i++) {
            if(diagram.get(0)[i] == 'S') {
                col = i;
                break;
            }
        }

        startBeam(diagram, 0, col);

        int totalSplits = splitters.size();

        System.out.println(totalSplits);
    }
}