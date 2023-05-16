package calcMain;
import calcModes.BaseCalculator;

public class CopyFactory {
    BaseCalculator cloneBaseCalculator(BaseCalculator calc){
       BaseCalculator calcCopy = (BaseCalculator)calc.clone();
       return calcCopy;
    }
}

    // BaseCalculator calc1, calc2;
    // calc1 = new BaseCalculator(new BigInteger("456"), new BigInteger("306"));
    // CopyFactory factory = new CopyFactory();
    // calc2 = factory.cloneBaseCalculator(calc1); 

    // System.out.println("calc1: " + calc1.toString());
    // System.out.println("calc2: " + calc2.toString());

    // calc2.setArg1(new BigInteger("3"));

    // System.out.println("calc1: " + calc1.toString());
    // System.out.println("calc2: " + calc2.toString());


    // CloneTest test1 = new CloneTest(456, 300);
    // CloneTest test2;
    // test2 = (CloneTest)test1.clone();
    // System.out.println("test1: " + test1.objectField.arg1 +" "+ test1.objectField.arg2);
    // System.out.println("test2: " + test2.objectField.arg1 +" "+ test2.objectField.arg2);

    // test2.objectField.arg1 = 100;

    // System.out.println("test1: " + test1.objectField.arg1 +" "+ test1.objectField.arg2);
    // System.out.println("test2: " + test2.objectField.arg1 +" "+ test2.objectField.arg2);
