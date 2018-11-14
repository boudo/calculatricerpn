package calculatriceRPN;

import java.util.Scanner;

public class SaisieRPN {
	
	MoteurRPN _mrpn;
	
	public SaisieRPN()
	{
		_mrpn = new MoteurRPN();
	}
	
	public void interUtilisateur()
	{
		Scanner _sc = new Scanner(System.in);
		String saisie = _sc.nextLine();
		Double d;
		while (!saisie.equals("exit"))
		{
			try 
			{
				if(saisie.equals("+"))
				{
					_mrpn.eval(Operation.PLUS);
				}
				else if(saisie.equals("-"))
				{
					_mrpn.eval(Operation.MOINS);
				}
				else if(saisie.equals("*"))
				{
					_mrpn.eval(Operation.MULT);
				}
				else if(saisie.equals("/"))
				{
					_mrpn.eval(Operation.DIV);
				}
				else
				{
					d = new Double(saisie);
					_mrpn.ajouterOperande(d);
				}
			}
			catch(OperandeManquantException | DivivionParZeroException e)
			{
				System.out.println(e.getMessage());
			}
			catch(OperandeTropPetitException | OperandeTropGrandException e)
			{
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e)
			{
				System.out.println("saisie incorrecte (Entrez une opérande ou une opération ou exit pour quitter)");
			}
			finally {
				System.out.println(_mrpn.afficher());
				saisie = _sc.nextLine();
			}
						
		}
		_sc.close();
	}
	

}

