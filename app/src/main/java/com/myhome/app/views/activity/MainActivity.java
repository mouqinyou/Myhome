package com.myhome.app.views.activity;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhome.app.R;
import com.myhome.app.utils.ToastUtils;
import com.myhome.app.views.adapter.ViewPagerFragmentAdapter;
import com.myhome.app.views.fragment.Fragment_0_;
import com.myhome.app.views.fragment.Fragment_1_;
import com.myhome.app.views.fragment.Fragment_2_;
import com.myhome.app.views.fragment.Fragment_3_;
import com.myhome.app.views.widget.NoScrollViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    NoScrollViewPager viewPager_main;

    @ViewById
    ImageView imageView_main_0;
    @ViewById
    ImageView imageView_main_1;
    @ViewById
    ImageView imageView_main_2;
    @ViewById
    ImageView imageView_main_3;

    @ViewById
    TextView textView_main_0;
    @ViewById
    TextView textView_main_1;
    @ViewById
    TextView textView_main_2;
    @ViewById
    TextView textView_main_3;

    private ImageView[] imageViews;
    private TextView[] textViews;

    private int iconUp[];
    private int iconDown[];
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPagerFragmentAdapter viewPagerAdapter;

    @AfterViews
    void init() {
        //定位
        iconUp = new int[]{
                R.mipmap.tab_icon_shouye_default,
                R.mipmap.tab_icon_haoyou_default,
                R.mipmap.tab_icon_gengduo_default,
                R.mipmap.tab_icon_gerenzhongxin_default
        };
        iconDown = new int[]{
                R.mipmap.tab_icon_shouye_pressed,
                R.mipmap.tab_icon_haoyou_pressed,
                R.mipmap.tab_icon_gerenzhongxin_pressed,
                R.mipmap.tab_icon_gengduo_pressed
        };
        imageViews = new ImageView[]{imageView_main_0, imageView_main_1, imageView_main_2, imageView_main_3};
        textViews = new TextView[]{textView_main_0, textView_main_1, textView_main_2, textView_main_3};
        fragments.add(new Fragment_0_());
        fragments.add(new Fragment_1_());
        fragments.add(new Fragment_2_());
        fragments.add(new Fragment_3_());
        viewPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager_main.setOffscreenPageLimit(4);
        viewPager_main.setAdapter(viewPagerAdapter);
        initTab(0, false);
        viewPager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                initTab(position, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Click({R.id.layout_main_0, R.id.layout_main_1, R.id.layout_main_2, R.id.layout_main_3})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.layout_main_0:
                initTab(0, true);
                break;
            case R.id.layout_main_1:
                initTab(1, true);
                break;
            case R.id.layout_main_2:
                initTab(2, true);
                break;
            case R.id.layout_main_3:
                initTab(3, true);
                break;
            default:
                break;
        }
    }

    /**
     * @param index  下标
     * @param isAnim 是否设置切换动画
     */
    public void initTab(int index, boolean isAnim) {
        for (int i = 0; i < 4; i++) {
            imageViews[i].setImageResource(iconUp[i]);
            textViews[i].setTextColor(getResources().getColor(R.color._000000));
        }
        imageViews[index].setImageResource(iconDown[index]);
        textViews[index].setTextColor(getResources().getColor(R.color._f10000));
        viewPager_main.setCurrentItem(index, isAnim);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //两次返回键退出
    private boolean isExit = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (isExit) {
                finish();
            } else {
                isExit = true;
                ToastUtils.ToastMakeText(MainActivity.this, "再按一次,退出应用");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
