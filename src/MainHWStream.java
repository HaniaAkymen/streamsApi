import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainHWStream {

    public static void main(String[] args) {
/*В отдельном проекте:
Создать ArrayList. заполните его числами от 0 до 100
Создайте стрим, который будет делать следующие вещи:
1) Делит все числа на 2
2) Оставляет только те, которые больше, чем 25
3) Вычитает 30 из каждого числа
4) Сортирует
5) Выбирает только первых 5 элементов
6) подсчитывает сумму оставшихся элементов
Вывести результат на экран
*/

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100 ; i++) {
            list.add(i);
        }

        List<Integer> result = list.stream()
                .map(x -> x / 2)
                .filter((x) -> x > 25)
                .map(x -> (x - 30))
                .sorted()
                .limit(5)
                .toList();

        System.out.println("Результат:" + result);

        int sumListLimit = result.stream()
                .mapToInt(x -> x)
                .sum();

        System.out.println("Cумма оставшихся элементов " + sumListLimit);

        }
    }

