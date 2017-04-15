package tgprojects.xyz.starterapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.wealthfront.magellan.NavigationType;
import com.wealthfront.magellan.Navigator;
import com.wealthfront.magellan.support.SingleActivity;
import tgprojects.xyz.starterapplication.views.home.HomeScreen;

public class MainActivity extends SingleActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override protected Navigator createNavigator() {
        return Navigator.withRoot(new HomeScreen()).build();
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            if (!(getNavigator().currentScreen() instanceof HomeScreen)) {
                getNavigator().goBackToRoot(NavigationType.GO);
            }
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
