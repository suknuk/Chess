# Chess

Chess program written in Java.

## Using own AI

This program is designed to be modified by your own algorithms on chessboard evaluation and move evaluation with a time restriction.

### Chessboard evaluation

Examples of board evaluation algorithms can be found in the ```src/chess/BoardEvaluation.java``` file. The most simple evaluation algorithm in the file simply counts the value of each piece on the board and if a player is in the 'mate' position

In the same file, you will find the variables to change the value of each chess piece, if you want to modify the value.

### Move evaluation

Move evaluation algorithm examples can be found in the ```src/chess/MoveEvaluation.java``` file.

## Testing

To assure correct functionality of the program, JUnit is extensively used to test the program components.
The JUnitTestSuite.java in the ```test/testSuite``` folder is linked to all test sub-test suites and test cases.


### Image licence

Images are under the Creative Commons Attribution-Share Alike 3.0 Unported licence
+ [Creative Commons](https://en.wikipedia.org/wiki/en:Creative_Commons)
+ [Attribution Share Alike 3.0](https://creativecommons.org/licenses/by-sa/3.0/deed.en)

Found [here](https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent) , made by the user [Cburnett](https://en.wikipedia.org/wiki/User:Cburnett)