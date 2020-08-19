package sig;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chart {
	protected Point[] data;
	protected int minX,maxX;
	protected int minY,maxY;
	protected String xLabel,yLabel;
	protected int xSize,ySize;
	protected int xScale,yScale;
	protected int dotSize=8;
	protected Rectangle chartBounds;
	protected Color backCol = Color.LIGHT_GRAY,
			axesCol = Color.BLACK,
			plotCol = new Color(255,220,100);
	protected static Font chartFont = new Font("Consolas",Font.BOLD,24);
	
	public Chart(Point[] data, int xSize, int ySize, String xLabel, String yLabel) {
		this.data = data;
		/*this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;*/
		minX=maxX=minY=maxY=0;
		
		for (Point p : data) {
			minX=Math.min(minX,p.x);
			minY=Math.min(minY,p.y);
			maxX=Math.max(maxX,p.x);
			maxY=Math.max(maxY,p.y);
		}
		
		this.xSize = xSize;
		this.ySize = ySize;
		
		xScale = xSize/(maxX-minX);
		yScale = ySize/(maxY-minY);
		
		this.xLabel=xLabel;
		this.yLabel=yLabel;
		
		chartBounds = new Rectangle(
				ChartMain.f.getWidth()/2-xSize/2,
				ChartMain.f.getHeight()/2-ySize/2,
				xSize,ySize);
	}

	public void render(Graphics g) throws IOException {
		//System.out.println("Rendering");
		chartBounds = new Rectangle(
				ChartMain.f.getWidth()/2-xSize/2,
				ChartMain.f.getHeight()/2-ySize/2,
				xSize,ySize);
	}
}
