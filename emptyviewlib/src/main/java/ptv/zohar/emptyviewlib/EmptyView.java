package ptv.zohar.emptyviewlib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

/**
 * Created by Zohar.
 * EmptyView
 */
public class EmptyView extends LinearLayout {
    private Context context;

    private TextView tvEmpty;
    private ImageView ivEmpty;
    private Button btnEmpty;

    private String noticeText;
    @ColorInt
    private int noticeTextColor;
    private int imgDrawable;
    private String btnText;
    @ColorInt
    private int btnTextColor;

    public EmptyView(Context context) {
        this(context, R.mipmap.bg_empty_list, "", R.color.black);
    }

    public EmptyView(Context context, @DrawableRes int imgDrawable, String noticeText, @ColorRes int noticeTextColor) {
        this(context, null, imgDrawable, noticeText, noticeTextColor);
    }

    public EmptyView(Context context, AttributeSet attrs, @DrawableRes int imgDrawable, String noticeText, @ColorRes int noticeTextColor) {
        this(context, attrs, 0, imgDrawable, noticeText, noticeTextColor);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr, @DrawableRes int imgDrawable, String noticeText, @ColorRes int noticeTextColor) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.imgDrawable = imgDrawable;
        this.noticeText = noticeText;
        this.noticeTextColor = context.getResources().getColor(noticeTextColor);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_option, this);
        tvEmpty = this.findViewById(R.id.tv_option);
        ivEmpty = this.findViewById(R.id.iv_option);
        btnEmpty = this.findViewById(R.id.btn_option);

        ivEmpty.setImageResource(imgDrawable);
        tvEmpty.setTextColor(noticeTextColor);
        setNoticeText(noticeText);
    }

    public void setNoticeText(CharSequence text) {
        setViewText(tvEmpty, text);
    }

    public void setBtnText(CharSequence text) {
        setViewText(btnEmpty, text);
    }

    private void setViewText(TextView textView, CharSequence text) {
        String noticeText = text.toString();
        if (TextUtils.isEmpty(noticeText)) {
            textView.setVisibility(INVISIBLE);
        } else {
            textView.setVisibility(VISIBLE);
            textView.setText(noticeText);
        }
    }

    public void setBtnOnclickListener(String btnText, @ColorRes int btnTextColor, @Nullable View.OnClickListener listener) {
        this.btnText = btnText;
        this.btnTextColor = context.getResources().getColor(btnTextColor);
        btnEmpty.setTextColor(this.btnTextColor);
        btnEmpty.setOnClickListener(new ClickProxy(listener));
        setBtnText(this.btnText);
    }
}
