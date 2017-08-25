package com.retrofit.programmer.rxjavaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import model.Data;
import model.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    private ApiInterface apiInterface;
    private Model data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                /*
                //Without RxJAVA
                Call<Model> call = apiInterface.getData();

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        data = response.body();
                        mTextView.setText(data.getData().getFirst_name());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });*/

                //with RxJAVA
                Observable<Model> observable = apiInterface.getData();

                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Model>() {
                            @Override
                            public void onNext(Model model) {
                                Log.e("onNext:",model.getData().getFirst_name());
                                mTextView.setText(model.getData().getFirst_name());
                            }

                            @Override
                            public void onCompleted() {
                                Log.e("onCompleted:","called");
                                Toast.makeText(MainActivity.this,"View has been updated",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError:", e.toString());
                            }

                        });
            }
        });
    }
}
