package com.myhome.app.views.widget;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by mqy on 2015/12/10.
 */
public class NoScrollViewPager extends ViewPager {

   private boolean isCanScroll = true;

   public NoScrollViewPager(Context context) {
      super(context);
   }

   public NoScrollViewPager(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   public void setScanScroll(boolean isCanScroll) {
      this.isCanScroll = isCanScroll;
   }

   @Override
   public void scrollTo(int x, int y) {
      super.scrollTo(x, y);
   }

   @Override
   public boolean onTouchEvent(MotionEvent arg0) {
      if (isCanScroll) {
         return super.onTouchEvent(arg0);
      } else {
         return false;
      }

   }

   @Override
   public void setCurrentItem(int item, boolean smoothScroll) {
      super.setCurrentItem(item, smoothScroll);
   }

   @Override
   public void setCurrentItem(int item) {
      super.setCurrentItem(item);
   }

   @Override
   public boolean onInterceptTouchEvent(MotionEvent arg0) {
      if (isCanScroll) {
         return super.onInterceptTouchEvent(arg0);
      } else {
         return false;
      }

   }

}
