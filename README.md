[![](https://jitpack.io/v/behnamnasehi/HomingPigeon.svg)](https://jitpack.io/#behnamnasehi/HomingPigeon)
# HomingPigeon
Online Chat Support Service

## Installation
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```bash
dependencies {
	         implementation 'com.github.behnamnasehi:HomingPigeon:64d4ccadf7'
	}
```

## Api Key
Go to www.behnamnasehi.com/homingpigeon/apikey to get the api key and register for new project.

## Code 
create new HomingPigeon Class in your activity :
```java
final HomingPigeon homingPigeon = new HomingPigeon(this, "02627a55-4cd2-4ac4-b5c1-07bc97142cf6", new SocketResponseInterface() {
            @Override
            public void onConnect() {
               // when connection is successfull
            }

            @Override
            public void onReady() {
               //ready to use the service
            }

            @Override
            public void onDisconnect() {
              //when socket is disconnected
            }

            @Override
            public void OnConnectError(final String msg) {
              //all the error show here
            }

            @Override
            public void OnMessageDetection(final Message messageObj) {
              // when new message is come 
            }
        });
```
## Send Message
send message by this function:
```java
    homingPigeon.sendMessage("My Dummy Message");
```

## get all Message
```java
homingPigeon.getMessageList(room_id, pagingateNumber , limit, new Response() {
            @Override
            public void onDataReceived(List<Message> list) {
                  //Received All Message from current room
            }
        });
 ```
 
 
## Contact Me 
Telegram : [Click Here For Opening My Telegram Profile](https://t.me/behnamnasehii)

Medium: [Click Here For Opening My Medium Profile](https://medium.com/@behnammnasehi)

