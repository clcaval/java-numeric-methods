/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregory_series;

/**
 *
 * @author Caio
 */
public class DaseFormula {


    public double calculateDaseFormula(int a, double b, double c, double d){
        return a*(Math.atan(b) + Math.atan(c) + Math.atan(d));
    }
}
