package org.example.flyweight;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Style> styles = new ArrayList<>();
    static StyleFactory styleFactory = new StyleFactory();
    public static void main(String[] args)
    {
        createRandomStyle();

        for( Style s : styles)
            System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:\n1 - Create Document\n2 - Load Document\n3 - Quit");
        int option = scanner.nextInt();
        scanner.nextLine();

        String statement = "";
        String fileName = "";

//        String statement = "HelloWorldCS5800";
//        String fileName = "flyweight_file.csv";
//        String fileName = "src/main/java/org/example/flyweight/flyweight_file.csv";

        switch (option) {
            case 1: {
                System.out.println("Enter string");
                statement = scanner.nextLine();
                System.out.println("Enter file path");
                fileName = scanner.nextLine();
                createDocument(statement, fileName);
                break;
            }
            case 2: {
                System.out.println("Enter file path");
                fileName = scanner.nextLine();
                loadDocument(fileName);
                break;
            }
            case 3: {
                System.out.println("Exiting program...");
                break;
            }
            default:{
                System.out.println("Invalid selection.");
                break;
            }
        }

//        createDocument(statement, fileName);
//        loadDocument( fileName);

    }

    private static void createRandomStyle(){
        String[] colors = {"red", "green", "blue", "purple", "yellow", "black", "pink", "white"};
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randFontInt = random.nextInt(4); //4 possible fonts
            int randColorInt = random.nextInt(8);
            int randSize = random.nextInt(100);

            Style style = styleFactory.getStyle(randFontInt);
            style.setStyle(colors[randColorInt], randSize);

            styles.add(style);
        }
    }

    static void  createDocument(String statement, String fileName){
        File file = new File(fileName);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Letter", "Font", "Color", "Size" };
            writer.writeNext(header);

            // add data to csv
            for (int i = 0; i < statement.length(); i++) {
                int index = (int)(Math.random() * styles.size());
                Style randomStyle = styles.get(index);

                String[] data = new String[4];

                data[0] = String.valueOf(statement.charAt(i));
                data[1] = randomStyle.getFont();
                data[2] = randomStyle.getColor();
                data[3] = String.valueOf( randomStyle.getSize() );

            writer.writeNext(data);
            }
            System.out.println(fileName + " has been saved.");

            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void loadDocument( String fileName )
    {
        String statement = "";
        try {
            FileReader fileReader = new FileReader(fileName);

            CSVReader csvReader = new CSVReader(fileReader);

            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}