import java.util.ArrayList;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {
    	IntegerValue integervalue = new IntegerValue();
        Printer printer = new Printer(integervalue);
        
        try {
        	integervalue.setValues(6);
			integervalue.setValues(6);
			integervalue.setValues(45);
			integervalue.setValues(85);
		} catch (TooManyRecords e) {
			e.display("Вышли за границу массива");
		}
        
    }	          
}





