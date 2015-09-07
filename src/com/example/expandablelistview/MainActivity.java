package com.example.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

/* expandableListView可以想像成很多個ListView被整合在一個可以開關的ListView內 
 * 在結構上會比ListView多一層 */
public class MainActivity extends Activity {

	private String[] lunch = {
		"飯類","麵類","小菜"
	};
	private String[][] lunch_class = {
		{"滷肉飯","雞腿飯","排骨飯","雞排飯","豬腳飯"},
		{"陽春麵","榨菜肉絲麵","餛飩麵","牛肉麵","乾麵"},
		{"豆干","豆腐","豬皮","海帶","滷蛋"}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ExpandableListView expandList = (ExpandableListView) findViewById(R.id.expandableListView1);
		
		ArrayList<ArrayList<HashMap<String,String>>> childData = new ArrayList<ArrayList<HashMap<String,String>>>();
		ArrayList<HashMap<String,String>> groupData  = new ArrayList<HashMap<String,String>>();

		for (int i = 0; i < lunch.length; i++) {
			// 加入種類:飯,麵,小菜
			HashMap<String, String> curGroupMap = new HashMap<String, String>();
		    curGroupMap.put("class", lunch[i]);
		    groupData.add(curGroupMap);
		           
		    ArrayList<HashMap<String, String>> children = new ArrayList<HashMap<String, String>>();
		    for (int j = 0; j <lunch_class[i].length ; j++) {
		    	// 加入內層詳細資料
		    	HashMap<String, String> curChildMap = new HashMap<String, String>();
		        curChildMap.put("name", lunch_class[i][j]);
		        children.add(curChildMap);
		    }
		    childData.add(children);
		}
		SimpleExpandableListAdapter mAdapter = new SimpleExpandableListAdapter(
	    	this,
            groupData,  //先加入外層的種類資料
            android.R.layout.simple_expandable_list_item_1,
            new String[] {"class"},
            new int[] {android.R.id.text1},
            childData,   // 加入內層的詳細資料
            android.R.layout.simple_expandable_list_item_1,
            new String[] {"name"},
            new int[] {android.R.id.text1}
	    );
		expandList.setAdapter(mAdapter);
	}

}
