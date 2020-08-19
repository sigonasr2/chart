package sig;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JPanel;

public class ChartPanel extends JPanel{
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,ChartMain.f.getWidth(),ChartMain.f.getHeight());
		
		try {
			ChartMain.chart.render(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
