| Progress              | Success              |
|-----------------------|----------------------|
| <img src="http://uupload.ir/files/t7f6_screenshot_1579643242.png" width="250"> | <img src="http://uupload.ir/files/2p17_screenshot_1579643339.png" width="250"> |

| Error                 |Custom image / confirm |
|-----------------------|-----------------------|
| <img src="http://uupload.ir/files/d7wy_screenshot_1579643385.png" width="250"> | <img src="http://uupload.ir/files/tldq_screenshot_1579643653.png" width="250"> |

# Media Picker
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)

## Installation
------
Add it in your project's build.gradle at the end of repositories:

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

**Maven**
```xml
<dependency>
	<groupId>com.github.Alireza-Saeedi</groupId>
	<artifactId>MegaDialog</artifactId>
	<version>1.0.0</version>
</dependency>
```


**Gradle**
```gradle
dependencies {
	implementation 'com.github.Alireza-Saeedi:MegaDialog:1.0.0'
}
```

# Usage
------
```java
        Megadialog megadialog;
        
        megadialog = new Megadialog(this)
                .setAlertType(Megadialog.CUSTOM_IMAGE_TYPE, true)
                .setCancelableDialog(true)
                .setCanceledOnTouchOutsideDialog(true)
                .setText(null, "do you want to exit?")
                .setTextGravity(Gravity.LEFT, Gravity.CENTER)
                .setImage(R.drawable.question_mark)
                .setDecriptionTextSize(15)
                .setCancelButton("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setConfirmButton("Exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .ShowDialog();
        
```

# Types
------
```
Megadialog.CUSTOM_IMAGE_TYPE
Megadialog.ERROR_TYPE
Megadialog.SUCCESS_TYPE
Megadialog.ERROR_TYPE
Megadialog.PROGRESS_TYPE
```
