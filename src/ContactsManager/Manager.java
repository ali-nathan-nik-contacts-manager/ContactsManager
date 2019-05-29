package ContactsManager;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Manager {
    static String directory = "data";
    static Path dataFolder = Paths.get(directory);
    static Path dataFile = Paths.get(directory, "contact.txt");

    /////////// M A I N /////////////

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {




        // Append New Contact
//        List<String> updatedList = new ArrayList<>();
//
//        try {
//            List<String> namesFromFile = Files.readAllLines(dataFile);
//
//            for (String line : namesFromFile) {
//
//                String name = line.split(" ")[0];
//                int PhoneNumber = Integer.parseInt(line.split(" ")[0]);
//
//                System.out.println("Name " + " | " + "Number");
//                System.out.println(name + " | " + PhoneNumber);
//
//                if (name.equalsIgnoreCase("ryan")) {
//                    updatedList.add(name + " " + 35);
//                    continue;
//                }
//
//                updatedList.add(line);
//            }
//
//            Files.write(dataFile, updatedList);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Files.write(dataFile, Arrays.asList(addContact()), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        userChoice();
    }

    ////// End of Main ///////


    //CLI
    public static void userChoice() {

        System.out.println("Welcome to Contacts Manager!");

        System.out.println(
                " 1. View contacts.\n" +
                        "        2. Add a new contact.\n" +
                        "        3. Search a contact by name.\n" +
                        "        4. Delete an existing contact.\n" +
                        "        5. Exit." +
                        " Enter an option (1, 2, 3, 4 or 5): "
        );

        int choice = scan.nextInt();

        switch (choice) {

            case (1): {
                displayContacts();
            }
            case (2): {
                addContact();
                break;
            }
            case (3): {
                contactByName("name");
                break;
            }
            case (4): {
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

    public static void folderFile(){
        // Creating a folder, check first if folder exist continue
        if (Files.notExists(dataFolder)) {
            try {
                Files.createDirectories(dataFolder);
                System.out.println(dataFolder + " was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Create file, check if it exist first
        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
                System.out.println(dataFile + " file was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(dataFile + " file already exists");
        }
    }

    // Display Contacts
    public static ArrayList<Contact> displayContacts() {

        ArrayList<Contact> contacts = new ArrayList<>();

        try {
            List<String> FullContactsList = Files.readAllLines(dataFile);
            for (int i = 0; i < FullContactsList.size(); i++) {
                System.out.println(FullContactsList);
            }
        } catch (Exception e) {
            System.out.println("FullContactsList Exception: " + e);
        }
        return contacts;
    }


    //Get Data from User to Append to contact
    public static void addContact() {
        Scanner choice = new Scanner(System.in);
        System.out.println("Enter contact name & number: ");
        System.out.println("Ex. First Name Last Name | 555.5555");
        String contact = choice.nextLine();

        try {
            Files.write(dataFile, Arrays.asList(contact), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userChoice();
    }

    // Search contact by name
    public static void contactByName(String name) {

    }

    //delete Contact
    public static void deleteContact(String name) {

    }
}