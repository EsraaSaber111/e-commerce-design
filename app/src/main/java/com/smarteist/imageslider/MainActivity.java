package com.smarteist.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.ImageView;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.imageslider.adapter.CollectionAdapter;
import com.smarteist.imageslider.adapter.TagAdapter;
import com.smarteist.imageslider.model.collection;
import com.smarteist.imageslider.model.tag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;

    private Context mContext=MainActivity.this;


    ImageView imgProfile;

    private ArrayList<collection> collectionList;
    private RecyclerView recyclerViewCollection;
    private CollectionAdapter collectionAdapter;

    private Integer image[] = {R.drawable.watch0,R.drawable.summer1,R.drawable.summer2,R.drawable.winter,R.drawable.summer1};
    private String title[] = {"watches","Accessories","T-Shirts","Formal Shirts","Sunglasses"};
    private String description[] = {"20 Wardrobes","96 Wardrobes","125 Wardrobes ","99 Wardrobes","439 Wardrobes"};

    private ArrayList<tag> tagList;
    private RecyclerView recyclerViewTag;
    private TagAdapter tagbAdapter;

    private Integer image1[] = {R.drawable.gradienttag1,R.drawable.gradienttag2,R.drawable.gradienttag3,R.drawable.gradienttag4,R.drawable.gradienttag5};
    private String title1[] = {"Jackets","Sunglasses","Kurtas","Footwear","Backpacks"};
    private String description1[] = {"Fast Food Eat","Chicken Restaurant","US Pizza","Dominoz","Dominoz"};


    private ArrayList<collection> offerList;
    private RecyclerView recyclerViewOffer;
    private CollectionAdapter offerAdapter;

    private Integer image2[] = {R.drawable.winter,R.drawable.summer1,R.drawable.summer2,R.drawable.winter,R.drawable.summer2};
    private String title2[] = {"Cloths","Footwear","Sunglasses","Watch","Backpacks"};
    private String description2[] = {"30% Discount","10% Discount","5% Discount","25% Discount","40% Discount"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //slider
        sliderView = findViewById(R.id.imageSlider);

        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(5);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

//collection

        recyclerViewCollection = findViewById(R.id.RecyclerViewCollection);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerViewCollection.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCollection.setItemAnimator(new DefaultItemAnimator());

        collectionList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            collection collection = new collection(title[i], description[i], image[i]);
            collectionList.add(collection);
        }
        collectionAdapter = new CollectionAdapter(mContext, collectionList);
        recyclerViewCollection.setAdapter(collectionAdapter);


        recyclerViewTag = findViewById(R.id.RecyclerViewTags);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(mContext);
        recyclerViewTag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTag.setItemAnimator(new DefaultItemAnimator());

        tagList = new ArrayList<>();

        for (int i = 0; i < image1.length; i++) {
            tag tag = new tag(title1[i], image1[i]);
            tagList.add(tag);
        }
        tagbAdapter = new TagAdapter(mContext, tagList);
        recyclerViewTag.setAdapter(tagbAdapter);


        recyclerViewOffer = findViewById(R.id.RecyclerViewOffers);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(mContext);
        recyclerViewOffer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewOffer.setItemAnimator(new DefaultItemAnimator());

        offerList = new ArrayList<>();

        for (int i = 0; i < image2.length; i++) {
            collection collection = new collection(title2[i], description2[i], image2[i]);
            offerList.add(collection);
        }
        offerAdapter = new CollectionAdapter(mContext, offerList);
        recyclerViewOffer.setAdapter(offerAdapter);
    }

}
