package com.example.task_manager_4

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
=======
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
>>>>>>> 8decab1 (Initial commit)
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.task_manager_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
<<<<<<< HEAD
=======

        navController.navigate(R.id.onBoardingFragment)
>>>>>>> 8decab1 (Initial commit)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
<<<<<<< HEAD
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.taskFragment
=======
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.profileFragment,
                R.id.taskFragment
>>>>>>> 8decab1 (Initial commit)
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
<<<<<<< HEAD
=======

        navController.addOnDestinationChangedListener(object : NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                if (destination.id == R.id.onBoardingFragment){
                    navView.isVisible = false
                    supportActionBar?.hide()
                } else{
                    navView.isVisible = true
                    supportActionBar?.show()
                }
            }

        })
>>>>>>> 8decab1 (Initial commit)
    }
}