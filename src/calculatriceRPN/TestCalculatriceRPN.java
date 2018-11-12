package calculatriceRPN;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculatriceRPN {

	@Test
	public void testMoteurRPN() {
		MoteurRPN mrpn = new MoteurRPN();
		assertNotNull(mrpn);
	}
	
	@Test
	public void testAjouterOperande1() {
		MoteurRPN mrpn = new MoteurRPN();
		try{
			mrpn.ajouterOperande(12000000000000.3);
			mrpn.ajouterOperande(15.2);
		}catch(OperandeTropPetitException | OperandeTropGrandException e)
		{
			assertTrue(e.getMessage()=="Operande trop grande");
		}
		
		
	}
	@Test
	public void testAjouterOperande2() {
		MoteurRPN mrpn = new MoteurRPN();
		try{
			mrpn.ajouterOperande(-12);
			mrpn.ajouterOperande(-1.2);
		}catch(OperandeTropPetitException | OperandeTropGrandException e)
		{
			assertTrue(e.getMessage()=="Operande trop petit");
		}
		
		
	}
	
	@Test
	public void testEvalMoteur1() {
		MoteurRPN mrpn = new MoteurRPN();
		try{
			mrpn.ajouterOperande(5);
			mrpn.ajouterOperande(0);
			mrpn.eval(Operation.DIV);
			
		}catch(OperandeManquantException | DivivionParZeroException | OperandeTropPetitException | OperandeTropGrandException e)
		{
			assertFalse(!e.getMessage().equals("Impossible de diviser par zéro")) ;
		}	
	}
	
	@Test
	public void testEvalMoteur2() {
		MoteurRPN mrpn = new MoteurRPN();
		try{
			mrpn.ajouterOperande(5);
			mrpn.eval(Operation.PLUS);
			
		}catch(OperandeManquantException | DivivionParZeroException | OperandeTropPetitException | OperandeTropGrandException e)
		{
			assertNotEquals(e.getMessage(), "Operation possible (pa besoin deux opérandes)") ;
		}
	}
	
	@Test
	public void testSaisie() {
		SaisieRPN srpn = new SaisieRPN();
		assertNotNull(srpn);
	}
	
	@Test
	public void testCalculatriceRPN() {
		CalculatriceRPN c =CalculatriceRPN.CALCULATRICE;
		assertNotNull(c);
	}


}
