package com.test.mybitcoin.history;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.mybitcoin.history.model.HistoryItem;
import com.test.mybitcoin.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder> {

    private List<HistoryItem> itemList = new ArrayList<>();
    private Context context;

    public HistoryRecyclerAdapter(List<HistoryItem> itemList, Context context) {
        this.itemList.addAll(itemList);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(itemList.get(i).getStatus() == 1){
            viewHolder.imageStatus.setImageResource(R.drawable.status_positive_icon);
            viewHolder.textStatus.setText(context.getResources().getString(R.string.status_positive));
        }else{
            if(itemList.get(i).getStatus() == -1){
                viewHolder.imageStatus.setImageResource(R.drawable.status_negative_icon);
                viewHolder.textStatus.setText(context.getResources().getString(R.string.status_negative));
            }else{
                viewHolder.imageStatus.setImageResource(R.drawable.status_neitrale_icon);
                viewHolder.textStatus.setText(context.getResources().getString(R.string.status_neitral));
            }
        }
        viewHolder.textDate.setText(context.getResources().getString(R.string.date) + itemList.get(i).getDate());
        viewHolder.textNumber.setText(context.getResources().getString(R.string.number) + itemList.get(i).getNumber());
        viewHolder.textReceived.setText(context.getResources().getString(R.string.received) + itemList.get(i).getReceived());
        viewHolder.textCost.setText(context.getResources().getString(R.string.cost) + itemList.get(i).getCost());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageStatus;
        TextView textStatus,
                textDate,
                textNumber,
                textReceived,
                textCost;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageStatus = itemView.findViewById(R.id.imageStatus);
            textStatus = itemView.findViewById(R.id.textStatus);
            textDate = itemView.findViewById(R.id.textDate);
            textNumber = itemView.findViewById(R.id.textNumber);
            textReceived = itemView.findViewById(R.id.textReceived);
            textCost = itemView.findViewById(R.id.textCost);
        }
    }
}
