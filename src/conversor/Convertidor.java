package conversor;


import java.util.ArrayList;
import java.util.HashSet;

public class Convertidor {

	private HashSet<FactorConversion> divisas;
	
	public Convertidor() {
		// Datos recabados desde google el 03 marzo 2023
		divisas = new HashSet<FactorConversion>();
		// peso mexicano
		divisas.add(new FactorConversion("Peso Mexicano","Dolar",17.98d));
		divisas.add(new FactorConversion("Peso Mexicano","Euro",19.10d));
		divisas.add(new FactorConversion("Peso Mexicano","Libra Esterlina",21.62d));
		divisas.add(new FactorConversion("Peso Mexicano","Won sul-coreano",72.16d));
		divisas.add(new FactorConversion("Yen Japonés","Peso Mexicano",7.57d));
		
		//dolar eu
		divisas.add(new FactorConversion("Euro","Dolar",17.98d));
		divisas.add(new FactorConversion("Libra Esterlina","Dolar",1.20d));
		divisas.add(new FactorConversion("Dolar","Yen Japonés",135.84d));
		divisas.add(new FactorConversion("Dolar","Won sul-coreano",1295.76d));
		
		// euro
		divisas.add(new FactorConversion("Libra Esterlina","Euro",1.13d));
		divisas.add(new FactorConversion("Euro","Won sul-coreano",1379.78d));
		divisas.add(new FactorConversion("Euro","Yen Japonés",144.65d));
		
		// Libra Esterlina
		divisas.add(new FactorConversion("Libra Esterlina","Won sul-coreano",1559.46d));
		divisas.add(new FactorConversion("Libra Esterlina","Yen Japonés",163.35));
		
		// Yen Japones
		divisas.add(new FactorConversion("Yen Japonés","Won sul-coreano",7.57d));
	}
	
	public double getFactorConversion(String divisa1,String divisa2) throws Exception {
		for(FactorConversion fc:divisas) {
			if(fc.isDivisa(divisa1) && fc.isDivisa(divisa2)) {
					return fc.getFactor(divisa1, divisa2);
			}
		}
		// manda una excepcion si al revisar la coleccion completa, no esta dicho conjunto divisas
		throw new Exception("No se tiene registro de las divisas: "+divisa1+" y "+divisa2);
	}
	
	public ArrayList<String> getArrayListDivisas(){
		// se opto por un HashSet para evitar elementos repetidos
		HashSet<String> hs1 = new HashSet<>();
		for(FactorConversion fc:divisas) {
			hs1.add(fc.getDivisa1());
			hs1.add(fc.getDivisa2());
		}
		
		return new ArrayList<String>(hs1);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return divisas.toString();
	}
}
