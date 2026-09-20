public class MatriceMagique {

    public static boolean estCarreMagique(int[][] m) {
        
        int ref = m[0][0] + m[0][1] + m[0][2];

        
        for (int i = 1; i < 3; i++) {
            int sommeLigne = m[i][0] + m[i][1] + m[i][2];
            if (sommeLigne != ref) {
                return false; 
            }
        }

        
        for (int j = 0; j < 3; j++) {
            int sommeColonne = m[0][j] + m[1][j] + m[2][j];
            if (sommeColonne != ref) {
                return false; 
            }
        }

        
        int diagPrincipale = m[0][0] + m[1][1] + m[2][2];
        if (diagPrincipale != ref) {
            return false;
        }

        
        int diagSecondaire = m[0][2] + m[1][1] + m[2][0];
        if (diagSecondaire != ref) {
            return false;
        }

        
        return true;
    }

    public static void main(String[] args) {

        
        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        testerMatrice("Test 1 (Magique classique)", m1);

        
        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };
        testerMatrice("Test 2 (Non magique)", m2);

        
        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        testerMatrice("Test 3 (Valeurs identiques)", m3);

        
        int[][] m4 = {
            { 0,  5, -2},
            {-3,  1,  5},
            { 4, -3,  2}
        };
        testerMatrice("Test 4 (Valeurs négatives - Magique)", m4);
    }

    
    private static void testerMatrice(String nomTest, int[][] m) {
        System.out.println( nomTest );
        boolean resultat = estCarreMagique(m);

        if (resultat) {
            System.out.println("Résultat : Carré magique !\n");
        } else {
            System.out.println("Résultat : Pas un carré magique.\n");
        }
    }
}
    

