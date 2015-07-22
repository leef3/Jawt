package studios.redleef.stmh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fred Lee on 7/21/2015.
 */
public class ItemListAdapter extends BaseAdapter
{
    Context context;
    protected ArrayList<String> itemList;
    LayoutInflater inflater;

    public ItemListAdapter(Context context, ArrayList<String> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return itemList.size();
    }
    public String getItem(int position)
    {
        return itemList.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.list_item, parent, false);

            //Find UI elements for Pay, Name, and Days
            holder.text = (TextView) convertView.findViewById(R.id.itemText);
            //Used to re-track the ingredient
            holder.text.setTag(position);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        String item = itemList.get(position);

        //Set the contents of the UI elements
        holder.text.setText(item);

        return convertView;
    }


    private class ViewHolder {
        TextView text;
    }

}