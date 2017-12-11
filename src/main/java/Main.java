import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Candy> gift = new ArrayList<Candy>();

    public static void main(String[] args) throws IOException {
        addCandyToGift();
        double summMass = 0;
        double summPrice = 0;
        for (Candy el : gift) {
            summMass += el.getMass();
            summPrice += el.getPrice();
        }
        System.out.println("Общая сумма подарка: " + summPrice + "\nОбщая масса подарка: " + summMass);
        for (Candy el : gift) {
            System.out.println(el.toString());

        }


    }

    private static void addCandyToGift() {
        boolean isEnd = true;
        while (isEnd) {
            int id;
            String name;
            double price;
            double mass;
            int candyTipe;
            BufferedReader a;
            //BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
            //String a2 = a.readLine();
            try {
                System.out.println("Выберите слодость (1-мармелад, 2-щербее, 3-козинак, 4-халва):");
                //candyTipe = scanner.nextInt();
                candyTipe = Integer.parseInt(scanner.nextLine());
                System.out.println("Укажите название сладости:");
                // name = scanner.nextLine();
                a = new BufferedReader(new InputStreamReader(System.in));
                name = a.readLine();
                System.out.println("Укажите цену:");
                // price = scanner.nextDouble();
                price = Double.parseDouble(scanner.nextLine());
                System.out.println("Укажите массы сладости:");
                //  mass = scanner.nextDouble();
                mass = Double.parseDouble(scanner.nextLine());
                System.out.println("Укажите уникальный номер сладости:");
                id = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Не верно введен параметр.Сладость не добавлена. Начните сначала.");
                continue;
            }

            switch (candyTipe) {
                case 1:
                    gift.add(new Marmalade(price, mass, name, id));
                    break;
                case 2:
                    gift.add(new Sherbet(price, mass, name, id));
                    break;
                case 3:
                    gift.add(new Kozinak(price, mass, name, id));
                    break;
                case 4:
                    gift.add(new Halva(price, mass, name, id));
                    break;
                default:
                    System.out.println("Не верно веден тип сладости");
                    continue;
            }
            /*System.out.println("Добавить еще сладость?(Да/Нет)");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("да"))
                break;
*/
            System.out.println("Добавить еще сладость?(1 - Да/ 2 - Нет)");
            int answer = scanner.nextInt();
            if (answer != 1)
                break;
        }
    }
}
