package calcException;

public class ExceptionDivideByZero extends CalcException {

    public ExceptionDivideByZero(){
        super("Cannot divide by zero");
    }
    public ExceptionDivideByZero(String message){
        super(message);
    }
}
