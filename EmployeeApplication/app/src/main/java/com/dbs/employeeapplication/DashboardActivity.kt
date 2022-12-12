package com.dbs.employeeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbs.employeeapplication.databinding.ActivityDashboardBinding
import com.dbs.employeeapplication.databinding.ActivitySignInBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {
    private var binding: ActivityDashboardBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarDash)
        supportActionBar?.title = "DashBoard"
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarDash?.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun getAllUserDetails(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.fetchAllUsers().collect { allUserList ->

                if (allUserList.isNotEmpty()) {
                    binding?.tvHistory?.visibility = View.VISIBLE
                    binding?.rvHistory?.visibility = View.VISIBLE
                    binding?.tvNoDataAvailable?.visibility = View.GONE
                    binding?.rvHistory?.layoutManager = LinearLayoutManager(this@DashboardActivity)

                    val users = ArrayList<String>()
                    for (u in allUserList) {
                        users.add(u.user)
                    }
                    val dashboardAdapter = DashBoardAdapter(ArrayList(users))
                    binding?.rvHistory?.adapter = dashboardAdapter
                } else {
                    binding?.tvHistory?.visibility = View.GONE
                    binding?.rvHistory?.visibility = View.GONE
                    binding?.tvNoDataAvailable?.visibility = View.VISIBLE
                }
            }
        }

    }
}