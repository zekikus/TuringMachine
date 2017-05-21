import java.util.Stack;

public class Tape {
	
	private Stack<Character> leftTape;
	private Stack<Character> rightTape; 
	private char current;
	
	public Tape(String input) {
		leftTape = new Stack<>();
		rightTape = new Stack<>();
		rightTape.push('#');
        for (int i = input.length() - 1; i >= 0; i--) {
            rightTape.push(input.charAt(i));
        }
        current = rightTape.pop();
	}
	
	public void moveLeft(){
		rightTape.push(current);
		if(leftTape.isEmpty())
			leftTape.push('#');
		current = leftTape.pop();
	}
	
	public void moveRight(){
		leftTape.push(current);
		if(rightTape.isEmpty())
			rightTape.push('#');
		current = rightTape.pop();
	}
	
	public Character getCurrent(){
		return current;
	}
	
	public void setCurrent(char nextChar) {
		this.current = nextChar;
	}
}
