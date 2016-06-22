package br.com.oca;

public class OCA {
	public static void main(String[] args) throws InterruptedException {
		String[] strings = { "stringValue" };
		Object[] objects = strings;
		String[] againStrings = (String[]) objects;
		//againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
		
		StringBuilder builder = new StringBuilder("oi");
		objects[0] = builder;

		System.out.println(objects[0]);

	}
}
