package com.ysl;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;
import com.ysl.ui.message.MessageFragment;
import com.ysl.ui.trends.TrendsFragment;
import com.ysl.ui.index.IndexFragment;
import com.ysl.ui.me.MeFragment;
import com.ysl.utils.FragmentManagerHelper;
import com.ysl.view.BaseActivity;
import com.qiantao.coordinatormenu.CoordinatorMenu;

/**
 * create by yang on 2017/10/11 16:48
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private BottomNavigationView bottomNavigationView;

    private CoordinatorMenu mCoordinatorMenu;

    private FragmentManagerHelper mFragmentHelper;

    //private ImageView mHeadIv;//左上角按钮
    private LinearLayout ll_slidePage_item1;//侧滑栏
    private FragmentManager fragmentManager;
    private IndexFragment mIndexFragment;//首页Fragment
    private TrendsFragment mTrendsFragment;//动态Fragment
    private MessageFragment mMessageFragment;//消息Fragment
    private MeFragment mMeFragment;//个人中心Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        initSetting();

        initListen();
    }

    private void initView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        mCoordinatorMenu = (CoordinatorMenu) findViewById(R.id.cm_slide_and_index);

        ll_slidePage_item1 = (LinearLayout) findViewById(R.id.ll_slidePage_item1);
        ll_slidePage_item1.setOnClickListener(this);
    }

    private void initData() {

        fragmentManager = getSupportFragmentManager();
        mFragmentHelper = new FragmentManagerHelper(fragmentManager,R.id.fl_fragment);
        //默认加载首页
        mIndexFragment = new IndexFragment();
        mFragmentHelper.addFg(mIndexFragment);

        int[] image = {R.drawable.ic_mic_black_24dp, R.drawable.ic_favorite_black_24dp,
                R.drawable.ic_book_black_24dp, R.drawable.github_circle};
        int[] color = {ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.firstColor),
                ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.firstColor)};

        //初始化底部菜单
        if (bottomNavigationView != null) {
            //汉字是否一直显示:(false:显示选中的；true全部显示)
            bottomNavigationView.isWithText(false);
            //菜单栏在左侧
            //bottomNavigationView.activateTabletMode();
            //关闭动画
            // bottomNavigationView.disableViewPagerSlide();
            //去掉阴影
            //bottomNavigationView.disableShadow();
            //整体背景色
            bottomNavigationView.isColoredBackground(true);
            //选中字体的大小
            bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
            //未选中字体的大小
            bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
            //当 bottomNavigationView.isColoredBackground(true);设置为false时icon和汉字显示颜色能用
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));
            bottomNavigationView.setFont(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Noh_normal.ttf"));
            //使用viewpager
            // bottomNavigationView.setUpWithViewPager(yourPager , colorResources , imageResources);
        }

        //菜单栏文字颜色图片
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("首页", color[0], image[0]);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("动态", color[1], image[1]);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("消息", color[2], image[2]);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("个人中心", color[3], image[3]);

        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);
    }

    private void initSetting() {

    }

    private void initListen() {
        //首页左上角按钮
//        mHeadIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mCoordinatorMenu.isOpened()) {
//                    mCoordinatorMenu.closeMenu();
//                } else {
//                    mCoordinatorMenu.openMenu();
//                }
//            }
//        });

        //菜单栏点击事件
        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0://首页
                        if(mIndexFragment == null){
                            mIndexFragment = new IndexFragment();
                        }
                        mFragmentHelper.switchFg(mIndexFragment);
                        break;
                    case 1://动态
                        if(mTrendsFragment == null){
                            mTrendsFragment = new TrendsFragment();
                        }
                        mFragmentHelper.switchFg(mTrendsFragment);
                        break;
                    case 2://消息
                        if(mMessageFragment == null){
                            mMessageFragment = new MessageFragment();
                        }
                        mFragmentHelper.switchFg(mMessageFragment);
                        break;
                    case 3://个人中心
                        if(mMeFragment == null){
                            mMeFragment = new MeFragment();
                        }
                        mFragmentHelper.switchFg(mMeFragment);
                        break;

                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_slidePage_item1://侧滑页第一个item
                Toast.makeText(MainActivity.this, "你第一个要上天", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    //返回键监听
    @Override
    public void onBackPressed() {
        if (mCoordinatorMenu.isOpened()) {
            mCoordinatorMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
