package wanmao.csrms.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import wanmao.csrms.R;
/*
 * Created by a1111 on 17/9/28.
 */

public class FragmentFactory {
    public static Fragment fragment;
    public static String currentFragment="";
    public static Fragment getFragmentInstance(FragmentManager fragmentManager, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        currentFragment=tag;
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
        if(tag.equals(GaodeMapFragment.TAG)){
            fragment = new GaodeMapFragment();
            fragmentTransaction.replace(R.id.fl_base,fragment);
        }
        if(tag.equals(GaodeMapFragment2.TAG)){
            fragment = new GaodeMapFragment2();
            fragmentTransaction.replace(R.id.fl_base,fragment);
        }
        if(tag.equals(EventFragment.TAG)){
            fragment = new EventFragment();
            fragmentTransaction.replace(R.id.fl_base,fragment);
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
        return fragment;
    }
}