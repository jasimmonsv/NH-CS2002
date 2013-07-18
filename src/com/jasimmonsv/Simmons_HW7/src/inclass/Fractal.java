package inclass;

/**
 * Copyright (c) 2003 Sun Microsystems, Inc. All  Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * -Redistributions of source code must retain the above copyright
 *  notice, this list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduct the above copyright
 *  notice, this list of conditions and the following disclaimer in
 *  the documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT
 * BE LIABLE FOR ANY DAMAGES OR LIABILITIES SUFFERED BY LICENSEE AS A RESULT
 * OF OR RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THE SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN
 * IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that Software is not designed, licensed or intended for
 * use in the design, construction, operation or maintenance of any nuclear
 * facility.
 */

/*
 * @(#)DrawTest.java	1.11 03/01/23
 */

import java.awt.*;
import javax.swing.*;

public class Fractal extends JApplet
{
	FractalPanel panel;
//	FractalControls controls;

	public void init()
	{
		setLayout(new BorderLayout());

		panel = new FractalPanel();
//		controls = new FractalControls(panel);

		add("Center", panel);
//		add("South", controls);
	}

	public void destroy()
	{
		remove(panel);
//		remove(controls);
	}

	public static void main(String args[])
	{
		JFrame f = new JFrame("DrawTest");
		Fractal drawTest = new Fractal();
		drawTest.init();
		drawTest.start();

		f.add("Center", drawTest);

		f.setSize(500, 500);
		f.setVisible(true);

	}

	public String getAppletInfo()
	{
		return "Fractal: a recursive fractal-drawing applet.";
	}
}

@SuppressWarnings("serial")
class FractalPanel extends JPanel
{
	public static final double ROOT3 = Math.sqrt(3.0);

	public FractalPanel()
	{
		setBackground(Color.white);
		setForeground(Color.black);
	}

	public void paint(Graphics g)
	{
		/* draw the current lines */

		setBackground(Color.white);
		g.setColor(Color.black);

		drawFractal(g, 50, 400, 400);

	}

	public void drawFractal(Graphics g, int x, int y, int side)
	{
		// check if we're at the "bottom" of the calls

		if (side < 1)
			return;

	// finish this, making recursive calls
	}
}

//@SuppressWarnings("serial")
//class FractalControls extends JPanel
//{
//	FractalPanel target;
//
//	public FractalControls(FractalPanel target)
//	{
//		this.target = target;
//
//		setLayout(new FlowLayout());
//		setBackground(Color.white);
//
//		// target.setForeground(Color.red);
//
//		JButton button = new JButton("Draw");
//
//		add(button);
//
//		button.setVisible(true);
//	}

//	g.drawLine(x, y, x+side, y);
//	g.drawLine(x+side, y, x+side/2, y-(int)(ROOT3*side/2.0));
//	g.drawLine(x+side/2, y-(int)(ROOT3*side/2.0), x, y);
//	
//	g.drawLine(x+side/2, y, x+3*side/4, y-(int)(ROOT3*side/4.0));
//	g.drawLine(x+3*side/4, y-(int)(ROOT3*side/4.0), x+side/4, y-(int)(ROOT3*side/4.0));
//	g.drawLine(x+side/4, y-(int)(ROOT3*side/4.0), x+side/2, y);
//	
//	drawFractal (g, x, y, side/2);
//	drawFractal (g, x+side/2, y, side/2);
//	drawFractal (g, x+side/4, y-(int)(ROOT3*side/4.0), side/2);
	
//
//}
