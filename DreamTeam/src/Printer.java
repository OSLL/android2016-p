class Printer implements Observer{

    @Override
    public void update(int value)
    {
        print(value);
    }
    void print(int value)
    {
        System.out.println("Current value is " + value);
    }
}