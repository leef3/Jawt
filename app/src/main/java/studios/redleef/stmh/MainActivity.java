package studios.redleef.stmh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//For Data Save
//GSON Serializable Data
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class MainActivity extends Activity {

    private static ArrayList<String> itemList;
    private static EditText newItem;
    private static ItemListAdapter mAdapter;
    private static Context context;
    private static TextView emptyText;

    private final static String MASTER_SAVE_NAME = "MASTER_SAVE_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = this;

        emptyText = (TextView)findViewById(R.id.emptyText);

        itemList = new ArrayList<String>();
        loadSavedList();
        ListView itemListView = (ListView)findViewById(R.id.itemListView);
        mAdapter = new ItemListAdapter(this, itemList);
        itemListView.setAdapter(mAdapter);

        itemListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                itemList.remove(position);
                mAdapter.notifyDataSetChanged();
                updateSavedList();
                return true;
            }
        });



        Button addItem = (Button)findViewById(R.id.addButton);

        newItem = (EditText)findViewById(R.id.newItemEntry);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newItem.getText().length() > 0)
                {
                    itemList.add(newItem.getText() + "");
                    updateSavedList();
                    newItem.setText("");
                    mAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(context, "You should add text!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private static void loadSavedList()
    {
        SharedPreferences settings = context.getSharedPreferences("pref", 0);
        settings = context.getSharedPreferences("pref", 0);
        String objectData = settings.getString(MASTER_SAVE_NAME, "");
        if (!objectData.equals("")) {
            System.out.println("Object Data: " + objectData);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<String>>() {
            }.getType();
            JsonArray jArray = new JsonParser().parse(objectData).getAsJsonArray();
            for (JsonElement e : jArray) {
                String c = gson.fromJson(e, String.class);
                itemList.add(c);
            }
        }

        if(itemList.size() < 1)
        {
            emptyText.setVisibility(View.VISIBLE);
        }
        else
        {
            emptyText.setVisibility(View.GONE);
        }
    }

    private static void updateSavedList()
    {
        SharedPreferences.Editor settings = context.getSharedPreferences("pref",0).edit();
        String data = new Gson().toJson(itemList);
        System.out.println("Data!: " + data);
        settings.putString(MASTER_SAVE_NAME, data);
        settings.commit();

        if(itemList.size() < 1)
        {
            emptyText.setVisibility(View.VISIBLE);
        }
        else
        {
            emptyText.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
