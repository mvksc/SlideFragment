    package com.example.aem.slidefragment.view;

    import android.content.Context;
    import android.util.AttributeSet;
    import android.view.ViewTreeObserver;
    import android.widget.RelativeLayout;

    /**
     * Created by paveld on 4/13/14.
     */
    public class SlidingRelativeLayout extends RelativeLayout {

        private float yFraction = 0,xFraction = 0;

        public SlidingRelativeLayout(Context context) {
            super(context);
        }

        public SlidingRelativeLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public SlidingRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        private ViewTreeObserver.OnPreDrawListener preDrawListener = null;
        private ViewTreeObserver.OnPreDrawListener preXDrawListener = null;

        public void setYFraction(float fraction) {

            this.yFraction = fraction;

            if (getHeight() == 0) {
                if (preDrawListener == null) {
                    preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                            setYFraction(yFraction);
                            return true;
                        }
                    };
                    getViewTreeObserver().addOnPreDrawListener(preDrawListener);
                }
                return;
            }

            float translationY = getHeight() * fraction;
            setTranslationY(translationY);
        }

        public float getYFraction() {
            return this.yFraction;
        }




        public void setXFraction(float fraction) {

            this.xFraction = fraction;

            if (getWidth() == 0) {
                if (preXDrawListener == null) {
                    preXDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            getViewTreeObserver().removeOnPreDrawListener(preXDrawListener);
                            setXFraction(xFraction);
                            return true;
                        }
                    };
                    getViewTreeObserver().addOnPreDrawListener(preXDrawListener);
                }
                return;
            }

            float translationX = getWidth() * fraction;
            setTranslationX(translationX);
        }

        public float getXFraction() {
            return this.xFraction;
        }
    }
