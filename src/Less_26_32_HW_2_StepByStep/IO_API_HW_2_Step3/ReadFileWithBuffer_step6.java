package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step3;
/*
ЕЩЕ Более изящная реализация ReadFileWithByteArray_step3
В данном примере чтение данных оптимизировано при помощи
чтения в буфер потока.
*/

import java.io.*;

public class ReadFileWithBuffer_step6 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step3\\Folder\\";
        File myFile = new File(path_to_file + "big_file_read.txt");

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(myFile))) {
            long start = System.currentTimeMillis();

            int sizeOfArrayReadingData = inputStream.read();
            StringBuilder sb_to_read = new StringBuilder();
            while (sizeOfArrayReadingData != -1) {
                    sb_to_read.append((char) sizeOfArrayReadingData);
                    sizeOfArrayReadingData = inputStream.read();
            }
            System.out.println(sb_to_read);

            long finish = System.currentTimeMillis();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Время чтения по-байтно: " + (finish - start) + " мс.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}