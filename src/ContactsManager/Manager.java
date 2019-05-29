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
        userChoice();
    }

    ////// E N D OF M A I N ///////

    public static void userChoice() {

        System.out.println("----------Choose------------");
        System.out.println(
                        " 1. View contacts.\n" +
                        " 2. Add a new contact.\n" +
                        " 3. Search a contact by name.\n" +
                        " 4. Delete an existing contact.\n" +
                        " 5. Exit." +
                        "  "
        );
        System.out.println("-----------------------------");


        int choice = scan.nextInt();

        switch (choice) {

            case (1): {
                displayContacts();
                userChoice();
                break;
            }
            case (2): {
                addContact();
                userChoice();
                break;
            }
            case (3): {
                contactByName();
                userChoice();
                break;
            }
            case (4): {
                deleteContact();
                userChoice();
                break;
            }
            case (5): {
                goodBye();
                break;

            }
            default: {
                System.out.println("Please enter a valid number of choice.");
                userChoice();
            }
        }
    }

    String userChoice = scan.nextLine();

    public static void folderFile() {
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
    public static void displayContacts() {

        List<String> contactList = new ArrayList<>();

        try {
            List<String> fullContactList = Files.readAllLines(dataFile);
            System.out.println("|----------------------------|");
            System.out.println("|          Contacts          |");
            System.out.println("|----------------------------|");
            for (String contact : fullContactList) {
                System.out.println("| " + contact + "  |");
            }
            System.out.println("----------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public static void contactByName() {
        List<Contact> searchedContact = new ArrayList<>();
        // Initiate scanner
        Scanner searchName = new Scanner(System.in);
        System.out.println("Search by first name: ");
        String searchFirstName = searchName.next();

        try {
            List<String> SearchList = Files.readAllLines(dataFile);
            // Loop through the data file contact.txt
            System.out.println("|----------------------------|");
            System.out.println("|          Results           |");
            System.out.println("|----------------------------|");
            for (String contact : SearchList) {
                if(contact.contains(searchFirstName)) {
                    System.out.println("Contact: " + contact);
                }
            }
            System.out.println(" ");
        } catch (Exception e) {
            System.out.println("FullContactsList Exception: " + e);
        }
    }

    //Delete Contact
    public static void deleteContact() {
        List<String> contactList = new ArrayList<>();
        Scanner deleteName = new Scanner(System.in);
        System.out.println("Delete User from list: ");
        String contactDel = deleteName.nextLine();

        try {
            List<String> fullContactList = Files.readAllLines(dataFile);
            for (String contact : fullContactList) {
                System.out.println(contact);
                if (contact.equalsIgnoreCase(contactDel))
                    fullContactList.remove(contactDel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goodBye() {
        System.out.println("Exiting...");
    }
}