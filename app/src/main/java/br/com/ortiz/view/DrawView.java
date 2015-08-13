package br.com.ortiz.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 56789 on 12/08/2015.
 */
public class DrawView extends View {

    Paint paint = new Paint();
    private int maxWidth;
    private int maxHeight;

    private int startX = 0;
    private int y = 50;

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);
        paint.setTextSize(20f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawText("Buffalo Soldier - Bob Marley", startX, 0, paint);
        //canvas.drawPaint(paint);

        while (y < maxHeight) {
            for (int i = 0; i < 5; i++) {
                canvas.drawLine(startX, y, maxWidth, y, paint);
                y += 20;
            }
            y += 100;
        }


    }



    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }
}
