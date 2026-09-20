public class PivotS {

    /**
     * Affiche tous les pivots du tableau t,
     * selon la définition donnée dans l'énoncé.
     */
    public static void afficherPivots(int[] t) {
        int n = t.length;
        int compteurPivots = 0;

    
        String message = "Pivots :";

       
        for (int i = 1; i < n - 1; i++) {
            int element = t[i];
            boolean estPivot = true;

            
            for (int j = 0; j < i; j++) {
                if (t[j] >= element) {
                    estPivot = false; // Ce n'est pas un pivot
                }
            }

           
            for (int k = i + 1; k < n; k++) {
                if (t[k] <= element) {
                    estPivot = false; // Ce n'est pas un pivot
                }
            }

            
            if (estPivot) {
                message = message + " " + element;
                compteurPivots = compteurPivots + 1;
            }
        }

        // --- Affichage du résultat ---
        if (compteurPivots > 0) {
            System.out.println(message);
        } else {
            System.out.println("Aucun pivot");
        }
    }

    public static void main(String[] args) {
       // Test 1 : 
        int[] t1 = {2, 4, 3, 5, 6};
        System.out.print("Test t1 : ");
        afficherPivots(t1); 

        // Test 2 : 
        int[] t2 = {1, 2, 3, 4, 5};
        System.out.print("Test t2 : ");
        afficherPivots(t2); 

        // Test 3 : 
        int[] t3 = {5, 4, 3, 2, 1};
        System.out.print("Test t3 : ");
        afficherPivots(t3); 

        // Test 4 : Éléments tous égaux
        int[] t4 = {3, 3, 3, 3};
        System.out.print("Test t4 : ");
        afficherPivots(t4); 

        // Test 5 : 
        int[] t5 = {7, 1, 5, 2, 6, 3, 4};
        System.out.print("Test t5 : ");
        afficherPivots(t5); 
    }
}