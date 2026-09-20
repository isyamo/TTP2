public class PivotPS {

    public static void afficherPivots(int[] t) {
        int n = t.length;

        // Pas de pivot si moins de 3 éléments (on ignore bords)
        if (n < 3) {
            System.out.println("Aucun pivot");
            return;
        }

        // 1. Tableau prefixMax : max de 0 à i
        int[] prefixMax = new int[n];
        prefixMax[0] = t[0];
        for (int i = 1; i < n; i++) {
            if (t[i] > prefixMax[i-1]) {
                prefixMax[i] = t[i];
            } else {
                prefixMax[i] = prefixMax[i-1];
            }
        }

        // 2. Tableau suffixMin : min de i à fin
        int[] suffixMin = new int[n];
        suffixMin[n-1] = t[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (t[i] < suffixMin[i+1]) {
                suffixMin[i] = t[i];
            } else {
                suffixMin[i] = suffixMin[i+1];
            }
        }

        // 3. On cherche les pivots au milieu (1 à n-2)
        boolean trouve = false;
        System.out.print("Pivots : ");

        for (int i = 1; i < n-1; i++) {
            // tous à gauche <= t[i] ET tous à droite >= t[i]
            if (prefixMax[i-1] <= t[i] && suffixMin[i+1] >= t[i]) {
                System.out.print(t[i] + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun pivot");
        } else {
            System.out.println(); // retour à la ligne
        }
    }

    public static void main(String[] args) {
        int[] t1 = {2, 4, 3, 5, 6};
        int[] t2 = {1, 2, 3, 4, 5};
        int[] t3 = {5, 4, 3, 2, 1};
        int[] t4 = {3, 3, 3, 3};
        int[] t5 = {7, 1, 5, 2, 6, 3, 4};

        afficherPivots(t1); // Pivots : 5
        afficherPivots(t2); // Pivots : 2 3 4
        afficherPivots(t3); // Aucun pivot
        afficherPivots(t4); // Pivots : 3 3
        afficherPivots(t5); // Aucun pivot
    }
}