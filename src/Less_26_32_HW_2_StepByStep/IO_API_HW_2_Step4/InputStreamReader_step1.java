package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step4;
/*
Особенность данного примера в том, что
побайтовое чтение латиницы вроде бы не
проблема, а вот чтение кирилицы уже да,
получаем набор псевдосимволов, даже если
файл и сохранен в формате UTF-8.

Проблема в размере кирилического символа -
более одного байта.

Для решения такой задачи применяют класс
Reader, который читает посимвольно.
*/
import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReader_step1 {
    public static void main(String[] args) {
        File directory = new File("src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step4\\MyFolder\\");
        directory.mkdir();
        File file = new File(directory, "rus_verse.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        В блоке try-with-resources создаем поток чтения
        посимвольно из указанного файла. Хотя по умолчанию
        кодировка UTF-8 применяется в данном классе, мы
        можем указать ее явно, либо выбрать любую другу.
        */
        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            // Читаем единственный символ
            int symbolForRead = reader.read();
            // Создаем строковый билдер
            StringBuilder result = new StringBuilder();
            /*
            Если в файле что-то есть то метод *.read()
            значение прочитанного символа, если файл
            закончится, то метод вернет -1.
            */
            while (symbolForRead > 0) {
                // Складируем прочитанные символы в билдер
                result.append((char) symbolForRead);
                // Читаем следующий
                symbolForRead = reader.read();
            }
            // Выводим на печать результат
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
