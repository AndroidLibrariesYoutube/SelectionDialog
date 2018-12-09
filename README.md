# Welcome to SelectionDialog!

Hello World. 
Enable Selections features. Now easy with SelectionDialog android library. You can now enable Single selection and Multiple selection features in your app easily.


# Implementation
**Step: 1**
  Add the JitPack repository to your build file.

 

    allprojects {
    		repositories {
    			maven { url 'https://jitpack.io' }
    		}
    	}
 **Step: 2**
  Add the SelectionDialog dependency to your build.gradle file.

```css
dependencies {
	        implementation 'com.github.AndroidLibrariesYoutube:SelectionDialog:0.1.9'
	}
```



## How do I use Single Selection Dialog?

![Screenshot 1](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot1.png)
![Screenshot 2](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot2.png)
![Screenshot 3](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot3.png)

Using SelectionDialog is pretty simple.

**Step 1**
Create class of SingleSelectionDialog for using the Single Selection.

  

      // First parameter you need to pass is this means you need to implement a SingleSelectionListener in your activity then activity context and last is TAG.
            
            
	  SingleSelectionDialog singleSelectionDialog = new SingleSelectionDialog(this, context, "TAG");
            
      //Then you need to the ArrayList which you want to show. ArrayList must be of String type.
      singleSelectionDialog.setContent(stringArrayList);  
        
**Step 2**
Add extra features to your dialog.
    

    singleSelectionDialog.setColor(getResources().getColor(R.color.colorPrimaryDark));  
    singleSelectionDialog.setTitle("Select Number");  
    singleSelectionDialog.setSelectedField(currentField);



**Step 3**
Call show(); method for showing the dialog.    

    singleSelectionDialog.show();
**Step 4**
Inherit SingleSelectionListener listener in your activity like this.

    public class MainActivity extends AppCompatActivity implements SingleSelectionListener
**Step 5**
Get value, positions, TAG and error from dialog.

   

    @Override  
    public void onDialogItemSelected(String s, int position, String tag) {  
      
    }  
      
    @Override  
    public void onDialogError(String error, String tag) {  
      
    }


## How do I use Multi Selection Dialog?

![Screenshot 4](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot4.png)
![Screenshot 5](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot5.png)

Using MultiSelection is also not that though.

**Step 1**
Create class of SingleSelectionDialog for using the Single Selection.

  

      // First parameter you need to pass is this means you need to implement a MultiSelectionListenerin your activity then activity context and last is TAG.
            
            
	MultiSelectionDialog multiSelectionDialog = new MultiSelectionDialog(this, context, "TAG");  
            
      //Then you need to the ArrayList which you want to show. ArrayList must be of String type.
    multiSelectionDialog.setContent(stringArrayList);

        
**Step 2**
Add extra features to your dialog.
    

    multiSelectionDialog.setColor(getResources().getColor(R.color.colorPrimaryDark));  
    multiSelectionDialog.setTitle("Select Number");  
    multiSelectionDialog.setSelectedFields(currentField);

**Step 3**
Call show(); method for showing the dialog.    

      multiSelectionDialog.show();

**Step 4**
Inherit MultiSelectionListener listener in your activity like this.

    public class MainActivity extends AppCompatActivity implements MultiSelectionListener
**Step 5**
Get values, selected item list,  TAG and error from dialog.

   

      
    @Override  
    public void onMultiDialogItemsSelected(String s, String tag, ArrayList<String> selectedItemList) {  
      
    }  
      
    @Override  
    public void onMultiDialogError(String error, String tag) {  
      
    }


[## Author
Dheeraj Rijhwani (Android Developer)](https://www.youtube.com/channel/UCEhHMXJs1V4mXGfJ4pSWaoA)





