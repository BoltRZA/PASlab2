package HOME;

public class MeanValue {
	private double buffer[]= new double[80];

	private int num =0;
	private double k =(double) 1.11/80;
	private double sigS = 0.0,sigMean = 0.0;

	//public MeanValue() {
	// TODO Auto-generated constructor stub
	//}
	public double get (double instValue) {
		sigS = sigS+Math.abs (instValue)- Math.abs(buffer[num]);
		buffer[num] = instValue;
		num++;
		if (num==80) num=0;
		return sigS*k;
	}
}
