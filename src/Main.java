import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }

        //1)Сначала все числа умножить на 2,
        //2)Отсортировать те числа, которые меньше 50,
        //3)Отнять 10 поделить на 4
        //4)Если число больше 10, то его нужно отсортировать
        //5)Посчитать сумму этих чисел

        System.out.println(list);


        List<Integer> firstStep = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            value *= 2;
            firstStep.add(value);
        }

        System.out.println(firstStep);


        List<Integer> secondStep = new ArrayList<>();

        for (int i = 0; i < firstStep.size(); i++) {
            if (firstStep.get(i) >= 50) {
                secondStep.add(firstStep.get(i));
            }
        }

        System.out.println(secondStep);


        List<Integer> thirdStep = new ArrayList<>();

        for (int i = 0; i < secondStep.size(); i++) {
            int value = secondStep.get(i);
            value -= 10;
            value /= 4;
            thirdStep.add(value);
        }

        System.out.println(thirdStep);

    System.out.println("------------------");
    System.out.println("------------------");
    System.out.println("------------------");

    List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
        int value = list.get(i);
        value *= 2;
        if (value >= 50) {
            value -= 10;
            value /= 4;
            answer.add(value);
        }
    }

        System.out.println(answer);

        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("------------------");

        List<Integer> result = list.stream()
                .map((x) -> x * 2)
                .filter((x) -> x >= 50)
                .map((x) -> (x -10) / 4)
                .toList();

        System.out.println(result);

        //конвеерные
        //метод map- изменить все элементы стрима
        //filter()- фильтрует элементы, оставляет только те, которые совпадают с условием
        //sorted()- сортирует стрим
        //distinct()- удаляет все повторяющиеся элементы
        //limit() - оставляет только первые пять элементов
        //skip() - пропускает элементы
        //peek() - предоставляет доступ кк каждому элементу -сделать что-то с каждым элементов при этом не изменяя его (для логов)

        //терминальные
        //forEach()- произвести любые действия с элементами и завершить стрим
        //toList()- превращает лист в стрим
        //count()- возвращает число элементов

        List<String> answerList = list.stream()
        .map(x -> x.toString())
        .map(x -> x + "querty")
        .toList();

        System.out.println(answerList);


//       list.stream().forEach(x-> System.out.println(x));

        System.out.println("*************************");

        List<Integer> result2 = list.stream()
                .filter(x ->  x % 2 == 0)
                .sorted()
                .distinct()
                .skip(5)
                .limit(5)
                .peek(x -> x = x + 1)
                .toList();

        //quickSort

        System.out.println(result2);

        long x = list.stream()
                .filter(y -> y > 20)
                .count();

        System.out.println(x);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);

//        List<Integer> aaa = set.stream()
//                .map(x -> x /10)
//                .distinct()
//                .toList();
//        System.out.println(aaa);

        int size = list.size();

        Optional<Integer> sum = list.stream()
                .reduce((a, b) -> a + b);
        if (sum.isPresent()){

            int sumInt = sum.get();
            System.out.println(sumInt/size);

        }

        Optional<Integer> optional = list.stream()
                .reduce((a, b) -> a + b);
        int resultInt = optional.get();
        System.out.println(result);

        Optional<Integer> optionalInteger = list.stream().findFirst();
        if (optionalInteger.isPresent()) {
            System.out.println(optionalInteger.get());

        }

        Optional<Integer> any = list.stream().findAny();
        if (any.isPresent()) {
            System.out.println(any.get());

        }

        Optional<Integer> min = list.stream().min(Comparator.naturalOrder());
        if (min.isPresent()) {
            System.out.println(min.get());

        };

        boolean anyMatch = list.stream().anyMatch(integer -> integer > 5);
        System.out.println(anyMatch);

        boolean fullMatch = list.stream().allMatch(integer -> integer > 5);
        System.out.println(fullMatch);

//        Set<Integer> collectSet = List.stream()
//                .collect(Collectors.toSet());


    }

}