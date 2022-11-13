public class naturalSubject extends Subject {

    //polimorfizm

    private final String firstName;
    private final String lastName;
    private final String address;

    naturalSubject(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+System.getProperty("line.separator")+address+System.getProperty("line.separator");
    }
}
