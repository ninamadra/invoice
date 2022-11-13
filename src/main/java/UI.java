import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private final invoiceController invoiceController;

    public UI() {
        System.out.println("Tworzenie nowej faktury");
        this.invoiceController = new invoiceController(enterNr());
        UIRun();

    }

    private static String enterNr(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wprowadź numer faktury: ");
        return scanner.next();
    }

    private void UIRun() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(System.getProperty("line.separator")+"Wprowadź dane wystawiającego fakturę");
        System.out.print("Firma: ");
        String company = scanner.nextLine();
        System.out.print("Adres: ");
        String address = scanner.nextLine();
        System.out.print("NIP: ");
        String NIP = scanner.nextLine();
        invoiceController.setIssuer(company,address,NIP);

        System.out.println(System.getProperty("line.separator")+"Rodzaj podmiotu (wybierz 1 lub 2):");
        System.out.println("1. Osoba fizyczna");
        System.out.println("2. Osoba prawna");
        String prompt = scanner.nextLine();
        System.out.println();
        switch (prompt) {
            case "1" -> {
                System.out.print("Imię: ");
                String firstName = scanner.nextLine();
                System.out.print("Nazwisko: ");
                String lastName = scanner.nextLine();
                System.out.print("Adres: ");
                address = scanner.nextLine();
                invoiceController.setNaturalCustomer(firstName, lastName, address);
            }
            case "2" -> {
                System.out.print("Firma: ");
                company = scanner.nextLine();
                System.out.print("Adres: ");
                address = scanner.nextLine();
                System.out.print("NIP: ");
                NIP = scanner.nextLine();
                invoiceController.setLegalCustomer(company, address, NIP);
            }
        }

        while (true) {
            System.out.println(System.getProperty("line.separator")+"Wybierz akcję:");
            System.out.println("1. Dodaj artykuły");
            System.out.println("2. Wyświetl fakturę");
            System.out.println("3. Dodaj fakturę do bazy danych");
            System.out.println("4. Wyjdź");
            prompt = scanner.nextLine();
            switch (prompt) {
                case "1":
                    addElements();
                    break;
                case "2":
                    printInvoice();
                    break;
                case "3":
                    invoiceController.addToDB();
                    break;
                case "4":
                    return;
            }
        }
    }

    private void addElements() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(System.getProperty("line.separator")+"Dodawanie artykułu do faktury");
            System.out.print("Nazwa: ");
            String name = scanner.nextLine();
            System.out.print("Cena netto: ");
            String price = scanner.nextLine();
            System.out.print("Ilość: ");
            String quantity = scanner.nextLine();
            invoiceController.addElement(name, Double.parseDouble(price),Integer.parseInt(quantity));
            System.out.println(System.getProperty("line.separator")+"Czy dodać kolejny artykuł? (T/n)");
            String prompt;
            prompt = scanner.nextLine();
            switch (prompt) {
                case "N","n":
                    return;
                default: break;
            }
        }
    }

    public void printInvoice() {

        System.out.println(System.getProperty("line.separator")+"FAKTURA NR: " + invoiceController.getInvoiceNr()+System.getProperty("line.separator"));
        System.out.println("Sprzedawca:");
        System.out.println(invoiceController.getIssuerInfo());
        System.out.println("Nabywca:");
        System.out.println(invoiceController.getCustomerInfo());
        System.out.println("Towar/usługa            ilość           cena netto [zl]         wartość netto [zl] ");

        ArrayList<String> names = invoiceController.getElementsNames();
        ArrayList<Integer> quantities = invoiceController.getElementsQuantities();
        ArrayList<Double> prices = invoiceController.getElementsPrices();
        ArrayList<Double> values = invoiceController.getElementsValues();

        for ( int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i)+"                   "
                    +quantities.get(i)+"                   "
                    +prices.get(i)+"                   "
                    +values.get(i));
        }

        System.out.println(System.getProperty("line.separator")+"Razem: "+invoiceController.getTotal()+" zl");
    }

}
