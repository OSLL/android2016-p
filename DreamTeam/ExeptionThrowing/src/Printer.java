class Printer implements Observer{

    void checkSize() throws ToManyRecords{
        if(count.size() == maxCount) {
            throw new ToManyRecords("ToManyRecords(" + count.size() + "/" + maxCount + ")");
        }
    }

    void addValue(int value) throws ToManyRecords
    {
        try {
            checkSize();
            count.add(value);
        } catch (ToManyRecords toManyRecords) {
            toManyRecords.printStackTrace();
            throw toManyRecords;
        }
        //return  true;
    }


    @Override
    public void update(int value) throws ToManyRecords
    {
        try {
            addValue(value);

            print(value);
        }
        catch (ToManyRecords e)
        {
            throw e;
        }
    }

    void print(int value)
    {
        System.out.println("Current value is " + value);
    }
    int getSize()
    {
        return count.size();
    }
}