import java.util.Arrays;

public class RubiksCube {
    public String lastmove;
    public String solution;
    public String state;
    public final String[] correct_corner_position = {"wob", "wbr", "wgo", "wrg", "yrb", "ybo", "ygr", "yog"};

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

    public Boolean isSolved(){
        if(this.state.equals("gggggggggwwwwwwwwwrrrrrrrrrooooooooobbbbbbbbbyyyyyyyyy")){
            return true;
        }
        return false;
    }

    public Boolean G1wy(){
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

    public Boolean G1bg(){
        Boolean result = true;
        String greenface = this.state.substring(0,9);
        String blueface = this.state.substring(36,45);
        result = result && greenface.indexOf("w")==-1 && greenface.indexOf("r")==-1 && greenface.indexOf("o")==-1 && greenface.indexOf("y")==-1;
        result = result && blueface.indexOf("w")==-1 && blueface.indexOf("r")==-1 && blueface.indexOf("o")==-1 && blueface.indexOf("y")==-1;
        Boolean orangeok = (this.state.charAt(28)== "o".charAt(0)|| this.state.charAt(28)=="r".charAt(0)) && (this.state.charAt(34)=="r".charAt(0)|| this.state.charAt(34)=="o".charAt(0));
        Boolean redok = (this.state.charAt(19)== "o".charAt(0)|| this.state.charAt(19)=="r".charAt(0)) && (this.state.charAt(25)=="r".charAt(0)|| this.state.charAt(25)=="o".charAt(0));
        result = result && orangeok && redok;
        return result;
    }

    public Boolean G1ro(){
        Boolean result = true;
        String redface = this.state.substring(18,27);
        String orangeface = this.state.substring(27,36);
        result = result && redface.indexOf("g")==-1 && redface.indexOf("w")==-1 && redface.indexOf("y")==-1 && redface.indexOf("b")==-1;
        result = result && orangeface.indexOf("g")==-1 && orangeface.indexOf("w")==-1 && orangeface.indexOf("y")==-1 && orangeface.indexOf("b")==-1;
        Boolean greenok = (this.state.charAt(1)== "g".charAt(0)|| this.state.charAt(1)=="b".charAt(0)) && (this.state.charAt(7)=="g".charAt(0)|| this.state.charAt(7)=="b".charAt(0));
        Boolean blueok = (this.state.charAt(37)== "g".charAt(0)|| this.state.charAt(37)=="b".charAt(0)) && (this.state.charAt(43)=="g".charAt(0)|| this.state.charAt(43)=="b".charAt(0));
        result = result && greenok && blueok;
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

    public int[] findCornerOrientation(){
        int[] corner_orientation = new int[8];
        int[] stickers_to_check = {9, 11, 15, 17, 45, 47, 51, 53};
        for(int i = 0; i < 8; i++){
            if("y".equals(this.state.substring(stickers_to_check[i],stickers_to_check[i]+1))||"w".equals(this.state.substring(stickers_to_check[i],stickers_to_check[i]+1)) ){
                corner_orientation[i] = 0;
            }
            else{
                if (i==0){
                    if(this.state.charAt(27)=="w".charAt(0) || this.state.charAt(27)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==2){
                    if(this.state.charAt(0)=="w".charAt(0) || this.state.charAt(0)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==3){
                    if(this.state.charAt(18)=="w".charAt(0) || this.state.charAt(18)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==1){
                    if(this.state.charAt(36)=="w".charAt(0) || this.state.charAt(36)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==4){
                    if(this.state.charAt(26)=="w".charAt(0) || this.state.charAt(26)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==5){
                    if(this.state.charAt(44)=="w".charAt(0) || this.state.charAt(44)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==6){
                    if(this.state.charAt(8)=="w".charAt(0) || this.state.charAt(8)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }

                if (i==7){
                    if(this.state.charAt(35)=="w".charAt(0) || this.state.charAt(35)=="y".charAt(0)){
                        corner_orientation[i] = 1;
                    }
                    else{
                        corner_orientation[i] = -1;
                    }
                }
            }
        }
        return corner_orientation;
    }

    public Boolean cornersOriented(){
        int[] corner_orientation = this.findCornerOrientation();
        for(int i = 0; i < corner_orientation.length; i++){
            if(corner_orientation[i]== -1 ||corner_orientation[i]== 1 ){
                return false;
            }
        }
        return true;
    }

    public int[] middleEdgesPostion(){
        int[] edge_position = new int[12];
        int[] stickers_to_check = {10, 12, 14, 16, 46, 48, 50, 52, 3, 5, 39, 41};
        for(int i =0; i < 12; i++){
            if(this.state.charAt(stickers_to_check[i])=="y".charAt(0) ||this.state.charAt(stickers_to_check[i])=="w".charAt(0)){
                edge_position[i] = 1;
            }
            else{
                edge_position[i] = 0;
            }
        }
        return edge_position;
    }

    public Boolean middleEdgesCorrect(){
        int[] edge_position = middleEdgesPostion();
        if(edge_position[9] == 0 && edge_position[10] == 0 && edge_position[8] == 0 && edge_position[11] == 0){
            return true;
        }
        return false;
    }

    public int[] middleEdgeAndCornerOrientation(){
        int[] corner_orientation = findCornerOrientation();
        int[] middle_edges = middleEdgesPostion();
        int[] combined = new int[corner_orientation.length + middle_edges.length];

        for(int i = 0; i<corner_orientation.length; i++){
            combined[i] = corner_orientation[i];
        }
        for(int i = 0; i<middle_edges.length; i++){
            combined[i+8] = middle_edges[i];
        }
        return combined;
    }

    public int[] edgeOrientations(){
        int[] edgeOrientations = new int[12];
        int[] stickers_to_check_RL = {10, 12, 14, 16, 46, 48, 50, 52, 3, 5, 39, 41};
        int[] stickers_to_check_UD = {37, 28, 19, 1, 43, 25, 34, 7, 32, 21, 23, 30};
        for(int i = 0; i<12; i++){
            if(this.state.charAt(stickers_to_check_RL[i])=="r".charAt(0) ||this.state.charAt(stickers_to_check_RL[i])=="o".charAt(0)){
                edgeOrientations[i] = -1;
            }
            else if(this.state.charAt(stickers_to_check_UD[i])=="w".charAt(0) ||this.state.charAt(stickers_to_check_UD[i])=="y".charAt(0)){
                edgeOrientations[i] = -1;
            }
            else{
                edgeOrientations[i] = 0;
            }
        }
        return edgeOrientations;
    }

    public Boolean edgesOriented(){
        int[] edgeOrientations = edgeOrientations();
        for(int i = 0; i<12; i++){
            if(edgeOrientations[i]==-1){
                return false;
            }
        }
        return true;
    }

    public Boolean G3(){
        int[] correct = {0,0,0,0,0,0,0,0,0,1,1,0,2,3,3,2,0};
        return Arrays.equals(correct,this.G3position());
    }

    public int[] rlSlice(){
        int[] slice_edges = new int[8];
        int[] stickers_to_check = {1,7,37,43,19,25,28,34};
        for(int i = 0; i<8; i++){
            if(i<4){
                if(this.state.charAt(stickers_to_check[i])=="r".charAt(0) || this.state.charAt(stickers_to_check[i])=="o".charAt(0)){
                    slice_edges[i] = 1;
                }
                else{
                    slice_edges[i] = 0;
                }
            }
            else{
                if(this.state.charAt(stickers_to_check[i])=="r".charAt(0) || this.state.charAt(stickers_to_check[i])=="o".charAt(0)){
                    slice_edges[i] = 0;
                }
                else{
                    slice_edges[i] = 1;
                }
            }
        }

        return slice_edges;
    }

    public int[] cornerPairs(){
        String[] corner_positions = cornerPositions();
        int[] cornerPairs = new int[8];
        for(int i =0; i<8; i++){
            int correct_index = Arrays.asList(this.correct_corner_position).indexOf(corner_positions[i]);
            if(correct_index == 0 || correct_index == 3){
                cornerPairs[i] = 0;
            }
            if(correct_index == 1 || correct_index == 2){
                cornerPairs[i] = 1;
            }
            if(correct_index == 4 || correct_index == 7){
                cornerPairs[i] = 2;
            }
            if(correct_index == 5 || correct_index == 6){
                cornerPairs[i] = 3;
            }
        }
        return cornerPairs;
    }

    public int cornerParity(String[] corner_position, int parity){
        for(int i = 0; i<8; i++){
            if(!corner_position[i].equals(this.correct_corner_position[i])){
                int correct_index = Arrays.asList(this.correct_corner_position).indexOf(corner_position[i]);
                String swapped_corner = corner_position[correct_index];
                corner_position[correct_index] = corner_position[i];
                corner_position[i] = swapped_corner;
                parity += 1;
                return cornerParity(corner_position, parity%2);
            }
        }
        return parity;
    }


    public String[] cornerPositions(){
        String[] corner_position = new String[8];
        corner_position[0] = this.state.substring(9,10) + this.state.charAt(27) + this.state.charAt(38);
        corner_position[1] = this.state.substring(11,12) + this.state.charAt(36) + this.state.charAt(20);
        corner_position[2] = this.state.substring(15,16) + this.state.charAt(0) + this.state.charAt(29);
        corner_position[3] = this.state.substring(17,18) + this.state.charAt(18) + this.state.charAt(2);
        corner_position[4] = this.state.substring(45,46) + this.state.charAt(26) + this.state.charAt(42);
        corner_position[5] = this.state.substring(47,48) + this.state.charAt(44) + this.state.charAt(33);
        corner_position[6] = this.state.substring(51,52) + this.state.charAt(8) + this.state.charAt(24);
        corner_position[7] = this.state.substring(53,54) + this.state.charAt(35) + this.state.charAt(6);
        return corner_position;
    }

    public int[] G3position(){
        int[] rlslice = this.rlSlice();
        int[] corner_pairs = this.cornerPairs();
        int parity = this.cornerParity(this.cornerPositions(), 0);
        int[] G3position = new int[rlslice.length + corner_pairs.length + 1];
        for(int i =0; i<rlslice.length; i++){
            G3position[i] = rlslice[i];
        }
        for(int i = 0; i<corner_pairs.length; i++){
            G3position[i+rlslice.length] = corner_pairs[i];
        }
        G3position[G3position.length -1] = parity;
        return G3position;
    }

    public void randomScramble(){
        String[] moves = {"R","R'","R2","D","D'","D2","L","L2","L'","U","U'","U2", "F","F'","F2","B","B2","B'"};
        String scramble = "";
        for(int i = 0; i< 30; i++){
            int randomNumber = (int) (Math.random() * (18));
            scramble += moves[randomNumber] + " ";
        }
        this.doScramble(scramble);

    }
}
