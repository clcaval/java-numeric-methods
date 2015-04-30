import secant_method.SecanteMethod;
import newthons_method.NewtonsMethod;
import helpers.Criterios;
import methods.Gauss_Seidel;
import methods.Jacobi;
import gregory_series.*;

public class Main {
	
	private static final int n = 2000;
	private static final int maxIts = 100000;
	private static final double erroEsperado = 0.000001;
	
    public static void main(String[] args) {

    	GregorySerie g = new GregorySerie(10000);
        
    	double t = System.currentTimeMillis();
        double gregory = g.calculateGregorySerie();
        double s = System.currentTimeMillis();
        double ts = (s-t)/1000;
        System.out.println("tempo em seg: " + ts);

        System.out.println("ABS erro: " + Math.abs(Math.PI - gregory));
         
         

        //MacLaurin ml = new MacLaurin();
        //System.out.println(ml.calculateMacLaurin(0.2, 0.00418410041841));
        

        DaseFormula d = new DaseFormula();
        System.out.println(d.calculateDaseFormula(4,0.5,0.2,0.125));
  

         ArcsenDevelop a = new ArcsenDevelop(4,0,1);
         System.out.println(a.calculateArcsen());
         
    		/*
       NewtonsMethod f = new NewtonsMethod();
             
       System.out.println("--------------------METODO DE NEWTON:------------------");
       System.out.println("--------------------PRIMEIRO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 0");
       f.newtons(0.0, 1);
       System.out.println("********************PARA x0 = 0.25");
       f.newtons(0.25, 1);
       System.out.println("********************PARA x0 = 0.5");
       f.newtons(0.5, 1);
       System.out.println("********************PARA x0 = 0.75");
       f.newtons(0.75, 1);
       System.out.println("********************PARA x0 = 1");
       f.newtons(1, 1);

       System.out.println("--------------------SEGUNDO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 3");
       f.newtons(3.0, 2);
       System.out.println("********************PARA x0 = 3.25");
       f.newtons(3.25, 2);
       System.out.println("********************PARA x0 = 3.5");
       f.newtons(3.5, 2);
       System.out.println("********************PARA x0 = 3.75");
       f.newtons(3.75, 2);
       System.out.println("********************PARA x0 = 4");
       f.newtons(4, 2);

       System.out.println("--------------------TERCEIRO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 3");
       f.newtons(3.0, 3);
       System.out.println("********************PARA x0 = 3.5");
       f.newtons(3.5, 3);
       System.out.println("********************PARA x0 = 4");
       f.newtons(4, 3);
       System.out.println("********************PARA x0 = 4.5");
       f.newtons(4.5, 3);
       System.out.println("********************PARA x0 = 5");
       f.newtons(5, 3);

       
       
       //*********************************************************************************
              
        /*
       SecanteMethod s = new SecanteMethod();
       System.out.println("--------------------METODO DA SECANTE:------------------");
       System.out.println("--------------------PRIMEIRO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 0");
       s.secante(0.0, 1);
       System.out.println("********************PARA x0 = 0.25");
       s.secante(0.25, 1);
       System.out.println("********************PARA x0 = 0.5");
       s.secante(0.5, 1);
       System.out.println("********************PARA x0 = 0.75");
       s.secante(0.75, 1);
       System.out.println("********************PARA x0 = 1");
       s.secante(1, 1);

       System.out.println("--------------------SEGUNDO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 3");
       s.secante(3.0, 2);
       System.out.println("********************PARA x0 = 3.25");
       s.secante(3.25, 2);
       System.out.println("********************PARA x0 = 3.5");
       s.secante(3.5, 2);
       System.out.println("********************PARA x0 = 3.75");
       s.secante(3.75, 2);
       System.out.println("********************PARA x0 = 4");
       s.secante(4, 2);

       System.out.println("--------------------TERCEIRO EXERCICIO:----------------");
       System.out.println("********************PARA x0 = 3");
       s.secante(3.0, 3);
       System.out.println("********************PARA x0 = 3.5");
       s.secante(3.5, 3);
       System.out.println("********************PARA x0 = 4");
       s.secante(4, 3);
       System.out.println("********************PARA x0 = 4.5");
       s.secante(4.5, 3);
       System.out.println("********************PARA x0 = 5");
       s.secante(5, 3);
	   	   
	   	   
	   	   */
	   /* Jacobi Gauss */
	   /*
	   	double[][] matrizA = new double[n][n];
		int[] vetorB = new int[n];
		
		double[][] matrizBTridiagonal = Criterios.MontaMatrizTridiagonal(n);
				
		//Criterios.imprimeMatriz(matrizBTridiagonal, n);
		
		double[] vetorX0 = new double[n];		
		double[] vetorX1 = new double[n];	
				
		double[][] L = new double[n][n];
		double[][] U = new double[n][n];
		
		for(int i = 0; i < n; i++)
		{
			vetorB[i] = 1;
			vetorX0[i] = 0.0;
		}
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == j)
					matrizA[i][j] = 1.;
				else
					matrizA[i][j] = 1./n;
				
				L[i][j] = 0.0;
				U[i][j] = 0.0;
			}
		}
		
	
		//		double[][] a = {{5, 1, -1, 0}, {-1, 6, -1, 1}, {-1, 1, 7, 0}, {0, 1, -1, 8}};
		//		int[] b = {5, -5, -9, 8};
		//		
		//		double[][] a = {{-3, 3, -6}, {-4, 7, -8}, {5, 7, -9}};
		//		int[] b = {-6, -5, 3}; 
		
		System.out.println("Comeco do metodo de Jacobi:");
		double t1 = System.currentTimeMillis();
		Jacobi jac = new Jacobi();
		jac.executaJacobi(matrizA, vetorB, vetorX0, vetorX1, n, erroEsperado, maxIts);
		double t2 = System.currentTimeMillis();
		double tempoTotal = (t2 - t1)/1000;		
		System.out.println("O tempo em segundos foi: " + tempoTotal);
		System.out.println("///////////////////////////////////////////////////////");
			
		System.out.println("Comeco do metodo de Gauss-Seidel:");
		t1 = System.currentTimeMillis();
		Gauss_Seidel gs = new Gauss_Seidel();
		gs.executaGaussSeidel(matrizA, vetorB, vetorX0, vetorX1, n, erroEsperado, maxIts);
		t2 = System.currentTimeMillis();
		tempoTotal = (t2 - t1)/1000;
		System.out.println("O tempo em segundos foi: " + tempoTotal);		
		System.out.println("///////////////////////////////////////////////////////");

		System.out.println("Comeco da solucaoo do sistema por LU:");
		t1 = System.currentTimeMillis();
		Criterios.FatoracaoLUPivoteamento(matrizA, L, U, vetorB, n);
		t2 = System.currentTimeMillis();
		tempoTotal = (t2 - t1) / 1000;
		System.out.println("O tempo em segundos foi: " + tempoTotal);		
		System.out.println("///////////////////////////////////////////////////////");
		*/
       
    }

}
