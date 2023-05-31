package com.mewz.grocery.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.mewz.grocery.R
import com.mewz.grocery.adapters.GroceryAdapter
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.databinding.ActivityMainBinding
import com.mewz.grocery.mvp.presenters.MainPresenter
import com.mewz.grocery.mvp.presenters.impls.MainPresenterImpl
import com.mewz.grocery.mvp.views.MainView

class MainActivity : BaseActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mAdapter: GroceryAdapter
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUiReady(this, this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<MainPresenterImpl, MainView>()
    }

    private fun setUpRecyclerView() {
        mAdapter = GroceryAdapter()
        binding.rvGroceries.adapter = mAdapter
        binding.rvGroceries.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showGroceryData(groceryList: List<GroceryVO>) {
        mAdapter.setNewData(groceryList)
    }

}