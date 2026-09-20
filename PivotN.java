public class PivotN {


    public static void afficherPivots(int[] t) {
        int n = t.length;
        
        boolean auMoinsUnPivot = false;

        System.out.print("Pivots :");

    
        // pour i de 1 à n-2 :
        for (int i = 1; i <= n - 2; i++) {
            // pivot = true
            boolean pivot = true;

            // pour j de 0 à i-1 :
            for (int j = 0; j <= i - 1; j++) {
                // si t[j] > t[i] alors pivot = false
                if (t[j] > t[i]) {
                    pivot = false;
                }
            }

            // pour k de i+1 à n-1 :
            for (int k = i + 1; k <= n - 1; k++) {
                // si t[k] < t[i] alors pivot = false
                if (t[k] < t[i]) {
                    pivot = false;
                }
            }

            
            if (pivot == true) {
                System.out.print(" " + t[i]);
                auMoinsUnPivot = true; // ON a trouvé un
            }
        }
        
        
        System.out.println();

        
        if (auMoinsUnPivot == false) {
            System.out.println("Aucun pivot");
        }
    }

    public static void main(String[] args) {
        
        int[] t = {2, 4, 3, 5, 6};
        afficherPivots(t);
    } 
}