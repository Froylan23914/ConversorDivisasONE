package conversor;

public class FactorConversion {
	private String mayor,menor;
	private double factor;
	
	FactorConversion(String mayor,String menor,double factor){
		super();
		this.mayor=mayor;
		this.menor=menor;
		this.factor=factor;
	}
	
	public double getFactor(String mayor, String menor) {
		boolean banderaMayor =!this.mayor.equals(mayor) || !this.mayor.equals(menor);
		if(banderaMayor ) {
			
		}
		
		if(this.mayor.equals(mayor) && this.menor.equals(menor))
		return this.factor;
		else if(this.mayor.equals(menor) && this.menor.equals(mayor))
		return 1/this.factor;
		
		return 0;
	}

}
