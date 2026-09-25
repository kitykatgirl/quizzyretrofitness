package ph.me.retrofitpytania;

import com.google.gson.annotations.SerializedName;

public class Pytanie {
    @SerializedName("tresc")
    private String trescPytania;
    @SerializedName("odp1")
    private String odp_a;
    @SerializedName("odp2")
    private String odp_b;
    @SerializedName("odp3")
    private String odp_c;

    public Pytanie(String trescPytania, String odp_a, String odp_b, String odp_c) {
        this.trescPytania = trescPytania;
        this.odp_a = odp_a;
        this.odp_b = odp_b;
        this.odp_c = odp_c;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public void setTrescPytania(String trescPytania) {
        this.trescPytania = trescPytania;
    }

    public String getOdp_a() {
        return odp_a;
    }

    public void setOdp_a(String odp_a) {
        this.odp_a = odp_a;
    }

    public String getOdp_b() {
        return odp_b;
    }

    public void setOdp_b(String odp_b) {
        this.odp_b = odp_b;
    }

    public String getOdp_c() {
        return odp_c;
    }

    public void setOdp_c(String odp_c) {
        this.odp_c = odp_c;
    }
}
