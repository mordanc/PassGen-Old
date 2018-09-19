package com.company;
import java.security.SecureRandom;

public class Encryption
{	
	private String str = "", decrypted = "";
	private char[] charArray;
	private int[] ASCII;
	private long time = System.currentTimeMillis();
	private int key = findMiddleDigitOfKey(time);
	
	
	
	public Encryption(String string)
	{
		charArray = string.toCharArray();
		ASCII = new int[charArray.length];
	}

	
	int getKey()
	{
		return key;
	}
	
	public void decrypt(char[] charArray, int[] ASCII, int key, String decrypted)
	{
		for(int i = 0; i < ASCII.length; i++)
		{
			ASCII[i] = ASCII[i] / key;
		}

		for(int i = 0; i < ASCII.length; i++)
		{
			String temp = Character.toString((char) ASCII[i]);
			charArray[i] = temp.charAt(0);
		}

		decrypted = new String(charArray);
		System.out.println("Your decrypted string is: " + decrypted);
	}

	public int[] encrypt()
	{
		for(int i = 0; i < charArray.length; i++)
		{
			char character = charArray[i];
			ASCII[i] = (int) character;
			charArray[i] = '0';
		}

		for(int i = 0; i < ASCII.length; i++)
		{
			ASCII[i] = ASCII[i] * key;
		}

		System.out.println("Your new encrypted string is: ");
		for(int i = 0; i < ASCII.length; i++)
		{
			System.out.print(ASCII[i] + " ");
		}

		System.out.println();
		
		
		return ASCII;
	}

	public int findMiddleDigitOfKey(long time)
	{
		int x = (int) time;
		String num = Integer.toString(x);
		SecureRandom rand = new SecureRandom();
		int n = rand.nextInt(num.length());
		while(true)
		{
			if(Integer.parseInt("" + num.charAt(n)) == 0)
			{
				n = rand.nextInt(num.length());
			}
			else
			{
				break;
			}
		}

		return Integer.parseInt("" + num.charAt(n));
	}

}
