package com.ssau.lab1.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ssau.lab1.R;
import com.ssau.lab1.ui.adapters.MenuAdapter;
import com.ssau.lab1.ui.adapters.NewsAdapter;
import com.ssau.lab1.ui.dialogs.AboutDialog;

import java.util.ArrayList;
import java.util.Arrays;


public class LabActivity extends AppCompatActivity {

    private ActionBarDrawerToggle menuToggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private AppCompatSpinner newsSpinner;
    private RecyclerView menuRecyclerView;
    private static final String ABOUT_TAG = "dialogAbout";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_lab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.menu);
        menuToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        menuToggle.syncState();
        newsSpinner = (AppCompatSpinner) findViewById(R.id.news_spinner);
        menuRecyclerView = (RecyclerView) findViewById(R.id.menu_content);
        menuRecyclerView.setAdapter(new MenuAdapter(Arrays.asList(com.ssau.lab1.ui.menu.MenuItem.values()), this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        menuRecyclerView.addItemDecoration(dividerItemDecoration);
        NewsAdapter newsAdapter = new NewsAdapter(this, getResources().getStringArray(R.array.news_array));
        newsSpinner.setAdapter(newsAdapter);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                showAbout();
                return true;
            case R.id.exit:
                showExitAlert();
                return true;
            case R.id.buy:
                Toast.makeText(this, R.string.buy_message, Toast.LENGTH_LONG).show();
                return true;
            default:
                break;

        }
        if (menuToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAbout() {
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.show(getSupportFragmentManager(), ABOUT_TAG);
    }

    private void showExitAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exit_confirmation).setMessage(R.string.confirmation).setPositiveButton(R.string.common_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton(R.string.common_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
