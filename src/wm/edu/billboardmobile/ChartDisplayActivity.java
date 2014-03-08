package wm.edu.billboardmobile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.android.youtube.player.YouTubeIntents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wm.edu.billboardmobile.tasks.ChartLookupTask;
import wm.edu.billboardmobile.tasks.HttpRequestTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ChartDisplayActivity extends Activity {
	
	//String result = "{\"date\":964238400000,\"type\":\"s\",\"data\":[{\"position\":1,\"artist\":\"Matchbox 20\",\"itemName\":\"Bent\"},{\"position\":2,\"artist\":\"Vertical Horizon\",\"itemName\":\"Everything You Want\"},{\"position\":3,\"artist\":\"Aaliyah\",\"itemName\":\"Try Again\"},{\"position\":4,\"artist\":\"\'n Sync\",\"itemName\":\"It\'s Gonna Be Me\"},{\"position\":5,\"artist\":\"Joe\",\"itemName\":\"I Wanna Know\"},{\"position\":6,\"artist\":\"Nine Days\",\"itemName\":\"Absolutely\"},{\"position\":7,\"artist\":\"Creed\",\"itemName\":\"Higher\"},{\"position\":8,\"artist\":\"Pink\",\"itemName\":\"There You Go\"},{\"position\":9,\"artist\":\"Eminem\",\"itemName\":\"The Real Slim Shady\"},{\"position\":10,\"artist\":\"Christina Aguilera\",\"itemName\":\"I Turn To You\"},{\"position\":11,\"artist\":\"Enrique Iglesias\",\"itemName\":\"Be With You\"},{\"position\":12,\"artist\":\"Toni Braxton\",\"itemName\":\"He Wasn\'t Man Enough\"},{\"position\":13,\"artist\":\"Destiny\'s Child\",\"itemName\":\"Jumpin\', Jumpin\'\"},{\"position\":14,\"artist\":\"Faith Hill\",\"itemName\":\"Breathe\"},{\"position\":15,\"artist\":\"Jagged Edge\",\"itemName\":\"Let\'s Get Married\"},{\"position\":16,\"artist\":\"Marc Anthony\",\"itemName\":\"You Sang To Me\"},{\"position\":17,\"artist\":\"Ruff Endz\",\"itemName\":\"No More\"},{\"position\":18,\"artist\":\"Bb Mak\",\"itemName\":\"Back Here\"},{\"position\":19,\"artist\":\"Sting Featuring Cheb Mami\",\"itemName\":\"Desert Rose\"},{\"position\":20,\"artist\":\"Jay-z Featuring Ugk\",\"itemName\":\"Big Pimpin\'\"},{\"position\":21,\"artist\":\"Macy Gray\",\"itemName\":\"I Try\"},{\"position\":22,\"artist\":\"Janet Jackson\",\"itemName\":\"Doesn\'t Really Matter\"},{\"position\":23,\"artist\":\"Nelly\",\"itemName\":\"(Hot S**t) Country Grammar\"},{\"position\":24,\"artist\":\"Britney Spears\",\"itemName\":\"Oops! ... I Did It Again\"},{\"position\":25,\"artist\":\"Next\",\"itemName\":\"Wifey\"},{\"position\":26,\"artist\":\"Dr. Dre Featuring Snoop Dogg\",\"itemName\":\"The Next Episode\"},{\"position\":27,\"artist\":\"Avant\",\"itemName\":\"Separated\"},{\"position\":28,\"artist\":\"3 Doors Down\",\"itemName\":\"Kryptonite\"},{\"position\":29,\"artist\":\"Jessica Simpson\",\"itemName\":\"I Think I\'m In Love With You\"},{\"position\":30,\"artist\":\"Westlife\",\"itemName\":\"Swear It Again\"},{\"position\":31,\"artist\":\"Sisqo\",\"itemName\":\"Thong Song\"},{\"position\":32,\"artist\":\"Son By Four\",\"itemName\":\"Purest Of Pain (A Puro Dolor)\"},{\"position\":33,\"artist\":\"Da Brat Featuring Tyrese\",\"itemName\":\"What\'Chu Like\"},{\"position\":34,\"artist\":\"Donell Jones\",\"itemName\":\"Where I Wanna Be\"},{\"position\":35,\"artist\":\"Lee Ann Womack With Sons Of The Desert\",\"itemName\":\"I Hope You Dance\"},{\"position\":36,\"artist\":\"Santana Featuring The Product G&b\",\"itemName\":\"Maria Maria\"},{\"position\":37,\"artist\":\"Lonestar\",\"itemName\":\"Amazed\"},{\"position\":38,\"artist\":\"No Doubt\",\"itemName\":\"Simple Kind Of Life\"},{\"position\":39,\"artist\":\"Chad Brock\",\"itemName\":\"Yes!\"},{\"position\":40,\"artist\":\"Lucy Pearl\",\"itemName\":\"Dance Tonight\"},{\"position\":41,\"artist\":\"Santana Featuring Rob Thomas\",\"itemName\":\"Smooth\"},{\"position\":42,\"artist\":\"Mandy Moore\",\"itemName\":\"I Wanna Be With You\"},{\"position\":43,\"artist\":\"Destiny\'s Child\",\"itemName\":\"Say My Name\"},{\"position\":44,\"artist\":\"Carl Thomas\",\"itemName\":\"I Wish\"},{\"position\":45,\"artist\":\"Lara Fabian\",\"itemName\":\"I Will Love Again\"},{\"position\":46,\"artist\":\"Rascal Flatts\",\"itemName\":\"Prayin\' For Daylight\"},{\"position\":47,\"artist\":\"Lonestar\",\"itemName\":\"What About Now\"},{\"position\":48,\"artist\":\"Goo Goo Dolls\",\"itemName\":\"Broadway\"},{\"position\":49,\"artist\":\"Savage Garden\",\"itemName\":\"Crash And Burn\"},{\"position\":50,\"artist\":\"Jo Dee Messina\",\"itemName\":\"That\'s The Way\"},{\"position\":51,\"artist\":\"Leann Rimes\",\"itemName\":\"I Need You\"},{\"position\":52,\"artist\":\"Reba Mcentire\",\"itemName\":\"I\'ll Be\"},{\"position\":53,\"artist\":\"Everclear\",\"itemName\":\"Wonderful\"},{\"position\":54,\"artist\":\"Ideal Featuring Lil\' Mo\",\"itemName\":\"Whatever\"},{\"position\":55,\"artist\":\"Backstreet Boys\",\"itemName\":\"The One\"},{\"position\":56,\"artist\":\"Billy Gilman\",\"itemName\":\"One Voice\"},{\"position\":57,\"artist\":\"Alan Jackson\",\"itemName\":\"It Must Be Love\"},{\"position\":58,\"artist\":\"Tim Mcgraw\",\"itemName\":\"Some Things Never Change\"},{\"position\":59,\"artist\":\"Enrique Iglesias & Whitney Houston\",\"itemName\":\"Could I Have This Kiss Forever\"},{\"position\":60,\"artist\":\"Eric Heatherley\",\"itemName\":\"Flowers On The Wall\"},{\"position\":61,\"artist\":\"Sisqo\",\"itemName\":\"Incomplete\"},{\"position\":62,\"artist\":\"Clay Davidson\",\"itemName\":\"Unconditional\"},{\"position\":63,\"artist\":\"Alice Deejay\",\"itemName\":\"Better Off Alone\"},{\"position\":64,\"artist\":\"Faith Hill\",\"itemName\":\"The Way You Love Me\"},{\"position\":65,\"artist\":\"Splender\",\"itemName\":\"I Think God Can Explain\"},{\"position\":66,\"artist\":\"Don Henley\",\"itemName\":\"Taking You Home\"},{\"position\":67,\"artist\":\"Sister Hazel\",\"itemName\":\"Change Your Mind\"},{\"position\":68,\"artist\":\"Dixie Chicks\",\"itemName\":\"Cold Day In July\"},{\"position\":69,\"artist\":\"Kelly Price\",\"itemName\":\"As We Lay\"},{\"position\":70,\"artist\":\"Creed\",\"itemName\":\"With Arms Open Wide\"},{\"position\":71,\"artist\":\"Clay Walker\",\"itemName\":\"The Chain Of Love\"},{\"position\":72,\"artist\":\"Lil\' Kim\",\"itemName\":\"No Matter What They Say\"},{\"position\":73,\"artist\":\"Collin Raye\",\"itemName\":\"Couldn\'t Last A Moment\"},{\"position\":74,\"artist\":\"Shedaisy\",\"itemName\":\"I Will ... But\"},{\"position\":75,\"artist\":\"Whitney Houston & Deborah Cox\",\"itemName\":\"Same Script Different Cast\"},{\"position\":76,\"artist\":\"Mary Mary\",\"itemName\":\"Shackles (Praise You)\"},{\"position\":77,\"artist\":\"Mariah Carey Featuring Snoop Dogg\",\"itemName\":\"Crybaby\"},{\"position\":78,\"artist\":\"504 Boyz\",\"itemName\":\"Wobble Wobble\"},{\"position\":79,\"artist\":\"Stone Temple Pilots\",\"itemName\":\"Sour Girl\"},{\"position\":80,\"artist\":\"Keith Urban\",\"itemName\":\"You\'re Everything\"},{\"position\":81,\"artist\":\"Souldecision Featuring Thrust\",\"itemName\":\"Faded\"},{\"position\":82,\"artist\":\"Brooks & Dunn\",\"itemName\":\"You\'ll Always Be Loved By Me\"},{\"position\":83,\"artist\":\"Metallica\",\"itemName\":\"I Disappear\"},{\"position\":84,\"artist\":\"Darryl Worley\",\"itemName\":\"When You Need My Love\"},{\"position\":85,\"artist\":\"Andy Griggs\",\"itemName\":\"She\'s More\"},{\"position\":86,\"artist\":\"Mya Featuring Jadakiss\",\"itemName\":\"Best Of Me\"},{\"position\":87,\"artist\":\"Dmx\",\"itemName\":\"What You Want\"},{\"position\":88,\"artist\":\"Eve & Jadakiss\",\"itemName\":\"Got It All\"},{\"position\":89,\"artist\":\"Torrey Carter\",\"itemName\":\"Take That\"},{\"position\":90,\"artist\":\"M2m\",\"itemName\":\"Mirror Mirror\"},{\"position\":91,\"artist\":\"Kenny Rogers / Alison Krauss / Billy Dean\",\"itemName\":\"Buy Me A Rose\"},{\"position\":92,\"artist\":\"Trick Daddy\",\"itemName\":\"Shut Up\"},{\"position\":93,\"artist\":\"Madison Avenue\",\"itemName\":\"Don\'t Call Me Baby\"},{\"position\":94,\"artist\":\"Elton John\",\"itemName\":\"Someday Out Of The Blue\"},{\"position\":95,\"artist\":\"Kenny Chesney\",\"itemName\":\"What I Need To Do\"},{\"position\":96,\"artist\":\"A*teens\",\"itemName\":\"Dancing Queen\"},{\"position\":97,\"artist\":\"Nu Flavour\",\"itemName\":\"3 Little Words\"},{\"position\":98,\"artist\":\"Big Punisher\",\"itemName\":\"It\'s So Hard\"},{\"position\":99,\"artist\":\"Baha Men\",\"itemName\":\"Who Let The Dogs Out\"},{\"position\":100,\"artist\":\"Phil Vasser\",\"itemName\":\"Carlene\"}]}";
	private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
	LinearLayout chart;
	TextView chartDateView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart_display);
		Intent intent = getIntent();
		
		chart = (LinearLayout)findViewById(R.id.chart);
		chartDateView = (TextView)findViewById(R.id.chartDateLabel);

		int type = intent.getIntExtra("chartType", 0);
		int day = intent.getIntExtra("day", 0);
		int month = intent.getIntExtra("month", 0);
		int year = intent.getIntExtra("year", 0);
		loadChart(type, day, month, year);

	}
	
	public void loadChart (int type, int day, int month, int year) {
		
		chart.removeAllViews();
		TextView chartTypeView = (TextView)findViewById(R.id.chartTypeLabel);
				
		ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
		ImageView forwardArrow = (ImageView)findViewById(R.id.forwardArrow);
		backArrow.setClickable(true);
		forwardArrow.setClickable(true);

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		
		Calendar albumsStartDate = Calendar.getInstance();
		albumsStartDate.set(1970, 11, 26);
		
		if (type == DateSearchActivity.ALBUMS_CHART && cal.before(albumsStartDate))
			cal = albumsStartDate;
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int delta;
		
		if (dayOfWeek > 3)
			delta = 7 - dayOfWeek;
		else
			delta = -dayOfWeek;
		
		cal.add(Calendar.DATE, delta);
		
		Date chartDate = cal.getTime();
		DateFormat df = new SimpleDateFormat("MMMMM d, yyyy");
		chartDateView.setText(df.format(chartDate));
		
		cal.add(Calendar.DATE, 7);
		forwardArrow.setOnClickListener(new ArrowClickListener(type, cal.get(Calendar.DATE), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR)));
		cal.add(Calendar.DATE, -14);
		backArrow.setOnClickListener(new ArrowClickListener(type, cal.get(Calendar.DATE), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR)));
		cal.add(Calendar.DATE, 7);
		
		if (type == DateSearchActivity.SINGLES_CHART) {
			
			chartTypeView.setText("Billboard Hot 100");
			DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
			ChartLookupTask task = new ChartLookupTask(this, "Getting chart...");
			task.execute(dfURL.format(cal.getTime()), "s");
			
			/*
			
			try {
				
				DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
				HttpRequestTask singlesChartTask = new HttpRequestTask(this, "Fetching chart...");
				String result = singlesChartTask.execute("http://billboard-jpblair.herokuapp.com/chart", "GET", "date", dfURL.format(cal.getTime()), "type", "s").get();
				displayChart(result);
				
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
			
		}
		else if (type == DateSearchActivity.ALBUMS_CHART) {
			
			chartTypeView.setText("Billboard 200");
			DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
			ChartLookupTask task = new ChartLookupTask(this, "Getting chart...");
			task.execute(dfURL.format(cal.getTime()), "a");
			
			/*
			
			try {
				
				DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
				HttpRequestTask singlesChartTask = new HttpRequestTask(this, "Fetching chart...");
				String result = singlesChartTask.execute("http://billboard-jpblair.herokuapp.com/chart", "GET", "date", dfURL.format(cal.getTime()), "type", "a").get();
				displayChart(result);
				
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
			
		}
	}
		
	public void displayChart (String result)  {
		
		try  {
			
			JSONObject j = new JSONObject(result);
			JSONArray JSONchart = new JSONArray(j.getString("data"));
			for (int i = 0; i < JSONchart.length(); i++) {
				JSONObject entry = JSONchart.getJSONObject(i);
				int position = entry.getInt("position");
				String artist = entry.getString("artist");
				String song = entry.getString("itemName");
				
				RelativeLayout entryLayout = new RelativeLayout(this);
				LinearLayout.LayoutParams lpEntry = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				lpEntry.setMargins(0, 10, 0, 10);
				
				TextView positionLabel = new TextView(this);
				positionLabel.setText("" + position);
				positionLabel.setId(generateViewId());
				positionLabel.setTextSize(20);
				RelativeLayout.LayoutParams lpPosition = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				lpPosition.addRule(RelativeLayout.CENTER_VERTICAL);
				lpPosition.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				lpPosition.setMargins(0, 0, 20, 0);
				
				ImageView youTubeIcon = new ImageView(this);
				youTubeIcon.setId(generateViewId());
				youTubeIcon.setImageResource(R.drawable.youtube);
				youTubeIcon.setScaleType(ScaleType.FIT_CENTER);
				youTubeIcon.setClickable(true);
				youTubeIcon.setOnClickListener(new YouTubeClickListener(artist, song));
				
				Display display = getWindowManager().getDefaultDisplay();
				int width = display.getWidth();
				int height = display.getHeight();
				int iconWidth = (int)(width * 0.10);
				int iconHeight = (int)(height * 0.07);
				
				RelativeLayout.LayoutParams lpYouTube = new RelativeLayout.LayoutParams(iconWidth, iconHeight);
				lpYouTube.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				lpYouTube.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				lpYouTube.setMargins(0, 0, 10, 0);
				
				TextView artistLabel = new TextView(this);
				artistLabel.setText(artist);
				artistLabel.setId(generateViewId());
				artistLabel.setTextSize(15);
				RelativeLayout.LayoutParams lpArtist = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				lpArtist.addRule(RelativeLayout.ALIGN_PARENT_TOP);
				lpArtist.addRule(RelativeLayout.RIGHT_OF, positionLabel.getId());
				lpArtist.addRule(RelativeLayout.LEFT_OF, youTubeIcon.getId());
				
				TextView songLabel = new TextView(this);
				songLabel.setText(song);
				songLabel.setTextSize(15);
				RelativeLayout.LayoutParams lpSong = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				lpSong.addRule(RelativeLayout.BELOW, artistLabel.getId());
				lpSong.addRule(RelativeLayout.RIGHT_OF, positionLabel.getId());
				lpSong.addRule(RelativeLayout.LEFT_OF, youTubeIcon.getId());
									
				entryLayout.addView(positionLabel, lpPosition);
				entryLayout.addView(youTubeIcon, lpYouTube);
				entryLayout.addView(artistLabel, lpArtist);
				entryLayout.addView(songLabel, lpSong);
	
				entryLayout.setBackgroundResource(R.drawable.rectangle_background);
				
				chart.addView(entryLayout, lpEntry);
				
			}
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static int generateViewId() {
	    for (;;) {
	        final int result = sNextGeneratedId.get();
	        // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
	        int newValue = result + 1;
	        if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
	        if (sNextGeneratedId.compareAndSet(result, newValue)) {
	            return result;
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chart_display, menu);
		return true;
	}
	
	public class YouTubeClickListener implements View.OnClickListener {
		
		String artist;
		String song;
		
		public YouTubeClickListener(String artist, String song) {
			this.artist=artist;
			this.song=song;
		}

		@Override
		public void onClick(View v) {
			
	        Intent intent = YouTubeIntents.createSearchIntent(ChartDisplayActivity.this, artist + " " + song);
	        startActivity(intent);
			
		}
		
	}
	
	public class ArrowClickListener implements View.OnClickListener {
		
		int chartType, day, month, year;
		
		public ArrowClickListener(int chartType, int day, int month, int year) {
			this.chartType=chartType;
			this.day=day;
			this.month=month;
			this.year=year;
		}

		@Override
		public void onClick(View v) {
			
			System.out.println("chartType: " + chartType + " day: " + day + " month: " + month + " year: " + year);
	        ChartDisplayActivity.this.loadChart(chartType, day, month, year);
			
		}
		
	}

}

