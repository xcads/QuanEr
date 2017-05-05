package com.photo.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.photo.adapter.FolderAdapter;
import com.photo.util.Bimp;
import com.photo.util.PublicWay;
import com.photo.util.Res;

/**
 * �������Ҫ������������ʾ����ͼƬ���ļ���
*/
public class ImageFile extends Activity {

	private FolderAdapter folderAdapter;
	private Button bt_cancel;
	private Context mContext;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(Res.getLayoutID("plugin_camera_image_file"));
		PublicWay.activityList.add(this);
		mContext = this;
		bt_cancel = (Button) findViewById(Res.getWidgetID("cancel"));
		bt_cancel.setOnClickListener(new CancelListener());
		GridView gridView = (GridView) findViewById(Res.getWidgetID("fileGridView"));
		TextView textView = (TextView) findViewById(Res.getWidgetID("headerTitle"));
		textView.setText(Res.getString("photo"));
		folderAdapter = new FolderAdapter(this);
		gridView.setAdapter(folderAdapter);
	}

	private class CancelListener implements OnClickListener {// ȡ����ť�ļ���
		public void onClick(View v) {
			//���ѡ���ͼƬ
			Bimp.tempSelectBitmap.clear();
			Intent intent = new Intent();
			intent.setClass(mContext, MainActivity1.class);
			startActivity(intent);
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();
			intent.setClass(mContext, MainActivity1.class);
			startActivity(intent);
		}
		
		return true;
	}

}