package secant_method;

import helpers.Functions;

public class SecanteMethod {

    private final int MAXITS = 1000;
    private final double E = 0.0001;
    private static Functions f = new Functions();

    public double whichExercise(double xv, double xa, int exerc){
        switch(exerc){
            case 1:
                return (xv*f.f1(xa) - xa*f.f1(xv))/(f.f1(xa) - f.f1(xv));
            case 2:
                return (xv*f.f2(xa) - xa*f.f2(xv))/(f.f2(xa) - f.f2(xv));
            case 3:
                return (xv*f.f3(xa) - xa*f.f3(xv))/(f.f3(xa) - f.f3(xv));
            default:
                return 0.0;
            }
    }

    public void secante(double x, int exerc){

        double xv = 0;
        double xa = x;
        double xx = 0;
        double erro = 0.0;
        int i = 0;

        while(true){

            xx = whichExercise(xv, xa, exerc);

            xv = xa;
            xa = xx;

            erro = Math.abs(xa-xv) / Math.abs(xa);

            if(i > MAXITS || erro < E )
                break;            

            i++;

            System.out.println("Iteracao: " + i + "; xx = " + xx + "; Erro = " + erro);

        }
    }


}
