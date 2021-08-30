package aleksa;

public class MainClass {
	
	
	public static void main(String[] args) {
		MyString niz = new MyString();
		try {
			//niz.remove(2);
			niz.add('A', 1);
			niz.add('B', 1);
			niz.add('B', 1);
			niz.add('B', 1);
			niz.add('C', 1);
			niz.add('D', 1);
			niz.add('E', 1);
			niz.add('D', 1);
			niz.add('D', 1);
			niz.add('D', 1);
			niz.remove(2);
			niz.contain('A', 'A');
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(niz.toString());
		
	}
}
