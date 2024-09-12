import java.util.HashSet;
import java.util.Random;

public class Main {

    // Создание хеш-таблицы из 1000 случайных чисел от 1 до 10000
    public static HashSet<Integer> inputSet(int n) {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < n) {
            set.add(random.nextInt(1, 10000)); // Генерация случайных чисел и добавление их в HashSet
        }
        return set;
    }

    // Поиск нужного числа
    public static void searchDigit(HashSet<Integer> set) {
        int max = -1;
        int tempI = 0;
        int tempJ = 0;

        // Перебираем все пары элементов
        for (Integer num1 : set) {
            for (Integer num2 : set) {
                int product = num1 * num2;
                // Проверяем, если произведение кратно 14 и присутствует в HashSet
                if (product % 14 == 0 && set.contains(product)) {
                    if (product > max) {
                        max = product;
                        tempI = num1;
                        tempJ = num2;
                    }
                }
            }
        }

        if (max == -1) {
            System.out.println(max);
        } else {
            System.out.println("Найдено число " + max + " с делителями " + tempI + " и " + tempJ);
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> set = inputSet(1000); // Заполняем только HashSet
        searchDigit(set);
    }
}
