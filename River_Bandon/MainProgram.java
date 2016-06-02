public class MainProgram {
    public static void main(String[] args) {
        IntValue intvalue = new IntValue();
        for (int i = 0; i < 1000; ++i) {
            try {
                intvalue.setValue(i);
            }
            catch (TooManyRecords err) {
                err.print();
            }
            finally {
                System.out.println("Thank you for your value");
            }
        }
    }
}
