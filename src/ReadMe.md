### ******* IO (Input & Output) API *******

IO API – (Input & Output) в первую очередь это Java API, которые облегчают работу с потоками.
В данном разделе кратко, по шагам, повторяем материал из разделов:
- [JavaExtended-26-29](https://github.com/JcoderPaul/JavaExtended-26-29) - раздел описывает варианты работы с классами и методами IO API. 
- [JavaExtended-30-32](https://github.com/JcoderPaul/JavaExtended-30-32) - раздел описывает варианты работы с классами и методами NIO API.

Следующие разделы содержат:
 ### [Less_26_32_HW_2_StepByStep](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/tree/master/src/Less_26_32_HW_2_StepByStep):
 ***
   - [IO_API_HW_2_Step1](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/tree/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step1) - примеры создания папок и файлов, пример работы метода *.listFiles();
   
   Документация по разделу (RUS):
   - [listFilesMethod.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/listFilesMethod.txt) - описание метода *.listFiles();
   - [FileСonstructor.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/File%D0%A1onstructor.txt) - описание конструкторов класса File;
   - [InterfaceFileFilter.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/InterfaceFileFilter.txt)
   - [InterfaceFilenameFilter.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/InterfaceFilenameFilter.txt)
 ***
   - [IO_API_HW_2_Step2](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/tree/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step2) - небольшая задача на закрепление материала:
1. Создать иерархию папок: folder1/folder2/folder3
2. В folder3 создать несколько файлов в разными именами
   (несколько из них должны начинаться с 'А')
3. Вывести на экран абсолютные пути файлов, имена
   которых начинаются на 'А'
***
- [IO_API_HW_2_Step3](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/tree/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3) - примеры использования классов работающих с входящими потоками [InputStream](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassInputStream.txt), [FileInputStream](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/FileInputStream.txt), [BufferedInputStream](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassBufferedInputStream.txt) и их методами *.read() и *.close();
  - [ReadInputStream_step1](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadInputStream_step1.java) - пример простого по-байтного чтения данных из короткого текстового файла;
  - [ReadInputStream_step2](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadFileWithTWR_step2.java) - пример простого по-байтного чтения данных из короткого текстового файла с применением блока 'try with resources' ;
  - [ReadInputStream_step3](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadFileToStringBuilder_step3.java) - пример чтения данных из большого текстового файла с применением StringBuilder;
  - [ReadInputStream_step4](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadFileWithByteArray_step4.java) - пример оптимизации чтения данных из файла при помощи байтового массива;
  - [ReadInputStream_step5](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadFileWithByteArray_step5.java) - пример аналогичный предыдущему, с более изящным решением;
  - [ReadInputStream_step6](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step3/ReadFileWithBuffer_step6.java) - пример чтения данных при помощи BufferedInputStream;
  
Документация по разделу (RUS):
- [ClassInputStream.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassInputStream.txt)
- [FileInputStream.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/FileInputStream.txt)
- [ClassBufferedInputStream.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassBufferedInputStream.txt)
***
- [IO_API_HW_2_Step4](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/tree/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step4) - примеры использования класса Reader и его методов;
  
  - InputStreamReader_step1 - пример работы с методами класса [Reader](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassReader.txt) и InputStreamReader;
  - [InputStreamReader_step2](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/IO_API_HW_2_Step4/InputStreamReader_step2.java) - небольшая задача на закрепление материала:
1. Создайте файл с именами (RUS). Все имена должны быть написаны
   в одну строку и между именами должен быть пробел.
2. Прочитайте файл и соберите имена в одну строку, используя Reader
   и чтение в массив символов.
3. Полученную строку преобразуйте в массив имен, используя метод
   split из класса String.
4. Преобразуйте массив в stream, отфильтруйте, оставив только имена,
   которые начинаются на букву 'А'
5. Результат отобразить в консоли.

Документация по разделу (RUS):
- [ClassReader.txt](https://github.com/JcoderPaul/JavaExtended-26-32-HW-StepByStep/blob/master/src/Less_26_32_HW_2_StepByStep/RUS_DOC/ClassReader.txt)
***