package main.day4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution1 {

    public static boolean checkSurrounding(ArrayList<char[]> grid, int row, int col, int x, int y) {
        if(x == 0 && y == 0) return false;
        if(
            row + y < grid.size() && row + y > -1 &&
            col + x < grid.get(col).length && col + x > -1 
        ) {
            return grid.get(row + y)[col + x] == '@';
        }
        return false;
    }

    public static int surroundingRolls(ArrayList<char[]> grid, int row, int col) {
        int counter = 0;
        for(int y = -1; y < 2; y++) {
            for(int x = -1; x < 2; x++) {
                if(checkSurrounding(grid, row, col, x, y)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int movedRolls(ArrayList<char[]> grid) {
        int rolls = 0;
        for(int row = 0; row < grid.size(); row++) {
            for(int col = 0; col < grid.get(0).length; col++) {
                if(grid.get(row)[col] == '@' && surroundingRolls(grid, row, col) < 4) {
                    rolls++;
                }
            }
        }

        return rolls;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<char[]> grid = new ArrayList<>();

        while (line != null && !line.isEmpty()) {
            grid.add(line.trim().toCharArray());
            line = br.readLine();
        }

        int rolls = movedRolls(grid);

        System.out.println("Result: " + rolls);
    }
}
