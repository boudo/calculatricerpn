package calculatriceRPN;


public class DivivionParZeroException extends OperationImpossibleException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7198449933892840745L;

	public DivivionParZeroException() {
		super("Impossible de diviser par zéro");
	}

}
