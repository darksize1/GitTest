package eksam_Martin_m�ek;

public class Pood {
	
	private static int avamisAeg;
	private static int sulgemisAeg;
	private static int k�lastus;
	
	public void Aeg() {
		this.setAvamisAeg(9);
		this.setSulgemisAeg(21);
		
		
	}

	public static int getAvamisAeg() {
		return avamisAeg;
	}

	public void setAvamisAeg(int avamisAeg) {
		this.avamisAeg = avamisAeg;
	}

	public static int getSulgemisAeg() {
		return sulgemisAeg;
	}

	public void setSulgemisAeg(int sulgemisAeg) {
		this.sulgemisAeg = sulgemisAeg;
	}

	public static int getK�lastus() {
		return k�lastus;
	}

	public static void setK�lastus(int k�lastus) {
		Pood.k�lastus = k�lastus;
	}
	
	

	
}