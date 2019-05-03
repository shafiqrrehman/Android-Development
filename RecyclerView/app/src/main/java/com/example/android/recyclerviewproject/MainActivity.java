package com.example.android.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> mItemList;
    private int mCurrentIndex = 0;

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText mInsertEditText;
    private Button mInsertButton;
    private EditText mRemoveEditText;
    private Button mRemoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemList();
        buildRecyclerView();
        setButtons();

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt("index", 0);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("MainActivity", "onSaveInstanceState");
        savedInstanceState.putInt("index", 0);
    }

    public void insertItem(int position) {
        mItemList.add(position, new Item(R.drawable.ic_android, "New Item at Position " + position, "Subline " + position));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mItemList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mItemList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createItemList() {

        mItemList = new ArrayList<>();
        mItemList.add(new Item(R.drawable.ic_android, "Line 1", "Subline A"));
        mItemList.add(new Item(R.drawable.ic_audio, "Line 2", "Subline B"));
        mItemList.add(new Item(R.drawable.ic_pool, "Line 3", "Subline C"));
    }

    public void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CustomAdapter(mItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void setButtons() {
        mInsertEditText = findViewById(R.id.insertEditText);
        mInsertButton = findViewById(R.id.insertButton);
        mRemoveEditText = findViewById(R.id.removeEditText);
        mRemoveButton = findViewById(R.id.removeButton);

        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertText = mInsertEditText.getText().toString();
                if (insertText.matches("")) {
                    Toast.makeText(getApplicationContext(), "Field is Empty, plz Enter Number.", Toast.LENGTH_LONG).show();
                } else {
                    int position = Integer.parseInt(insertText);
                    if (position >= mItemList.size()){
                        Toast.makeText(getApplicationContext(), "Out of Bound, plz enter valid number.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    insertItem(position);
                }
            }
        });

        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String removeText = mRemoveEditText.getText().toString();
                if (removeText.matches("")) {
                    Toast.makeText(getApplicationContext(), "Field is Empty, plz Enter Number.", Toast.LENGTH_LONG).show();
                } else {
                    int position = Integer.parseInt(removeText);
                    if (position >= mItemList.size()){
                        Toast.makeText(getApplicationContext(), "Out of Bound, plz enter valid number.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    removeItem(position);
                }
            }
        });
    }
}
