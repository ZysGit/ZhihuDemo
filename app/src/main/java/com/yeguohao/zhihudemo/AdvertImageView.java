package com.yeguohao.zhihudemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class AdvertImageView extends View {

    private Bitmap bitmap;
    private Paint paint;
    private Rect src = new Rect();
    private Rect dst = new Rect();

    private int top;
    private int bitmapHeight;

    public AdvertImageView(Context context) {
        super(context);
    }

    public AdvertImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AdvertImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        bitmapHeight = bitmap.getHeight();
        paint = new Paint();
    }

    @Override
    public void offsetTopAndBottom(int offset) {
        super.offsetTopAndBottom(offset);
        top += offset;
        top = Math.max(0, top);
        top = Math.min(bitmapHeight - getHeight(), top);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        dst.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap == null) {
            return;
        }

        src.set(0, top, getWidth(), top + getHeight());
        canvas.drawBitmap(bitmap, src, dst, paint);
    }

}
