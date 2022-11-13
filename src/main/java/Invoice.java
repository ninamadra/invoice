import java.util.ArrayList;

public class Invoice {

    //  Klasa ekspert wyliczajaca calkowita naleznosc
    //  Niskie sprzezenie- klasa pamieta tylko elementy, nie korzysta z ich wlasnosci
    //  Wysoka spojnosc- klasa zawiera same dane i logike

    private final String nr;
    private legalSubject issuer;
    private Subject customer;
    private final ArrayList<Element> elements;

    Invoice(String nr) {
        this.nr = nr;
        this.elements = new ArrayList<>();
    }

    public String getNr(){
        return nr;
    }

    public String getIssuer(){
        return issuer.toString();
    }

    public String getCustomer(){
        return customer.toString();
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setIssuer(legalSubject issuer) {
        this.issuer = issuer;
    }

    public void setCustomer(Subject customer) {
        this.customer = customer;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public double getTotal() {
        return elements.stream().mapToDouble(Element::getValue).sum();
    }

}
