package ph.me.retrofitpytania;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    @GET("Pytania")
    public Call<List<Pytanie>>_getPytania();
}
