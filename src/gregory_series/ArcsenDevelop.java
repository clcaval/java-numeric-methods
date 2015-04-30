/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregory_series;

/**
 *
 * @author Caio
 */

public class ArcsenDevelop {

private int n;

	public ArcsenDevelop(){
        this.n = 0;
    }

    public ArcsenDevelop(int n, int sum, int z) {
        this.n = n;
    }

    public double calculateArcsen(){
        
    	double first = 0;
        double second = 0;
        double sum = 0;
        
        for(int i = 0; i <= n; i++){

            double a = fact(2*i);
            double b = Math.pow(2, 2*i);
            double c = fact(i);
            double d = Math.pow(c, 2);
            double e = 2*i + 1;

            first = (double)((a/b)*d)/e;
            sum += first;
        }

        return sum;
    }

    public int fact(int n){
        int sum1 = 1;
        for(int k = 1; k <= n; k++){
           sum1 *= k;
       }
        return sum1;
    }
    









}
