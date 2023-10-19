package basics;

public class TestInstanceOf {

    public boolean checkIsInstance(String clazz, Object obj) {
        try {
            return Class.forName(clazz).isInstance(obj);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Integer i = new Integer(10);
        Boolean b = Boolean.TRUE;
        TestInstanceOf t = new TestInstanceOf();
        System.out.println(t.checkIsInstance("java.lang.Boolean", b));
        System.out.println(t.checkIsInstance("java.lang.Integer", i));
        System.out.println(t.checkIsInstance("java.lang.String", b));
        System.out.println(i instanceof Integer);
    }



}
