package ptv.zohar.nondatalayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import ptv.zohar.emptyviewlib.EmptyLayoutManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout rootLayoutTop;
    private FrameLayout rootLayoutBottom;
    private AppCompatButton btnStartTop;
    private AppCompatButton btnCenterTop;
    private AppCompatButton btnEndTop;
    private AppCompatButton btnStartBottom;
    private AppCompatButton btnCenterBottom;
    private AppCompatButton btnEndBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayoutTop = findViewById(R.id.root_layout_top);
        btnStartTop = findViewById(R.id.btn_start_top);
        btnCenterTop = findViewById(R.id.btn_center_top);
        btnEndTop = findViewById(R.id.btn_end_top);
        rootLayoutBottom = findViewById(R.id.root_layout_bottom);
        btnStartBottom = findViewById(R.id.btn_start_bottom);
        btnCenterBottom = findViewById(R.id.btn_center_bottom);
        btnEndBottom = findViewById(R.id.btn_end_bottom);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnStartTop.setOnClickListener(this);
        btnCenterTop.setOnClickListener(this);
        btnEndTop.setOnClickListener(this);
        btnStartBottom.setOnClickListener(this);
        btnCenterBottom.setOnClickListener(this);
        btnEndBottom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_top:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x1, rootLayoutTop);
                break;
            case R.id.btn_center_top:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x2, rootLayoutTop);
                break;
            case R.id.btn_end_top:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x3, rootLayoutTop);
                break;
            case R.id.btn_start_bottom:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x1, rootLayoutBottom);
                break;
            case R.id.btn_center_bottom:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x2, rootLayoutBottom);
                break;
            case R.id.btn_end_bottom:
                EmptyLayoutManager.addEmptyViewToViewGroup(0x3, rootLayoutBottom);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        EmptyLayoutManager.clear();
        super.onDestroy();
    }
}
