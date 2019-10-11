package ahp;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		
		Metodo m1 = new Metodo();
		
		ArrayList a1 = new ArrayList();
		
		a1.add("C1");
		a1.add("C2");
		a1.add("C3");
		
		m1.defineCriterios(a1);
		m1.geraVetorNormal();
		m1.printMatriz();
                
                
               
    }

}

