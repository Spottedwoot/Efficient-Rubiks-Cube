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
        self.edge_orientations = [0] * 12

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

        for edge_index in [1, 4, 9, 7]:  # UR, FR, DR, BR
            self.edge_orientations[edge_index] ^= 1


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

        for edge_index in [3, 5, 11, 6]:  # UL, FL, DL, BL
            self.edge_orientations[edge_index] ^= 1

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

        for edge_index in [0, 4, 8, 5]:  # UF, FR, DF, FL
            self.edge_orientations[edge_index] ^= 1

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

        for edge_index in [2, 7, 10, 6]:  # 	UB, BR, DB, BL
            self.edge_orientations[edge_index] ^= 1

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



    def __deepcopy__(self, memo):
        new_cube = RubiksCube()
        new_cube.redface = copy.deepcopy(self.redface, memo)
        new_cube.greenface = copy.deepcopy(self.greenface, memo)
        new_cube.whiteface = copy.deepcopy(self.whiteface, memo)
        new_cube.blueface = copy.deepcopy(self.blueface, memo)
        new_cube.yellowface = copy.deepcopy(self.yellowface, memo)
        new_cube.orangeface = copy.deepcopy(self.orangeface, memo)

        new_cube.edge_orientations = self.edge_orientations.copy()
        return new_cube

    def edge_orientation_index(self):
        n = 0
        for i in range(11):
            n = (n << 1) | self.edge_orientations[i]
        return n


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
            print(move)
            print(new_cube.edge_orientations)
            print(len(i))
            if pruning_table[new_cube.edge_orientation_index()] == -1 or pruning_table[new_cube.edge_orientation_index()] > (depth + 1):
                pruning_table[new_cube.edge_orientation_index()] = (depth + 1)
                queue.append((new_cube, depth + 1))


        if depth % 2 == 0:
            visited = sum(1 for x in pruning_table if x != -1)
            print(f"Depth {depth}, Visited {visited}")
    return pruning_table



def phase1(cube, pruning_table, max_depth):
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

    def dfs(cube, depth, path, last_move):
        index = cube.edge_orientation_index ()
        if index == 0:
            return path

        if pruning_table[index] > max_depth - depth:
            return None

        for move in moves:
            if move_opposites.get(move) != last_move:
                new_cube = copy.deepcopy(cube)
                getattr(new_cube, move)()
                result = dfs(new_cube, depth + 1, path + [move], move)
                if result is not None:
                    return result
        return None

    for depth in range(max_depth + 1):
        result = dfs(cube, 0, [], None)
        if result is not None:
            temp_result = []
            if len(result) >= 4:
                for i in range(len(result) - 4):
                    if result[i] == result[i + 1] == result[i + 2] == result[i + 3]:
                        temp_result = result[:i]
                        a = np.linspace(i + 4, len(result)-1, len(result) - i - 4)
                        for j in a.astype(int):
                            temp_result.append(result[j])
            if temp_result is not None:
                result = temp_result
            return result
    return None


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

cube = RubiksCube()
#checker()
cube.r()
cube.rprime()
print(cube.edge_orientations)

print(pruning_table())


