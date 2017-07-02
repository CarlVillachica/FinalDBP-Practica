package carl.finaldbp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactItemAdapter extends ArrayAdapter<ContactItem> {
    private Activity activity1;
    private List<ContactItem> contact;

    public ContactItemAdapter(Activity context, int resource, List<ContactItem> items) {
        super(context, resource, items);
        this.activity1 = context;
        this.contact = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactItemAdapter.ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity1.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        ContactItem item = getItem(position);
        int viewType = getItemViewType(position);

        layoutResource = R.layout.item_contact_item;

        if(convertView != null) {
            holder = (ContactItemAdapter.ViewHolder) convertView.getTag();
        }   else {
            convertView = inflater.inflate(layoutResource,parent,false);
            holder = new ContactItemAdapter.ViewHolder (convertView);
            convertView.setTag(holder);
        }
        holder.msg.setText(item.getContent());

        return convertView;
    }
    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    public static class ViewHolder {
        private TextView msg;

        public ViewHolder(View v) {
            msg = (TextView) v.findViewById(R.id.txt_msg1996);
        }
    }

}
