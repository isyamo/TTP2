public class SommeDiaMa {
 
    
    public static int differenceDiagonales(int[][] m) {
        // Sécurité : vérifier si la matrice est vide ou nulle
        if (m == null || m.length == 0) {
            System.out.println("Erreur : La matrice est vide ou invalide.");
            return 0;
        }

        int n = m.length; 
        int sommePrincipale = 0;
        int sommeSecondaire = 0;

        
        for (int i = 0; i < n; i++) {
            sommePrincipale += m[i][i];         
            sommeSecondaire += m[i][n - 1 - i]; 
        }

        
        int diff = sommePrincipale - sommeSecondaire;
        int absDiff = Math.abs(diff);

    
        System.out.println("Somme diagonale principale : " + sommePrincipale);
        System.out.println("Somme diagonale secondaire : " + sommeSecondaire);
        System.out.println("Valeur absolue de la différence : " + absDiff);

        return absDiff;
    }
    public static void main(String[] args) {

        System.out.println("--- TEST 1 ---");
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        differenceDiagonales(m1);

        
        System.out.println("\n--- TEST 2 ---");
        int[][] m2 = {
            {1, 3, 5},
            {2, 4, 6},
            {7, 8, 9}
        };
        differenceDiagonales(m2);

      
        System.out.println("\n--- TEST 3 ---");
        int[][] m3 = {
            {5}
        };
        differenceDiagonales(m3);

        
        System.out.println("\n--- TEST 4 ---");
        int[][] m4 = {
            {-1,  2},
            { 3, -4}
        };
        differenceDiagonales(m4);
    }
}

