
public class PermutationCirculaire {

    
    public static boolean estPermutationCirculaire(int[] t) {
        if (t == null || t.length == 0) return false;
        int n = t.length;

        
        boolean[] vu = new boolean[n + 1];
        for (int x : t) {
            if (x < 1 || x > n) return false;
            if (vu[x]) return false; 
            vu[x] = true;
        }

        
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                pos = i;
                break;
            }
        }

        
        for (int k = 0; k < n; k++) {
            int idx = (pos + k) % n; 
            int attendu = k + 1; 
            if (t[idx]!= attendu) {
                return false;
            }
        }
        return true;
    }

    
    public static boolean estPermutationCirculaireNaif(int[] t) {
        int n = t.length;
        
        boolean[] vu = new boolean[n+1];
        for(int x: t){
            if(x < 1 || x > n || vu[x]) return false;
            vu[x]=true;
        }
        
        for (int k = 0; k < n; k++) { 
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int rotation = ((k + i) % n) + 1; 
                if (t[i]!= rotation) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5}, 
            {4,5,1,2,3}, 
            {5,1,2,3,4}, 
            {3,1,2,4,5}, 
            {1,2,2,3,4},
            {0,1,2,3,4} 
        };
        for(int[] test : tests){
            System.out.println(java.util.Arrays.toString(test) + " -> " + estPermutationCirculaire(test));
        }
    }
}

