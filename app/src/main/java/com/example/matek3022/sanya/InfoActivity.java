package com.example.matek3022.sanya;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matek3022.sanya.transform.CircleTransform;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    public static final String EXTRA_TRANSITION_NAME = "extra_transition_name";
    public static final String EXTRA_TITLE = "extra_title";

    @BindView(R.id.title)
    TextView textView;
    @BindView(R.id.image)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        String transitionName = getIntent().getStringExtra(EXTRA_TRANSITION_NAME);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
        }
        textView.setText(title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView.setTransitionName("title" + transitionName);
            imageView.setTransitionName("image" + transitionName);
        }

        Picasso.with(this).load("https://pp.userapi.com/c419521/v419521627/31a/XKJyLkCzMHk.jpg")
                .transform(new CircleTransform())
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            startPostponedEnterTransition();
                        }
                    }

                    @Override
                    public void onError() {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            startPostponedEnterTransition();
                        }
                    }
                });
    }


}
