package tr.mustafaesattemel.landmarkbook;

import java.io.Serializable;

//Serializableden implemente etme sebebimiz : MainActivity'den diger aktiviteye sorunsuz bir sekilde veri aktarmak icin.
public class Landmark implements Serializable {
    private String name;
    private String country;
    private int image;

    public Landmark(String name,String country,int image){
        this.name=name;
        this.country=country;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getImage() {
        return image;
    }
}
