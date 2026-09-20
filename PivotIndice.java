
public class PivotIndice {
    public static void afficherPivotsAvecIndices(int[] t){
    int compteur = 0;
    System.out.print("Pivots (index : valeur) => ");

    for(int i=1; i<t.length-1; i++){
        int p=1;
        for(int j=0;j<i;j++) if(t[j]>t[i]) p=0;
        for(int k=i+1;k<t.length;k++) if(t[k]<t[i]) p=0;
        if(p==1){
            System.out.print("("+i+" : "+t[i]+") ");
            compteur = compteur + 1;
        }
    }
    if(compteur==0){
        System.out.print("Aucun pivot");
    }
    System.out.println();
}
public static void main(String[] args){
        int[] t = {1, 2, 3, 7};
        afficherPivotsAvecIndices(t);
    }
}
