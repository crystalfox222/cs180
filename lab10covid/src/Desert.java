public abstract class Desert {
    private String description;
    public Desert(String description){
        this.description = description;
    }
    public abstract double calculatePrice();
    public double calculatePrice(int amount){
        double b = amount;
        return b;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
