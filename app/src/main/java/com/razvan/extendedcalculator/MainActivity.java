package com.razvan.extendedcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static String s = new String();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// The parser
		final ExpressionParser calculator = new ExpressionParser();
		
		// Create textView
		final TextView t = (TextView)findViewById(R.id.textView1); 

		
		// Create buttons
		Button sinBtn = (Button)findViewById(R.id.btn_sin);	    
	    sinBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" sin ( ");
						t.append("sin(");
	                }
	            });
	    
	    Button cosBtn = (Button)findViewById(R.id.btn_cos);	    
	    cosBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" cos ( ");
						t.append("cos(");
	                }
	            });
	    
	    Button delBtn = (Button)findViewById(R.id.btn_del);	    
	    delBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						//t.setText(s);
	                }
	            });
	    
	    Button acBtn = (Button)findViewById(R.id.btn_ac);	    
	    acBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = new String();
						t.setText("");
	                }
	            });
	    
	    Button lnBtn = (Button)findViewById(R.id.btn_ln);	    
	    lnBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" ln ( ");
						t.append("ln(");
	                }
	            });
	    
	    Button logBtn = (Button)findViewById(R.id.btn_log);	    
	    logBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" log ( ");
						t.append("log(");
	                }
	            });
	    
	    Button sqrtBtn = (Button)findViewById(R.id.btn_sqrt);	    
	    sqrtBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" sqrt ( ");
						t.append("sqrt(");
	                }
	            });
	    
	    Button expBtn = (Button)findViewById(R.id.btn_exp);	    
	    expBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" ^ ");
						t.append("^");
	                }
	            });
	    
	    Button n7Btn = (Button)findViewById(R.id.btn_7);	    
	    n7Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("7");
						t.append("7");
	                }
	            });
	    
	    Button n8Btn = (Button)findViewById(R.id.btn_8);	    
	    n8Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("8");
						t.append("8");
	                }
	            });
	    
	    Button n9Btn = (Button)findViewById(R.id.btn_9);	    
	    n9Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("9");
						t.append("9");
	                }
	            });
	    
	    Button openbrBtn = (Button)findViewById(R.id.btn_openbr);	    
	    openbrBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" ( ");
						t.append("(");
	                }
	            });
	    
	    Button closebrBtn = (Button)findViewById(R.id.btn_closebr);	    
	    closebrBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" ) ");
						t.append(")");
	                }
	            });
	    
	    Button n4Btn = (Button)findViewById(R.id.btn_4);	    
	    n4Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("4");
						t.append("4");
	                }
	            });
	    
	    Button n5Btn = (Button)findViewById(R.id.btn_5);	    
	    n5Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("5");
						t.append("5");
	                }
	            });
	    
	    Button n6Btn = (Button)findViewById(R.id.btn_6);	    
	    n6Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("6");
						t.append("6");
	                }
	            });
	    
	    Button mulBtn = (Button)findViewById(R.id.btn_mul);	    
	    mulBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" * ");
						t.append("*");
	                }
	            });
	    
	    Button divBtn = (Button)findViewById(R.id.btn_div);	    
	    divBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" / ");
						t.append("/");
	                }
	            });
	    
	    Button n1Btn = (Button)findViewById(R.id.btn_1);	    
	    n1Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("1");
						t.append("1");
	                }
	            });
	    
	    Button n2Btn = (Button)findViewById(R.id.btn_2);	    
	    n2Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("2");
						t.append("2");
	                }
	            });
	    
	    Button n3Btn = (Button)findViewById(R.id.btn_3);	    
	    n3Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("3");
						t.append("3");
	                }
	            });
	    
	    Button plusBtn = (Button)findViewById(R.id.btn_plus);	    
	    plusBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" + ");
						t.append("+");
	                }
	            });
	    
	    Button minusBtn = (Button)findViewById(R.id.btn_minus);	    
	    minusBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" - ");
						t.append("-");
	                }
	            });
	    
	    Button dotBtn = (Button)findViewById(R.id.btn_dot);	    
	    dotBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(".");
						t.append(".");
	                }
	            });
	    
	    Button n0Btn = (Button)findViewById(R.id.btn_0);	    
	    n0Btn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat("0");
						t.append("0");
	                }
	            });
	    
	    Button piBtn = (Button)findViewById(R.id.btn_pi);	    
	    piBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" 3.14159");
						t.append("π");
	                }
	            });
	    
	    Button eBtn = (Button)findViewById(R.id.btn_e);	    
	    eBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						s = s.concat(" 2.71828");
						t.append("e");
	                }
	            });
	    
	    Button equBtn = (Button)findViewById(R.id.btn_equ);	    
	    equBtn.setOnClickListener(
				new View.OnClickListener()
				{
					public void onClick(View view)
					{
						try {
							float f;
							f = calculator.eval(s);
							s = new String( Math.round(f*10000.0)/10000.0  + "");
							t.setText(s);
						} catch (Exception e) {
							s = new String();
							t.setText("ERR");
						}
						
	                }
	            });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
