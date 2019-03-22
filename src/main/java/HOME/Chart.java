package HOME;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class Chart {
	
	public XYSeries series1;
	public XYSeries series2;
	public XYSeries series3;
	public XYSeries series4;
	public XYSeries series5;
	public XYSeries series6;
	public XYDataset xyDataset;
	public JFreeChart chart;
	public JFreeChart chart2;
	public JFrame frame;
	public int s1=0;
	public int s2=0;
	public int s3=0;
	public int s4=0;
	public int s5=0;
	public int s6=0;
	
  public  Chart(){
    xyDataset = createSampleDataset();
 
    chart = ChartFactory
        .createXYLineChart("Заголовок", "х", "y",
                           xyDataset, 
                           PlotOrientation.VERTICAL,
                           true, true, true);
    
    frame = new JFrame("Название графика");
    
    frame.getContentPane().add(new ChartPanel(chart));
    frame.setSize(400,300);
    frame.show();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private XYDataset createSampleDataset() {
      series1 = new XYSeries("Series 1");
      series1.add(0.0, 0.0);
      series2 = new XYSeries("Series 2");
      series2.add(0.0, 0.0);
      series3 = new XYSeries("Series 3");
      series3.add(0.0, 0.0);       
      series4 = new XYSeries("Series 4");
      series4.add(0.0, 0.0);    
      series5 = new XYSeries("Series 5");
      series5.add(0.0, 0.0);    
      series6 = new XYSeries("Series 6");
      series6.add(0.0, 0.0);    
      
      XYSeriesCollection dataset = new XYSeriesCollection();
      dataset.addSeries(series1);
      dataset.addSeries(series2);
      dataset.addSeries(series3);        
      dataset.addSeries(series4);    
      dataset.addSeries(series5);        
      dataset.addSeries(series6);  
      return dataset;
  }
  
 public void setData1(double d){ 
	 s1++;
	 series1.add(s1,d);
  }
 public void setData2(double d){ 
	 s2++;
	 series2.add(s2,d);
  }
 public void setData3(double d){ 
	 s3++;
	 series3.add(s3,d);
  }
 public void setData4(double d){ 
	 s4++;
	 series4.add(s4,d);
  }
 public void setData5(double d){ 
	 s5++;
	 series5.add(s5,d);
  }
 public void setData6(double d){ 
	 s6++;
	 series6.add(s6,d);
  }
}