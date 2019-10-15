/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahp;

/**
 *
 * @author 17111168
 */
public class Analise {
    
    public static double defineCI(double m[][],double v[], int n){
        double vet[] = {0,0,0};
        double aux = 0;
        double CI = 0;
        
        for(int i=0;i < n; i++){
            for (int j=0; j < n; j++) {
                vet[i] = Double.parseDouble(String.format("%.4f",vet[i] + (v[j] * m[i][j])).replaceAll(",", "."));
                System.out.println("VET = "+vet[i]);
            }
        }
        
        for (int i=0; i < n; i++) {
            aux = aux + (vet[i] / v[i])/ n;
        }
        
        CI = Double.parseDouble(String.format("%.4f",(aux - n) / (n - 1)).replaceAll(",", "."));
        
        return CI;
        
    }
    
    public static void deficeCR(double n, int tam){
        switch(tam){
            case 1:
                System.out.printf("\nCR = %.2f%%",n*100);
                break;
            case 2:
                System.out.printf("\nCR = %.2f%%",n*100);
                break;
            case 3:
                System.out.printf("\nCR = %.2f %%",(n/0.58)*100);
                break;
            case 4:
                System.out.printf("\nCR = %.2f%%",(n/0.9)*100);
                break;
            case 5:
                System.out.printf("\nCR = %.2f%%",(n/1.12)*100);
                break;    
            case 6:
                System.out.printf("\nCR = %.2f%%",(n/1.24)*100);
                break;
            case 7:
                System.out.printf("\nCR = %.2f%%",(n/1.32)*100);
                break;
            case 8:
                System.out.printf("\nCR = %.2f%%",(n/1.41)*100);
                break;    
        }
        System.out.println("\n");
    }
    
}
