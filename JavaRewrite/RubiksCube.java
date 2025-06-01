

public class RubiksCube {
    public String lastmove;
    public String solution;
    public String state;

    public RubiksCube(){
        this.lastmove = "";
        this.solution = "";
        this.state = "gggggggggwwwwwwwwwrrrrrrrrrooooooooobbbbbbbbbyyyyyyyyy";
    }

    public RubiksCube(String state){
        this.lastmove = "";
        this.solution = "";
        this.state = state;
    }

    public RubiksCube(String state, String lastmove, String solution){
        this.lastmove = lastmove;
        this.solution = solution;
        this.state = state;
    }

    public void r(){
        String newstate = "";
        newstate += this.state.substring(0,2) + this.state.charAt(51) +
        this.state.substring(3,5) + this.state.charAt(48) + this.state.substring(6,8) + this.state.charAt(45) +
        this.state.substring(9,11) + this.state.charAt(2) + this.state.substring(12,14) + this.state.charAt(5) +
        this.state.substring(15,17) + this.state.charAt(8) + this.state.charAt(24) + this.state.charAt(21) +
        this.state.charAt(18) + this.state.charAt(25) + this.state.charAt(22) + this.state.charAt(19) +
        this.state.charAt(26) + this.state.charAt(23) + this.state.charAt(20)+ this.state.substring(27,36) +
        this.state.charAt(17) + this.state.substring(37,39) + this.state.charAt(14)+ this.state.substring(40,42) +
        this.state.charAt(11)+ this.state.substring(43,45) + this.state.charAt(36)+ this.state.substring(46,48) +
        this.state.charAt(39)+ this.state.substring(49,51) + this.state.charAt(42)+ this.state.substring(52,54);
        this.state = newstate;
        this.solution += "R";
        this.lastmove = "R";
    }

    public void r(Boolean flag){
        String newstate = "";
        newstate += this.state.substring(0,2) + this.state.charAt(51) +
        this.state.substring(3,5) + this.state.charAt(48) + this.state.substring(6,8) + this.state.charAt(45) +
        this.state.substring(9,11) + this.state.charAt(2) + this.state.substring(12,14) + this.state.charAt(5) +
        this.state.substring(15,17) + this.state.charAt(8) + this.state.charAt(24) + this.state.charAt(21) +
        this.state.charAt(18) + this.state.charAt(25) + this.state.charAt(22) + this.state.charAt(19) +
        this.state.charAt(26) + this.state.charAt(23) + this.state.charAt(20)+ this.state.substring(27,36) +
        this.state.charAt(17) + this.state.substring(37,39) + this.state.charAt(14)+ this.state.substring(40,42) +
        this.state.charAt(11)+ this.state.substring(43,45) + this.state.charAt(36)+ this.state.substring(46,48) +
        this.state.charAt(39)+ this.state.substring(49,51) + this.state.charAt(42)+ this.state.substring(52,54);
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
        newstate += this.state.charAt(9) + this.state.substring(1,3) + this.state.charAt(12) + 
        this.state.substring(4,6) + this.state.charAt(15) + this.state.substring(7,9) + 
        this.state.charAt(44) + this.state.substring(10,12) + this.state.charAt(41) +
        this.state.substring(13,15) + this.state.charAt(38) + this.state.substring(16,18) + this.state.substring(18,27) +

        this.state.charAt(33) + this.state.charAt(30) + this.state.charAt(27) +
        this.state.charAt(34) + this.state.charAt(31) + this.state.charAt(28) + this.state.charAt(35) +
        this.state.charAt(32) + this.state.charAt(29) + 

        this.state.substring(36,38) + this.state.charAt(47) + this.state.substring(39,41) + this.state.charAt(50) +
        this.state.substring(42,44) + this.state.charAt(53) +

        this.state.substring(45,47) + this.state.charAt(6) + this.state.substring(48,50) + this.state.charAt(3) +
        this.state.substring(51,53) + this.state.charAt(0);
        this.state = newstate;
        if (flag){
            this.solution += "R";
            this.lastmove = "R";
        }
    }

    public void l(){
        String newstate = "";
        newstate += this.state.charAt(9) + this.state.substring(1,3) + this.state.charAt(12) + 
        this.state.substring(4,6) + this.state.charAt(15) + this.state.substring(7,9) + 
        this.state.charAt(44) + this.state.substring(10,12) + this.state.charAt(41) +
        this.state.substring(13,15) + this.state.charAt(38) + this.state.substring(16,18) + this.state.substring(18,27) +

        this.state.charAt(33) + this.state.charAt(30) + this.state.charAt(27) +
        this.state.charAt(34) + this.state.charAt(31) + this.state.charAt(28) + this.state.charAt(35) +
        this.state.charAt(32) + this.state.charAt(29) + 

        this.state.substring(36,38) + this.state.charAt(47) + this.state.substring(39,41) + this.state.charAt(50) +
        this.state.substring(42,44) + this.state.charAt(53) +

        this.state.substring(45,47) + this.state.charAt(6) + this.state.substring(48,50) + this.state.charAt(3) +
        this.state.substring(51,53) + this.state.charAt(0);
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
        newstate += String.valueOf(this.state.charAt(6)) + this.state.charAt(3) + this.state.charAt(0) +
        this.state.charAt(7) + this.state.charAt(4) + this.state.charAt(1) + this.state.charAt(8) +
        this.state.charAt(5) + this.state.charAt(2) + 

        this.state.substring(9,15) + this.state.charAt(35) + this.state.charAt(32) + this.state.charAt(29) +
        
        
        this.state.charAt(15) + this.state.substring(19,21) + this.state.charAt(16) + 
        this.state.substring(22,24) + this.state.charAt(17) + this.state.substring(25,27) + 

        this.state.substring(27,29) + this.state.charAt(53) + this.state.substring(30,32) + this.state.charAt(52) +
        this.state.substring(33,35) + this.state.charAt(51) +this.state.substring(36,45) +

        this.state.substring(45,51) + this.state.charAt(18) + this.state.charAt(21) + this.state.charAt(24);
        this.state = newstate;
        this.solution += "F";
        this.lastmove = "F";
    }

    public void f(Boolean flag){
        String newstate = "";
        newstate += String.valueOf(this.state.charAt(6)) + this.state.charAt(3) + this.state.charAt(0) +
        this.state.charAt(7) + this.state.charAt(4) + this.state.charAt(1) + this.state.charAt(8) +
        this.state.charAt(5) + this.state.charAt(2) + 

        this.state.substring(9,15) + this.state.charAt(35) + this.state.charAt(32) + this.state.charAt(29) +
        
        
        this.state.charAt(15) + this.state.substring(19,21) + this.state.charAt(16) + 
        this.state.substring(22,24) + this.state.charAt(17) + this.state.substring(25,27) + 

        this.state.substring(27,29) + this.state.charAt(53) + this.state.substring(30,32) + this.state.charAt(52) +
        this.state.substring(33,35) + this.state.charAt(51) +this.state.substring(36,45) +

        this.state.substring(45,51) + this.state.charAt(18) + this.state.charAt(21) + this.state.charAt(24);
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
        newstate += this.state.substring(18,21) + this.state.substring(3,9) + 
        
        this.state.charAt(15) + this.state.charAt(12) + this.state.charAt(9) +
        this.state.charAt(16) + this.state.charAt(13) + this.state.charAt(10) + this.state.charAt(17) +
        this.state.charAt(14) + this.state.charAt(11) + 

        this.state.substring(36,39) + this.state.substring(21,27) +
        this.state.substring(0,3) + this.state.substring(30,36) +
        this.state.substring(27,30) + this.state.substring(39,45) +
        this.state.substring(45,54);
        this.state = newstate;
        this.solution += "U";
        this.lastmove = "U";
    }

    public void u(Boolean flag){
        String newstate = "";
        newstate += this.state.substring(18,21) + this.state.substring(3,9) + 
        
        this.state.charAt(15) + this.state.charAt(12) + this.state.charAt(9) +
        this.state.charAt(16) + this.state.charAt(13) + this.state.charAt(10) + this.state.charAt(17) +
        this.state.charAt(14) + this.state.charAt(11) + 

        this.state.substring(36,39) + this.state.substring(21,27) +
        this.state.substring(0,3) + this.state.substring(30,36) +
        this.state.substring(27,30) + this.state.substring(39,45) +
        this.state.substring(45,54);
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
        newstate += this.state.substring(0,6) + this.state.substring(33,36) + 
        this.state.substring(9,18) + this.state.substring(18,24) + this.state.substring(6,9) +
        this.state.substring(27,33) + this.state.substring(42,45) + this.state.substring(36,42) + this.state.substring(24,27) +
        
        this.state.charAt(51) + this.state.charAt(48) + this.state.charAt(45) +
        this.state.charAt(52) + this.state.charAt(49) + this.state.charAt(46) + this.state.charAt(53) +
        this.state.charAt(50) + this.state.charAt(47);
        this.state = newstate;
        this.solution += "D";
        this.lastmove = "D";
    }

    public void d(Boolean flag){
        String newstate = "";
        newstate += this.state.substring(0,6) + this.state.substring(33,36) + 
        this.state.substring(9,18) + this.state.substring(18,24) + this.state.substring(6,9) +
        this.state.substring(27,33) + this.state.substring(42,45) + this.state.substring(36,42) + this.state.substring(24,27) +
        
        this.state.charAt(51) + this.state.charAt(48) + this.state.charAt(45) +
        this.state.charAt(52) + this.state.charAt(49) + this.state.charAt(46) + this.state.charAt(53) +
        this.state.charAt(50) + this.state.charAt(47);
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
        newstate += this.state.substring(0,9) +
        
        this.state.charAt(20) + this.state.charAt(23) + this.state.charAt(26) + this.state.substring(12,18) +
        this.state.substring(18,20)+ this.state.charAt(45) + this.state.substring(21,23)+ 
        this.state.charAt(46) + this.state.substring(24,26)+this.state.charAt(47) + 

        this.state.charAt(11) + this.state.substring(28,30)+ this.state.charAt(10) + 
        this.state.substring(31,33)+this.state.charAt(9) + this.state.substring(34,36) + 
        
        this.state.charAt(42) + this.state.charAt(39) + this.state.charAt(36) +
        this.state.charAt(43) + this.state.charAt(40) + this.state.charAt(37) + this.state.charAt(44) +
        this.state.charAt(41) + this.state.charAt(38)+
        this.state.charAt(33) + this.state.charAt(30) + this.state.charAt(27) + this.state.substring(48,54);

        this.state = newstate;
        this.solution += "B";
        this.lastmove = "B";
    }

    public void b(Boolean flag){
        String newstate = "";
        newstate += this.state.substring(0,9) +
        
        this.state.charAt(20) + this.state.charAt(23) + this.state.charAt(26) + this.state.substring(12,18) +
        this.state.substring(18,20)+ this.state.charAt(45) + this.state.substring(21,23)+ 
        this.state.charAt(46) + this.state.substring(24,26)+this.state.charAt(47) + 

        this.state.charAt(11) + this.state.substring(28,30)+ this.state.charAt(10) + 
        this.state.substring(31,33)+this.state.charAt(9) + this.state.substring(34,36) + 
        
        this.state.charAt(42) + this.state.charAt(39) + this.state.charAt(36) +
        this.state.charAt(43) + this.state.charAt(40) + this.state.charAt(37) + this.state.charAt(44) +
        this.state.charAt(41) + this.state.charAt(38)+
        this.state.charAt(33) + this.state.charAt(30) + this.state.charAt(27) + this.state.substring(48,54);

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

    public Boolean G1(){
        Boolean result = true;
        String whiteface = this.state.substring(9,18);
        String yellowface = this.state.substring(45,54);
        result = result && whiteface.indexOf("g")==-1 && whiteface.indexOf("r")==-1 && whiteface.indexOf("o")==-1 && whiteface.indexOf("b")==-1;
        result = result && yellowface.indexOf("g")==-1 && yellowface.indexOf("r")==-1 && yellowface.indexOf("o")==-1 && yellowface.indexOf("b")==-1;
        Boolean greenok = (this.state.charAt(3)== "g".charAt(0)|| this.state.charAt(3)=="b".charAt(0)) && (this.state.charAt(5)=="g".charAt(0)|| this.state.charAt(5)=="b".charAt(0));
        Boolean blueok = (this.state.charAt(39)== "g".charAt(0)|| this.state.charAt(39)=="b".charAt(0)) && (this.state.charAt(41)=="g".charAt(0)|| this.state.charAt(41)=="b".charAt(0));
        Boolean orangeok = (this.state.charAt(30)== "o".charAt(0)|| this.state.charAt(30)=="r".charAt(0)) && (this.state.charAt(32)=="r".charAt(0)|| this.state.charAt(32)=="o".charAt(0));
        Boolean redok = (this.state.charAt(21)== "o".charAt(0)|| this.state.charAt(21)=="r".charAt(0)) && (this.state.charAt(23)=="r".charAt(0)|| this.state.charAt(23)=="o".charAt(0));
        result = result && greenok && blueok && orangeok && redok;
        return result;
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
