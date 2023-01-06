package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step4;
/*
1. Создайте файл с именами (RUS). Все имена должны быть написаны
   в одну строку и между именами должен быть пробел.
2. Прочитайте файл и соберите имена в одну строку, используя Reader
   и чтение в массив символов.
3. Полученную строку преобразуйте в массив имен, используя метод
   split из класса String.
4. Преобразуйте массив в stream, отфильтруйте, оставив только имена,
   которые начинаются на букву 'А'
5. Результат отобразить в консоли.
*/
import java.io.*;
import java.util.Arrays;

public class InputStreamReader_step2 {
    public static void main(String[] args) {
        File directory =
                new File("src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step4\\MyFolder\\");
        File file = new File(directory, "rus_names.txt");
        try (Reader readFromFile = new InputStreamReader(new FileInputStream(file))) {
            char[] arrayOfReadChar = new char[128];
            /*
            При такой конфигурации кода мы получаем
            размер прочитанных данных от 0 до 128,
            как в выбранном размере массива.
            */
            int sizeOfReadStream = readFromFile.read(arrayOfReadChar);
            StringBuilder result = new StringBuilder();
            while (sizeOfReadStream > 0) {
                result.append(new String(arrayOfReadChar, 0, sizeOfReadStream));
                sizeOfReadStream = readFromFile.read(arrayOfReadChar);
            }
            // Метод *.split() возвращает массив строк
            String[] names = result.toString().split(" ");
            // Превращаем массив строк в stream
            Arrays.stream(names)
                    // Фильтруем текущий stream по первой букве имени
                    .filter(string -> string.startsWith("А"))
                    // Терминальная операция вывода на экран
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
