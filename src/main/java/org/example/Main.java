package org.example;

import org.example.model.FirstLine;
import org.example.model.SecondLine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String fileName = "D:\\data\\modeldata\\output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (int i = 0; i < 1000; i++) {
                FirstLine firstLine = new FirstLine(i);
                SecondLine secondLine = new SecondLine(i);
                System.out.println(firstLine.toString());
                System.out.println(secondLine.toString());
                if (firstLine.toString().length() != 69) {
                    System.out.println("错误1！");
                }
                if (secondLine.toString().length() != 69) {
                    System.out.println("错误2！");
                }
                writer.write(firstLine.satelliteoribitName);
                writer.newLine(); // 写入换行符
                writer.write(firstLine.toString());
                writer.newLine(); // 写入换行符
                writer.write(secondLine.toString());
                writer.newLine(); // 写入换行符

            }

            System.out.println("写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            FirstLine firstLine = new FirstLine(i);
            SecondLine secondLine = new SecondLine(i);
            System.out.println(firstLine.toString());
            System.out.println(secondLine.toString());
            if (firstLine.toString().length() != 69) {
                System.out.println("错误1！");
            }
            if (secondLine.toString().length() != 69) {
                System.out.println("错误2！");
            }
        }


    }
}