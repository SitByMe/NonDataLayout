package ptv.zohar.nondatalayout;

import android.app.Application;

import ptv.zohar.emptyviewlib.EmptyLayoutManager;
import ptv.zohar.emptyviewlib.EmptyView;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EmptyView emptyView1 = new EmptyView(this);
        emptyView1.setNoticeText("网络不好，请稍后重试");
        EmptyLayoutManager.init(0x1, emptyView1);
        EmptyView emptyView2 = new EmptyView(this);
        emptyView2.setNoticeText("暂无数据");
        EmptyLayoutManager.init(0x2, emptyView2);
        EmptyView emptyView3 = new EmptyView(this);
        emptyView3.setNoticeText("服务器异常");
        EmptyLayoutManager.init(0x3, emptyView3);
    }
}
