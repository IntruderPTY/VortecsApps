package com.elemental2012.CVapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity {
    /** Called when the activity is first created. */
    private String strOpciones[] = {"Creación","Edición","Borrado", "Sincronización"};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
    
        setListAdapter(new ArrayAdapter<String>(MainMenu.this, android.R.layout.simple_list_item_1, strOpciones));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String strOpcion="Nada";
		
	switch (position){
	case 0:
		strOpcion = "Creacion";
		break;
	case 1:
		strOpcion = "edicion";
		break;
	case 2:
		strOpcion = "borrado";
		break;
	case 3:
		strOpcion = "sincro";
		break;
	default:
		strOpcion = "Nada";
		break;
	}
	
	System.out.println(position);
	System.out.println("com.elemental2012.CVapp." + strOpcion);
	
	if (strOpcion != "Nada"){
	try{
	Class clsOpcion = Class.forName("com.elemental2012.CVapp." + strOpcion);
	Intent OpcionIntent = new Intent(MainMenu.this, clsOpcion);
	startActivity(OpcionIntent);
	}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	
	}
	}
}