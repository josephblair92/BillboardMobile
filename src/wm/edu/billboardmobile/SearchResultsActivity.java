package wm.edu.billboardmobile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wm.edu.billboardmobile.tasks.HttpRequestTask;
import wm.edu.billboardmobile.tasks.ReverseAlbumLookupTask;
import wm.edu.billboardmobile.tasks.ReverseArtistLookupTask;
import wm.edu.billboardmobile.tasks.ReverseSongLookupTask;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

























import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;

public class SearchResultsActivity extends Activity {
	
	private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
	
	String response = "[{\"itemName\":\"A Trick Of The Tail\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":30,\"date\":200380863102}]},{\"itemName\":\"Wind And Wuthering\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":30,\"date\":225181263102},{\"position\":27,\"date\":225786063102},{\"position\":25,\"date\":226390863102},{\"position\":24,\"date\":226995663102},{\"position\":24,\"date\":227600463102},{\"position\":23,\"date\":228205263102}]},{\"itemName\":\"Your Own Special Way\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":85,\"date\":226995663102},{\"position\":74,\"date\":227600463102},{\"position\":63,\"date\":228205263102},{\"position\":99,\"date\":228810063102},{\"position\":99,\"date\":229414863102}]},{\"itemName\":\"Follow You, Follow Me\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":83,\"date\":262074063102},{\"position\":71,\"date\":262678863102},{\"position\":61,\"date\":263280063102},{\"position\":53,\"date\":263884863102},{\"position\":47,\"date\":264489663102},{\"position\":41,\"date\":265094463102},{\"position\":37,\"date\":265699263102},{\"position\":35,\"date\":266304063102},{\"position\":29,\"date\":266908863102},{\"position\":23,\"date\":267513663102},{\"position\":23,\"date\":268118463102},{\"position\":54,\"date\":268723263102},{\"position\":54,\"date\":269328063102},{\"position\":53,\"date\":269932863102},{\"position\":59,\"date\":270537663102},{\"position\":98,\"date\":271142463102}]},{\"itemName\":\"And Then There Were Three\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":18,\"date\":262678863102},{\"position\":18,\"date\":263280063102},{\"position\":18,\"date\":263884863102},{\"position\":15,\"date\":264489663102},{\"position\":15,\"date\":265094463102},{\"position\":28,\"date\":265699263102}]},{\"itemName\":\"Duke\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":14,\"date\":323763663102},{\"position\":14,\"date\":324368463102},{\"position\":14,\"date\":324973263102},{\"position\":14,\"date\":325578063102},{\"position\":14,\"date\":326179263102},{\"position\":14,\"date\":326784063102},{\"position\":14,\"date\":327388863102},{\"position\":14,\"date\":327993663102},{\"position\":14,\"date\":328598463102},{\"position\":14,\"date\":329203263102},{\"position\":14,\"date\":329808063102},{\"position\":14,\"date\":330412863102},{\"position\":19,\"date\":331017663102}]},{\"itemName\":\"Misunderstanding\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":81,\"date\":327993663102},{\"position\":71,\"date\":328598463102},{\"position\":61,\"date\":329203263102},{\"position\":49,\"date\":329808063102},{\"position\":39,\"date\":330412863102},{\"position\":35,\"date\":331017663102},{\"position\":31,\"date\":331622463102},{\"position\":27,\"date\":332227263102},{\"position\":24,\"date\":332832063102},{\"position\":22,\"date\":333436863102},{\"position\":17,\"date\":334041663102},{\"position\":15,\"date\":334646463102},{\"position\":14,\"date\":335251263102},{\"position\":14,\"date\":335856063102},{\"position\":33,\"date\":336460863102},{\"position\":45,\"date\":337065663102},{\"position\":55,\"date\":337670463102},{\"position\":84,\"date\":338275263102}]},{\"itemName\":\"Turn It On Again\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":84,\"date\":337065663102},{\"position\":73,\"date\":337670463102},{\"position\":66,\"date\":338275263102},{\"position\":60,\"date\":338880063102},{\"position\":58,\"date\":339484863102},{\"position\":68,\"date\":340089663102},{\"position\":77,\"date\":340694463102},{\"position\":94,\"date\":341299263102}]},{\"itemName\":\"No Reply At All\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":85,\"date\":370329663102},{\"position\":75,\"date\":370934463102},{\"position\":65,\"date\":371539263102},{\"position\":54,\"date\":372144063102},{\"position\":47,\"date\":372748863102},{\"position\":41,\"date\":373357263102},{\"position\":36,\"date\":373962063102},{\"position\":32,\"date\":374566863102},{\"position\":30,\"date\":375171663102},{\"position\":29,\"date\":375776463102},{\"position\":29,\"date\":376381263102},{\"position\":34,\"date\":376986063102},{\"position\":42,\"date\":377590863102},{\"position\":49,\"date\":378195663102},{\"position\":49,\"date\":378800463102},{\"position\":61,\"date\":379405263102},{\"position\":82,\"date\":380010063102},{\"position\":98,\"date\":380614863102}]},{\"itemName\":\"Abacab\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":17,\"date\":372748863102},{\"position\":13,\"date\":373357263102},{\"position\":10,\"date\":373962063102},{\"position\":8,\"date\":374566863102},{\"position\":8,\"date\":375171663102},{\"position\":13,\"date\":375776463102},{\"position\":17,\"date\":376381263102},{\"position\":187,\"date\":447142863102},{\"position\":176,\"date\":447747663102},{\"position\":172,\"date\":448352463102},{\"position\":168,\"date\":448957263102},{\"position\":186,\"date\":449562063102},{\"position\":196,\"date\":523948863102},{\"position\":199,\"date\":524553663102}]},{\"itemName\":\"Abacab\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":71,\"date\":378195663102},{\"position\":71,\"date\":378800463102},{\"position\":57,\"date\":379405263102},{\"position\":47,\"date\":380010063102},{\"position\":40,\"date\":380614863102},{\"position\":36,\"date\":381219663102},{\"position\":30,\"date\":381824463102},{\"position\":28,\"date\":382429263102},{\"position\":26,\"date\":383034063102},{\"position\":26,\"date\":383638863102},{\"position\":44,\"date\":384243663102},{\"position\":57,\"date\":384848463102},{\"position\":71,\"date\":385453263102},{\"position\":98,\"date\":386058063102}]},{\"itemName\":\"Man On The Corner\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":82,\"date\":385453263102},{\"position\":73,\"date\":386058063102},{\"position\":63,\"date\":386662863102},{\"position\":55,\"date\":387267663102},{\"position\":51,\"date\":387872463102},{\"position\":45,\"date\":388477263102},{\"position\":44,\"date\":389078463102},{\"position\":40,\"date\":389683263102},{\"position\":40,\"date\":390288063102},{\"position\":67,\"date\":390892863102},{\"position\":100,\"date\":391497663102}]},{\"itemName\":\"Paperlate\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":90,\"date\":392102463102},{\"position\":80,\"date\":392707263102},{\"position\":68,\"date\":393312063102},{\"position\":55,\"date\":393916863102},{\"position\":48,\"date\":394521663102},{\"position\":45,\"date\":395126463102},{\"position\":41,\"date\":395731263102},{\"position\":36,\"date\":396336063102},{\"position\":34,\"date\":396940863102},{\"position\":32,\"date\":397545663102},{\"position\":32,\"date\":398150463102},{\"position\":32,\"date\":398755263102},{\"position\":91,\"date\":399360063102},{\"position\":100,\"date\":399964863102}]},{\"itemName\":\"Three Sides Live\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":20,\"date\":396336063102},{\"position\":17,\"date\":396940863102},{\"position\":14,\"date\":397545663102},{\"position\":14,\"date\":398150463102},{\"position\":14,\"date\":398755263102},{\"position\":14,\"date\":399360063102},{\"position\":15,\"date\":399964863102},{\"position\":17,\"date\":400569663102}]},{\"itemName\":\"Mama\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":93,\"date\":433833663102},{\"position\":88,\"date\":434438463102},{\"position\":84,\"date\":435043263102},{\"position\":75,\"date\":435648063102},{\"position\":73,\"date\":436252863102},{\"position\":82,\"date\":436861263102},{\"position\":86,\"date\":437466063102},{\"position\":91,\"date\":438070863102},{\"position\":97,\"date\":438675663102}]},{\"itemName\":\"Genesis\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":16,\"date\":436861263102},{\"position\":11,\"date\":437466063102},{\"position\":10,\"date\":438070863102},{\"position\":10,\"date\":438675663102},{\"position\":9,\"date\":439280463102},{\"position\":11,\"date\":439885263102},{\"position\":11,\"date\":440490063102},{\"position\":13,\"date\":441094863102},{\"position\":13,\"date\":441699663102},{\"position\":15,\"date\":442304463102},{\"position\":17,\"date\":442909263102},{\"position\":14,\"date\":443514063102},{\"position\":13,\"date\":444118863102},{\"position\":14,\"date\":444723663102},{\"position\":14,\"date\":445328463102},{\"position\":13,\"date\":445933263102},{\"position\":14,\"date\":446538063102},{\"position\":16,\"date\":447142863102},{\"position\":20,\"date\":447747663102},{\"position\":20,\"date\":448352463102},{\"position\":24,\"date\":448957263102},{\"position\":22,\"date\":449562063102},{\"position\":29,\"date\":450166863102},{\"position\":32,\"date\":450771663102},{\"position\":33,\"date\":451376463102},{\"position\":34,\"date\":451981263102},{\"position\":40,\"date\":452582463102},{\"position\":41,\"date\":453187263102},{\"position\":44,\"date\":453792063102},{\"position\":63,\"date\":454396863102},{\"position\":73,\"date\":455001663102},{\"position\":98,\"date\":455606463102},{\"position\":114,\"date\":456211263102},{\"position\":109,\"date\":456816063102},{\"position\":103,\"date\":457420863102},{\"position\":102,\"date\":458025663102},{\"position\":104,\"date\":458630463102},{\"position\":125,\"date\":459235263102},{\"position\":130,\"date\":459840063102},{\"position\":132,\"date\":460444863102},{\"position\":128,\"date\":461049663102},{\"position\":145,\"date\":461654463102},{\"position\":149,\"date\":462259263102},{\"position\":160,\"date\":462864063102},{\"position\":187,\"date\":463468863102},{\"position\":180,\"date\":464073663102},{\"position\":197,\"date\":464678463102},{\"position\":195,\"date\":543306063102},{\"position\":189,\"date\":543910863102}]},{\"itemName\":\"That\'s All\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":63,\"date\":438675663102},{\"position\":43,\"date\":439280463102},{\"position\":34,\"date\":439885263102},{\"position\":30,\"date\":440490063102},{\"position\":27,\"date\":441094863102},{\"position\":27,\"date\":441699663102},{\"position\":22,\"date\":442304463102},{\"position\":17,\"date\":442909263102},{\"position\":12,\"date\":443514063102},{\"position\":10,\"date\":444118863102},{\"position\":8,\"date\":444723663102},{\"position\":6,\"date\":445328463102},{\"position\":6,\"date\":445933263102},{\"position\":11,\"date\":446538063102},{\"position\":15,\"date\":447142863102},{\"position\":22,\"date\":447747663102},{\"position\":51,\"date\":448352463102},{\"position\":68,\"date\":448957263102},{\"position\":75,\"date\":449562063102},{\"position\":98,\"date\":450166863102}]},{\"itemName\":\"Illegal Alien\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":88,\"date\":447747663102},{\"position\":73,\"date\":448352463102},{\"position\":63,\"date\":448957263102},{\"position\":54,\"date\":449562063102},{\"position\":50,\"date\":450166863102},{\"position\":49,\"date\":450771663102},{\"position\":44,\"date\":451376463102},{\"position\":49,\"date\":451981263102},{\"position\":73,\"date\":452582463102},{\"position\":95,\"date\":453187263102}]},{\"itemName\":\"Taking It All Too Hard\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":82,\"date\":456211263102},{\"position\":69,\"date\":456816063102},{\"position\":65,\"date\":457420863102},{\"position\":59,\"date\":458025663102},{\"position\":53,\"date\":458630463102},{\"position\":51,\"date\":459235263102},{\"position\":50,\"date\":459840063102},{\"position\":69,\"date\":460444863102},{\"position\":74,\"date\":461049663102},{\"position\":89,\"date\":461654463102},{\"position\":97,\"date\":462259263102},{\"position\":98,\"date\":462864063102}]},{\"itemName\":\"Invisible Touch\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":45,\"date\":517900863102},{\"position\":37,\"date\":518505663102},{\"position\":27,\"date\":519110463102},{\"position\":17,\"date\":519715263102},{\"position\":8,\"date\":520320063102},{\"position\":6,\"date\":520924863102},{\"position\":2,\"date\":521529663102},{\"position\":1,\"date\":522134463102},{\"position\":3,\"date\":522739263102},{\"position\":5,\"date\":523344063102},{\"position\":11,\"date\":523948863102},{\"position\":21,\"date\":524553663102},{\"position\":33,\"date\":525158463102},{\"position\":47,\"date\":525763263102},{\"position\":67,\"date\":526368063102},{\"position\":79,\"date\":526972863102},{\"position\":98,\"date\":527577663102}]},{\"itemName\":\"Invisible Touch\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":23,\"date\":520320063102},{\"position\":10,\"date\":520924863102},{\"position\":5,\"date\":521529663102},{\"position\":5,\"date\":522134463102},{\"position\":4,\"date\":522739263102},{\"position\":3,\"date\":523344063102},{\"position\":4,\"date\":523948863102},{\"position\":4,\"date\":524553663102},{\"position\":4,\"date\":525158463102},{\"position\":3,\"date\":525763263102},{\"position\":6,\"date\":526368063102},{\"position\":6,\"date\":526972863102},{\"position\":8,\"date\":527577663102},{\"position\":10,\"date\":528182463102},{\"position\":9,\"date\":528787263102},{\"position\":9,\"date\":529392063102},{\"position\":9,\"date\":529996863102},{\"position\":12,\"date\":530601663102},{\"position\":14,\"date\":531210063102},{\"position\":15,\"date\":531814863102},{\"position\":18,\"date\":532419663102},{\"position\":22,\"date\":533024463102},{\"position\":25,\"date\":533629263102},{\"position\":25,\"date\":534234063102},{\"position\":23,\"date\":534838863102},{\"position\":22,\"date\":535443663102},{\"position\":21,\"date\":536048463102},{\"position\":21,\"date\":536653263102},{\"position\":20,\"date\":537258063102},{\"position\":17,\"date\":537862863102},{\"position\":15,\"date\":538467663102},{\"position\":13,\"date\":539072463102},{\"position\":12,\"date\":539677263102},{\"position\":9,\"date\":540282063102},{\"position\":7,\"date\":540886863102},{\"position\":7,\"date\":541491663102},{\"position\":4,\"date\":542096463102},{\"position\":4,\"date\":542701263102},{\"position\":6,\"date\":543306063102},{\"position\":5,\"date\":543910863102},{\"position\":6,\"date\":544515663102},{\"position\":6,\"date\":545116863102},{\"position\":8,\"date\":545721663102},{\"position\":13,\"date\":546326463102},{\"position\":16,\"date\":546931263102},{\"position\":20,\"date\":547536063102},{\"position\":22,\"date\":548140863102},{\"position\":21,\"date\":548745663102},{\"position\":19,\"date\":549350463102},{\"position\":19,\"date\":549955263102},{\"position\":19,\"date\":550560063102},{\"position\":17,\"date\":551164863102},{\"position\":20,\"date\":551769663102},{\"position\":19,\"date\":552374463102},{\"position\":18,\"date\":552979263102},{\"position\":17,\"date\":553584063102},{\"position\":20,\"date\":554188863102},{\"position\":24,\"date\":554793663102},{\"position\":25,\"date\":555398463102},{\"position\":34,\"date\":556003263102},{\"position\":39,\"date\":556608063102},{\"position\":42,\"date\":557212863102},{\"position\":51,\"date\":557817663102},{\"position\":53,\"date\":558422463102},{\"position\":64,\"date\":559027263102},{\"position\":84,\"date\":559632063102},{\"position\":80,\"date\":560236863102},{\"position\":93,\"date\":560841663102},{\"position\":116,\"date\":561446463102},{\"position\":125,\"date\":562051263102},{\"position\":156,\"date\":562659663102},{\"position\":154,\"date\":563264463102},{\"position\":150,\"date\":563869263102},{\"position\":167,\"date\":564474063102},{\"position\":175,\"date\":565078863102},{\"position\":177,\"date\":565683663102},{\"position\":176,\"date\":566288463102},{\"position\":158,\"date\":566893263102},{\"position\":158,\"date\":567498063102},{\"position\":158,\"date\":568102863102},{\"position\":187,\"date\":568707663102},{\"position\":164,\"date\":569312463102},{\"position\":176,\"date\":569917263102},{\"position\":189,\"date\":570522063102},{\"position\":199,\"date\":571126863102}]},{\"itemName\":\"Throwing It All Away\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":54,\"date\":524553663102},{\"position\":38,\"date\":525158463102},{\"position\":27,\"date\":525763263102},{\"position\":25,\"date\":526368063102},{\"position\":20,\"date\":526972863102},{\"position\":17,\"date\":527577663102},{\"position\":12,\"date\":528182463102},{\"position\":7,\"date\":528787263102},{\"position\":4,\"date\":529392063102},{\"position\":4,\"date\":529996863102},{\"position\":7,\"date\":530601663102},{\"position\":16,\"date\":531210063102},{\"position\":29,\"date\":531814863102},{\"position\":51,\"date\":532419663102},{\"position\":68,\"date\":533024463102},{\"position\":87,\"date\":533629263102}]},{\"itemName\":\"Land Of Confusion\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":64,\"date\":531210063102},{\"position\":49,\"date\":531814863102},{\"position\":37,\"date\":532419663102},{\"position\":34,\"date\":533024463102},{\"position\":28,\"date\":533629263102},{\"position\":26,\"date\":534234063102},{\"position\":20,\"date\":534838863102},{\"position\":16,\"date\":535443663102},{\"position\":13,\"date\":536048463102},{\"position\":13,\"date\":536653263102},{\"position\":11,\"date\":537258063102},{\"position\":8,\"date\":537862863102},{\"position\":6,\"date\":538467663102},{\"position\":4,\"date\":539072463102},{\"position\":6,\"date\":539677263102},{\"position\":20,\"date\":540282063102},{\"position\":32,\"date\":540886863102},{\"position\":45,\"date\":541491663102},{\"position\":65,\"date\":542096463102},{\"position\":89,\"date\":542701263102},{\"position\":97,\"date\":543306063102}]},{\"itemName\":\"Tonight, Tonight, Tonight\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":45,\"date\":540282063102},{\"position\":36,\"date\":540886863102},{\"position\":27,\"date\":541491663102},{\"position\":16,\"date\":542096463102},{\"position\":12,\"date\":542701263102},{\"position\":6,\"date\":543306063102},{\"position\":4,\"date\":543910863102},{\"position\":3,\"date\":544515663102},{\"position\":4,\"date\":545116863102},{\"position\":14,\"date\":545721663102},{\"position\":26,\"date\":546326463102},{\"position\":44,\"date\":546931263102},{\"position\":56,\"date\":547536063102},{\"position\":80,\"date\":548140863102},{\"position\":95,\"date\":548745663102}]},{\"itemName\":\"In Too Deep\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":51,\"date\":546326463102},{\"position\":39,\"date\":546931263102},{\"position\":34,\"date\":547536063102},{\"position\":24,\"date\":548140863102},{\"position\":16,\"date\":548745663102},{\"position\":11,\"date\":549350463102},{\"position\":6,\"date\":549955263102},{\"position\":4,\"date\":550560063102},{\"position\":4,\"date\":551164863102},{\"position\":3,\"date\":551769663102},{\"position\":6,\"date\":552374463102},{\"position\":17,\"date\":552979263102},{\"position\":29,\"date\":553584063102},{\"position\":43,\"date\":554188863102},{\"position\":60,\"date\":554793663102},{\"position\":74,\"date\":555398463102},{\"position\":88,\"date\":556003263102}]},{\"itemName\":\"No Son Of Mine\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":53,\"date\":689062863102},{\"position\":40,\"date\":689667663102},{\"position\":29,\"date\":690272463102},{\"position\":22,\"date\":690877263102},{\"position\":22,\"date\":691482063102},{\"position\":20,\"date\":692086863102},{\"position\":17,\"date\":692691663102},{\"position\":13,\"date\":693296463102},{\"position\":13,\"date\":693901263102},{\"position\":14,\"date\":694506063102},{\"position\":16,\"date\":695110863102},{\"position\":12,\"date\":695715663102},{\"position\":13,\"date\":696320463102},{\"position\":15,\"date\":696925263102},{\"position\":21,\"date\":697530063102},{\"position\":26,\"date\":698134863102},{\"position\":38,\"date\":698739663102},{\"position\":46,\"date\":699344463102},{\"position\":56,\"date\":699949263102},{\"position\":59,\"date\":700554063102}]},{\"itemName\":\"We Can\'t Dance\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":4,\"date\":691482063102},{\"position\":8,\"date\":692086863102},{\"position\":12,\"date\":692691663102},{\"position\":13,\"date\":693296463102},{\"position\":13,\"date\":693901263102},{\"position\":13,\"date\":694506063102},{\"position\":14,\"date\":695110863102},{\"position\":17,\"date\":695715663102},{\"position\":18,\"date\":696320463102},{\"position\":18,\"date\":696925263102},{\"position\":17,\"date\":697530063102},{\"position\":14,\"date\":698134863102},{\"position\":10,\"date\":698739663102},{\"position\":7,\"date\":699344463102},{\"position\":10,\"date\":699949263102},{\"position\":14,\"date\":700554063102},{\"position\":14,\"date\":701158863102},{\"position\":14,\"date\":701763663102},{\"position\":15,\"date\":702368463102},{\"position\":14,\"date\":702969663102},{\"position\":17,\"date\":703574463102},{\"position\":18,\"date\":704179263102},{\"position\":16,\"date\":704784063102},{\"position\":20,\"date\":705388863102},{\"position\":21,\"date\":705993663102},{\"position\":14,\"date\":706598463102},{\"position\":16,\"date\":707203263102},{\"position\":15,\"date\":707808063102},{\"position\":14,\"date\":708412863102},{\"position\":15,\"date\":709017663102},{\"position\":13,\"date\":709622463102},{\"position\":11,\"date\":710227263102},{\"position\":12,\"date\":710832063102},{\"position\":14,\"date\":711436863102},{\"position\":21,\"date\":712041663102},{\"position\":25,\"date\":712646463102},{\"position\":24,\"date\":713251263102},{\"position\":23,\"date\":713856063102},{\"position\":24,\"date\":714460863102},{\"position\":29,\"date\":715065663102},{\"position\":28,\"date\":715670463102},{\"position\":32,\"date\":716275263102},{\"position\":33,\"date\":716880063102},{\"position\":36,\"date\":717484863102},{\"position\":37,\"date\":718089663102},{\"position\":47,\"date\":718694463102},{\"position\":55,\"date\":719299263102},{\"position\":55,\"date\":719904063102},{\"position\":57,\"date\":720512463102},{\"position\":62,\"date\":721117263102},{\"position\":66,\"date\":721722063102},{\"position\":68,\"date\":722326863102},{\"position\":71,\"date\":722931663102},{\"position\":75,\"date\":723536463102},{\"position\":84,\"date\":724141263102},{\"position\":86,\"date\":724746063102},{\"position\":83,\"date\":725350863102},{\"position\":82,\"date\":725955663102},{\"position\":89,\"date\":726560463102},{\"position\":88,\"date\":727165263102},{\"position\":102,\"date\":727770063102},{\"position\":108,\"date\":728374863102},{\"position\":121,\"date\":728979663102},{\"position\":109,\"date\":729584463102},{\"position\":127,\"date\":730189263102},{\"position\":128,\"date\":730794063102},{\"position\":138,\"date\":731398863102},{\"position\":151,\"date\":732003663102},{\"position\":156,\"date\":732608463102},{\"position\":190,\"date\":733213263102},{\"position\":194,\"date\":733818063102},{\"position\":190,\"date\":735628863102}]},{\"itemName\":\"I Can\'t Dance\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":78,\"date\":696925263102},{\"position\":43,\"date\":697530063102},{\"position\":29,\"date\":698134863102},{\"position\":27,\"date\":698739663102},{\"position\":21,\"date\":699344463102},{\"position\":15,\"date\":699949263102},{\"position\":11,\"date\":700554063102},{\"position\":9,\"date\":701158863102},{\"position\":8,\"date\":701763663102},{\"position\":9,\"date\":702368463102},{\"position\":7,\"date\":702969663102},{\"position\":13,\"date\":703574463102},{\"position\":17,\"date\":704179263102},{\"position\":19,\"date\":704784063102},{\"position\":23,\"date\":705388863102},{\"position\":32,\"date\":705993663102},{\"position\":41,\"date\":706598463102},{\"position\":45,\"date\":707203263102},{\"position\":46,\"date\":707808063102},{\"position\":54,\"date\":708412863102}]},{\"itemName\":\"Hold On My Heart\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":79,\"date\":704784063102},{\"position\":44,\"date\":705388863102},{\"position\":31,\"date\":705993663102},{\"position\":19,\"date\":706598463102},{\"position\":17,\"date\":707203263102},{\"position\":14,\"date\":707808063102},{\"position\":13,\"date\":708412863102},{\"position\":13,\"date\":709017663102},{\"position\":12,\"date\":709622463102},{\"position\":15,\"date\":710227263102},{\"position\":16,\"date\":710832063102},{\"position\":23,\"date\":711436863102},{\"position\":25,\"date\":712041663102},{\"position\":32,\"date\":712646463102},{\"position\":33,\"date\":713251263102},{\"position\":37,\"date\":713856063102},{\"position\":45,\"date\":714460863102},{\"position\":51,\"date\":715065663102},{\"position\":56,\"date\":715670463102},{\"position\":54,\"date\":716275263102}]},{\"itemName\":\"Jesus He Knows Me\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":59,\"date\":712646463102},{\"position\":43,\"date\":713251263102},{\"position\":35,\"date\":713856063102},{\"position\":33,\"date\":714460863102},{\"position\":29,\"date\":715065663102},{\"position\":24,\"date\":715670463102},{\"position\":23,\"date\":716275263102},{\"position\":23,\"date\":716880063102},{\"position\":23,\"date\":717484863102},{\"position\":32,\"date\":718089663102},{\"position\":39,\"date\":718694463102},{\"position\":46,\"date\":719299263102},{\"position\":52,\"date\":719904063102},{\"position\":61,\"date\":720512463102},{\"position\":68,\"date\":721117263102},{\"position\":73,\"date\":721722063102},{\"position\":67,\"date\":722326863102},{\"position\":67,\"date\":722931663102},{\"position\":81,\"date\":723536463102},{\"position\":89,\"date\":724141263102}]},{\"itemName\":\"Never A Time\",\"artist\":\"Genesis\",\"type\":\"s\",\"entries\":[{\"position\":83,\"date\":721117263102},{\"position\":60,\"date\":721722063102},{\"position\":54,\"date\":722326863102},{\"position\":50,\"date\":722931663102},{\"position\":46,\"date\":723536463102},{\"position\":35,\"date\":724141263102},{\"position\":31,\"date\":724746063102},{\"position\":25,\"date\":725350863102},{\"position\":29,\"date\":725955663102},{\"position\":36,\"date\":726560463102},{\"position\":24,\"date\":727165263102},{\"position\":21,\"date\":727770063102},{\"position\":25,\"date\":728374863102},{\"position\":38,\"date\":728979663102},{\"position\":48,\"date\":729584463102},{\"position\":57,\"date\":730189263102},{\"position\":68,\"date\":730794063102},{\"position\":65,\"date\":731398863102},{\"position\":71,\"date\":732003663102},{\"position\":72,\"date\":732608463102}]},{\"itemName\":\"Live: The Way We Walk Volume 1\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":48,\"date\":723536463102},{\"position\":42,\"date\":724141263102},{\"position\":39,\"date\":724746063102},{\"position\":35,\"date\":725350863102},{\"position\":39,\"date\":725955663102},{\"position\":40,\"date\":726560463102},{\"position\":36,\"date\":727165263102},{\"position\":41,\"date\":727770063102},{\"position\":43,\"date\":728374863102},{\"position\":47,\"date\":728979663102},{\"position\":45,\"date\":729584463102},{\"position\":57,\"date\":730189263102},{\"position\":57,\"date\":730794063102},{\"position\":71,\"date\":731398863102},{\"position\":79,\"date\":732003663102},{\"position\":84,\"date\":732608463102},{\"position\":93,\"date\":733213263102}]},{\"itemName\":\"Live: The Way We Walk Vol. 2: The Longs\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":20,\"date\":730794063102},{\"position\":40,\"date\":731398863102},{\"position\":63,\"date\":732003663102},{\"position\":77,\"date\":732608463102}]},{\"itemName\":\"Live - The Way We Walk Volume 2\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":104,\"date\":733213263102},{\"position\":122,\"date\":733818063102},{\"position\":148,\"date\":734419263102},{\"position\":158,\"date\":735024063102},{\"position\":178,\"date\":735628863102}]},{\"itemName\":\"Live - The Way We Walk Volume 1\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":118,\"date\":733818063102},{\"position\":130,\"date\":734419263102},{\"position\":139,\"date\":735024063102},{\"position\":144,\"date\":735628863102},{\"position\":169,\"date\":736233663102},{\"position\":186,\"date\":736838463102}]},{\"itemName\":\"Calling All Stations\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":54,\"date\":874732863102},{\"position\":77,\"date\":875337663102},{\"position\":102,\"date\":875942463102},{\"position\":140,\"date\":876547263102},{\"position\":192,\"date\":877152063102}]},{\"itemName\":\"Turn It On Again - The Hits\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":65,\"date\":942474063102},{\"position\":91,\"date\":943078863102},{\"position\":122,\"date\":943683663102},{\"position\":154,\"date\":944288463102},{\"position\":198,\"date\":944893263102},{\"position\":185,\"date\":947312463102},{\"position\":184,\"date\":947917263102},{\"position\":186,\"date\":948522063102},{\"position\":197,\"date\":949126863102}]},{\"itemName\":\"Platinum Collection\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":100,\"date\":1128144063102}]},{\"itemName\":\"The Platinum Collection\",\"artist\":\"Genesis\",\"type\":\"a\",\"entries\":[{\"position\":120,\"date\":1128748863102},{\"position\":178,\"date\":1129353663102}]}]";
	JSONArray results;
	String artist;
	int type;
	String item;
	
	TextView entry;
	TextView peak;
	TextView dropoff;
	Spinner spinner;
	RelativeLayout topLayout;
	
	int graphViewID = -1;
	int entryListID = -1;
	
	TextView queryLabel;
	RelativeLayout layout;
	RelativeLayout resultDisplayLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results);
		Intent intent = getIntent();
		
		artist = intent.getStringExtra("Artist");
		type = intent.getIntExtra("Search Type", ReverseLookupActivity.ARTIST_SEARCH);
		item = intent.getStringExtra("Item");
		
		entry = (TextView)findViewById(R.id.entryTextView);
		peak = (TextView)findViewById(R.id.peakTextView);
		dropoff = (TextView)findViewById(R.id.dropoffTextView);
		
		queryLabel = (TextView)findViewById(R.id.query_label);
		topLayout = (RelativeLayout)findViewById(R.id.topLayout);
		layout = (RelativeLayout)findViewById(R.id.layout);
		resultDisplayLayout = (RelativeLayout)findViewById(R.id.resultDisplayLayout);
		//Spinner spinner = (Spinner)findViewById(R.id.searchResultSpinner);

		
		if (type == ReverseLookupActivity.ARTIST_SEARCH) {
			
			ReverseArtistLookupTask task = new ReverseArtistLookupTask(this, "Executing search...");
			task.execute(artist, "", "");
			
			/*
			
			try {
			
				DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
				HttpRequestTask reverseLookupTask = new HttpRequestTask(this, "Getting results...");
				String response = reverseLookupTask.execute("http://billboard-jpblair.herokuapp.com/reverse/artist", "GET", "artist", artist, "startDate", "", "endDate", "").get();
				populateSpinner(response);
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
		else if (type == ReverseLookupActivity.SONG_SEARCH) {
			
			ReverseSongLookupTask task = new ReverseSongLookupTask(this, "Executing search...");
			task.execute(artist, item, "", "");
			
			/*
			
			try {
				
				DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
				HttpRequestTask reverseLookupTask = new HttpRequestTask(this, "Getting results...");
				String response = reverseLookupTask.execute("http://billboard-jpblair.herokuapp.com/reverse/song", "GET", "artist", artist, "song", item, "startDate", "", "endDate", "").get();
				
				if (response.equals(""))  {
					noResults();
					return;
				}
				
				displayResult(new JSONObject(response));
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
			
			*/
						
		}
		else if (type == ReverseLookupActivity.ALBUM_SEARCH) {
			
			ReverseAlbumLookupTask task = new ReverseAlbumLookupTask(this, "Executing search...");
			task.execute(artist, item, "", "");
			
			/*
			
			try {
				
				DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
				HttpRequestTask reverseLookupTask = new HttpRequestTask(this, "Getting results...");
				String response = reverseLookupTask.execute("http://billboard-jpblair.herokuapp.com/reverse/album", "GET", "artist", artist, "album", item, "startDate", "", "endDate", "").get();
				
				if (response.equals(""))  {
					noResults();
					return;
				}
				
				displayResult(new JSONObject(response));
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
			
			*/
			
		}
		
		
		
	}
	
	public void populateSpinner(String response) {
		
		spinner = new Spinner(this);
		
		try {

			if (response.equals(""))  {
				noResults();
				return;
			}
		
			RelativeLayout.LayoutParams lpSpinner = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lpSpinner.addRule(RelativeLayout.BELOW, R.id.query_label);
			lpSpinner.addRule(RelativeLayout.CENTER_HORIZONTAL);
			lpSpinner.setMargins(0, 15, 0, 22);
			spinner.setLayoutParams(lpSpinner);
			topLayout.addView(spinner);
			
			results = new JSONArray(response);
			ArrayList<String> spinnerItems = new ArrayList<String>();
			
			for (int i = 0; i < results.length(); i++) {
				JSONObject cur = results.getJSONObject(i);
				String resultType;
				
				if (cur.getString("type").equals("s"))
					resultType = " (single)";
				else
					resultType = " (album)";
				
				spinnerItems.add(cur.getString("itemName") + resultType);
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner.setAdapter(adapter);
		
		}
		catch (JSONException e) {
			e.printStackTrace();
		} 
		
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	        @Override
	        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int myPosition, long myID) {
	        	try {
					JSONObject item = SearchResultsActivity.this.results.getJSONObject(myPosition);
					SearchResultsActivity.this.displayResult(item);
				} catch (JSONException e) {
					e.printStackTrace();
				}
	        }

	        @Override
	        public void onNothingSelected(AdapterView<?> parentView) {

	        }

	    });		
		
	}
	
	public void noResults() {
		setContentView(R.layout.no_results);
	}
	
	public void displayResult(JSONObject json) {

		try {
			
			//Set header text
			
			String itemName = json.getString("itemName");
			String artistName = json.getString("artist");
			String itemType = json.getString("type");
			String labelText =  artistName + " - " + itemName;
				
			queryLabel.setText(labelText);
			
			//Clear out old Views
			
			if (resultDisplayLayout.getChildCount() > 3)
				resultDisplayLayout.removeViewAt(3);
			
			if (resultDisplayLayout.getChildCount() > 3)
				resultDisplayLayout.removeViewAt(3);
		
			JSONArray chartHistory = new JSONArray(json.getString("entries"));
			GraphViewData [] data = new GraphViewData[chartHistory.length()]; 
			
			int peakPosition = chartHistory.getJSONObject(0).getInt("position");
			Date peakDate = new Date(chartHistory.getJSONObject(0).getLong("date"));
			
			LinearLayout entriesList = new LinearLayout(this);
			entriesList.setOrientation(LinearLayout.VERTICAL);
			DateFormat resultDF = new SimpleDateFormat("MMMM d, yyyy");
			
			//Parse through JSON array of entries
			
			for (int i = 0; i < chartHistory.length(); i++)  {
				
				//Get entry data from JSON object
				
				JSONObject entry = chartHistory.getJSONObject(i);
				long dateMillis = entry.getLong("date");
				int position = entry.getInt("position");
				Date date = new Date (dateMillis);
				
				if (position < peakPosition)  {
					peakPosition = position;
					peakDate = date;
				}
				
				//Add entries to list
				
				RelativeLayout rl = new RelativeLayout(this);
				
				TextView tvDate = new TextView(this);
				TextView tvPosition = new TextView(this);
				tvDate.setText(resultDF.format(date));
				tvPosition.setText("#" + position);
				tvDate.setTextSize(20);
				tvPosition.setTextSize(20);
				
				RelativeLayout.LayoutParams lpDate = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				lpDate.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				tvDate.setLayoutParams(lpDate);
				rl.addView(tvDate);
				
				RelativeLayout.LayoutParams lpPosition = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				lpPosition.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				tvPosition.setLayoutParams(lpPosition);
				rl.addView(tvPosition);
				
				entriesList.addView(rl);
				
				//Add data to graph

				data[i] = new GraphViewData(date.getTime(), -1*position);
			}			
			
			//Set entry, peak and dropoff labels
			
			if (chartHistory.length() < 2)  {
				entry.setText("Peak position: " + resultDF.format(new Date(chartHistory.getJSONObject(0).getLong("date"))) + " - #" + chartHistory.getJSONObject(0).getInt("position"));
				//entry.setTextSize(20);
				peak.setText("");
				dropoff.setText("");
				return;
			}
			
			entry.setText("Entry position:  #" + chartHistory.getJSONObject(0).getInt("position") + ", " + resultDF.format(new Date(chartHistory.getJSONObject(0).getLong("date"))));
			peak.setText("Peak position:  #" + peakPosition + ", " + resultDF.format(peakDate));
			dropoff.setText("Dropoff position:  #" + chartHistory.getJSONObject(chartHistory.length() - 1).getInt("position") + ", " + resultDF.format(new Date(chartHistory.getJSONObject(chartHistory.length() - 1).getLong("date"))));
			
			//Set up graph
			
			GraphViewSeries exampleSeries = new GraphViewSeries(data);
			
			final DateFormat df = new SimpleDateFormat("MM/dd/yy");
			
			Display display = getWindowManager().getDefaultDisplay();
			int width = display.getWidth();
			int height = display.getHeight();
			int graphWidth = (int)(width * 0.95);
			int graphHeight = graphWidth;
			
			RelativeLayout.LayoutParams lpGraph = new RelativeLayout.LayoutParams(graphWidth, graphHeight);
				 
			LineGraphView graphView = new LineGraphView(this, "") {
			    @Override
			    protected String formatLabel(double value, boolean isValueX) {
			        if (isValueX) {
			            // transform number to time
			            return df.format(new Date((long) value));
			        } else {
			        	if (value == (int)value)
			        		return super.formatLabel(-value, isValueX);
			        	else
			        		return "";
			        }
			    }
			};
			
			graphView.setLayoutParams(lpGraph);
			graphView.setId(generateViewId());
			graphView.getGraphViewStyle().setTextSize(20);
			graphView.addSeries(exampleSeries); // data
			graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.BLACK);
			graphView.getGraphViewStyle().setVerticalLabelsColor(Color.BLACK);
			graphView.getGraphViewStyle().setVerticalLabelsWidth(50);
			//graphView.getGraphViewStyle().setNumVerticalLabels((int)(graphView.getMaxY() - graphView.getMinY()) + 1);
			
			//lpGraph.addRule(RelativeLayout.BELOW, R.id.searchResultSpinner);
			//layout.addView(graphView, lpGraph);
			lpGraph.addRule(RelativeLayout.BELOW, R.id.dropoffTextView);
			lpGraph.addRule(RelativeLayout.CENTER_HORIZONTAL);
			
			int range = (int)(graphView.getMaxY() - graphView.getMinY()) + 1;
			
			if (range < 10)
				graphView.getGraphViewStyle().setNumVerticalLabels(range);
			else
				graphView.getGraphViewStyle().setNumVerticalLabels(2);
			
			graphView.getGraphViewStyle().setNumHorizontalLabels(2);
			resultDisplayLayout.addView(graphView, lpGraph);
			
			RelativeLayout extraRow = new RelativeLayout(this);
			TextView tv = new TextView(this);
			tv.setText(" ");
			extraRow.addView(tv);
			entriesList.addView(extraRow);
			
			RelativeLayout.LayoutParams lpEntryList = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			entriesList.setLayoutParams(lpEntryList);
			lpEntryList.addRule(RelativeLayout.BELOW, graphView.getId());
			lpEntryList.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			lpEntryList.setMargins(0,35,0,20);
			entriesList.setId(generateViewId());
			System.out.println("Entry TextView ID: " + entry.getId());
			System.out.println("Peak TextView ID: " + peak.getId());
			System.out.println("Dropoff TextView ID: " + dropoff.getId());
			System.out.println("GraphView ID: " + graphView.getId());
			System.out.println("Entries list ID: " + entriesList.getId());
			resultDisplayLayout.addView(entriesList, lpEntryList);
			
			
		}
		catch (Exception e) {
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
		getMenuInflater().inflate(R.menu.search_results, menu);
		return true;
	}

}
