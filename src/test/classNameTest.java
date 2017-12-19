package test;

public class classNameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String TEST = "test";
		
		System.out.println(TEST.getClass().getName());
		System.out.println(TEST.getClass().getSimpleName());
		
		Tttt tt = new Tttt();
		Class cls = Cccc.class;
		
		System.out.println(Tttt.class.getName());
		System.out.println(Tttt.class.getSimpleName());
		
		System.out.println(Tttt.class.isAssignableFrom(cls));
		System.out.println(Tttt.class.equals(tt.getClass()));
		System.out.println(Tttt.class.getEnumConstants());
	}
	
}

class Tttt {
	String aaa;
}

class Cccc {
	String aaa;
}