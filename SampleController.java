package application;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.scene.paint.Color;
import java.util.Random;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
// DumbAI, Move Log, Save, Load, Smart AI
public class SampleController {
	
	private Main mainApplication;
	private ArrayList<ArrayList<Button>> board = new ArrayList<> ();
	private ArrayList<ArrayList<Button>> diagnalSets = new ArrayList<> ();
	private final String White = "-fx-background-color: #bbd1ea;";
	private final String Yellow = "-fx-background-color: #ffe382;";
	private final String Red = "-fx-background-color: #c63d2f;";
	private boolean colorCheck = false;
	private boolean onGoingGame = false;
	private boolean dumbAItoggle = false;
	private boolean dumbAIturn = false;
	private boolean smartAItoggle = false;
	private boolean gameSaved = false;
	
	@FXML Label redLabel = new Label();
	@FXML Label yellowLabel = new Label();
	@FXML Label redTurn = new Label();
	@FXML Label yellowTurn = new Label();
	
	@FXML private Button Reset;
	@FXML private Button Move_Log;
	@FXML private Button SmartAI;
	@FXML private Button DumbAI;
	@FXML private Button Load;
	@FXML private Button Save;
	
	@FXML Button button00 = new Button();
	@FXML Button button01 = new Button();
	@FXML Button button02 = new Button();
	@FXML Button button03 = new Button();
	@FXML Button button04 = new Button();
	@FXML Button button05 = new Button();
	ArrayList<Button> col0 = new ArrayList<>();
	private AtomicInteger col0ClickCount;
	
	@FXML Button button10 = new Button();
	@FXML Button button11 = new Button();
	@FXML Button button12 = new Button();
	@FXML Button button13 = new Button();
	@FXML Button button14 = new Button();
	@FXML Button button15 = new Button();
	ArrayList<Button> col1 = new ArrayList<>();
	private AtomicInteger col1ClickCount;
	
	@FXML Button button20 = new Button();
	@FXML Button button21 = new Button();
	@FXML Button button22 = new Button();
	@FXML Button button23 = new Button();
	@FXML Button button24 = new Button();
	@FXML Button button25 = new Button();
	ArrayList<Button> col2 = new ArrayList<>();
	private AtomicInteger col2ClickCount;
	
	@FXML Button button30 = new Button();
	@FXML Button button31 = new Button();
	@FXML Button button32 = new Button();
	@FXML Button button33 = new Button();
	@FXML Button button34 = new Button();
	@FXML Button button35 = new Button();
	ArrayList<Button> col3 = new ArrayList<>();
	private AtomicInteger col3ClickCount;
	
	@FXML Button button40 = new Button();
	@FXML Button button41 = new Button();
	@FXML Button button42 = new Button();
	@FXML Button button43 = new Button();
	@FXML Button button44 = new Button();
	@FXML Button button45 = new Button();
	ArrayList<Button> col4 = new ArrayList<>();
	private AtomicInteger col4ClickCount;
	
	@FXML Button button50 = new Button();
	@FXML Button button51 = new Button();
	@FXML Button button52 = new Button();
	@FXML Button button53 = new Button();
	@FXML Button button54 = new Button();
	@FXML Button button55 = new Button();
	ArrayList<Button> col5 = new ArrayList<>();
	private AtomicInteger col5ClickCount;
	
	@FXML Button button60 = new Button();
	@FXML Button button61 = new Button();
	@FXML Button button62 = new Button();
	@FXML Button button63 = new Button();
	@FXML Button button64 = new Button();
	@FXML Button button65 = new Button();
	ArrayList<Button> col6 = new ArrayList<>();
	private AtomicInteger col6ClickCount;
	
	ArrayList<Button> diag0 = new ArrayList<>();
	ArrayList<Button> diag1 = new ArrayList<>();
	ArrayList<Button> diag2 = new ArrayList<>();
	ArrayList<Button> diag3 = new ArrayList<>();
	ArrayList<Button> diag4 = new ArrayList<>();
	ArrayList<Button> diag5 = new ArrayList<>();
	ArrayList<Button> diag6 = new ArrayList<>();
	ArrayList<Button> diag7 = new ArrayList<>();
	ArrayList<Button> diag8 = new ArrayList<>();
	ArrayList<Button> diag9 = new ArrayList<>();
	ArrayList<Button> diag10 = new ArrayList<>();
	ArrayList<Button> diag11 = new ArrayList<>();
	
	TextArea textArea = new TextArea();
	ConsoleTextAreaOutputStream consoleStream;
	
	ArrayList<String> components = new ArrayList<> ();
	
	@FXML
	private void initialize() {
		
		textArea.setEditable(true);
		textArea.setPrefWidth(300);
		textArea.setPrefHeight(400);
		textArea.appendText("Player Column Position\n");
		consoleStream = new ConsoleTextAreaOutputStream(textArea); 
        System.setOut(new java.io.PrintStream(consoleStream, true));
		
		col0.add(button05);
		col0.add(button04);
		col0.add(button03);
		col0.add(button02);
		col0.add(button01);
		col0.add(button00);
		col0ClickCount = new AtomicInteger(0);
		
		col1.add(button15);
		col1.add(button14);
		col1.add(button13);
		col1.add(button12);
		col1.add(button11);
		col1.add(button10);
		col1ClickCount = new AtomicInteger(0);
		
		col2.add(button25);
		col2.add(button24);
		col2.add(button23);
		col2.add(button22);
		col2.add(button21);
		col2.add(button20);
		col2ClickCount = new AtomicInteger(0);
		
		col3.add(button35);
		col3.add(button34);
		col3.add(button33);
		col3.add(button32);
		col3.add(button31);
		col3.add(button30);
		col3ClickCount = new AtomicInteger(0);
		
		col4.add(button45);
		col4.add(button44);
		col4.add(button43);
		col4.add(button42);
		col4.add(button41);
		col4.add(button40);
		col4ClickCount = new AtomicInteger(0);
		
		col5.add(button55);
		col5.add(button54);
		col5.add(button53);
		col5.add(button52);
		col5.add(button51);
		col5.add(button50);
		col5ClickCount = new AtomicInteger(0);
		
		col6.add(button65);
		col6.add(button64);
		col6.add(button63);
		col6.add(button62);
		col6.add(button61);
		col6.add(button60);
		col6ClickCount = new AtomicInteger(0);
		
		board.add(col0);
		board.add(col1);
		board.add(col2);
		board.add(col3);
		board.add(col4);
		board.add(col5);
		board.add(col6);
		
		// making diagnol matrix
		diag0.add(button35);
		diag0.add(button24);
		diag0.add(button13);
		diag0.add(button02);
		
		diag1.add(button45);
		diag1.add(button34);
		diag1.add(button23);
		diag1.add(button12);
		diag1.add(button01);
		
		diag2.add(button55);
		diag2.add(button44);
		diag2.add(button33);
		diag2.add(button22);
		diag2.add(button11);
		diag2.add(button00);
		
		diag3.add(button65);
		diag3.add(button54);
		diag3.add(button43);
		diag3.add(button32);
		diag3.add(button21);
		diag3.add(button10);
		
		diag4.add(button64);
		diag4.add(button53);
		diag4.add(button42);
		diag4.add(button31);
		diag4.add(button20);
		
		diag5.add(button63);
		diag5.add(button52);
		diag5.add(button41);
		diag5.add(button30);
		
		diag6.add(button35);
		diag6.add(button44);
		diag6.add(button53);
		diag6.add(button62);
		
		diag7.add(button25);
		diag7.add(button34);
		diag7.add(button43);
		diag7.add(button52);
		diag7.add(button61);
		
		diag8.add(button15);
		diag8.add(button24);
		diag8.add(button33);
		diag8.add(button42);
		diag8.add(button51);
		diag8.add(button60);
		
		diag9.add(button05);
		diag9.add(button14);
		diag9.add(button23);
		diag9.add(button32);
		diag9.add(button41);
		diag9.add(button50);
		
		diag10.add(button04);
		diag10.add(button13);
		diag10.add(button22);
		diag10.add(button31);
		diag10.add(button40);
		
		diag11.add(button03);
		diag11.add(button12);
		diag11.add(button21);
		diag11.add(button30);
		
		diagnalSets.add(diag0);
		diagnalSets.add(diag1);
		diagnalSets.add(diag2);
		diagnalSets.add(diag3);
		diagnalSets.add(diag4);
		diagnalSets.add(diag5);
		diagnalSets.add(diag6);
		diagnalSets.add(diag7);
		diagnalSets.add(diag8);
		diagnalSets.add(diag9);
		diagnalSets.add(diag10);
		diagnalSets.add(diag11);
	}
	
	public class ConsoleTextAreaOutputStream extends OutputStream {
		private TextArea textArea;
		public ConsoleTextAreaOutputStream(TextArea textArea) {
			this.textArea = textArea;
		}
		public void write(int b) throws IOException{
			Platform.runLater(() -> textArea.appendText(String.valueOf((char) b)));
		}
		public void setTextArea(TextArea text) {
			this.textArea = text;
		}
		public TextArea getTextArea() {
			return this.textArea;
		}
	}
	
	public void setMainApplication(Main mainApplication) {
        this.mainApplication = mainApplication;
    }

    public static Integer incrementInteger(Integer num) {
        return Integer.valueOf(num.intValue() + 1);
    }
	
	private void tileClick(AtomicInteger count, int col) {
		// modify col0Click
		onGoingGame = true;
		if (count.get() <= 5) {
			for (int i = 5; i >= 0; i--) {
				//System.out.println(board.get(col).get(i).getStyle() + " bruh");
				if (!board.get(col).get(i).getStyle().equals("-fx-background-radius: 45; " + White)) {
					System.out.println("cock");
					break;
				}
				else {
					if (i == count.get()) {
						board.get(col).get(i).setStyle("-fx-background-radius: 45; " + (colorCheck ? Red : Yellow)); //c63d2f
						if (colorCheck) { // Yellow Turn
							yellowTurn.setTextFill(Color.web("#ffe382")); // yellow
							redTurn.setTextFill(Color.web("#2d728f")); // blue
						}
						else if (!colorCheck) { // Red Turn
							redTurn.setTextFill(Color.web("#c63d2f")); // red
							yellowTurn.setTextFill(Color.web("#2d728f")); // blue
						}
						colorCheck = colorCheck ? false : true;
						break;
					}
				}
				
			}
			count.incrementAndGet();
		}
		checkWin();
		if (dumbAItoggle) {
			dumbAIturn = dumbAIturn ? false : true;
		}
		if (dumbAItoggle && dumbAIturn) {
			PauseTransition delay = new PauseTransition(Duration.seconds(0.75));
			delay.setOnFinished(event -> {
				dumbAIclick();
				checkWin();
			});
			delay.play();
		}
		else if (smartAItoggle) {
			smartAIclick();
			checkWin();
		}
	}
	
	private void dumbAIclick() {
		// get random number that is possitive
		ActionEvent nullEvent = new ActionEvent(this, ActionEvent.NULL_SOURCE_TARGET);
		Random randomInt = new Random();
		int AIchoice = Math.abs(randomInt.nextInt());
		AIchoice = AIchoice % 7;
		switch(AIchoice) {
			case 0:
				col0Click(nullEvent);
				break;
			case 1:
				col1Click(nullEvent);
				break;
			case 2:
				col2Click(nullEvent);
				break;
			case 3:
				col3Click(nullEvent);
				break;
			case 4:
				col4Click(nullEvent);
				break;
			case 5:
				col5Click(nullEvent);
				break;
			case 6:
				col6Click(nullEvent);
				break;
		}
	}
	
	private void smartAIclick() {
		
	}
	
	private void freezeBoard() {
		for (int i = 0; i < board.size(); i++) { // vert check
			ArrayList<Button> row = board.get(i);
			for (int j = 0; j < row.size(); j++) {
				row.get(j).setDisable(true);
			}
		}
	}
	
	private void softReset() {
		for (int i =0; i < board.size(); i++) {
			ArrayList<Button> row = board.get(i);
			for (int j = 0; j < row.size(); j++) {
				row.get(j).setStyle("-fx-background-radius: 45; " + White);	
				//row.get(j).setDisable(false);
			}
		}
		col0ClickCount.set(0);
		col1ClickCount.set(0);
		col2ClickCount.set(0);
		col3ClickCount.set(0);
		col4ClickCount.set(0);
		col5ClickCount.set(0);
		col6ClickCount.set(0);
	}
	
	private void reset() {
		for (int i =0; i < board.size(); i++) {
			ArrayList<Button> row = board.get(i);
			for (int j = 0; j < row.size(); j++) {
				row.get(j).setStyle("-fx-background-radius: 45; " + White);	
				row.get(j).setDisable(false);
			}
		}
		col0ClickCount.set(0);
		col1ClickCount.set(0);
		col2ClickCount.set(0);
		col3ClickCount.set(0);
		col4ClickCount.set(0);
		col5ClickCount.set(0);
		col6ClickCount.set(0);
		redLabel.setTextFill(Color.web("#2d728f"));
		yellowLabel.setTextFill(Color.web("#2d728f"));
		redTurn.setTextFill(Color.web("#2d728f"));
		yellowTurn.setTextFill(Color.web("#2d728f"));
		onGoingGame = false;
		colorCheck = false;
		dumbAItoggle = false;
		dumbAIturn = false;
		yellowTurn.setText("Yellows Move");
		redTurn.setText("Reds Move");
		textArea.clear();
		textArea.appendText("Player Column Position\n");
	}
	
	
	
	private String vertCheck() {
		int redCount = 0;
		int yellowCount = 0;
//		boolean redTile = false;
//		boolean yellowTile = false;
		for (int i = 0; i < board.size(); i++) { // vert check
			ArrayList<Button> row = board.get(i);
			redCount = 0;
			yellowCount = 0;
			for (int j = 0; j < row.size(); j++) {
				if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + Red)) {
					redCount++;
					yellowCount = 0;
					if (redCount == 4) {
						return "Red";
					}
				}
				else if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + Yellow)) {
					yellowCount++;
					redCount = 0;
					if (yellowCount == 4) {
						return "Yellow";
					}
				}
				else if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + White)) {
					yellowCount = 0;
					redCount = 0;
				}
			}
			//System.out.println("Vert check: Red - " + redCount + "| Yellow - " + yellowCount);
		}
		return "";
	}

	private String horizCheck() {
		int redCount = 0;
		int yellowCount = 0;
		for (int i = 0; i < 6; i++) {
			redCount = 0;
			yellowCount = 0;
			for (int j = 0; j < 7; j++) {
				ArrayList<Button> row = board.get(j);
				if (row.get(i).getStyle().equals("-fx-background-radius: 45; " + Red)) {
					redCount++;
					yellowCount = 0;
					if (redCount == 4) {
						return "Red";
					}
				}
				else if (row.get(i).getStyle().equals("-fx-background-radius: 45; " + Yellow)) {
					yellowCount++;
					redCount = 0;
					if (yellowCount == 4) {
						return "Yellow";
					}
				}
				else if (row.get(i).getStyle().equals("-fx-background-radius: 45; " + White)) {
					yellowCount = 0;
					redCount = 0;
				}
			}
			//System.out.println("Horr check: Red - " + redCount + "| Yellow - " + yellowCount);
		}
		return "";
	}
	
	private String diagnalCheck() {
		int redCount = 0;
		int yellowCount = 0;
		for (int i = 0; i < diagnalSets.size(); i++) { // vert check
			ArrayList<Button> row = diagnalSets.get(i);
			redCount = 0;
			yellowCount = 0;
			for (int j = 0; j < row.size(); j++) {
				if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + Red)) {
					redCount++;
					yellowCount = 0;
					if (redCount == 4) {
						return "Red";
					}
				}
				else if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + Yellow)) {
					yellowCount++;
					redCount = 0;
					if (yellowCount == 4) {
						return "Yellow";
					}
				}
				else if (row.get(j).getStyle().equals("-fx-background-radius: 45; " + White)) {
					yellowCount = 0;
					redCount = 0;
				}
			}
			
		}
		//System.out.println("Diag check: Red - " + redCount + "| Yellow - " + yellowCount);
		return "";
	}
	
	private void checkWin() {
		String vert = vertCheck();
		String horiz = horizCheck();
		String diag = diagnalCheck();
		
		if (vert.equals("Red") || horiz.equals("Red") || diag.equals("Red")) {
			redLabel.setTextFill(Color.web("#c63d2f"));
			yellowTurn.setTextFill(Color.web("#2d728f"));
			freezeBoard();
			dumbAItoggle = false;
			onGoingGame = false;
		}
		else if (vert.equals("Yellow") || horiz.equals("Yellow") || diag.equals("Yellow")) {
			yellowLabel.setTextFill(Color.web("#ffe382"));
			redTurn.setTextFill(Color.web("#2d728f"));
			freezeBoard();
			dumbAItoggle = false;
			onGoingGame = false;
		}
		//return false;
	}
	
	private void saveText(TextArea text) {
		String[] componentsArr = text.getText().split("\\s+"); // using an array list, its fucked up.
		for (int i = 3;i < componentsArr.length; i++) {
			components.add(componentsArr[i]);
		}
	}
	
	private void loadSaveFile(ArrayList<String> Arr) {
		softReset();
//		System.out.println(Arr.size());
//		System.out.println(Arr.get(0));
//		System.out.println(Arr.get(1));
//		System.out.println(Arr.get(2));
		//System.out.println(board.get(0));
		for (int i = 0; i < Arr.size();) {
			int col = Integer.parseInt(Arr.get(i+1));
			int placement = Integer.parseInt(Arr.get(i+2));
			if (Arr.get(i).equals("Red")) {
				board.get(col).get(placement).setStyle("-fx-background-radius: 45; " + Red);
				//System.out.println(col + " " + placement + " is set to red");
			}
			else if (Arr.get(i).equals("Yellow")) {
				board.get(col).get(placement).setStyle("-fx-background-radius: 45; " + Yellow);
				//System.out.println(col + " " + placement + " is set to yellow");
			}
			switch (col) {
			case 0:
				col0ClickCount.set(col0ClickCount.get() + 1);
				break;
			case 1:
				col1ClickCount.set(col1ClickCount.get() + 1);
				break;
			case 2:
				col2ClickCount.set(col2ClickCount.get() + 1);
				break;
			case 3:
				col3ClickCount.set(col3ClickCount.get() + 1);
				break;
			case 4:
				col4ClickCount.set(col4ClickCount.get() + 1);
				break;
			case 5:
				col5ClickCount.set(col5ClickCount.get() + 1);
				break;
			case 6:
				col6ClickCount.set(col6ClickCount.get() + 1);
				break;
		}
			i=i+3;
		}
	}
	
	private void resetTextArea(ArrayList<String> Arr) {
		textArea.clear();
		textArea.appendText("Player Column Position\n");
		for (int i = 0; i < Arr.size();) {
			//int col = Integer.parseInt(Arr.get(i+1));
			System.out.println(Arr.get(i) + " " + Arr.get(i+1) + " " + Arr.get(i+2));
			i = i+3;
		}
	}
	
	@FXML
	private void col0Click(ActionEvent event) {
		if (col0ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 0 " + col0ClickCount);
		}
		tileClick(col0ClickCount, 0);
	}
	
	@FXML
	private void col1Click(ActionEvent event) {
		if (col1ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 1 " + col1ClickCount);
		}
		tileClick(col1ClickCount, 1);
	}

	@FXML
	private void col2Click(ActionEvent event) {
		if (col2ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 2 " + col2ClickCount);
		}
		tileClick(col2ClickCount, 2);
	}

	@FXML
	private void col3Click(ActionEvent event) {
		if (col3ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 3 " + col3ClickCount);
		}
		tileClick(col3ClickCount, 3);
	}

	@FXML
	private void col4Click(ActionEvent event) {
		if (col4ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 4 " + col4ClickCount);
		}
		tileClick(col4ClickCount, 4);
	}
	
	@FXML
	private void col5Click(ActionEvent event) {
		if (col5ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 5 " + col5ClickCount);
		}
		tileClick(col5ClickCount, 5);
	}

	@FXML
	private void col6Click(ActionEvent event) {
		if (col6ClickCount.get() >= 6) {
			mainApplication.openPopup("Warning: Column Is Full", "Please Click Another Column.");
		}
		else {
			System.out.println((colorCheck ? "Red" : "Yellow") + " 6 " + col6ClickCount);
		}
		tileClick(col6ClickCount, 6);
	}
	
	@FXML
	private void resetClick(ActionEvent event) {
		reset();
		//System.out.println("The reset button has not been implimented yet");
	}
	
	@FXML
	private void moveLogClick(ActionEvent event) {
		mainApplication.moveLogPopup(consoleStream.getTextArea());
//		System.out.println("The Move Log button has not been implimented yet");
//		System.out.println("Cock");
	}
	
	@FXML
	private void smartAIClick(ActionEvent event) {
		if (onGoingGame) {
			mainApplication.openPopup("Warning: On Going Match", "Can Not Switch To An AI opponent \n While In The Middle Of A Match! \n Click Reset First!");
			//open popup window
		}
		else {
			reset();
			//impliment pop up
			mainApplication.openPopup("Warning: No call", "Smart AI has not been implimented");
		}
	}
	
	@FXML
	private void dumbAIClick(ActionEvent event) {
		if (onGoingGame) {
			mainApplication.openPopup("Warning: On Going Match","Can Not Switch To An AI opponent \n While In The Middle Of A Match! \n Click Reset First!");
			//open popup window
		}
		else {
			mainApplication.openPopup("Dumb AI","You Are About To play Against \n A Dumb AI. Please Do Not Lose.");
			reset();
			yellowTurn.setTextFill(Color.web("#ffe382"));
			yellowTurn.setText("Your Move");
			redTurn.setText("AIs Move");
			dumbAItoggle = true;
			//dumbAIturn = true;
			//System.out.println("The Dumb AI button has not been implimented yet");
		}
	}
	
	@FXML
	private void loadClick(ActionEvent event) {
		//mainApplication.openPopup("Warning: No call", "Load has not been implimented");
		if (gameSaved) {
			mainApplication.openPopup("Loading Save File", "Most Recent Save File is being \n Loaded Into the Board");
			loadSaveFile(components);
			resetTextArea(components);
		}
		else {
			mainApplication.openPopup("Error: No Save file", "Save a game first then load.");
		}

	}
	
	@FXML
	private void saveClicked(ActionEvent event) {
		if (onGoingGame) {
			saveText(consoleStream.getTextArea());
			gameSaved = true;
			mainApplication.openPopup("Game Saved", "The Current Game's Board \n Has Been Saved");
		}
		else {
			mainApplication.openPopup("Error: Game Has Not Started", "Can not save a empty board.");
		}
	}
}

