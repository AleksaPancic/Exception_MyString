package aleksa;

import java.util.Iterator;
import java.util.Vector;


//Samo moja verzija koda, ne znaci da je validna.
public class MyString {
	private Vector<Character> niz = new Vector<Character>();
	private Vector<Character> pomniz = new Vector<Character>();
	private Vector<Integer> times = new Vector<Integer>();
	
	
	public void add(char c, int  x) throws DownCaseException, OutOfRangeException,InvalidInputException { //Done
		if(niz.size() == 200) {
			throw new OutOfRangeException("Vector has reached a limit of 200");
		}
		boolean ValidUpperCase;
		ValidUpperCase = Character.isUpperCase(c);
		if(!ValidUpperCase) {
			throw new DownCaseException("Invalid Char " + " ("+ c + ") " + " Only supports uppercase English Alphabet");
		}
		
		if(x == 1) {
			niz.add(c);
		}else if(x == -1) {
			niz.add(0, c); //sve muke zamenjene jednim pozivom funkcijom, dole je moj pokusaj da se zakomplikuje problem
		}else
			throw new InvalidInputException("Input of x is only -1 or 1. Your input: " + x);	
	}
	
	public void remove(int k) throws OutOfRangeException{ //pain in the ass but Done
		if(niz.isEmpty()) {
			throw new OutOfRangeException("Vector is empty");
		}
		int numberoftimes = 0;
		for(int i = 0; i < niz.size(); i++) {
			numberoftimes = 0;
			for(int j = i + 1; j < niz.size(); j++) {
				if(niz.get(i) == niz.get(j)) {
					numberoftimes++;
				}
			}
			if(numberoftimes > k) {
				pomniz.add(niz.get(i));
				times.add(numberoftimes);
			}
		}
		if(pomniz.isEmpty()) throw new OutOfRangeException("Invalid remove operation");
		int najmanji = times.get(0);
		int indeks = 0;
		for(int i = 1; i < times.size(); i++) {
			if(times.get(i) < najmanji) {
				indeks = i;
			}
		}
		Iterator<Character> it = niz.iterator();
		while(it.hasNext()) {
			if(it.next() == pomniz.get(indeks)) {
				it.remove();
			}
		}
	}
	
	public Boolean contain(char c1, char c2) throws DownCaseException, OutOfRangeException { //done
		if(niz.isEmpty()) {
			throw new OutOfRangeException("Vector is empty");
		}
		if(Character.isUpperCase(c1) && Character.isUpperCase(c2)) {
			Iterator<Character> it = niz.iterator();
			char c;
			while(it.hasNext()) {
				c = (char) it.next();
				if(c > c1 && c < c2) {
					System.out.println("true"); //test samo da li radi ok.
					return true;
				}
			}
		} else throw new DownCaseException("c1 or c2 are not upper case Alphabet characters" + c1 + " " + c2);
		System.out.println("false"); //test samo da li radi ok.
		return false;
	}
	
	@Override
	public String toString() {
		String s = " ";
		for(int i = 0; i < niz.size(); i++) {
			s = s + niz.get(i);
			if(i!=niz.size()-1) {
				s = s + " ";
			}
		}
		return s;
	}
	
	
}


/*else if(x == -1) {
			pomniz.add(c); //na pocetku prazan. Ok
			for(int i = 0; i < niz.size(); i++) { //mozda komplikovan nacin sa vecom vremenskom slozenoscu ali prvo sam se njega setio
				pomniz.add(niz.get(i)); //dodajem sve elementi niza u podniz
				niz.remove(i); //brisem svaki element niza
			}
			for(int i = 0; i < pomniz.size(); i++) { //prolazim ceo podniz
				niz.add(pomniz.get(i)); //nizu dodajem sve elemente podniza 
			} //ne radi na kraju iz nekog razloga....
		}*/


//Pancic Aleksa 121