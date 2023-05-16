package calcInterface;
import calcException.*;
import java.math.BigDecimal;
import java.math.MathContext;


public abstract class BaseOperations implements BaseOpInterface {
    protected BigDecimal arg1, arg2;
    protected BigDecimal answer;
    protected MathContext precision = new MathContext(14);

    @Override
    public void addition(){
        answer = arg1.add(arg2).round(precision);
    }
    @Override
    public void subtraction(){
        answer = arg1.subtract(arg2).round(precision);
    }
    @Override
    public void multiplication(){
        answer = arg1.multiply(arg2).round(precision);      
    }
    @Override
    public void division() throws ExceptionDivideByZero {
        
        if(arg2.equals(BigDecimal.ZERO)){
            throw new ExceptionDivideByZero();
        }
        else {
            answer = arg1.divide(arg2).round(precision);
        }
    }
}