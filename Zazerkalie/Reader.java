import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 6/3/2016.
 */
//"C:\\Users\\user\\IdeaProjects\\untitled3\\src\\questions"
public class Reader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled3\\src\\questions"));
        String line;
        List <Vopros> list = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
           Vopros v = new Vopros();
            v.setQuestion(line);
            if ((line = reader.readLine()) != null ) {
                v.setAnswer(line);
                list.add(v);
            }
            else
            break;
        }
        /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getQuestion() + " " + list.get(i).qetAnswer() );
        }  */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vopros v1;
        int x;
        int n = 15;
        int k =0;
        Random rand = new Random();
        System.out.println("Кто ты? о0");
        String name =br.readLine();
        for(int i =0; i<=5; i++) {
            x = rand.nextInt(n);
            v1 = list.get(x);

            System.out.println(v1.getQestion());
            String h = br.readLine();
            if (h.equals(v1.qetAnswer())) {
                System.out.println("Ух ты!");
                k++;
            } else System.out.println("Ты можешь лучше!");
        }
        System.out.println("Правильных ответов у "+name+":  "+k+" шт.");

        System.out.println("Кто ты? о0");
        String name1 =br.readLine();
        int k1=0;
        for(int i =0; i<=5; i++) {
            x = rand.nextInt(n);
            v1 = list.get(x);

            System.out.println(v1.getQestion());
            String h = br.readLine();
            if (h.equals(v1.qetAnswer())) {
                System.out.println("Ух ты!");
                k1++;
            } else System.out.println("Ты можешь лучше!");
        }
        System.out.println("Правильных ответов у "+name1+":  "+k1+" шт.");
        if(k1>k){
            System.out.println("Победитель:"+name1+", который набрал: "+k1);
        } else if (k1==k){
            System.out.println("Реванш?");
        }
        else System.out.println("Победитель: "+name+", который набрал: "+k);


    }



}
