package javaNioDecorator;

import java.io.*;

public class Task1 {

    private static final String pathRead = "C:\\Users\\ASUS\\IdeaProjects\\new_prepod\\src\\javaNioDecorator\\forRead.txt";
    private static final String pathWrite = "C:\\Users\\ASUS\\IdeaProjects\\new_prepod\\src\\javaNioDecorator\\forWrite.txt";

    private static final BufferedReader reader;
    private static final BufferedWriter writer;

    static {
        try {
            reader = new BufferedReader(new FileReader(pathRead));
            writer = new BufferedWriter(new FileWriter(pathWrite));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        //task1
        BufferedReader reader = new BufferedReader(new FileReader(pathRead));
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathWrite));

        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            line = reader.readLine();
        }
        reader.close();
        writer.close();
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }


}
