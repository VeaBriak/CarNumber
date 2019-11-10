import java.util.*;

/**Написать программу, которая будет работать как телефонная книга: если пишем новое имя, просит ввести номер телефона и запоминает его,
  если новый номер телефона — просит ввести имя и тоже запоминает. Если вводим существующее имя или номер телефона, программа должна выводить всю информацию о контакте.
  При вводе команды LIST программа должна печатать в консоль список всех абонентов в алфавитном порядке с номерами.**/

public class Main {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> result = new ArrayList<>();

            char[] symbols = {'A', 'B', 'C', 'E', 'H', 'M', 'O', 'P', 'T', 'Y'};
            int[] region = new int[197];
            for (int i = 0; i < 197; i++) {
                region[i] = i + 1;
            }
            List<String> array = new ArrayList<>();
            final int NUMBER_COUNT = 1000, DIGIT_COUNT = 10;
            for (char symbol : symbols)
                for (int numbers = 0; numbers < NUMBER_COUNT; numbers++) {
                    String number = String.format("%1$c%2$03d%1$c%1$c", symbol, numbers);
                    array.add(number);
                }
            for (char symbol1 : symbols)
                for (char symbol2 : symbols)
                    for (char symbol3 : symbols)
                        for (int numbers = 0; numbers < DIGIT_COUNT; numbers++) {
                            String number = String.format("%2$c%1$d%1$d%1$d%3$c%4$c", numbers, symbol1, symbol2, symbol3);
                            array.add(number);
                        }

            for (String number : array)
                for (int regions : region) {
                    result.add(String.format("%s%02d", number, regions));
                }
//            for (String num : result) {
//            System.out.println(num);
//            }
            System.out.println("Блатных номеров = " + result.size());
            Collections.sort(result);
            HashSet<String> set = new HashSet<>();
            set.addAll(result);
            TreeSet<String> treeSet = new TreeSet<>();
            treeSet.addAll(result);
            for (; ; ) {

                System.out.println("Введите номер машины: ");
                String carNumber = scanner.nextLine().trim();
                long start1 = System.currentTimeMillis();
                System.out.println(result.contains(carNumber) + " - " + (System.currentTimeMillis() - start1) + "ms" + " //Прямой перебор");
                long start2 = System.currentTimeMillis();
                System.out.println(Collections.binarySearch(result, carNumber) + " - " + (System.currentTimeMillis() - start2) + "ms" + " // Бинарный поиск");
                long start3 = System.currentTimeMillis();
                System.out.println(set.contains(carNumber) + " - " + (System.currentTimeMillis() - start3) + "ms" + " // При HashSet поиск");
                long start4 = System.currentTimeMillis();
                System.out.println(treeSet.contains(carNumber) + " - " + (System.currentTimeMillis() - start4) + "ms" + " // При TreeSet поик");
            }
        }

}
