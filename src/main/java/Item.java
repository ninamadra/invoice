public class Item {

    // Wysoka spojnosc- klasa zawiera same dane i logike
    //  Protected variations- wrappery na prywatne pola klasy

    private final String name;
    private final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
