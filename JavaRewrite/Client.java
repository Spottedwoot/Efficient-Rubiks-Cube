import java.util.*;

public class Client {
    public static void main(String[] args){
        int failed = 0;
        double averageTime = 0;
        int iterations = 100;
        for(int i = 0; i<iterations; i++){
            RubiksCube cube = new RubiksCube();
        long time1 = System.currentTimeMillis();
        cube.randomScramble();
        cube.resetSolution();
        cube.resetLastMove();
        RubiksCube phaseOne = phaseOne(cube);
        System.out.println("Phase 1 Done");
        RubiksCube phaseTwo = phaseTwo(phaseOne);
        System.out.println("Phase 2 Done");
        RubiksCube phaseThree = phaseThree(phaseTwo);
        System.out.println("Phase 3 Done");
        if(phaseThree == null){
            failed ++;
            System.out.println("Failed");;
        }
        else{
            RubiksCube newcube = phaseFour(phaseThree);
            if(newcube == null){
                failed ++;
            System.out.println("Failed");;
            }
            else{
                System.out.println("Solved");
            System.out.println(newcube.getSolution());
            newcube.print();
            long time2 = System.currentTimeMillis();
            long timeTaken = (time2-time1);
            double timeSeconds = (double) timeTaken;
            averageTime += timeSeconds/1000;
            System.out.println("Time: " + timeSeconds/1000);
            }
        }
        }
        System.out.println("Times Failed: " + failed);
        System.out.println("Average Time: " + averageTime/iterations);
    }

    public static RubiksCube phaseOne(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        if (cube.edgesOriented()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(Arrays.toString(s.edgeOrientations()))){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr.r();
                RubiksCube srprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                srprime.rprime();
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                if (srprime.edgesOriented()){
                    return srprime;
                }
                if (sr.edgesOriented()){
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
                if (slprime.edgesOriented()){
                    return slprime;
                }
                if (sl.edgesOriented()){
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
                if (sfprime.edgesOriented()){
                    return sfprime;
                }
                if (sf.edgesOriented()){
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
                if (sbprime.edgesOriented()){
                    return sbprime;
                }
                if (sb.edgesOriented()){
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
                if (sdprime.edgesOriented()){
                    return sdprime;
                }
                if (sd.edgesOriented()){
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
                if (suprime.edgesOriented()){
                    return suprime;
                }
                if (su.edgesOriented()){
                    return su;
                }
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }
            count += 1;
            if(count == 1000000){
                return s;
            }
            seenBefore.add(Arrays.toString(s.edgeOrientations()));
        }
        return null;
    }

    public static RubiksCube phaseTwo(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        if (cube.cornersOriented() && cube.middleEdgesCorrect()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(Arrays.toString(s.middleEdgeAndCornerOrientation()))){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr.r();
                RubiksCube srprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                srprime.rprime();
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                if (srprime.cornersOriented() && srprime.middleEdgesCorrect()){
                    return srprime;
                }
                if (sr.cornersOriented() && sr.middleEdgesCorrect()){
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
                if (slprime.cornersOriented() && slprime.middleEdgesCorrect()){
                    return slprime;
                }
                if (sl.cornersOriented() && sl.middleEdgesCorrect()){
                    return sl;
                }
                queue.add(sl);
                queue.add(sl2);
                queue.add(slprime);
            }
            if(!s.getLastMove().equals("F") && !s.getLastMove().equals("F'") && !s.getLastMove().equals("F2")){
                RubiksCube sf2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf2.f2();
                queue.add(sf2);
            }
            if(!s.getLastMove().equals("B") && !s.getLastMove().equals("B'") && !s.getLastMove().equals("B2")){
                RubiksCube sb2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb2.b2();
                queue.add(sb2);
            }
            if(!s.getLastMove().equals("D") && !s.getLastMove().equals("D'") && !s.getLastMove().equals("D2")){
                RubiksCube sd = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd.d();
                RubiksCube sdprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sdprime.dprime();
                RubiksCube sd2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd2.d2();
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
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }
            count += 1;
            if(count == 10000000){
                return s;
            }
            seenBefore.add(Arrays.toString(s.middleEdgeAndCornerOrientation()));
        }
        return null;
    }

    public static RubiksCube phaseThree(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        HashSet<String> findG3 = findG3();
        if (cube.G3()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(Arrays.toString(s.G3position()))){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                queue.add(sr2);
            }
            if(!s.getLastMove().equals("L") && !s.getLastMove().equals("L'") && !s.getLastMove().equals("L2")){
                RubiksCube sl2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sl2.l2();
                queue.add(sl2);
            }
            if(!s.getLastMove().equals("F") && !s.getLastMove().equals("F'") && !s.getLastMove().equals("F2")){
                RubiksCube sf2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf2.f2();
                queue.add(sf2);
            }
            if(!s.getLastMove().equals("B") && !s.getLastMove().equals("B'") && !s.getLastMove().equals("B2")){
                RubiksCube sb2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb2.b2();
                queue.add(sb2);
            }
            if(!s.getLastMove().equals("D") && !s.getLastMove().equals("D'") && !s.getLastMove().equals("D2")){
                RubiksCube sd = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd.d();
                RubiksCube sdprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sdprime.dprime();
                RubiksCube sd2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd2.d2();
                if (findG3.contains(sdprime.getState())){
                    return sdprime;
                }
                if (findG3.contains(sd.getState())){
                    return sd;
                }
                if(sdprime.G3()){
                    return sdprime;
                }
                if(sd.G3()){
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
                if (findG3.contains(suprime.getState())){
                    return suprime;
                }
                if (findG3.contains(su.getState())){
                    return su;
                }
                if(suprime.G3()){
                    return suprime;
                }
                if(su.G3()){
                    return su;
                }
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }
            count += 1;
            if(count == 10000000){
                return s;
            }
            seenBefore.add(Arrays.toString(s.G3position()));
        }
        return null;
    }

    public static RubiksCube phaseFour(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        if (cube.isSolved()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(s.getState())){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                if(sr2.isSolved()){
                    return sr2;
                }
                queue.add(sr2);
            }
            if(!s.getLastMove().equals("L") && !s.getLastMove().equals("L'") && !s.getLastMove().equals("L2")){
                RubiksCube sl2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sl2.l2();
                if(sl2.isSolved()){
                    return sl2;
                }
                queue.add(sl2);
            }
            if(!s.getLastMove().equals("F") && !s.getLastMove().equals("F'") && !s.getLastMove().equals("F2")){
                RubiksCube sf2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf2.f2();
                if(sf2.isSolved()){
                    return sf2;
                }
                queue.add(sf2);
            }
            if(!s.getLastMove().equals("B") && !s.getLastMove().equals("B'") && !s.getLastMove().equals("B2")){
                RubiksCube sb2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb2.b2();
                if(sb2.isSolved()){
                    return sb2;
                }
                queue.add(sb2);
            }
            if(!s.getLastMove().equals("D") && !s.getLastMove().equals("D'") && !s.getLastMove().equals("D2")){
                RubiksCube sd2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd2.d2();
                if(sd2.isSolved()){
                    return sd2;
                }
                queue.add(sd2);
            }
            if(!s.getLastMove().equals("U") && !s.getLastMove().equals("U'") && !s.getLastMove().equals("U2")){
                RubiksCube su2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                su2.u2();
                if(su2.isSolved()){
                    return su2;
                }
                queue.add(su2);
            }
            count += 1;
            if(count == 10000000){
                return s;
            }
            seenBefore.add(s.getState());
        }
        return null;
    }

    public static HashSet<String> findG3(){
        RubiksCube cube = new RubiksCube();
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(s.getState())){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                queue.add(sr2);
            }
            if(!s.getLastMove().equals("L") && !s.getLastMove().equals("L'") && !s.getLastMove().equals("L2")){
                RubiksCube sl2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sl2.l2();
                queue.add(sl2);
            }
            if(!s.getLastMove().equals("F") && !s.getLastMove().equals("F'") && !s.getLastMove().equals("F2")){
                RubiksCube sf2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sf2.f2();
                queue.add(sf2);
            }
            if(!s.getLastMove().equals("B") && !s.getLastMove().equals("B'") && !s.getLastMove().equals("B2")){
                RubiksCube sb2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sb2.b2();
                queue.add(sb2);
            }
            if(!s.getLastMove().equals("D") && !s.getLastMove().equals("D'") && !s.getLastMove().equals("D2")){
                RubiksCube sd2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sd2.d2();
                queue.add(sd2);
            }
            if(!s.getLastMove().equals("U") && !s.getLastMove().equals("U'") && !s.getLastMove().equals("U2")){
                RubiksCube su2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                su2.u2();
                queue.add(su2);
            }
            seenBefore.add(s.getState());
        }
        return seenBefore;
    }
}
