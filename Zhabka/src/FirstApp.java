import java.util.Scanner;

public class FirstApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int ans = 1;
        int pts = 0;
        String w = "c";
        System.out.println("Игра началсь!\n Для выбора введите номер желаемого ответа\n Для выхода введите '0'\n\n Готовы?\n 1.Да\n 2.Нет\n");
        while(ans!=0) {
            ans = in.nextInt();
            if (ans != 1) {
                System.out.println("Ну и ладно\n");
                return;
            }
            System.out.println(" Отлично\n Ага,забыл напомнить за свои действия ты будешь получать или терять очки(pts)\n\n Перед тобой сундук\n 1.Попробую открыть\n 2.Зачем терять время\n");
            ans = in.nextInt();
            if (ans == 1) {
                System.out.println(" Хм код от сундука число от 0 до 10, попробуешь отгадать?\n 1.Да\n 2.Нет\n");
                ans = in.nextInt();
                if (ans != 1)
                    return;
                else {
                    System.out.println("\n Код:");
                    ans = in.nextInt();
                    if (ans != 6) {
                        System.out.println("\n Не повезло, ещё будешь?\n 1.Да\n 2.Нет\n");
                        ans = in.nextInt();
                        if(ans == 1){
                            System.out.println(" Код:");
                            ans = in.nextInt();
                            if(ans == 6) {
                                pts+=5;
                                System.out.println("Угадал!! +5pts А вот и первые pts\n  PTS-"+pts+"\n ");
                                ans=0;
                            }

                        }
                    }
                    if (ans == 6) {
                        pts += 5;
                        System.out.println("Угадал!! +5pts А вот и первые pts\n  PTS-" + pts + "\n ");
                    }
                }
            }
            System.out.println(" Тогда идем дальше\n");
            System.out.println("Лабиринт... Можешь потратить 3pts(1.) чтобы обойти его с другой стороны или пройти его сам(2.)\n ");
            ans = in.nextInt();
            if(ans == 1) {
                pts-=3;
                System.out.println("-3 pts PTS-" +pts +"/n ");
            }
            else {
                System.out.println("**********+********\n" +
                        "*          ********\n" +
                        "* *****************\n" +
                        "* ******          *\n" +
                        "* **     ******** *\n" +
                        "* ** ****       * *\n" +
                        "* ** **   ***** * *\n" +
                        "*    ** ***   *   *\n" +
                        "*******     * *****\n" +
                        "*************-*****\n" + "Доберись из - в + используя wasd для управления пройди путь сразу и целиком/n");
                w = in.next();

                if(w.equals("wwaasaaaawwddwddddddssddwwwwaaaaaaaaasaaaasssaaawwwwwwdddddddddw"))
                    System.out.println("Классно");




            }

        }

        System.out.println("Игра закончена\n");
    }

}
