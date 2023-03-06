public class Main {
    public static void main(String[] args) {
        System.out.println("Hel world!");
        List list = new List();
        list.AddToTail(5);
        list.AddToTail(6);
        list.AddToTail(4);
        list.AddToTail(2);
        list.AddToTail(0);
        list.PrintAllElements();
        System.out.println(list.ExtractionWithPos(5));
        list.PrintAllElements();
    }
}