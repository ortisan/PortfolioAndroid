package br.com.ortiz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import ortiz.com.br.portfolio.R;

/**
 * Created by marcelo on 21/07/15.
 */
public class MinhaView extends View {

    private String text;
    private Paint mTextPaint;

    public MinhaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MinhaView, 0, 0);
        this.text = ta.getString(R.styleable.MinhaView_text);

        ta.recycle();

        init();
    }

    private void init() {
        mTextPaint = new Paint();
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(Color.RED);
        //mTextPaint.setTypeface(tf);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        mTextPaint.setTextSize(30);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(this.text, canvas.getWidth(), canvas.getHeight(), this.mTextPaint);
    }
}
