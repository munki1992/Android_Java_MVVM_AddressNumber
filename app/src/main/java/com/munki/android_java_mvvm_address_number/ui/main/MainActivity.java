package com.munki.android_java_mvvm_address_number.ui.main;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.munki.android_java_mvvm_address_number.R;
import com.munki.android_java_mvvm_address_number.databinding.ActivityMainBinding;
import com.munki.android_java_mvvm_address_number.ui.base.BaseActivity;
import com.munki.android_java_mvvm_address_number.util.PermissionUtil;

import javax.inject.Inject;

import static com.munki.android_java_mvvm_address_number.BR.main;

/**
 * [MVVM] MainActivity
 * @author 나비이쁜이
 * @since 2020.10.05
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    // - this.binding & this.viewmodel
    private ActivityMainBinding mBinding;
    @Inject MainViewModel mViewModel;

    /************************************************************************************************************************************************/

    /**
     * Binding variable
     */
    @Override
    public int getBindingVariable() {
        return main;
    }

    /**
     * Resoucres Layout
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * ViewModel
     */
    @Override
    public MainViewModel getViewModel() {
        mViewModel.setNavigation(this);
        return mViewModel;
    }

    /************************************************************************************************************************************************/

    /**
     * onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();

        // observer init
        ObserverInit();
    }

    /**
     * Observer & Init
     */
    @Override
    protected void ObserverInit() {
        super.ObserverInit();

        // 권한 확인
        boolean isREAD_CONTACTS = PermissionUtil.checkAndRequestPermission(this, 1, Manifest.permission.READ_CONTACTS);

        if (isREAD_CONTACTS)
            new MainTask(this, resultList -> {
                mViewModel.contactList = resultList;
                MainViewModel.bindContactListItem(mBinding.rvWord, mViewModel.contactList);
            }).execute();
    }

    /**
     * onRequestPermissionsResult
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (PermissionUtil.verifyPermissions(grantResults)) {
            switch (requestCode) {
                case 1:
                    new MainTask(this, resultList -> {
                        mViewModel.contactList = resultList;
                        MainViewModel.bindContactListItem(mBinding.rvWord, mViewModel.contactList);
                    }).execute();
                    break;
            }
        }
    }
}