public class Baklava extends Desert {
    @Override
    public double calculatePrice(int amount) {
        return amount*2;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    public Baklava(String description){
        super(description);
    }
}
