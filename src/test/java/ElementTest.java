import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private static Item item = new Item("item", 23.42);
    private static Element element = new Element(item,5);


    @Test
    public void getValue() {
        assertEquals(23.42 * 5, element.getValue());
    }
}