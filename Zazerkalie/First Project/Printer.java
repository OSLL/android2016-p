public class Printer {
    void display(int x) {
        int[] mas;
        {
            mas = new int[10];
            for (int i = 0; i < 10; i++)
                mas[i] = x;
            System.out.println(x);
        }
    }
}