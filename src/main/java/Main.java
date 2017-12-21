import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Main {
    private static List<Candy> gift = new ArrayList<Candy>();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        int menyTipe;
        boolean cicle = true;
        while (cicle) {
            try {
                System.out.println("Выберете пункт меню(1 - Добавление/Формирование сладости в подарки, " +
                        "2 - Вывод списка сладостей в подарке, 3 - Удаление сладости из подарка)");
                menyTipe = Integer.parseInt(brr.readLine());
                switch (menyTipe) {
                    case 1:
                        addCandyToGift();
                        break;
                    case 2:
                        if (gift.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            printGift(gift);
                        }
                        break;
                    case 3:
                        if (gift.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            delCandyFromGift(gift);
                        }
                        break;
                    default:
                        System.out.println("Введен не верный пунк меню");
                        continue;
                }
                System.out.println("Выбрать другой пункт меню? (Да/Нет)");
                String answer = brr.readLine();
                if (!answer.equalsIgnoreCase("да")) {
                    cicle = false;
                }
            } catch (NumberFormatException e) {
                mainMenu();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Не верно введен параметр.Сладость не добавлена. Начните сначала.");
                addCandyToGift();
            }
        }
    }


    private static void delCandyFromGift(List<Candy> delCandy) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите уникальный номер удаляемой сладости :");
                int idCandy = Integer.parseInt(br.readLine());
                int tempID = -1;
                for (int i = 0; i < delCandy.size(); i++) {
                    if (delCandy.get(i).getId() == idCandy) tempID = i;
                }
                delCandy.remove(tempID);
                System.out.println("Удалить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Введен не корректный уникальный номер сладости");
            }


        }
    }

    private static void printGift(List<Candy> printList) {
        double summMass = 0;
        double summPrice = 0;
        for (Candy el : printList) {
            summMass += el.getMass();
            summPrice += el.getPrice();
        }
        System.out.println("Общая сумма подарка: " + summPrice + "\nОбщая масса подарка: " + summMass);
        for (Candy el : printList) System.out.println(el.toString());
    }
}
