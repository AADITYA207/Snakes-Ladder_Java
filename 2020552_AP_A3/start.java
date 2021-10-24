import java.util.*;


public class start{
   public static floor temp = new floor();
   public static player tempP = new player();
   public static dice d = new dice(2);
   public static ArrayList<floor> game = new ArrayList<floor>();
   public static ArrayList<player> players = new ArrayList<player>();
    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);

        System.err.println("Enter number of players: ");
        int noOfPlayers = sc.nextInt();
        sc.nextLine();
        
        for(int i=0;i<noOfPlayers;i++){
        System.out.println("Enter player " +i + " name" );
        String name = sc.nextLine();
       /// sc.nextLine();
        player p1 = new player(name);
        players.add(p1);
    }
        int step=0;
        temp.createGame(game);
        floor current=game.get(0);
        System.out.println(current.getTypeFloor());
        
        String repeat = "Hit enter to roll dice";
        boolean gameFlag=false;
        boolean hasPower=true;
       // boolean powerOnce=false;
            for(int i=0;i<noOfPlayers;i++){
            System.out.println("WELCOME ALL PLAYERS: "+i +") " + players.get(i).getName());
}
            System.out.println("The setup is ready");
            System.out.println();
            System.out.println();
            boolean flag=false;

            while(!gameFlag){
            for(int i=0;i<noOfPlayers;i++){
            current.retainJump();
            player p1 = players.get(i);
            step=p1.floorLvl;
            if(!gameFlag){
            while(true){
            System.out.println(p1.getName()+"'s turn: ");
            System.out.println(repeat);
            String enter = sc.nextLine();
            
            if(enter.equals("")){
                
                d.roll();
                System.out.println(d.toString());
                if(!flag){
                    if(d.getFaceValue()==1){
                        flag=true;
                    }
                    else{
                        System.out.println("Game cant start till 1 comes");
                        System.out.println();
                        System.out.println();
                        break;
                    }
                }
                if(flag){
                int tempStep = step;
                step += d.getFaceValue();
                
                if(step>13){
                    System.out.println("Not possible");
                    step=tempStep;
                    System.out.println();
                    System.out.println();
                    break;
                    //System.out.println(repeat);
                    
                }
                else{
                current =game.get(step);
                //System.out.println("ASDASDA"+current.type);
                //System.out.println(current.checkPowerup(p1));
                if((current.getTypeFloor()=="Snake" || current.getTypeFloor()=="King Cobra") && current.checkPowerup(p1)){
                    System.out.println("Power to be Used here. Instead of goinf down 8 points, you will only go down by 1 point");
                    current.changeJump();
                    hasPower=false;

                }
                else if(current.getTypeFloor()=="empty floor" && current.checkPowerup(p1)){
                    System.out.println("Power to be used here. A jump of 2 will be provided.");
                    current.changeJump();
                    
                    hasPower=false;
                }
                current.changeScore(p1);
                System.out.println("Player " + p1.getName() + " is on floor number " + current.getFloorNo());
                System.out.println("This is a/an " + current.getTypeFloor());
                System.out.println("Current score of player " + p1.getName() + "= " + p1.points);
                
                System.out.println();
                System.out.println();
                
                
                //System.out.println(repeat);
                if((current.getTypeFloor()=="Snake" || current.getTypeFloor()=="King Cobra") && current.checkPowerup(p1) && hasPower){
                    System.out.println("Power to be Used here. Instead of goinf down 8 points, you will only go down by 1 point");
                    current.changeJump();
                    //current.retainJump();
                    hasPower=false;

                }
                else if(current.getTypeFloor()=="empty floor" && current.checkPowerup(p1) && hasPower){
                    System.out.println("Power to be used here. A jump of 2 will be provided.");
                    current.changeJump();
                    //current.retainJump();
                    hasPower=false;
                }
                step += current.jump;
                p1.floorLvl=step;
                if(current.jump!=0){
                    
                current=game.get(step);
                
                System.out.println("Player " + p1.getName() + " is on floor number " + current.getFloorNo() + " which is a " + current.getTypeFloor());
                
                current.changeScore(p1);
                System.out.println("Current score of player " + p1.getName() + "= " + p1.points);
                System.out.println();
                System.out.println();
                //System.out.println(repeat);
                current.retainJump();
                if(p1.points>=5 && current.getFloorNo()<13 && hasPower){
                    System.out.println("Would you like to take power ups? : 1) Snake Killer, Cost:5 points. 2) Jet Pack, Cost:5 points.  3) No powerups." );
                    int power = sc.nextInt();
                    sc.nextLine();
                    powerups s = new snakeKiller();
                    powerups j = new jetPack();
                    if(power==1){
                        p1.p=s;
                        p1.points -=s.cost;
                        System.out.println("Current Points: " + p1.points);
                        hasPower=true;
                    }
                    else if(power==2){
                        p1.p=j;
                        p1.points -=j.cost;
                        System.out.println("Current Points: " + p1.points);
                        hasPower=true;
                    }
                    else if(power==3){
                        System.out.println("Current Points: " + p1.points);
                        hasPower=false;
                    }
                }
                break;
                }
                if(p1.points>=5 && current.getFloorNo()<13 && hasPower){
                    System.out.println("Would you like to take power ups? : 1) Snake Killer, Cost:5 points. 2) Jet Pack, Cost:5 points.  3) No powerups." );
                    int power = sc.nextInt();
                    sc.nextLine();
                    powerups s = new snakeKiller();
                    powerups j = new jetPack();
                    if(power==1){
                        p1.p=s;
                        p1.points -=s.cost;
                        System.out.println("Current Points: " + p1.points);
                        hasPower=true;
                    }
                    else if(power==2){
                        p1.p=j;
                        p1.points -=j.cost;
                        System.out.println("Current Points: " + p1.points);
                        hasPower=true;
                    }
                    else if(power==3){
                        System.out.println("Current Points: " + p1.points);
                        //p1.p=null;
                    }
                }
                
                if(current.getTypeFloor()=="Finish"){
                    System.out.println("You won the game, your current score is " + p1.points);
                    for(int j=0;j<noOfPlayers;j++){
                        System.out.println("Scores of player : " + players.get(j).getName()+") = " + players.get(j).points );
                    }
                    gameFlag=true;
                    break;
                }
                System.out.println();
                System.out.println();
                current.retainJump();
                break;
            }   
                

            }
           
        }
        else{
            System.out.println("Only press enter");
            break;
            
        }
        }
    }
    }
            }
    }


}