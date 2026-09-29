package ph.me.retrofitpytania;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textViewPytanie;
    RadioGroup radioGrupa;
    RadioButton radioButtonA;
    RadioButton radioButtonB;
    RadioButton radioButtonC;
    Button buttonNastepne;

    List<Pytanie> pytaniaZInternetu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewPytanie = findViewById(R.id.tresc);
        radioGrupa = findViewById(R.id.radiogrup);
        radioButtonA = findViewById(R.id.radioButton1);
        radioButtonB = findViewById(R.id.radioButton2);
        radioButtonC = findViewById(R.id.radioButton3);
        buttonNastepne = findViewById(R.id.button);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/kitykatgirl/retrofit-type-shi/").addConverterFactory(GsonConverterFactory.create()).build();
        // christ this is a LOT
        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
        Call<List<Pytanie>> call = jsonPlaceholderApi._getPytania();
        call.enqueue(new Callback<List<Pytanie>>() {
            @Override
            public void onResponse(Call<List<Pytanie>> call, Response<List<Pytanie>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                pytaniaZInternetu = response.body();
                textViewPytanie.setText(pytaniaZInternetu.get(0).getTrescPytania());
                radioButtonA.setText(pytaniaZInternetu.get(0).getOdp_a());
            }

            @Override
            public void onFailure(Call<List<Pytanie>> call, Throwable t) {

            }
        });
    }
}