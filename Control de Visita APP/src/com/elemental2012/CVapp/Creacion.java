package com.elemental2012.CVapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

//Formulario para la creacion de Controles de Visita v0.1

public class Creacion extends Activity{

	private int intYearI, intMonthI, intDayI, intHourI, intMinutesI;
	private int intYearF, intMonthF, intDayF, intHourF, intMinutesF;
	
	private Button btnFechaInicial,btnHoraInicial,btnFechaFinal,btnHoraFinal;
		
	static final int DATE_DIALOG_ID_I = 0;
	static final int DATE_DIALOG_ID_F = 1;
	static final int TIME_DIALOG_ID_I = 2;
	static final int TIME_DIALOG_ID_F = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.creacion);
		
		btnFechaInicial = (Button) findViewById(R.id.btnFechaInicial);        
		btnHoraInicial = (Button) findViewById(R.id.btnHoraInicial);
		btnFechaFinal =(Button) findViewById(R.id.btnFechaFinal);
		btnHoraFinal = (Button) findViewById(R.id.btnHoraFinal);
				
		btnFechaInicial.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID_I);
			}
		});
		
		btnHoraInicial.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID_I);
			}
		});
		
		btnFechaFinal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID_F);
    			
			}
		});
		
		btnHoraFinal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID_F);
			}
		});
		
	    // Obtener fecha y hora corriente
		final Calendar c = Calendar.getInstance();
	    intYearI = c.get(Calendar.YEAR);
	    intMonthI = c.get(Calendar.MONTH);
	    intDayI = c.get(Calendar.DAY_OF_MONTH);
	    intHourI = c.get(Calendar.HOUR_OF_DAY);
	    intMinutesI = c.get(Calendar.MINUTE);
	    intYearF = c.get(Calendar.YEAR);
	    intMonthF = c.get(Calendar.MONTH);
	    intDayF = c.get(Calendar.DAY_OF_MONTH);
	    intHourF = c.get(Calendar.HOUR_OF_DAY);
	    intMinutesF = c.get(Calendar.MINUTE);
	    
	    // Actualiza el formulario
	    updateForm();
	
	}
	// Actualiza el despliegue del dia y la hora en los botones
	private void updateForm() {
	    btnHoraInicial.setText(
	        new StringBuilder()
	            .append(pad(intHourI)).append(":")
	            .append(pad(intMinutesI)));
	   
	    btnFechaInicial.setText(
	            new StringBuilder()
                // Mes basado en 0 asi que adiciona 1
                .append(intMonthI + 1).append("-")
                .append(intDayI).append("-")
                .append(intYearI).append(" "));

	    btnHoraFinal.setText(
		        new StringBuilder()
		            .append(pad(intHourF)).append(":")
		            .append(pad(intMinutesF)));
		   
	    btnFechaFinal.setText(
		            new StringBuilder()
	                // Mes basado en 0 asi que adiciona 1
	                .append(intMonthF + 1).append("-")
	                .append(intDayF).append("-")
	                .append(intYearF).append(" "));
	
	}

	private static String pad(int c) {
	    if (c >= 10)
	        return String.valueOf(c);
	    else
	        return "0" + String.valueOf(c);
	}

    private DatePickerDialog.OnDateSetListener InitialDateSetListener =
	            new DatePickerDialog.OnDateSetListener() {
 
	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                    intYearI = year;
	                    intMonthI = monthOfYear;
	                    intDayI = dayOfMonth;
	                    updateForm();
	                }
	            };
	    
	private TimePickerDialog.OnTimeSetListener InitialTimeSetListener =
	     new TimePickerDialog.OnTimeSetListener() {
	          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	        	  intHourI = hourOfDay;
	        	  intMinutesI = minute;
	        	  updateForm();
	          }
		};
		
		private DatePickerDialog.OnDateSetListener FinalDateSetListener =
	            new DatePickerDialog.OnDateSetListener() {
 
	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                    intYearF = year;
	                    intMonthF = monthOfYear;
	                    intDayF = dayOfMonth;
	                    updateForm();
	                }
	            };
	    
	private TimePickerDialog.OnTimeSetListener FinalTimeSetListener =
	     new TimePickerDialog.OnTimeSetListener() {
	          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	        	  intHourF = hourOfDay;
	        	  intMinutesF = minute;
	        	  updateForm();
	          }
		};
	            
    @Override
    protected Dialog onCreateDialog(int id) {
	        switch (id) {
	        case DATE_DIALOG_ID_I:
	            return new DatePickerDialog(this,
	                        InitialDateSetListener,
	                        intYearI, intMonthI, intDayI);
	        case TIME_DIALOG_ID_I:
	        	return new TimePickerDialog(this,
	        				InitialTimeSetListener,
	        				intHourI, intMinutesI, false);
	        case DATE_DIALOG_ID_F:
	            return new DatePickerDialog(this,
	                        FinalDateSetListener,
	                        intYearF, intMonthF, intDayF);
	        case TIME_DIALOG_ID_F:
	        	return new TimePickerDialog(this,
	        				FinalTimeSetListener,
	        				intHourF, intMinutesF, false);
	        }
	        return null;
	    }
	
}
