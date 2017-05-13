package com.example.clinicalguide;


import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Intents;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class AndroidListViewCustomLayoutActivity extends Activity {
	final Context context = this;
 MyCustomAdapter dataAdapter = null;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main1);
 
	
 
  //Generate list View from ArrayList
  displayListView();
 
 }
 
 private void displayListView() {
 
  //Array list of countries
  ArrayList<Country> countryList = new ArrayList<Country>();
  
 Country country = new Country("Fazlul Kader Road","031619597","Chittagong Medical College & Hospital");//22.35967 	91.83318
  countryList.add(country);
  country = new Country("Andarkillah, Ctg","031611407","Chittagong General Hospital");//22.34210 	91.83667
  countryList.add(country);
  country = new Country("Agrabad, Ctg.","031711236","Chittagong Maa-O-Shishu Hospital");// 22.32269 	91.80619 
  countryList.add(country);
  country = new Country("487/B,O.R.Nizam Road,Ctg.","031620634","Chittgong Metropolitan Hospital");// 22.35899 	91.82489
  countryList.add(country);
  country = new Country("427, Ansari  Mansion, Batali Road","031-617495","Chittagong Diabetic general Hospital");//22.3612559//91.80240690000005
  countryList.add(country);
  country = new Country("1062, Love Lane (1st Floor","031619378","Al-Zahar Hospital Ltd.");//24.7243095//46.84658290
  countryList.add(country);
  country = new Country("U.S.T.C Foy’s lake","031-659070","B.B.M.H");// 22.36092 	91.79756
  countryList.add(country);
  country = new Country("100, Momin Road, Chittagong – 4000","031639025","Centre Point Hospital (Pvt)Ltd");//22.3437802//91.8341904
  countryList.add(country);
  country = new Country("33, Panchlaish R/A","031-650911","Chittagong Poly Chinic ");//  22.36219 	91.83427
  countryList.add(country);
  country = new Country("Chittagong Cantt. Ctg.","031681551","Combined Military Hospital");//   22.41313 	91.80746
  countryList.add(country);
  country = new Country("31, K.B. Fazlul Kader Road, Panchlaish R/A","031-651591","Desh Medical Services");//22.35967 	91.83318
  countryList.add(country);
  country = new Country("1733/A P Croad, West Rumpur Sabuj bag","031-715166","Halishahar General Hospital");//22.318119000000000000//91.778226700000000000
  countryList.add(country);
  country = new Country("500/A, Zakir Hosain Road, Khulshi, Ctg.","031620025","Holy Crescent Hospital (Pvt.) Ltd");//22.3612559//91.80240690000005
  countryList.add(country);
  country = new Country("Chittagong 4202","031-615710","Institute Of Community Opthalmology");//22.3603158//91.79630759999998
  countryList.add(country);
  country = new Country("O. R. Nizam Road, Ctg.","031616652","Lions Eye Hospital");//   22.35899 	91.82489
  countryList.add(country);
  country = new Country("Zakir Hossain Road, Nasirabad, Ctg.","622443","Lions General Hospital");//22.3612559//91.80240690000005
  countryList.add(country);

  country = new Country("37, K.B Fazlu Kader Road","031-651558","Ma Moni Hospital");//22.35967 	91.83318
  countryList.add(country);
  country = new Country("Lalkhan Bazar","031-616905","Medicare Services Ltd");//22.347500800000000000//91.819202899999940000
  countryList.add(country);
  country = new Country("1160,Surson Road, Askardegi North","031-623262","Mouni Hospital & Diagnostic Centre");//22.3513782 91.82976009999993
  countryList.add(country);
  country = new Country("30, Mehdibag","031-623713","National Hospital Chittagong");//22.359755200000000000//91.825962099999970000
  countryList.add(country);
  country = new Country("99/A, Chatteswary Road,","031-613874","Panorama Hospital (Pvt) Ltd");//22.3572474//91.83738960000005
  countryList.add(country);
  country = new Country("45, Panchalaish R/A","031-654230","Upasham Hospital");//22.3614492//91.833662
  countryList.add(country);
  country = new Country("53/1, Panchlaish R/A, Chittagong, Chittagong","652038","Surgiscope Pvt. Ltd");//22.3614492//91.833662
  countryList.add(country);
  country = new Country("4, O R Nizam Road Chittagong","652728","Chittagong Health Care Hospital Pvt. Ltd.");//  22.35899 	91.82489
  countryList.add(country);
   country = new Country("75, Panchlaish R/A, Chittagong","031653036","Niramoy Clinic Pvt. Ltd");//22.3614492//91.833662
  countryList.add(country);
  country = new Country("Pachlaish","031-658950","Pachlaish Maa-O-Shishu Hospital");//22.3614492//91.83427
  countryList.add(country);
  country = new Country("G.E.C Circle, O.R Nizam Road","031-658842"," Royal Hospital");//  22.35899 	91.82489
  countryList.add(country);
  country = new Country("Sugandha Road 2","031-657629","Ekhushe Hospital");//22.3661522//91.83348869999998
  countryList.add(country);
  country = new Country("Probortak Circle","031-2550625","C.S.C.R ");//  22.36667 	91.80000
  countryList.add(country);
  
  country = new Country("Panchlaish R/A","031-652635","Sheba Hospital");//22.3614492//91.83427
  countryList.add(country);
  country = new Country("OR Nizam Road (5th Floor)","031-655109","General Hospital");//22.3394381//91.78179139999997
  countryList.add(country);
  country = new Country("Coxsbazar","0341-64066","Cox'sbazar Sadar Hospital");//21.442273900000000000//91.975712499999990000
  countryList.add(country);
  country = new Country("Sadar hospital road","0341-63606","Cox'sbazar Seaside Hospital");//21.442273900000000000//91.975712499999990000
  countryList.add(country);
  country = new Country("Sadar hospital road","0341-64674","Cox'sbazar Fuad Alkhatib Hospital");//21.263064// 91.583324
  countryList.add(country);
  country = new Country("Shatkania","01819636433","Shatkania Thana Health Complex");//22.085108//92.05428239999992
  countryList.add(country);
  country = new Country("Chakaria 4741","342256049","Cakaria Thana Health Complex");//21.7621702//92.07463499999994
  countryList.add(country);
  
 
  //create an ArrayAdaptar from the String Array
  dataAdapter = new MyCustomAdapter(this,
    R.layout.country_info, countryList);
  ListView listView = (ListView) findViewById(R.id.listView1);
  // Assign adapter to ListView
  
  listView.setAdapter(dataAdapter);
 
  //enables filtering for the contents of the given ListView
  listView.setTextFilterEnabled(true);
 
  /*listView.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
    // When clicked, show a toast with the TextView text
	   final Country country = (Country) parent.getItemAtPosition(position);
    //Toast.makeText(getApplicationContext(),
     // country.getName(), Toast.LENGTH_SHORT).show();
	   AlertDialog .Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity.this);
		builder.setTitle("this is item dialog");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setCancelable(false);
		final String[] items={"call","nearest hospital"};
		builder.setItems(items,new DialogInterface.OnClickListener() {
			//int x=Integer.valueOf(Country.getContinent().toString());
			//int i=Integer.parseInt(Country.getContinent().replaceAll("[\\D]",""));
			@Override
			public void onClick(DialogInterface arg0, int pos) {
				// TODO Auto-generated method stub
				
				//Intent callIntent = new Intent(Intent.ACTION_CALL);
				//callIntent.setData(Uri.parse("country.getContinent"));
				//startActivity(callIntent);
				//Toast.makeText(getApplicationContext(),
					    // Country.getRegion(), Toast.LENGTH_SHORT).show();
				//String uri = "tel:"+country.getContinent().toString();

					                   //Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
				
					                    
				
					                   // startActivity(callIntent);
				
				//Toast.makeText(getApplicationContext()," "+pos,Toast.LENGTH_LONG).show();
				if(pos==0)
				{
					
					String uri ="tel:"+country.getContinent().toString();

	                  //  Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));

	                    

	                  //  startActivity(callIntent);
	                    
	                    Intent intent = new Intent(Intent.ACTION_DIAL);
	    				
	    				intent.setData(Uri.parse(uri));
	    				startActivity(intent); 
					
				}
				
				
				
			}
		});
		builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(getApplicationContext(),"dialog is closed",Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				
			}
		});
		AlertDialog itemdialog=builder.create();
		itemdialog.show();
   }
  });
  */
  
  listView.setOnItemClickListener(new OnItemClickListener() {
  public void onItemClick(AdapterView<?> parent, View view,
    int position, long id) {
   // When clicked, show a toast with the TextView text
	   final Country country = (Country) parent.getItemAtPosition(position);
   //Toast.makeText(getApplicationContext(),
    // country.getName(), Toast.LENGTH_SHORT).show();
	   LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity.this);
	   View view1=li.inflate(R.layout.custome_layout,null);
	 
	   final LinearLayout save=(LinearLayout)view1.findViewById(R.id.layout1);
	   LinearLayout call=(LinearLayout)view1.findViewById(R.id.layout2);
	   LinearLayout dir=(LinearLayout)view1.findViewById(R.id.layout3);
	   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout4);
	   LinearLayout dis=(LinearLayout)view1.findViewById(R.id.layout5);
	   
		AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity.this);
		builder.setView(view1);//builder e age image set krtam ekhn view set korlam
		builder.setCancelable(false);
		final AlertDialog customdialog=builder.create();
			//int x=Integer.valueOf(Country.getContinent().toString());
			//int i=Integer.parseInt(Country.getContinent().replaceAll("[\\D]",""));
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
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// Creates a new Intent to insert a contacto
				//String uri ="tel:"+country.getContinent().toString();
				Intent intent = new Intent(Intents.Insert.ACTION);
				// Sets the MIME type to match the Contacts Provider
				intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
				startActivity(intent);
				/*intent.putExtra(Intents.Insert.PHONE,country.getContinent().toString());
				
				intent.putExtra(Intents.Insert.PHONE_TYPE,continent.TYPE_WORk);*/
				
			}
		});
		dir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity.this);
				   View view1=li.inflate(R.layout.custom_layout1,null);
				 
				
				   LinearLayout cont =(LinearLayout)view1.findViewById(R.id.layout1);
				   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout2);
				
				   
					AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity.this);
					builder.setView(view1);//builder e age image set krtam ekhn view set korlam
					builder.setCancelable(false);
					final AlertDialog customdialog=builder.create();
					customdialog.show();
				
				
				
				
				
				
	               cont.setOnClickListener(new OnClickListener() {
		       			
		       			@Override
		       			public void onClick(View arg0) {

		    				
		    				String uri =country.getContinent().toString();
		    				
		    				Intent intent =new Intent(AndroidListViewCustomLayoutActivity.this,MapActivity.class);
		    	              intent.putExtra("item_name",uri);
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
		
dis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				LayoutInflater li=LayoutInflater.from(AndroidListViewCustomLayoutActivity.this);
				   View view1=li.inflate(R.layout.custom_layout1,null);
				 
				
				   LinearLayout cont =(LinearLayout)view1.findViewById(R.id.layout1);
				   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout2);
				
				   
					AlertDialog.Builder builder=new AlertDialog.Builder(AndroidListViewCustomLayoutActivity.this);
					builder.setView(view1);//builder e age image set krtam ekhn view set korlam
					builder.setCancelable(false);
					final AlertDialog customdialog=builder.create();
					customdialog.show();
				
				
				
				
				
				
	               cont.setOnClickListener(new OnClickListener() {
		       			
		       			@Override
		       			public void onClick(View arg0) {
		       				String uri =country.getContinent().toString();
		       				Intent intent =new Intent(AndroidListViewCustomLayoutActivity.this,DistanceActivity.class);
		  	              intent.putExtra("item_name",uri);
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
close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(),"dialog cancelled",Toast.LENGTH_LONG).show();
				customdialog.cancel();
				
				
			}
		});
		customdialog.show();
		//Toast.makeText(getApplicationContext()," "+position,Toast.LENGTH_LONG).show();
	   
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
