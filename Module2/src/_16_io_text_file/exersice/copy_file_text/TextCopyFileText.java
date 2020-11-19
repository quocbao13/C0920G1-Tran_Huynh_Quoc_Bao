package _16_io_text_file.exersice.copy_file_text;

import java.io.*;

public class TextCopyFileText {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/_16_io_text_file/exersice/copy_file_text/test.txt");
            fileWriter.write("Hello!");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("src/_16_io_text_file/exersice/copy_file_text/test.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new  BufferedReader(fileReader);
            String line = null;
            FileWriter fileWriter1 = new FileWriter("src/_16_io_text_file/exersice/copy_file_text/test2.txt");
            while ((line = bufferedReader.readLine()) != null){
                fileWriter1.write(line);
            }
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
