package com.example.app_libsys.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_libsys.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-13.
 */
public class NoticeListViewAdapter extends BaseAdapter {
    private LayoutInflater inflate;
    private List<String> list;
    private ArrayList<NoticeItem> data;
    private int layout;


    public NoticeListViewAdapter(Context context, int layout, ArrayList<NoticeItem> data) {
        this.inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }
    @Override
    public int getCount() { //리스트 안 Item의 개수를 센다.
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflate.inflate(layout, parent, false);
        }
        NoticeItem noticeItem = data.get(position);


        final ImageView imageView = convertView.findViewById(R.id.imageView);

        if (noticeItem.getImage().equals("0")) {

        } else  {
            imageView.setImageResource(R.drawable.ic_image);
        }

        TextView title = convertView.findViewById(R.id.titleView);
        title.setText(noticeItem.getTitle());

        TextView text = convertView.findViewById(R.id.descView);
        text.setText(noticeItem.getText());

        TextView nickname = convertView.findViewById(R.id.userIdView);
        nickname.setText(noticeItem.getName());

        return convertView;
    }
}