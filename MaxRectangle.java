public class MaxRectangle  {
   
    public static int maxRectangle(int[][] m) {
        int n = m.length;
        int p = m[0].length;
        int max = 0;

        for (int i1 = 0; i1 < n; i1++) { // ligne debut
            for (int j1 = 0; j1 < p; j1++) { // colonne debut
                for (int i2 = i1; i2 < n; i2++) { // ligne fin
                    for (int j2 = j1; j2 < p; j2++) { // colonne fin

                        // verifie si tout le rectangle est rempli de 1
                        boolean ok = true;
                        for (int i = i1; i <= i2; i++) {
                            for (int j = j1; j <= j2; j++) {
                                if (m[i][j] == 0) ok = false;
                            }
                        }
                        if (ok) {
                            int aire = (i2 - i1 + 1) * (j2 - j1 + 1);
                            if (aire > max) max = aire;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, 0, 1},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println(maxRectangle(m)); // 4
    }
}

