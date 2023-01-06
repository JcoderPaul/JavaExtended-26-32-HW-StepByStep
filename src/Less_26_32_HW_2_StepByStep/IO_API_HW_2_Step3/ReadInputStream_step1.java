package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;

import java.io.*;

public class ReadInputStream_step1 {
    public static void main(String[] args) {
        // Создаем путь к будущей папке
        String path_to_file = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step3\\Folder\\";
        // Создаем путь к будущему файлу в той самой папке
        File myFolder = new File(path_to_file);
        File myFile = new File(path_to_file + "file_for_read.txt");
        try {
            myFolder.mkdirs();
            myFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InputStream inputStream = null;
        try {
            /*
            Используем одну из реализаций класса
            InputStream для чтения из файла. И вот
            мы получили поток данных и готовы читать
            из файла.
            */
            inputStream = new FileInputStream(myFile);
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
        } finally {
            try {
                /*
                Любой отработанный поток данных
                нужно закрывать для экономии ресурсов.
                */
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
