package finalproject;

public class Visualization {
    private Viewer spectator;
    private Video movie;
    
    public Visualization(Viewer spectator, Video movie) {
        this.spectator = spectator;
        this.movie = movie;
        this.spectator.setTotalWatched(this.spectator.getTotalWatched() + 1);
        this.movie.setViews(this.movie.getViews() + 1);
    }

    public void rate(){
        this.movie.setEvaluation(5);
    }

    public void rate(int note){
        this.movie.setEvaluation(note);
    }
    
    public void rate(float percentage){
        int total = 0;
        
        if(percentage <= 20){
            total = 3;
        } else if (percentage <= 50){
            total = 5;
        } else if (percentage <= 90){
            total = 8;
        } else {
            total = 10;
        }
        this.movie.setEvaluation(total);
    }
    
    public Viewer getSpectator() {
        return spectator;
    }

    public void setSpectator(Viewer spectator) {
        this.spectator = spectator;
    }

    public Video getMovie() {
        return movie;
    }

    public void setMovie(Video movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "visualization{" + "spectator=" + spectator + ", movie=" + movie + '}';
    }
   
}
