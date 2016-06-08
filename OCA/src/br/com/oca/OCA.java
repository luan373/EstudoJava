package br.com.oca;

public class OCA {
	public static void main(String[] args) throws InterruptedException {

		int x = 5;
		System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);
		
		boolean c = false;
		if (c = true){
			System.out.println(c);
		}

		/*
		 * for (int a = 0; a <= 4; a++) { for (char x = 'a'; x <= 'c'; x++) {
		 * if(a== 2 || x =='b') continue; System.out.println(" " + a + x); } }
		 */
	}

	int roomInBelly = 5;

	public void eatCheese(int bitesOfCheese) {
		while (bitesOfCheese > 0 && roomInBelly > 0) {
			bitesOfCheese--;
			roomInBelly--;
		}
		System.out.println(bitesOfCheese + " pieces of cheese left");
	}

}
