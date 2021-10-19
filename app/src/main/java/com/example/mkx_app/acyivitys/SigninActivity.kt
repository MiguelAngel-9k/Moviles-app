package com.example.mkx_app.acyivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.mkx_app.R
import com.example.mkx_app.adapters.SigninViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SigninActivity : AppCompatActivity() {

    private val signinAdapter by lazy { SigninViewPagerAdapter(this) }

    companion object{
        private const val ACCOUNT = 0
        private const val INFORMATION = 1
        private const val ADDRESS = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signinPager = findViewById<ViewPager2>(R.id.signinPager)
        signinPager.adapter = this.signinAdapter

        val signinTab = findViewById<TabLayout>(R.id.signinTablayout)

        val tabLayoutMediator = TabLayoutMediator(signinTab, signinPager, TabLayoutMediator.TabConfigurationStrategy{
            tab,
            position->
            when(position){
                ACCOUNT->{
                    tab.setText("Account")
                    tab.setIcon(R.drawable.ic_email_24)
                }
                INFORMATION->{
                    tab.setText("Information")
                    tab.setIcon(R.drawable.ic_person_24)
                }
                ADDRESS->{
                    tab.setText("Address")
                    tab.setIcon(R.drawable.ic_house_24)
                }
            }
        }).attach()

    }
}