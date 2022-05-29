package pojo.requests;

import lombok.Getter;
import lombok.Setter;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;


public class CreateRunningJobsPojo {


    private NasaModisJob nasamodis;
    private SharpeningJob sharpening;

    public NasaModisJob getNasamodis() {
        return nasamodis;
    }

    public void setNasamodis(NasaModisJob nasamodis) {
        this.nasamodis = nasamodis;
    }

    public SharpeningJob getSharpening() {
        return sharpening;
    }

    public void setSharpening(SharpeningJob sharpening) {
        this.sharpening = sharpening;
    }


}
