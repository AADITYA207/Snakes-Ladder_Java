public class player {
    private String name;
    int points;
    int floorLvl;
    powerups p;
    noPower empty = new noPower();
    player(String name){
        this.name=name;
        this.p=empty;
    }
    player(){

    }

    public String getName(){
        return this.name;
    }
}
