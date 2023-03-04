package NGS.DataStructure.pratice.list3;

import java.util.Iterator;

public class Polynomial {
	public char name;
	public MySingleLinkedList<Term> terms;

	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<>();
	}

	public void addTerm(int coef, int expo) {
	}
	
	public int calc(int x) {
		int result = 0;
		Iterator<Term> iter = terms.iterator();
		while (iter.hasNext()) {
			Term t = iter.next();
			result += t.calc(x);
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "";
		Iterator<Term> iter = terms.iterator();
		while (iter.hasNext()) {
			Term t = iter.next();
			result += ("+" + t.toString());
		}
		return result;
	}

}
