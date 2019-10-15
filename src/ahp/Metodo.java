package ahp;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Metodo {
	
    int grauImportancia[];
    double mat [][];
    double matPrimaria [][];
    double vetNormal [] = {0,0,0};
    int tam;

    public Metodo() {
        grauImportancia = new int[9];
        for(int i=0; i<9; i++) {
            grauImportancia[i] = i+1;
        }
        
        
    }

    public void defineCriterios(ArrayList crit) {

        mat = new double[crit.size()][crit.size()];
        matPrimaria = new double[crit.size()][crit.size()];
        tam = crit.size();
        
        Scanner sc = new Scanner(System.in);
        double Num;

        for(int i=0; i<crit.size(); i++) {
            for(int j=i; j<crit.size();j++) {
                if(i != j) {
                    System.out.print("Qual a importancia de "+crit.get(i)+" em relacao a "+crit.get(j)+": ");
                    Num = sc.nextDouble();
                    if(Num > 0){
                        mat[i][j] = Double.parseDouble(String.format("%.4f",Num).replaceAll(",", "."));
                        mat[j][i] = Double.parseDouble(String.format("%.4f",(1/Num)).replaceAll(",", "."));
                        matPrimaria[i][j] = mat[i][j];
                        matPrimaria[j][i] = mat[j][i];
                        
                    }else{
                        mat[i][j] = Double.parseDouble(String.format("%.4f",Math.abs(1/Num)).replaceAll(",", "."));
                        mat[j][i] = Double.parseDouble(String.format("%.4f",Math.abs(Num)).replaceAll(",", "."));
                        matPrimaria[i][j] = mat[i][j];
                        matPrimaria[j][i] = mat[j][i];
                    
                    }

                }else{
                    mat[i][j] = 1;
                    matPrimaria[i][j] = 1;
                } 
            }
        }
    }

    public void printMatriz(){
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam;j++) {
                System.out.printf(" | %.2f",mat[i][j]);
            }
            System.out.print(" |\n");
        }
        
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam;j++) {
                System.out.printf(" | %.2f",matPrimaria[i][j]);
            }
            System.out.print(" |\n");
        }
        
        for(int i=0; i<tam; i++){
            System.out.println("\nVetor normalizado: "+vetNormal[i]);
        }
        
        System.out.println("\nCI = "+Analise.defineCI(matPrimaria, vetNormal, tam));
        
        Analise.deficeCR(Analise.defineCI(matPrimaria, vetNormal, tam), tam);
    }    
        
    public void geraVetorNormal(){
        double multMat [][] = new double[tam][tam];
        double aux = 0;
        
        double linhasSum [] = new double[tam];
        double totalVetor = 0;
        
        double vetN [] = new double[tam];
        
        for(int n=0; n<5;n++){
                  
            for(int l=0;l<tam;l++){
                for(int c=0;c<tam;c++){
                    for(int i=0;i<tam;i++){
                        aux = aux + (mat[l][i] * mat[i][c]);    // Multiplição da Matriz
                    }
                    multMat[l][c] = aux;
                    aux = 0;
                }
            }
            
            for(int i=0; i<tam; i++) {
                for(int j=0; j<tam;j++) {
                    System.out.printf(" | %.2f",multMat[i][j]); // Print da Matriz multiplicada
                }
                System.out.print(" |\n");
            }
            System.out.println("\n");
            
            for(int l=0;l<tam;l++){
                for(int c=0;c<tam;c++){
                    aux = aux + multMat[l][c];  
                }
                linhasSum[l] = aux;                             // Soma das linhas da Matriz multplicada
                aux = 0;
                totalVetor = totalVetor + linhasSum[l];         // Total da soma de todo vetor
            
            }
            
            for(int l=0; l<tam;l++){
                vetN[l] = linhasSum[l] / totalVetor;            // Normalizacao das linhas da Matriz
                if(vetN[l] != vetNormal[l]){
                    vetNormal[l] = Double.parseDouble(String.format("%.4f",vetN[l]).replaceAll(",", "."));
                }
            }
            
            for(int l=0; l<tam;l++){
                for(int c=0; c<tam;c++){
                    mat[l][c] = multMat[l][c];                  // Transfere a Matriz multiplicada para multiplica-la na próxima iteração
                }
            }
            
            
            
        }
       
    }
}
