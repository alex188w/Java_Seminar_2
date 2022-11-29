import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * Seminar1
 */
public class Seminar2 {
    public static void main(String[] args) {
        // System.out.println(alternatingCharacters(10, '!', '-'));
        String s = "aaaabbbcdda";
        String p = "123454321";
        String p1 = "123354321"; 
        String str = oneHandredStr("TEST", 100);
        System.out.println(oneHandredStr("TEST", 100));
        // writerTxt(str);
        // writerTxt1(str);
        // System.out.println(compresstr(s));
        // System.out.println(compresstr1(s));
        // System.out.println(palindrom(p));
        // System.out.println(palindrom1(p));
        
    }     

    // Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет
    // строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с
    // c1.
    private static String alternatingCharacters(int length, char c1, char c2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++)
            if (i % 2 == 0)
                builder.append(c1);
            else
                builder.append(c2);
        return builder.toString();
    }

    // Напишите метод, который сжимает строку. Пример: aaaabbbcdd → a4b3cd2
    private static String compresstr(String str) {
        StringBuilder new_str = new StringBuilder();
        int count = 1;
        int i = 0;
        for (i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;
            else {
                if (count > 1) {
                    new_str.append(str.charAt(i));
                    new_str.append(count);
                    count = 1;
                } else {
                    new_str.append(str.charAt(i));
                }
            }
            if (count > 1) { // условие для добавления крайних справа символов
                new_str.append(str.charAt(i));
                new_str.append(count);
            } else
                new_str.append(str.charAt(i));
        }
        return new_str.toString();
    }

    // Та же задача через переменную simb
    private static String compresstr1(String str) {
        StringBuilder new_str = new StringBuilder();
        int count = 0;
        char simb = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == simb)
                count++;
            else {
                new_str.append(simb);
                simb = str.charAt(i);
                if (count > 1) {
                    new_str.append(count);
                    count = 1;
                }
            }
        }
        new_str.append(simb);
        if (count > 1)
            new_str.append(count);

        return new_str.toString();
    }

    // Напишите метод, который принимает на вход строку (String) и определяет
    // является ли строка палиндромом (возвращает boolean значение).
    private static boolean palindrom(String str) {
        if (str.equals(new StringBuilder(str).reverse().toString()))
            return true;
        else
            return false;
    }

    // другой способ записи
    private static boolean palindrom1(String str) {
        return (str.equals(new StringBuilder(str).reverse().toString()));
    } 

     // Напишите метод, который составит строку, состоящую из 100 повторений слова
    // TEST и метод, который запишет эту строку в простой текстовый файл,
    // обработайте исключения
    private static String oneHandredStr(String str, int num) {
        StringBuilder new_str = new StringBuilder();
        for (int i = 0; i < num; i++)
            new_str.append(str);
        return new_str.toString();
    }

    // запись в файл
    private static void writerTxt(String str) {
        try (FileWriter writer = new FileWriter("TEST.txt", false)) {
            writer.write(str);
            writer.flush();
        } catch (Exception e) {
            System.out.println("catch");
        }
    }

    // запись в файл 2
    private static void writerTxt1(String str) {
        try (FileWriter nFile = new FileWriter("TEST.txt", false)) {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                nFile.write("TEST");
                count++;
                if (count == 20) {
                    nFile.write("\n");
                    count = 0;
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}