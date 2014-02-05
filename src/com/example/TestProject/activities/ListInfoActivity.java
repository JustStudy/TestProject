package com.example.TestProject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.TestProject.R;

/**
 * Created by Ruslik on 05.02.14.
 */
public class ListInfoActivity extends ActionBarActivity {
    ListView listViewNames;
    String[] namesArray;
    String[] descriptionsArray;
    Intent intentData;


    private String[] buffernamesArray;
    private String[] bufferdescriptionsArray;
    SimpleListViewAdapter simpleListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_info_layout);
        buffernamesArray = getResources().getStringArray(R.array.array_of_headers);
        bufferdescriptionsArray = getResources().getStringArray(R.array.description_array);
        listViewNames = (ListView) findViewById(R.id.listViewNames);

        if (savedInstanceState == null) {
            reloadItems();

        }

        listViewNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intentData = new Intent(ListInfoActivity.this, DetailInfoActivity.class);
                intentData.putExtra(Constants.NAME_FOR_INTENT_STRING_TITLE, namesArray[position]);
                intentData.putExtra(Constants.NAME_FOR_INTENT_STRING_DESC, descriptionsArray[position]);
                startActivity(intentData);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    private void reloadItems() {

        //Определяем начальную позицию для для псевдослучайного заполнения списка
        int position = new Double(Math.random() * 10).intValue();

        namesArray = new String[Constants.COUNT_LIST];
        descriptionsArray = new String[Constants.COUNT_LIST];

        for (int i = 0; i < Constants.COUNT_LIST; i++) {
            if (position >= getResources().getStringArray(R.array.array_of_headers).length) {
                position = 0;
            }

            namesArray[i] = buffernamesArray[position];
            descriptionsArray[i] = bufferdescriptionsArray[position];
            position++;
        }

        setSimpleListViewAdapter();

    }

    private void setSimpleListViewAdapter() {
        simpleListViewAdapter = new SimpleListViewAdapter(this,
                R.layout.one_list_item_layout, namesArray);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                listViewNames.setAdapter(simpleListViewAdapter);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.reload_act_bar_button:
                reloadItems();
                break;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArray(Constants.SAVE_NAME_STRING_TITLES, namesArray);
        outState.putStringArray(Constants.SAVE_DESC_STRING_ARRAY_DESC, descriptionsArray);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        namesArray = savedInstanceState.getStringArray(Constants.SAVE_NAME_STRING_TITLES);
        descriptionsArray = savedInstanceState.getStringArray(Constants.SAVE_DESC_STRING_ARRAY_DESC);
        setSimpleListViewAdapter();
    }
}
