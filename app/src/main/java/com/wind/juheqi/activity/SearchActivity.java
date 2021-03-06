package com.wind.juheqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wind.juheqi.R;
import com.wind.juheqi.fragment.ContentFragment;

public class SearchActivity extends FragmentActivity {
    private Button back;
    private EditText search_edit;
    private TextView search_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_fragment);
        back=findViewById(R.id.iv_back);
        search_edit=findViewById(R.id.edit_seek);
        search_text=findViewById(R.id.tv_search);
        back.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(SearchActivity.this,MainActivity.class));
                                    }
                                }
        );
        search_edit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edit.setCursorVisible(true);
            }

        }));

        search_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edit.setCursorVisible(false);
                if(search_edit.getText().toString().trim().length()==0){
                    search_edit.setText(search_edit.getHint().toString().trim());
                }
                replaceFragment(ContentFragment.newInstance(search_edit.getText().toString()));
            }
        });
//        replaceFragment(new SearchHistoryFragment());

    }

    //搜索后的页面
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
