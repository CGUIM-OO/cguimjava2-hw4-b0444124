import java.util.ArrayList;

public class Player {
	private String name;// ���a�m�W
	private int chips;// ���a�����w�X
	private int bet;// ���a�����U�`���w�X
	private ArrayList<Card> oneRoundCard;// ���P�����d

	public Player(String name, int chips) {
		oneRoundCard = new ArrayList<Card>();
		this.name = name;
		this.chips = chips;
		// Player constructor�A�s�WPlayer����ɡA�ݭn�m�W�B�֦����w�X����ӰѼ�
	}

	public String getName() {
		return name;// name��getter
	}

	public int makeBet() {
		if (chips >= 1) {
			bet = bet;
		} else {
			bet = 0;
		}
		return bet;
		// �U�`�A�^�ǹw�p�U�`���w�X
		// �򥻤U�`�G�@��1��
		// �`�N�G�n�ˬd�O�_�٦����A�S���F�N����A�~��U�`
	}

	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard = cards;
		// �]�w���P���ұo�쪺�d setter
	}

	public boolean hitMe() {
		// �O�_�n�P�A�O�^��true�A���A�n�P�h�^��false
		// �򥻰Ѧұ���G16�I�H�U�n�P�A17�I�H�W���n�P
		// ���ܡG��oneRoundCard�Ӻ�
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
		// �^�Ǧ��P���ұo���d�I�ƥ[�`
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
		// �^�Ǫ��a�{���w�X
		return chips;
	}

	public void increaseChips(int diff) {
		// ���a�w�X�ܰʡAsetter
		bet=diff;
	}

	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
		// ���aSay Hello
	}
}
