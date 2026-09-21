class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                perimeter += getPerimeterForCell(grid, x, y);
            }
        }

        return perimeter;
    }

    private int getPerimeterForCell(int[][] grid, int x, int y) {
        int perimeter = 0;

        // if water
        if (grid[y][x] == 0) {
            return perimeter;
        }

        // check left
        if (outOfBounds(grid, x - 1, y) || grid[y][x - 1] == 0) {
            perimeter++;
        }

        // check up
        if (outOfBounds(grid, x, y - 1) || grid[y - 1][x] == 0) {
            perimeter++;
        }        

        // check right
        if (outOfBounds(grid, x + 1, y) || grid[y][x + 1] == 0) {
            perimeter++;
        }

        // check down
        if (outOfBounds(grid, x, y + 1) || grid[y + 1][x] == 0) {
            perimeter++;
        }  

        return perimeter;           
    }

    private boolean outOfBounds(int[][] grid, int x, int y) {
        boolean xBad = (x < 0) || (x >= grid[0].length);
        boolean yBad = (y < 0) || (y >= grid.length);
        return xBad || yBad;
    }
}