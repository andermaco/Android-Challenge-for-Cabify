package com.ander.components;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * andermaco@gmail.com
 */

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * Initialize style
     */
    private void init(Context context, AttributeSet attrs) {
        setCustomStyle();
    }

    /**
     * Set custom style for the given text view
     */
    protected void setCustomStyle() {
        // NOTE: Edit this method for applying your own custom styles
    }
}
