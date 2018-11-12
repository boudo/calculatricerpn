package calculatriceRPN;

public enum Operation {
	PLUS('+')
	{
		@Override
		public double eval(double operande1, double operande2)
		{
			return operande1 + operande2;
		}
	},
	MOINS('-')
	{
		@Override
		public double eval(double operande1, double operande2)
		{
			return operande1 - operande2;
		}
	},
	MULT('*')
	{
		@Override
		public double eval(double operande1, double operande2)
		{
			return operande1 * operande2;
		}
	},
	DIV('/')
	{
		@Override
		public double eval(double operande1, double operande2)
		{
			return operande1 / operande2;
		}
	};
	
	private char _symbole;
	
	Operation(char symbole)
	{
		_symbole = symbole;
	}
	
	public abstract double eval(double operande1, double operande2);
	
	public char getOperation()
	{
		return _symbole;
	}
}
