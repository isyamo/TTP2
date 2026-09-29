public class matriceS {
    

    public static int[][] construireSpirale(int n) {
        int[][] m = new int[n][n];

        int haut = 0;
        int bas = n - 1;
        int gauche = 0;
        int droite = n - 1;
        int num = 1;

        while (num <= n * n) {
           
            for (int j = gauche; j <= droite; j++) {
                m[haut][j] = num++;
            }
            haut++;

           
            for (int i = haut; i <= bas; i++) {
                m[i][droite] = num++;
            }
            droite--;

            
            for (int j = droite; j >= gauche; j--) {
                m[bas][j] = num++;
            }
            bas--;

            
            for (int i = bas; i >= haut; i--) {
                m[i][gauche] = num++;
            }
            gauche++;
        }
        return m;
    }

    public static void afficherMatrice(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
         int n = 2; 
        int n1=5;
        int[][] matrice = construireSpirale(n);
        int[][] matrice1 = construireSpirale(n1);
        System.out.println("Matrice spirale de taille " + n + " :" );
        afficherMatrice(matrice);
        System.out.println("Matrice spirale de taille " + n1 + " :");
        afficherMatrice(matrice1);
    }
}

