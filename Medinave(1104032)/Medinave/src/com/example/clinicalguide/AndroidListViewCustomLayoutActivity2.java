package com.example.clinicalguide;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class AndroidListViewCustomLayoutActivity2 extends Activity {
	final Context context = this;
 MyCustomAdapter dataAdapter = null;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.diagnostic);
 
	
 
  //Generate list View from ArrayList
  displayListView();
 
 }
 
 private void displayListView() {
 
  //Array list of countries
  ArrayList<Country> countryList = new ArrayList<Country>();
  
 Country country = new Country("205/216, Jamal Khan RoadChittagong ","031 613249","LAB ONE HEALTH SERVICES LTD ");
  countryList.add(country);
  country = new Country("106/A,FazlulQuaderRoad","031 653010","BANGLADESH DIAGNOSTIC");
  countryList.add(country);
  country = new Country("20, K.B. Fazlul Kader Road, Chittagong.","031 652652","BASIC LAB");
  countryList.add(country);
  country = new Country("106/A, K.B. Fazlul Quader Road, Chittagong ","0607 4304303","BIOCHEMISTRY LAB");
  countryList.add(country);
  country = new Country("84, Jamal Khan Road, Chittagong","031 618533. ","PATH LABORATORY");
  countryList.add(country);
  country = new Country("417, M. M. Ali Road, Dampara Police Line,Chittagong ","0191 883053 ","CENTRAL LAB");
  countryList.add(country);
  country = new Country("12/12,O.R.NizamRoad","031 652963","CHEVRON CLINICAL LABORATORY (PVT.) LTD");
  countryList.add(country);
  country = new Country("131, K.B. Fazlul Quader Road,","031 650868","CHITTAGONG DOCTORS LAB (PVT.) LTD");
  countryList.add(country);
  country = new Country("20. K.B. Fazlul Kader Road. Panchlaish.","031 653135 ","CHITTAGONG LAB LTD");
  countryList.add(country);
  country = new Country("57, K.B. Fazlul Quader Road, Chittagong","031 654185","CRESCENT DIAGNOSIS");
  countryList.add(country);
  country = new Country("Chittagong","031 652342","C.T. IMAGING & DIAGNOSTIC CENTRE LTD");
  countryList.add(country);
  country = new Country("Minhaz Complex. 12, Jamal Khan Road","031 632980","DIASONIC DIAGNOSTIC CENTRE");
  countryList.add(country);
  country = new Country("65, Jamal Khan Road, Chittagong ","031 639757","DIVINE DIAGNOSTIC LTD");
  countryList.add(country);
  country = new Country("58,Chatteswari Road","031 619057","DR.MAHFUZUR RAHMAN'S LAB");
  countryList.add(country);
  country = new Country("83, Jamal Khan Road, Chittagong .","031 616899 ","LAB EXPERTS (PVT) LTD");
  countryList.add(country);
  country = new Country("39, Momin Road, Chittagong","031 617060","MAGNUM DIAGNOSTIC COMPLEX ");
  countryList.add(country);
  country = new Country("14, Panchlaish R/A, Chittagong.","031-656592","Health Sense Diagnostic Cente");
  countryList.add(country);
  country = new Country("Metro Tower,Mehidibagh"," 031-2851677","Metro Diagnostic Center Ltdl");
  countryList.add(country);

  country = new Country("487/B,O.R.Nizam Road","031-620634","Metropolitan Diagnostic Centre");
  countryList.add(country);
  country = new Country("ctg medical main gate,fazlul kaer road","01938584409","popular diagnostic centre");
  countryList.add(country);
  country = new Country("190, K.B Fazlul Kader Road","031 617604","Woodland Diagnostic Centre");
  countryList.add(country);
  country = new Country("Faruque Bhavan(1st floor),O.R.Nizam Road","031-650034 ","Sheba Diagnostic Centre");
  countryList.add(country);
  country = new Country("5, Laldhighir Purbo Par, Chittagong"," 031‑615097","MEDIPATH DIAGNOSTIC CENTRE");
  countryList.add(country);
  country = new Country("17, Panchiaish RIA, Chittagong"," 031‑654490","MEGHNA LABORATORY");
  countryList.add(country);
  country = new Country("Bibir Hat, Fatickchari, Chittagong ","01819‑808980","MENA DIAGNOSTIC CENTRE");
  countryList.add(country);
  country = new Country("131,FazlulQuaderRoad"," 031‑652661","METRO DIAGNOSTIC CENTRE.");
  countryList.add(country);
   country = new Country("Jamal Khan Road, Chittagong,","031‑65083","ULTRA ASSAY");
  countryList.add(country);
  country = new Country(" 14115, Mehadibag.","031‑627914","SIGMA LAB LTD");
  countryList.add(country);
  country = new Country("H‑370, R‑14, Block b, Chandgaon R/A, Chittagong","01818510969"," PRATISRUTY");
  countryList.add(country);
  country = new Country("60 & 129, Panchlaish R/A. Chittagong","031‑651582","MIRROR LAB (PVT.) LTD.");
  countryList.add(country);
  country = new Country("14/A, Panchlaish R/A, Chittagong",":031‑656480","PREMIER DIAGNOSTIC CENTRE");
  countryList.add(country);
  country = new Country("65/A,Chack Bazar","031‑619205","QUICK DIAGNOSIS (PVT.) LIMITED");
  countryList.add(country);
 country = new Country("57, K.B.FazlulQuader Road,Chittagong","031‑653118","SAFE CLINICAL LABORATORY");
  countryList.add(country);
  country = new Country("14, Jamal Khan Road, Chittagong","031‑615878","SENSIV");
  countryList.add(country);
  country = new Country("3, O.R. Nizam Road Chittagong ","031‑625765","STAR LAB LTD");
  countryList.add(country);
  country = new Country("47,Suhrawardy Road, Chittagong","031‑3099708","WELCOME DIAGNOSTIC CENTRE");
  countryList.add(country);
  country = new Country("145, Jamal Khan Road. Chittagong","031‑614743","MICROLAB");
  countryList.add(country);
  country = new Country("42, Hossain Shaheed Suhrawardy Road, Chittagong",": 031‑612262","MID CITY LAB");
  countryList.add(country);
  country = new Country("127, Jamal Khan Road, Chittagong","031‑625495","SCAN INN");
  countryList.add(country);
  
 
  //create an ArrayAdaptar from the String Array
  dataAdapter = new MyCustomAdapter(this,
    R.layout.country_info, countryList);
  ListView listView = (ListView) findViewById(R.id.listView1);
  // Assign adapter to ListView
  
  listView.setAdapter(dataAdapter);
 
  //enables filtering for the contents of the given ListView
  listView.setTextFilterEnabled(true);
 
  listView.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
    // When clicked, show a toast with the TextView text
	   final Country country = (Country) parent.getItemAtPosition(position);
	   LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity2.this);
	   View view1=li.inflate(R.layout.custom_layout2,null);
	 
	   final LinearLayout save=(LinearLayout)view1.findViewById(R.id.layout1);
	   LinearLayout call=(LinearLayout)view1.findViewById(R.id.layout1);
	   
	   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout4);
	 
	   
		AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity2.this);
		builder.setView(view1);//builder e age image set krtam ekhn view set korlam
		builder.setCancelable(false);
		final AlertDialog customdialog=builder.create();
		customdialog.show();
call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String uri ="tel:"+country.getContinent().toString();
                  
                  Intent intent = new Intent(Intent.ACTION_DIAL);
  				
  				intent.setData(Uri.parse(uri));
  				startActivity(intent);
				
				
			}
		});

close.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(getApplicationContext(),"dialog cancelled",Toast.LENGTH_LONG).show();
			customdialog.cancel();
			
			
		}
	});
   }
  });
  
 
  EditText myFilter = (EditText) findViewById(R.id.myFilter);
  myFilter.addTextChangedListener(new TextWatcher() {
 
  public void afterTextChanged(Editable s) {
  }
 
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
  }
 
  public void onTextChanged(CharSequence s, int start, int before, int count) {
   dataAdapter.getFilter().filter(s.toString());
  }
  });
 
 }
 
 private class MyCustomAdapter extends ArrayAdapter<Country> {
 
  private ArrayList<Country> originalList;
  private ArrayList<Country> countryList;
  private CountryFilter filter;
 
  public MyCustomAdapter(Context context, int textViewResourceId, 
    ArrayList<Country> countryList) {
   super(context, textViewResourceId, countryList);
   this.countryList = new ArrayList<Country>();
   this.countryList.addAll(countryList);
   this.originalList = new ArrayList<Country>();
   this.originalList.addAll(countryList);
  }
 
  @Override
  public Filter getFilter() {
   if (filter == null){
    filter  = new CountryFilter();
   }
   return filter;
  }
 
 
  private class ViewHolder {
   //TextView code;
   TextView name;
   TextView continent;
   TextView region;
  }
 
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
 
   ViewHolder holder = null;
   Log.v("ConvertView", String.valueOf(position));
   if (convertView == null) {
 
   LayoutInflater vi = (LayoutInflater)getSystemService(
     Context.LAYOUT_INFLATER_SERVICE);
   convertView = vi.inflate(R.layout.country_info, null);
 
   holder = new ViewHolder();
   //holder.code = (TextView) convertView.findViewById(R.id.code);
   holder.name = (TextView) convertView.findViewById(R.id.name);
   holder.continent = (TextView) convertView.findViewById(R.id.continent);
   holder.region = (TextView) convertView.findViewById(R.id.region);
 
   convertView.setTag(holder);
 
   } else {
    holder = (ViewHolder) convertView.getTag();
   }
 
   Country country = countryList.get(position);
  // holder.code.setText(country.getCode());
   holder.name.setText(country.getName());
   holder.continent.setText(country.getContinent());
   holder.region.setText(country.getRegion());
 
   return convertView;
 
  }
 
  private class CountryFilter extends Filter
  {
 
   @Override
   protected FilterResults performFiltering(CharSequence constraint) {
 
    constraint = constraint.toString().toLowerCase();
    FilterResults result = new FilterResults();
    if(constraint != null && constraint.toString().length() > 0)
    {
    ArrayList<Country> filteredItems = new ArrayList<Country>();
 
    for(int i = 0, l = originalList.size(); i < l; i++)
    {
     Country country = originalList.get(i);
     if(country.toString().toLowerCase().contains(constraint))
      filteredItems.add(country);
    }
    result.count = filteredItems.size();
    result.values = filteredItems;
    }
    else
    {
     synchronized(this)
     {
      result.values = originalList;
      result.count = originalList.size();
     }
    }
    return result;
   }
 
   @SuppressWarnings("unchecked")
   @Override
   protected void publishResults(CharSequence constraint, 
     FilterResults results) {
 
    countryList = (ArrayList<Country>)results.values;
    notifyDataSetChanged();
    clear();
    for(int i = 0, l = countryList.size(); i < l; i++)
     add(countryList.get(i));
    notifyDataSetInvalidated();
   }
  }
 
 
 }
}
