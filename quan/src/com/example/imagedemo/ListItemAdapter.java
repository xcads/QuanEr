package com.example.imagedemo;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListItemAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<ItemEntity> items;

	public ListItemAdapter(Context ctx, ArrayList<ItemEntity> items) {
		this.mContext = ctx;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(mContext, R.layout.item_list, null);
			holder.iv_avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
			holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			holder.gridview = (NoScrollGridView) convertView.findViewById(R.id.gridview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ItemEntity itemEntity = items.get(position);
		holder.tv_title.setText(itemEntity.getTitle());
		holder.tv_content.setText(itemEntity.getContent());

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.bitmapConfig(Config.RGB_565)
				.build();
		ImageLoader.getInstance().displayImage(itemEntity.getAvatar(), holder.iv_avatar, options);
		final ArrayList<String> imageUrls = itemEntity.getImageUrls();
		if (imageUrls == null || imageUrls.size() == 0) {
			holder.gridview.setVisibility(View.GONE);
		} else {
			holder.gridview.setAdapter(new NoScrollGridAdapter(mContext, imageUrls));
		}

		holder.gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				imageBrower(position, imageUrls);
			}
		});
		return convertView;
	}

	protected void imageBrower(int position, ArrayList<String> urls2) {
		Intent intent = new Intent(mContext, ImagePagerActivity.class);

		intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls2);
		intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
		mContext.startActivity(intent);
	}

	class ViewHolder {
		private ImageView iv_avatar;
		private TextView tv_title;
		private TextView tv_content;
		private NoScrollGridView gridview;
	}
}
