import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (true) {
            System.out.println("Выберите задание (1-7) или 0 для выхода:");
            System.out.println("1. Задание 1.1");
            System.out.println("2. Задание 1.2");
            System.out.println("3. Задание 2.2");
            System.out.println("4. Задание 3.1");
            System.out.println("5. Задание 3.2");
            System.out.println("6. Задание 3.3");
            System.out.println("7. Задание 3.4");
            System.out.println("0. Выход");


            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Неверный ввод, пожалуйста, введите целое число");
                    scanner.next();
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали Задание 1.1");
                    Box<Integer> integerBox = new Box<>();
                    boolean taskRunning = true;
                    while (taskRunning) {
                        System.out.println("Выберите действие с Коробкой:");
                        System.out.println("1. Положить число в коробку");
                        System.out.println("2. Извлечь число из коробки");
                        System.out.println("3. Проверить, пуста ли коробка");
                        System.out.println("4. Вернуться в меню заданий");
                        System.out.print("Ваш выбор (1-4): ");

                        int actionChoice;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                actionChoice = scanner.nextInt();
                                break;
                            } else {
                                System.out.println("Неверный ввод, пожалуйста, введите целое число от 1 до 4.");
                                scanner.next();
                            }
                        }

                        switch (actionChoice) {
                            case 1:
                                System.out.print("Введите число для помещения в коробку: ");
                                int numberToPut = scanner.nextInt();
                                try {
                                    integerBox.put(numberToPut);
                                    System.out.println("Число " + numberToPut + " помещено в коробку.");
                                } catch (IllegalStateException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 2:
                                extractAndPrintValue(integerBox);
                                break;

                            case 3:
                                System.out.println("Коробка пуста? " + integerBox.isEmpty());
                                break;

                            case 4:
                                taskRunning = false; // Возврат в меню заданий
                                break;

                            default:
                                System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 4.");
                                break;
                        }
                        System.out.println(); // Пустая строка для разделения выводов
                    }

                    break;

                case 2:
                    System.out.println("Вы выбрали Задание 1.2");

                    // Задание 1: Хранилище чисел с null
                    Storage<Integer> nullNumberStorage = new Storage<>(null);
                    Storage.printValue(nullNumberStorage, 0); // Извлеченное значение: 0

                    // Задание 2: Хранилище чисел со значением 99
                    Storage<Integer> numberStorage = new Storage<>(99);
                    Storage.printValue(numberStorage, -1); // Извлеченное значение: 99

                    // Задание 3: Хранилище строк с null
                    Storage<String> nullStringStorage = new Storage<>(null);
                    Storage.printValue(nullStringStorage, "default"); // Извлеченное значение: default

                    // Задание 4: Хранилище строк со значением "hello"
                    Storage<String> stringStorage = new Storage<>("hello");
                    Storage.printValue(stringStorage, "hello world"); // Извлеченное значение: hello


                    break;

                case 3:
                    System.out.println("Вы выбрали Задание 2.2");
                    // Пример 1: Помещение одной точки в коробку
                    Box<Point3D> box1 = new Box<>();
                    Point3D point1 = new Point3D(1.0, 2.0, 3.0);

                    System.out.println("Пример 1: Помещение точки в коробку");
                    box1.putPoint3D(point1);
                    System.out.println("Содержимое коробки: " + box1.get());
                    System.out.println("Коробка пуста? " + box1.isEmpty());

                    // Пример 2: Попытка поместить вторую точку в уже занятую коробку
                    try {
                        Point3D point2 = new Point3D(4.0, 5.0, 6.0);
                        System.out.println("\nПример 2: Попытка поместить вторую точку в занятую коробку");
                        box1.putPoint3D(point1);
                        box1.putPoint3D(point2); // Это вызовет исключение
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    // Пример 3: Создание новой коробки и помещение нескольких точек
                    Box<Point3D> box2 = new Box<>();

                    Point3D point3 = new Point3D(7.0, 8.0, 9.0);
                    Point3D point4 = new Point3D(10.0, 11.0, 12.0);

                    System.out.println("\nПример 3: Помещение и извлечения нескольких точек в коробку");
                    box2.putPoint3D(point3);
                    System.out.println("Содержимое коробки: " + box2.get());

                    box2.putPoint3D(point4);
                    System.out.println("Содержимое коробки: " + box2.get());

                    // Проверка пустоты коробки после извлечения всех точек
                    System.out.println("Коробка пуста? " + box2.isEmpty());

                    // Пример 4: Проверка состояния пустой коробки
                    try {
                        System.out.println("\nПример 4: Попытка извлечь точку из пустой коробки");
                        Box<Point3D> emptyBox = new Box<>();
                        emptyBox.get(); // Это вызовет исключение
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("Вы выбрали Задание 3.1");
                    // Пример 1: Получение списка длин строк
                    List<String> strings = List.of("qwerty", "asdfg", "zx");
                    List<Integer> lengths = FunctionUtils.map(strings, String::length);
                    System.out.println("Длины строк: " + lengths); // Вывод: Длины строк: [6, 5, 2]

                    // Пример 2: Преобразование отрицательных чисел в положительные
                    List<Integer> numbers = List.of(1, -3, 7);
                    List<Integer> absoluteValues = FunctionUtils.map(numbers, value -> Math.abs(value));
                    System.out.println("Начальный список: " + numbers+"\n"); // Вывод: Абсолютные значения: [1, 3, 7]
                    System.out.println("Абсолютные значения: " + absoluteValues+"\n"); // Вывод: Абсолютные значения: [1, 3, 7]

                    // Пример 3: Получение максимальных значений из массивов целых чисел
                    List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{5, 4, 3});
                    System.out.println("Список массивов: {1, 2, 3}, {-1, -2, -3}, {5, 4, 3}"); // Вывод: Абсолютные значения: [1, 3, 7]

                    List<Integer> maxValues = FunctionUtils.map(arrays, array -> {
                        int max = Integer.MIN_VALUE; // Начальное значение для поиска максимума
                        for (int num : array) {
                            if (num > max) {
                                max = num; // Обновляем максимум
                            }
                        }
                        return max; // Возвращаем максимальное значение
                    });
                    System.out.println("Максимальные значения: " + maxValues); // Вывод: Максимальные значения: [3, -1, 5]
                    break;
                case 5:
                    System.out.println("Вы выбрали Задание 3.2");
                    // Пример 1: Фильтрация строк с длиной менее 3 символов
                    List<String> strings2 = List.of("qwerty", "asdfg", "zx");
                    List<String> filteredStrings = FunctionUtils.filter(strings2, value -> value.length() >= 3);
                    System.out.println(" строки: " + strings2); // Вывод: Отфильтрованные строки: [qwerty, asdfg]
                    System.out.println("Отфильтрованные строки: " + filteredStrings + "\n"); // Вывод: Отфильтрованные строки: [qwerty, asdfg]

                    // Пример 2: Фильтрация положительных элементов
                    List<Integer> numbers2 = List.of(1, -3, 7);
                    List<Integer> filteredNumbers = FunctionUtils.filter(numbers2, value -> value <= 0);
                    System.out.println("Элименты: " + strings2);
                    System.out.println("Отфильтрованные числа: " + filteredNumbers + "\n"); // Вывод: Отфильтрованные числа: [-3]

                    // Пример 3: Фильтрация массивов целых чисел, содержащих только отрицательные элементы
                    List<int[]> arrays2 = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{5, 4, 3}, new int[]{-4, -5});
                    List<int[]> filteredArrays = FunctionUtils.filter(arrays2, array -> {
                        for (int num : array) {
                            if (num > 0) {
                                return false; // Если найден положительный элемент, возвращаем false
                            }
                        }
                        return true; // Если все элементы отрицательные, возвращаем true
                    });

                    // Печать отфильтрованных массивов
                    System.out.println("Массивы: {1, 2, 3},{-1, -2, -3},{5, 4, 3}, {-4, -5})"); // Вывод: Отфиль
                    System.out.println("Отфильтрованные массивы:");
                    for (int[] array : filteredArrays) {
                        System.out.println(arrayToString(array)); // Печатаем каждый массив
                    }
                    // Вывод: Отфильтрованные массивы: [-1, -2, -3], [-4, -5]


                    break;
                case 6:
                    // Пример 1: Слияние строк
                    List<String> stringList = List.of("qwerty", "asdfg", "zx");
                    String concatenatedString = FunctionUtils.reduce(stringList, "", (a, b) -> a + b);
                    System.out.println("Список строк: " + stringList);
                    System.out.println("Сложенная строка: " + concatenatedString + "\n");

                    // Пример 2: Сумма чисел
                    List<Integer> intList = List.of(1, -3, 7);
                    Integer sum = FunctionUtils.reduce(intList, 0, (a, b) -> a + b);
                    System.out.println("Список чисел: " + intList);
                    System.out.println("Сумма чисел: " + sum + "\n");

                    // 3. Получим общее количество элементов во всех списках
                    List<List<Integer>> listOfLists = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6));
                    List<Integer> lengths2 = FunctionUtils.map(listOfLists, List::size);
                    Integer totalCount = FunctionUtils.reduce(lengths2, 0, (a, b) -> a + b);
                    System.out.println("Список элементов': " + listOfLists);
                    System.out.println("Общее количество элементов: " + totalCount + "\n ");


                    // Пример 4: Пустой список
                    List<Integer> emptyList = List.of();
                    Integer emptySum = FunctionUtils.reduce(emptyList, 0, (a, b) -> a + b);
                    System.out.println("Сумма элементов пустого списка: " + emptySum); // Должно вернуть 0


                    break;
                case 7:

                    List<Integer> numbers3 = List.of(1, -3, 7);
                    List<Integer> positiveNumbers = FunctionUtils.collect(numbers3, ArrayList::new, n -> n > 0);
                    List<Integer> negativeNumbers = FunctionUtils.collect(numbers3, ArrayList::new, n -> n < 0);
                    System.out.println("Числа: " + numbers3);
                    System.out.println("Положительные числа: " + positiveNumbers);
                    System.out.println("Отрицательные числа: " + negativeNumbers);

                    List<String> strings3 = List.of("qwerty", "asdfg", "zx", "qw");
                    Map<Integer, List<String>> groupedStrings = strings3.stream()
                            .collect(Collectors.groupingBy(String::length));
                    System.out.println("Строки: " + strings3);

                    groupedStrings.forEach((length, group) ->
                            System.out.println("Строки длиной " + length + ": " + group)
                    );


                    List<String> uniqueStrings = List.of("qwerty", "asdfg", "qwerty", "qw");
                    Set<String> uniqueSet = FunctionUtils.collect(uniqueStrings, HashSet::new, str -> true);
                    System.out.println("Cтроки: " + uniqueStrings);
                    System.out.println("Уникальные строки: " + uniqueSet);


                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 4.");
                    break;
            }
            System.out.println(); // Пустая строка для разделения выводов
        }

    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", "); // Добавляем запятую между элементами
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static void extractAndPrintValue(Box<Integer> box) {
        try {
            Integer value = box.get(); // Извлечение значения
            System.out.println("Извлеченное значение: " + value);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }


    }
}