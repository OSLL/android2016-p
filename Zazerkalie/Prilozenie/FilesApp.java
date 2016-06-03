import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class FilesApp{
    public FilesApp() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try (FileReader reader = new FileReader("C:\\Users\\user\\IdeaProjects\\Vopros\\src\\vopr")) {
            int c;
            int index = -1;
            String s;
            while ((c = reader.read()) != -1) {
                s = String.valueOf((char) c);
                if (s.equals("#")) {
                    list.add(s);
                    index++;
                }
                list.set(index, list.get(index) + s);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        ArrayList<String> list2 = new ArrayList<>();
        try (FileReader reader = new FileReader("C:\\Users\\user\\IdeaProjects\\Vopros\\src\\otveti")) {
            int c;
            String s;
            while ((c = reader.read()) != -1) {
                s = String.valueOf((char) c);
                list2.add(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int n;
        int o =0;
        for (int i = 0; i < list.size(); i++) {
            int x = 0;
            n = list.size();
            Random rand = new Random();
            x = rand.nextInt(n);
            if (list.get(x).equals("0")){
                i--;
            }
            else{
                System.out.println(list.get(x));
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String name = bf.readLine();
                if (name.equals(list2.get(x))) {
                    System.out.println("Верно");
                    o++;
                } else {
                    System.out.println("Неверно");
                }
                list2.set(x,"0");
                list.set(x,"0");
                n = list.size();
            }

        }
        System.out.println("Правильных ответов: "+o);
    }
}