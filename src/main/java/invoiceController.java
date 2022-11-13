import java.util.ArrayList;

public class invoiceController {

    //  Klasa kreator produkujaca fakture, poniewaz bezposrednio jej uzywa
    //  Klasa kreator dla faktury, elementu i towaru, poniewaz posiada dane inicjalizujace
    //  Niskie sprzezenie- klasa pamieta tylko fakture, nie jej wlasnosci
    //  Wysoka spojnosc- klasa realizuaca komunikacje, wywolujaca logike klasy faktura
    //  Klasa kontroler

    private final Invoice invoice;
    private final invoiceService invoiceService;

    invoiceController(String nr) {
        invoice = new Invoice(nr);
        invoiceService = new invoiceService(new invoiceRepository());
    }

    public void addToDB() {
        invoiceService.add(invoice);
    }

    public void addElement(String name, double price, int quantity ) {
        invoice.addElement(new Element(new Item(name, price), quantity));
    }

    public void setIssuer(String company, String address, String NIP) {
        invoice.setIssuer(new legalSubject(company, address, NIP));
    }

    public void setNaturalCustomer(String firstName, String lastName, String address) {
        invoice.setCustomer(new naturalSubject(firstName, lastName, address));
    }

    public void setLegalCustomer(String company, String address, String NIP) {
        invoice.setCustomer(new legalSubject(company, address, NIP));
    }

    public String getInvoiceNr() {
        return invoice.getNr();
    }

    public String getIssuerInfo() {
        return invoice.getIssuer();
    }

    public String getCustomerInfo() {
        return invoice.getCustomer();
    }

    public ArrayList<String> getElementsNames() {

        ArrayList<Element> elements = invoice.getElements();
        ArrayList<String> names = new ArrayList<>();
        elements.forEach((element) -> names.add(element.getItem().getName()));
        return names;
    }

    public ArrayList<Integer> getElementsQuantities() {

        ArrayList<Element> elements = invoice.getElements();
        ArrayList<Integer> quantities = new ArrayList<>();
        elements.forEach((element) -> quantities.add(element.getQuantity()));
        return quantities;
    }

    public ArrayList<Double> getElementsPrices() {

        ArrayList<Element> elements = invoice.getElements();
        ArrayList<Double> prices = new ArrayList<>();
        elements.forEach((element) -> prices.add(element.getItem().getPrice()));
        return prices;
    }

    public ArrayList<Double> getElementsValues() {

        ArrayList<Element> elements = invoice.getElements();
        ArrayList<Double> values = new ArrayList<>();
        elements.forEach((element) -> values.add(element.getValue()));
        return values;
    }

    public double getTotal() {
        return invoice.getTotal();
    }

}
