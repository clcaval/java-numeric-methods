/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregory_series;
/**
 *
 * @author Caio
 */
public class MacLaurin {

    public double calculateMacLaurin(double a, double p, double b, double q){
        return a*Math.atan(p) + b*Math.atan(q);
    }

}
