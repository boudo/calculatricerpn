package calculatriceRPN;

public enum CalculatriceRPN {
	CALCULATRICE(new SaisieRPN());
	
	private SaisieRPN _srpn;
	
	CalculatriceRPN( SaisieRPN srpn)
	{
		_srpn = srpn;
	}
	public void on()
	{
		_srpn.interUtilisateur();
	}
	
	public static void main(String[] args) {
		
		CalculatriceRPN.CALCULATRICE.on();
	}

}
