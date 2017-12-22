import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Candy> gift = new ArrayList<Candy>();

    public static List<Candy> getGift() {
        return gift;
    }

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
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
                System.out.println("Введен не корректный номер меню");
                mainMenu();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addCandyToGift() {
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
                if (price < 0) {
                    System.out.println("Введена отрицательная цена сладости");
                    break;
                }
                System.out.println("Укажите массы сладости:");
                mass = Double.parseDouble(br.readLine());
                if (mass <= 0) {
                    System.out.println("Введена отрицательная или нулевая масса сладости");
                    break;
                }
                System.out.println("Укажите уникальный номер сладости:");
                id = Integer.parseInt(br.readLine());
                if (id < 0) {
                    System.out.println("Введена отрицательный уникальный номер сладости");
                    break;
                }
                switch (candyTipe) {
                    case 1:
                        addCFG(gift, new Marmalade(price, mass, name, id));
                        break;
                    case 2:
                        addCFG(gift, new Sherbet(price, mass, name, id));
                        break;
                    case 3:
                        addCFG(gift, new Kozinak(price, mass, name, id));
                        break;
                    case 4:
                        addCFG(gift, new Halva(price, mass, name, id));
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

    public static void addCFG(List<Candy> gift, Candy candiAdd) {
        gift.add(candiAdd);
        //return gift;
    }

    public static void delCandyFromGift(List<Candy> delCandy) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите уникальный номер удаляемой сладости :");
                delCFG(delCandy, Integer.parseInt(br.readLine()));
                System.out.println("Удалить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Введен не корректный уникальный номер сладости");
            }


        }
    }

    public static void delCFG(List<Candy> list, int numToRemove) {
        int idCandy = numToRemove;
        int tempID = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idCandy) tempID = i;
        }
        if (tempID!=-1)list.remove(tempID);
        //return list;
    }

    public static void printGift(List<Candy> printList) {
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
