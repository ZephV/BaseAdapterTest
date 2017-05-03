package com.example.zeph.baseadaptertest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class BaseAdapter extends android.widget.BaseAdapter {

  private List<ItemBeam> mList;
  private LayoutInflater mLayoutInflater;

  public BaseAdapter(Context context, List<ItemBeam> list) {
    mList = list;
    mLayoutInflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
    //适配器中数据集中数据的个数
    return mList.size();
  }

  @Override
  public Object getItem(int position) {
    //获取数据集中与指定索引对应的数据
    return mList.get(position);
  }

  @Override
  public long getItemId(int position) {
    //获取指定对应的ID
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    //获取每个Item显示的内容
    ViewHolder viewHolder;
    if (convertView == null) {
      viewHolder = new ViewHolder();
      convertView = mLayoutInflater.inflate(R.layout.listview_main_item, null);
      viewHolder.imageView = (ImageView) convertView.findViewById(R.id.lv_img);
      viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
      viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
      convertView.setTag(viewHolder);
    }else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    ItemBeam beam = mList.get(position);
    viewHolder.imageView.setImageResource(beam.imgId);
    viewHolder.title.setText(beam.itemTitle);
    viewHolder.tvContent.setText(beam.itemContent);
    return convertView;
  }

  class ViewHolder {

    ImageView imageView;
    TextView title;
    TextView tvContent;
  }
}
