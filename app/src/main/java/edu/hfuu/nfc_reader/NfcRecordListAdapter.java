package edu.hfuu.nfc_reader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hfuu.nfc_reader.db.NfcRecord;

/**
 Created by mr.lgb
 * Date: 2017/8/6.
 */
public class NfcRecordListAdapter extends BaseAdapter {
    private Context context;
    private List<NfcRecord> orderList;

    public NfcRecordListAdapter(Context context, List<NfcRecord> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        NfcRecord order = orderList.get(position);
        if (order == null){
            return null;
        }

        ViewHolder holder = null;
        if (view != null){
            holder = (ViewHolder) view.getTag();
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.show_sql_item, null);

            holder = new ViewHolder();
            holder.recordSNIdTextView = (TextView) view.findViewById(R.id.nfcRecordIdTextView);
            holder.recordRFIDTextView = (TextView) view.findViewById(R.id.nfcIDTextView);
            holder.recordTimeTextView = (TextView) view.findViewById(R.id.nfcRecordTimeTextView);

            view.setTag(holder);
        }

        holder.recordSNIdTextView.setText(order.id + "");
        holder.recordRFIDTextView.setText(order.nfcId);
        holder.recordTimeTextView.setText(order.recordTime + "");

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public static class ViewHolder{
        public TextView recordSNIdTextView;
        public TextView recordRFIDTextView;
        public TextView recordTimeTextView;
    }
}
