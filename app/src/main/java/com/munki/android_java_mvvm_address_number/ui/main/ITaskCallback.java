package com.munki.android_java_mvvm_address_number.ui.main;

import androidx.databinding.ObservableArrayList;

/**
 * [MVVM] ITaskCallback
 * @author 나비이쁜이
 * @since 2020.10.05
 */
public interface ITaskCallback {
    void returnList(ObservableArrayList<String> resultList);
}
