package pomis.app.treeway.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pomis.app.treeway.R;
import pomis.app.treeway.models.SkillModel;

/**
 * Created by romanismagilov on 19.11.16.
 */

public class SkillAdapter extends ArrayAdapter {
    ArrayList<SkillModel> list;
    Context context;

    public SkillAdapter(Context context, int resource, ArrayList<SkillModel> objects) {
        super(context, resource, objects);
        this.list = objects;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SkillViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_skill, null);
            holder = new SkillViewHolder(
                    convertView.findViewById(R.id.tv_skill_name),
                    convertView.findViewById(R.id.tv_skill_used_in)
            );
            convertView.setTag(holder);
        } else {
            holder = (SkillViewHolder) convertView.getTag();
        }
        holder.tvName.setText(list.get(position).name);
        holder.tvUsedIn.setText(list.get(position).getProfiles());

        return convertView;
    }

    private class SkillViewHolder {
        TextView tvName;
        TextView tvUsedIn;

        SkillViewHolder(View tvName, View tvUsedIn) {
            this.tvName = (TextView) tvName;
            this.tvUsedIn = (TextView) tvUsedIn;
        }
    }
}
