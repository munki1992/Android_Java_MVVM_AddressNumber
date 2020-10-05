package com.munki.android_java_mvvm_address_number.di.builder;

import com.munki.android_java_mvvm_address_number.ui.main.MainActivity;
import com.munki.android_java_mvvm_address_number.ui.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * [Dagger] Module - 생성 공급자
 * @author 나비이쁜이
 * @since 2020.10.05
 */
@Module
public abstract class ActivityBuilder {

    /**
     * Module 지정(Component 위치 지정) -> Inject 위치 지정
     */

    // LoginActivity
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();
}