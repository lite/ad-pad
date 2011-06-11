package com.fssle.adpad;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import greendroid.app.GDListActivity;            
import greendroid.widget.AsyncImageView;

public class RidersActivity extends GDListActivity implements OnScrollListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new MyAdapter(this));
        getListView().setOnScrollListener(this);
    }

    private static class MyAdapter extends BaseAdapter {

        private static final String BASE_URL_PREFIX = "http://www.cyrilmottier.com/files/greendroid/images/image";
        private static final String BASE_URL_SUFFIX = ".png";
        private static final StringBuilder BUILDER = new StringBuilder();
                                               
        static class ViewHolder {
            public AsyncImageView imageView;
            public TextView textView;
            public StringBuilder textBuilder = new StringBuilder();
        }

        private LayoutInflater mInflater;
        
        public MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return 20;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.riders_view, parent, false); 
                holder = new ViewHolder();
                holder.imageView = (AsyncImageView) convertView.findViewById(R.id.async_image);
                holder.textView = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            BUILDER.setLength(0);
            BUILDER.append(BASE_URL_PREFIX);
            BUILDER.append(position);
            BUILDER.append(BASE_URL_SUFFIX);
            holder.imageView.setUrl(BUILDER.toString());

            final StringBuilder textBuilder = holder.textBuilder;
            textBuilder.setLength(0);
            textBuilder.append("Photo");
            textBuilder.append(position);
            holder.textView.setText(textBuilder);

            return convertView;
        }
    }

    public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
    }

    public void onScrollStateChanged(AbsListView listView, int scrollState) {
        if (getListView() == listView) {
            searchAsyncImageViews(listView, scrollState == OnScrollListener.SCROLL_STATE_FLING);
        }
    }

    private void searchAsyncImageViews(ViewGroup viewGroup, boolean pause) {
        final int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AsyncImageView image = (AsyncImageView) viewGroup.getChildAt(i).findViewById(R.id.async_image);
            if (image != null) {
                image.setPaused(pause);
            }
        }
    }

}
