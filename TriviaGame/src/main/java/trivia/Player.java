package trivia;

public class Player {
    
    private String name;
    private int purses;
    private boolean inPenalityBox;

    public Player(String n){
        this.name = n;
        this.purses = 0;
        this.inPenalityBox = false;
    }

    public boolean isInPenalityBox() {
        return inPenalityBox;
    }

    public void setInPenalityBox(boolean inPenalityBox) {
        this.inPenalityBox = inPenalityBox;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses() {
        this.purses++;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }

}


