package sig.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import sig.Chart;
import sig.ChartMain;
import sig.utils.DrawUtils;
import sig.utils.TextUtils;

public class BarChart extends Chart{

	public BarChart(Point[] data, int xSize, int ySize, String xLabel, String yLabel) {
		super(data, xSize, ySize, xLabel, yLabel);
	}


	public void render(Graphics g) throws IOException {
		super.render(g);
		g.setColor(backCol);
		g.fillRect(chartBounds.x,chartBounds.y,chartBounds.width,chartBounds.height);
		
		//g.drawString(xLabel, chartBounds., y);
		DrawUtils.drawCenteredText(g, chartFont, ChartMain.p, 
				chartBounds.x+chartBounds.width/2, chartBounds.y+chartBounds.height+8, Color.BLACK, 
				xLabel);
		Rectangle2D bounds = TextUtils.calculateStringBoundsFont(ChartMain.p, yLabel, chartFont);
		DrawUtils.drawCenteredText(g, chartFont, ChartMain.p, 
				(int)(chartBounds.x-bounds.getWidth()/2-4), chartBounds.y+chartBounds.height/2, Color.BLACK, 
				yLabel);
		

		g.setColor(plotCol);
		for (int i=0;i<data.length;i++) {
			g.fill3DRect(
					chartBounds.x+data[i].x*xScale,
					chartBounds.y+chartBounds.height-data[i].y*yScale,
					xScale/2,
					data[i].y*yScale,
					true
					);
		}
		
		g.setColor(Color.BLACK);

		g.setColor(axesCol);
		g.fill3DRect(chartBounds.x, chartBounds.y, 3, chartBounds.height, true);
		g.fill3DRect(chartBounds.x, chartBounds.y+chartBounds.height, chartBounds.width, 3, true);
		
		for (int i=minX;i<maxX;i++) {
			int xPos = chartBounds.x+(i-minX)*xScale;
			g.drawLine(
					xPos,chartBounds.y+chartBounds.height-4,
					xPos,chartBounds.y+chartBounds.height+8);
		}

		for (int i=minY;i<maxY;i++) {
			int yPos = chartBounds.y+chartBounds.height-(i-minY)*yScale;
			g.drawLine(
					chartBounds.x-8,yPos,
					chartBounds.x+4,yPos);
		}
	}
}
