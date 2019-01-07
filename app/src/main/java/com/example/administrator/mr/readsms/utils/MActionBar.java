package com.example.administrator.mr.readsms.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mr.readsms.R;


/**
 * date:2019/1/4
 * 自定义Actionbar
 */
public class MActionBar extends LinearLayout {
    private ImageView leftImg;
    private ImageView rightImg;
    private TextView title;

    public MActionBar(Context context) {
        super(context);
    }

    public MActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(Context mContext) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.action_bar_layout, this);
        leftImg = layout.findViewById(R.id.left_image);
        rightImg = layout.findViewById(R.id.right_image);
        title = layout.findViewById(R.id.title);
    }
}
