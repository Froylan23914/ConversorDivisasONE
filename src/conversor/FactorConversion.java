package conversor;

import java.util.Objects;

public class FactorConversion {
	private String divisa1,divisa2;
	private double factor;
	
	FactorConversion(String divisa1,String divisa2,double factor){
		super();
		this.divisa1=divisa1;
		this.divisa2=divisa2;
		this.factor=factor;
	}
	
	public double getFactor(String divisa1, String divisa2) throws Exception {
		// revisa si las divisas son correctas
		if(!isDivisa(divisa1) || !isDivisa(divisa2)) {
			throw new Exception("No hay factor de conversion entre " + divisa1+" y "+ divisa2);
		}
		//si son repetidas
		if(divisa1.equals(divisa2)) {
			return 1;
		}
		
		// revisa el orden con respecto a las divisas
		if(this.divisa1.equals(divisa1) && this.divisa2.equals(divisa2))
		return this.factor;
		else // en caso de que las divisas esten alrevez
		return 1/this.factor;
	}
	
	public boolean isDivisa(String divisa) {
		return this.divisa1.equals(divisa) || this.divisa2.equals(divisa);
	}
	
	@Override
	public String toString() {
		return this.divisa1.toString()+" -> "+this.divisa2.toString()+" : "+this.factor;
	}

	public String getDivisa1() {
		return divisa1;
	}

	public String getDivisa2() {
		return divisa2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(divisa1, divisa2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FactorConversion fc = (FactorConversion) obj;
		return fc.isDivisa(this.divisa1) && fc.isDivisa(this.divisa2);
	}
	
}
