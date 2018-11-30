package chat.hemant.com.walkthrough;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private LinearLayout layout;
    private Slider_adapter adapter;
    private TextView[] mdots;
    private Button prev,next;
    private int current_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=(ViewPager)findViewById(R.id.viewpager);
        layout=(LinearLayout)findViewById(R.id.linear_id);
        prev=(Button)findViewById(R.id.previous_id);
        next=(Button)findViewById(R.id.next_id);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(current_page - 1 );
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(current_page +1 );

            }
        });
        adapter=new Slider_adapter(this);
        pager.setAdapter(adapter);
        dotindicator(0  );
        pager.addOnPageChangeListener(pageChangeListener);
    }



    public void dotindicator(int po){
        mdots=new TextView[3];
        layout.removeAllViews();
        for (int i=0;i < mdots.length;i++){
            mdots[i]= new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.tranparent));
            layout.addView(mdots[i]);
        }
        if (mdots.length > 0){
            mdots[po].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            dotindicator(i);
            current_page =i;
            if (i==0){
                next.setEnabled(true);
                prev.setEnabled(false);
                prev.setVisibility(View.INVISIBLE);
                next.setText("Next");
                prev.setText("");
            }else if (i==mdots.length-1){

                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Finish");
                prev.setText("Back");

            }
            else {

                next.setEnabled(true);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("Next");
                prev.setText("Back");


            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
