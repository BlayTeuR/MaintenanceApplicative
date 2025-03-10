package trivia;

public class Player {
    
    private String name;
    private int purses;

    public Player(String n){
        this.name = n;
        this.purses = 0;
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
