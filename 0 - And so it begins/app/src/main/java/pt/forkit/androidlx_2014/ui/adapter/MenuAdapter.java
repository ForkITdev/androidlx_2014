package pt.forkit.androidlx_2014.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import pt.forkit.androidlx_2014.R;
import pt.forkit.androidlx_2014.domain.Menu;

import java.util.ArrayList;

/**
 
 */
public class MenuAdapter extends BaseAdapter {

    private ArrayList<Menu> mMenus;
    private Context ctx;
    private int currentPosition = 0;
    LayoutInflater inflater;

    public MenuAdapter(ArrayList<Menu> menus, Context ctx) {
        this.ctx = ctx;
        this.mMenus = menus;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mMenus.size();
    }

    @Override
    public Menu getItem(int i) {
        return mMenus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.list_item_menu, null, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        Menu mi = getItem(i);

        holder.iv_icon.setImageResource(mi.getMenuIconDrawableId());
        holder.tv_title.setText(mi.getMenuTitle());

        if(currentPosition == i){
            holder.tv_title.setTextColor(ctx.getResources().getColor(R.color.light_green));
        } else {
            holder.tv_title.setTextColor(ctx.getResources().getColor(R.color.white));
        }

        return view;
    }

    public void setActive(int position) {
        currentPosition = position;
        notifyDataSetChanged();
    }

    static class ViewHolder {

        ImageView iv_icon;
        TextView tv_title;

        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
