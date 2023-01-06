package Less_26_32_HW_3_StepByStep.IO_API_HW_3_Step3;
/*
Пример работы класса RandomAccessFile.

Нужно помнить, что стандартный вариант чтения-записи
файла через InputStream/OutputStream не поддерживает
случайный доступ к данным, все идет сплошным потоком.

Экземпляры класса RandomAccessFile поддерживают
как чтение, так и запись в файл с произвольным
доступом. Файл с произвольным доступом ведет
себя как большой массив байтов, хранящийся в
файловой системе. Существует своего рода курсор
или индекс в подразумеваемом массиве, называемый
файловым указателем.
*/
import java.io.*;

public class RandomAccessFile_step3 {
    public static void main(String[] args) {
        // Задаем путь к файлу
        String path_to_file =
                "src\\Less_26_32_HW_3_StepByStep\\IO_API_HW_3_Step3\\RandomRWFolder\\big_file.txt";
        // Создаем объект класса File и передаем в него путь к файлу
        File file = new File(path_to_file);
        /*
        Создаем экземпляр класса RandomAccessFile, выставленный
        флаг "rw" позволяет читать из файла и записывать в файл.
        */
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            // Создаем байтовый массив
            byte[] array = new byte[1024];
            // Задаем позиции с которых планируем читать отрезки файл
            int positionOne = 5000;
            int positionTwo = 0;
            System.out.println("******* Первый прочитанный блок с позиции " + positionOne + " *******\n");
            /*
            Применяем метод *.seek(), который устанавливает смещение
            указателя файла, измеренное от начала файла, при котором
            происходит следующее чтение или запись. Т.е. задаем точку
            с которой будем читать/записывать данные.
            */
            randomAccessFile.seek(positionOne);
            /*
            Далее применяем метод *.read(), в реализации, которая
            считывает до b.length байтов данных из этого файла в
            массив байтов.
            */
            randomAccessFile.read(array);
            /*
            Выводим на экран полученные данные из файла
            */
            System.out.println(new String(array));

            System.out.println("\n******* Второй прочитанный блок с позиции " + positionTwo + " *******\n");
            // Повторяем операцию с другой позиции
            randomAccessFile.seek(positionTwo);
            randomAccessFile.read(array);
            System.out.println(new String(array));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
