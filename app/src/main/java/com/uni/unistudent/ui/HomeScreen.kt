package com.uni.unistudent.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.uni.unistudent.R
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.data.di.SignUpKey
import com.uni.unistudent.databinding.ActivityHomeScreenBinding
import com.uni.unistudent.ui.fragments.AttendanceFragment
import com.uni.unistudent.ui.fragments.HomeFragment
import com.uni.unistudent.ui.fragments.NotificationsFragment
import com.uni.unistudent.ui.fragments.PermissionFragment
import com.uni.unistudent.ui.fragments.ProfileFragment
import com.uni.unistudent.ui.fragments.ScheduleFragment
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeScreen : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModels()
    private val storageViewModel: FireStorageViewModel by viewModels()

    //TODO save the image in a shared prefrance

    lateinit var currentUser: UserStudent
    private lateinit var binding: ActivityHomeScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.notification -> replaceFragment(AttendanceFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.schedule_and_attendees -> {
                    replaceFragment(ScheduleFragment())
                    updateUser(currentUser)
                }

                else -> {
                }

            }
            true
        }

    }


    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }

    private fun updateUser(user: UserStudent) {
        viewModel.getUserStudent(user.userId, user.section, user.department, user.grade)
    }

    private fun observeImage() {

        lifecycleScope.launchWhenCreated {
            storageViewModel.getUri.collectLatest { uri ->

                when (uri) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        binding.progressBarImage.visibility = View.GONE
                        Glide.with(this@HomeScreen)
                            .load(uri.result)
                            //.diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //TODO https://stackoverflow.com/questions/53140975/load-already-fetched-image-when-offline-in-glide-for-android
                            .placeholder(R.drawable.user_image)
                            .into(binding.userImage)
                    }

                    is Resource.Failure -> {
                        Toast.makeText(this@HomeScreen, uri.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }


        }
    }


    private fun observeUser() {
        lifecycleScope.launchWhenCreated {
            viewModel.userStudent.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        val user = state.result
                        if (user != null) {

                            viewModel.setSession(state.result)
                            binding.userGrade.text = user.grade
                            binding.userDepartment.text = user.department
                            binding.userName.text = user.name

                        }
                    }

                    is Resource.Failure -> {
                        Toast.makeText(
                            this@HomeScreen,
                            state.exception.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else -> {
                    }
                }
            }

        }
    }

    override fun onStart() {
        super.onStart()
        // settingsOnStartApp()
        viewModel.getSessionStudent { user ->
            if (user != null) {
                updateUser(user)
                currentUser = user
                if (checkForInternet(this)) {
                    storageViewModel.getUri(user.userId)

                }
                observeUser()
                observeImage()

                if (user.hasPermission) {
                    replaceFragment(HomeFragment())
                    binding.layoutHomeScreen.visibility = View.VISIBLE
                    binding.bottomNavigationView.visibility = View.VISIBLE


                } else {
                    replaceFragment(PermissionFragment())
                    binding.bottomNavigationView.visibility = View.GONE

                }

            } else {

                val intent = Intent(this, SignUp::class.java)

                intent.putExtra(SignUpKey.FROM_HOME_SCREEN, getString(R.string.notFoundUser))
                startActivity(intent)
            }
        }
    }

    private fun checkForInternet(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    private fun settingsOnStartApp() {
        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.selectedItemId = R.id.home

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.notification -> replaceFragment(NotificationsFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.schedule_and_attendees -> {
                    replaceFragment(ScheduleFragment())
                    updateUser(currentUser)
                }

                else -> {
                }

            }
            true
        }
    }
}