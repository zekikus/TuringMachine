import java.util.ArrayList;

public class TuringMachine {

	private String input;
	private Tape inputTape;
	private ArrayList<Transition> rules;
	private char startState;
	private char currentState;

	public TuringMachine(String input, char startState) {
		inputTape = new Tape(input);
		rules = new ArrayList<>();
		this.startState = startState;
		this.input = input;
	}

	public void addRule(Transition transition) {
		rules.add(transition);
	}

	public void start() {
		currentState = startState;
		Transition currentTrans = null;
		do {
			if (currentTrans != null)
				currentState = currentTrans.getNextState();
			currentTrans = checkRule(currentState);
		} while (currentTrans != null);

		if (currentState == 't')
			System.out.println(input + " - Kabul Edildi");
		else
			System.out.println(input + " - Kabul Edilmedi");
	}

	public Transition checkRule(char state) {
		Transition transition = null;
		for (Transition rl : rules) {
			if (rl.getCurrentState() == state) {
				if (rl.getReadCharacter() == inputTape.getCurrent()) {
					transition = rl;
					System.out.println(transition);
					inputTape.setCurrent(transition.getWriteCharacter());
					if (transition.getDimension() == 'L')
						inputTape.moveLeft();
					else if (transition.getDimension() == 'R')
						inputTape.moveRight();
					break;
				}
			}
		}

		return transition;
	}

	public static void main(String[] args) {
		TuringMachine machine = new TuringMachine("00011", 's');

		machine.addRule(new Transition('s', 'p', '0', 'X', 'R'));
		machine.addRule(new Transition('s', 'r', 'Y', 'Y', 'R'));
		machine.addRule(new Transition('p', 'p', '0', '0', 'R'));
		machine.addRule(new Transition('p', 'q', '1', 'Y', 'L'));
		machine.addRule(new Transition('p', 'p', 'Y', 'Y', 'R'));
		machine.addRule(new Transition('q', 'q', '0', '0', 'L'));
		machine.addRule(new Transition('q', 's', 'X', 'X', 'R'));
		machine.addRule(new Transition('q', 'q', 'Y', 'Y', 'L'));
		machine.addRule(new Transition('r', 'r', 'Y', 'Y', 'R'));
		machine.addRule(new Transition('r', 't', '#', '#', 'R'));

		machine.start();
	}

}
