package adminportalTests;

import org.junit.Test;

public class Soft {
	
	@Test
	public void Cycle1(){
		
	System.out.println("Cycle1" );
	
	int y = 1;
	
	int k;
	
	for(k = 6; k >= 3; k--) // k = 6, k = 5, k = 4, k = 3;

	y = y + k;  // k = 6 + 1 = 7; y =7; k = 5 + 7 = 12; k = 4 + 12 = 16; y = 3 + 16 = 19;
	
	System.out.println("y = " + y); //y = 19;
	
	System.out.println("k = " + k); //k = 2;

	}
	@Test
	public void Cycle2(){
		
		System.out.println("Cycle2" );
	
		int y = 6;
		
		int k;
		
		for(k = 1; k <= 6; k++)

		y = y + k; // y = (6+0)*10 + (6+1)*10 + (6+2)*10 + (6+3)*10 + (6+4)*10 + (6+5)*10 = 
		
		y = y * 10;
		
		System.out.println("y = " + y);
		
		System.out.println("k = " + k);
	}
	
	@Test
	public void Cycle3(){
		
		System.out.println("Cycle3" );
		
		int y = 2;
		int k;
		for(k = 7; k <= 2; k++)
		y = y + k;
		System.out.println("y = " + y);
		System.out.println("k = " + k);

	}
	
	@Test
	public void Cycle4(){
		
		System.out.println("Cycle4" );
	
		int y = 0;
		int k = 4;
		while (k > 1 ){
		y = y + 1 / k;
		k = k - 1;
		}
		System.out.println("y = " + y);
		System.out.println("k = " + k);


	}
	
	@Test
	public void Cycle5(){
		
		System.out.println("Cycle5" );
	
		int y = 0;
		int k = 3;
		do {
		k = k * 2;
		y = y + k;
		}
		while (k <7);
		System.out.println("y = " + y);
		System.out.println("k = " + k);

	}

}
