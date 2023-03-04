package NGS.DataStructure.code.list2;

import NGS.DataStructure.code.list1.MySingleLinkedList;
import NGS.DataStructure.code.list1.Node;

public class Polynomial {

	public char name;
	public MySingleLinkedList<Term> terms;

	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<>();
	}
	
	/*
	 * 기존의 다항식에 새로운 항을 추가하는 메서드
	 * 두 가지 경우
	 * - 추가하려는 항과 동일 차수의 항이 이미 있는 경우: 기존 항의 계수만 변경
	 * - 새로운 항을 삽입해야 하는 경우: 단일 연결리스트에서 어떠한 노드 앞에 새로운 노드를
	 * 삽입하기 위해서는 이 앞 노드의 주소가 필요하다.
	 */
	public void addTerm(int coef, int expo) {
		if (coef == 0)
			return;
		
		Node<Term> p = terms.head, q = null;
		while (p != null && p.data.expo > expo) {
			q = p;
			p = p.next;
		}
		
		if (p != null && p.data.expo == expo) {
			p.data.coef += coef;
			if (p.data.coef == 0) {
				if (q == null) {
					terms.removeFirst();
				} else {
					terms.removeAfter(q);
				}
			}
		} else {
			Term t = new Term(coef, expo);
			if (q == null) {
				terms.addFirst(t);
			} else {
				terms.addAfter(q, t);
			}
		}
	}
	
	public int calc(int x) {
		int result = 0;
		Node<Term> p = terms.head;
		while (p != null) {
			result += p.data.calc(x);
			p = p.next;
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<Term> p = terms.head;
		while (p != null) {
			sb.append("+" + p.data.toString());
			p = p.next;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
	}
	
}
