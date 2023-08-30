public class Test {
    public static void main(String[] args) {
        OhioStateStudent ohioStateStudent = new OhioStateStudent();
        OhioStateStudent ohio = new OhioStateStudent();
        OhioStateStudent oh = new OhioStateStudent();
        OhioStateStudent hi = new OhioStateStudent();
        OhioStateStudent o = new OhioStateStudent();
        OhioStateStudent ohi = new OhioStateStudent();
        String oid = ohioStateStudent.generateID();
        String pod = ohio.generateID();
        String po = oh.generateID();
        String ohg = hi.generateID();
        String omg = o.generateID();
        String ah = ohi.generateID();
        System.out.println(oid);
        System.out.println(pod);
        System.out.println(po);
        System.out.println(ohg);
        System.out.println(omg);
        System.out.println(ah);
    }
}
