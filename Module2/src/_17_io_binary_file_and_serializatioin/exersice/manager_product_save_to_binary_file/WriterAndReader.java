package _17_io_binary_file_and_serializatioin.exersice.manager_product_save_to_binary_file;

import java.io.*;

public class WriterAndReader{
    public void writeFile(Product product) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/_17_io_binary_file_and_serializatioin/exersice/manager_product_save_to_binary_file/file.c09"),true));

            objectOutputStream.writeObject(product);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("src/_17_io_binary_file_and_serializatioin/exersice/manager_product_save_to_binary_file/file.c09")));

            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
