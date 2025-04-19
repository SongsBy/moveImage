## ImageMove or 애니메이션
---
### 애니메이션
1. 이미지 10초간격 1초마다 10f 만큼 이동 
2. 이미지가 FrameLayout에 끝에 도달하면 원래 위치 x = 0f y = 0f
3. 시작버튼 click시 : 정지 버튼 on , 리셋버튼 on
4. 정지버튼 click시 : 시작버튼 텍스트 "재시작"변경 , 리셋버튼 on , 동작 멈춤
5. 리셋버튼 click시 : 초기상태 돌아감.
---
### imageMover
1. 4가지 버튼 (상,하,좌,우) 클릭시 그 에 맞는 위치 명령 버튼 움직임
2. framelayout 사용한 width,height 크기 사용
3. 가로화면 생성.
