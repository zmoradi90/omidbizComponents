#omidbizComponents

Provides components enhancements to the RichFaces Tag library for using in JBoss Seam. Features include:

+ inputListOfValues based on colorbox 
+ persianDatePicker
+ persianDateLabelConvertor
+ and more...


##Building

   mvn clean install
   
##Tips

+ Assembling this project requires maven 2.2.1 for javascript obfuscation
+ If you are using compressed version, you need to disable load on demand in web.xml
```
 Change load strategy to DEFAULT to disable sending scripts/styles as packs 

	<context-param>
		<param-name>org.richfaces.LoadStyleStrategy</param-name>
		<param-value>ALL</param-value>
	</context-param>

	<context-param>
		<param-name>org.richfaces.LoadScriptStrategy</param-name>
		<param-value>ALL</param-value>
	</context-param>
```

+ Do not forget to add compressed js and css

```
<a:loadStyle src="resource://org/omidbiz/ui.styles.css" />
<a:loadScript src="resource://org/omidbiz/ui.scripts.js"></a:loadScript>
```
