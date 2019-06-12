import java.io.Serializable;

public class Discount implements Serializable {
    private double percent;

    public Discount(){}
    public Discount(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double setNewPrice(double p, double per){
        p=p*(100-per);
        return p*0.01;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "percent=" + percent +"%"+
                '}';
    }
}
