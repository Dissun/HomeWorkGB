import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] thing = {"table", "pen", "bucket", "table", "book", "plate", "pencil", "spoon", "plate", "candle", "knife"};
        HashMap<String, Integer> something = new HashMap<>();
        for (String x : thing) {
            something.put(x, something.getOrDefault(x,0)+1);
        }
        System.out.println(something);



        namePhone book = new namePhone();
        book.addContact("Smith", "01233387");
        book.addContact("Richardson", "1023429");
        book.addContact("Summerset", "00013182");
        book.addContact("Parker", "0210989");
        book.addContact("Parker", "9999999");
        book.addContact("Hollifield", "0101983");

        book.findAndPrint("Smith");
        book.findAndPrint("Parker");
        book.findAndPrint("Richardson");
    }
}