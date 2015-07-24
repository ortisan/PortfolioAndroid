//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.ortiz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Iterator;

import ortiz.com.br.portfolio.R;

public class OrtizParallaxScrollView extends ScrollView {
    private static final int DEFAULT_PARALLAX_VIEWS = 1;
    private static final float DEFAULT_INNER_PARALLAX_FACTOR = 1.9F;
    private static final float DEFAULT_PARALLAX_FACTOR = 1.9F;
    private static final float DEFAULT_ALPHA_FACTOR = -1.0F;
    private int numOfParallaxViews = 1;
    private float innerParallaxFactor = 1.9F;
    private float parallaxFactor = 1.9F;
    private float alphaFactor = -1.0F;
    private float deepChildParallax = 0;
    private ArrayList<ParallaxedView> parallaxedViews = new ArrayList();

    public OrtizParallaxScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context, attrs);
    }

    public OrtizParallaxScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.makeViewsParallax();
    }



    /*
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.makeViewsParallax();
    }
    */

    public OrtizParallaxScrollView(Context context) {
        super(context);
    }

    protected void init(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.OrtizParallaxScrollView);
        this.parallaxFactor = typeArray.getFloat(0, 1.9F);
        this.alphaFactor = typeArray.getFloat(1, -1.0F);
        this.innerParallaxFactor = typeArray.getFloat(2, 1.9F);
        this.numOfParallaxViews = typeArray.getInt(3, 1);
        typeArray.recycle();
    }

    private void makeViewsParallax() {
        if (this.getChildCount() > 0 && this.getChildAt(0) instanceof ViewGroup) {
            ViewGroup viewsHolder = (ViewGroup) this.getChildAt(0);
            int numOfParallaxViews = Math.min(this.numOfParallaxViews, viewsHolder.getChildCount());

            View view1 = ((ViewGroup) ((ViewGroup) this.getChildAt(0)).getChildAt(0)).getChildAt(0);
            View view2 = ((ViewGroup) ((ViewGroup) this.getChildAt(0)).getChildAt(1)).getChildAt(0);

            OrtizParallaxScrollView.ScrollViewParallaxedItem parallaxedView = new OrtizParallaxScrollView.ScrollViewParallaxedItem(view1);
            this.parallaxedViews.add(parallaxedView);
            parallaxedView = new OrtizParallaxScrollView.ScrollViewParallaxedItem(view2);
            this.parallaxedViews.add(parallaxedView);





/*
            for (int i = 0; i < numOfParallaxViews; ++i) {
                OrtizParallaxScrollView.ScrollViewParallaxedItem parallaxedView = new OrtizParallaxScrollView.ScrollViewParallaxedItem(viewsHolder.getChildAt(i));
                this.parallaxedViews.add(parallaxedView);
            }
            */


        }
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float parallax = this.parallaxFactor;
        float alpha = this.alphaFactor;

        ParallaxedView parallaxedView;

        Iterator i$ = this.parallaxedViews.iterator();

        while (i$.hasNext()) {


            //}

            //for (Iterator i$ = this.parallaxedViews.iterator(); i$.hasNext(); parallaxedView.animateNow()) {


            /*
            parallaxedView = (ParallaxedView) i$.next();
            Rect bounds = new Rect();
            parallaxedView.view.get().getLocalVisibleRect(bounds);
            Rect scrollBounds = new Rect(0, t, 1000, t + oldt);

            if (Rect.intersects(scrollBounds, bounds)) {
                //is  visible
                parallaxedView.setOffset((float) t / parallax);
                parallax *= this.innerParallaxFactor;
                if (alpha != -1.0F) {
                    float fixedAlpha = t <= 0 ? 1.0F : 100.0F / ((float) t * alpha);
                    parallaxedView.setAlpha(fixedAlpha);
                    alpha /= this.alphaFactor;
                }
            } else {
                parallaxedView.setOffset(0);
            }
            */
            parallaxedView = (ParallaxedView) i$.next();
            View view = parallaxedView.view.get();

            Rect bounds = new Rect();
            view.getHitRect(bounds);

            int left = view.getLeft();
            int top = view.getTop();
            top = bounds.top;

            top = bounds.top - bounds.bottom;
            int right = view.getRight();
            int bottom = view.getBottom();

            //Rect bounds1 = new Rect(left, top, right, bottom);
            //Rect bounds = new Rect();

            //view.getHitRect(bounds);
            //Rect scrollBounds = new Rect(l, t, l+oldl, oldt + t);
            //this.getHitRect(scrollBounds);
            //boolean x = Rect.intersects(scrollBounds, bounds);

            Rect scrollBounds = new Rect();
            this.getHitRect(scrollBounds);
            view.getDrawingRect(bounds);

            int delta1 = scrollBounds.top - scrollBounds.bottom;
            int delta2 = oldt - t;

            view.getDrawingRect(bounds);
            if (view.getLocalVisibleRect(scrollBounds)) {
                //is  visible


                parallaxedView.setOffset((bounds.bottom - t) / parallax);
                parallax *= this.innerParallaxFactor;
                if (alpha != -1.0F) {
                    float fixedAlpha = t <= 0 ? 1.0F : 100.0F / ((float) t * alpha);
                    parallaxedView.setAlpha(fixedAlpha);
                    alpha /= this.alphaFactor;
                }
                parallaxedView.animateNow();
            } else {
                //parallaxedView.setOffset(0);
            }
        }
    }

    protected class ScrollViewParallaxedItem extends ParallaxedView {
        public ScrollViewParallaxedItem(View view) {
            super(view);
        }

        protected void translatePreICS(View view, float offset) {
            view.offsetTopAndBottom((int) offset - this.lastOffset);
            this.lastOffset = (int) offset;
        }
    }
}
