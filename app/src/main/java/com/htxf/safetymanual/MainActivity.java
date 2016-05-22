package com.htxf.safetymanual;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.htxf.safetymanual.general.GeneralSafetyRulesFragment;
import com.htxf.safetymanual.laws.LawsFragment;
import com.htxf.safetymanual.purpose.PurposeFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    /**
     * 测试1 16:24
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){

        //设置抽屉导航
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        mNavigationView= (NavigationView) findViewById(R.id.navigation);


        //设置默认的打开哪一个章节（是一个第一级的Fragment）
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container_view, new GeneralSafetyRulesFragment()).commit();

        //点击导航目录时
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.purpose:
                        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_view, new PurposeFragment()).commit();
                        break;
                    case R.id.laws:
                        FragmentTransaction fragmentTransaction1 = mFragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.container_view, new LawsFragment()).commit();
                        break;
                    case R.id.general__safety_rules:
                        FragmentTransaction fragmentTransaction2 = mFragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.container_view, new GeneralSafetyRulesFragment()).commit();
                }
                return false;
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
