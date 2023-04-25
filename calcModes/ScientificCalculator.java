package calcModes;
import calcInterface.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.lang.Math;

public class ScientificCalculator extends BaseCalculator implements ScientificInterface {

    public ScientificCalculator() {
        this(BigInteger.ZERO);
    }
    public ScientificCalculator(BigInteger arg1){
        super(arg1);
    }

    @Override
    public void log(){
        answer = new BigDecimal(Math.log10(arg1.doubleValue()));
    }
    @Override
    public void lg(){
        answer = new BigDecimal(Math.log(arg1.doubleValue()));        
    }
    @Override
    public void sin(){
        answer = new BigDecimal(Math.sin(Math.toRadians(arg1.doubleValue())));
    }
    @Override
    public void cos(){
        answer = new BigDecimal(Math.cos(Math.toRadians(arg1.doubleValue())));
    }
    @Override
    public void tan(){
        answer = new BigDecimal(Math.tan(Math.toRadians(arg1.doubleValue())));
    }

    @Override
    public String toString(){
        return "argument: "+arg1+" answer: "+answer;
    }
}
