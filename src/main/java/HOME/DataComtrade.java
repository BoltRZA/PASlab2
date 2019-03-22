package HOME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.PUBLIC_MEMBER;

public class DataComtrade {
	private File comtrCfg;
	private File comtrDat;
	private BufferedReader br;
	private String line;
	private String[] lineData;

	private double k1[]= new double [2];
	private double k2[]=new double [2];
	//private double U[]=new double [4001];
	//private double I[]=new double [4001];
	private Chart ch;
	private Rele r;


	public DataComtrade(String path, String file) {
		//Тот метод который выполняется при создании экземпляра. 

		comtrCfg = new File(path+file+".cfg");
		comtrDat = new File(path+file+".dat");
	}

	public void run() {
		//ожем обратиться извне, и оно ничего не вернет
		try {
			br= new BufferedReader( new FileReader(comtrCfg));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//трайкэтч поможет игнорировать ошибку в ктче вывод ошибки и прога продолжит выполнение а не остановится)
		}
		try {
			int lineNum = 0;
			while((line = br.readLine())!=null) {
				//	System.out.println(line);
				if (lineNum==2) {
					lineData = line.split(",");
					k1[0]=Double.parseDouble(lineData[5]); // koefficient preobrazovaniya
					k2[0]=Double.parseDouble(lineData[6]);

				}
				if (lineNum==3) {
					lineData = line.split(",");
					k1[1]=Double.parseDouble(lineData[5]); // koefficient preobrazovaniya
					k2[1]=Double.parseDouble(lineData[6]);
				}
				lineNum++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//_________________________________________________________________________________________________
		try {
			br= new BufferedReader( new FileReader(comtrDat));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//трайкэтч поможет игнорировать ошибку в ктче вывод ошибки и прога продолжит выполнение а не остановится)
		}
		Furie f1 = new Furie();
		MeanValue mv = new MeanValue();
		double rms = 0; 
		try {
			int lineNum = 0;
			while((line = br.readLine())!=null) {
				lineData = line.split(",");
				rms=f1.getRMS(Double.parseDouble(lineData[3])*k1[1]+k2[1]);
				ch.setData1(Double.parseDouble(lineData[3])*k1[1]+k2[1]);

				ch.setData2(rms);
				ch.setData3(mv.get(Double.parseDouble(lineData[3])*k1[1]+k2[1]));
				System.out.println(Double.parseDouble(lineData[3])*k1[1]+k2[1]);
				r.chekTrip(rms);
				//System.out.println(line);
				//int i=0;
				//for (int x = 0; x >4001; x++ ) {
				//if (lineNum==x) {
				//	U[x]=Double.parseDouble(lineData[2]);
				//	I[x]=Double.parseDouble(lineData[3]);	
				//}
				//}												
			}

		} catch (IOException e) {			
			e.printStackTrace();
		}

		System.err.println(k1);
		//System.err.println(U);
		//System.err.println(I);
	}
	public void setChart(Chart ch) {this.ch = ch;}

	public void setRele(Rele r) {this.r = r;}
}
