package wm.edu.billboardmobile;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ReverseLookupActivity extends Activity {
	
	public static int SONG_SEARCH = 0;
	public static int ALBUM_SEARCH = 1;
	public static int ARTIST_SEARCH = 2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reverse_lookup);
		
		Button searchButton = (Button)findViewById(R.id.reverseLookup_searchButton);
		searchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("Button click");
				String artist = ((EditText)findViewById(R.id.artistEditText)).getText().toString();
				String item = ((EditText)findViewById(R.id.searchEditText)).getText().toString();
				Spinner s = (Spinner)findViewById(R.id.searchSpinner);
				String searchType = s.getSelectedItem().toString();
				int type;
				
				if (item.equals(""))
					type = ARTIST_SEARCH;
				else if (searchType.equals("Song"))
					type = SONG_SEARCH;
				else if (searchType.equals("Album"))
					type = ALBUM_SEARCH;
				else
					return;
				
				Intent i = new Intent(getApplicationContext(), SearchResultsActivity.class);
				i.putExtra("Artist", artist);
				i.putExtra("Search Type", type);
				i.putExtra("Item", item);
				startActivity(i);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reverse_lookup, menu);
		return true;
	}

}
