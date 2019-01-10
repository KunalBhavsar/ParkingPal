package in.parkingpal.parkingpal.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import in.parkingpal.parkingpal.R;
import in.parkingpal.parkingpal.ui.fragments.HistoryFragment;
import in.parkingpal.parkingpal.ui.fragments.HomeFragment;
import in.parkingpal.parkingpal.ui.fragments.MoreFragment;
import in.parkingpal.parkingpal.ui.fragments.VehiclesFragment;
import in.parkingpal.parkingpal.ui.fragments.WalletFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_vehicles:
                            selectedFragment = new VehiclesFragment();
                            break;
                        case R.id.nav_wallet:
                            selectedFragment = new WalletFragment();
                            break;
                        case R.id.nav_history:
                            selectedFragment = new HistoryFragment();
                            break;

                        case R.id.nav_more:
                            selectedFragment = new MoreFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;

                }
            };
}
