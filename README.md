Java-ex1


=============================
=      File description     =
=============================
Competition.java - contains the class Competition, which represents a competition of certain number of
                   rounds between 2 players.
Board.java -       contains the class Board, which represents a board that the competition is taking place on.
Player.java -      contains the class Player, which represents a player playing the nim game. Contains four
                   different kinds of players.
Move.java -        contains the class Move, which represents a move that the players make on the board.


=============================
=          Design           =
=============================
The rules of the game are simple: remove continuous sequence of rows. the last who removes sticks loses. The
program describes 4 objects: a competition, board, player and move. The Competition class is the
main class, and it calls for the other classes to run properly. In each competition there are two
player that play the nim-game a certain number of rounds.
There are 4 different kinds of players: 1) Human - the program asks him how he would like to move each turn.
2) random - making its moves randomly. 3) smart - has some logic behind his moves and 4) heuristic - he is
good at this game, and there's no proof why.
In the competition class i chose to have an array of length 2 for the scores instead of 2 different int
variables, because it is more efficient to update the scores that way.

=============================
=  Implementation details   =
=============================
The smart player - the logic behind this player is simple: always make sure there is an odd number of
unmarked sticks on the boards. That's why he makes a single sequence move if there is even number, and 2
sticks move if there is odd number. If there is no 2 sticks sequence, he makes a single sequence move.

=============================
=    Answers to questions   =
=============================
