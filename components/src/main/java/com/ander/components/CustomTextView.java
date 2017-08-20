package com.ander.components;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * andermaco@gmail.com
 */

/**
 * Custom text view used in application, so we can change fonts and styles at once.
 */
public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
