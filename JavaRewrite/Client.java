import java.util.*;

public class Client {
    public static void main(String[] args){
        RubiksCube cube = new RubiksCube();
        cube.doScramble("R B' U R' F2 R2 F B2 L D2 B2 U2 R' U2 D2 F2 R' D2 B D'");
        cube.resetSolution();
        cube.resetLastMove();
        RubiksCube phaseOne = phaseOne(cube);
        RubiksCube phaseTwo = phaseTwo(phaseOne);
        RubiksCube phaseThree = phaseThree(phaseTwo);
        RubiksCube newcube = phaseFour(phaseThree);
        System.out.println(newcube.getSolution());
        newcube.print();
    }

    public static RubiksCube kociembaPhaseOne(RubiksCube cube){
        Queue<RubiksCube> queue = new LinkedList<>();
        queue.add(cube);
        HashSet<String> seenBefore = new HashSet<>();
        if (cube.G1wy() ||cube.G1bg() || cube.G1ro()){
            return cube;
        }
        int count = 0;
        while  (!queue.isEmpty()){
            RubiksCube s= queue.remove();
            if (seenBefore.contains(s.getState())){
                continue;
            }
            if(!s.getLastMove().equals("R") && !s.getLastMove().equals("R'") && !s.getLastMove().equals("R2")){
                RubiksCube sr = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr.r();
                RubiksCube srprime = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                srprime.rprime();
                RubiksCube sr2 = new RubiksCube(s.getState(), s.getLastMove(), s.getSolution());
                sr2.r2();
                if (srprime.G1wy() ||srprime.G1bg() || srprime.G1ro()){
                    return srprime;
                }
                if (sr.G1wy() ||sr.G1bg() || sr.G1ro()){
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
                if (slprime.G1wy() ||slprime.G1bg() || slprime.G1ro()){
                    return slprime;
                }
                if (sl.G1wy() ||sl.G1bg() || sl.G1ro()){
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
                if (sfprime.G1wy() ||sfprime.G1bg() || sfprime.G1ro()){
                    return sfprime;
                }
                if (sf.G1wy() ||sf.G1bg() || sf.G1ro()){
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
                if (sbprime.G1wy() ||sbprime.G1bg() || sbprime.G1ro()){
                    return sbprime;
                }
                if (sb.G1wy() ||sb.G1bg() || sb.G1ro()){
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
                if (sdprime.G1wy() ||sdprime.G1bg() || sdprime.G1ro()){
                    return sdprime;
                }
                if (sd.G1wy() ||sd.G1bg() || sd.G1ro()){
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
                if (suprime.G1wy() ||suprime.G1bg() || suprime.G1ro()){
                    return suprime;
                }
                if (su.G1wy() ||su.G1bg() || su.G1ro()){
                    return su;
                }
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }
            count += 1;
            System.out.println(s.getSolution());
            System.out.println(count);
            System.out.println(seenBefore.size());
            if(count == 1000000){
                return s;
            }
            seenBefore.add(s.getState());
        }
        return null;
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
            System.out.println(s.getSolution());
            System.out.println(count);
            if(count == 10000){
                for (String element : seenBefore) {
                    System.out.println(element);
                }
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
            System.out.println(s.getSolution());
            System.out.println(count);
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
        HashSet<String> G3 = findG3();
        if (G3.contains(cube.getState())){
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
                if (G3.contains(sdprime.getState())){
                    return sdprime;
                }
                if (G3.contains(sd.getState())){
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
                if (G3.contains(suprime.getState())){
                    return suprime;
                }
                if (G3.contains(su.getState())){
                    return su;
                }
                queue.add(su);
                queue.add(su2);
                queue.add(suprime);
            }
            count += 1;
            System.out.println(s.getSolution());
            System.out.println(count);
            if(count == 10000000){
                return s;
            }
            seenBefore.add(s.getState());
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
            System.out.println(s.getSolution());
            System.out.println(count);
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
        int count = 0;
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
            count += 1;
            seenBefore.add(s.getState());
        }
        return seenBefore;
    }
}
