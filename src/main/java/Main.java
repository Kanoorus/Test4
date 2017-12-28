import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String defaultPath = "C:/Present/";
        String defaultName = String.valueOf(new Random().nextInt(1000))+".present";
        Present myPresent = new Present();
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        int menyTipe;
        boolean cicle = true;
        while (cicle) {
            try {
                System.out.println("Выберете пункт меню:\n1 - Добавление/Формирование сладости в подарки, " +
                        "2 - Вывод списка сладостей в подарке, 3 - Удаление сладости из подарка), 4 - Записать в файл, 5 - Загрузить из файла");
                menyTipe = Integer.parseInt(brr.readLine());
                switch (menyTipe) {
                    case 1:
                        addCandyToGift(myPresent);
                        break;
                    case 2:
                        if (myPresent.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            myPresent.print();
                        }
                        break;
                    case 3:
                        if (myPresent.isEmpty()) {
                            System.out.println("Список сладостей пуст");
                        } else {
                            delCandyFromGift(myPresent);
                        }
                        break;
                    case 4:
                        myPresent.writeToFile(defaultPath+defaultName);
                        System.out.println("Данные сохранены в файл "+ defaultName);
                        break;
                    case 5:
                        System.out.println("Введите имя файла .present находящегося в каталоге С:/Present/");
                        myPresent.readFromFile(defaultPath+brr.readLine()+".present");
                        myPresent.print();
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

    private static void addCandyToGift(Present myPresent) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int candyType;
            String name;
            double price;
            double mass;
            try {
                System.out.println("Выберите слодость (1-мармелад, 2-щербее, 3-козинак, 4-халва):");
                candyType = Integer.parseInt(br.readLine());
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
                switch (candyType) {
                    case 1:
                        myPresent.addCandyToMy(new Marmalade(price, mass, name));
                        break;
                    case 2:
                        myPresent.addCandyToMy(new Sherbet(price, mass, name));
                        break;
                    case 3:
                        myPresent.addCandyToMy(new Kozinak(price, mass, name));
                        break;
                    case 4:
                        myPresent.addCandyToMy(new Halva(price, mass, name));
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
                addCandyToGift(myPresent);
            }
        }
    }

    private static void delCandyFromGift(Present myPresent) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите уникальный номер удаляемой сладости :");
                myPresent.dellCandyInMy(Integer.parseInt(br.readLine()));
                System.out.println("Удалить еще сладость?(Да/Нет)");
                if (!br.readLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Введен не корректный уникальный номер сладости");
            }
        }
    }
}
