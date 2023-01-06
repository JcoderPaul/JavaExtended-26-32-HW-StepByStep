package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileWithByteArray_step4 {
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
                Однако массив - всегда массив и тут возникает заминка
                если мы считали 645 байт, а не 1024, это означает, что
                мы определенно добрались до конца текста. Однако, в
                нашем массиве оставшиеся 379 байт (ячеек массива), будут
                заполнены старыми данными. И при работе метода *.append()
                будут присоединены к финальному выводу.

                Нам бы этого не хотелось.

                Для этого применяем старый добрый вариант чтения данных
                по-байтово из массива с приведением полученных данных к
                char.

                5. Проверяем размер считанных данных если меньше 1024
                значит, конец текста близок.
                */
                if (sizeOfArrayReadingData < 1024){
                    // 6. Читаем массив посимвольно до величины считанных данных
                    for (int i = 0; i < sizeOfArrayReadingData; i++){
                    // 7. Присоединяем символ к общему строковому билдеру
                    sb_to_read.append((char) arrayBytes[i]);
                    }
                    /*
                    8. Выход из цикла означает, что все символы прочитаны
                    и можно обнулить значение (размер) считанных данных.
                    Т.е. считали весь файл.
                    */
                    sizeOfArrayReadingData = 0;

                } else {
                    /*
                    Если размер sizeOfArrayReadingData не меньше 1024,
                    то это означает, что мы можем сгрузить в строковый
                    билдер значения всех ячеек массива. В них, скорее
                    всего, нет повторяющихся данных из прошлой подкачки.
                    */
                sb_to_read.append(new String(arrayBytes));
                sizeOfArrayReadingData = inputStream.read(arrayBytes);
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