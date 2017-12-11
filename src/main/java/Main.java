import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int id;
            int candyTipe;
            String name;
            double price;
            double mass;
            try {
                System.out.println("Выберите слодость (1-мармелад, 2-щербее, 3-козинак, 4-халва):");
                candyTipe = Integer.parseInt(br.readLine());
                System.out.println("Укажите название сладости:");
                name = br.readLine();
                System.out.println("Укажите цену:");
                price = Double.parseDouble(br.readLine());
                System.out.println("Укажите массы сладости:");
                mass = Double.parseDouble(br.readLine());
                System.out.println("Укажите уникальный номер сладости:");
                id = Integer.parseInt(br.readLine());
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
                System.out.println("Добавить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да"))
                    br.close();
                    break;
            } catch (Exception e) {
                System.out.println("Не верно введен параметр.Сладость не добавлена. Начните сначала.");
                continue;
            }
        }
    }
}
