package com.journaldev.retrofitintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.pojo.CreateUserResponse;
import com.journaldev.retrofitintro.pojo.Foods;
import com.journaldev.retrofitintro.pojo.MultipleResource;
import com.journaldev.retrofitintro.pojo.ORToolsSolution;
import com.journaldev.retrofitintro.pojo.Task;
import com.journaldev.retrofitintro.pojo.User;
import com.journaldev.retrofitintro.pojo.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;
    LinearLayout mScrollViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        mScrollViewLayout=(LinearLayout) findViewById(R.id.scrollViewLayout);


//    /**
//     GET List Resources
//     **/
//    Call<ORToolsSolution> call = apiInterface.getSolution();
//        call.enqueue(new Callback<ORToolsSolution>() {
//        @Override
//        public void onResponse(Call<ORToolsSolution> call, Response<ORToolsSolution> response) {
//
//
//            Log.d("TAG", response.code() + "");
//            Log.d("TAG", response.message() );
//
//            String displayResponse = "";
//
//            ORToolsSolution resource = response.body();
//
//
//            Double xVal=resource.x;
//            displayResponse+="X="+xVal.toString();
//
//
//            responseText.setText(displayResponse);
//
//        }
//
//            @Override
//            public void onFailure(Call<ORToolsSolution> call, Throwable t) {
//
//            }
//
//
//    });

        Call<Foods> foodListCall=apiInterface.getFoods();
        foodListCall.enqueue(new Callback<Foods>() {
            @Override
            public void onResponse(Call<Foods> call, Response<Foods> response)
            {
                Foods foodsList=response.body();

                for (Foods.Food food : foodsList.foods) {
                    {
                        Log.d("Foods","\nName="+food.name+"\nCalories="+food.calories);

                        CheckBox newRecipe=new CheckBox(getBaseContext());
                        newRecipe.setText(food.name);
                        newRecipe.setTextSize(15);
                        newRecipe.setTextColor(getResources().getColor(R.color.White));
                        mScrollViewLayout.addView(newRecipe);



                    }
                }


            }

            @Override
            public void onFailure(Call<Foods> call, Throwable t) {

            }
        });

}

}
