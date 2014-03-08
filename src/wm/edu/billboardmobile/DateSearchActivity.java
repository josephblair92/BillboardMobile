package wm.edu.billboardmobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;

public class DateSearchActivity extends Activity {
	
	public static int SINGLES_CHART = 0;
	public static int ALBUMS_CHART = 1;
	DatePicker dp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_search);
		
		Button searchButton = (Button)findViewById(R.id.dateSearch_searchButton);
		dp = (DatePicker)findViewById(R.id.datePicker);
		dp.init(2013, 12, 14, null);
		
		searchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				int day = dp.getDayOfMonth();
				int month = dp.getMonth();
				int year = dp.getYear();
				
				RadioGroup rg = (RadioGroup)findViewById(R.id.chartRadioGroup);
				int id = rg.getCheckedRadioButtonId();
				int chart;
				
				if (id == R.id.singlesRadio)
					chart = SINGLES_CHART;
				else if (id == R.id.albumsRadio)
					chart = ALBUMS_CHART;
				else
					return;
					
				Intent i = new Intent(getApplicationContext(), ChartDisplayActivity.class);
				i.putExtra("chartType", chart);
				i.putExtra("day", day);
				i.putExtra("month", month);
				i.putExtra("year", year);
				startActivity(i);				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.date_search, menu);
		return true;
	}

}
