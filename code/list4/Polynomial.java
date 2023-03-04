package NGS.DataStructure.code.list4;

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

	public char name;
	public LinkedList<Term> terms;

	public Polynomial(char name) {
		this.name = name;
		terms = new LinkedList<Term>();
	}

	/*
	 * 기존의 다항식에 새로운 항을 추가하는 메서드 두 가지 경우 - 추가하려는 항과 동일 차수의 항이 이미 있는 경우: 기존 항의 계수만 변경
	 * - 새로운 항을 삽입해야 하는 경우: 단일 연결리스트에서 어떠한 노드 앞에 새로운 노드를 삽입하기 위해서는 이 앞 노드의 주소가 필요하다.
	 */
	public void addTerm(int coef, int expo) {
		if (coef == 0) {
			return;
		}
		
		ListIterator<Term> iter = terms.listIterator();
		while (iter.hasNext()) {
			Term t = iter.next();
			if (t.expo == expo) {
				t.coef += coef;
				if (t.coef == 0) {
					iter.remove();
				} else if (t.coef < expo) {
					iter.previous();
					iter.add(new Term(coef, expo));
					return;
				}
			}
			iter.add(new Term(coef, expo));
		}
	}
	
	public int calc(int x) {
		int result = 0;
		for (Term term : terms) {
			result += term.calc(x);
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (Term term : terms) {
			result += ("+" + term.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {

	}

}
