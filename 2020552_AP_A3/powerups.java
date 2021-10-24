public class powerups {
    protected int cost;
    protected String type;
    // powerups(){
    //     this.type="";
    // }
    public String getType(){
        return this.type;
    }
}

class snakeKiller extends powerups{

    snakeKiller(){
        this.type="SnakeKiller";
        this.cost=5;
    }
}

class jetPack extends powerups{

    jetPack(){
        this.type="jetPack";
        this.cost=5;
    }

}

class noPower extends powerups{
    noPower(){
        this.type="noPower";
        //this.cost=5;
    }
}