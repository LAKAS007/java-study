package JavaCaesarsСipher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите действие (encode / decode / BF): ");
        String move = scanner.nextLine();

        String filename = CaesarsCip.getFilename();
        String codeFilename = CaesarsCip.getFilenameCode();

        if (move.equals("encode")) {
            //Ввод языка
            CaesarsCip.setActualLang();

            //Ввод ключа шифрования
            CaesarsCip.setEncodeKey();

            //Чтение файла и запись в переменную
            String text = CaesarsCip.readFromFile(filename);

            // Кодировка текста
            String encodeText = CaesarsCip.encodeText(text);

            //Запись текста в файл
            CaesarsCip.writeToFile(encodeText, codeFilename);
        } else if (move.equals("decode")) {
            //Ввод языка
            CaesarsCip.setActualLang();

            //Ввод ключа шифрования
            CaesarsCip.setEncodeKey();

            //Чтение файла и запись в переменную
            String text = CaesarsCip.readFromFile(codeFilename);

            // Кодировка текста
            String decodeText = CaesarsCip.decodeText(text);

            //Запись текста в файл
            CaesarsCip.writeToFile(decodeText, filename);
        } else if (move.equals("BF")) {

            CaesarsCip.setActualLang();
            
            CaesarsCip.bruteForce();
        }
    }
}
