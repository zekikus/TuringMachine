
public class Transition {

	private char currentState;
	private char nextState;
	private char readCharacter;
	private char writeCharacter;
	private char dimension;

	public Transition(char currentState, char nextState, char readCharacter, char writeCharacter, char dimension) {
		this.currentState = currentState;
		this.nextState = nextState;
		this.readCharacter = readCharacter;
		this.writeCharacter = writeCharacter;
		this.dimension = dimension;
	}

	public char getCurrentState() {
		return currentState;
	}

	public void setCurrentState(char currentState) {
		this.currentState = currentState;
	}

	public char getNextState() {
		return nextState;
	}

	public void setNextState(char nextState) {
		this.nextState = nextState;
	}

	public char getReadCharacter() {
		return readCharacter;
	}

	public void setReadCharacter(char readCharacter) {
		this.readCharacter = readCharacter;
	}

	public char getWriteCharacter() {
		return writeCharacter;
	}

	public void setWriteCharacter(char writeCharacter) {
		this.writeCharacter = writeCharacter;
	}

	public char getDimension() {
		return dimension;
	}

	public void setDimension(char dimension) {
		this.dimension = dimension;
	}

	@Override
	public String toString() {
		return "Current State:" + currentState + " Read:" + readCharacter + " Next State:" + nextState + " Write:"
				+ writeCharacter + " Dimension:" + getDimension();
	}

}
