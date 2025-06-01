import java.util.*;

public class Client {
    public static void main(String[] args){
        RubiksCube cube = new RubiksCube();
        cube.doScramble("R2 F U2 F2 D2 B D2 B' L2 R2 U2 L D U L' D2 F' D R F' D'");
        cube.resetSolution();
        RubiksCube newcube = kociembaPhaseOne(cube);
        System.out.println(newcube.getSolution());
    }

    public static RubiksCube kociembaPhaseOne(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        if (cube.G1()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr.r();
                RubiksCube srprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                srprime.rprime();
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                if (srprime.G1()){
                    return srprime;
                }
                if (sr.G1()){
                    return sr;
                }
                queue.add(sr);
                queue.add(sr2);
                queue.add(srprime);
            }
            if(!s.getLastMove().equals("L") && !s.getLastMove().equals("L'") && !s.getLastMove().equals("L2")){
                RubiksCube sl = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sl.l();
                RubiksCube slprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                slprime.lprime();
                RubiksCube sl2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sl2.l2();
                if (slprime.G1()){
                    return slprime;
                }
                if (sl.G1()){
                    return sl;
                }
                queue.add(sl);
                queue.add(sl2);
                queue.add(slprime);
            }

            if(!s.getLastMove().equals("F") && !s.getLastMove().equals("F'") && !s.getLastMove().equals("F2")){
                RubiksCube sf = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf.f();
                RubiksCube sfprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sfprime.fprime();
                RubiksCube sf2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf2.f2();
                if (sfprime.G1()){
                    return sfprime;
                }
                if (sf.G1()){
                    return sf;
                }
                queue.add(sf);
                queue.add(sf2);
                queue.add(sfprime);
            }

            if(!s.getLastMove().equals("B") && !s.getLastMove().equals("B'") && !s.getLastMove().equals("B2")){
                RubiksCube sb = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb.b();
                RubiksCube sbprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sbprime.bprime();
                RubiksCube sb2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb2.b2();
                if (sbprime.G1()){
                    return sbprime;
                }
                if (sb.G1()){
                    return sb;
                }
                queue.add(sb);
                queue.add(sb2);
                queue.add(sbprime);
            }

            if(!s.getLastMove().equals("D") && !s.getLastMove().equals("D'") && !s.getLastMove().equals("D2")){
                RubiksCube sd = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd.d();
                RubiksCube sdprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sdprime.dprime();
                RubiksCube sd2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd2.d2();
                if (sdprime.G1()){
                    return sdprime;
                }
                if (sd.G1()){
                    return sd;
                }
                queue.add(sd);
                queue.add(sd2);
                queue.add(sdprime);
            }

            if(!s.getLastMove().equals("U") && !s.getLastMove().equals("U'") && !s.getLastMove().equals("U2")){
                RubiksCube su = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                su.u();
                RubiksCube suprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                suprime.uprime();
                RubiksCube su2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                su2.u2();
                if (suprime.G1()){
                    return suprime;
                }
                if (su.G1()){
                    return su;
                }
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }

            count += 1;
            System.out.println(s.getSolution());
            System.out.println(count);
            if(count == 1000000){
                return s;
            }
        }
        return null;
    }
}
