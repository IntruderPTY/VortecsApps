package com.elemental2012.CVapp;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Formulario para la creacion de Controles de Visita v0.1


public class Creacion extends Activity{

	private int intYear, intMonth, intDay, intHour, intMinutes;
	
	private Button btnFechaInicial,btnHoraInicial,btnFechaFinal,btnHoraFinal;
	
	
	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID = 0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		
		
		setContentView(R.layout.creacion);
		
		btnFechaInicial = (Button) findViewById(R.id.btnFechaInicial);        
		btnHoraInicial = (Button) findViewById(R.id.btnHoraFinal);
		btnFechaFinal =(Button) findViewById(R.id.btnFechaFinal);
		btnHoraFinal = (Button) findViewById(R.id.btnHoraFinal);
				
		btnFechaInicial.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
			}
		});
		
		btnHoraInicial.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnFechaFinal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnHoraFinal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	    // Obtener fecha y hora corriente
		final Calendar c = Calendar.getInstance();
	    intYear = c.get(Calendar.YEAR);
	    intMonth = c.get(Calendar.MONTH);
	    intDay = c.get(Calendar.DAY_OF_MONTH);
	    intHour = c.get(Calendar.HOUR_OF_DAY);
	    intMinutes = c.get(Calendar.MINUTE);

	    
	    // Actualiza el formulario
	    updateForm();

		
	
	}
	// Actualiza el despliegue del dia y la hora en los botones
	private void updateForm() {
	    String mTimeDisplay;
		btnHoraInicial.setText(
	        new StringBuilder()
	            .append(pad(intHour)).append(":")
	            .append(pad(intMinutes)));
	}

	private static String pad(int c) {
	    if (c >= 10)
	        return String.valueOf(c);
	    else
	        return "0" + String.valueOf(c);
	}

	
	
}
