package com.fssle.adpad; 

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
 
/**
 * List adapter decorator that inserts adverts into the list.
 * @author Daniel Dyer
 */
public class AdvertisingAdapter extends BaseAdapter
{
    private static final String ADMOB_PUBLISHER_ID = "YOUR_ADMOB_ID_HERE";
 
    private final Activity activity;
    private final BaseAdapter delegate;
 
    public AdvertisingAdapter(Activity activity, BaseAdapter delegate)
    {
        this.activity = activity;
        this.delegate = delegate;
        delegate.registerDataSetObserver(new DataSetObserver()
        {
            @Override
            public void onChanged()
            {
                notifyDataSetChanged();
            }
 
            @Override
            public void onInvalidated()
            {
                notifyDataSetInvalidated();
            }
        });
    }
 
    public int getCount()
    {
        return delegate.getCount() + 1;
    }
 
    public Object getItem(int i)
    {
        return delegate.getItem(i - 1);
    }
 
    public long getItemId(int i)
    {
        return delegate.getItemId(i - 1);
    }
 
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (position == 0)
        {
            if (convertView instanceof AdView)
            {
                return convertView;
            }
            else
            {
                AdView adView = new AdView(activity, AdSize.BANNER, ADMOB_PUBLISHER_ID);
                // Disable focus for sub-views of the AdView to avoid problems with
                // trackpad navigation of the list.
                for (int i = 0; i < adView.getChildCount(); i++)
                {
                    adView.getChildAt(i).setFocusable(false);
                }
                adView.setFocusable(false);
                // Default layout params have to be converted to ListView compatible
                // params otherwise there will be a ClassCastException.
                float density = activity.getResources().getDisplayMetrics().density;
                int height = Math.round(AdSize.BANNER.getHeight() * density);
                AbsListView.LayoutParams params
                    = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT,
                                                   height);
                adView.setLayoutParams(params);
                adView.loadAd(new AdRequest());
                return adView;
            }
        }
        else
        {
            return delegate.getView(position - 1, convertView, parent);
        }
    }
 
    @Override
    public int getViewTypeCount()
    {
        return delegate.getViewTypeCount() + 1;
    }
 
    @Override
    public int getItemViewType(int position)
    {
        return position == 0 ? delegate.getViewTypeCount()
                             : delegate.getItemViewType(position - 1);
    }
 
    @Override
    public boolean areAllItemsEnabled()
    {
        return false;
    }
 
    @Override
    public boolean isEnabled(int position)
    {
        return position != 0 && delegate.isEnabled(position - 1);
    }
}