public class Calculator {
    private double prevResult;
    private int count;

    public Calculator(){
    }

    public int add(int a, int b){
        int result = a + b;
        setPrevResult(result);
        updateCount();
        return result;
    }

    public int subtract(int a, int b){
        int result = a - b;
        setPrevResult(result);
        updateCount();
        return result;
    }

    public int multiply(int a, int b){
        int result = a*b;
        setPrevResult(result);
        updateCount();
        return result;

    }

    public double divide(int a, int b){
        double c = a;
        double d = b;
        double result = c/d;
        setPrevResult(result);
        updateCount();
        return result;
    }

    public double calculateCircleArea(int r){
        double s = r;
        double result = Math.PI * s * s;
        setPrevResult(result);
        updateCount();
        return result;

    }

    public int calculatePower(int a, int x){
        int i = 1;
        int h = a;
        while(i < x){
            h = h*a;
            ++i;
        }
        int result = h;
        setPrevResult(result);
        updateCount();
        return result;
    }

    public double getPrevResult() {
        return prevResult;
    }

    public void setPrevResult(double prevResult) {
        this.prevResult = prevResult;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void updateCount(){
        this.count = ++count;
    }

}
