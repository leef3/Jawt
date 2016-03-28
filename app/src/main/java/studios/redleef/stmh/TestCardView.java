package studios.redleef.stmh;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.redleefstudios.redleeflibrary.Helpers.TwoLineDataObject;
import com.redleefstudios.redleeflibrary.Helpers.ListRecyclerAdapter;

import java.util.ArrayList;

public class TestCardView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_card_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data fro recycler view

        ArrayList<TwoLineDataObject> data = new ArrayList<TwoLineDataObject>();
        for(int x = 0 ; x < 10; x++)
        {
            TwoLineDataObject toAdd = new TwoLineDataObject("This is the large text", "This is the small text", com.redleefstudios.redleeflibrary.R.drawable.ico_business_male);
            data.add(toAdd);
        }

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        ListRecyclerAdapter mAdapter = new ListRecyclerAdapter(data);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

}
