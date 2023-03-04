package conversor;

public class TestConversor {

	public static void main(String[] args) {
		/*
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new GUIConversor();

            }
        });
		*/
		Convertidor convertidor = new Convertidor();
		
		System.out.println(convertidor);
		for(int i =0;i<30;i++) 
			System.out.print("*");
		System.out.println();
		java.util.ArrayList<String> divisas = convertidor.getArrayListDivisas();
		System.out.println(divisas);
		try {
			String divisa1 = divisas.get(0);
			String divisa2 = divisas.get(2);
			double valor = convertidor.getFactorConversion(divisa1, divisa2);				
			System.out.println(divisa1+" -> "+divisa2+": "+valor);
			
			divisa1 = divisas.get(2);
			divisa2 = divisas.get(2);
			valor = convertidor.getFactorConversion(divisa1, divisa2);				
			System.out.println(divisa1+" -> "+divisa2+": "+valor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
