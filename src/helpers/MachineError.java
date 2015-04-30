package helpers;

public class MachineError {

    private double t, s;

    MachineError(){
        this.t = 1.0;
        this.s = 0;
    }

    public double calculateMachineErrorDouble(){
        do{
            t *= 0.5;
            s += t;
        }while(!(s==1));
        return t;
    }
}
