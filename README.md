# Welcome to SelectionDialog!

![Release](https://jitpack.io/v/AndroidLibrariesYoutube/SelectionDialog.svg)

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
	        implementation 'com.github.AndroidLibrariesYoutube:SelectionDialog:1.0.2'
	}
```



## How do I use Single Selection Dialog?

![Screenshot 1](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot1.png)
![Screenshot 2](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot2.png)
![Screenshot 3](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot3.png)

Using SelectionDialog is pretty simple.

**Step 1**
Create object of SingleSelectionDialog with Builder for using the Single Selection.

  

	//First parameter need to pass is current context and then TAG. TAG is for determine if you are using dialog multiple times.            
	 SingleSelectionDialog singleSelectionDialog = new SingleSelectionDialog.Builder(context, "TEST")
                .setTitle("Select Number")
                .setContent(stringArrayList) // Set ArrayList you want to show.
                .setColor(getResources().getColor(R.color.colorPrimaryDark))	 
                .setSelectedField(currentField)					
                .enableSearch(true, "Search your number")			
                .setTextColor(getResources().getColor(R.color.colorAccent))	
                .setListener(new SingleSelectionListener() {
                    @Override
                    public void onDialogItemSelected(String s, int position, String tag) {
                       
                    }

                    @Override
                    public void onDialogError(String error, String tag) {
                    }
                })								
                .build();
            
      
       
**Step 2**
Call show(); method for showing the dialog.    

    singleSelectionDialog.show();
    
**Step 3**
 Set Default value or Current value to Dialog.

    singleSelectionDialog.setSelectedField(value); //Default value must be of String type.


## How do I use Multi Selection Dialog?

![Screenshot 4](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot4.png)
![Screenshot 5](https://github.com/AndroidLibrariesYoutube/SelectionDialog/blob/master/screenshot5.png)

Using MultiSelection is also not that tough.

**Step 1**
Create object of MultiSelectionDialog with Builder for using the Multiple Selection.

  

      	//First parameter need to pass is current context and then TAG. TAG is for determine if you are using dialog multiple times.            
	   MultiSelectionDialog multiSelectionDialog = new MultiSelectionDialog.Builder(context, "TEST")
                .setTitle("Select Number")
                .setContent(stringArrayList)
                .setColor(getResources().getColor(R.color.colorPrimaryDark))
                .setSelectedField(currentField)
                .setTextColor(getResources().getColor(R.color.colorAccent))
                .setListener(new MultiSelectionListener() {
                    @Override
                    public void onMultiDialogItemsSelected(String s, String tag, ArrayList<String> selectedItemList) {
                    }

                    @Override
                    public void onMultiDialogError(String error, String tag) {
                    }
                })
                .build();


**Step 2**
Call show(); method for showing the dialog.    

      multiSelectionDialog.show();

 **Step 3**
 Set Default values or Current values to Dialog.

    multiSelectionDialog.setSelectedFields(value); //Default values must be of String type.

## Author
[Dheeraj Rijhwani (Android Developer)](https://www.youtube.com/channel/UCEhHMXJs1V4mXGfJ4pSWaoA)

## Licence

```
Copyright 2018 Dheeraj Rijhwani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


