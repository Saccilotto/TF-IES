package Animacao;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//classe teste para transformacao de arquivos em imagens

public class teste {
	private void metodoInput(){
		InputStream input = getClass().getResourceAsStream("\\icones\\");
		  
		final String dir = input.getClass().getSimpleName();
	    System.out.println(dir);
	}
	
	teste(){
		
		metodoInput();
		
    	
	    
      
	}
	
}
