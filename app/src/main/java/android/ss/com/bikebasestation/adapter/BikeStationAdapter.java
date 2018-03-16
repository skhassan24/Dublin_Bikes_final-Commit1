package android.ss.com.bikebasestation.adapter;

import android.ss.com.bikebasestation.R;
import android.ss.com.bikebasestation.model.ItemBikeStation;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// Kh Sipar Hassan , id 16045
public class BikeStationAdapter extends RecyclerView.Adapter<BikeStationAdapter.ViewHolder> {

    List<ItemBikeStation> bikeStationList;

    public BikeStationAdapter(List<ItemBikeStation> bikeStationList) {
        this.bikeStationList = bikeStationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bike_station, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemBikeStation itemBikeStation = bikeStationList.get(position);

        holder.tv_address.setText(itemBikeStation.getAddress());
        holder.tv_name.setText(itemBikeStation.getName());
        holder.tv_number.setText("Number: "+itemBikeStation.getNumber());

    }

    @Override
    //Getting the count of number f items in JSON.
    public int getItemCount() {
        return bikeStationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_address, tv_number;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_number = (TextView) itemView.findViewById(R.id.tv_number);

        }
    }
}
