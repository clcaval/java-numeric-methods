/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregory_series;

/**
 *
 * @author Caio
 */

public class GregorySerie {

    private int n;
    private double sum;

    public GregorySerie(){
        this(0, 0.0, 0.0);
    }

    public GregorySerie(int n){
        this(n, 0.0, 0.0);
    }

    public GregorySerie(int n, double x){
        this(n, x, 0.0);
    }

    public GregorySerie(int n, double x, double sum){
        this.n = n;
        this.sum = sum;
    }

    public double calculateGregorySerie(){
        for(int i = 0; i <= n; i++){
            sum += (Math.pow(-1, i))/(2*i+1) ;
        }
        return 4*sum;
    }

    public double calculateGregorySerieMath(){
        for(int i = 1; i <= n; i++){
        }
        
        return 0.0;
    }
}
