package eksam_Martin_m�ek;

import java.util.Scanner;

public class kasutaja {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Mis aega on teil vaja?(t�istundides ehk nt: 2 v 15)");
		Scanner inputFromUser = new Scanner(System.in);
		String rida=inputFromUser.nextLine();
		int vastus = Integer.parseInt(rida);
		
		
		if (vastus>=Pood.getAvamisAeg() && vastus<=Pood.getSulgemisAeg()){
			System.out.println("Pood on lahti, sisestatud kellaajal");
		}else{
			System.out.println("pood on kinni, sisestatud kellaajal");
		}
		System.out.println("Kas soovite k�lastada?(J/E)");
		
		String vastus2 = inputFromUser.nextLine();
		
		if(vastus2.compareToIgnoreCase("J") == 0){
			Pood.setK�lastus(Pood.getK�lastus()+1);
			System.out.println(Pood.getK�lastus());
		}
		
		
		
		inputFromUser.close();
	}
	

}
