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
 
public class AndroidListViewCustomLayoutActivity3 extends Activity {
	final Context context = this;
 MyCustomAdapter dataAdapter = null;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.ambulance);
 
	
 
  //Generate list View from ArrayList
  displayListView();
 
 }
 
 private void displayListView() {
 
  //Array list of countries
  ArrayList<Country> countryList = new ArrayList<Country>();
  
 Country country = new Country("","01819-371919","Alfa Ambulance");
  countryList.add(country);
  country = new Country("","01819-380000","Alif Ambulance");
  countryList.add(country);
  country = new Country("","01819-396161","Dolphin Ambulance");
  countryList.add(country);
  country = new Country("","031-620025","Holy Crescent Hospital");
  countryList.add(country);
  country = new Country("","031-502024","Port Hospital");
  countryList.add(country);
  country = new Country("","031-602220","Railway Hospital");
  countryList.add(country);
  country = new Country("","031637243","Urasham Hospital ");
  countryList.add(country);
  country = new Country("","031-716326","Fire Service Ambualnce");
  countryList.add(country);
  country = new Country("","031-656666","Media Medical Service");
  countryList.add(country);
  
 
  
 
  //create an ArrayAdaptar from the String Array
  dataAdapter = new MyCustomAdapter(this,
    R.layout.country1, countryList);
  ListView listView = (ListView) findViewById(R.id.listView1);
  // Assign adapter to ListView
  
  listView.setAdapter(dataAdapter);
 
  //enables filtering for the contents of the given ListView
  listView.setTextFilterEnabled(true);
 
  listView.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
final Country country = (Country) parent.getItemAtPosition(position);
	  
	   
	   LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity3.this);
	   View view1=li.inflate(R.layout.custom_layout2,null);
	 
	   final LinearLayout save=(LinearLayout)view1.findViewById(R.id.layout1);
	   LinearLayout call=(LinearLayout)view1.findViewById(R.id.layout1);
	   
	   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout4);
	 
	   
		AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity3.this);
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
   convertView = vi.inflate(R.layout.country1, null);
 
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

