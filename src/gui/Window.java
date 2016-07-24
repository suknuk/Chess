package gui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import board.Board;
import board.Move;
import chess.Chess;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;

/*
 * Class responsible to display the chessboard and register the mouse
 */
public class Window extends Applet implements Runnable, MouseListener {

	private static final long serialVersionUID = 8551786484748424017L;
	private static int FPS = 60;
	private static long lastUpdate = System.currentTimeMillis();
	private static long millisPerFrame = 1000 / FPS;
	private static long timeSinceLastUpdate;

	public static int windowWidth = 640;
	public static int windowHeight = 640;

	private Image image;
	private Graphics second;

	/*
	 * black and white piece images
	 */
	private BufferedImage img_black_pawn;
	private BufferedImage img_black_tower;
	private BufferedImage img_black_knight;
	private BufferedImage img_black_bishop;
	private BufferedImage img_black_queen;
	private BufferedImage img_black_king;

	private BufferedImage img_white_pawn;
	private BufferedImage img_white_tower;
	private BufferedImage img_white_knight;
	private BufferedImage img_white_bishop;
	private BufferedImage img_white_queen;
	private BufferedImage img_white_king;

	/*
	 * board instance
	 */
	private Board board;

	/*
	 * variable to show possible moves to a player on the board
	 */
	ArrayList<Move> possibleMoves;

	@Override
	public void init() {

		setSize(windowWidth, windowHeight);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Snake");

		loadImages();

		board = new Board();
		Chess.setupNormalMatch(board);

		board.addPiece(new Queen(4, 4, PieceColor.BLACK, board));

		possibleMoves = new ArrayList<Move>();

		this.addMouseListener(this);
	}

	private void loadImages() {
		try {
			URL url_black_pawn = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/pawn_black.png");
			URL url_black_tower = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/tower_black.png");
			URL url_black_knight = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/knight_black.png");
			URL url_black_bishop = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/bishop_black.png");
			URL url_black_queen = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/queen_black.png");
			URL url_black_king = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/king_black.png");

			URL url_white_pawn = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/pawn_white.png");
			URL url_white_tower = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/tower_white.png");
			URL url_white_knight = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/knight_white.png");
			URL url_white_bishop = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/bishop_white.png");
			URL url_white_queen = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/queen_white.png");
			URL url_white_king = new URL(getCodeBase(),
					"/home/raymond/Documents/eclipse_workspace/chess/images/king_white.png");

			img_black_pawn = ImageIO.read(url_black_pawn);
			img_black_tower = ImageIO.read(url_black_tower);
			img_black_knight = ImageIO.read(url_black_knight);
			img_black_bishop = ImageIO.read(url_black_bishop);
			img_black_queen = ImageIO.read(url_black_queen);
			img_black_king = ImageIO.read(url_black_king);

			img_white_pawn = ImageIO.read(url_white_pawn);
			img_white_tower = ImageIO.read(url_white_tower);
			img_white_knight = ImageIO.read(url_white_knight);
			img_white_bishop = ImageIO.read(url_white_bishop);
			img_white_queen = ImageIO.read(url_white_queen);
			img_white_king = ImageIO.read(url_white_king);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void run() {
		while (true) {

			repaint();

			timeSinceLastUpdate = System.currentTimeMillis() - lastUpdate;
			if (timeSinceLastUpdate < millisPerFrame) {
				long timeToSlepp = millisPerFrame - timeSinceLastUpdate;
				try {
					Thread.sleep(timeToSlepp);
					// Thread.sleep(16);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lastUpdate = System.currentTimeMillis();
		}
	}

	@Override
	public void update(Graphics g) {

		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(Color.gray);
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());

		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		/*
		 * painting the board
		 */
		g.setColor(Color.white);
		boolean flip = true;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (flip) {
					g.fillRect(x * 80 + 2, y * 80 + 2, 76, 76);
				}
				flip = !flip;
			}
			flip = !flip;
		}

		paintPossibleMoves(g);
		paintChessPieces(g);
	}

	/*
	 * Method to paint possible moves on the board
	 */
	private void paintPossibleMoves(Graphics g) {
		g.setColor(Color.YELLOW);
		for (Move mv : possibleMoves) {
			g.fillOval(mv.toX() * 80 + 20, mv.toY() * 80 + 20, 40, 40);
		}
	}

	/**
	 * Painting the chess pieces of the board onto the board
	 * 
	 * @param g
	 *            The graphics instance
	 */
	private void paintChessPieces(Graphics g) {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (board.getPieceAt(x, y) != null) {
					BufferedImage paintPiece = img_white_pawn;
					/*
					 * checking all white pieces
					 */
					if (board.getPieceAt(x, y).color() == PieceColor.WHITE) {
						if (board.getPieceAt(x, y).getClass().equals(Pawn.class)) {
							paintPiece = img_white_pawn;
						} else if (board.getPieceAt(x, y).getClass().equals(Tower.class)) {
							paintPiece = img_white_tower;
						} else if (board.getPieceAt(x, y).getClass().equals(Knight.class)) {
							paintPiece = img_white_knight;
						} else if (board.getPieceAt(x, y).getClass().equals(Bishop.class)) {
							paintPiece = img_white_bishop;
						} else if (board.getPieceAt(x, y).getClass().equals(Queen.class)) {
							paintPiece = img_white_queen;
						} else if (board.getPieceAt(x, y).getClass().equals(King.class)) {
							paintPiece = img_white_king;
						}
						/*
						 * checking all black pieces
						 */
					} else {
						if (board.getPieceAt(x, y).getClass().equals(Pawn.class)) {
							paintPiece = img_black_pawn;
						} else if (board.getPieceAt(x, y).getClass().equals(Tower.class)) {
							paintPiece = img_black_tower;
						} else if (board.getPieceAt(x, y).getClass().equals(Knight.class)) {
							paintPiece = img_black_knight;
						} else if (board.getPieceAt(x, y).getClass().equals(Bishop.class)) {
							paintPiece = img_black_bishop;
						} else if (board.getPieceAt(x, y).getClass().equals(Queen.class)) {
							paintPiece = img_black_queen;
						} else if (board.getPieceAt(x, y).getClass().equals(King.class)) {
							paintPiece = img_black_king;
						}
					}
					g.drawImage(paintPiece, x * 80 + 7, y * 80 + 7, this);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int clicked_x = e.getX() / 80;
		int clicked_y = e.getY() / 80;

		System.out.println("Registered click at " + clicked_x + " " + clicked_y);

		/*
		 * click position must be from 0 to 7
		 */
		if (clicked_x >= 0 && clicked_x <= 7 && clicked_y >= 0 && clicked_y <= 7) {

			if (board.getPieceAt(clicked_x, clicked_y) != null) {
				/*
				 * Checking if piece selected is from player who has to go next
				 */
				if (board.getPieceAt(clicked_x, clicked_y).color() == board.whichPlayerToGo()) {
					possibleMoves = new ArrayList<Move>();
					possibleMoves.addAll(board.getPieceAt(clicked_x, clicked_y).possibleMoves(board));
					System.out.println("Moves found :" + possibleMoves.size());
				} else {
					System.out.println("Selected enemy piece");
					/*
					 * clicked on enemy piece, hit it if in the possibleMoves
					 * list
					 */
					for (Move mv : possibleMoves) {
						if (mv.toX() == clicked_x && mv.toY() == clicked_y) {
							board.applyMove(mv);
							board.changePlayerToGo();
							possibleMoves = new ArrayList<Move>();
							break;
						}
					}
				}
				/*
				 * check if click was in the possibleMoves list and move the
				 * selected piece if it was
				 */
			} else {
				for (Move mv : possibleMoves) {
					if (mv.toX() == clicked_x && mv.toY() == clicked_y) {
						board.applyMove(mv);
						board.changePlayerToGo();
						possibleMoves = new ArrayList<Move>();
						break;
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
