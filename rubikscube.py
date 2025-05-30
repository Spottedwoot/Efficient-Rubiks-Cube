import copy

class RubiksCube:
    def __init__(self, greenface=[["g","g","g"],["g","g","g"],["g","g","g"]], whiteface=[["w","w","w"],["w","w","w"],["w","w","w"]], blueface=[["b","b","b"],["b","b","b"],["b","b","b"]], orangeface=[["o","o","o"],["o","o","o"],["o","o","o"]], redface=[["r","r","r"],["r","r","r"],["r","r","r"]], yellowface=[["y","y","y"],["y","y","y"],["y","y","y"]], solution="", lastmove = ""):
        self.greenface = greenface
        self.whiteface = whiteface
        self.blueface = blueface
        self.orangeface = orangeface
        self.redface = redface
        self.yellowface = yellowface
        self.solution = solution
        self.lastmove = lastmove

    def isSolved(self):
        if (self.greenface == [["g","g","g"],["g","g","g"],["g","g","g"]]):
            if(self.whiteface == [["w","w","w"],["w","w","w"],["w","w","w"]]):
                if(self.blueface == [["b","b","b"],["b","b","b"],["b","b","b"]]):
                    if(self.orangeface == [["o","o","o"],["o","o","o"],["o","o","o"]]):
                        if(self.redface == [["r","r","r"],["r","r","r"],["r","r","r"]]):
                            if(self.yellowface == [["y","y","y"],["y","y","y"],["y","y","y"]]):
                                return True
        return False
    

    #right side up
    def r(self, flag):
        tempred = copy.deepcopy(self.redface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempblue = copy.deepcopy(self.blueface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempred[0][i]= self.redface[2-i][0]
        for i in range(3):
            tempred[2][2-i]= self.redface[i][2]
        for i in range(3):
            tempred[i][0]= self.redface[2][i]
        for i in range(3):
            tempred[i][2]= self.redface[0][i]
        for i in range(3):
            tempwhite[i][2] = self.greenface[i][2]
        for i in range(3):
            tempblue[2-i][0] = self.whiteface[i][2]
        for i in range(3):
            tempyellow[i][0] = self.blueface[i][0]
        for i in range(3):
            tempgreen[i][2] = self.yellowface[2-i][0]
        self.redface =tempred.copy()
        self.blueface =tempblue.copy()
        self.whiteface =tempwhite.copy()
        self.yellowface =tempyellow.copy()
        self.greenface =tempgreen.copy()
        if(flag):
            self.solution += "R"

    #right side down
    def rprime(self):
        self.r(False)
        self.r(False)
        self.r(False)
        self.solution += "R'"

    #left side down
    def l(self, flag):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempblue = copy.deepcopy(self.blueface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            temporange[0][i]= self.orangeface[2-i][0]
        for i in range(3):
            temporange[2][2-i]= self.orangeface[i][2]
        for i in range(3):
            temporange[i][0]= self.orangeface[2][i]
        for i in range(3):
            temporange[i][2]= self.orangeface[0][i]
        for i in range(3):
            tempwhite[i][0] = self.blueface[2-i][2]
        for i in range(3):
            tempblue[i][2] = self.yellowface[i][2]
        for i in range(3):
            tempyellow[i][2] = self.greenface[2-i][0]
        for i in range(3):
            tempgreen[i][0] = self.whiteface[i][0]
        self.orangeface =temporange.copy()
        self.blueface =tempblue.copy()
        self.whiteface =tempwhite.copy()
        self.yellowface =tempyellow.copy()
        self.greenface =tempgreen.copy()
        if(flag):
            self.solution += "L"

    def lprime(self):
        self.l(False)
        self.l(False)
        self.l(False)
        self.solution += "L'"

    def f(self, flag):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempgreen[0][i]= self.greenface[2-i][0]
        for i in range(3):
            tempgreen[2][2-i]= self.greenface[i][2]
        for i in range(3):
            tempgreen[i][0]= self.greenface[2][i]
        for i in range(3):
            tempgreen[i][2]= self.greenface[0][i]
        
        for i in range(3):
            tempwhite[2][i] = self.orangeface[2-i][2]
        for i in range(3):
            temporange[i][2] = self.yellowface[2][2-i]
        for i in range(3):
            tempyellow[2][i] = self.redface[i][0]
        for i in range(3):
            tempred[i][0] = self.whiteface[2][i]
        self.orangeface =temporange.copy()
        self.redface =tempred.copy()
        self.whiteface =tempwhite.copy()
        self.yellowface =tempyellow.copy()
        self.greenface =tempgreen.copy()
        if(flag):
            self.solution += "F"

    def fprime(self):
        self.f(False)
        self.f(False)
        self.f(False)

        self.solution += "F'"

    def u(self, flag):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempblue = copy.deepcopy(self.blueface)

        for i in range(3):
            tempwhite[0][i]= self.whiteface[2-i][0]
        for i in range(3):
            tempwhite[2][2-i]= self.whiteface[i][2]
        for i in range(3):
            tempwhite[i][0]= self.whiteface[2][i]
        for i in range(3):
            tempwhite[i][2]= self.whiteface[0][i]
        
        for i in range(3):
            tempblue[0][i] = self.orangeface[0][i]
        for i in range(3):
            temporange[0][i] = self.greenface[0][i]
        for i in range(3):
            tempgreen[0][i] = self.redface[0][i]
        for i in range(3):
            tempred[0][i] = self.blueface[0][i]
        self.orangeface =temporange.copy()
        self.redface =tempred.copy()
        self.whiteface =tempwhite.copy()
        self.blueface =tempblue.copy()
        self.greenface =tempgreen.copy()
        if(flag):
            self.solution += "U"

    def uprime(self):
        self.u(False)
        self.u(False)
        self.u(False)

        self.solution += "U'"

    def b(self, flag):
        temporange = copy.deepcopy(self.orangeface)
        tempblue = copy.deepcopy(self.blueface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempblue[0][i]= self.blueface[2-i][0]
        for i in range(3):
            tempblue[2][2-i]= self.blueface[i][2]
        for i in range(3):
            tempblue[i][0]= self.blueface[2][i]
        for i in range(3):
            tempblue[i][2]= self.blueface[0][i]
        
        for i in range(3):
            tempwhite[0][i] = self.redface[i][2]
        for i in range(3):
            tempred[i][2] = self.yellowface[0][i]
        for i in range(3):
            tempyellow[0][i] = self.orangeface[2-i][0]
        for i in range(3):
            temporange[i][0] = self.whiteface[0][2-i]
        self.orangeface =temporange.copy()
        self.redface =tempred.copy()
        self.whiteface =tempwhite.copy()
        self.yellowface =tempyellow.copy()
        self.blueface =tempblue.copy()
        if(flag):
            self.solution += "B"

    def bprime(self):
        self.solution += "B'"
        self.b(False)
        self.b(False)
        self.b(False)

    def d(self,flag):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempblue = copy.deepcopy(self.blueface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempyellow[0][i]= self.yellowface[2-i][0]
        for i in range(3):
            tempyellow[2][2-i]= self.yellowface[i][2]
        for i in range(3):
            tempyellow[i][0]= self.yellowface[2][i]
        for i in range(3):
            tempyellow[i][2]= self.yellowface[0][i]
        
        for i in range(3):
            tempblue[2][i] = self.redface[2][i]
        for i in range(3):
            temporange[2][i] = self.blueface[2][i]
        for i in range(3):
            tempgreen[2][i] = self.orangeface[2][i]
        for i in range(3):
            tempred[2][i] = self.greenface[2][i]
        self.orangeface =temporange.copy()
        self.redface =tempred.copy()
        self.blueface =tempblue.copy()
        self.yellowface =tempyellow.copy()
        self.greenface =tempgreen.copy()
        if(flag):
            self.solution += "D"

    def dprime(self):
        self.d(False)
        self.d(False)
        self.d(False)

        self.solution += "D'"

    def r2(self):
        self.r(False)
        self.r(False)

        self.solution += "R2"
    
    def b2(self):
        self.b(False)
        self.b(False)

        self.solution += "B2"
    
    def d2(self):
        self.d(False)
        self.d(False)

        self.solution += "D2"
    
    def u2(self):
        self.u(False)
        self.u(False)

        self.solution += "U2"
    
    def f2(self):
        self.f(False)
        self.f(False)

        self.solution += "F2"

    def l2(self):
        self.l(False)
        self.l(False)

        self.solution += "L2"

    def print(self):
        for i in range (3):
            print (self.greenface[i])
        print()
        for i in range (3):
            print (self.whiteface[i])
        print()
        for i in range (3):
            print (self.blueface[i])
        print()
        for i in range (3):
            print (self.redface[i])
        print()
        for i in range (3):
            print (self.yellowface[i])
        print()
        for i in range (3):
            print (self.orangeface[i])
        print()
    
    def doScramble(self, scramble):
        for i in range(len(scramble)):
            if scramble[i] == "'":
                scramble = scramble[:i-1] + scramble[i-1].lower() + scramble[i:]
            if scramble[i]== "2":
                if scramble[i-1]== "R":
                    scramble = scramble[:i-1] + "w" + scramble[i:]
                if scramble[i-1]== "D":
                    scramble = scramble[:i-1] + "e" + scramble[i:]
                if scramble[i-1]== "U":
                    scramble = scramble[:i-1] + "t" + scramble[i:]
                if scramble[i-1]== "B":
                    scramble = scramble[:i-1] + "y" + scramble[i:]
                if scramble[i-1]== "F":
                    scramble = scramble[:i-1] + "i" + scramble[i:]
                if scramble[i-1]== "L":
                    scramble = scramble[:i-1] + "o" + scramble[i:]
        for i in range(len(scramble)):
            if (scramble[i] != "'" or scramble[i] != "2"):
                if scramble[i] == "r":
                    self.rprime()
                if scramble[i] == "b":
                    self.bprime()
                if scramble[i] == "u":
                    self.uprime()
                if scramble[i] == "d":
                    self.dprime()
                if scramble[i] == "f":
                    self.fprime()
                if scramble[i] == "l":
                    self.lprime()

                if scramble[i] == "R":
                    self.r(True)
                if scramble[i] == "L":
                    self.l(True)
                if scramble[i] == "U":
                    self.u(True)
                if scramble[i] == "D":
                    self.d(True)
                if scramble[i] == "B":
                    self.b(True)
                if scramble[i] == "F":
                    self.f(True)

                if scramble[i] == "w":
                    self.r2()
                if scramble[i] == "o":
                    self.l2()
                if scramble[i] == "t":
                    self.u2()
                if scramble[i] == "e":
                    self.d2()
                if scramble[i] == "y":
                    self.b2()
                if scramble[i] == "i":
                    self.f2()
    
    def kociembaAble(self):
        result = True
        for i in range(len(self.whiteface)):
            for j in range(len(self.whiteface[i])):
                result = (self.whiteface[i][j]=="y" or self.whiteface[i][j]=="w") and result
        for i in range(len(self.yellowface)):
            for j in range(len(self.yellowface[i])):
                result = (self.yellowface[i][j]=="y" or self.yellowface[i][j]=="w") and result
        for i in range(len(self.greenface)):
            result = (self.greenface[1][i]=="g" or self.greenface[1][i]=="b") and result
        for i in range(len(self.blueface)):
            result = (self.blueface[1][i]=="g" or self.blueface[1][i]=="b") and result
        for i in range(len(self.orangeface)):
            result = (self.orangeface[1][i]=="o" or self.orangeface[1][i]=="r") and result
        for i in range(len(self.redface)):
            result = (self.redface[1][i]=="o" or self.redface[1][i]=="r") and result
        return result
    
    def deepcopy(self):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempblue = copy.deepcopy(self.blueface)
        tempyellow = copy.deepcopy(self.yellowface)
        tempred = copy.deepcopy(self.redface)
        return RubiksCube(tempgreen,tempwhite, tempblue,temporange, tempred,tempyellow, self.solution, self.lastmove)
    
def kociembaPhaseOne(cube):
    foundG1 = False
    queue = []
    queue.append(cube)
    if (cube.kociembaAble()):
            return cube
    count = 0
    while not foundG1:
        s= queue.pop(0)
        if(s.lastmove != "R" and s.lastmove != "R'" and s.lastmove != "R2"):
            sr = s.deepcopy()
            sr.r(True)
            srprime = s.deepcopy()
            srprime.rprime()
            sr2 = s.deepcopy()
            sr2.r2()
            if (srprime.kociembaAble()):
                return srprime
            if (sr.kociembaAble()):
                return sr
            queue.append(sr)
            queue.append(sr2)
            queue.append(srprime)
        if(s.lastmove != "L" and s.lastmove != "L'" and s.lastmove != "L2"):
            sl = s.deepcopy()
            sl.l(True)
            slprime = s.deepcopy()
            slprime.lprime()
            sl2 = s.deepcopy()
            sl2.l2()
            if (slprime.kociembaAble()):
                return slprime
            if (sl.kociembaAble()):
                return sl
            queue.append(sl)
            queue.append(sl2)
            queue.append(slprime)
        if(s.lastmove != "F" and s.lastmove != "F'" and s.lastmove != "F2"):
            sf = s.deepcopy()
            sf.f(True)
            sfprime = s.deepcopy()
            sfprime.fprime()
            sf2 = s.deepcopy()
            sf2.f2()
            if (sfprime.kociembaAble()):
                return sfprime
            if (sf.kociembaAble()):
                return sf
            queue.append(sf)
            queue.append(sf2)
            queue.append(sfprime)
        if(s.lastmove != "B" and s.lastmove != "B'" and s.lastmove != "B2"):
            sb = s.deepcopy()
            sb.b(True)
            sbprime = s.deepcopy()
            sbprime.bprime()
            sb2 = s.deepcopy()
            sb2.b2()
            if (sbprime.kociembaAble()):
                return sbprime
            if (sb.kociembaAble()):
                return sb
            queue.append(sb)
            queue.append(sb2)
            queue.append(sbprime)
        if(s.lastmove != "U" and s.lastmove != "U'" and s.lastmove != "U2"):
            su = s.deepcopy()
            su.u(True)
            suprime = s.deepcopy()
            suprime.uprime()
            su2 = s.deepcopy()
            su2.u2()
            queue.append(su)
            queue.append(su2)
            queue.append(suprime)
        if(s.lastmove != "D" and s.lastmove != "D'" and s.lastmove != "D2"):
            sd = s.deepcopy()
            sd.d(True)
            sdprime = s.deepcopy()
            sdprime.dprime()
            sd2 = s.deepcopy()
            sd2.d2()
            queue.append(sd)
            queue.append(sd2)
            queue.append(sdprime)
        count += 1
        print(count)
cube = RubiksCube()
cube.doScramble("F' U2 F2 R2 F' R2 F L2 B2 U2 F' U2 R' F2 L' D L2 D2 B' R B2")
cube.solution = ""
G1 = kociembaPhaseOne(cube)