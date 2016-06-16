interface Observer {
    void update (int value) throws TooManyRecords;
}