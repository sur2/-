# Android-Brainwashing-Class
[인프런] 겜팔이님의 '안드로이드 세뇌교실 - 인★그램 개발부터 배포까지' 강좌



## Activity

### Activity : Foreground로 Service에 반대되는 성향, 보여주는 녀석, 화면을 관장함, 안드로이드 앱의 기본적인 녀석

그 외...

- ContentProvier : 자료 제공자, 각 종 데이터(주소록, Database, image 등)를 가져옴
- Service : Background로 Activity에 반대되는 성향, 눈에 보이지 않게 일하는 녀석
- BroadcastReceiver : 알림을 도와줌(ex. Kakao Talk 알림), Java interface의 callback과 비슷함

액티비티는 UI를 보여줌, Event와 같은 행동, callback으로 감지 등 거의 모든 것을 함

액티비티의 생명주기 : ![](https://developer.android.com/guide/components/images/activity_lifecycle.png)

## Intent

### Intent는 우편배달부(액티비티 - 액티비티 // 앱 - 앱)

명시적 Intent - 받는이와 보내는 이가 명시되어 있다.

```
Intent intent = new Intent(this, NewActivity.class);
startActivity(intent);
```

암시적 Intent - 해당된다 싶으면 다 부른다.(주로 외부 앱과 연결...'우편배달~')

```
Intent sendIntent = new Intent();
// ACTION_CALL : 통화앱
sendIntent.setAction(Intent.ACTION_CALL);
startActivity(sendIntent);
```
