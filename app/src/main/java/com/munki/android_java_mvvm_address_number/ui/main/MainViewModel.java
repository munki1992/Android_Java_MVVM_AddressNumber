package com.munki.android_java_mvvm_address_number.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.munki.android_java_mvvm_address_number.ui.base.BaseViewModel;

/**
 * [MainActivity] View Model
 * @author 나비이쁜이
 * @since 2020.10.05
 */
public class MainViewModel extends BaseViewModel<MainNavigator> {

    // - Word
    public MainAdapter adapter;
    public ObservableArrayList<String> contactList;

    /**
     * 생성자
     */
    MainViewModel(@NonNull Application application) {
        super(application);

        contactList = new ObservableArrayList<>();
        adapter = new MainAdapter(application);
    }

    /************************************************************************************************************************************************/

    /* Listener Databinding */

    // [Binding] setAdapter
    @BindingAdapter("setContactListAdapter")
    public static void bindContactListAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setAdapter(adapter);
    }

    // [Binding] setItem
    @BindingAdapter("setContactListName")
    public static void bindContactListItem(RecyclerView recyclerView, ObservableArrayList<String> dataList) {
        MainAdapter adapter = (MainAdapter) recyclerView.getAdapter();

        if (adapter != null)
            adapter.setItem(dataList);
    }
}