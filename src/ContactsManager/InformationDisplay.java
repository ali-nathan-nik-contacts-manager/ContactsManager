package ContactsManager;
import java.util.*;

public class InformationDisplay {
    private static final String contactsFormat = "| %-10s | %10s |\n ";

    public static void error(String message) {
        System.out.println("Error Message: " + message);
    }
    public static void error() {
        error("Error");
    }

    public static void showContacts(List<Contacts> contacts) {
        if (contacts.isEmpty()) {
            System.out.format("No %s found by that name ", contacts);
            return;
        }
        System.out.printf(contactsFormat, "Contact", "#");
        System.out.printf(contactsFormat, "========", "========");
        for (Contacts contact : contacts) {
            System.out.printf(contactsFormat, contact.getName(), contact.getNumber());
        }
    }

    public static void welcome() {
        System.out.println("            .'\\   /`.\n" +
                "         .'.-.`-'.-.`.\n" +
                "    ..._:   .-. .-.   :_...\n" +
                "  .'    '-.(o ) (o ).-'    `.\n" +
                " :  _    _ _`~(_)~`_ _    _  :\n" +
                ":  /:   ' .-=_   _=-. `   ;\\  :\n" +
                ":   :|-.._  '     `  _..-|:   :\n" +
                " :   `:| |`:-:-.-:-:'| |:'   :\n" +
                "  `.   `.| | | | | | |.'   .'\n" +
                "    `.   `-:_| | |_:-'   .'\n" +
                " jgs  `-._   ````    _.-'\n" +
                "          ``-------''");
    }

    public static void showMenu() {
        System.out.println("1 - View Contacts");
        System.out.println("2 - Add A Contact");
        System.out.println("3 - Search Contacts");
        System.out.println("4 - Remove A Contact");
        System.out.println("5 - Exit");
        System.out.print("Enter an option (1, 2, 3, 4 or 5):\n");
    }

    public static void goodbye() {
        System.out.println("Thank you for using Contacts Manager!");
        System.out.println(" ");
    }
}
