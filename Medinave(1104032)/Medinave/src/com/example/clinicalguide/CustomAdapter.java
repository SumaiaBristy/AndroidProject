package com.example.clinicalguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class CustomAdapter extends BaseAdapter{   
    String [] result;
    Context context;
   // private Activity activity;
 int [] imageId;
      private static LayoutInflater inflater=null;
    public CustomAdapter(CallActivity callActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=callActivity;
        imageId=prgmImages;
         inflater = ( LayoutInflater )context.
                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;       
             rowView = inflater.inflate(R.layout.program_list, null);
             holder.tv=(TextView) rowView.findViewById(R.id.textView1);
             holder.img=(ImageView) rowView.findViewById(R.id.imageView1);       
         holder.tv.setText(result[position]);
         holder.img.setImageResource(imageId[position]);         
        rowView.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            	if(result[position]=="Grameenphone")
            	{
            		
            		Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:1800 022 222"));
                    rowView.getContext().startActivity(intent);
                   // Activity activity = null;
					//Context activity = null;
					//activity.startActivity(intent);
            		
            	}
            	else if(result[position]=="Airtel")
            	{
            		
            		Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:54445"));
                    rowView.getContext().startActivity(intent);
                   // Activity activity = null;
					//Context activity = null;
					//activity.startActivity(intent);
            		
            	}
            	else if(result[position]=="Banglalink")
            	{
            		
            		Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:789"));
                    rowView.getContext().startActivity(intent);
                   // Activity activity = null;
					//Context activity = null;
					//activity.startActivity(intent);
            		
            	}
            	else if(result[position]=="Teletalk")
            	{
            		
            		Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9882585-200-267"));
                    rowView.getContext().startActivity(intent);
                   // Activity activity = null;
					//Context activity = null;
					//activity.startActivity(intent);
            		
            	}
            	else if(result[position]=="Robi")
            	{
            		
            		  // final Country country = (Country) parent.getItemAtPosition(position);
            		   //Toast.makeText(getApplicationContext(),
            		    // country.getName(), Toast.LENGTH_SHORT).show();
            			   LayoutInflater li=LayoutInflater.from(rowView.getContext());
            			   View view1=li.inflate(R.layout.robi,null);
            			 
            			   final LinearLayout save=(LinearLayout)view1.findViewById(R.id.layout1);
            			   LinearLayout call=(LinearLayout)view1.findViewById(R.id.layout2);
            			   LinearLayout dir=(LinearLayout)view1.findViewById(R.id.layout3);
            			   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout4);
            			   LinearLayout dis=(LinearLayout)view1.findViewById(R.id.layout5);
            			   
            				AlertDialog.Builder builder=new AlertDialog.Builder(rowView.getContext());
            				builder.setView(view1);//builder e age image set krtam ekhn view set korlam
            				builder.setCancelable(false);
            				final AlertDialog customdialog=builder.create();
            				customdialog.show();
            				close.setOnClickListener(new OnClickListener() {
            	       			
            	       			@Override
            	       			public void onClick(View arg0) {
            	       				// TODO Auto-generated method stub
            	       				//Toast.makeText(getApplicationContext(),"dialog cancelled",Toast.LENGTH_LONG).show();
            	       				customdialog.cancel();
            	       				
            	       				
            	       			}
            	       		});
            				save.setOnClickListener(new OnClickListener() {
            					
            					@Override
            					public void onClick(View arg0) {
            						
            		                  Intent intent = new Intent(Intent.ACTION_DIAL);
            		  				
            		                  intent.setData(Uri.parse("tel:10606"));
            		                  rowView.getContext().startActivity(intent);
            						
            						
            					}
            				});
call.setOnClickListener(new OnClickListener() {
            					
            					@Override
            					public void onClick(View arg0) {
            						
            		                  Intent intent = new Intent(Intent.ACTION_DIAL);
            		  				
            		                  intent.setData(Uri.parse("tel:10666"));
            		                  rowView.getContext().startActivity(intent);
            						
            						
            					}
            				});
            		
dir.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
          Intent intent = new Intent(Intent.ACTION_DIAL);
			
          intent.setData(Uri.parse("tel:10678"));
          rowView.getContext().startActivity(intent);
		
		
	}
});

dis.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
          Intent intent = new Intent(Intent.ACTION_DIAL);
			
          intent.setData(Uri.parse("tel:10610"));
          rowView.getContext().startActivity(intent);
		
		
	}
});

            		
            	}
            }
        });   
         
        return rowView;
    }

}