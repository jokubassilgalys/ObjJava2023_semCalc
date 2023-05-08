package calcModes;
import java.math.BigInteger;
import java.math.BigDecimal;
import calcException.*;

public class SimpleCalculator extends BaseCalculator {

    public SimpleCalculator() {
        this(BigInteger.ZERO, BigInteger.ZERO);
    }
    public SimpleCalculator(BigInteger arg1, BigInteger arg2) {
        super(arg1, arg2);
    }


    public void power(){
        answer = new BigDecimal(arg1.pow(arg2.intValue()));
    }

    public void percent() throws CalcException{
        if(arg2.equals(BigInteger.ZERO)){
            throw new ExceptionDivideByZero();
        }
        else {
            BigDecimal BDarg1 = new BigDecimal(arg1);
            BigDecimal BDarg2 = new BigDecimal(arg2);
            answer = BDarg1.multiply(BigDecimal.ONE.divide(BDarg2));
        }
    }

    public void mod() throws CalcException {
        if(arg2.equals(BigInteger.ZERO)){
            throw new ExceptionDivideByZero();
        }
        else if(arg2.compareTo(BigInteger.ZERO) == -1){
            throw new CalcException("Argument cannot be negative");
        }
        else {
            answer = new BigDecimal(arg1.mod(arg2));
        }
    }

    @Override
    public String toString(){
        return "first argument: "+arg1+" second argument: "+arg2+" answer: "+answer;
    }
}