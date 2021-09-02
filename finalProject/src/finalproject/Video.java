package finalproject;

public class Video implements VideoActions {
    private String title;
    private int evaluation;
    private int views;
    private int likes;
    private boolean playing;

    public Video(String title) {
        this.title = title;
        this.evaluation = 1;
        this.views = 0;
        this.likes = 0;
        this.playing = false;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        int newEvaluate;
        newEvaluate = (this.evaluation = evaluation/this.views);
        this.evaluation = newEvaluate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    @Override
    public void play() {
        this.playing = true;
    }

    @Override
    public void pause() {
        this.playing = false;
    }

    @Override
    public void like() {
        this.likes ++;
    }

    @Override
    public String toString() {
        return "video{" + "title=" + title + ", evaluation=" + evaluation + ", views=" + views + ", likes=" + likes + ", playing=" + playing + '}';
    }
}
