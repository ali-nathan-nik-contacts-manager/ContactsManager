package ContactsManager;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;


public class Manager {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        String directory = "data";

        // Set directory
        Path dataFolder = Paths.get(directory);
        Path dataFile = Paths.get(directory, "contact.txt");


        // Creating a folder, check first if folder exist continue
        if(Files.notExists(dataFolder)){
            try {
                Files.createDirectories(dataFolder);
                System.out.println(dataFolder + " was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Create file, check if it exist first
        if(!Files.exists(dataFile)){
            try {
                Files.createFile(dataFile);
                System.out.println(dataFile + " file was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println(dataFile + " file already exists");
        }


        //
        List<String> updatedList = new ArrayList<>();

        try {
            List<String> namesFromFile = Files.readAllLines(dataFile);
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
            Files.write(dataFile, updatedList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(dataFile, Arrays.asList(addContact()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




      public void userChoice () {

          System.out.println(" 1. View contacts.\n" +
                  "        2. Add a new contact.\n" +
                  "        3. Search a contact by name.\n" +
                  "        4. Delete an existing contact.\n" +
                  "        5. Exit." +
                  " Enter an option (1, 2, 3, 4 or 5): "
          );
          int choice = scan.nextInt();

          switch(choice){

              case (1): {
                  displayContacts();
              }
              case (2): {
                  addContact();
                  break;
              }
              case (3):  {
                  System.out.println("Enter the name.");
                  String name = scan.nextLine();
                  contactByName("name");
                  break;
              }
              case(4): {
                  System.out.println("Enter the name.");
                  String name = scan.nextLine();
                  deleteContact("name");
              }
              case (5): {
                  System.out.println("Exiting application...");

              }
              default: {
                  System.out.println("Please enter a valid number of choice.");
                  userChoice();
              }
          }
      }


        String userChoice = scan.nextLine();





    // View Contacts
    public static void displayContacts(){
        // displays

    }

    //Get Data from User to Append to contact
    public static String addContact(){
        String contact;
        System.out.println("Enter contact name & number: ");
        System.out.println("Ex. First Name Last Name | 555.5555");
        contact = scan.nextLine();
        return contact;
    }

    // Search contact by name
    public static void contactByName(String name){
        // att by name
    }

    //delete Contact
    public static void deleteContact(String name){

    }
}