package com.munki.android_java_mvvm_address_number.ui.main;

import com.munki.android_java_mvvm_address_number.GlobalApplication;

import dagger.Module;
import dagger.Provides;

/**
 * [Dagger] - Inject with ViewModel
 * @author 나비이쁜이
 * @since 2020.10.05
 */
@Module
public class MainModule {

    @Provides
    MainViewModel createViewModel(GlobalApplication application) {
        return new MainViewModel(application);
    }
}