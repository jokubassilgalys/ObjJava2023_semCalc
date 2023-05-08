package calcInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import calcException.*;

public abstract class BaseOperations implements BaseOpInterface {
    protected BigInteger arg1, arg2;
    protected BigDecimal answer;

    @Override
    public void addition(){
        answer = new BigDecimal(arg1.add(arg2));
    }
    @Override
    public void subtraction(){
        answer = new BigDecimal(arg1.subtract(arg2));
    }
    @Override
    public void multiplication(){
        answer = new BigDecimal(arg1.multiply(arg2));       
    }
    @Override
    public void division() throws CalcException{
        
        if(arg2.equals(BigInteger.ZERO)){
            throw new ExceptionDivideByZero();
        }
        else {
            answer = new BigDecimal(arg1.divide(arg2));
        }
    }
}