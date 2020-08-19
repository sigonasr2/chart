package sig;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import sig.chart.BarChart;
import sig.chart.LineChart;

public class ChartMain {
	public static JFrame f;
	public static ChartPanel p;
	public static LineChart chart;
	public static void main(String[] args) throws IOException {
		f = new JFrame();
		f.setSize(1024, 800);
		p = new ChartPanel();
		int i=0;
		chart = new LineChart(
				new Point[] {
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),
						new Point(i++,(int)(Math.random()*10)),},
				640,480,
				"Day","Cookies");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		
		BufferedImage img = new BufferedImage(ChartMain.f.getWidth(),ChartMain.f.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		ChartMain.p.paintAll(g2);
		ImageIO.write(img, "png", new File("chart.png"));
	}
}
