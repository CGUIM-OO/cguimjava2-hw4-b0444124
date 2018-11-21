import java.util.ArrayList;

public class Player {
	private String name;// 玩家姓名
	private int chips;// 玩家有的籌碼
	private int bet;// 玩家此局下注的籌碼
	private ArrayList<Card> oneRoundCard;// 此牌局的卡

	public Player(String name, int chips) {
		oneRoundCard = new ArrayList<Card>();
		this.name = name;
		this.chips = chips;
		// Player constructor，新增Player物件時，需要姓名、擁有的籌碼等兩個參數
	}

	public String getName() {
		return name;// name的getter
	}

	public int makeBet() {
		if (chips >= 1) {
			bet = bet;
		} else {
			bet = 0;
		}
		return bet;
		// 下注，回傳預計下注的籌碼
		// 基本下注：一次1元
		// 注意：要檢查是否還有錢，沒錢了就不能再繼續下注
	}

	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard = cards;
		// 設定此牌局所得到的卡 setter
	}

	public boolean hitMe() {
		// 是否要牌，是回傳true，不再要牌則回傳false
		// 基本參考條件：16點以下要牌，17點以上不要牌
		// 提示：用oneRoundCard來算
		int totalValue=getTotalValue();
		boolean yn;
		if(totalValue<=16) {
			yn=true;
		}
		else {
			yn=false;
		}
		return yn;
	}

	public int getTotalValue() {
		// 回傳此牌局所得的卡點數加總
		int total=0;
		for(Card t:oneRoundCard) {
			if(t.getRank()<10) {
				total+=t.getRank();
			}
			else {
				total+=10;
			}
		}
		return total;
	}

	public int getCurrentChips() {
		// 回傳玩家現有籌碼
		return chips;
	}

	public void increaseChips(int diff) {
		// 玩家籌碼變動，setter
		bet=diff;
	}

	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
		// 玩家Say Hello
	}
}
