package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapters.MeaningAdapter;
import com.example.dictionary.Adapters.PhoneticsAdapter;
import com.example.dictionary.Models.APIResponse;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textview_word;
    RecyclerView recycler_phonetics;
    RecyclerView recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view =findViewById(R.id.search_view);
        textview_word=findViewById(R.id.textview_word);
        recycler_meanings=findViewById(R.id.recycler_meanings);
        recycler_phonetics=findViewById(R.id.recycler_phonetics);

        progressDialog =new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeanings(listener,"hello");



        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response  for "+query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeanings(listener,query);


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private final OnFetchDataListener listener =new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();

            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found!!", Toast.LENGTH_SHORT).show();
            }
            showData(apiResponse);

        }

        @Override
        public void onError(String message) {
progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIResponse apiResponse) {
        textview_word.setText("Word: "+apiResponse.getWord());
        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter=new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(phoneticsAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter=new MeaningAdapter(this,apiResponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);

    }
}