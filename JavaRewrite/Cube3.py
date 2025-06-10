import copy
import numpy as np


class RubiksCube:
    def __init__(self):
        self.greenface = [["g", "g", "g"], ["g", "g", "g"], ["g", "g", "g"]]
        self.whiteface = [["w", "w", "w"], ["w", "w", "w"], ["w", "w", "w"]]
        self.blueface = [["b", "b", "b"], ["b", "b", "b"], ["b", "b", "b"]]
        self.orangeface = [["o", "o", "o"], ["o", "o", "o"], ["o", "o", "o"]]
        self.redface = [["r", "r", "r"], ["r", "r", "r"], ["r", "r", "r"]]
        self.yellowface = [["y", "y", "y"], ["y", "y", "y"], ["y", "y", "y"]]

    def isSolved(self):
        if (self.greenface == [["g", "g", "g"], ["g", "g", "g"], ["g", "g", "g"]]):
            if (self.whiteface == [["w", "w", "w"], ["w", "w", "w"], ["w", "w", "w"]]):
                if (self.blueface == [["b", "b", "b"], ["b", "b", "b"], ["b", "b", "b"]]):
                    if (self.orangeface == [["o", "o", "o"], ["o", "o", "o"], ["o", "o", "o"]]):
                        if (self.redface == [["r", "r", "r"], ["r", "r", "r"], ["r", "r", "r"]]):
                            if (self.yellowface == [["y", "y", "y"], ["y", "y", "y"], ["y", "y", "y"]]):
                                return True
        return False

    # right side up
    def r(self):
        tempred = copy.deepcopy(self.redface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempblue = copy.deepcopy(self.blueface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempred[0][i] = self.redface[2 - i][0]
        for i in range(3):
            tempred[2][2 - i] = self.redface[i][2]
        for i in range(3):
            tempred[i][0] = self.redface[2][i]
        for i in range(3):
            tempred[i][2] = self.redface[0][i]
        for i in range(3):
            tempwhite[i][2] = self.greenface[i][2]
        for i in range(3):
            tempblue[2 - i][0] = self.whiteface[i][2]
        for i in range(3):
            tempyellow[i][0] = self.blueface[i][0]
        for i in range(3):
            tempgreen[i][2] = self.yellowface[2 - i][0]
        self.redface = tempred.copy()
        self.blueface = tempblue.copy()
        self.whiteface = tempwhite.copy()
        self.yellowface = tempyellow.copy()
        self.greenface = tempgreen.copy()

    # right side down
    def rprime(self):
        self.r()
        self.r()
        self.r()

    # left side down
    def l(self):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempblue = copy.deepcopy(self.blueface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            temporange[0][i] = self.orangeface[2 - i][0]
        for i in range(3):
            temporange[2][2 - i] = self.orangeface[i][2]
        for i in range(3):
            temporange[i][0] = self.orangeface[2][i]
        for i in range(3):
            temporange[i][2] = self.orangeface[0][i]
        for i in range(3):
            tempwhite[i][0] = self.blueface[2 - i][2]
        for i in range(3):
            tempblue[i][2] = self.yellowface[i][2]
        for i in range(3):
            tempyellow[i][2] = self.greenface[2 - i][0]
        for i in range(3):
            tempgreen[i][0] = self.whiteface[i][0]
        self.orangeface = temporange.copy()
        self.blueface = tempblue.copy()
        self.whiteface = tempwhite.copy()
        self.yellowface = tempyellow.copy()
        self.greenface = tempgreen.copy()

    def lprime(self):
        self.l()
        self.l()
        self.l()

    def f(self):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempgreen[0][i] = self.greenface[2 - i][0]
        for i in range(3):
            tempgreen[2][2 - i] = self.greenface[i][2]
        for i in range(3):
            tempgreen[i][0] = self.greenface[2][i]
        for i in range(3):
            tempgreen[i][2] = self.greenface[0][i]

        for i in range(3):
            tempwhite[2][i] = self.orangeface[2 - i][2]
        for i in range(3):
            temporange[i][2] = self.yellowface[2][2 - i]
        for i in range(3):
            tempyellow[2][i] = self.redface[i][0]
        for i in range(3):
            tempred[i][0] = self.whiteface[2][i]
        self.orangeface = temporange.copy()
        self.redface = tempred.copy()
        self.whiteface = tempwhite.copy()
        self.yellowface = tempyellow.copy()
        self.greenface = tempgreen.copy()

    def fprime(self):
        self.f()
        self.f()
        self.f()

    def u(self):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempblue = copy.deepcopy(self.blueface)

        for i in range(3):
            tempwhite[0][i] = self.whiteface[2 - i][0]
        for i in range(3):
            tempwhite[2][2 - i] = self.whiteface[i][2]
        for i in range(3):
            tempwhite[i][0] = self.whiteface[2][i]
        for i in range(3):
            tempwhite[i][2] = self.whiteface[0][i]

        for i in range(3):
            tempblue[0][i] = self.orangeface[0][i]
        for i in range(3):
            temporange[0][i] = self.greenface[0][i]
        for i in range(3):
            tempgreen[0][i] = self.redface[0][i]
        for i in range(3):
            tempred[0][i] = self.blueface[0][i]
        self.orangeface = temporange.copy()
        self.redface = tempred.copy()
        self.whiteface = tempwhite.copy()
        self.blueface = tempblue.copy()
        self.greenface = tempgreen.copy()

    def uprime(self):
        self.u()
        self.u()
        self.u()

    def b(self):
        temporange = copy.deepcopy(self.orangeface)
        tempblue = copy.deepcopy(self.blueface)
        tempwhite = copy.deepcopy(self.whiteface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempblue[0][i] = self.blueface[2 - i][0]
        for i in range(3):
            tempblue[2][2 - i] = self.blueface[i][2]
        for i in range(3):
            tempblue[i][0] = self.blueface[2][i]
        for i in range(3):
            tempblue[i][2] = self.blueface[0][i]

        for i in range(3):
            tempwhite[0][i] = self.redface[i][2]
        for i in range(3):
            tempred[i][2] = self.yellowface[0][i]
        for i in range(3):
            tempyellow[0][i] = self.orangeface[2 - i][0]
        for i in range(3):
            temporange[i][0] = self.whiteface[0][2 - i]
        self.orangeface = temporange.copy()
        self.redface = tempred.copy()
        self.whiteface = tempwhite.copy()
        self.yellowface = tempyellow.copy()
        self.blueface = tempblue.copy()

    def bprime(self):
        self.b()
        self.b()
        self.b()

    def d(self):
        temporange = copy.deepcopy(self.orangeface)
        tempgreen = copy.deepcopy(self.greenface)
        tempblue = copy.deepcopy(self.blueface)
        tempred = copy.deepcopy(self.redface)
        tempyellow = copy.deepcopy(self.yellowface)

        for i in range(3):
            tempyellow[0][i] = self.yellowface[2 - i][0]
        for i in range(3):
            tempyellow[2][2 - i] = self.yellowface[i][2]
        for i in range(3):
            tempyellow[i][0] = self.yellowface[2][i]
        for i in range(3):
            tempyellow[i][2] = self.yellowface[0][i]

        for i in range(3):
            tempblue[2][i] = self.orangeface[2][i]
        for i in range(3):
            temporange[2][i] = self.greenface[2][i]
        for i in range(3):
            tempgreen[2][i] = self.redface[2][i]
        for i in range(3):
            tempred[2][i] = self.blueface[2][i]
        self.orangeface = temporange.copy()
        self.redface = tempred.copy()
        self.blueface = tempblue.copy()
        self.yellowface = tempyellow.copy()
        self.greenface = tempgreen.copy()

    def dprime(self):
        self.d()
        self.d()
        self.d()

    def rtwo(self):
        self.r()
        self.r()

    def btwo(self):
        self.b()
        self.b()

    def dtwo(self):
        self.d()
        self.d()

    def utwo(self):
        self.u()
        self.u()

    def ftwo(self):
        self.f()
        self.f()

    def ltwo(self):
        self.l()
        self.l()

    def print(self):
        for i in range(3):
            print(self.greenface[i])
        print()
        for i in range(3):
            print(self.whiteface[i])
        print()
        for i in range(3):
            print(self.blueface[i])
        print()
        for i in range(3):
            print(self.redface[i])
        print()
        for i in range(3):
            print(self.yellowface[i])
        print()
        for i in range(3):
            print(self.orangeface[i])
        print()

    edge_positions = [
        (("whiteface", (2, 1)), ("greenface", (0, 1))),
        (("whiteface", (1, 2)), ("redface", (0, 1))),
        (("whiteface", (0, 1)), ("blueface", (0, 1))),
        (("whiteface", (1, 0)), ("orangeface", (0, 1))),
        (("greenface", (1, 2)), ("redface", (1, 0))),
        (("greenface", (1, 0)), ("orangeface", (1, 2))),
        (("blueface", (1, 0)), ("orangeface", (1, 0))),
        (("blueface", (1, 2)), ("redface", (1, 2))),
        (("yellowface", (0, 1)), ("greenface", (2, 1))),
        (("yellowface", (1, 2)), ("redface", (2, 1))),
        (("yellowface", (2, 1)), ("blueface", (2, 1))),
        (("yellowface", (1, 0)), ("orangeface", (2, 1))),
    ]


    def edge_orientation_index(self):
        orientation = self.edge_orientations()
        n = 0
        for i in range(11):
            n = (n << 1) | orientation[i]
        return n

    def edge_orientations(self):

        color_at_face = {
            'U': self.whiteface[1][1],
            'D': self.yellowface[1][1],
            'F': self.greenface[1][1],
            'B': self.blueface[1][1],
            'L': self.orangeface[1][1],
            'R': self.redface[1][1],
        }

        edge_positions = [
            (('U', 2, 1), ('F', 0, 1)),  # UF
            (('U', 1, 2), ('R', 0, 1)),  # UR
            (('U', 0, 1), ('B', 0, 1)),  # UB
            (('U', 1, 0), ('L', 0, 1)),  # UL
            (('F', 1, 2), ('R', 1, 0)),  # FR
            (('F', 1, 0), ('L', 1, 2)),  # FL
            (('B', 1, 2), ('R', 1, 2)),  # BR
            (('B', 1, 0), ('L', 1, 0)),  # BL
            (('D', 0, 1), ('F', 2, 1)),  # DF
            (('D', 1, 2), ('R', 2, 1)),  # DR
            (('D', 2, 1), ('B', 2, 1)),  # DB
            (('D', 1, 0), ('L', 2, 1)),  # DL
        ]

        face_map = {
            'U': self.whiteface,
            'D': self.yellowface,
            'F': self.greenface,
            'B': self.blueface,
            'L': self.orangeface,
            'R': self.redface,
        }

        orientations = []

        for i, (pos1, pos2) in enumerate(edge_positions):
            f1, r1, c1 = pos1
            f2, r2, c2 = pos2
            color1 = face_map[f1][r1][c1]
            color2 = face_map[f2][r2][c2]

            if f1 in ('U', 'D'):
                flipped = int(color1 != color_at_face[f1])
            elif f2 in ('U', 'D'):
                flipped = int(color2 != color_at_face[f2])
            else:
                flipped = int(color1 != color_at_face[f1])

            if i < 11:
                orientations.append(flipped)

        return orientations


from collections import deque



def pruning_table():
    table_size = 2048
    pruning_table = [-1] * table_size

    solved_cube = RubiksCube()
    start_index = solved_cube.edge_orientation_index()
    pruning_table[start_index] = 0

    queue = deque()
    queue.append((solved_cube, 0))

    moves = ["r", "rprime", "rtwo",
             "l", "lprime", "ltwo",
             "f", "fprime", "ftwo",
             "u", "uprime", "utwo",
             "b", "bprime", "btwo",
             "d", "dprime", "dtwo"]
    i= []
    while queue:
        cube, depth = queue.popleft()
        for move in moves:
            i.append([1])
            new_cube = copy.deepcopy(cube)
            getattr(new_cube, move)()
            #print(move)
            #print(new_cube.edge_orientations)
            #print(len(i))
            if pruning_table[new_cube.edge_orientation_index()] == -1 or pruning_table[new_cube.edge_orientation_index()] > (depth + 1):
                pruning_table[new_cube.edge_orientation_index()] = (depth + 1)
                queue.append((new_cube, depth + 1))


        #if depth % 2 == 0:
        #    visited = sum(1 for x in pruning_table if x != -1)
        #    print(f"Depth {depth}, Visited {visited}")
    return pruning_table

def checker():
    solved_cube = RubiksCube()
    queue = []
    queue.append((solved_cube, 0))
    moves = ["r", "rprime", "rtwo",
             "l", "lprime", "ltwo",
             "f", "fprime", "ftwo",
             "u", "uprime", "utwo",
             "b", "bprime", "btwo",
             "d", "dprime", "dtwo"]
    arr = []
    sum = 0
    while queue:
        cube, depth = queue.pop(0)
        for move in moves:
            new_cube = copy.deepcopy(cube)
            getattr(cube, move)()
            print(move)
            print("Depth = ",{depth})
            print(cube.edge_orientations)
            print("Index = ",{cube.edge_orientation_index()})
            arr.append(cube.edge_orientation_index())
            queue.append((new_cube, depth + 1))


def phase1(cube, pruning_table):
    moves = ["r", "rprime", "rtwo", "l", "lprime", "ltwo",
             "f", "fprime", "ftwo", "u", "uprime", "utwo",
             "b", "bprime", "btwo", "d", "dprime", "dtwo"]

    move_opposites = {
        "r": "rprime", "rprime": "r", "rtwo": "rtwo",
        "l": "lprime", "lprime": "l", "ltwo": "ltwo",
        "f": "fprime", "fprime": "f", "ftwo": "ftwo",
        "u": "uprime", "uprime": "u", "utwo": "utwo",
        "b": "bprime", "bprime": "b", "btwo": "btwo",
        "d": "dprime", "dprime": "d", "dtwo": "dtwo"
    }

    def dfs(cube, pruning_table):
        path = []
        old_cube_index = cube.edge_orientation_index()
        #print(old_cube_index)
        for move in moves:
            new_cube = copy.deepcopy(cube)
            getattr(new_cube, move)()
            new_cube_index = new_cube.edge_orientation_index()
            #print(new_cube_index)
            #print(pruning_table[new_cube_index])
            if pruning_table[new_cube_index] < pruning_table[old_cube_index] and pruning_table[new_cube_index] > -1:
                path.append(move)
                dfs(new_cube, pruning_table)
        return path

    path = dfs(cube, pruning_table)
    return path

cube = RubiksCube()
cube.b()
cube.f()
cube.l()
cube.rtwo()
cube.fprime()
print("INDICIES:")
print(cube.edge_orientation_index())
cube.f()
print(cube.edge_orientation_index())


pruning_table = pruning_table()
phase1_solution = phase1(cube, pruning_table)
hit = 0
missed = 0
for i in range(len(pruning_table)):
    if pruning_table[i] != -1:
        hit += 1
    else:
        missed+=1
print("Inicies hit: ",hit)
print("Inicies missed: ",missed)
print("Phase 1 solution:", phase1_solution)
print(cube.edge_orientation_index())
print(pruning_table[cube.edge_orientation_index()])
print(pruning_table)
