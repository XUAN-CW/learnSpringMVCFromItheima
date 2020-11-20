package domain;

import java.util.List;

/**
 * @author XUAN
 * @date 2020/11/20 - 19:51
 * @references
 * @purpose
 * @errors
 */
public class Result {
    private int id;
    private int min;
    private int max;
    private int avg_integral;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getAvg_integral() {
        return avg_integral;
    }

    public void setAvg_integral(int avg_integral) {
        this.avg_integral = avg_integral;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", min=" + min +
                ", max=" + max +
                ", avg_integral=" + avg_integral +
                '}';
    }
}
