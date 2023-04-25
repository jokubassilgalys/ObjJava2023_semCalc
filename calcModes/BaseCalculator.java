package calcModes;
import calcInterface.*;
import java.math.BigInteger;
import java.math.BigDecimal;

public class BaseCalculator extends BaseOperations{

    public BaseCalculator() {
        this(BigInteger.ZERO, BigInteger.ZERO);
    }
    public BaseCalculator(BigInteger arg1) {
        this.arg1 = arg1;
    }
    public BaseCalculator(BigInteger arg1, BigInteger arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public final BigInteger getArg1(){ return arg1; }
    public final BigInteger getArg2(){ return arg2; }
    public final BigDecimal getAnswer(){ return answer; }
    
  
    public void setArg1(BigInteger arg1){ this.arg1 = arg1; }
    public void setArg2(BigInteger arg2){ this.arg2 = arg2; }

    @Override
    public String toString(){
        return "first argument: "+arg1+" second argument: "+arg2+" answer: "+answer;
    }
}
