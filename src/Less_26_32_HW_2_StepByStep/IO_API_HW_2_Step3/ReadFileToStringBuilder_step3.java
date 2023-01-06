package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileToStringBuilder_step3 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step3\\Folder\\";
        File myFile = new File(path_to_file + "big_file_read.txt");

        try (InputStream inputStream = new FileInputStream(myFile)) {
            long start = System.currentTimeMillis();
            /*
            Для экономии ресурсов создаем строковый билдер
            и далее помещаем в него методом *.append() наши
            считанные байты.
            */
            StringBuilder sb_to_read = new StringBuilder();
            int readData = inputStream.read();

            while (readData != -1) {
                sb_to_read.append((char) readData);
                readData = inputStream.read();
            }

            System.out.println(sb_to_read);

            long finish = System.currentTimeMillis();
            System.out.println("-----------------------------------------------------------------------------");
            // Вычисляем время затраченное на чтение файла по-байтно
            System.out.println("Время чтения по-байтно: " + (finish - start) + " мс.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
