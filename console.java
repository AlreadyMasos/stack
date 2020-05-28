import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class console {

    public static void main(String[] args) throws IOException {
        String fileName = "E:\\lab4\\gufovsky.txt";
        String read = readUsingFiles(fileName);
        System.out.println(read);

        String digits = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        int maxSize = read.length();
        stack number = new stack(maxSize);
        stack text = new stack(maxSize);
        stack other = new stack(maxSize);

        for (int i = 0; i < read.length(); i += 1) {
            String symbol = read.substring(i, i + 1);
            if (letters.contains(symbol)) {
                text.push(symbol);
                continue;
            }
            if (digits.contains(symbol)) {
                number.push(symbol);
                continue;
            }
            other.push(symbol);
        }

        System.out.println("\nСтек букв: ");
        stack reverseText = new stack(maxSize);
        while (!text.isEmpty())
            reverseText.push(text.pop());
        while (!reverseText.isEmpty())
            System.out.println(reverseText.pop());


        System.out.println("\nСтек цифр: ");
        stack reverseDig = new stack(maxSize);
        while (!number.isEmpty())
            reverseDig.push(number.pop());
        while (!reverseDig.isEmpty())
            System.out.println(reverseDig.pop());


        System.out.println("\nСтек остального: ");
        stack reverseOther = new stack(maxSize);
        while (!other.isEmpty())
            reverseOther.push(other.pop());
        while (!reverseOther.isEmpty())
            System.out.println(reverseOther.pop());
    }
    public static String readUsingFiles(String fileName) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}