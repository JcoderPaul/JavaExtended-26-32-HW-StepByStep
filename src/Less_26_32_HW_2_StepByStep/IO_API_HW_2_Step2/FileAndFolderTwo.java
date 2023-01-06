package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step2;
/*
Задача:
1. Создать иерархию папок: folder1/folder2/folder3
2. В folder3 создать несколько файлов в разными именами
   (несколько из них должны начинаться с 'А')
3. Вывести на экран абсолютные пути файлов, имена
   которых начинаются на 'А'
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAndFolderTwo {
    public static void main(String[] args) {
        /*
        Создаем путь относительно папки src, где будет
        создаваться каскад из 3-х папок и далее файлы.
        */
        String pathForCreateFolder =
                "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step2\\folder1\\folder2\\folder3\\";
        // Создаем объект File с указанным ранее путем
        File folders = new File(pathForCreateFolder);
        // Для удобства создания файлов создаем их список
        List<File> files = new ArrayList<>();
        /*
        Помещаем в будущем создаваемые файлы в наш список,
        в качестве пути создания файлов указываем составную
        строку из относительного пути указанного ранее + имя
        создаваемого файла.
        */
        files.add(new File(pathForCreateFolder + "Atlanta.txt"));
        files.add(new File(pathForCreateFolder + "Amber.txt"));
        files.add(new File(pathForCreateFolder + "Atoll.txt"));
        files.add(new File(pathForCreateFolder + "Briony.txt"));
        files.add(new File(pathForCreateFolder + "Bee.txt"));
        // Создаем директории из пути
        folders.mkdirs();
        // Создаем в цикле файлы из нашего списка
        for (File mkFile: files) {
            try {
                mkFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        /*
        При помощи метода *.listFiles() получаем массив
        файлов в папке folder3, т.к. она самая верхняя в
        иерархии папок в пути 'pathForCreateFolder'
        */
        File[] folder_structure = folders.listFiles();
        // Выводим длину массива на экран
        System.out.println(folder_structure.length);
        // Выводим имена всех файлов на экран
        for (File prn_srtucture: folder_structure) {
            System.out.println(prn_srtucture.getName());
        }
        /*
        Получаем массив имен файлов начинающихся с 'А',
        чтобы массив сформировался, необходимо быть
        внимательным при создании файлов (см. выше) и
        при их фильтрации. Т.е. если мы создаем файл и
        его имя на латинице, то и фильтровать мы должны
        используя латиницу, а не кириллицу. Выглядят
        одинаково: 'А' - cyr и 'A' - lat, а результат
        может удивить.
        */
        File[] filtered_file = folders.listFiles(name -> name.getName().startsWith("A"));
        // Выводим массив на экран, при этом выводим абсолютные пути файлов
        System.out.println(filtered_file.length);
        for (File prn_filter: filtered_file){
            System.out.println(prn_filter.getAbsolutePath());
        }

    }
}
