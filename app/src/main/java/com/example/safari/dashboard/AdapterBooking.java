package com.example.safari.dashboard;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.safari.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ImageViewHolder> {
    private Context mContext;
    private List<Booking> mUploads;
    private OnItemClickListener mListener;

    public AdapterBooking(Context mContext, List<Booking> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.booking_layout,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Booking uploadCurrent = mUploads.get(position);
        holder.mTvFirstName.setText(uploadCurrent.getFirstname());
        holder.mTvLastName.setText(uploadCurrent.getLastname());
        holder.mTvHotelName.setText(uploadCurrent.getHotelname());
        holder.mTvRoomType.setText(uploadCurrent.getRoomtype());
        holder.mTvDate.setText(uploadCurrent.getDate());

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        public TextView mTvFirstName,mTvLastName,mTvHotelName,mTvRoomType,mTvDate;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mTvFirstName = itemView.findViewById(R.id.tv_first_name);
            mTvLastName = itemView.findViewById(R.id.tv_last_name);
            mTvHotelName = itemView.findViewById(R.id.tv_hotel_name);
            mTvRoomType = itemView.findViewById(R.id.tv_room_type);
            mTvDate = itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener!=null){
                //Get the position of the clicked item
                int position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }
        // Handle Menu Items
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1,"Do Whatever");
            MenuItem delete = menu.add(Menu.NONE,2,2,"Delete");
            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener!=null){
                //Get the position of the clicked item
                int position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    switch (item.getItemId()){
                        case 1:
                            mListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public void setSearchOperation(List<Booking> newList){
        mUploads = new ArrayList<>();
        mUploads.addAll(newList);
        notifyDataSetChanged();
    }
}