package com.example.sumit.srms;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class AdminDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_drawer);

        //Screen Rotation Disable Code
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Drawer Code
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new Home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        //Drawer Code End
    }

    //Drawer Methods
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new Home()).commit();
                break;

            case R.id.nav_course:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new CourseMgmt()).commit();
                break;

            case R.id.nav_semester:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new SemesterMgmt()).commit();
                break;

            case R.id.nav_division:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new DivisionMgmt()).commit();
                break;

            case R.id.nav_subject:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new SubjectMgmt()).commit();
                break;

            case R.id.nav_exam:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new ExamMgmt()).commit();
                break;

            case R.id.nav_manual_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new RegistrationActivity()).commit();
                break;

            case R.id.nav_import_users:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new ImportUser()).commit();
                break;

            case R.id.admin_nav_update_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new UpdateProfile()).commit();
                break;

            case R.id.nav_semester_update:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new SemesterUpdate()).commit();
                break;

            case R.id.nav_manage_faculty:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new FacultyMgmt()).commit();
                break;

            case R.id.nav_manual_result:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new ManualResult()).commit();
                break;

            case R.id.nav_import_results:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new ImportResults()).commit();
                break;

            case R.id.nav_reports:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container, new Reports()).commit();
                break;

            case R.id.nav_logout:
                Intent intent = new Intent(AdminDrawer.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Drawer Methods End
}