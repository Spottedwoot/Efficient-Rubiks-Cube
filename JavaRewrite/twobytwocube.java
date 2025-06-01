

public class twobytwocube {
    public String lastmove;
    public String solution;
    public String state;

    public twobytwocube(){
        this.lastmove = "";
        this.solution = "";
        this.state = "ggggwwwwrrrroooobbbbyyyy";
    }

    public twobytwocube(String state){
        this.lastmove = "";
        this.solution = "";
        this.state = state;
    }

    public twobytwocube(String state, String lastmove, String solution){
        this.lastmove = lastmove;
        this.solution = solution;
        this.state = state;
    }

    public void r(){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(0)) + this.state.charAt(22) + this.state.charAt(2) + this.state.charAt(20) +
        this.state.charAt(4) + this.state.charAt(1) + this.state.charAt(6) + this.state.charAt(3) + this.state.charAt(0) + this.state.charAt(10) + this.state.charAt(8) +
        this.state.charAt(11) + this.state.charAt(9) + this.state.substring(12,16) + this.state.charAt(7) + this.state.charAt(17) +
        this.state.charAt(5) + this.state.charAt(18) + this.state.charAt(16) + this.state.charAt(21) + this.state.charAt(18) + this.state.charAt(23);
        this.state = newstate;
        this.solution += "R";
        this.lastmove = "R";
    }

    public void r(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(0)) + this.state.charAt(22) + this.state.charAt(2) + this.state.charAt(20) +
        this.state.charAt(4) + this.state.charAt(1) + this.state.charAt(6) + this.state.charAt(3) + this.state.charAt(0) + this.state.charAt(10) + this.state.charAt(8) +
        this.state.charAt(11) + this.state.charAt(9) + this.state.substring(12,16) + this.state.charAt(7) + this.state.charAt(17) +
        this.state.charAt(5) + this.state.charAt(18) + this.state.charAt(16) + this.state.charAt(21) + this.state.charAt(18) + this.state.charAt(23);
        this.state = newstate;
        if (flag){
            this.solution += "R";
            this.lastmove = "R";
        }
    }

    public void rprime(){
        this.r(false);
        this.r(false);
        this.r(false);
        this.solution += "R'";
        this.lastmove = "R'";
        
    }

    public void l(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(4)) +this.state.charAt(1) + this.state.charAt(6) + this.state.charAt(3)+
        this.state.charAt(19) + this.state.charAt(5) + this.state.charAt(17) + this.state.charAt(7)+
        this.state.substring(8,12) + this.state.charAt(14) + this.state.charAt(12) + this.state.charAt(15) + this.state.charAt(13) +
        this.state.charAt(16) + this.state.charAt(21) + this.state.charAt(18) + this.state.charAt(23) + this.state.charAt(20) + this.state.charAt(2) + 
        this.state.charAt(22) + this.state.charAt(0);
        this.state = newstate;
        if (flag){
            this.solution += "R";
            this.lastmove = "R";
        }
    }

    public void l(){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(4)) +this.state.charAt(1) + this.state.charAt(6) + this.state.charAt(3)+
        this.state.charAt(19) + this.state.charAt(5) + this.state.charAt(17) + this.state.charAt(7)+
        this.state.substring(8,12) + this.state.charAt(14) + this.state.charAt(12) + this.state.charAt(15) + this.state.charAt(13) +
        this.state.charAt(16) + this.state.charAt(21) + this.state.charAt(18) + this.state.charAt(23) + this.state.charAt(20) + this.state.charAt(2) + 
        this.state.charAt(22) + this.state.charAt(0);
        this.state = newstate;
        this.solution += "L";
        this.lastmove = "L'";
    }

    public void lprime(){
        this.l(false);
        this.l(false);
        this.l(false);
        this.solution += "L'";
        this.lastmove = "L'";
    }

    public void f(){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(2)) + this.state.charAt(0) + this.state.charAt(3) + this.state.charAt(1) + this.state.charAt(4) + this.state.charAt(5) +
        this.state.charAt(15) + this.state.charAt(13) + this.state.charAt(6) + this.state.charAt(9) + this.state.charAt(7) + this.state.charAt(11) +
        this.state.charAt(12) + this.state.charAt(23) + this.state.charAt(14) + this.state.charAt(22) + this.state.substring(16,20) +
        this.state.charAt(20) + this.state.charAt(21) + this.state.charAt(8) + this.state.charAt(10);
        this.state = newstate;
        this.solution += "F";
        this.lastmove = "F";
    }

    public void f(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(2)) + this.state.charAt(0) + this.state.charAt(3) + this.state.charAt(1) + this.state.charAt(4) + this.state.charAt(5) +
        this.state.charAt(15) + this.state.charAt(13) + this.state.charAt(6) + this.state.charAt(9) + this.state.charAt(7) + this.state.charAt(11) +
        this.state.charAt(12) + this.state.charAt(23) + this.state.charAt(14) + this.state.charAt(22) + this.state.substring(16,20) +
        this.state.charAt(20) + this.state.charAt(21) + this.state.charAt(8) + this.state.charAt(10);
        this.state = newstate;
    }

    public void fprime(){
        this.f(false);
        this.f(false);
        this.f(false);
        this.solution += "F'";
        this.lastmove = "F'";
    }

    public void u(){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(8)) + this.state.charAt(9) + this.state.charAt(2) + this.state.charAt(3) + this.state.charAt(6) +
        this.state.charAt(4) + this.state.charAt(7) + this.state.charAt(5) + this.state.charAt(16) + this.state.charAt(17) + this.state.charAt(10) +
        this.state.charAt(11) + this.state.charAt(0) + this.state.charAt(1) + this.state.charAt(14) + this.state.charAt(15) + this.state.charAt(12) +
        this.state.charAt(13) + this.state.charAt(18) + this.state.charAt(19) + this.state.substring(20,24);
        this.state = newstate;
        this.solution += "U";
        this.lastmove = "U";
    }

    public void u(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(8)) + this.state.charAt(9) + this.state.charAt(2) + this.state.charAt(3) + this.state.charAt(6) +
        this.state.charAt(4) + this.state.charAt(7) + this.state.charAt(5) + this.state.charAt(16) + this.state.charAt(17) + this.state.charAt(10) +
        this.state.charAt(11) + this.state.charAt(0) + this.state.charAt(1) + this.state.charAt(14) + this.state.charAt(15) + this.state.charAt(12) +
        this.state.charAt(13) + this.state.charAt(18) + this.state.charAt(19) + this.state.substring(20,24);
        this.state = newstate;
    }

    public void uprime(){
        this.u(false);
        this.u(false);
        this.u(false);
        this.solution += "U'";
        this.lastmove = "U'";
    }

    public void d(){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(0)) + this.state.charAt(1) + this.state.charAt(14) + this.state.charAt(15) + this.state.substring(4,8) +
        this.state.charAt(8) + this.state.charAt(9) + this.state.charAt(2) + this.state.charAt(3) + this.state.charAt(12) + this.state.charAt(13) + this.state.charAt(18) +
        this.state.charAt(19) + this.state.charAt(16) + this.state.charAt(17) + this.state.charAt(10) + this.state.charAt(11)+ this.state.charAt(22) + this.state.charAt(20) +
        this.state.charAt(23) + this.state.charAt(21);
        this.state = newstate;
        this.solution += "D";
        this.lastmove = "D";
    }

    public void d(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(0)) + this.state.charAt(1) + this.state.charAt(14) + this.state.charAt(15) + this.state.substring(4,8) +
        this.state.charAt(8) + this.state.charAt(9) + this.state.charAt(2) + this.state.charAt(3) + this.state.charAt(12) + this.state.charAt(13) + this.state.charAt(18) +
        this.state.charAt(19) + this.state.charAt(16) + this.state.charAt(17) + this.state.charAt(10) + this.state.charAt(11)+ this.state.charAt(22) + this.state.charAt(20) +
        this.state.charAt(23) + this.state.charAt(21);
        this.state = newstate;
    }

    public void dprime(){
        this.d(false);
        this.d(false);
        this.d(false);
        this.solution += "D'";
        this.lastmove = "D'";
    }

    public void b(){
        String newstate = "";
        newstate += this.state.substring(0,4) +  this.state.charAt(9) + this.state.charAt(11) + this.state.charAt(6) + this.state.charAt(7) + this.state.charAt(8) +
        this.state.charAt(20) + this.state.charAt(10) + this.state.charAt(21) + this.state.charAt(5) + this.state.charAt(13) + this.state.charAt(4) +
        this.state.charAt(15) + this.state.charAt(18) + this.state.charAt(16) + this.state.charAt(19) + this.state.charAt(17)+
        this.state.charAt(14) + this.state.charAt(12) + this.state.charAt(22) + this.state.charAt(23); 

        this.state = newstate;
        this.solution += "B";
        this.lastmove = "B";
    }

    public void b(Boolean flag){
        String newstate = "";
        newstate += this.state.substring(0,4) +  this.state.charAt(9) + this.state.charAt(11) + this.state.charAt(6) + this.state.charAt(7) + this.state.charAt(8) +
        this.state.charAt(20) + this.state.charAt(10) + this.state.charAt(21) + this.state.charAt(5) + this.state.charAt(13) + this.state.charAt(4) +
        this.state.charAt(15) + this.state.charAt(18) + this.state.charAt(16) + this.state.charAt(19) + this.state.charAt(17)+
        this.state.charAt(14) + this.state.charAt(12) + this.state.charAt(22) + this.state.charAt(23);
        this.state = newstate;
    }

    public void bprime(){
        this.b(false);
        this.b(false);
        this.b(false);
        this.solution +="B'";
        this.lastmove = "B'";
    }
    public void b2(){
        this.b(false);
        this.b(false);
        this.solution +="B2";
        this.lastmove = "B2";
    }
    public void d2(){
        this.d(false);
        this.d(false);
        this.solution += "D2";
        this.lastmove = "D2";
    }
    public void u2(){
        this.u(false);
        this.u(false);
        this.solution += "U2";
        this.lastmove = "U2";
    }
    public void f2(){
        this.f(false);
        this.f(false);
        this.solution += "F2";
        this.lastmove = "F2";
    }
    public void l2(){
        this.l(false);
        this.l(false);
        this.solution += "L2";
        this.lastmove = "L'";
    }
    public void r2(){
        this.r(false);
        this.r(false);
        this.solution += "R2";
        this.lastmove = "R2";
    }

    public void print(){
        for(int i = 0; i < this.state.length(); i++){
            if(i%3 == 0){
                System.out.println("");
            }
            if(i%9 == 0){
                System.out.println("");
            }
            System.out.print(this.state.charAt(i) + " ");
        }
    }

    public void resetSolution(){
        this.solution = "";
    }

    public void resetLastMove(){
        this.lastmove = "";
    }

    public Boolean isSolved(){
        if(this.state.equals("ggggwwwwrrrroooobbbbyyyy")){
            return true;
        }
        else{
            return false;
        }
    }

    public String getLastMove(){
        return this.lastmove;
    }

    public String getState(){
        return this.state;
    }

    public String getSolution(){
        return this.solution;
    }

    public void doScramble(String scramble){
        String[] moves = scramble.split(" ");
        for(int i =0; i <moves.length; i++){
            if(moves[i].equals("R")){
                this.r();
            }
            if(moves[i].equals("R'")){
                this.rprime();
            }
            if(moves[i].equals("R2")){
                this.r2();
            }

            if(moves[i].equals("L")){
                this.l();
            }
            if(moves[i].equals("L'")){
                this.lprime();
            }
            if(moves[i].equals("L2")){
                this.l2();
            }

            if(moves[i].equals("F")){
                this.f();
            }
            if(moves[i].equals("F'")){
                this.fprime();
            }
            if(moves[i].equals("F2")){
                this.f2();
            }

            if(moves[i].equals("U")){
                this.u();
            }
            if(moves[i].equals("U'")){
                this.uprime();
            }
            if(moves[i].equals("U2")){
                this.u2();
            }

            if(moves[i].equals("D")){
                this.d();
            }
            if(moves[i].equals("D'")){
                this.dprime();
            }
            if(moves[i].equals("D2")){
                this.d2();
            }

            if(moves[i].equals("B")){
                this.b();
            }
            if(moves[i].equals("B'")){
                this.bprime();
            }
            if(moves[i].equals("B2")){
                this.b2();
            }

        }
    }
}