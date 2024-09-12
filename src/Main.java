import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int arraySize = 1000; //Размер последовательности
        final int maxValue = 10000; //Максимальное значение

        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < arraySize) {
            set.add(random.nextInt(1, maxValue)); // Генерация случайных чисел и добавление их в HashSet
        }
        searchMaxProduct(set);
    }
    // Поиск нужного числа
    public static void searchMaxProduct(HashSet<Integer> set) {
        int max = -1; // для хранения максимального произведения
        int max14 = -1; // максимальное число, кратное 14
        int max2 = -1;  // максимальное число, кратное 2
        int max7 = -1;  // максимальное число, кратное 7

        // Перебираем все элементы множества
        for (Integer num : set) {
            if (num % 14 == 0) {
                // Число кратно 14
                if (num > max14) max14 = num;
            } else if (num % 2 == 0) {
                // Число кратно только 2
                if (num > max2) max2 = num;
            } else if (num % 7 == 0) {
                // Число кратно только 7
                if (num > max7) max7 = num;
            }
        }

        // Если есть числа, кратные 14, они могут быть наибольшим произведением
        if (max14 != -1) {
            max = max14;
        }

        // Если есть числа, кратные 2 и 7, их произведение тоже будет кратно 14
        if (max2 != -1 && max7 != -1) {
            int product = max2 * max7;
            if (product > max) max = product;
        }

        // Выводим результат
        if (max == -1) {
            System.out.println(max);
        } else {
            System.out.println("Найдено максимальное число, кратное 14: " + max);
        }
    }
}
