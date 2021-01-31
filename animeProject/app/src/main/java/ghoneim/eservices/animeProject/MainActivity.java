package ghoneim.eservices.animeProject;


import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import ghoneim.eservices.animeProject.fragment.ShowGridFragment;
import ghoneim.eservices.animeProject.fragment.ShowVerticalFragment;
import ghoneim.eservices.animeProject.nav.SelectableNavigationView;

public class MainActivity extends AppCompatActivity {

    private final static String FRAGMENT_NUMBER_KEY = "Fragment_Number";
    private final static String FRAGMENT_STORED_KEY = "Fragment_Stored";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private SelectableNavigationView navigationView;
    private SparseArray<Fragment> fragmentArray;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigationElements();

        if (savedInstanceState != null) {
            currentFragment = getSupportFragmentManager().getFragment(savedInstanceState, FRAGMENT_STORED_KEY);
            replaceFragment(currentFragment);
            fragmentArray.append(savedInstanceState.getInt(FRAGMENT_NUMBER_KEY), currentFragment);
        } else {
            navigationView.setSelectedItem(navigationView.getMenu().getItem(0));
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void setupNavigationElements() {
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        fragmentArray = new SparseArray<>(3);

        navigationView = findViewById(R.id.navigation);
        navigationView.inflateHeaderView(R.layout.navigation_header);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getOrder() == 2) {
                    logoff();
                    return false;
                }
                if (navigationView.getCheckedItem() != menuItem) {
                    replaceFragment(getSelectedMenuFragment(menuItem.getOrder()));
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private Fragment getSelectedMenuFragment(int position) {
        Fragment selectedFragment = fragmentArray.get(position);
        if (selectedFragment == null) {
            switch (position) {
                case 0:
                    selectedFragment = ShowVerticalFragment.newInstance();
                    break;
                case 1:
                    selectedFragment = ShowGridFragment.newInstance();
                    break;
                default:
                    selectedFragment = ShowVerticalFragment.newInstance();
                    break;
            }
            fragmentArray.append(position, selectedFragment);
        }
        currentFragment = selectedFragment;
        return selectedFragment;
    }


    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, newFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void logoff() {
        finish();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(FRAGMENT_NUMBER_KEY, navigationView.getCheckedItem().getOrder());
        getSupportFragmentManager().putFragment(savedInstanceState, FRAGMENT_STORED_KEY, currentFragment);
    }

}
