package com.hdt.onlinegroceries.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseActivity
import com.hdt.onlinegroceries.databinding.ActivityMainBinding
import com.hdt.onlinegroceries.extension.setupWithNavController
import com.hdt.onlinegroceries.extension.visibleIf

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var navController: LiveData<NavController>? = null

    override fun onInflateView(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.data
        intent.data = null
        handleDeepLink(data)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        setupBottomNavigation()
        val data = intent?.data
        handleDeepLink(data)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun setupData(savedInstanceState: Bundle?) {
        if (savedInstanceState === null) {
            setupBottomNavigation()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigation()
    }

    private fun handleDeepLink(uri: Uri?) {
        if (uri != null) {
            navController?.value?.navigate(uri)
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setupBottomNavigation() {
        val navGraphIds = listOf(
            R.navigation.nav_shop,
            R.navigation.nav_explore,
            R.navigation.nav_cart,
            R.navigation.nav_favorite,
            R.navigation.nav_account
        )

        val controller = binding.navView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navHost,
            intent = intent
        )
        navController = controller
        binding.navView.itemIconTintList = null
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean =
        navController?.value?.navigateUp() ?: false

    fun switchBottomNavTab(id: Int) {
        binding.navView.selectedItemId = id
    }

    fun checkSwitchNavTab(id: Int) = binding.navView.selectedItemId == id

    fun showToolbar(isShow: Boolean) {
        if (isShow) {
            supportActionBar?.show()
        } else {
            supportActionBar?.hide()
        }
    }

    fun setBadge(id: Int, count: Int) {
        binding.navView.apply {
            if (count > 0) {
                getOrCreateBadge(id)
            } else {
                removeBadge(id)
            }
        }
    }

    fun showBottomNav(isShow: Boolean) = binding.navView.visibleIf(isShow)
}