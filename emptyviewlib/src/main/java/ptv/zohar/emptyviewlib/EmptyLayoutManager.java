package ptv.zohar.emptyviewlib;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class EmptyLayoutManager {
    private static final int emptyId = R.string.empty_id;

    private static SparseArray<View> emptyViews = new SparseArray<>();

    public static void init(int emptyTagKey, View emptyView) {
        emptyViews.put(emptyTagKey, emptyView);
    }

    public static void addEmptyViewToViewGroup(int tagKey, ViewGroup rootLayout) {
        View emptyView = emptyViews.get(tagKey);
        if (emptyView == null) {
            throw new IllegalStateException("没有这个key的EmptyView");
        }
        if (emptyView.getParent() != null) {
            ViewGroup rootParent = (ViewGroup) emptyView.getParent();
            rootParent.removeView(emptyView);
        }

        if (rootLayout.getTag(emptyId) != null) {
            rootLayout.removeView((View) rootLayout.getTag(emptyId));
        }

        rootLayout.setTag(emptyId, emptyView);
        rootLayout.addView(emptyView);
    }

    public static void clear() {
        for (int i = 0; i < emptyViews.size(); i++) {
            View emptyView = emptyViews.valueAt(i);
            if (emptyView.getParent() != null) {
                ViewGroup rootLayout = (ViewGroup) emptyView.getParent();
                rootLayout.removeView(emptyView);
            }
        }
    }
}
