
import java.util.Arrays;
public class nbreAbs {
    
    public static void afficherElementsManquants(int[] t) {
        int n = t.length;
        
        boolean[] vu = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int valeur = t[i];
            
            
            if (valeur >= 1 && valeur <= n) {
                vu[valeur] = true;
            }
        }

        
        boolean aucunManquant = true;
        
        System.out.print("Éléments manquants : ");
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) { 
                System.out.print(k + " ");
                aucunManquant = false;
            }
        }

    
        if (aucunManquant) {
            System.out.print("Aucun élément manquant");
        }
        
        System.out.println(); // Saut de ligne
    }


    public static void afficherElementsManquantsEnPlace(int[] t) {
        int n = t.length;

        
        for (int i = 0; i < n; i++) {
            int val = Math.abs(t[i]);
            
            
            if (val >= 1 && val <= n) {
                int index = val - 1;
                if (t[index] > 0) {
                    t[index] = -t[index]; 
                }
            }
        }


        boolean aucunManquant = true;
        System.out.print("Éléments manquants (En place) : ");
        for (int i = 0; i < n; i++) {
            if (t[i] > 0) {
                System.out.print((i + 1) + " ");
                aucunManquant = false;
            }
        }

        if (aucunManquant) {
            System.out.print("Aucun élément manquant");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        // Test 1 
        testerTableau(new int[]{1, 3, 3, 5, 1}); 

        // Test 2 
        testerTableau(new int[]{1, 2, 3, 4});    

        // Test 3 
        testerTableau(new int[]{1, 1, 1, 1});    

        // Test 4 
        testerTableau(new int[]{4, 2, 2, 1, 5}); 

        // Test 5 
        testerTableau(new int[]{1});            

        // Test 6 :
        testerTableau(new int[]{1, 2, 3, 6});   
    }

   
    private static void testerTableau(int[] t) {
        System.out.println("\nEntrée : " + Arrays.toString(t) + " (n = " + t.length + ")");
        
    
        afficherElementsManquants(t.clone());
        
     
        afficherElementsManquantsEnPlace(t.clone());
    }
}

