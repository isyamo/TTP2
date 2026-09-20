public class LIS {

    public static int longueurLIS(int[] t) {
        
        if (t.length == 0) {
            return 0;
        }

        int n = t.length;
        int[] dp = new int[n];


        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { 
                if (t[j] < t[i]) {  
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {},
            {5},
            {5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5},
            {2, 1, 4, 2, 3, 5, 1, 7},
            {3, 3, 3, 3},
            {10, 9, 2, 5, 3, 7, 101, 18}
        };

        for (int[] t : tests) {
            System.out.println( java.util.Arrays.toString(t) + " -> LIS = " + longueurLIS(t));
        }

        int[] t = {3, 1, 4, 5,2};
        int n = t.length;

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n];
        int[] prev = new int[n];

        // 1. depart
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        // 2. calcul
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] < t[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        // 3. trouver le meilleur
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[k]) {
                k = i;
            }
        }

        System.out.println("Longueur LIS = " + dp[k]);

        // 4. reconstruire
        // on stocke a l'envers dans un tableau temporaire
        int[] temp = new int[n];
        int taille = 0;
        int cur = k;
        while (cur!= -1) {
            temp[taille] = t[cur];
            taille++;
            cur = prev[cur];
        }

        System.out.print("Une LIS possible : ");
        for (int i = taille - 1; i >= 0; i--) {
            System.out.print(temp[i] + " ");
        }
    }
}