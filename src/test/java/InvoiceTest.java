import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {

    private static Item item = new Item("item", 23.42);
    private static Item item2 = new Item("item2", 12.33);
    private static Element element = new Element(item,5);
    private static Element element2 = new Element(item2, 3);

    private static Invoice invoice = new Invoice("123");


    @BeforeAll
    static void init() {

        invoice.addElement(element);
        invoice.addElement(element2);

    }
    @Test
    public void addElement() {

        assertEquals(element, invoice.getElements().get(0));
        assertEquals(element2, invoice.getElements().get(1));

    }

    @Test
    public void getTotal() {
        assertEquals(23.42 * 5 + 12.33 * 3, invoice.getTotal());
    }
}
