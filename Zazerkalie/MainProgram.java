/**
 * Created by user on 6/2/2016.
 */
public class MainProgram {
    public static void main(String[] args) throws TooManyRecords{
        IntValue intvalue = new IntValue();



        try{
            for (int x=0; x< 10; x++){
              intvalue.setValue(x);
            }
        }catch(TooManyRecords e){
            System.out.println("Пойман");
        }
        finally{
            System.out.println("Сработало!");        }



    }
}
