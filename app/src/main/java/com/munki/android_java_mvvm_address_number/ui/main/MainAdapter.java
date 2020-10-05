package com.munki.android_java_mvvm_address_number.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.munki.android_java_mvvm_address_number.R;
import com.munki.android_java_mvvm_address_number.databinding.ItemRecyclerviewBinding;
import com.munki.android_java_mvvm_address_number.ui.base.BaseViewHolder;

/**
 * BaseViewHolder
 * @author 나비이쁜이
 * @since 2020.10.05
 */
public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder<String>> {

    /**
     * Context & Word
     */
    private Context mContext;
    private ObservableArrayList<String> dataList;

    /**
     * 생성자
     */
    public MainAdapter(Context context) {
        this.mContext = context;
        dataList = new ObservableArrayList<>();
    }

    /**
     * onCreateViewHolder
     */
    @NonNull
    @Override
    public BaseViewHolder<String> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false));
    }

    /**
     * onBindViewHolder
     */
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<String> holder, int position) {
        holder.bind(dataList.get(holder.getLayoutPosition()), position);
    }

    /**
     * getItemCount
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /************************************************************************************************************************************************/

    /**
     * setItem
     */
    public void setItem(ObservableArrayList<String> dataList) {
        if (dataList == null)
            return;

        this.dataList = dataList;
        notifyDataSetChanged();
    }

    /************************************************************************************************************************************************/

    /**
     * 뷰 활용을 위한 Viewholder
     */
    public static class ViewHolder extends BaseViewHolder<String> {

        /**
         * itemView Databinding
         */
        ItemRecyclerviewBinding mBinding;

        /**
         * 생성자
         */
        ViewHolder(@NonNull View view) {
            super(view);
            mBinding = DataBindingUtil.bind(view);
        }

        /**
         * Bind
         */
        @Override
        public void bind(String itemVo, Integer position) {
            mBinding.tvName.setText(itemVo);
        }
    }
}
