package com.oracledb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferWriteDemo {
    public static void main(String[] args) {
        // The string that needs to be written to the file
        String data = "This is an practice of writing data to a file using ByteBuffer.";

        // Using FileChannel to write data to a file
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/output.txt");
             FileChannel fileChannel = fos.getChannel()) {

            // Convert the string to bytes and put them in a ByteBuffer
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());

            // Write data from the buffer to the file
            fileChannel.write(buffer);

            System.out.println("Data written to file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

