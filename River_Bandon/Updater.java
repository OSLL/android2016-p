
interface Updater {
    void display(int val);
    void update(int val) throws TooManyRecords;
}
