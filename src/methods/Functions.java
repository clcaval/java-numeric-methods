package methods;

public class Functions {

    public double f1(double x){
        return 1 - 4*x*Math.cos(x) + 2*x*x + Math.cos(2*x);
    }

    public double f2(double x){
        return Math.sin(3*x) + 3*Math.exp(-2*x)*Math.sin(2*x) - 3*Math.exp(-x)*Math.sin(2*x) - Math.exp(-3*x);
    }

    public double f3(double x){
        return Math.exp(3*x) - 27*Math.pow(x, 6) + 27*Math.pow(x, 4)*Math.exp(x) - 9*Math.pow(x, 2)*Math.exp(2*x);
    }

    public double f1Deriv(double x){
        return - 4*Math.cos(x) + x*Math.sin(x) + 4*x - 2*Math.sin(2*x);
    }

    public double f2Deriv(double x){
        return 3*(Math.cos(3*x) - 2*x*Math.exp(-2*x)*Math.sin(x) + Math.exp(-2*x)*Math.cos(x) + x*Math.exp(-x)*Math.sin(2*x) - 2*Math.exp(-x)*Math.cos(2*x) + x*Math.exp(-3*x));
    }

    public double f3Deriv(double x){
        return 3*(x*Math.exp(3*x) - 54*Math.pow(x, 5) + 9*(Math.pow(x, 5)*Math.exp(x) + 4*Math.pow(x, 3)*Math.exp(x)) - 3*(2*Math.pow(x, 3)*Math.exp(2*x) + 2*x*Math.exp(2*x)));
    }
    
}
