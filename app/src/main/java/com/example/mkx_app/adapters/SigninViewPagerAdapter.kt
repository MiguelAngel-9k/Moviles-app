package com.example.mkx_app.adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mkx_app.fragments.AccountFragment
import com.example.mkx_app.fragments.AddressFragment
import com.example.mkx_app.fragments.InformationFragment

class SigninViewPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    companion object{
        private const val ACCOUNT = 0
        private const val INFORMATION = 1
        private const val ADDRESS = 2
        private const val OBJECT = "Object"
    }

    override fun getItemCount(): Int = 3 //Total fragments

    override fun createFragment(position: Int): Fragment {

        when(position){
            ACCOUNT->{
                return AccountFragment()
            }
            INFORMATION->{
                return InformationFragment()
            }
            ADDRESS->{
                return AddressFragment()
            }
        }


        return AccountFragment()

    }

}

//A way to pass information entre fragments
//val fragment = AccountFragment()
//fragment.arguments = Bundle.apply{
//putInt(OBJECT, position + 1)