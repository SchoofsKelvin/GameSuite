package domain;

import java.awt.Graphics;

import ui.Drawable;

public abstract class Vorm implements Drawable {

	public abstract Omhullende getOmhullende();

	@Override
	public abstract String toString();

	@Override
    public abstract void draw(Graphics g);
}
