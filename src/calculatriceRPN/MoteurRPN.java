package calculatriceRPN;

import java.util.*;

public class MoteurRPN {
	
	private Stack<Double> _pile;
	public final double MAX_VALUE = Double.MAX_VALUE; /*1000000*/;
	public final double MIN_VALUE = /*Double.MIN_VALUE;*/ 0;
	
	public MoteurRPN() {
		_pile = new Stack<Double>();
	}
	
	public void ajouterOperande(double operande) throws OperandeTropPetitException, OperandeTropGrandException
	{
		if(operande < MIN_VALUE)
		{
			throw new OperandeTropPetitException();
		}
		else if(operande > MAX_VALUE)
		{
			throw new OperandeTropGrandException();
		}
		_pile.push(operande); //  L’intervalle de nombres supporté 
	}
	
	public void eval(Operation op) throws OperandeManquantException, DivivionParZeroException// Exception
	{
		double valPile1 = MIN_VALUE - 1;
		double valPile2 = MIN_VALUE - 1;
		try
		{
			double operande1 = _pile.pop(); valPile1 = operande1;
			double operande2 = _pile.pop(); valPile2 = operande2;
			if(operande1 == 0.0 && op.getOperation()=='/')
			{
				_pile.push(valPile2);
				_pile.push(valPile1);
				throw new DivivionParZeroException();
			}
			this.ajouterOperande(op.eval(operande2, operande1)); //  L’intervalle de nombres supporté
		}
		catch(EmptyStackException e)
		{
			if(valPile1 >= MIN_VALUE)
			{
				_pile.push(valPile1);
			}
			throw new OperandeManquantException();
		}
		catch(OperandeTropPetitException | OperandeTropGrandException e)
		{
			_pile.push(valPile2);
			_pile.push(valPile1);
			System.out.println(e.getMessage()+" "+valPile2+" "+op.getOperation()+" "+valPile1+" = "+op.eval(valPile2, valPile1));
		}
		 
	}
	
	public String afficher()
	{
		String contenu = "";
		for(double d : _pile)
		{
			contenu += d + " ";
		}
		return contenu;
	}
	
	public int getTaille()
	{
		return _pile.size();
	}
}
