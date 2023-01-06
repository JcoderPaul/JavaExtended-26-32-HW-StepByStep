package Less_26_32_HW_2_StepByStep.IO_API_HW_2_Step1;
/*
Для более подробного ознакомления и повторения
см. Less_29_IO_FileClassMethod данного раздела.
*/

import java.io.File;
import java.io.FileFilter;

public class CreateFileAndFolder {
    public static void main(String[] args) {
        /*
        Класс File задает и файлы и папки, в конструктор
        класса передается путь к файлу/папке, даже если
        ни того ни другого еще нет (не созданы).

        Задаем путь к папке и файлам...
        */
        String path = "src\\Less_26_32_HW_2_StepByStep\\IO_API_HW_2_Step1\\DirAndFile\\";
        File directory = new File(path);
        /*
        Такой вариант создания тоже работает:
        File file = new File(path + "file1.txt");
        См. описание в FileСonstructor.txt
        */
        File file = new File(path,"file1.txt");
        File file2 = new File(path,"file2.txt");
        File file3 = new File(path, "file3.txt");
        File testListFilter = new File(path,"Dir1");
        File testListFilter2 = new File(path,"Dir2");
        System.out.println("---- Ни файлов ни папок еще нет ----");
        // Проверочные методы класса File
        System.out.println(directory.getName()); // DirAndFile хотя папки еще нет в реальности
        System.out.println(directory.isDirectory()); // False
        System.out.println(directory.exists()); // False
        System.out.println(file.getName()); // file1.txt хотя файла еще нет в реальности
        System.out.println(file.isFile()); // False
        System.out.println(file.exists()); // False
        // Создаем наши сначала папки, а затем файлы
        try {
            /*
            Если у нас цепочка вложенных папок,
            которых не существует, данный метод
            их создаст, в отличие от *.mkdir()
            */
            directory.mkdirs();
            // Создаем 3-и новых файла
            file.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            testListFilter.mkdir();
            testListFilter2.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Повторная проверка после создания
        System.out.println("---- Файлы и папки созданы ----");
        System.out.println(directory.isDirectory()); // True
        System.out.println(directory.exists()); // True
        System.out.println(file.isFile()); // True
        System.out.println(file.exists()); // True

        System.out.println("---- Имя файла содержит '1' папки игнорируем ----");
        /*
        Для понимания процесса фильтрации изучить:
        - listFilesMethod.txt - описание метода *.listFiles()
        - FileСonstructor.txt
        - InterfaceFileFilter.txt
        - InterfaceFilenameFilter.txt
        в папке RUS_DOC

        В данном случае применяем Interface FileFilter в
        котором мы реализуем метод *.accept(). Задача -
        отфильтровать только файлы содержащие символ '1',
        папки с этим символом игнорируем.
        */
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                boolean fileIsContainSymbol = false;
                if(dir.isDirectory()) {
                    fileIsContainSymbol = false;
                }
                if (dir.isFile() && dir.getName().contains("1")) {
                    fileIsContainSymbol = true;
                }
                return fileIsContainSymbol;
            }
        });

        for (File f : files) {
            System.out.println(f.getName());
        }
        // Тоже что и выше, но через Lambda и Interface FilenameFilter
        System.out.println("---- Имя файла и папки содержит '2' ----");
        File[] filesTwo = directory.listFiles((dir, name) -> name.contains("2"));

        for (File f : filesTwo) {
            System.out.println(f.getName());
        }
        /*
        Тоже что и выше, но через Lambda и, в данном случае
        применяем Interface FileFilter, который фильтрует в
        массив и папки и файлы содержащие '1'. Отличие от
        первого фильтра, где применялся анонимный класс, тут
        в массив попадают и папки и файлы.
        */
        System.out.println("---- Имя файла или папки содержит '1' ----");
        File[] filesThree = directory.listFiles((name) -> name.getName().contains("1"));

        for (File f : filesThree) {
            System.out.println(f.getName());
        }
    }
}