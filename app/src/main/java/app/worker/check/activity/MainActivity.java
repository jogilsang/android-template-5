package app.worker.check.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import app.worker.check.kakasubstitutedriving.R;
import app.worker.check.adapter.ViewPagerAdapter;
import app.worker.check.fragment.tabFragment1;
import app.worker.check.fragment.tabFragment2;
import app.worker.check.fragment.tabFragment3;
import app.worker.check.helper.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private MenuItem prevMenuItem;

    private View header;

    private Context mContext;
    private DrawerLayout drawer;

    public static tabFragment1 tab1 = new tabFragment1();
    public static tabFragment2 tab2 = new tabFragment2();
    public static tabFragment3 tab3 = new tabFragment3();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_2:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_3:
                    viewPager.setCurrentItem(2);
                    return true;

            }
            return false;
        }
    };
    private NavigationView navigationView;


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);


        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        mContext = MainActivity.this;

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                 this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//         drawer.addDrawerListener(toggle);
//
//         toggle.syncState();

        // navigation view
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
//
//        adapter.AddFragment(new tabFragment1(), getText(R.string.tab_1).toString());
//        adapter.AddFragment(new tabFragment2(), getText(R.string.tab_2).toString());
//        adapter.AddFragment(new tabFragment3(), getText(R.string.tab_3).toString());
//        adapter.AddFragment(new tabFragment4(), getText(R.string.tab_4).toString());

        adapter.AddFragment(tab1, getText(R.string.tab_1).toString());
        adapter.AddFragment(tab2, getText(R.string.tab_2).toString());
        adapter.AddFragment(tab3, getText(R.string.tab_3).toString());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }

                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}

