import java.util.*;
public class floor {
    static int count=-1;
    private int floorNumber;
    protected int points;
    protected String type;
    protected int jump;
    floor(){
        
        floorNumber=count;
        count++;
    }
    public int getFloorNo(){
        return this.floorNumber;
    }
    public void changeScore(player p){
        p.points += this.points;
       // return p.points;
    }
    public static void main(String[] args){
        // floor f = new floor();
        // f.
    }

    public String getTypeFloor(){
        return(this.type);
    }
    public ArrayList<floor> createGame(ArrayList<floor> l){
        startFloor f0= new startFloor();
        emptyFloor f1 = new emptyFloor();
        elevator f2 = new elevator();
        emptyFloor f3 = new emptyFloor();
        emptyFloor f4 = new emptyFloor();
        snake f5 = new snake();
        emptyFloor f6 = new emptyFloor();
        emptyFloor f7 = new emptyFloor();
        ladder f8 = new ladder();
        emptyFloor f9 = new emptyFloor();
        emptyFloor f10 = new emptyFloor();
        KingCobrs f11 = new KingCobrs();
        emptyFloor f12 = new emptyFloor();
        finish f13 = new finish();
        
        
        
       
        l.add(f0);
        l.add(f1);
        l.add(f2);
        l.add(f3);
        l.add(f4);
        l.add(f5);
        l.add(f6);
        l.add(f7);
        l.add(f8);
        l.add(f9);
        l.add(f10);
        l.add(f11);
        l.add(f12);
        l.add(f13);

        return l;
    }

}

class emptyFloor extends floor{
    emptyFloor(){
        this.points=1;
        this.type = "empty floor";
        this.jump=0;
    }

}

class KingCobrs extends floor{
    KingCobrs(){
        this.points=-4;
        this.type = "King Cobra";
        this.jump=-8;
    }

}

class elevator extends floor{
    elevator(){
        this.points=4;
        this.type = "Elevator";
        this.jump=8;
    }
}

class ladder extends floor{
    ladder(){
        this.points=2;
        this.type = "Ladder";
        this.jump=4;
    }
}

class snake extends floor{
    snake(){
        this.points=-2;
        this.type = "Snake";
        this.jump=-4;
    }
}

class startFloor extends emptyFloor{
    startFloor(){
        super();
        this.type = "Start";
    }

}

class finish extends emptyFloor{
    finish(){
        super();
        this.type = "Finish";
    }
}