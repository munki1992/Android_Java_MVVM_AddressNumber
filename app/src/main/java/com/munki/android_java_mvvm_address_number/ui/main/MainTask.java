package com.munki.android_java_mvvm_address_number.ui.main;

import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.databinding.ObservableArrayList;

import java.lang.ref.WeakReference;

/**
 * [MVVM] MainTask
 * @author 나비이쁜이
 * @since 2020.10.05
 */
public class MainTask extends AsyncTask<Void, Void, ObservableArrayList<String>> {

    private WeakReference<MainActivity> mContext;
    private ITaskCallback mCallback;

    /**
     * 생성자
     */
    public MainTask(MainActivity context, ITaskCallback callback) {
        mContext = new WeakReference<>(context);
        this.mCallback = callback;
    }

    /**
     * onPreExecute
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * doInBackground
     */
    @Override
    protected ObservableArrayList<String> doInBackground(Void... voids) {
        // Result ArrayList
        ObservableArrayList<String> contacts = new ObservableArrayList<>();

        // Cursor
        Cursor cursor = mContext.get().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        if (cursor == null) return null;

        // Work Cursor
        while (cursor.moveToNext()) {
            // Name + Number
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            // Result
            contacts.add(contactName + " : " + phoneNumber);
        }

        // Close
        cursor.close();

        // Return
        return contacts;
    }

    /**
     * onPostExecute
     */
    @Override
    protected void onPostExecute(ObservableArrayList<String> strings) {
        super.onPostExecute(strings);

        if (mCallback != null) mCallback.returnList(strings);
    }
}
