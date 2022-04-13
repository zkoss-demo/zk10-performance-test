# ZK 10 Performance Test
Testing project for ZK 10 Client MVVM

## Prerequisites
* JDK Version: 1.8
* Apache JMeter 5.4.3
* Visual VM 2.1.2

## How To Test
### Run with ZK 9.6.1 or ZK 10.0.0 FL
#### ZK 9.6.1
* Change the dependency in build.gradle
```
implementation "org.zkoss.zk:zkmax:9.6.1-Eval"
```
#### ZK 10.0.0 FL
* Change the dependency in build.gradle
```
implementation "org.zkoss.zk:zkmax:10.0.0.FL.20220412-Eval"
implementation "org.zkoss.zephyr:zephyr-ex:10.0.0.FL.20220413-Eval"
```
* Add ZK 10 Client MVVM settings in zk.xml
```
<listener>
	<listener-class>org.zkoss.zephyrex.bind.BinderPropertiesRenderer</listener-class>
</listener>
<library-property>
	<name>org.zkoss.bind.defaultComposer.class</name>
	<value>org.zkoss.zephyrex.bind.ClientBindComposer</value>
</library-property>
```
### Run Testing Tools
Run Apache JMeter, and open "zk10-performance-test.jmx".

Run Visual VM.

### Test Steps
* Run Web Application - run with `./gradlew appRun`
* (Apache JMeter) Change the number of Threads (users) to 100
* (Apache JMeter) Click "Start" several times to warm up
* (Visual VM) Open the "org.akhikhl.gretty.Runner" to Monitor, then do "Perform GC"
* (Apache JMeter) Change the number of Threads (users) to 100/200/400/800 and "Start"
* (Visual VM) See Memory used in Monitor
* (Apache JMeter) See result in "Aggregate Report" (label:/zk10-performance-test/test/listbox.zul, 99% Line)

## Result
https://www.zkoss.org/wiki/Small_Talks/2022/April/ZK10_Preview:_3000%25_Lighter_And_30000%25_Faster_in_MVVM