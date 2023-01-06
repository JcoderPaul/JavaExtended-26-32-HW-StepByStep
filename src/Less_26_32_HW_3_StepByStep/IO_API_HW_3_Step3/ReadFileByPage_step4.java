package Less_26_32_HW_3_StepByStep.IO_API_HW_3_Step3;
/*
Задание:
1. Создайте текстовый файл большого объема.
2. Напишите программу, которая запрашивает номер
   страницы в консоли (размер страницы 3000 байт).
3. Далее мы вводим номер страницы и у нас в консоли
   выводится текст этой страницы.
4. После ввода слова 'Выход' программа завершается.
*/
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadFileByPage_step4 {
    public static void main(String[] args) {
        // Задаем путь к файлу
        String path_to_file =
                "src\\Less_26_32_HW_3_StepByStep\\IO_API_HW_3_Step3\\RandomRWFolder\\big_file.txt";
        // Создаем объект класса File и передаем в него путь к файлу
        File file = new File(path_to_file);
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            // Создаем массив имитирующий размер полной страницы 3000 байт
            byte[] pageText = new byte[3000];
            // Создаем сканер, читающий данные с консоли
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите страницу для чтения или \nнаберите " +
                               "\"Выход \" для завершения \nпрограммы:");
            // Читаем строку с консоли
            String input = scanner.nextLine();
            // Цикл будет крутиться до ввода строки 'Выход'
            while (!input.equals("Выход")) {
                /*
                Предполагается, что пользователь будет вводить
                только цифры или текст 'Выход'. Парсим полученную
                с консоли строку, на наличие цифры.
                */
                int page = Integer.parseInt(input);
                /*
                Несложная математика для нахождения нужной страницы:
                - Допустим первая страница (1 - 1) = 0, умноженная
                  на величину массива даст 0. Т.е. позиция для чтения
                  из файла начинается с 0.
                - Допустим вторая страница (2 - 1) = 1, умноженная
                  на величину массива даст 3000. Т.е. позиция для чтения
                  из файла начинается с 3000.
                и т.д.
                */
                randomAccessFile.seek((page - 1) * pageText.length);
                // Получаем величину прочитанных байт
                int count = randomAccessFile.read(pageText);
                /*
                Если размер прочитанных байт -1, значит "мы уже на обложке"
                читать и выводить на экран нечего.
                */
                if(count == -1){
                    System.out.println("Такой страницы в книге нет! \nВыберите другую!");
                } else {
                /*
                Выводим на экран полученные данные из байтового массива
                начиная с нулевой позиции и до величины прочитанных данных.
                Как уже было ранее, если мы близки к концу файла, то в
                массив может загрузиться не все 3000 байт, а только,
                например 1230 байт. Вот их мы и должны прочитать и вывести
                на экран.
                */
                    System.out.println(new String(pageText, 0, count));
                    System.out.println("\nВыберите следующую страницу или наберите \n" +
                            "\"Выход \" для завершения программы:");
                }
                    input = scanner.nextLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nПрограмма завершила работу!");
    }
}