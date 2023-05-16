package calcModes;
import calcInterface.*;
import java.lang.Math;
import java.math.BigDecimal;

public class ScientificCalculator extends BaseCalculator implements ScientificInterface {

    public ScientificCalculator() {
        this(BigDecimal.ZERO);
    }
    public ScientificCalculator(BigDecimal arg1){
        super(arg1);
    }

    @Override
    public void log(){
        answer = new BigDecimal(Math.log10(arg1.doubleValue())).round(precision);
    }
    @Override
    public void ln(){
        answer = new BigDecimal(Math.log(arg1.doubleValue())).round(precision);  
    }
    @Override
    public void sin(){
        answer = new BigDecimal(Math.sin(Math.toRadians(arg1.doubleValue()))).round(precision);
    }
    @Override
    public void cos(){
        answer = new BigDecimal(Math.cos(Math.toRadians(arg1.doubleValue()))).round(precision);
    }
    @Override
    public void tan(){
        answer = new BigDecimal(Math.tan(Math.toRadians(arg1.doubleValue()))).round(precision);
    }

    @Override
    public String toString(){
        return "argument: "+arg1+" answer: "+answer;
    }
}
