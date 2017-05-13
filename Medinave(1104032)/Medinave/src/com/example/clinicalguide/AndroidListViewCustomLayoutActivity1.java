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
 
public class AndroidListViewCustomLayoutActivity1 extends Activity {
	final Context context = this;
 MyCustomAdapter dataAdapter = null;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.blood);
 
	
 
  //Generate list View from ArrayList
  displayListView();
 
 }
 
 private void displayListView() {
 
  //Array list of countries
  ArrayList<Country> countryList = new ArrayList<Country>();
  
 Country country = new Country("Kotowali/Ctg. Sadar, Chittagong","031616625","Sandhani");
  countryList.add(country);
  country = new Country("Kotowali/Ctg. Sadar, Chittagong","031619199","Chittagong Medical College");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar,Chittagong","031752302","Ferozshah Blood Donor'sClub");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar, Chittagong","031616652","Lions Hospital");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar, Chittagong","031-502024","Port Hospital");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar, Chittagong","031-602220","Railway Hospital");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar, Chittagong","031659057","Red Drop; Blood Donor's Clob");
  countryList.add(country);
  country = new Country("Kotowali/Ctg.Sadar, Chittagong","031-659070","U.S.T.C");
  countryList.add(country);
  country = new Country("Anderkilla,Chittagong","031-620685","Fatema Begum RedCrescent Blood centre");
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
	   final Country country = (Country) parent.getItemAtPosition(position);
	  
	   
	   LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity1.this);
	   View view1=li.inflate(R.layout.custom_layout2,null);
	 
	   final LinearLayout save=(LinearLayout)view1.findViewById(R.id.layout1);
	   LinearLayout call=(LinearLayout)view1.findViewById(R.id.layout1);
	   
	   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout4);
	 
	   
		AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity1.this);
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
