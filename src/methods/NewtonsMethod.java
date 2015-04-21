package methods;

public class NewtonsMethod {

    private final int MAXITS = 1000;
    private final double E = 0.0001;
    private static Functions f = new Functions();

    public double whichExercise(double x, double xv, int exerc){
        switch(exerc){
            case 1:
                return xv - (f.f1(xv)/f.f1Deriv(xv));
            case 2:
                return xv - (f.f2(xv)/f.f2Deriv(xv));
            case 3:
                return xv - (f.f3(xv)/f.f3Deriv(xv));
            default:
                return 0.0;
            }
    }

    public void newtons(double x, int exerc){

        int i = 0;
        double erro = 1.0;

        double xv = x;
        double xa = whichExercise(x, xv, exerc);

        while((i < MAXITS) && erro >= E){

            xv = xa;
            xa = whichExercise(x, xv, exerc);
            erro = Math.abs(xa-xv) / Math.abs(xa);
            i++;

            System.out.println("Iteracao: " + i + "; xa = " + xa + "; Erro = " + erro);
        }
    }


}
