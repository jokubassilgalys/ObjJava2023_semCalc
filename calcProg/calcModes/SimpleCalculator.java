package calcModes;
import calcException.*;
import java.math.BigDecimal;

public class SimpleCalculator extends BaseCalculator {

    public SimpleCalculator() {
        this(BigDecimal.ZERO, BigDecimal.ZERO);
    }
    public SimpleCalculator(BigDecimal arg1, BigDecimal arg2) {
        super(arg1, arg2);
    }

    public void power(){
        answer = arg1.pow(arg2.intValue()).round(precision);
    }

    public void mod() throws ExceptionDivideByZero {
        if(arg2.equals(BigDecimal.ZERO)){
            throw new ExceptionDivideByZero();
        }
        else {
            answer = arg1.remainder(arg2).round(precision);
        }
    }

    @Override
    public String toString(){
        return "first argument: "+arg1+" second argument: "+arg2+" answer: "+answer;
    }
}