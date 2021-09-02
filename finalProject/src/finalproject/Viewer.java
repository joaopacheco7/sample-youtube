package finalproject;

public class Viewer extends People {
    private String login;
    private int totalWatched;

    public Viewer(String name, int age, String gender, String login) {
        super(name, age, gender);
        this.login = login;
        this.totalWatched = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotalWatched() {
        return totalWatched;
    }

    public void setTotalWatched(int totalWatched) {
        this.totalWatched = totalWatched;
    }

    @Override
    public String toString() {
        return "viewer{" + super.toString() + "login=" + login + ", totalWatched=" + totalWatched + '}';
    }
}
