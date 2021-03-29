package innerClasses;

public class Main {

	public static void main(String[] args) {
		
		//---------------------Setup
		Gearbox VW = new Gearbox(5);
		VW.addGear(1, 2.5);
		VW.addGear(2, 5);
		VW.addGear(3, 7.5);
		VW.addGear(4, 10);
		VW.addGear(5, 12.5);
		
		//---------------------Operation
		VW.operateClutch(true);
		VW.changeGear(1);
		VW.operateClutch(false);
		VW.changeGear(2);
	}
}
