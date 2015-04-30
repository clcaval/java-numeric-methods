package methods;

import helpers.Criterios;

public class Jacobi {
	
	public Jacobi(){}
	
	public void executaJacobi(double[][] matrizA, int[] vetorB, double[] vetorX0, double[] vetorX1, 
							  int n, double erroEsperado, int maxIts)
	{
								
		int countIts = 0;
		double erroObtido = 1.0;
				
		if(Criterios.CriterioSassenfeld(matrizA, n))		
			System.out.println("Criterio de Sassenfeld foi satisfeito");

		while(erroObtido > erroEsperado && countIts < maxIts )
		{			
			for(int i = 0; i < n; i++)
			{
				double sum = 0.0;
				for(int j = 0; j < n; j++)
				{
					if(j != i)					
						sum += matrizA[i][j]*vetorX0[j];					
				}
				
				vetorX1[i] = (vetorB[i] - sum) / matrizA[i][i];			
				
			}
			erroObtido = Criterios.CalculaErro(vetorX0, vetorX1, n);
			vetorX0 = vetorX1.clone();
			countIts++;
		}
		
		System.out.println("após " + countIts + " iteracoes");
		
		Criterios.imprimeVetor(vetorX1, n);
			
	}
	
	
}
