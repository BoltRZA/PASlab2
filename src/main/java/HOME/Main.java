package HOME;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\Users\\User\\Desktop\\holskz\\";
		String file = "KZ1";
//		Rele r = new Rele();
		Furie f = new Furie();
//		Chart ch = new Chart();
		DataComtrade cd = new DataComtrade(path, file);
//		cd.setChart(ch);
//		cd.setRele (r);
		Charts.createAnalogChart("High",0);
		Charts.addSeries("doubleprimeAH",0,0);
		Charts.addSeries("doubleprimeBH",0,1);
		Charts.addSeries("doubleprimeCH",0,2);

		Charts.createAnalogChart("Low ",1);
		Charts.addSeries("doubleprimeAL",1,0);
		Charts.addSeries("doubleprimeBL",1,1);
		Charts.addSeries("doubleprimeCL",1,2);

		Charts.createAnalogChart("HighRMS ",2);
		Charts.addSeries("doubleprimeAHR",2,0);
		Charts.addSeries("doubleprimeBHR",2,1);
		Charts.addSeries("doubleprimeCHR",2,2);

		Charts.createAnalogChart("LowRMS ",3);
		Charts.addSeries("doubleprimeALR",3,0);
		Charts.addSeries("doubleprimeBLR",3,1);
		Charts.addSeries("doubleprimeCLR",3,2);



		cd.run();
	}

}
