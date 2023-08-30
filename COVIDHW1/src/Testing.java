public class Testing {
    public static void main(String[] args) {
        PurdueStudent student = new PurdueStudent("Name", "last name" ,"123", 3.10, "IN_STATE", false, "Engineering");
        double tut = student.calculateYearlyCost();
        System.out.println(tut);
    }
}
