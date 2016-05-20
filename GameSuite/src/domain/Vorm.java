package domain;

import ui.Drawable;

import java.awt.*;

public abstract class Vorm implements Drawable {

	public abstract Omhullende getOmhullende();

	@Override
	public abstract String toString();

    @Override
    public abstract void draw(Graphics g);

}
