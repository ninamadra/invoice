public class legalSubject extends Subject {

    // polimorfizm

    private final String company;
    private final String address;
    private final String NIP;

    legalSubject(String company, String address, String NIP) {
        this.company = company;
        this.address = address;
        this.NIP = NIP;

    }

    @Override
    public String toString() {
        return company+System.getProperty("line.separator")+address+System.getProperty("line.separator")+NIP+System.getProperty("line.separator");
    }
}
