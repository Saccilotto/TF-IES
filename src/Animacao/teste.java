package Animacao;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//classe teste para transformacao de arquivos em imagens

public class teste {
	
	public static void main(String[] args) {
                
        File dir = new File("C:\\Users\\Andre\\Desktop\\TF-IES\\src\\Animacao\\icones");	      
	    String[] arquivos = dir.list();
	    
	    ArrayList<Image> iconImages = new ArrayList<Image>();
	    Image aux;
	    for(int i=0;i< arquivos.length;i++) {
	    	//aux = getImage(arquivos[i]);
	    	//iconImages.add(aux);
	    }
	      
	    
    	
	    
      
	}
}
