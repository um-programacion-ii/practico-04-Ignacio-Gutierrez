package clase07.Excepciones;

public class StockInsuficiente extends Exception {
    public StockInsuficiente(String s) {
        super(s);
    }
}