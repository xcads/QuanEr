package com.example.imagedemo;

import java.util.ArrayList;

import com.photo.activity.MainActivity1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<ItemEntity> itemEntities;

	private ListView listview;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
		initData();
		listview.setAdapter(new ListItemAdapter(this, itemEntities));
		button = (Button) findViewById(R.id.button);
		ButtonListener buttonListener = new ButtonListener();
		button.setOnClickListener(buttonListener);
	}

	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MainActivity1.class);
			startActivity(intent);
		}
		
	}
	
	private void initData() {
		itemEntities = new ArrayList<ItemEntity>();

		ItemEntity entity1 = new ItemEntity(
				"http://img4.duitang.com/uploads/item/201508/07/20150807093119_ykQRK.png", "name", "12345...", null);
		itemEntities.add(entity1);

		ArrayList<String> urls_1 = new ArrayList<String>();
		urls_1.add("http://www.jf258.com/touxiang/img_d.hiphotos.baidu.com/image/h%3D220/sign=5eae034c9558d109dbe3aeb0e159ccd0/5366d0160924ab1814d1810532fae6cd7b890b38.jpg");
		ItemEntity entity2 = new ItemEntity(
				"http://img4.duitang.com/uploads/item/201508/07/20150807093119_ykQRK.png", "name", "12345...", urls_1);
		itemEntities.add(entity2);

		ArrayList<String> urls_2 = new ArrayList<String>();
		urls_2.add("http://www.jf258.com/touxiang/img_d.hiphotos.baidu.com/image/h%3D220/sign=5eae034c9558d109dbe3aeb0e159ccd0/5366d0160924ab1814d1810532fae6cd7b890b38.jpg");
		urls_2.add("http://www.jf258.com/touxiang/img_img5.imgtn.bdimg.com/it/u=1676741984,3491679787@fm=21@gp=0.jpg");
		urls_2.add("http://www.jf258.com/touxiang/img_img2.imgtn.bdimg.com/it/u=3365970640,1309779710@fm=21@gp=0.jpg");
		ItemEntity entity3 = new ItemEntity(
				"http://img4.duitang.com/uploads/item/201508/07/20150807093119_ykQRK.png", "name", "12345...", urls_2);
		itemEntities.add(entity3);

		ArrayList<String> urls_3 = new ArrayList<String>();
		urls_3.add("http://www.jf258.com/touxiang/img_d.hiphotos.baidu.com/image/h%3D220/sign=5eae034c9558d109dbe3aeb0e159ccd0/5366d0160924ab1814d1810532fae6cd7b890b38.jpg");
		urls_3.add("http://www.jf258.com/touxiang/img_img5.imgtn.bdimg.com/it/u=1676741984,3491679787@fm=21@gp=0.jpg");
		urls_3.add("http://www.jf258.com/touxiang/img_img2.imgtn.bdimg.com/it/u=3365970640,1309779710@fm=21@gp=0.jpg");
		urls_3.add("http://www.jf258.com/touxiang/img_img2.imgtn.bdimg.com/it/u=3548381912,3662390956@fm=21@gp=0.jpg");
		urls_3.add("http://www.jf258.com/touxiang/img_img1.imgtn.bdimg.com/it/u=1184617218,496222579@fm=21@gp=0.jpg");
		urls_3.add("http://www.jf258.com/touxiang/img_img1.imgtn.bdimg.com/it/u=1344511279,765113862@fm=21@gp=0.jpg");
		ItemEntity entity4 = new ItemEntity(//
				"http://img4.duitang.com/uploads/item/201508/07/20150807093119_ykQRK.png", "name", "12345...", urls_3);
		itemEntities.add(entity4);
	}
}
