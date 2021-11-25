package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
public List<Integer> readFile(String filePath){
    List<Integer> integerList = new ArrayList<>();
    try {
        File file = new File(filePath);
        if(!file.exists())  {
            System.out.println("vao if");
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            System.out.println("vao while");
//            System.out.println("line  = "+line);
            integerList.add(Integer.parseInt(line));
//            System.out.println(integerList);
        }
        bufferedReader.close();
    } catch (Exception e){

    }
    return integerList;
}
    public  int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max =  " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	// write your code here

        Main main = new Main();

        List<Integer> numbers = main.readFile("E:\\CODEGYM\\C0921K1\\untitled5\\src\\com\\company\\file\\list-number.txt");
        System.out.println(numbers);
        int maxValue = main.findMax(numbers);
        System.out.println("Max = "+maxValue);
        main.writeFile("E:\\CODEGYM\\C0921K1\\untitled5\\src\\com\\company\\file\\list-number.txt", maxValue);
    }
}
