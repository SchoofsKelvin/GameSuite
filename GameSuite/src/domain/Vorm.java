package domain;

import java.awt.Graphics;

import ui.Drawable;

public abstract class Vorm implements Drawable {

    private boolean zichtbaar = true;

    public abstract Omhullende getOmhullende();

	@Override
	public abstract String toString();

	@Override
    public abstract void draw(Graphics g);

    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }

    public boolean isZichtbaar() {
        return zichtbaar;
    }

}
