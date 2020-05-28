package com.anfly.a1908a;

import android.text.TextUtils;

public class ShapeFactory {
    public Shape getShape(String shapaType) {

        if (TextUtils.isEmpty(shapaType)) {
            return null;
        }

        if (shapaType.equals(Constants.CIRCLE)) {
            return new CircleShape();
        } else if (shapaType.equals(Constants.SQUARE)) {
            return new SquareShape();
        } else if (shapaType.equals(Constants.RECTANGLE)) {
            return new RectangleShape();
        }

        return null;
    }
}
