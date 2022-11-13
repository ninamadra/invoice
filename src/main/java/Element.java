public class Element {

    //  Klasa ekspert wyliczajaca naleznosc za wielokrotnosci tego samego produktu
    //  Niskie sprzezenie- klasa pamieta tylko towar, nie jego wlasnosci
    //  Wysoka spojnosc- klasa zawiera same dane i logike
    //  Protected variations- wrappery na prywatne pola klasy

    private final Item item;
    private final int quantity;

    Element(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return item.getPrice() * quantity;
    }
}
