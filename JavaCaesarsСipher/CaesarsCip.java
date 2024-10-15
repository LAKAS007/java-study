package JavaCaesarsСipher;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class CaesarsCip {
    private static final Character[] rusAlpha = new Character[] {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ь', 'ы', 'э', 'ю', 'я'};
    private static final Character[] engAlpha = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static String actualLang;
    private static int encodeKey;

    private static final String FILENAME = "src/JavaCaesarsСipher/text.txt";
    private static final String FILENAME_CODE = "src/JavaCaesarsСipher/codetext.txt";

    private static Scanner scan = new Scanner(System.in);

    public static String encodeText(String text) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) {
                res.append(text.charAt(i));
            }
            else {
                try {
                    if (Character.isUpperCase(text.charAt(i))) {
                        if (actualLang.equals("eng")) {
                            res.append(engAlpha[Arrays.asList(engAlpha).indexOf(Character.toLowerCase(text.charAt(i))) + encodeKey].toString().toUpperCase());

                        } else if (actualLang.equals("rus")) {
                            res.append(rusAlpha[Arrays.asList(rusAlpha).indexOf(Character.toLowerCase(text.charAt(i))) + encodeKey].toString().toUpperCase());
                        }
                    }
                    else {
                        if (actualLang.equals("eng")) {
                            res.append(engAlpha[Arrays.asList(engAlpha).indexOf(text.charAt(i)) + encodeKey].toString());
                        } else if (actualLang.equals("rus")) {
                            res.append(rusAlpha[Arrays.asList(rusAlpha).indexOf(text.charAt(i)) + encodeKey].toString());
                        }
                    }
                } catch (Exception e) {
                    int cnt;
                    if (Character.isUpperCase(text.charAt(i))) {
                        if (actualLang.equals("eng")) {
                            cnt = encodeKey - (engAlpha.length - Arrays.asList(engAlpha).indexOf(Character.toLowerCase(text.charAt(i))));
                            res.append(engAlpha[cnt].toString().toUpperCase());
                        } else if (actualLang.equals("rus")) {
                            cnt = encodeKey - (rusAlpha.length - Arrays.asList(rusAlpha).indexOf(Character.toLowerCase(text.charAt(i))));
                            res.append(rusAlpha[cnt].toString().toUpperCase());
                        }
                    }
                    else {
                        if (actualLang.equals("eng")) {
                            cnt = encodeKey - (engAlpha.length - Arrays.asList(engAlpha).indexOf(Character.toLowerCase(text.charAt(i))));
                            res.append(engAlpha[cnt]);
                        } else if (actualLang.equals("rus")) {
                            cnt = encodeKey - (rusAlpha.length - Arrays.asList(rusAlpha).indexOf(Character.toLowerCase(text.charAt(i))));
                            res.append(rusAlpha[cnt]);
                        }

                    }
                }
            }
        }
        return res.toString();
    }
    public static String decodeText(String text) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {           //в 1 -> б
            if (!Character.isLetter(text.charAt(i))) {
                res.append(text.charAt(i));
            }
            else {
                try {
                    if (Character.isUpperCase(text.charAt(i))) {
                        if (actualLang.equals("eng")) {
                            res.append(engAlpha[Arrays.asList(engAlpha).indexOf(Character.toLowerCase(text.charAt(i))) - encodeKey].toString().toUpperCase());
                        } else if (actualLang.equals("rus")) {
                            res.append(rusAlpha[Arrays.asList(rusAlpha).indexOf(Character.toLowerCase(text.charAt(i))) - encodeKey].toString().toUpperCase());
                        }
                    }
                    else {
                        if (actualLang.equals("eng")) {
                            res.append(engAlpha[Arrays.asList(engAlpha).indexOf(text.charAt(i)) - encodeKey].toString());
                        } else if (actualLang.equals("rus")) {
                            res.append(rusAlpha[Arrays.asList(rusAlpha).indexOf(text.charAt(i)) - encodeKey].toString());
                        }
                    }
                } catch (Exception e) {
                    int cnt;
                    if (Character.isUpperCase(text.charAt(i))) {
                        if (actualLang.equals("eng")) {
                            cnt = engAlpha.length + (Arrays.asList(engAlpha).indexOf(Character.toLowerCase(text.charAt(i))) - encodeKey);
                            res.append(engAlpha[cnt].toString().toUpperCase());
                        } else if (actualLang.equals("rus")) {
                            cnt = rusAlpha.length + (Arrays.asList(rusAlpha).indexOf(Character.toLowerCase(text.charAt(i))) - encodeKey);
                            res.append(rusAlpha[cnt].toString().toUpperCase());
                        }

                    }
                    else {
                        if (actualLang.equals("eng")) {
                            cnt = engAlpha.length + (Arrays.asList(engAlpha).indexOf(text.charAt(i)) - encodeKey);
                            res.append(engAlpha[cnt]);
                        } else if (actualLang.equals("rus")) {
                            cnt = rusAlpha.length + (Arrays.asList(rusAlpha).indexOf(text.charAt(i)) - encodeKey);
                            res.append(rusAlpha[cnt]);
                        }

                    }
                }
            }
        }
        return res.toString();
    }

    public static String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append("\n");
        }
        reader.close();
        return text.toString();
    }
    public static void writeToFile(String text, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);

        fileWriter.write(text);
        fileWriter.flush();
    }

    public static void setActualLang() {
        System.out.println("Введите язык (eng / rus)");
        actualLang = scan.nextLine();
    }
    public static void setEncodeKey() {
        System.out.println("Введите ключь шифрования");
        encodeKey = scan.nextInt();
    }

    public static void bruteForce() throws IOException {
        String text = CaesarsCip.readFromFile(FILENAME_CODE);

        if (actualLang.equals("rus"))
            for (int i = 0; i < rusAlpha.length; i++) {
                encodeKey = i;
                String dec = CaesarsCip.decodeText(text);
                System.out.println(dec);
            }
        else if (actualLang.equals("eng")) {
            for (int i = 0; i < engAlpha.length; i++) {
                encodeKey = i;
                String dec = CaesarsCip.decodeText(text);
                System.out.println(dec);            }
        }
    }

    public static String getFilename() {
        return FILENAME;
    }
    public static String getFilenameCode() {
        return FILENAME_CODE;
    }
}

