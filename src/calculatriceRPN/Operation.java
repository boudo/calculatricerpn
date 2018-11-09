package calculatriceRPN;

public enum Operation {
	PLUS('+')
	{
		@Override
		double eval(double operande1, double operande2)
		{
			return operande1 + operande2;
		}
	},
	MOINS('-')
	{
		@Override
		double eval(double operande1, double operande2)
		{
			return operande1 - operande2;
		}
	},
	MULT('*')
	{
		@Override
		double eval(double operande1, double operande2)
		{
			return operande1 * operande2;
		}
	},
	DIV('/')
	{
		@Override
		double eval(double operande1, double operande2)
		{
			//Exception si operande2 = 0 
			return operande1 / operande2;
		}
	};
	
	private char _symbole;
	
	Operation(char symbole)
	{
		_symbole = symbole;
	}
	
	abstract double eval(double operande1, double operande2);
	
	public char getOperation()
	{
		return _symbole;
	}
}
