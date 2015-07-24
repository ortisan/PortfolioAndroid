//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.ortiz.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ParallaxedView {
    public static boolean isAPI11;
    protected WeakReference<View> view;
    protected int lastOffset = 0;
    protected List<Animation> animations = new ArrayList();

    protected abstract void translatePreICS(View var1, float var2);

    public ParallaxedView(View view) {
        this.view = new WeakReference(view);
    }

    public boolean is(View v) {
        return v != null && this.view != null && this.view.get() != null && ((View)this.view.get()).equals(v);
    }

    @SuppressLint({"NewApi"})
    public void setOffset(float offset) {
        View view = (View)this.view.get();
        if(view != null) {
            if(isAPI11) {
                view.setTranslationY(offset);
            } else {
                this.translatePreICS(view, offset);
            }
        }

    }

    public void setAlpha(float alpha) {
        View view = (View)this.view.get();
        if(view != null) {
            if(isAPI11) {
                view.setAlpha(alpha);
            } else {
                this.alphaPreICS(view, alpha);
            }
        }

    }

    protected synchronized void addAnimation(Animation animation) {
        this.animations.add(animation);
    }

    protected void alphaPreICS(View view, float alpha) {
        this.addAnimation(new AlphaAnimation(alpha, alpha));
    }

    protected synchronized void animateNow() {
        View view = (View)this.view.get();
        if(view != null) {
            AnimationSet set = new AnimationSet(true);
            Iterator i$ = this.animations.iterator();

            while(i$.hasNext()) {
                Animation animation = (Animation)i$.next();
                if(animation != null) {
                    set.addAnimation(animation);
                }
            }

            set.setDuration(0L);
            set.setFillAfter(true);
            view.setAnimation(set);
            set.start();
            this.animations.clear();
        }

    }

    public void setView(View view) {
        this.view = new WeakReference(view);
    }

    static {
        isAPI11 = VERSION.SDK_INT >= 11;
    }
}
