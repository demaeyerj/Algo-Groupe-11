package mission.one;

import java.util.Stack;

public class PostScript {

	/**
	 * @pre
	 * @post imprime le contenu de toute la pile s;
	 */
	public void pstack(Stack s) {
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}

	/**
	 * @pre
	 * @post remplace les deux premiers elements de la stack par leur somme
	 */
	public void add(Stack s) {
		double temp = (double) s.pop() + (double) s.pop();
		s.push(temp);
	}

	/**
	 * @pre
	 * @post remplace les deux premiers elements de la stack par leur différence
	 */
	public void sub(Stack s) {
		double temp = (double) s.pop() - (double) s.pop();
		s.push(temp);
	}

	/**
	 * @pre
	 * @post remplace les deux premiers elements de la stack par leur
	 *       multiplication
	 */
	public void mul(Stack s) {
		double temp = (double) s.pop() * (double) s.pop();
		s.push(temp);
	}

	/**
	 * @pre
	 * @post remplace les deux premiers elements de la stack par leur division
	 */
	public void div(Stack s) {
		double temp = (double) s.pop() / (double) s.pop();
		s.push(temp);
	}
	
	/**
	 * 
	 * @post Teste si les deux premiers elements de la stack ne sont pas egaux
	 */
	public void ne(Stack s){
		if(s.size()>2){
			boolean temp = (double) s.pop()!=(double) s.pop();
			s.push(temp);
		}
	}
	
	/**
	 * 
	 * @post Teste si les deux premiers elements de la pile sont egaux
	 */
	public void eq(Stack s){
		if(s.size()>2){
			boolean temp = (double) s.pop()==(double) s.pop();
			s.push(temp);
		}
	}
	
	/**
	 * @pre 
	 * @post Echange la place des deux elements top de la stack
	 */
	public void exch(Stack s) {
		if(s.size()>2){
			double temp1= (double) s.pop();
			double temp2= (double) s.pop();
			s.push(temp1);
			s.push(temp2);
		}
	}
	
	/**
	 * 
	 * @post push une copie du "top element" de la stock au somment de celle-ci
	 */
	public void dup(Stack s) {
		if(s.isEmpty()!=true){
			double temp= (double) s.peek();
			s.push(temp);
		}
	}
	
	/**
	 * @pre 
	 * @post retire le "top element" de la stack
	 */
	public void pop(Stack s){
		if(s.isEmpty()!=true){
			s.pop();
		}
	}
	
	/**
	 * @pre: argument ligne non null
	 * @post: decode et execute les instructions presentes dans le String ligne.
	 */
	public void decode(String ligne) {
		assert ligne != null : "argument String ligne == null.";
		String Elem[] = ligne.split(" ");
		Stack DStack = new Stack(); // TODO , initialiser comme dans la def.
		for (int i = 0; i < Elem.length; i++) {
			switch (Elem[i]) {
			case "pstack":
				pstack(DStack);
				break;
			case "add":
				add(DStack);
				break;
			case "sub":
				sub(DStack);
				break;
			case "mul":
				mul(DStack);
				break;
			case "div":
				div(DStack);
				break;
			case "dup":
				dup(DStack);
				break;
			case "exch":
				exch(DStack);
				break;
			case "eq":
				eq(DStack);
				break;
			case "ne":
				ne(DStack);
				break;
			case "def":
				def(DStack);
				break;
			case "pop":
				pop(DStack);
				break;
			default:
				DStack.push(Elem[i]);
				break;
			}
		}
	}
}
