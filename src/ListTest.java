import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testAddToHead() {
        List list = new List();
        list.AddToHead(5);
        assertEquals(5, list.GetElement());
        list.AddToHead(6);
        assertEquals(6, list.GetElement());
    }

    @org.junit.jupiter.api.Test
    void testAddToTail() {
        List list = new List();
        list.AddToTail(5);
        assertEquals(5, list.GetElement());
        list.AddToTail(6);
        assertEquals(6, list.GetElement(1));
    }

    @org.junit.jupiter.api.Test
    void testAddWithPos() {
        List list = new List();
        list.AddToHead(2);
        list.AddToHead(3);
        list.AddToHead(4);
        list.AddWithPos(1, 0);
        list.AddWithPos(6, 2);
        list.AddWithPos(8, 4);
        assertEquals(1, list.GetElement());
        assertEquals(6, list.GetElement(2));
        assertEquals(8, list.GetElement(4));
    }

    @org.junit.jupiter.api.Test
    void testGetCount() {
        List list = new List();
        assertEquals(0, list.GetCount());
        list.AddToHead(1);
        assertEquals(1, list.GetCount());
        list.AddToHead(1);
        list.AddToTail(1);
        list.AddWithPos(2, 2);
        assertEquals(4, list.GetCount());
        list.DeleteFromHead();
        assertEquals(3, list.GetCount());
        list.DeleteFromTail();
        list.DeleteWithPos(10);
        assertEquals(2, list.GetCount());
    }

    @org.junit.jupiter.api.Test
    void testGetElement() {
        List list = new List();
        list.AddToHead(5);
        list.AddToHead(2);
        list.AddToHead(3);
        list.AddToHead(0);
        assertEquals(0 , list.GetElement());
        assertEquals(5 , list.GetElement(3));
        assertEquals( Integer.MIN_VALUE, list.GetElement(5));
    }

    @org.junit.jupiter.api.Test
    void testDeleteFromHead() {
        List list = new List();
        list.AddToHead(6);
        list.AddToHead(1);
        list.AddToHead(2);
        assertEquals(true, list.DeleteFromHead());
        assertEquals(1, list.GetElement());
        assertEquals(true, list.DeleteFromHead());
        assertEquals(6, list.GetElement());
        assertEquals(true, list.DeleteFromHead());
        assertEquals(Integer.MIN_VALUE, list.GetElement());
        assertEquals(false, list.DeleteFromHead());
    }

    @org.junit.jupiter.api.Test
    void testDeleteFromTail() {
        List list = new List();
        list.AddToTail(6);
        list.AddToTail(1);
        list.AddToTail(2);
        assertEquals(true, list.DeleteFromTail());
        assertEquals(1, list.GetElement(1));
        assertEquals(true, list.DeleteFromTail());
        assertEquals(6, list.GetElement());
        assertEquals(true, list.DeleteFromTail());
        assertEquals(Integer.MIN_VALUE, list.GetElement());
        assertEquals(false, list.DeleteFromTail());
    }

    @org.junit.jupiter.api.Test
    void testDeleteWithPos() {
        List list = new List();
        list.AddToTail(6);
        list.AddToTail(1);
        list.AddToTail(2);
        list.AddToTail(3);
        list.AddToTail(4);
        assertEquals(true, list.DeleteWithPos(2));
        assertEquals(3, list.GetElement(2));
    }

    @org.junit.jupiter.api.Test
    void TestExtractionFromHead() {
        List list = new List();
        assertEquals(Integer.MIN_VALUE, list.ExtractionFromHead());
        list.AddToTail(5);
        list.AddToTail(2);
        assertEquals(5, list.ExtractionFromHead());
        assertEquals(2 , list.GetElement());
        assertEquals(2, list.ExtractionFromHead());
        assertEquals(Integer.MIN_VALUE , list.GetElement());
        assertEquals(Integer.MIN_VALUE , list.ExtractionFromHead());
    }

    @org.junit.jupiter.api.Test
    void testExtractionFromTail() {
        List list = new List();
        assertEquals(Integer.MIN_VALUE, list.ExtractionFromTail());
        list.AddToTail(2);
        list.AddToTail(5);
        assertEquals(5, list.ExtractionFromTail());
        assertEquals(2 , list.GetElement());
        assertEquals(2, list.ExtractionFromTail());
        assertEquals(Integer.MIN_VALUE , list.GetElement());
        assertEquals(Integer.MIN_VALUE , list.ExtractionFromTail());
    }

    @org.junit.jupiter.api.Test
    void extractionWithPos() {
        List list = new List();
        assertEquals(Integer.MIN_VALUE, list.ExtractionWithPos(0));
        assertEquals(Integer.MIN_VALUE, list.ExtractionWithPos(2));
        assertEquals(Integer.MIN_VALUE, list.ExtractionWithPos(-1));
        list.AddToTail(5);
        list.AddToTail(2);
        list.AddToTail(3);
        list.AddToTail(7);
        list.AddToTail(9);
        assertEquals(7, list.ExtractionWithPos(3));
        assertEquals( 9, list.GetElement(3));
        assertEquals(2, list.ExtractionWithPos(1));
        assertEquals(5 , list.ExtractionWithPos(0));
        assertEquals(Integer.MIN_VALUE , list.ExtractionWithPos(3));
    }
}