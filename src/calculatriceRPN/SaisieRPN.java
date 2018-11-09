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
			if(saisie.equals("+"))
			{
				try
				{
					System.out.println(_mrpn.afficher() + "+ ");
					_mrpn.eval(Operation.PLUS);
					System.out.println(_mrpn.afficher());
				}catch(OperandeManquantException | DivivionParZeroException e)
				{
					System.out.println(e.getMessage());
				}
				
			}
			else if(saisie.equals("-"))
			{
				try
				{
					System.out.println(_mrpn.afficher() + "- ");
					_mrpn.eval(Operation.MOINS);
					System.out.println(_mrpn.afficher());
				}catch(OperandeManquantException | DivivionParZeroException e)
				{
					System.out.println(e.getMessage());
				}
				
			}
			else if(saisie.equals("*"))
			{
				try
				{
					System.out.println(_mrpn.afficher() + "* ");
					_mrpn.eval(Operation.MULT);
					System.out.println(_mrpn.afficher());
				}catch(OperandeManquantException | DivivionParZeroException e)
				{
					System.out.println(e.getMessage());
				}
				
			}
			else if(saisie.equals("/"))
			{
				try
				{
					System.out.println(_mrpn.afficher() + "/ ");
					_mrpn.eval(Operation.DIV);
					System.out.println(_mrpn.afficher());
				}catch(OperandeManquantException | DivivionParZeroException e)
				{
					System.out.println(e.getMessage());
				}
				
			}

			else
				{
					try
					{
						d = new Double(saisie);
						_mrpn.ajouterOperande(d);
						System.out.println(_mrpn.afficher());
					}
					catch(NumberFormatException e)
					{
						System.out.println("saisie imcorecte (Entrez une opérande ou une opération ou exit pour quiter)");
					}
					catch(OperandeTropPetitException e)
					{
						System.out.println(e.getMessage());
					}
					catch(OperandeTropGrandException e)
					{
						System.out.println(e.getMessage());
					}
					
				}
			
			saisie = _sc.nextLine();
		}
		_sc.close();
	}
	

}

