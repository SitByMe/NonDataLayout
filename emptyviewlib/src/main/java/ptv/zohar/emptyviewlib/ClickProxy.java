package ptv.zohar.emptyviewlib;

import android.view.View;

public class ClickProxy implements View.OnClickListener {
    private View.OnClickListener originListener;
    private long lastClick = 0;
    private long times = 1500;

    public ClickProxy(View.OnClickListener originListener) {
        this.originListener = originListener;
    }

    public ClickProxy(View.OnClickListener originListener, int times) {
        this(originListener);
        this.times = times;
    }

    @Override
    public void onClick(View v) {
        if (!(originListener instanceof ClickProxy) && (System.currentTimeMillis() - lastClick >= times)) {
            originListener.onClick(v);
            lastClick = System.currentTimeMillis();
        }
    }
}
