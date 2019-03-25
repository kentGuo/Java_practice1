package com.fg.Generic;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
	public void drawAll(List<? extends Shape> shapes) {
		for(Shape s:shapes) {
			s.draw(this);
		}
	}
	public static void main(String[] args) {
		List<Circle> circles=new ArrayList<>();
		circles.add(new Circle());
		List<Rectangle> rectangles=new ArrayList<>();
		rectangles.add(new Rectangle());
		Canvas canvas=new Canvas();
		canvas.drawAll(circles);
		canvas.drawAll(rectangles);
	}
}
