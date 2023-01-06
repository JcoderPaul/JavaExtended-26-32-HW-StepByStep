package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileWithTWR_step2 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step3\\Folder\\";
        File myFile = new File(path_to_file + "file_for_read.txt");
        /*
            Используем одну из реализаций класса
            InputStream для чтения из файла. Мы
            получили поток данных и готовы читать
            из файла. Тут, в отличие от первого
            варианта мы применили блок 'try with resources'
            поскольку наши классы AutoCloseable и
            их можно закрыть по завершении работы
            входящего потока данных.
        */
        try (InputStream inputStream = new FileInputStream(myFile)){

            /*
            Не самый оптимальный способ побайтового
            чтения данных из файла, но простой и
            доходчивый. Метод *.read() считывает
            байт данных из входящего потока и
            возвращает -1, если читать больше нечего.
            */
            int readData = inputStream.read();
            /*
            Для вывода информации на экран, нам
            нужен цикл. Который будет читать данные
            из файла, пока таковые не закончатся.
            */
            while (readData != -1) {
                /*
                Выводим считанный байт на экран, но
                данные будут читаться в формате int,
                нам нужно сделать явное приведение типов,
                в нашем случае к char, чтобы отобразить
                полученный текст.
                */
                System.out.print((char) readData);
                // Читаем новый байт
                readData = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
