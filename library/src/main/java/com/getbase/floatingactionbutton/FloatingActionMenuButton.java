package com.getbase.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;

public class FloatingActionMenuButton extends FloatingActionButton {

  @DrawableRes
  private int mStrokeIconNormal;
  private Drawable mStrokeIconNormalDrawable;

  @DrawableRes
  private int mStrokeIconPressed;
  private Drawable mStrokeIconPressedDrawable;

  private boolean mExpanded;

  public FloatingActionMenuButton(Context context) {
    this(context, null);
  }

  public FloatingActionMenuButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FloatingActionMenuButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  void init(Context context, AttributeSet attributeSet) {
    TypedArray attr = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionMenuButton, 0, 0);
    mStrokeIconNormal = attr.getResourceId(R.styleable.FloatingActionMenuButton_fab_strokeIconNormal, 0);
    mStrokeIconPressed = attr.getResourceId(R.styleable.FloatingActionMenuButton_fab_strokeIconPressed, 0);
    mExpanded = attr.getBoolean(R.styleable.FloatingActionMenuButton_fab_expanded, false);
    attr.recycle();

    super.init(context, attributeSet);
  }

  /**
   * @return the current Color of plus icon.
   */
  public int getIconNormal() {
    return mStrokeIconNormal;
  }

  public void setIconNormalResId(@DrawableRes int icon) {
    setIconNormal(getResources().getDrawable(icon));
  }
  /**
   * @return the current Color of plus icon.
   */
  public int getIconPressed() {
    return mStrokeIconNormal;
  }

  public void setIconPressedResId(@DrawableRes int icon) {
    setIconPressed(getResources().getDrawable(icon));
  }

  public void setIconNormal(Drawable drawable) {
    if (mStrokeIconNormalDrawable != drawable) {
      mStrokeIconNormalDrawable = drawable;
      updateBackground();
    }
  }
  public void setIconPressed(Drawable drawable) {
    if (mStrokeIconPressedDrawable != drawable) {
      mStrokeIconPressedDrawable = drawable;
      updateBackground();
    }
  }

  public void collapse() {
    collapse(false);
  }

  private void collapse(boolean immediately) {
    if (mExpanded) {
      mExpanded = false;

    }
  }

  public void toggle() {
    if (mExpanded) {
      collapse();
    } else {
      expand();
    }
  }

  public void expand() {
    if (!mExpanded) {
      mExpanded = true;
    }
  }

  @Override
  void updateBackground() {
    super.updateBackground();
  }

  @Override
  Drawable getIconDrawable() {

    //点击前
    if(isStrokeVisible()) {
      if (mStrokeIconNormalDrawable != null) {
        return mStrokeIconNormalDrawable;
      } else if (mStrokeIconNormal != 0) {
        return getResources().getDrawable(mStrokeIconNormal);
      }
    }else { //点击后
      if (mStrokeIconPressedDrawable != null) {
        return mStrokeIconPressedDrawable;
      } else if (mStrokeIconPressed != 0) {
        return getResources().getDrawable(mStrokeIconPressed);
      }
    }

    // icon
    if (mIconDrawable != null) {
      return mIconDrawable;
    } else if (mIcon != 0) {
      return getResources().getDrawable(mIcon);
    }

    //都没有？
    return new ColorDrawable(Color.TRANSPARENT);
  }




}
