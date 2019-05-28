package ContactsManager;


public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contacts)) {
            return false;
        }
        Contacts contact = (Contacts) obj;
        return contact.name.equals(this.name) && contact.number.equals(this.number);
    }
}

