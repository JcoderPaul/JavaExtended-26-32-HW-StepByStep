package Less_26_32_HW_3_StepByStep.IO_API_HW_3_Step1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteDataToFile_step1 {
    public static void main(String[] args) {
        // Задаем путь к файлу
        String path_to_file =
                "src\\Less_26_32_HW_3_StepByStep\\IO_API_HW_3_Step1\\MyFolder\\file_to_write.txt";
        // Создаем объект класса File и передаем в него путь к файлу
        File file = new File(path_to_file);
        /*
        В блоке 'try with resources' создаем исходящий поток данных.
        Флаг в конструкторе файлового исходящего потока стоит 'TRUE',
        что означает дозапись новых данных в файл, а не перезапись
        поверх старых.
        */
        try (OutputStream outputStream = new FileOutputStream(file, true)) {
           // Формируем строку, которую планируем записать в файл
           String string_names_for_write = "\nJohn Max Nick Thomas Andrew Roman Herbert Alex";
           // Пишем данные в файл
           outputStream.write(string_names_for_write.getBytes());
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
}