package Less_26_32_HW_3_StepByStep.IO_API_HW_3_Step2;
/*
В примере WriteDataToFile_step1 показан пример
записи данных в файл без применения буферизации.
В данном случае данные сначала помещаются в
буфер потока, а затем в файл.
*/
import java.io.*;
import java.util.Scanner;

public class WriteAndReadFile_step2 {
    public static void main(String[] args) {
        // Задаем путь к файлу
        String path_to_file =
                "src\\Less_26_32_HW_3_StepByStep\\IO_API_HW_3_Step2\\MyReadWriteFolder\\write_read_file.txt";
        // Создаем объект класса File и передаем в него путь к файлу
        File file = new File(path_to_file);

        // I. Блок записи в файл
        /*
        Формируем буфер исходящего потока с аргументом файлового
        исходящего потока - готовимся писать данные файл с флагом
        дозаписи (не перезаписи)
        */
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            // Создаем сканер (будем читать данные с консоли)
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите любое имя или \"Выход\" для выхода из программы:");
            // Читаем строку с консоли из сканера
            String next = scanner.nextLine();
            // Цикл будет крутиться, до тех пор пока мы не введем 'Выход'
            while (!next.equals("Выход")) {
                /*
                Вот тут целая комбинация методов:
                - метод *.write() пишет данные в исходящий поток, то в свою очередь в файл
                - метод *.getBytes() класса String имеет несколько реализаций:
                    byte[] getBytes() - Кодирует текущую (данную) строку в
                    последовательность байтов, используя кодировку платформы
                    по умолчанию, сохраняя результат в новый массив байтов.

                    byte[] getBytes(Charset charset) - Кодирует текущую (данную)
                    строку в последовательность байтов, используя заданный набор
                    символов, сохраняя результат в новый массив байтов.

                    byte[] getBytes(String charsetName) - Кодирует текущую (данную)
                    строку в последовательность байтов, используя именованный набор
                    символов, сохраняя результат в новый массив байтов.

                В данном случае мы преобразуем полученную строку в последовательность байт
                и пишем ее в поток.
                */
                outputStream.write(next.getBytes());
                outputStream.write("\n".getBytes());
                // Ждем ввода следующей строки (имя или 'Выход')
                next = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // II. Блок чтения из файла
        /*
        В данном блоке реализован код рассмотренный в разделе
        Less_26_29_HW_2_StepByStep, где подробно рассматриваются
        методики чтения из файла см. пример ReadFile..._step_1-6.
        */
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] array = new byte[128];
            int count = inputStream.read(array);
            StringBuilder result = new StringBuilder();
            while (count > 0) {
                result.append(new String(array, 0, count));
                count = inputStream.read(array);
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
