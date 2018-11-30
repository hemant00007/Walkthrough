package chat.hemant.com.walkthrough;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Slider_adapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public Slider_adapter(Context context) {
        this.context = context;
    }


    //array

    public int[] slide_image={
            R.drawable.eat,
            R.drawable.computer,
            R.drawable.read
    };

    public String[] heading={
            "Eat","Computer","Read"
    };

    public String[] description={
            "Dont eat too much, Spend some time to read. This is good for you.",
            "Computer is the very good thing for everyone. We use it on daily basis.",
            "Reading is one of the best hobby for a person,Everybody should read daily."
    };

    @Override
    public int getCount() {
        return description.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view==(RelativeLayout)obj;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView tv =(TextView)view.findViewById(R.id.title);
        TextView desc =(TextView)view.findViewById(R.id.desc);
        imageView.setImageResource(slide_image[position]);
        tv.setText(heading[position]);
        desc.setText(description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}
