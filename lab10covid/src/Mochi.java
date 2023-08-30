public class Mochi extends Desert {

    public Mochi(String description){
        super(description);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public double calculatePrice(int amount) {
        double dAmount = amount;
        if (amount < 6) {
            return dAmount;
        } else if (amount > 6){
        }
        return dAmount*.75;
    }
}
