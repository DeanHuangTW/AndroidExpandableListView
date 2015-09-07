package com.example.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

/* expandableListView�i�H�Q�����ܦh��ListView�Q��X�b�@�ӥi�H�}����ListView�� 
 * �b���c�W�|��ListView�h�@�h */
public class MainActivity extends Activity {

	private String[] lunch = {
		"����","����","�p��"
	};
	private String[][] lunch_class = {
		{"���׶�","���L��","�ư���","���ƶ�","�޸}��"},
		{"���K��","�^��׵���","�_����","������","����"},
		{"���z","���G","�ޥ�","���a","���J"}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ExpandableListView expandList = (ExpandableListView) findViewById(R.id.expandableListView1);
		
		ArrayList<ArrayList<HashMap<String,String>>> childData = new ArrayList<ArrayList<HashMap<String,String>>>();
		ArrayList<HashMap<String,String>> groupData  = new ArrayList<HashMap<String,String>>();

		for (int i = 0; i < lunch.length; i++) {
			// �[�J����:��,��,�p��
			HashMap<String, String> curGroupMap = new HashMap<String, String>();
		    curGroupMap.put("class", lunch[i]);
		    groupData.add(curGroupMap);
		           
		    ArrayList<HashMap<String, String>> children = new ArrayList<HashMap<String, String>>();
		    for (int j = 0; j <lunch_class[i].length ; j++) {
		    	// �[�J���h�ԲӸ��
		    	HashMap<String, String> curChildMap = new HashMap<String, String>();
		        curChildMap.put("name", lunch_class[i][j]);
		        children.add(curChildMap);
		    }
		    childData.add(children);
		}
		SimpleExpandableListAdapter mAdapter = new SimpleExpandableListAdapter(
	    	this,
            groupData,  //���[�J�~�h���������
            android.R.layout.simple_expandable_list_item_1,
            new String[] {"class"},
            new int[] {android.R.id.text1},
            childData,   // �[�J���h���ԲӸ��
            android.R.layout.simple_expandable_list_item_1,
            new String[] {"name"},
            new int[] {android.R.id.text1}
	    );
		expandList.setAdapter(mAdapter);
	}

}
