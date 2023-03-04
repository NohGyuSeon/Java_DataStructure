package NGS.DataStructure.code.list3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyPolynomialApp {
	
	private Polynomial[] polys = new Polynomial[100];
	private int n = 0;
	private Scanner sc = new Scanner(System.in);
	
	public MyPolynomialApp() {
		
	}
	
	public void processCommand() {
		try {
			while(true) {
				System.out.print("$ ");
				String command = sc.next();
				if (command.equals("create")) { 
					handleCreate();
				} else if (command.equals("add")) {
					handleAdd();
				} else if (command.equals("calc")) {
	 				handleCalc();
				} else if (command.equals("print")) {
					handlePrint();
				} else if (command.equals("exit")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private void handleCreate() {
		char name = sc.next().charAt(0);
		Polynomial p = new Polynomial(name);
		polys[n++] = p;
	}
	
	private void handleAdd() {
		char name = sc.next().charAt(0);
		int coef = sc.nextInt();
		int expo = sc.nextInt();
		int index = find(name);
		if (index < 0) {
			throw new NoSuchElementException();
		}
		polys[index].addTerm(coef, expo);
	}
	
	private void handleCalc() {
		char name = sc.next().charAt(0);
		int x = sc.nextInt();
		int index = find(name);
		if (index < 0) {
			throw new NoSuchElementException();
		}
		System.out.println(polys[index].calc(x));
	}
	
	private int find(char name) {
		for(int i = 0; i < n; i++) {
			if (polys[i].name == name) {
				return i;
			}
		}
		return -1;
	}
	
	private void handlePrint() {
		char name = sc.next().charAt(0);
		int index = find(name);
		if (index < 0) {
			throw new NoSuchElementException();
		}
		System.out.println(polys[index].toString());
	}
	
	public static void main(String[] args) {
		MyPolynomialApp app = new MyPolynomialApp();
		app.processCommand();
	}
}
