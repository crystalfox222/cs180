public class Skyr extends Desert {

    public Skyr(String description){
        super(description);
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

    @Override
    public double calculatePrice() {
        return 0;
    }
}
