package ContactsManager;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {

    public static void main(String[] args) {
        // Menu

        String directory = "data";
        Path folder = Paths.get(directory);
        Path file = Paths.get(directory, "info.txt");

        if(Files.notExists(folder)){
            try {
                Files.createDirectories(folder);
                System.out.println(folder + " was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!Files.exists(file)){
            try {
                Files.createFile(file);
                System.out.println(file + " file was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println(file + " file already exists");
        }

//        List<String> names = Arrays.asList("Fer 29", "Daniel 35", "Justin 35", "Sophie 26", "David 26");
//
//        try {
//            Files.write(file, names);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        List<String> updatedList = new ArrayList<>();

        try {
            List<String> namesFromFile = Files.readAllLines(file);
            for (String line: namesFromFile) {

                String name = line.split(" ")[0];
                int age = Integer.parseInt(line.split(" ")[1]);

                System.out.println("name " + " | " + "Number");
                System.out.println(name + " | " + age);

                if(name.equalsIgnoreCase("ryan")){
                    updatedList.add(name + " " + 35);
                    continue;
                }
                updatedList.add(line);


            }

            Files.write(file, updatedList);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Files.write(file, Arrays.asList("Ryan " + 40), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}