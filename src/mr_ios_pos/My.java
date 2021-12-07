package mr_ios_pos;

import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.time.*;
import java.io.*;
import java.util.*;

public class My {

	
		static Scanner key= new Scanner(System.in);
		Random rand = new Random();
		
		public static long getID(String str) {
			long id = 0;
			char index[] = str.toLowerCase().toCharArray();
			for(int i = 0; i < str.length(); i++) {
				
				switch(index[i]) {
					case'q': id+=1; break;
					case'w': id+=2; break;
					case'e': id+=3; break;
					case'r': id+=4; break;
					case't': id+=5; break;
					case'y': id+=6; break;
					case'u': id+=7; break;
					case'i': id+=8; break;
					case'o': id+=9; break;
					case'p': id+=10; break;
					case'a': id+=11; break;
					case's': id+=12; break;
					case'd': id+=13; break;
					case'f': id+=14; break;
					case'g': id+=15; break;
					case'h': id+=16; break;
					case'j': id+=17; break;
					case'k': id+=18; break;
					case'l': id+=19; break;
					case'z': id+=20; break;
					case'x': id+=21; break;
					case'c': id+=22; break;
					case'v': id+=23; break;
					case'b': id+=24; break;
					case'n': id+=25; break;
					case'm': id+=26; break;
					case'(': id+=27; break;
					case')': id+=28; break;
					case'-': id+=29; break;
					case'+': id+=30; break;
					case'1': id+=31; break;
					case'2': id+=32; break;
					case'3': id+=33; break;
					case'4': id+=34; break;
					case'5': id+=35; break;
					case'6': id+=36; break;
					case'7': id+=37; break;
					case'8': id+=38; break;
					case'9': id+=39; break;
					case'0': id+=40; break;
					case'&': id+=41; break;
					case'/': id+=42; break;
					case' ': id+=43; break;

				}
			}
			
			return id;
		}

		public static void p(String s){
			System.out.print(s);
		}
		
		public static void c() {
			System.exit(0);
		}
		
		public static int randI (int min, int max) {
			int i;
			Random rand = new Random();
			i = min + rand.nextInt(max);
			return i;
		}
		
		
		public static int getOpt(int min, int max){
			int opt=0;
			while(opt<min || opt>max){
				opt= key.nextInt();
				if(opt<min || opt >max )
				{	p("\n\t Must be between" + min + " - "+ max);
					p("\n\t\t\tPlease reenter");
				}
			}
			return opt;
		}
		
		public static char getYN(){
			String s;
			char ch;
			
			do{
			p("\n\t\t\tEnter Y/N   or y/n:  ");
			s= key.next();
			ch= s.toUpperCase().charAt(0);
			}while(ch!='Y' && ch!='N' );
			
			return ch;
		}
		
		public static void pressKey(){
			String s;
			p("\n\t\t\tPress any key to continue  :");
			s= key.next();
						
			}
		
}

