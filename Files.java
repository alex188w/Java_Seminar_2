import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public class Files {
    // Напишите метод, который вернет содержимое текущей папки в виде массива строк.
    // Напишите метод, который запишет массив, возвращенный предыдущим методом в
    // файл.
    // Обработайте ошибки с помощью try-catch конструкции. В случае возникновения
    // исключения, оно должно записаться в лог-файл.
    public static void main(String[] args) throws IOException {
        fileWriter(null);
    }

    private static void fileWriter(String string) throws IOException {
        File dir = new File(
                "F:Обучение/Знакомство с языком программирования Java - Знакомство и как пользоваться базовым API/Семинары/Семинар2/Seminar_2");
        try {
            String[] fileNames = getStrArr(dir);
            System.out.println("Список файлов директории");
            try (FileWriter writer = new FileWriter("TEST1.txt")) {
                for (int i = 0; i < fileNames.length; i++) {
                    writer.write(fileNames[i]);
                    writer.write("\n");
                    writer.flush();
                    System.out.println(fileNames[i]);
                }
            }
        } catch (Exception ex) {
            Logger logger = Logger.getLogger("Files");
            FileHandler handler = new FileHandler("Test.log");
            logger.addHandler(handler);
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    private static String[] getStrArr(File f) throws SecurityException, IOException {
        File[] files = f.listFiles();
        String[] strArr = new String[files.length];
        try {
            for (int i = 0; i < files.length; i++)
                strArr[i] = files[i].toString();
        } catch (Exception ex) {
            Logger logger = Logger.getLogger("Files");
            FileHandler handler = new FileHandler("Test.log");
            logger.addHandler(handler);
            logger.log(Level.SEVERE, "\n", ex.getMessage());
        }
        return strArr;
    }
}