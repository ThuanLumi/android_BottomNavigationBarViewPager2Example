package com.office.bottomnavigationbarviewpagerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   private ViewPager2 mViewPager2;
   private BottomNavigationView mBottomNavigationView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mViewPager2 = findViewById(R.id.view_pager2);
      mBottomNavigationView = findViewById(R.id.bottom_navigation);

      MyViewPager2Adapter adapter = new MyViewPager2Adapter(this);
      mViewPager2.setAdapter(adapter);

      mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
         @Override
         public void onPageSelected(int position) {
            super.onPageSelected(position);
            switch (position) {
               case 0:
                  mBottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                  break;
               case 1:
                  mBottomNavigationView.getMenu().findItem(R.id.menu_favorite).setChecked(true);
                  break;
               case 2:
                  mBottomNavigationView.getMenu().findItem(R.id.menu_settings).setChecked(true);
                  break;
            }
         }
      });

      mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.menu_home) {
               mViewPager2.setCurrentItem(0);
            } else if (id == R.id.menu_favorite) {
               mViewPager2.setCurrentItem(1);
            } else if (id == R.id.menu_settings) {
               mViewPager2.setCurrentItem(2);
            }

            return true;
         }
      });
   }
}