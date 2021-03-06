package iss.workshop.ca_team5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private Bitmap[] images;

    public GridAdapter(Context c, Bitmap[] images){
        context =c;
        this.images = images;
    }
    @Override
    public int getCount() {
        return images.length ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.image_view);
        imageView.setImageBitmap(images[position]);
        return convertView;
    }

    public void flipImage(int position, Bitmap image){
        if(position >= 0 && position < images.length){
            images[position] = image;
            notifyDataSetChanged();
        }
    }

    public void flipBack(int position, int prevPosition){
        if(position >= 0 && position < images.length){
            images[position] = BitmapFactory.decodeResource(context.getResources(), R.drawable.hidden1);//change to hidden
            images[prevPosition] = BitmapFactory.decodeResource(context.getResources(), R.drawable.hidden1);//change to hidden
            notifyDataSetChanged();
        }
    }

}
