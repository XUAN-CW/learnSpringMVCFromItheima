package domain;

public class User {

    private int id;
    private int remaining;
    private int integral;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return time.substring(0,7)+":remaining-" + getRemaining()+",Integral:"+getIntegral();

//        return "User{" +
//                "id=" + id +
//                ", remaining=" + remaining +
//                ", integral=" + integral +
//                ", time='" + time + '\'' +
//                '}';
    }
}
