package com.jpaulmorrison.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class ReportBlock extends Block {
	
	ReportBlock(Diagram diag) {
		super(diag);
		width = BLOCKWIDTH;
		height = BLOCKHEIGHT;
		type = Block.Types.REPORT_BLOCK;
		//calcEdges();
	}
	
	@Override
	void draw(Graphics g) {
		if (!visible && this != driver.selBlock) {
			showZones(g);
			return;
		}
		int ptx[] = new int[11];
		int pty[] = new int[11];
		int left, right, top, bottom;
		left = cx - width / 2;
		right = cx + width / 2;
		top = cy - height / 2;
		bottom = cy + height / 2;
		ptx[0] = left;
		pty[0] = bottom;
		ptx[1] = left;
		pty[1] = top;
		ptx[2] = right;
		pty[2] = top;
		int xt = right;
		int yt = bottom - height / 4;
		ptx[3] = xt;
		pty[3] = yt;
		xt -= width / 4;
		yt += height / 32;
		ptx[4] = xt;
		pty[4] = yt;
		xt -= width / 8;
		yt += height / 24;
		ptx[5] = xt;
		pty[5] = yt;
		xt -= width / 8;
		yt += height / 16;
		ptx[6] = xt;
		pty[6] = yt;
		xt -= width / 8;
		yt += height / 16;
		ptx[7] = xt;
		pty[7] = yt;
		xt -= width / 12;
		yt += height / 20;
		ptx[8] = xt;
		pty[8] = yt;
		xt -= width / 16;
		yt += 1;
		ptx[9] = xt;
		pty[9] = yt;
		xt -= width / 16;
		yt += 1;
		ptx[10] = xt;
		pty[10] = yt;

		g.setColor(Color.BLACK);
		g.drawPolygon(ptx, pty, 11);
		if (this == driver.selBlock)
			g.setColor(DrawFBP.ly); // light yellow
		else
			g.setColor(DrawFBP.lb); // light turquoise
		ptx[0] += 1;
		ptx[1] += 1;
		pty[1] += 1;
		pty[2] += 1;
		for (int i = 3; i < 11; i++)
			pty[i] -= 1;
		g.fillPolygon(ptx, pty, 11);

		if (desc != null) {
			centreDesc(g);
		}

		// showZones(g);
		calcDiagMaxAndMin(cx - width / 2, cx + width / 2, cy - height / 2, cy + height
				/ 2);

	}
}