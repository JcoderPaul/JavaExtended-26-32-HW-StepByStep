package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;
/*
Более изящная реализация ReadFileWithByteArray_step4
*/
import java.io.*;

public class ReadFileWithByteArray_step5 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step3\\Folder\\";
        File myFile = new File(path_to_file + "big_file_read.txt");

        try (InputStream inputStream = new FileInputStream(myFile)) {
            long start = System.currentTimeMillis();
            /*
            Для оптимизации скорости работы программы,
            мы будем сразу считывать по 1024 байта из
            входного потока данных и писать их в строковый
            билдер.

            1. Формируем массив байт
            */
            byte[] arrayBytes = new byte[1024];
            /*
            2. Читаем данные в массив и тут же получаем
            размер считанных данных, т.е. если в массив
            будет считано 645 байт, а не 1024 байта, то
            sizeOfArrayReadingData их и получит в качестве
            значения.
            */
            int sizeOfArrayReadingData = inputStream.read(arrayBytes);
            // 3. Формируем строковый билдер
            StringBuilder sb_to_read = new StringBuilder();
            /*
            4. Цикл работает до тех пор, пока в наш байтовый массив
            хоть что-то прилетает, хотя бы 1-н байт, т.е. чтение из
            файла идет.
            */
            while (sizeOfArrayReadingData > 0) {
                /*
                Помним, что стока это массив символов и
                тоже имеет индексацию начинающуюся с 0,
                а значит мы можем в новую строку поместить
                только те элементы массива, которые нам нужны.

                Как и в прошлом примере, мы создаем строку из
                массива байт с нулевой позиции массива и до
                'размера скачанных данных'

                Т.е. sizeOfArrayReadingData = 1024, как массив,
                значит в строку уйдет весь массив. Если
                sizeOfArrayReadingData < 1024, например
                sizeOfArrayReadingData = 654 в строку уйдет,
                только элементы массива с 0 по 654.

                5. Присоединяем к строковому билдеру
                полученные данные.
                */
                try {
                    sb_to_read.append(new String(arrayBytes,0,sizeOfArrayReadingData));
                    sizeOfArrayReadingData = inputStream.read(arrayBytes);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(sb_to_read);

            long finish = System.currentTimeMillis();
            System.out.println("-----------------------------------------------------------------------------");
            /*
            Вычисляем время затраченное на чтение файла с использованием массива байт
            Несложно заметить, что время затраченное на чтение одного и того же файла
            'big_file_read.txt' по-байтно (см. ReadFileToStringBuilder_step3) и сразу
            массивом байт (данный пример) отличается примерно в 21 раз.
            */
        System.out.println("Время чтения по-байтно: " + (finish - start) + " мс.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}