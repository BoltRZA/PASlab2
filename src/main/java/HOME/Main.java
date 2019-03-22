package HOME;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\Users\\anast\\Desktop\\Магистратура\\Алгоритмы\\Лаба ДЗТ\\";
		String file = "KZ1";
		Rele r = new Rele();
		Furie f = new Furie();
		Chart ch = new Chart();
		DataComtrade cd = new DataComtrade(path, file);
		cd.setChart(ch);
		cd.setRele (r);
		cd.run();
	}

}
