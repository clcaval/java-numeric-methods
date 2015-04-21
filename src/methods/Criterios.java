package methods;

public class Criterios {
	
	public static boolean CriterioSassenfeld(double[][] A, int n)
	{
				
		double[] beta = new double[n];
		
		for(int i = 0; i < n; i++)
			beta[i] = 0;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i != j)				
					beta[i] += Math.abs(A[i][j]);
			}
			beta[i] = beta[i] / A[i][i];
		}
		
		double maxBeta = 9999999999.9;
		
		for(int i = 0; i < n; i++)
		{
			if (beta[i] < maxBeta)			
				maxBeta = beta[i];			
		}
		
		if(maxBeta < 1)
			return true;
		else
			return false;
	}
		
	public static double CalculaErro(double[] vetorX0, double[] vetorX1, int n)
	{
		double erro = 0.0;
		for(int i = 0; i < n; i++)		
			erro += (Math.abs(vetorX1[i] - vetorX0[i])) /  Math.abs(vetorX1[i]);
						
		return erro;
	}
	
	public static void FatoracaoLUPivoteamento(double[][] matrizA, double[][] L, double[][] U, 
													int[] vetorB, int n)
	{
	
		for(int m = 0; m < n - 1; m++)
		{
			for(int j = m; j < n; j++)
			{
				
				double sum = 0.0;
				
				for(int k = 0; k < m; k++)				
					sum += L[m][k] * U[k][j];
								
				U[m][j] = matrizA[m][j] - sum;
			}
			
			for(int i = m+1; i < n; i++)
			{
				double sum = 0.0;
				for(int k = 0; k < m; k++)
					sum += L[i][k] * U[k][m];
				
				L[i][m] = (matrizA[i][m] - sum) / U[m][m];				
			}
			L[m][m] = 1.;				
			
		}
		
		double sum = 0.;
		for(int k = 0; k < n; k++)		
			sum += L[n-1][k] * U[k][n-1];
		
//		System.out.println(sum);
//		System.out.println(matrizA[n-1][n-1]);
		
		U[n-1][n-1] = matrizA[n-1][n-1] - sum;
		L[n-1][n-1] = 1.;
		
//		System.out.println("Matriz L");
//		imprimeMatriz(L, n);
//		
//		System.out.println("Matriz U:");
//		imprimeMatriz(U, n);
//			
//		System.out.println("Matriz L * U:");	
//		multiplicaLU(L, U, n);
		
		// Resolve Ly = b
		
		double[] Y = new double[n];
		
		Y[0] = (double)vetorB[0]/L[0][0];
		
		for(int k = 1; k < n; k++)
		{
			sum = 0.;
			for(int j = 0; j < k; j++)			
				sum += L[k][j] * Y[j];
						
			Y[k] = (vetorB[k] - sum) / L[k][k];
		}
		
		//System.out.println("Vetor Y:");
		//imprimeVetor(Y, n);
		
		// Resolve Ux = y
		
		double[] X = new double[n];
		
		X[n-1] = (double)(Y[n-1] / U[n-1][n-1]);
		for(int k = n - 2; k >= 0; k--)
		{
			sum = 0.;
			for(int j = k + 1; j < n; j++)
				sum += U[k][j] * X[j];
			
			X[k] = (Y[k] - sum) / U[k][k];					
		}
		
		System.out.println("Vetor X:");
		imprimeVetor(X, n);

//		System.out.println("Determinante U: ");		
//		System.out.println(calculaDet(U, n));
		
	}
			
	public static void multiplicaLU(double[][] L, double[][] U, int n)
	{
		double[][] A = new double[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				double sum = 0.;
				for(int k = 0; k < n; k++)
				{
					sum += L[i][k] * U[k][j];
				}
				A[i][j] = sum;
			}			
		}		
		
		imprimeMatriz(A, n);
		
	}
	
	public static double calculaDet(double[][] U, int n)
	{
		double det = U[0][0];
		
		for(int i = 1; i < n; i++)
			det *= U[i][i];
								
		return det;
	}

	public static double[][] MontaMatrizTridiagonal(int n)
	{
		double[][] matrizA = new double[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == j)
					matrizA[i][j] = 1.;
				else if(Math.abs(i-j) == 1)
					matrizA[i][j] = (double)1./n;
				else
					matrizA[i][j] = 0.;				
			}
		}
				
		return matrizA;
		
	}
	
	public static void imprimeMatriz(double[][] mat, int n)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void imprimeVetor(double[] vet, int n)
	{
		for(int i = 0; i < n; i ++)
			System.out.println(vet[i] + " ");
	}

}
		