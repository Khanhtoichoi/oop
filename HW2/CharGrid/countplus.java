package OOP.HW2.CharGrid;

public class countplus {
    private static boolean CheckPattern(char[][] table, int x, int y) {
        if (x < 0 || y < 0 || x >= table.length+1 || y >= table[0].length+1) {
            return false;
        }

        char center = table[x][y];

        int right = 0;
        for (int i = y + 1; i < table[0].length; i++) {
            if (table[x][i] == center) {
                right++;
            } else {
                break;
            }
        }

        int left = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (table[x][i] == center) {
                left++;
            } else {
                break;
            }
        }


        int down = 0;
        for (int i = x + 1; i < table.length; i++) {
            if (table[i][y] == center) {
                down++;
            } else {
                break;
            }
        }

        int up = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (table[i][y] == center) {
                up++;
            } else {
                break;
            }
        }

        return left >= 2 && right >= 2 && up >= 2 && down >= 2 && left == right && up == down && left == up;
    }

    public static int countPlus(char[][] table) {
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (CheckPattern(table, i, j)) {
                    count++;

                }
            }
        }
        return count;
    }
    
}
