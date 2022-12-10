package ir.shariaty.fifaworldcup2.manager;

import android.content.Context;

import ir.shariaty.fifaworldcup2.ResponseListener;
import ir.shariaty.fifaworldcup2.models.FixtureResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.cup2022.ir/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager (Context context) {
        this.context = context;
    }
    public void getFixture(ResponseListener listener) {
        CallFixture callFixture = retrofit.create(CallFixture.class);
        Call<FixtureResponse> call = callFixture.callFixture();
        call.enqueue(new Callback<FixtureResponse>() {
            @Override
            public void onResponse(Call<FixtureResponse> call, Response<FixtureResponse> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body() , response.message());
            }


            @Override
            public void onFailure(Call<FixtureResponse> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }
    private interface CallFixture {
        @GET ("match")
        Call<FixtureResponse> callFixture();
    }
}
