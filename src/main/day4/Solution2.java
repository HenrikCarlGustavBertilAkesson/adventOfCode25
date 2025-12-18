package main.day4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2 {

    public static ArrayList<int[]> loadRollCoords(ArrayList<char[]> grid) {
        ArrayList<int[]> coords = new ArrayList<>();
        for(int row = 0; row < grid.size(); row++) {
            for(int col = 0; col < grid.get(0).length; col++) {
                if(grid.get(row)[col] == '@') coords.add(new int[]{row, col});
            }
        }

        return coords;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> grid = new ArrayList<>();
        
        while (line != null && !line.isEmpty()) {
            grid.add(line.trim().toCharArray());
            line = br.readLine();
        }
        
        ArrayList<int[]> coords = loadRollCoords(grid);

        boolean rollsMoved = true;
        int tot = 0;
        while(rollsMoved) {
            rollsMoved = false;
            ArrayList<int[]> copy = new ArrayList<>(coords) ;
            for(int[] pos : copy) {
                if(Solution1.surroundingRolls(grid, pos[0], pos[1]) < 4) {
                    coords.remove(pos);
                    grid.get(pos[0])[pos[1]] = '.';
                    tot++;
                    rollsMoved = true;
                }
            }
        }

        System.out.println("Result: " + tot);
    }
}
